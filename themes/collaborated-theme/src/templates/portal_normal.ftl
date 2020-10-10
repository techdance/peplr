<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />

	<script src="https://kit.fontawesome.com/e4f868da6e.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:300,400,400i,700,700i,800,800i&display=swap" rel="stylesheet">
	<link href="https://use.fontawesome.com/releases/v5.0.1/css/all.css" rel="stylesheet">

</head>

<body id="page-register" class="${css_class} page-enter page-sign-in">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<div class="pt-0" id="wrapper">
	<header id="banner">
		<div class="navbar navbar-top navigation-bar-secondary">
			<div class="container user-personal-bar">
				<#assign preferences = freeMarkerPortletPreferences.getPreferences("portletSetupPortletDecoratorId", "barebone") />

				<#--  <#if show_header_search>
					<div class="ml-auto mr-4 navbar-form" role="search">
						<@liferay.search default_preferences="${preferences}" />
					</div>
				</#if>  -->

				<@liferay.user_personal_bar />
			</div>
		</div>

		<#--  <div class="mb-4 navbar navbar-expand-md navbar-light navbar-classic py-4">
			<div class="container">
				<a class="${logo_css_class} align-items-center d-inline-flex" href="${site_default_url}" title="<@liferay.language_format arguments="" key="go-to-x" />">
					<img alt="${logo_description}" class="mr-3" height="48" src="${site_logo}" />

					<h1 class="font-weight-bold h2 mb-0 text-dark">${site_name}</h1>
				</a>

				<#include "${full_templates_path}/navigation.ftl" />
			</div>
		</div>  -->
	</header>

	<section class="container">
		<div id="container">
		<header id="wrap-logo" class="ac">
			<a href="#"><img src="" id="collaborated_logo"></a>
		</header>
		<h1 class="sr-only">${the_title}</h1>

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

	<footer class="wrap-logo-bottom">
		<img src="/o/collaborated-theme/images/logo-tower-register.png" class="block">
	</footer>
</div>

<script>
$(document).ready(function(){
	//getLoginApplicationLogo();
});
function getLoginApplicationLogo(){
	$.ajax({
		url:'${propsUtil.get("LOGO_API_URL")}',
		type: "get",
		dataType: "json",
		contentType:"application/json",
		success: function(data){
		debugger;
			if(data!=null && data!=undefined && data!="undefined" && data!="null"){	
				if(data.collaborated_direct_login_logo!=null && data.collaborated_direct_login_logo!="" && data.collaborated_direct_login_logo!=undefined){
					$("#collaborated_logo").attr("src",data.collaborated_direct_login_logo);
				}
			}	
		}
	});
}
</script>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

</body>

</html>