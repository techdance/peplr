<%@page import="com.liferay.portal.kernel.service.ListTypeServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.ListType"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.service.ContactLocalServiceUtil"%>
<%@ include file="/init.jsp" %>

<div class="personal box box-border-radius box-shadow bg-white">
    <div class="inner-wrap">
        <div class="box-top position-relative">
            <h2 class="box-subhead"><i class="fas fa-user"></i>Personal Information</h2>
        </div>
        <div class="box-middle d-flex flex-column flex-md-row align-items-md-center">
            <div class="content-left">
                <div class="bg-profile">
                    <img src="<%=themeDisplay.getUser().getPortraitURL(themeDisplay) %>" class="rounded-circle" id="user-profile" alt="Profile Image">
                </div>
            </div>
            <div class="content-right">
                <div class="profile-info profile-name">
                    <div class="title"><i class="fas fa-user"></i> Name</div>
                    <div class="text"><span id="prefixValue"></span> <span id="fullName"></span></div>
                </div>
                <div class="profile-info profile-title">
                    <div class="title"><i class="fa fa-users"></i> Position</div>
                    <div class="text" id="jobTitle"></div>
                </div>
            </div>
        </div>
        <div class="box-middle">
            <h4>Status</h4>
            <p id="profileStatus"></p>
        </div>
    </div>
    <a href="<%=themeDisplay.getURLPortal() %>/edit-profile" class="btn btn-blue position-absolute btn-edit-profile">
	    <span class="position-relative">
	        Edit Profile
	        <span class="link-toltip">Profile 85% Complete</span>
	    </span>
	</a>
</div>

<script>
$(document).ready(function(){
	loadUserInfo();
});
</script>