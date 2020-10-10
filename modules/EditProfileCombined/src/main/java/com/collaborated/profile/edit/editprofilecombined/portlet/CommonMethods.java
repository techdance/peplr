package com.collaborated.profile.edit.editprofilecombined.portlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import com.collaborated.entity.model.userProfileImage;
import com.collaborated.entity.service.userProfileImageLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.dao.jdbc.OutputBlob;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

public class CommonMethods {
	/*public static boolean addProfileImage(long userId, File file) throws PortalException, FileNotFoundException {
		boolean returnMessage = false;
		ServiceContext serviceContext = null;
		long Id = 0;
		long ImageId = 0;
		long FileEntryId = 0;
		String folderName = "";
		DLFileEntry dlFileEntry = null;
		InputStream is = null;
		long globalGroupId = 0;
		DLFolder dlfolder = null;
		long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		List<userProfileImage> values = null;
		try {
			Company companyobj = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
			globalGroupId = companyobj.getGroup().getGroupId();

			String groupName = GroupConstants.GUEST;
			long companyIdGroup = PortalUtil.getDefaultCompanyId();
			globalGroupId = GroupLocalServiceUtil.getGroup(companyIdGroup, groupName).getGroupId();

			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(userProfileImage.class,PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(userId));
			values = userProfileImageLocalServiceUtil.dynamicQuery(dynamicQuery);

			serviceContext = new ServiceContext();
			serviceContext.setScopeGroupId(globalGroupId);
			serviceContext.setAddGroupPermissions(true);
			serviceContext.setAddGuestPermissions(true);

			folderName = "Profile Image";

			dlfolder = DLFolderLocalServiceUtil.getFolder(globalGroupId, 0, folderName);
			System.out.println("dlfolder" + dlfolder);
			
			if(dlfolder==null){
				dlfolder=DLFolderLocalServiceUtil.addFolder(userId, globalGroupId, globalGroupId, false, parentFolderId, folderName, folderName, false, serviceContext);
				//System.out.println("Folder is created newly their with dlId:"+dlId);
			}else if(dlfolder!=null){
				String fileName = new Date().getTime() + "_" + file.getName();
				if (file != null) {
					is = new FileInputStream(file);
					
					try {
						System.out.println("dlfolder");
						dlFileEntry = DLFileEntryLocalServiceUtil.addFileEntry(userId, globalGroupId, globalGroupId,
								dlfolder.getFolderId(), fileName, MimeTypesUtil.getContentType(file), fileName, "", "", 0,
								null, file, is, file.length(), serviceContext);
						Id = dlFileEntry.getFileEntryId();
						FileEntry dlFileEntrys = DLAppLocalServiceUtil.getFileEntry(Id);
						String URL = "/documents/" + dlFileEntrys.getGroupId() + "/" + dlFileEntrys.getFolderId() + "/"
								+ dlFileEntrys.getTitle() + "/" + dlFileEntrys.getUuid();
						System.out.println("dlfolder" + URL);
						if(Id>0){
							if (values.size() > 0) {
								for (userProfileImage p : values) {
									DLFileEntryLocalServiceUtil.deleteDLFileEntry(Long.parseLong(p.getFileEntryId()));
									userProfileImage imageadd = userProfileImageLocalServiceUtil.getuserProfileImage(p.getPK_profileImageId());
									imageadd.setUserId(userId);
									imageadd.setFileEntryId(Long.toString(Id));
									imageadd.setCreatedOn(new Date());
									imageadd.setFileEntryUrl(URL);
									userProfileImageLocalServiceUtil.updateuserProfileImage(imageadd);		
								}
							}else{					
								userProfileImage imageadd = userProfileImageLocalServiceUtil.createuserProfileImage(CounterLocalServiceUtil.increment());
								imageadd.setUserId(userId);
								imageadd.setFileEntryId(Long.toString(Id));
								imageadd.setCreatedOn(new Date());
								imageadd.setFileEntryUrl(URL);
								userProfileImageLocalServiceUtil.adduserProfileImage(imageadd);					
							}
						}
						
					} catch (Exception e) {
						System.out.println(e);
					}
					returnMessage = true;
				}
			}
		} catch (Exception e) { 
			
			serviceContext = new ServiceContext();
			serviceContext.setScopeGroupId(globalGroupId);
			serviceContext.setAddGroupPermissions(true);
			serviceContext.setAddGuestPermissions(true);
			
			if(dlfolder==null){
				dlfolder=DLFolderLocalServiceUtil.addFolder(userId, globalGroupId, globalGroupId, false, parentFolderId, folderName, folderName, false, serviceContext);
				//System.out.println("Folder is created newly their with dlId:"+dlId);
			}
			
			if(dlfolder!=null){
				String fileName = new Date().getTime() + "_" + file.getName();
				if (file != null) {
					is = new FileInputStream(file);
					System.out.println("dlfolder" + is);
					try {
						System.out.println("dlfolder");
						dlFileEntry = DLFileEntryLocalServiceUtil.addFileEntry(userId, globalGroupId, globalGroupId,
								dlfolder.getFolderId(), fileName, MimeTypesUtil.getContentType(file), fileName, "", "", 0,
								null, file, is, file.length(), serviceContext);
						Id = dlFileEntry.getFileEntryId();
						FileEntry dlFileEntrys = DLAppLocalServiceUtil.getFileEntry(Id);
						String URL = "/documents/" + dlFileEntrys.getGroupId() + "/" + dlFileEntrys.getFolderId() + "/"
								+ dlFileEntrys.getTitle() + "/" + dlFileEntrys.getUuid();
						System.out.println("dlfolder" + URL);
						if(Id>0){
							if (values.size() > 0) {
								for (userProfileImage p : values) {
									DLFileEntryLocalServiceUtil.deleteDLFileEntry(Long.parseLong(p.getFileEntryId()));
									userProfileImage imageadd = userProfileImageLocalServiceUtil.getuserProfileImage(p.getPK_profileImageId());
									imageadd.setUserId(userId);
									imageadd.setFileEntryId(Long.toString(Id));
									imageadd.setCreatedOn(new Date());
									imageadd.setFileEntryUrl(URL);
									userProfileImageLocalServiceUtil.updateuserProfileImage(imageadd);		
								}
							}else{					
								userProfileImage imageadd = userProfileImageLocalServiceUtil.createuserProfileImage(CounterLocalServiceUtil.increment());
								imageadd.setUserId(userId);
								imageadd.setFileEntryId(Long.toString(Id));
								imageadd.setCreatedOn(new Date());
								imageadd.setFileEntryUrl(URL);
								userProfileImageLocalServiceUtil.adduserProfileImage(imageadd);					
							}
						}
						
					} catch (Exception e1) {
						System.out.println(e1);
					}
					returnMessage = true;
				}
			}
			
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return returnMessage;
	}*/
	
