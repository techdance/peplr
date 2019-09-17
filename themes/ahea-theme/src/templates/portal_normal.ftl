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

<body id="page-register" class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<div class="pt-0" id="wrapper">
	<div class="page-wrapper d-flex flex-cloumn flex-lg-row">
		<div id="sidebar" class="sidebar-fixed">
			<div id="sidebar-wrap">
				<div id="wrap-logo">
					<a href="#" #logo=""><img src="/o/ahea-theme/images/logo-a.png"><img class="group-hide" src="/o/ahea-theme/images/logo-b.png"></a>
				</div>
				<div id="sidebar-content" class="aux">
					<#include "${full_templates_path}/navigation.ftl" />
				</div>
				<div id="wrap-logo-bottom" class="d-none d-xl-block">
					<a href="#"><img src="/o/ahea-theme/images/logo-tower-education.png"></a>
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
	
</div>
<script src="/o/ahea-theme/js/custom.js"></script>
<script src="/o/ahea-theme/js/jquery.sortable.js"></script>
<script src="/o/ahea-theme/js/perfect-scrollbar.js"></script>
<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

</body>

</html>