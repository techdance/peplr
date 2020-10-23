<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">
<#assign session=request.getSession()>
<#assign access_token = "" /><#assign course_url = "" />
<#if session.getAttribute("LIFERAY_SHARED_USER_TOKEN")??>
    <#assign access_token = session.getAttribute("LIFERAY_SHARED_USER_TOKEN")>
</#if>
<#if access_token!="">
	<#assign course_url = "http://137.117.70.79//login/index.php?user=${access_token}" />
<#else>
	<#assign course_url = "#" />
</#if>
<head>
	<title>${the_title} - </title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />

	<script src="https://kit.fontawesome.com/e4f868da6e.js"></script>
	<#--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>  -->
	<link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:300,400,400i,700,700i,800,800i&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="/o/ahea-theme/css/fontawesome-all.css">
	<!-- <link href="https://use.fontawesome.com/releases/v5.0.1/css/all.css" rel="stylesheet"> -->
	
	<#--  <script src="/o/ahea-theme/js/jquery-3.1.1.js"></script>  -->
	

</head>



<body id="page-register" class="${css_class}">

<#assign isAdmin = false 
	isClient = false
	adminClass = ""
/>

<#if is_signed_in>
	<#if serviceLocator??>
		<#assign
			roleLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.RoleLocalService")
			user_roles_list = roleLocalService.getUserRoles( themeDisplay.getUser().getUserId())
		/>
	</#if>

	<#list user_roles_list as roles_alone>
		<#if roles_alone.getName()=="Administrator">
			<#assign isAdmin = true 
				adminClass = "wrapper"
			/>					
		<#break>
		<#else>
			<#assign isClient = true />
			<#break>
		</#if>
	</#list>
</#if>

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<#if isAdmin>
	<@liferay.control_menu />
</#if>

<div class="loaderContainer">
	<div class="loader"></div>
</div>

<div class="pt-0" id="${adminClass}">
	<div class="page-wrapper d-flex flex-cloumn flex-lg-row">
		<div id="sidebar" class="sidebar-fixed">
			<div id="sidebar-wrap">
				<div id="wrap-logo">
					<a href="#" #logo=""><img src="" id="nav_collapse_logo"><img class="group-hide" src="" id="nav_logo"></a>
				</div>
				<#--  <div class="wrap-menu-button px-3"><a href="#" id="menu-button-hide-show"><i class="fas fa-arrow-circle-left" aria-hidden="true"></i></a></div>   -->
				<div class="top-icon icon-1">
					<button id="menu-button-hide-show" class="visible-lg"><i class="fas fa-arrow-circle-left"></i></button>
				</div>
				<div id="sidebar-content" class="aux">
					<#include "${full_templates_path}/navigation.ftl" />
				</div>
				<div id="wrap-logo-bottom" class="d-none d-xl-block">
					<a href="https://www.toweredtech.com/" target="_blank"><img src="/o/ahea-theme/images/logo-tower-education.png"></a>
				</div>
			</div>
		</div>
		<div id="content">
			<section class="container-fluid">
				<div id="">				
				<div class="testing_section">
					<#if selectable>
						<@liferay_util["include"] page=content_include />
					<#else>
						${portletDisplay.recycle()}
			
						${portletDisplay.setTitle(the_title)}
			
					<@liferay_theme["wrap-portlet"] page="portlet.ftl">
						<@liferay_util["include"] page=content_include />
					</@>
				</#if>
				</div>
			</section>
		</div>
	</div>
	<div class="modal fade" id="signOutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-body">
	        <div class="sign-out-logo">
	        	<img src="/o/ahea-theme/images/logo.png" id="sign-out-logo-image">
	        </div>
	        <h2>Sign Out</h2>
	        <p>Are you sure you would like to Sign Out of your account?</p>
	      </div>
	      <div class="modal-footer ac">
	        <button type="button" class="btn-footer" data-dismiss="modal" aria-label="Close">Cancel</button>
	        <a href="/c/portal/logout" class="btn-footer">Sign Out</a>
	      </div>
	    </div>
	  </div>
	</div>
</div>

<script src="/o/ahea-theme/js/jquery.sortable.js"></script>
<script src="/o/ahea-theme/js/perfect-scrollbar.js"></script>
<script src="/o/ahea-theme/js/custom.js?v=1.3"></script>

<script type="text/javascript" src="/o/ahea-theme/js/jquery.easy-pie-chart.min.js"></script>
<script type="text/javascript" src="/o/ahea-theme/js/app.js"></script>
<script type="text/javascript" src="/o/ahea-theme/js/plugins.js"></script>
<script>
$(document).ready(function(){
	Plugins.init();
	getApplicationLogo();
	getApplicationTitle();
});

function getApplicationLogo(){
	$.ajax({
		url:'${propsUtil.get("LOGO_API_URL")}',
		type: "get",
		dataType: "json",
		contentType:"application/json",
		success: function(data){
		debugger;
			if(data!=null && data!=undefined && data!="undefined" && data!="null"){	
				if(data.side_navigation_menu_logo!=null && data.side_navigation_menu_logo!="" && data.side_navigation_menu_logo!=undefined){
					$("#nav_logo").attr("src",data.side_navigation_menu_logo);
					$("#sign-out-logo-image").attr("src",data.side_navigation_menu_logo);
				}
				if(data.side_navigation_menu_collapsed_logo!=null && data.side_navigation_menu_collapsed_logo!="" && data.side_navigation_menu_collapsed_logo!=undefined){
					$("#nav_collapse_logo").attr("src",data.side_navigation_menu_collapsed_logo);
				}
			}	
		}
	});
}
function getApplicationTitle(){
	$.ajax({
		url:'${propsUtil.get("INSTITUTION_PROFILE_API_URL")}',
		type: "get",
		dataType: "json",
		contentType:"application/json",
		success: function(data){
		debugger;
			if(data!=null && data!=undefined && data!="undefined" && data!="null"){	
				if(data.data!=null && data.data!="" && data.data!=undefined){
					$("title").append(data.data.institutionName);
				}
			}	
		}
	});
}
$("#sign-out-hit").click(function(){
    location.href="${themeDisplay.getURLSignOut()}";
    window.location.href="http://sfu.toweredtech.com/";
});
</script>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

</body>

</html>