	public static boolean addProfileImage(long userId, File file){
		boolean returnMessage = false;
		List<userProfileImage> values = null;
		try{
			InputStream inputStream = new FileInputStream(file);
	        /**
	         * Below is the actual blob data
	         */
	        OutputBlob blobData = new OutputBlob(inputStream, file.length());
	        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(userProfileImage.class,PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(userId));
			values = userProfileImageLocalServiceUtil.dynamicQuery(dynamicQuery);
			if (values.size() > 0) {
				for (userProfileImage p : values) {
					userProfileImage imageadd = userProfileImageLocalServiceUtil.getuserProfileImage(p.getPK_profileImageId());
					imageadd.setUserId(userId);
					//imageadd.setFileEntryId(Long.toString(Id));
					imageadd.setCreatedOn(new Date());
					//imageadd.setFileEntryUrl(URL);
					imageadd.setBlobData(blobData);
					userProfileImageLocalServiceUtil.updateuserProfileImage(imageadd);
				}
			}else{
				userProfileImage imageadd = userProfileImageLocalServiceUtil.createuserProfileImage(CounterLocalServiceUtil.increment());
				imageadd.setUserId(userId);
				//imageadd.setFileEntryId(Long.toString(Id));
				imageadd.setCreatedOn(new Date());
				//imageadd.setFileEntryUrl(URL);
				imageadd.setBlobData(blobData);
				userProfileImageLocalServiceUtil.adduserProfileImage(imageadd);	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return returnMessage;
	}
	
	public static JSONObject getProfileImageBlob(long userId){
		JSONObject jsonSingleObject = null;	
		PreparedStatement st = null;
		ResultSet rs = null;
		Connection conn = null;
		try{
			String query = "SELECT * FROM `collaborated_userProfileImage` WHERE userId="+userId;
			conn = DataAccess.getConnection();
			st = conn.prepareStatement(query);
			rs = st.executeQuery(query);
			if (rs != null) {
				while (rs.next()) {
					jsonSingleObject = JSONFactoryUtil.createJSONObject();
					Blob blob = rs.getBlob("blobData");
					byte[] byteArray = blob.getBytes(1,(int)blob.length());	
					String encodeImage = Base64.encode(byteArray);
					jsonSingleObject.put("byteArray",encodeImage);					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
		    		rs.close();
		    	}
				if(st!=null){
					st.close();
		    	}
				if(conn!=null){
					conn.close();
		    	}
			}catch(Exception e){
			}
		}
		return jsonSingleObject;
	}
}