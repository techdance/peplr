<%@page import="javax.portlet.WindowState"%>
<%@ include file="/init.jsp" %>

<portlet:renderURL var="bestPracticesLibraryDashboard" copyCurrentRenderParameters="false" windowState="<%= WindowState.MAXIMIZED.toString() %>">
	<portlet:param name="jspPage"  value="/META-INF/resources/bestPractices.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="templatesLibraryDashboard" copyCurrentRenderParameters="false" windowState="<%= WindowState.MAXIMIZED.toString() %>">
	<portlet:param name="jspPage" value="/META-INF/resources/templates.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="gettingStartedLibraryDashboard" copyCurrentRenderParameters="false" windowState="<%= WindowState.MAXIMIZED.toString() %>">
	<portlet:param name="jspPage" value="/META-INF/resources/gettingStarted.jsp"/>
</portlet:renderURL> 

<div class="resources box box-border-radius box-shadow bg-white">
	<!-- Loader -->
	<div id="dashboardResourcesLoader" class="sectionloader"> 
		<div class="loader"></div>
	</div>
	<div class="inner-wrap">
		<div class="box-top position-relative">
			<%-- <h2 class="box-subhead icon-fa-box icon-th-large-regular pl-4"><a href="<%=themeDisplay.getURLPortal() %>/resources" style="color: black;">Resources</a></h2> --%>
			<h2 class="box-subhead icon-fa-box icon-th-large pl-4"><a href="<%=themeDisplay.getURLPortal() %>/resources" style="color: black;">Resources</a></h2>
			<a href="javascript:void(0);" class="icon-setting icon-box"><i class="fas fa-cog"></i></a>
		</div>
	</div>
	<div class="box-middle">
		<!-- <div class="box-image text-center">
			<img src="/o/ahea-theme/images/desktop-mobile-circle.png" alt="">
		</div> -->
		<div class="box-image text-center">
			<i class="fad fa-th-large icon-size-60" style="color:#008ffa"></i>
		</div>
	</div>
	<div class="box-bottom list-bullet">
		<ul>
			<li><a href="<%=gettingStartedLibraryDashboard.toString() %>">Getting Started</a></li>
			<li><a href="<%=bestPracticesLibraryDashboard.toString() %>">Best Practices</a></li>
			<li><a href="<%=templatesLibraryDashboard.toString() %>">Templates</a></li>
			<li><a href="javascript:void(0);">Tutorials</a></li>
			<li><a href="<%=themeDisplay.getURLPortal() %>/resources">More Resources</a></li>
		</ul>
	</div>
</div>