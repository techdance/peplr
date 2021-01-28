package com.collaborated.matching.portlet;

import com.collaborated.entity.model.profileAreaofinterest;
import com.collaborated.entity.model.projectInviteTracking;
import com.collaborated.entity.model.userCredential;
import com.collaborated.entity.model.userProfileImage;
import com.collaborated.entity.service.profileAreaofinterestLocalServiceUtil;
import com.collaborated.entity.service.projectInviteTrackingLocalServiceUtil;
import com.collaborated.entity.service.userCredentialLocalServiceUtil;
import com.collaborated.entity.service.userProfessionalBioLocalServiceUtil;
import com.collaborated.entity.service.userProfileImageLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Image;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.AddressLocalServiceUtil;
import com.liferay.portal.kernel.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.service.ImageLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=MatchingScreen Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"com.liferay.portlet.private-session-attributes=false",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MatchingScreenPortlet extends MVCPortlet {
	
	JSONObject institutionProfile = null;
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceID = null;
		resourceID = resourceRequest.getResourceID();
		System.out.println("resourceID" + resourceID);
		if (resourceID != null && resourceID.equals("getAllDetails")) {
			getAllDetails(resourceRequest,resourceResponse);
		}else if (resourceID != null && resourceID.equals("loadRecommenedPartners")) {
			loadRecommenedPartners(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("loadProfileDetails")) {
			loadProfileDetails(resourceRequest,resourceResponse);
		}else if(resourceID != null && resourceID.equals("sendInvite")) {
			sendInvite(resourceRequest,resourceResponse);
		}
	}
	public void getAllDetails(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		JSONObject jsonObject = null;
		JSONArray jsonArray = null;
		JSONArray jsonArrayFinal = null;
		JSONObject jsonObjectFinal = null;
		PrintWriter out = null;
		List<profileAreaofinterest> listData = null;
		profileAreaofinterest singleData = null;
		long key = ParamUtil.getLong(resourceRequest, "key");
		String educationLevel = "";String instituteNameCurrentUser = "";
		PortletSession ps = resourceRequest.getPortletSession();
		try{
			out = resourceResponse.getWriter();
			System.out.println("inside getall");
			singleData = profileAreaofinterestLocalServiceUtil.getprofileAreaofinterest(key);
			System.out.println("key==="+key);
			System.out.println("singleData==="+singleData);
			instituteNameCurrentUser = (String) themeDisplay.getUser().getExpandoBridge().getAttribute("instituteName");
			System.out.println("instituteNameCurrentUser==="+instituteNameCurrentUser);
			if(singleData!=null){
				String query = "SELECT * FROM `collaborated_profileAreaofinterest` WHERE (projectType='"+singleData.getProjectType()+"' OR location1='"+singleData.getLocation1()+"' OR "
						+ "discipline1='"+singleData.getDiscipline1()+"' OR language='"+singleData.getLanguage()+"' OR collaborationType='"+singleData.getCollaborationType()+"') AND userId!="+themeDisplay.getUserId();
				/*String query = "SELECT DISTINCT(userId) FROM `collaborated_profileareaofinterest` WHERE (projectType='"+singleData.getProjectType()+"' OR "
						+ "discipline='"+singleData.getDiscipline()+"')";*/
				
				if(singleData.getCollaborationType().equalsIgnoreCase("Departmental") || singleData.getCollaborationType().equalsIgnoreCase("Institutional")){
					query = query + " AND universityName='"+instituteNameCurrentUser+"'";
				}
				
				System.out.println("query==="+query);
				jsonArray = GetData(query);
				jsonArrayFinal = JSONFactoryUtil.createJSONArray();
				for(int l=0;l<jsonArray.length();l++){
					 JSONObject jsonobj=jsonArray.getJSONObject(l);
					 User user = UserLocalServiceUtil.getUser(Long.valueOf(jsonobj.getString("userId")));
					 DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(projectInviteTracking.class, PortalClassLoaderUtil.getClassLoader());
					 //dynamicQuery.add(PropertyFactoryUtil.forName("projectId").eq(jsonobj.getLong("PK_areaofinterest")));
					 dynamicQuery.add(RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("inviteTo",user.getUserId()),RestrictionsFactoryUtil.eq("projectId", key)));
					 List<projectInviteTracking> projectInviteTracking = projectInviteTrackingLocalServiceUtil.dynamicQuery(dynamicQuery);
					 boolean isAlreadySent = false;
					 if(projectInviteTracking.size()>0){
						 isAlreadySent = true;
					 }
					 
					 DynamicQuery dynamicQueryCredential = DynamicQueryFactoryUtil.forClass(userCredential.class, PortalClassLoaderUtil.getClassLoader());
					 dynamicQueryCredential.add(PropertyFactoryUtil.forName("userId").eq(user.getUserId()));
					 List<userCredential> creList = userCredentialLocalServiceUtil.dynamicQuery(dynamicQueryCredential);
					 if(creList.size()>0){
						 educationLevel = "";
						 educationLevel = creList.get(0).getMembership4();
					 }
					 System.out.println("query==="+query);
					 System.out.println("educationLevel==="+educationLevel);
					 /*String department="", cityState="",instituteName="",country="";
					 institutionProfile = (JSONObject)ps.getAttribute("INSTITUTE_PROFILE",PortletSession.APPLICATION_SCOPE);					 
					 if(institutionProfile!=null){
							instituteName = institutionProfile.getString("institutionName");
							JSONObject institutionContact = institutionProfile.getJSONObject("institutionContact");							
							if(institutionContact!=null){
								department = institutionContact.getString("department");
							}
							JSONObject instituteProfileContact = institutionProfile.getJSONObject("institutionLocation");
							if(instituteProfileContact!=null){
								//department = instituteProfileContact.getString("department");
								cityState = instituteProfileContact.getString("city")+", "+instituteProfileContact.getString("state");		
								country = instituteProfileContact.getString("country");
							}
					}*/
					
					 // Multiple university institution details based on user
					 
					 String instituteName = (String) user.getExpandoBridge().getAttribute("instituteName");
					 String instituteDepartment = (String) user.getExpandoBridge().getAttribute("instituteDepartment");
					 String instituteCity = (String) user.getExpandoBridge().getAttribute("instituteCity");
					 String instituteState = (String) user.getExpandoBridge().getAttribute("instituteState");
					 String instituteCountry = (String) user.getExpandoBridge().getAttribute("instituteCountry");
					 
					 jsonObjectFinal = JSONFactoryUtil.createJSONObject();
					 //String instituteName = (String) themeDisplay.getUser().getExpandoBridge().getAttribute("instituteName");
					 /*ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(user.getCompanyId(),User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME);
					 ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(user.getCompanyId(),User.class.getName(), table.getName(), "instituteName" );
					 String instituteName =  ExpandoValueLocalServiceUtil.getData(user.getCompanyId(),User.class.getName(), table.getName(), column.getName(), user.getUserId(), StringPool.BLANK);*/
					 //long portraitId = user.getPortraitId();				 
						 
					 String imageURL = "",imgSRC="";boolean isBase64 = false;
					 DynamicQuery dynamicQueryProfileImage = DynamicQueryFactoryUtil.forClass(userProfileImage.class,PortalClassLoaderUtil.getClassLoader());
					 dynamicQueryProfileImage.add(PropertyFactoryUtil.forName("userId").eq(user.getUserId()));
					 List<userProfileImage> values = userProfileImageLocalServiceUtil.dynamicQuery(dynamicQueryProfileImage);
					 if(values.size()>0){
						imageURL = values.get(0).getFileEntryUrl();					
					    JSONObject jsonObject2 = CommonMethods.getProfileImageBlob(user.getUserId());	               
					    imageURL = jsonObject2.getString("byteArray");
					    imgSRC = "data:image/png;base64,"+imageURL;
					    isBase64 = true;
					 }else{
						 imageURL = "/o/ahea-theme/images/user.png";
						imgSRC = imageURL;
						isBase64 = false;
					 }
					 
					 jsonObjectFinal.put("userId", user.getUserId());
					 jsonObjectFinal.put("educationLevel",educationLevel);
					 jsonObjectFinal.put("userName", user.getFullName());
					 jsonObjectFinal.put("position", user.getJobTitle());
					 jsonObjectFinal.put("department", instituteDepartment);
					 jsonObjectFinal.put("institutionName", instituteName);
					 jsonObjectFinal.put("institutionLocation", instituteCity+", "+instituteState);
					 jsonObjectFinal.put("country", instituteCountry);
					 jsonObjectFinal.put("PK_areaofinterest", jsonobj.getLong("PK_areaofinterest"));
					 jsonObjectFinal.put("isAlreadySent", isAlreadySent);
					 jsonObjectFinal.put("imageURL", imgSRC);
					// jsonObjectFinal.put("imageURL", image);
					 jsonArrayFinal.put(jsonObjectFinal);
				 }
			}
			out.print(jsonArrayFinal);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (out != null) {
				out.close();
			}
		}
	}
	
	public void loadRecommenedPartners(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		JSONArray jsonArray = null;
		JSONArray jsonArrayFinal = null;
		JSONObject jsonObjectFinal = null;
		PrintWriter out = null;
		List<profileAreaofinterest> listData = null;
		String educationLevel = "";
		
		try{
			out = resourceResponse.getWriter();
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(profileAreaofinterest.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplay.getUserId())));
			listData = profileAreaofinterestLocalServiceUtil.dynamicQuery(dynamicQuery);
			if(listData.size()>0){
				/*String query = "SELECT DISTINCT(userId),PK_areaofinterest FROM `collaborated_profileAreaofinterest` where userId!="+themeDisplay.getUserId();*/
				String query = "SELECT DISTINCT(userId) FROM `collaborated_profileAreaofinterest` where userId!="+themeDisplay.getUserId()+" LIMIT 3"; 
				/*String query = "SELECT DISTINCT(userId) FROM `collaborated_profileareaofinterest` WHERE (projectType='"+singleData.getProjectType()+"' OR "
						+ "discipline='"+singleData.getDiscipline()+"')";*/
				jsonArray = GetData(query);
				jsonArrayFinal = JSONFactoryUtil.createJSONArray();
				for(int l=0;l<jsonArray.length();l++){
					 JSONObject jsonobj=jsonArray.getJSONObject(l);
					 System.out.println("jsonobj====="+jsonobj);
					 User user = UserLocalServiceUtil.getUser(Long.valueOf(jsonobj.getString("userId")));
					 
					 DynamicQuery dynamicQueryTracking = DynamicQueryFactoryUtil.forClass(projectInviteTracking.class, PortalClassLoaderUtil.getClassLoader());
					 dynamicQueryTracking.add(PropertyFactoryUtil.forName("projectId").eq(jsonobj.getLong("PK_areaofinterest")));
					 List<projectInviteTracking> projectInviteTracking = projectInviteTrackingLocalServiceUtil.dynamicQuery(dynamicQuery);
					 boolean isAlreadySent = false;
					 if(projectInviteTracking.size()>0){
						 isAlreadySent = true;
					 }
					 
					 DynamicQuery dynamicQueryCredential = DynamicQueryFactoryUtil.forClass(userCredential.class, PortalClassLoaderUtil.getClassLoader());
					 dynamicQueryCredential.add(PropertyFactoryUtil.forName("userId").eq(user.getUserId()));
					 List<userCredential> creList = userCredentialLocalServiceUtil.dynamicQuery(dynamicQueryCredential);
					 if(creList.size()>0){
						 educationLevel = "";
						 educationLevel = creList.get(0).getMembership4();
					 }
					 
					 jsonObjectFinal = JSONFactoryUtil.createJSONObject();
					 //String instituteName = (String) themeDisplay.getUser().getExpandoBridge().getAttribute("instituteName");
					 
					 ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(user.getCompanyId(),User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME);
					 ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(user.getCompanyId(),User.class.getName(), table.getName(), "instituteName" );
					 String instituteName =  ExpandoValueLocalServiceUtil.getData(user.getCompanyId(),User.class.getName(), table.getName(), column.getName(), user.getUserId(), StringPool.BLANK);
					 
					 long portraitId = user.getPortraitId();
				     
					 jsonObjectFinal.put("userId", user.getUserId());
					 jsonObjectFinal.put("educationLevel",educationLevel);
					 jsonObjectFinal.put("userName", user.getFullName());
					 jsonObjectFinal.put("department", user.getJobTitle());
					 jsonObjectFinal.put("institutionName", instituteName);
					 jsonObjectFinal.put("institutionLocation", "");
					 jsonObjectFinal.put("PK_areaofinterest", jsonobj.getLong("PK_areaofinterest"));
					 jsonObjectFinal.put("isAlreadySent", isAlreadySent);
					 jsonObjectFinal.put("imageURL", themeDisplay.getPathImage()+"/user_portrait?img_id="+portraitId);
					 jsonArrayFinal.put(jsonObjectFinal);
				 }
				 out.print(jsonArrayFinal);
			}else{
				out.print("showmessage");
			}			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (out != null) {
				out.close();
			}
		}
	}
	
	public void loadProfileDetails(ResourceRequest request, ResourceResponse response){
		String key = ParamUtil.getString(request, "key");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try{
			/*PortletSession ps = request.getPortletSession();
			ps.setAttribute("MATCHING_KEY", key, PortletSession.APPLICATION_SCOPE);*/
			
			HttpServletRequest httprequest = PortalUtil.getHttpServletRequest(request);
			httprequest = PortalUtil.getOriginalServletRequest(httprequest);

			HttpSession session = httprequest.getSession();
			session.removeAttribute("MATCHING_KEY");			
			session.setAttribute("MATCHING_KEY", key);
			session.setAttribute("currentUser", themeDisplay.getUserId());
			
		}catch(Exception e){}
		finally{
			
		}
	}
	
	public void sendInvite(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long interestId = ParamUtil.getLong(resourceRequest, "interestId");
		long inviteTo = ParamUtil.getLong(resourceRequest, "inviteTo");
		profileAreaofinterest profileAreaofinterest = null;
		long inviteFrom = themeDisplay.getUserId();
		String inviteToName = "";String projectName = "";
		projectInviteTracking projectInviteTracking = null;
		PrintWriter out = null;
		try{
			out = resourceResponse.getWriter();
			if(interestId!=0){
				profileAreaofinterest = profileAreaofinterestLocalServiceUtil.getprofileAreaofinterest(interestId);
				if(profileAreaofinterest!=null){
					inviteToName = UserLocalServiceUtil.getUser(themeDisplay.getUserId()).getFullName();
				}
			}
			if(inviteTo!=0){
				projectInviteTracking = projectInviteTrackingLocalServiceUtil.createprojectInviteTracking(CounterLocalServiceUtil.increment());
				projectInviteTracking.setProjectId(interestId);
				projectInviteTracking.setInviteFrom(inviteFrom);
				projectInviteTracking.setInviteTo(inviteTo);
				projectInviteTracking.setInvitationStatus("Pending");
				projectInviteTracking.setIsRead(1);
				projectInviteTracking.setIsRemoved(3);
				projectInviteTracking.setMessageContent(inviteToName+" has sent you an invitation");
				projectInviteTracking.setCreateDate(new Date());
				projectInviteTrackingLocalServiceUtil.addprojectInviteTracking(projectInviteTracking);
				out.print("sent");
			}
		}catch(Exception e){}
		finally{
			
		}
	}
	
	private JSONArray GetData(String query) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		try {
			conn = DataAccess.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			if (rs != null) {
				while (rs.next()) {
					JSONObject jsonlstobj = JSONFactoryUtil.createJSONObject();
					ResultSetMetaData rsmd = rs.getMetaData();
					int noofcolumns = rsmd.getColumnCount();
					for (int i = 1; i <= noofcolumns; i++) {
						String column_name = rsmd.getColumnLabel(i);
						if (rsmd.getColumnType(i) == java.sql.Types.ARRAY) {
							jsonlstobj.put(column_name, rs.getArray(column_name));
						} else if (rsmd.getColumnType(i) == java.sql.Types.BIGINT) {
							jsonlstobj.put(column_name, checkvarchar(rs.getString(column_name)));
						} else if (rsmd.getColumnType(i) == java.sql.Types.BOOLEAN) {
							jsonlstobj.put(column_name, rs.getBoolean(column_name));
						} else if (rsmd.getColumnType(i) == java.sql.Types.BLOB) {
							jsonlstobj.put(column_name, rs.getBlob(column_name));
						} else if (rsmd.getColumnType(i) == java.sql.Types.DOUBLE) {
							jsonlstobj.put(column_name, rs.getDouble(column_name));
						} else if (rsmd.getColumnType(i) == java.sql.Types.FLOAT) {
							jsonlstobj.put(column_name, rs.getFloat(column_name));
						} else if (rsmd.getColumnType(i) == java.sql.Types.INTEGER) {
							jsonlstobj.put(column_name, rs.getInt(column_name));
						} else if (rsmd.getColumnType(i) == java.sql.Types.NVARCHAR) {
							jsonlstobj.put(column_name, checkvarchar(rs.getNString(column_name)));
						} else if (rsmd.getColumnType(i) == java.sql.Types.VARCHAR) {
							jsonlstobj.put(column_name, checkvarchar(rs.getString(column_name)));
						} else if (rsmd.getColumnType(i) == java.sql.Types.TINYINT) {
							jsonlstobj.put(column_name, rs.getInt(column_name));
						} else if (rsmd.getColumnType(i) == java.sql.Types.SMALLINT) {
							jsonlstobj.put(column_name, rs.getInt(column_name));
						} else if (rsmd.getColumnType(i) == java.sql.Types.DATE) {
							jsonlstobj.put(column_name, rs.getDate(column_name));
						} else if (rsmd.getColumnType(i) == java.sql.Types.TIMESTAMP) {
							jsonlstobj.put(column_name, rs.getTimestamp(column_name));
						} else {
							jsonlstobj.put(column_name, rs.getObject(column_name));
						}
					}
					jsonArray.put(jsonlstobj);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return jsonArray;
	}

	public String checkvarchar(String val) {
		String returnval = " ";
		if (val != null) {
			returnval = val;
		}
		return returnval;
	}
}