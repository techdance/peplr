<%@ include file="/init.jsp" %>
<%
String[] onlineStatus = (String[]) themeDisplay.getUser().getExpandoBridge().getAttribute("onlineStatus");
String status = "";
for (String s: onlineStatus) {           
    //Do your stuff here 
    status = s;
}
%>
<div class="box box-border-radius box-shadow bg-white">
	<div class="inner-wrap">
		<div class="box-top position-relative">
			<h2 class="box-subhead"><i class="fas fa-user"></i><a href="<%=themeDisplay.getURLPortal() %>/profile" style="color: black;"> My Profile</a></h2>
			<a href="javascript:void(0);" class="icon-setting icon-box btn-menu"><i class="fas fa-cog"></i></a>
			<div class="toltip2 menu-toltip toltip-overlay any-toltip">
				<ul>
					<li><a href="<%=themeDisplay.getURLPortal() %>/edit-profile">Edit Profile</a></li>
					<li><a href="javascript:void(0);" class="btn-remove">Remove</a></li>
				</ul>
			</div>
		</div>
		<div class="box-middle">
			<div class="profile-image position-relative">
				<img src="<%=themeDisplay.getUser().getPortraitURL(themeDisplay) %>" alt="">
				<!-- <span class="user-active"></span> -->
			</div>
			<div class="profile-text w-50">
				<h3 class="profile-name text-truncate"><%=themeDisplay.getUser().getFullName() %></h3>
				<h3 class="profile-title text-truncate"><%=themeDisplay.getUser().getJobTitle() %></h3>
			</div>
		</div>
		<div class="box-bottom">
			<h3>Department of American Sign Language and Deaf Studies </h3>
			<p>The function of education is to teach one to think intensively and to think critically. Intelligence plus character - that is the goal of true education - MLK, Jr. </p>
		</div>
	</div>
</div>

<script>
$(window).on('load', function() {
	debugger;
	if("<%=status %>"=='Private' && "<%=status %>"!=''){
		$(".profile-image").addClass("Offline-status");
	}
	if("<%=status %>"=='Public' && "<%=status %>"!=''){
		$(".profile-image").addClass("Online-status");
	}
});
</script>