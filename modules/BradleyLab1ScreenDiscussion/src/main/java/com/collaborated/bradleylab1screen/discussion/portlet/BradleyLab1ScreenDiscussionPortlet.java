package com.collaborated.bradleylab1screen.discussion.portlet;

import com.collaborated.entity.model.labScreenProjectOverview;
import com.collaborated.entity.model.projectDiscussion;
import com.collaborated.entity.model.projectFilesUpload;
import com.collaborated.entity.model.projectFolderUpload;
import com.collaborated.entity.model.userProfileImage;
import com.collaborated.entity.service.labScreenProjectOverviewLocalServiceUtil;
import com.collaborated.entity.service.projectDiscussionLocalServiceUtil;
import com.collaborated.entity.service.projectFilesUploadLocalServiceUtil;
import com.collaborated.entity.service.projectFolderUploadLocalServiceUtil;
import com.collaborated.entity.service.userProfileImageLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactory;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

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
		"javax.portlet.display-name=BradleyLab1ScreenDiscussion Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"com.liferay.portlet.private-session-attributes=false",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class BradleyLab1ScreenDiscussionPortlet extends MVCPortlet {	
	private long PK_projectId = new Long(0); 
	private long PK_interestId = new Long(0);

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
		
		/*PortletSession session = renderRequest.getPortletSession();	
		labScreenProjectOverview labScreenProjectOverview = null;
		String projectId = (String)session.getAttribute("PROJECT_KEY", PortletSession.APPLICATION_SCOPE);
		PK_projectId = new Long(projectId);
		if(PK_projectId!=0){
			try {
				labScreenProjectOverview = labScreenProjectOverviewLocalServiceUtil.getlabScreenProjectOverview(PK_projectId);
				if(labScreenProjectOverview!=null){
					PK_interestId = labScreenProjectOverview.getInterestId();
				}
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}*/
	
		super.doView(renderRequest, renderResponse); // make sure this is the last line in your method
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceID = null;
		resourceID = resourceRequest.getResourceID();
		if (resourceID != null && resourceID.equals("saveFolder")) {
			saveFolder(resourceRequest,resourceResponse);
		}else if (resourceID != null && resourceID.equals("saveFiles")) {
			saveFiles(resourceRequest,resourceResponse);
		}else if (resourceID != null && resourceID.equals("getFolders")) {
			getFolders(resourceRequest,resourceResponse);
		}else if (resourceID != null && resourceID.equals("getFilesByFolderSelection")) {
			getFilesByFolderSelection(resourceRequest,resourceResponse);
		}else if (resourceID != null && resourceID.equals("getFolderSelection")) {
			getFolderSelection(resourceRequest,resourceResponse);
		}else if (resourceID != null && resourceID.equals("saveMessage")) {
			saveMessage(resourceRequest,resourceResponse);
		}else if (resourceID != null && resourceID.equals("showDiscussionMessage")) {
			showDiscussionMessage(resourceRequest,resourceResponse);
		}
	}
	
	public void saveFolder(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long parentFolderId = ParamUtil.getLong(resourceRequest, "parentFolderId");
		String folderName = ParamUtil.getString(resourceRequest, "folderName");
		PrintWriter out = null;
		Folder folder = null;
		try{
			out = resourceResponse.getWriter();
			
			HttpServletRequest httprequest = PortalUtil.getHttpServletRequest(resourceRequest);
			httprequest = PortalUtil.getOriginalServletRequest(httprequest);

			HttpSession httpsession = httprequest.getSession();
			String sessionProjectID = (String)httpsession.getAttribute("PROJECT_KEY");
			String sessionInterestID = (String)httpsession.getAttribute("PROJECT_INTEREST_KEY");
			long PK_projectId = new Long(0);
			long PK_interestId = new Long(0);
			long currentUser = (Long)httpsession.getAttribute("currentUser");		
			if(currentUser==themeDisplay.getUserId()){
				PK_projectId = new Long(sessionProjectID);	
				PK_interestId = new Long(sessionInterestID);
			}
			
			boolean folderExist = isFolderExist(themeDisplay,parentFolderId,themeDisplay.getUserId()+"_"+folderName);			
			if (!folderExist) {
				long repositoryId = themeDisplay.getScopeGroupId();		
				try {
					ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), resourceRequest);
					//folder = DLAppLocalServiceUtil.addFolder(themeDisplay.getUserId(), repositoryId, parentFolderId, folderName, "Folder created programmatically", serviceContext);
					folder = DLAppServiceUtil.addFolder(repositoryId,parentFolderId, themeDisplay.getUserId()+"_"+folderName, "Folder created programmatically", serviceContext);
					projectFolderUpload projectFolderUpload = projectFolderUploadLocalServiceUtil.createprojectFolderUpload(CounterLocalServiceUtil.increment());
					projectFolderUpload.setCreatedOn(new Date());
					projectFolderUpload.setProjectId(PK_projectId);
					projectFolderUpload.setInterestId(PK_interestId);
					projectFolderUpload.setUserId(themeDisplay.getUserId());
					projectFolderUpload.setFolderId(folder.getFolderId());
					projectFolderUpload.setParentFolderId(parentFolderId);
					projectFolderUpload.setFolderName(folderName);
					projectFolderUpload.setDescription("Folder created programmatically");
					projectFolderUploadLocalServiceUtil.addprojectFolderUpload(projectFolderUpload);
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
					jsonObject.put("message", "add");
					jsonObject.put("parentFolderId", projectFolderUpload.getFolderId());
					out.print(jsonObject);
				} catch (PortalException e1) {
					e1.printStackTrace();
				} catch (SystemException e1) {
					e1.printStackTrace();
				}			
			}
		}catch(Exception e){
			
		}finally{
			if(out!=null){
				out.close();
			}
			if(folder!=null){
				folder = null;
			}
		}
	}
	
	public boolean isFolderExist(ThemeDisplay themeDisplay,long parentFolderId,String folderName){
		boolean folderExist = false;
		Folder folder = null;
		System.out.println("parentFolderId====folderexist==="+parentFolderId);
		try {
			folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId, themeDisplay.getUserId()+"_"+folderName);
			//folder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), parentFolderId, folderName);
			/*if(folder.getUserId()==themeDisplay.getUserId()){
				folderExist = true;
			}*/
			System.out.println("Folder is already Exist");
		} catch (Exception e) {	
			System.out.println(e.getMessage());
		}
		return folderExist;
	}
	
	public Folder getFolder(ThemeDisplay themeDisplay,long folderId,String folderName){
		Folder folder = null;
		try {
			folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), folderId, themeDisplay.getUserId()+"_"+folderName);
			//folder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), folderId, folderName);
			/*if(folder.getUserId()!=themeDisplay.getUserId()){
				folder = null;
			}*/
		} catch (Exception e) {	
			System.out.println(e.getMessage());
		}
		return folder;
	}
	
	public void saveFiles(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		PrintWriter out = null;Folder folder = null;
		projectFolderUpload projectFolderUpload = null;
      
		String fileName=uploadPortletRequest.getFileName("uploadedFile");		 			
		File file = uploadPortletRequest.getFile("uploadedFile");
		String mimeType = uploadPortletRequest.getContentType("uploadedFile");
        String title = fileName;
		String description = "This file is added via programatically";
		long repositoryId = themeDisplay.getScopeGroupId();
		System.out.println("Title=>"+title);
		long parentFolderId = ParamUtil.getLong(resourceRequest, "folderId");
		String folderName = ParamUtil.getString(resourceRequest, "folderNameHidden");
		System.out.println("folderId==="+parentFolderId);
		System.out.println("folderNameHidden==="+folderName);
	    try
	    {  
	    	out = resourceResponse.getWriter();
	    	projectFolderUpload = projectFolderUploadLocalServiceUtil.getprojectFolderUpload(parentFolderId);
	    	System.out.println(projectFolderUpload);
	    	if(projectFolderUpload!=null){
	    		folder = getFolder(themeDisplay, projectFolderUpload.getParentFolderId(), folderName);
	    	}	   
	    	System.out.println(folder);
	    	if(folder!=null){
	    		System.out.println("test 1");
	    		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), resourceRequest);
		    	InputStream is = new FileInputStream( file );	
		    	System.out.println("test 2");
		    	FileEntry fileObject = DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), fileName, mimeType, title, description, "", is, file.getTotalSpace(), serviceContext);
		    	projectFilesUpload projectFilesUpload = projectFilesUploadLocalServiceUtil.createprojectFilesUpload(CounterLocalServiceUtil.increment());
		    	projectFilesUpload.setCreatedOn(new Date());
		    	projectFilesUpload.setUserId(themeDisplay.getUserId());
		    	projectFilesUpload.setPK_projectFolderId(parentFolderId);
		    	projectFilesUpload.setFileName(fileName);
		    	projectFilesUpload.setFileEntryId(String.valueOf(fileObject.getFileEntryId()));
		    	projectFilesUpload.setDescription("This file is added via programatically");
		    	projectFilesUploadLocalServiceUtil.addprojectFilesUpload(projectFilesUpload);
		    	JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("message", "add");
				jsonObject.put("parentFolderId", parentFolderId);
				out.print(jsonObject);
	    	}	
	    } catch (Exception e)
	    {
	       System.out.println(e.getMessage());
	       e.printStackTrace();
	    }finally{
			if(out!=null){
				out.close();
			}
			if(folder!=null){
				folder = null;
			}
		}
	}
	
	public void getFolders(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		List<projectFolderUpload> projectFolderUpload = null;
		List<projectFolderUpload> projectFolderUploadSub = null;
		List<projectFilesUpload> projectFilesUpload = null;
		String templateFolder = "";String templateFile = "";
		PrintWriter out = null;
		JSONObject jsonObject = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try{
			out = resourceResponse.getWriter();
			
			HttpServletRequest httprequest = PortalUtil.getHttpServletRequest(resourceRequest);
			httprequest = PortalUtil.getOriginalServletRequest(httprequest);

			HttpSession httpsession = httprequest.getSession();
			String sessionProjectID = (String)httpsession.getAttribute("PROJECT_KEY");
			String sessionInterestID = (String)httpsession.getAttribute("PROJECT_INTEREST_KEY");
			long PK_projectId = new Long(0);
			long PK_interestId = new Long(0);
			long currentUser = (Long)httpsession.getAttribute("currentUser");		
			if(currentUser==themeDisplay.getUserId()){
				PK_projectId = new Long(sessionProjectID);	
				PK_interestId = new Long(sessionInterestID);
			}
			
			jsonObject = JSONFactoryUtil.createJSONObject();
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(projectFolderUpload.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("projectId").eq(Long.valueOf(PK_projectId)));
			projectFolderUpload = projectFolderUploadLocalServiceUtil.dynamicQuery(dynamicQuery);
			System.out.println("projectFolderUpload==="+projectFolderUpload.size());
			System.out.println("projectFolderUpload==="+projectFolderUpload);
			if(projectFolderUpload.size()>0){
				for(projectFolderUpload singleData:projectFolderUpload){
					String subfolderDesign = "";
					
					DynamicQuery dynamicQuerySub = DynamicQueryFactoryUtil.forClass(projectFolderUpload.class, PortalClassLoaderUtil.getClassLoader());
					dynamicQuerySub.add(PropertyFactoryUtil.forName("parentFolderId").eq(singleData.getFolderId()));
					projectFolderUploadSub = projectFolderUploadLocalServiceUtil.dynamicQuery(dynamicQuerySub);
					for(projectFolderUpload singleDataSub:projectFolderUploadSub){
						subfolderDesign = subfolderDesign + "<li><a href=\"javascript:void(0);\" onclick='getSelectedFolder("+singleDataSub.getPK_projectFolderId()+")'><i class=\"fas fa-folder\"></i> "+ singleDataSub.getFolderName() +" </a></li>";
					}					
					
					/*if(singleData.getParentFolderId()==singleData.getFolderId()){
						subfolderDesign = subfolderDesign + "<li><a href=\"#\" onclick='getSelectedFolder("+singleData.getFolderId()+")'><i class=\"fas fa-folder\"></i> "+ singleData.getFolderName() +" </a></li>";
					}*/		
					
					if(singleData.getParentFolderId()==0){
						//Design for parent folder structure
						templateFolder = templateFolder
								+ "<li id='"+singleData.getPK_projectFolderId()+"'><a href=\"javascript:void(0);\" onclick='getSelectedFolder("+singleData.getPK_projectFolderId()+")' ><i class=\"fas fa-folder\"></i> "+ singleData.getFolderName() +" </a><ul>"+subfolderDesign+"</ul></li>"
								;
					}
					
					
				}
				
				//Load files for first folder
				
				DynamicQuery dynamicQueryFiles = DynamicQueryFactoryUtil.forClass(projectFilesUpload.class, PortalClassLoaderUtil.getClassLoader());
				dynamicQueryFiles.add(PropertyFactoryUtil.forName("PK_projectFolderId").eq(projectFolderUpload.get(0).getPK_projectFolderId()));
				projectFilesUpload = projectFilesUploadLocalServiceUtil.dynamicQuery(dynamicQueryFiles);
				System.out.println("projectFilesUpload==="+projectFilesUpload.size());
				System.out.println("projectFilesUpload==="+projectFilesUpload);
				for(projectFilesUpload singleFileData:projectFilesUpload){
					FileEntry dlFileEntry = null;String urlPath = "";
					dlFileEntry = DLAppLocalServiceUtil.getFileEntry(Long.valueOf(singleFileData.getFileEntryId()));
					if(dlFileEntry!=null){
						urlPath = themeDisplay.getPortalURL() + "/documents/"
								+ dlFileEntry.getGroupId() + "/"
								+ dlFileEntry.getFolderId() + "/"
								+ dlFileEntry.getTitle();
					}
					templateFile = templateFile + singleFileData.getFileName() + urlPath;
				}
				
				jsonObject.put("parentFolderId",projectFolderUpload.get(0).getPK_projectFolderId());
			}
			jsonObject.put("templateFolder","<ul class=\"mb-4\">"+templateFolder+"<li><a href=\"#\"><i class=\"fas fa-trash\"></i> Recycle Bin</a></li></ul>");
			jsonObject.put("templateFile",templateFile);
			
			out.print(jsonObject);
		}catch(Exception e){
			
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	public void getFilesByFolderSelection(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long PK_parentFolderId = ParamUtil.getLong(resourceRequest, "parentFolderId");
		long folderId = ParamUtil.getLong(resourceRequest, "folderId");
		PrintWriter out = null;
		List<projectFilesUpload> projectFilesUpload = null;List<projectFolderUpload> projectFolderDetails = null;
		String templateFile = "";
		try{
			out = resourceResponse.getWriter();
			DynamicQuery dynamicQueryFiles = DynamicQueryFactoryUtil.forClass(projectFilesUpload.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryFiles.add(PropertyFactoryUtil.forName("PK_projectFolderId").eq(PK_parentFolderId));
			projectFilesUpload = projectFilesUploadLocalServiceUtil.dynamicQuery(dynamicQueryFiles);
			System.out.println("projectFilesUpload==="+projectFilesUpload.size());
			System.out.println("projectFilesUpload==="+projectFilesUpload);
			
			/*DynamicQuery dynamicQuerySub = DynamicQueryFactoryUtil.forClass(projectFolderUpload.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQuerySub.add(PropertyFactoryUtil.forName("parentFolderId").eq(folderId));
			projectFolderDetails = projectFolderUploadLocalServiceUtil.dynamicQuery(dynamicQuerySub);
			
			if(projectFolderDetails.size()>0){
				for(projectFolderUpload singleDataSub:projectFolderDetails){
					templateFile = templateFile + singleDataSub.getFolderName();
				}
			}*/
			
			if(projectFilesUpload.size()>0){
				for(projectFilesUpload singleFileData:projectFilesUpload){
					FileEntry dlFileEntry = null;String urlPath = "";String thumbnail = "";
					dlFileEntry = DLAppLocalServiceUtil.getFileEntry(Long.valueOf(singleFileData.getFileEntryId()));
					if(dlFileEntry!=null){
						urlPath = themeDisplay.getPortalURL() + "/documents/"
								+ dlFileEntry.getGroupId() + "/"
								+ dlFileEntry.getFolderId() + "/"
								+ dlFileEntry.getTitle();
						//thumbnail = dlFileEntry.get
						String[] res = singleFileData.getFileName().split("\\.");
						if(res[1].equals("jpeg") || res[1].equals("png")){
							//set static icon for thumbnail
							thumbnail = "<i class='fas fa-images'></i>";
						}
						else if(res[1].equals("docx") || res[1].equals("doc") || res[1].equals("ppt") || res[1].equals("pptx") || res[1].equals("pdf")){
							//set static icon for thumbnail
							thumbnail = "<i class='fas fa-file-alt'></i>";
						}
						
						else if(res[1].equals("folder")){
							//set static icon for thumbnail
							thumbnail = "<i class='fas fa-folder'></i>";
						}
					}
					 
					templateFile = templateFile + " <div class='col-md-4 ac mb-3'> "+
							" <a href='javascript:void(0);' data-content='"+urlPath+"'> "+ thumbnail +
							"  <span class='font12 color-black'>"+singleFileData.getFileName()+"</span></a> "+
							" </div> ";
				}
			}
			out.print(templateFile);
		}catch(Exception e){
			
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	public void getFolderSelection(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		long PK_parentFolderId = ParamUtil.getLong(resourceRequest, "PK_parentFolderId");
		JSONObject jsonObject = null;
		PrintWriter out = null;
		projectFolderUpload projectFolderUpload = null;
		try{
			out = resourceResponse.getWriter();
			jsonObject = JSONFactoryUtil.createJSONObject();
			projectFolderUpload = projectFolderUploadLocalServiceUtil.getprojectFolderUpload(PK_parentFolderId);
			if(projectFolderUpload!=null){
				jsonObject.put("parentFolderId", projectFolderUpload.getFolderId());
				jsonObject.put("folderName", projectFolderUpload.getFolderName());
			}
			System.out.println("projectFilesUpload==="+projectFolderUpload);
			out.print(jsonObject);
		}catch(Exception e){
			
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	public void saveMessage(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String discussionMessage = ParamUtil.getString(resourceRequest, "discussionMessage");
		SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
		Date createdOn = new Date();
		String userTimeZone = "";
		try {
			User sendUser = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
			userTimeZone = (String)sendUser.getExpandoBridge().getAttribute("instituteTimezone");
			if(userTimeZone!=""){
				sdfDestination.setTimeZone(TimeZone.getTimeZone(userTimeZone));
				createdOn = sdfDestination.parse(sdfDestination.format(new Date()));
			}
		} catch (PortalException | ParseException e1) {
			_log.error("Couldn't find the user details");
		}
		PrintWriter out = null;
		try{
			out = resourceResponse.getWriter();
			
			HttpServletRequest httprequest = PortalUtil.getHttpServletRequest(resourceRequest);
			httprequest = PortalUtil.getOriginalServletRequest(httprequest);

			HttpSession httpsession = httprequest.getSession();
			String sessionProjectID = (String)httpsession.getAttribute("PROJECT_KEY");
			String sessionInterestID = (String)httpsession.getAttribute("PROJECT_INTEREST_KEY");
			long PK_projectId = new Long(0);
			long PK_interestId = new Long(0);
			long currentUser = (Long)httpsession.getAttribute("currentUser");		
			if(currentUser==themeDisplay.getUserId()){
				PK_projectId = new Long(sessionProjectID);	
				PK_interestId = new Long(sessionInterestID);
			}
			
			projectDiscussion projectDiscussion = projectDiscussionLocalServiceUtil.createprojectDiscussion(CounterLocalServiceUtil.increment());
			projectDiscussion.setCreatedOn(createdOn);
			projectDiscussion.setInterestId(PK_interestId);
			projectDiscussion.setProjectId(PK_projectId);
			projectDiscussion.setSenderId(themeDisplay.getUserId());
			projectDiscussion.setDescription(discussionMessage);
			projectDiscussionLocalServiceUtil.addprojectDiscussion(projectDiscussion);
			out.print("add");
		}catch(Exception e){
			
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	
	public void showDiscussionMessage(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PrintWriter out = null;String template = "",imageURL="",imgSRC = "";
		boolean isBase64 = false;
		try{
			out = resourceResponse.getWriter();
			
			HttpServletRequest httprequest = PortalUtil.getHttpServletRequest(resourceRequest);
			httprequest = PortalUtil.getOriginalServletRequest(httprequest);

			HttpSession httpsession = httprequest.getSession();
			String sessionProjectID = (String)httpsession.getAttribute("PROJECT_KEY");
			String sessionInterestID = (String)httpsession.getAttribute("PROJECT_INTEREST_KEY");
			long PK_projectId = new Long(0);
			long PK_interestId = new Long(0);
			long currentUser = (Long)httpsession.getAttribute("currentUser");		
			if(currentUser==themeDisplay.getUserId()){
				PK_projectId = new Long(sessionProjectID);	
				PK_interestId = new Long(sessionInterestID);
			}
			
			DynamicQuery dynamicQueryDiscussion = DynamicQueryFactoryUtil.forClass(projectDiscussion.class, PortalClassLoaderUtil.getClassLoader());
			dynamicQueryDiscussion.add(PropertyFactoryUtil.forName("projectId").eq(PK_projectId));
			List<projectDiscussion> projectDiscussion = projectDiscussionLocalServiceUtil.dynamicQuery(dynamicQueryDiscussion);
			if(projectDiscussion.size()>0){
				for(projectDiscussion singleData:projectDiscussion){
					String userTimeZone = "";
					if(singleData.getSenderId() == themeDisplay.getUserId()){
						User user = UserLocalServiceUtil.getUser(singleData.getSenderId());
						SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
						User sendUser = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
						userTimeZone = (String)sendUser.getExpandoBridge().getAttribute("instituteTimezone");
						if(userTimeZone!=""){
							sdfDestination.setTimeZone(TimeZone.getTimeZone(userTimeZone));
						}
						DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(userProfileImage.class,PortalClassLoaderUtil.getClassLoader());
						dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(user.getUserId()));
						List<userProfileImage> values = userProfileImageLocalServiceUtil.dynamicQuery(dynamicQuery);
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
						
						//Leftside design
						/*template = template + user.getPortraitURL(themeDisplay) + user.getFullName() + singleData.getDescription() + sdfDestination.format(singleData.getCreatedOn()) ;*/
						template = template + " <div class='item item-flex'> "+
								  " <div class='item-text'> "+
									 " <div class='items odd'> "+
										  " <div class='person-top'> "+
											  " <p>"+user.getFullName()+" "+sdfDestination.format(singleData.getCreatedOn())+"</p> "+
										  " </div> "+
										  " <div class='person-bottom'> "+
											  " <p class='m-0'>"+singleData.getDescription()+"</p> "+
										  " </div> "+
									  " </div> "+
								  " </div> "+
								  " <div class='item-img'> "+
									  " <div class='person-img'> "+
										  " <img src='"+imgSRC+"' class='img-circle' width='58'> "+
									  " </div> "+
								  " </div> "+
								" </div> ";
					}else{
						User user = UserLocalServiceUtil.getUser(singleData.getSenderId());
						SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
						DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(userProfileImage.class,PortalClassLoaderUtil.getClassLoader());
						dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(user.getUserId()));
						List<userProfileImage> values = userProfileImageLocalServiceUtil.dynamicQuery(dynamicQuery);
						if(values.size()>0){
							imageURL = values.get(0).getFileEntryUrl();					
						    JSONObject jsonObject2 = CommonMethods.getProfileImageBlob(user.getUserId());	               
						    imageURL = jsonObject2.getString("byteArray");
						    imgSRC = "data:image/png;base64,"+imageURL;
						    isBase64 = true;
						}else{
							imageURL = user.getPortraitURL(themeDisplay) ;
							imgSRC = imageURL;
							isBase64 = false;
						}
						//Right side design
						/*template = template + user.getPortraitURL(themeDisplay) + user.getFullName() + singleData.getDescription() + sdfDestination.format(singleData.getCreatedOn());*/
						template = template + " <div class='item item-flex'> " +
								  " <div class='item-img'> " +
								  " <div class='person-img'> "+
									  " <img src='"+imgSRC+"' class='img-circle' width='58'> "+
									  " <span class='user-active'></span> "+
								  " </div> "+
							  " </div> "+
							  " <div class='item-text'> "+
								  " <div class='person-top'> "+
									  " <p>"+user.getFullName()+" "+sdfDestination.format(singleData.getCreatedOn())+"</p> "+
								  " </div> "+
								  " <div class='person-bottom person-laguage'> "+
									  " <p class='m-0'>"+singleData.getDescription()+"</p> "+
								  " </div> "+
							  " </div> "+
							" </div> ";
					}
				}
			}
			
			out.print(template);
		}catch(Exception e){
			
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	private static final Log _log = LogFactoryUtil.getLog(BradleyLab1ScreenDiscussionPortlet.class.getName());
}