package com.collaborated.dashboard.dashboardrecommendedpartners.portlet;

import com.collaborated.entity.model.profileAreaofinterest;
import com.collaborated.entity.model.userProfileImage;
import com.collaborated.entity.service.profileAreaofinterestLocalServiceUtil;
import com.collaborated.entity.service.userProfileImageLocalServiceUtil;
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
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Image;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ImageLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DashboardRecommendedPartners Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DashboardRecommendedPartnersPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		/*JSONObject responseJSONInstitute = null;
		
		String apiURL = "http://23.99.141.44:3000/api/institution-profile";
        String institutionProfileResonse = getMethodAPI(apiURL); 
	    try {
	    	responseJSONInstitute = JSONFactoryUtil.createJSONObject(institutionProfileResonse);
	    	institutionProfile = responseJSONInstitute.getJSONObject("data");	
	    } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    }*/
		
		super.render(request, response);
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceID = null;
		resourceID = resourceRequest.getResourceID();
		System.out.println("resourceID" + resourceID);
		if (resourceID != null && resourceID.equals("loadRecommenedPartners")) {
			loadRecommenedPartners(resourceRequest,resourceResponse);
		}
	}
	public void loadRecommenedPartners(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		JSONArray jsonArray = null;
		JSONArray jsonArrayFinal = null;
		JSONObject jsonObjectFinal = null;
		PrintWriter out = null;
		List<profileAreaofinterest> listData = null;
		try{
			out = resourceResponse.getWriter();
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(profileAreaofinterest.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplay.getUserId())));
			listData = profileAreaofinterestLocalServiceUtil.dynamicQuery(dynamicQuery);
			if(listData.size()>0){
				String query = "SELECT DISTINCT(userId) FROM `collaborated_profileAreaofinterest` where userId!="+themeDisplay.getUserId()+" LIMIT 3";
				/*String query = "SELECT DISTINCT(userId) FROM `collaborated_profileareaofinterest` WHERE (projectType='"+singleData.getProjectType()+"' OR "
						+ "discipline='"+singleData.getDiscipline()+"')";*/
				jsonArray = GetData(query);
				jsonArrayFinal = JSONFactoryUtil.createJSONArray();
				for(int l=0;l<jsonArray.length();l++){
					 JSONObject jsonobj=jsonArray.getJSONObject(l);
					 User user = UserLocalServiceUtil.getUser(Long.valueOf(jsonobj.getString("userId")));
					 jsonObjectFinal = JSONFactoryUtil.createJSONObject();
					 //String instituteName = (String) themeDisplay.getUser().getExpandoBridge().getAttribute("instituteName");
					 
					 //ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(user.getCompanyId(),User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME);
					 //ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(user.getCompanyId(),User.class.getName(), table.getName(), "instituteName" );
					 //String instituteName =  ExpandoValueLocalServiceUtil.getData(user.getCompanyId(),User.class.getName(), table.getName(), column.getName(), user.getUserId(), StringPool.BLANK);
					 
					 //long portraitId = user.getPortraitId();
					 
					 
					 String imageURL = "",imgSRC="";boolean isBase64 = false;
					 imageURL = "";imgSRC="";isBase64 = false;
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
					 
					 /*String department="", cityState="",instituteName="";
					 if(institutionProfile!=null){
							instituteName = institutionProfile.getString("institutionName");
							JSONObject institutionContact = institutionProfile.getJSONObject("institutionContact");
							if(institutionContact!=null){
								department = institutionContact.getString("department");
							}
							JSONObject instituteProfileContact = institutionProfile.getJSONObject("institutionLocation");
							System.out.println("instituteProfileContact==="+instituteProfileContact);
							if(instituteProfileContact!=null){
								//department = instituteProfileContact.getString("department");
								cityState = instituteProfileContact.getString("city")+", "+instituteProfileContact.getString("state");								
							}
					}*/
						
						String instituteName = (String) themeDisplay.getUser().getExpandoBridge().getAttribute("instituteName");
						
						String instituteDepartment = (String) user.getExpandoBridge().getAttribute("instituteDepartment");
						String instituteCity = (String) user.getExpandoBridge().getAttribute("instituteCity");
						String instituteState = (String) user.getExpandoBridge().getAttribute("instituteState");
						String instituteCountry = (String) user.getExpandoBridge().getAttribute("instituteCountry");
				     
					 jsonObjectFinal.put("userName", user.getFullName());
					 jsonObjectFinal.put("jobTitle", user.getJobTitle());
					 jsonObjectFinal.put("department", instituteDepartment);
					 jsonObjectFinal.put("institutionName", instituteName);
					 jsonObjectFinal.put("institutionLocation", instituteCity + ", "+instituteState);
					 jsonObjectFinal.put("imageURL", imgSRC);
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
	
	public String getMethodAPI(String apiURL) {
		String returnData ="";
		ResponseEntity<String> returnObject= null;		
		try {
			RestTemplate restTemplate = new RestTemplate();
			returnObject=restTemplate.getForEntity(apiURL,String.class);
			if(returnObject!=null){
				returnData = returnObject.getBody();
			}
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return returnData;
	}
}