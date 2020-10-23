<%@page import="com.collaborated.profile.portlet.CommonMethods"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.collaborated.entity.service.userProfileImageLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page import="com.collaborated.entity.model.userProfileImage"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@ include file="/init.jsp" %>

<%
String portalUrl = themeDisplay.getURLPortal();
String currentUrl = themeDisplay.getURLCurrent();
String returnURL = "";
/* if (currentUrl.contains("edit-profile")) {
	returnURL = "Edit Profile";
} else if (currentUrl.contains("institution-profile-overview")) {
	returnURL = "Institution";
}  */if (currentUrl.contains("profile")) {
	returnURL = "Profile";
} else if (currentUrl.contains("resources")) {
	returnURL = "Resources";
}
/*else if (currentUrl.contains("matching-screen")) {
	returnURL = "Matching Screen";
}*/
else if (currentUrl.contains("course-development")) {
	returnURL = "Course Development";
}

String imageURL = "",imgSRC="";boolean isBase64 = false;
DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(userProfileImage.class,PortalClassLoaderUtil.getClassLoader());
dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(themeDisplay.getUser().getUserId()));
List<userProfileImage> values = userProfileImageLocalServiceUtil.dynamicQuery(dynamicQuery);
if(values.size()>0){
	imageURL = values.get(0).getFileEntryUrl();					
    JSONObject jsonObject2 = CommonMethods.getProfileImageBlob(themeDisplay.getUser().getUserId());	               
    imageURL = jsonObject2.getString("byteArray");
    imgSRC = "data:image/png;base64,"+imageURL;
    isBase64 = true;
}else{
	imageURL = "/o/ahea-theme/images/user.png";
	imgSRC = imageURL;
	isBase64 = false;
}

%>


<section class="top">
	<div class="px-3">
	<!--<div class="top-icon icon-1">
		<button id="menu-button-hide-show" class="visible-lg"><i class="fas fa-arrow-circle-left"></i></button>
	</div>-->
	<!-- <div class="top-icon icon-1">
		<a  id="btn-badges">
			<img src="/o/ahea-theme/images/svg/Badges-Icon-1.svg" width="50" alt="">
			<span class="note">
				<span class="outer">1</span>
			</span>
		</a>	
		<div id="badges-toltip" class="toltip toltip-overlay p-3">
			<div class="toltip-header">
				<div class="toltip-title">
					<img src="/o/ahea-theme/images/svg/Badges-Icon-3.svg" width="25"> Badges
				</div>
				<div class="toltip-close">
					<a href="javascript:void(0);"><i class="fa fa-times-circle" aria-hidden="true"></i></a>
				</div>
			</div>
			<div class="toltip-body text-center">
				<div class="wrap-icon">
					<img src="/o/ahea-theme/images/svg/Badges-Icon-2.svg" alt="" width="125">
				</div>
				<p>Congratulations! You earned the Orientation Badge.</p>
			</div>
			<div class="toltip-footer text-center">
				<a href="javascript:void(0);" class="btn btn-blue m-auto">View More</a>
			</div>
		</div>					
	</div>
	<div class="top-icon icon-2">
		<a id="btn-notification">
			<img class="this-img" src="/o/ahea-theme/images/svg/Bell-Icon-1.svg" width="45" alt="">
			<span class="note">
				<span class="outer">5</span>
			</span>
		</a>
		<div id="notification-toltip" class="toltip">
			<div class="toltip-item toltip-overlay d-flex mb-2">
				<div class="toltip-image">
					<img src="/o/ahea-theme/images/recom-img-1.jpg" width="48">
				</div>
				<div class="toltip-text">
					<p>Lorem ipsum dolor sit amet, adipiscing. Donec odio.</p>
				</div>
				<div class="toltip-close-details">
					<a href="javascript:void(0);" class="close-this">Close</a>
					<a href="javascript:void(0);">Details</a>
				</div>
			</div>
			<div class="toltip-item toltip-overlay d-flex mb-2">
				<div class="toltip-icon toltip-icon-green">
					<i class="fa fa-users" aria-hidden="true"></i>
				</div>
				<div class="toltip-text">
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing. Donec odio.</p>
				</div>
				<div class="toltip-close-details">
					<a href="javascript:void(0);" class="close-this">Close</a>
					<a href="javascript:void(0);">Details</a>
				</div>
			</div>
			<div class="toltip-item toltip-overlay d-flex mb-2">
				<div class="toltip-image">
					<img src="/o/ahea-theme/images/recom-img-2.jpg" width="48">
				</div>
				<div class="toltip-text">
					<p>Lorem ipsum dolor sit amet, adipiscing. Donec odio.</p>
				</div>
				<div class="toltip-close-details">
					<a href="javascript:void(0);" class="close-this">Close</a>
					<a href="javascript:void(0);">Details</a>
				</div>
			</div>
			<div class="toltip-item toltip-overlay d-flex mb-2">
				<div class="toltip-icon toltip-icon-blue">
					<i class="fas fa-bullhorn" aria-hidden="true"></i>
				</div>
				<div class="toltip-text">
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing. Donec odio.</p>
				</div>
				<div class="toltip-close-details">
					<a href="javascript:void(0);" class="close-this">Close</a>
					<a href="javascript:void(0);">Details</a>
				</div>
			</div>
			<div class="toltip-item toltip-overlay d-flex mb-2">
				<div class="toltip-image">
					<img src="/o/ahea-theme/images/recom-img-3.jpg" width="48">
				</div>
				<div class="toltip-text">
					<p>Lorem ipsum dolor sit amet, adipiscing. Donec odio.</p>
				</div>
				<div class="toltip-close-details">
					<a href="javascript:void(0);" class="close-this">Close</a>
					<a href="javascript:void(0);">Details</a>
				</div>
			</div>
		</div>
	</div> 
	 <div class="top-icon icon-3">
		<a href="javascript:void(0);">
			<img src="/o/ahea-theme/images/svg/Envelope-Icon-1.svg" width="40" alt="">
			<span class="note">
				<span class="outer">3</span>
			</span>
		</a>
	</div> -->
	
	<div class="top-icon icon-1 top-icon-badges">
		<!-- <a href="javascript:void(0);" id="btn-badges"> -->
		<!-- <a href="javascript:void(0);" data-toggle="modal" data-target="#badgesModal">
			<img src="/o/ahea-theme/images/svg/Badges-Icon-1.svg" width="50" alt="">
			<span class="note">
				<span class="outer">1</span>
			</span>
		</a> -->
		
		<div class="btn-group btn-group-menu">
			<a href="javascript:void(0);" type="button" class="top-icon-fa top-icon-award disabled" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<span class="note">
					<span class="outer">1</span>
				</span>
			</a>
			<div class="dropdown-menu">
				<div class="toltip toltip-overlay p-3">
					<div class="toltip-header">
						<div class="toltip-title icon-fa-box icon-award pl-4">
							Badges
						</div>
						<div class="toltip-close">
							<a href="javascript:void(0);" data-dismiss="modal"><i class="fa fa-times-circle"></i></a>
						</div>
					</div>
					<div class="toltip-body text-center">
						<div class="wrap-icon">
							<i class="fad fa-chart-network icon-size-120 mt-3 mb-3" style="color:#6C389B;"></i>
						</div>
						<p>Congratulations! You Earned a Networking Badge.</p>
					</div>
					<div class="toltip-footer text-center">
						<a href="javascript:void(0);" class="btn btn-blue m-auto">View More</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="top-icon icon-2">
		<!-- <a id="btn-notification" href="javascript:void(0);"> -->
		<!-- <a href="javascript:void(0);" data-toggle="modal" data-target="#notificationModal">
				<img class="this-img" src="/o/ahea-theme/images/svg/Bell-Icon-1.svg" width="45" alt="">
				<span class="note">
					<span id="notifyCount" class="outer">5</span>
				</span>
			</a> -->
		<div class="btn-group btn-group-menu">
			<a href="javascript:void(0);" class="top-icon-fa top-icon-bell" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<span class="note">
					<span id="notifyCount" class="outer">5</span>
				</span>
			</a>
			<div class="dropdown-menu">
				<div id="notification-toltip" class="toltip any-toltip">
				
				</div>
			</div>
		</div>
	</div>
	<div class="top-icon icon-3 top-icon-message">
		<!-- <a id="btn-email" href="javascript:void(0);"> -->
		<!-- <a href="javascript:void(0);" data-toggle="modal" data-target="#messagesModal">
			<i class="far fa-comment" style="font-size: 40px;"></i>
			<span class="note">
				<span class="outer">3</span>
			</span>
		</a> -->
		
		<div class="btn-group btn-group-menu">
			<a href="javascript:void(0);" class="top-icon-fa top-icon-comment msgview" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<span class="note">
					<span id="messageCount" class="outer">3</span>
				</span>
			</a>
			<div class="dropdown-menu">
				<div id="email-toltip" class="toltip messagecontent">
					<div class="toltip-body">
						
					</div>
				</div>
			</div>
		</div>
		
	</div>

	<div class="top-icon hello">
		<div class="btn-group btn-group-menu show">
			<!-- <a href="javascript:void(0);"  id="btn-user" class="btn-menu"> -->
			<%-- <a href="javascript:void(0);" data-toggle="modal" data-target="#userModal" class="btn-menu">
				<img class="img-circle img-border-blue" src="<%=themeDisplay.getUser().getPortraitURL(themeDisplay) %>" alt="">
				<img class="img-circle" src="<%=themeDisplay.getUser().getPortraitURL(themeDisplay) %>" alt="">
				Hello, <%=themeDisplay.getUser().getFullName() %>
			</a> --%>
			<a href="javascript:void(0);" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn-menu">
				<img class="img-circle" src="<%=imgSRC %>" alt="">
				Hello, <%=themeDisplay.getUser().getFirstName() %>
			</a>
			<div class="dropdown-menu p-0">
				<div id="user-toltip" class="toltip menu-toltip toltip-overlay">
					<ul>
						<li><a href="" onclick='goToMyProfile(<%=themeDisplay.getUserId() %>)'>My Profile</a></li>
						<li><a href="javascript:void(0);">Settings & Privacy</a></li>
						<li><a href="javascript:void(0);" id="btn-sign-out" data-toggle="modal" data-target="#signOutModal">Sign Out</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- <div class="top-icon top-button">
		<a href="javascript:void(0);" class="btn btn-blue">Tour <i class="fas fa-forward"></i></a>
	</div> -->
	<div class="wrap-top-search">
		<div class="top-search">
			<!-- <a href="javascript:void(0);" class="btn btn-blue btn-w-100 mr-2 returnToResult d-none">Return to Results</a> -->
			<div class="box-search">
				<form action="">
					<input type="text" placeholder="Search">
					<button type="submit"><i class="fas fa-search"></i></button>
				</form>
			</div>
			<div class="box-question">
				<a href="javascript:void(0);"><img src="/o/ahea-theme/images/search-icon.png" width="38"></a>
			</div>
		</div>
		<%-- <% if(currentUrl.contains("lab-screen-v2") || currentUrl.contains("lab-detailed-screen")){ %>
			<a href="/home1" id="submitForReview" class="btn btn-grey btn-w-100 ml-3 ">Submit for Review <i class="far fa-arrow-alt-circle-right"></i></a>
		<% } %> --%>
		<a href="javascript:void(0)" id="submitForReview" class="btn btn-grey btn-w-100 ml-3 " >Submit for Review <i class="far fa-arrow-alt-circle-right"></i></a>
		<!-- <div class="top-text">
			<p>Looking for an academic collaborator? <a href="javascript:void(0);">Click Here</a>.</p>
		</div> -->
	</div>
	<!-- <div class="top-text returnToResult d-none">
		<p>Looking for an academic collaborator? <a href="javascript:void(0);">Click Here</a>.</p>
	</div> -->
	</div>
	<% if(returnURL!=""){ %>
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
		  <li class="breadcrumb-item"><a href="/home1"><!-- <i class="fas fa-home"></i> --> Home</a></li>
		  <li class="breadcrumb-item active" aria-current="page"><%= returnURL %></li>
		</ol>
	</nav>
	<% } %>
</section>

<!-- <div class="" id="onlyEditProfile">
	<div class="col-lg-12 mb-4 mt-3 text-right" style="padding: 0;">
		<a class="btn btn-blue" href="javascript:void(0);">Save Profile</a>
	</div>
</div> -->


<!-- Modal Badges -->
<div class="modal fade modalToltip" id="badgesModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
	  <div class="modal-content">
		<div class="modal-body">
			  <div class="toltip toltip-overlay p-3">
				<div class="toltip-header">
					<div class="toltip-title">
						<img src="/o/ahea-theme/images/svg/Badges-Icon-3.svg" width="25"> Badges
					</div>
					<div class="toltip-close">
						<a href="javascript:void(0);" id="badgesModalClose" data-dismiss="modal"><i class="fa fa-times-circle"></i></a>
					</div>
				</div>
				<div class="toltip-body text-center">
					<div class="wrap-icon">
						<img src="/o/ahea-theme/images/network.svg" alt="" width="125">
					</div>
					<p>Congratulations! You Earned a Networking Badge.</p>
				</div>
				<div class="toltip-footer text-center">
					<a href="javascript:void(0);" class="btn btn-blue m-auto">View More</a>
				</div>
			</div>
		</div>
	  </div>
	</div>
  </div>

  <!-- Modal Notifications -->
  <div class="modal fade modalToltip" id="notificationModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
	  <div class="modal-content">
		<div class="modal-body">
			  <!-- <div id="notification-toltip" class="toltip any-toltip"> -->
				<!-- <div class="toltip-item toltip-overlay d-flex">
					<div class="toltip-image">
						<img src="/o/ahea-theme/images/randy.png" width="48">
					</div>
					<div class="toltip-text">
						<p>Randy Wolff uploaded a document in What Artificial Intelligence Can Do for Small Business project </p>
					</div>
				</div>
				<div class="toltip-item toltip-overlay d-flex">
					<div class="toltip-icon toltip-icon-green">
						<i class="fa fa-users" aria-hidden="true"></i>
					</div>
					<div class="toltip-text">
						<p>Karthic Koothrappali, Joanne Byrne and others have matched with you as suggested partners </p>
					</div>
				</div>
				<div class="toltip-item toltip-overlay d-flex">
					<div class="toltip-image">
						<img src="/o/ahea-theme/images/Inez.png" width="48">
					</div>
					<div class="toltip-text">
						<p>Inez Campos was added to the Ethics in Multinational Management project </p>
					</div>
				</div>
				<div class="toltip-item toltip-overlay d-flex">
					<div class="toltip-icon toltip-icon-blue">
						<i class="fas fa-bullhorn" aria-hidden="true"></i>
					</div>
					<div class="toltip-text">
						<p>Register today for the International Conference on Big Data in Business </p>
					</div>
				</div>
				<div class="toltip-item toltip-overlay d-flex">
					<div class="toltip-image">
						<img src="/o/ahea-theme/images/Li.png" width="48">
					</div>
					<div class="toltip-text">
						<p>Missed call from Li Wei </p>
					</div>
				</div> -->
			<!-- </div> -->
		</div>
	  </div>
	</div>
  </div>


  <!-- Modal Messages -->
  <div class="modal fade modalToltip" id="messagesModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
	  <div class="modal-content">
		<div class="modal-body">
			 <div id="email-toltip" class="toltip any-toltip">
				<div class="toltip-item d-flex position-relative p-0 toltip-overlay border-radius-5">
					<div class="status-email"></div>
					<div class="toltip-text p-2 pl-4 w-100">
						<div class="toltip-header">
							<div class="toltip-header-left p0">
								<p>Clinton Harris</p>
							</div>
							<div class="toltip-header-right text-right p0">
								<p>9:08 PM </p>
							</div>
						</div>
						<div class="toltip-subhead p0">
							<p>Welcome to AHEA</p>
						</div>
						<div class="toltip-content p0">
							<p>We’re so glad you are taking advantage of the benefits of AHEA membership.  Enclosed please find…</p>
						</div>
					</div>
				</div>
				<div class="toltip-item d-flex position-relative p-0 toltip-overlay border-radius-5">
					<div class="status-email"></div>
					<div class="toltip-text p-2 pl-4 w-100">
						<div class="toltip-header">
							<div class="toltip-header-left p0">
								<p>Clinton Harris</p>
							</div>
							<div class="toltip-header-right text-right p0">
								<p>4:12 PM </p>
							</div>
						</div>
						<div class="toltip-subhead p0">
							<p>Your syllabus is available.</p>
						</div>
						<div class="toltip-content p0">
							<p>Your syllabus template for the global business course is currently attached for review.</p>
						</div>
					</div>
				</div>
				<div class="toltip-item d-flex position-relative p-0 toltip-overlay border-radius-5">
					<div class="status-email"></div>
					<div class="toltip-text p-2 pl-4 w-100">
						<div class="toltip-header">
							<div class="toltip-header-left p0">
								<p>Inez Campos </p>
							</div>
							<div class="toltip-header-right text-right p0">
								<p>2:23 PM </p>
							</div>
						</div>
						<div class="toltip-subhead p0">
							<p>Academic Paper</p>
						</div>
						<div class="toltip-content p0">
							<p>Hello Bradley. I found an academic paper that would support our collaboration – relatively new and incorporates the cloud. </p>
						</div>
					</div>
				</div>
				<div class="toltip-item d-flex position-relative p-0 toltip-overlay border-radius-5">
					<div class="toltip-text p-2 pl-4 w-100">
						<div class="toltip-header">
							<div class="toltip-header-left p0">
								<p>Brittany Simms</p>
							</div>
							<div class="toltip-header-right text-right p0">
								<p>11:46 PM </p>
							</div>
						</div>
						<div class="toltip-subhead p0">
							<p>Chapter 1 Questions</p>
						</div>
						<div class="toltip-content p0">
							<p>Hi Dr. Dexter – Chapter 1 has me wondering about the implications of regulations globally as well.</p>
						</div>
					</div>
				</div>
				<div class="toltip-item d-flex position-relative p-0 toltip-overlay border-radius-5">
					<div class="toltip-text p-2 pl-4 w-100">
						<div class="toltip-header">
							<div class="toltip-header-left p0">
								<p>Inez Campos </p>
							</div>
							<div class="toltip-header-right text-right p0">
								<p>8:59 PM </p>
							</div>
						</div>
						<div class="toltip-subhead p0">
							<p>Review Questions</p>
						</div>
						<div class="toltip-content p0">
							<p>Hello Bradley.  Looking forward to consolidating our review questions into a central area.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	  </div>
	</div>
  </div>

  <!-- Modal Messages -->
  <div class="modal fade modalToltip" id="userModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
	  <div class="modal-content">
		<div class="modal-body">
			  <div id="user-toltip" class="toltip menu-toltip toltip-overlay any-toltip">
				<ul>
					<li><a href="" onclick='goToMyProfile(<%=themeDisplay.getUserId() %>)'>My Profile</a></li>
					<li><a href="javascript:void(0);">Settings & Privacy</a></li>
					<li><a href="javascript:void(0);" id="btn-sign-out" data-toggle="modal" data-target="#signOutModal">Sign Out</a></li>
				</ul>
			</div>
		</div>
	  </div>
	</div>
  </div>
  
 <!-- Modal confirmation Message -->
<div class="modal fade modalToltip modalareainterest" id="confirmationMessage" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
	  <div id="modalCourseSummaryContent" class="modal-content">
	  	<div class="modal-header position-relative text-center">
			<div class="text-left font15 m-auto">
				<strong>Confirmation Message</strong> 
			</div> 
		</div>
		<div class='modal-body'> 
			<div class='interest-modal text-center'>
				<p class="text-white">Are you sure you want to submit?</p>
				<button value='Cancel' class='btn btn-grey mr-2' data-dismiss='modal'>Cancel</button>
					<a href="/home1?project=approved" id="moveToDashboard" class='btn btn-blue'>Ok</a>
			</div>
		</div>
	   </div>
	</div>
</div>

<!-- Modal confirmation Message -->
<div class="modal fade modalToltip modalareainterest" id="submitedForApproval" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
	  <div id="modalCourseSummaryContent" class="modal-content">
	  	<div class="modal-header position-relative text-center">
			<div class="text-left font15 m-auto">
				<strong></strong> 
			</div> 
		</div>
		<div class='modal-body'> 
			<div class='interest-modal'>
				<p class="text-white text-center">Submitted For Approval</p>
				<div class="text-right">
					<button value='Cancel' class='btn btn-blue' data-dismiss='modal'>Ok</button>
				</div>
			</div>
		</div>
	   </div>
	</div>
</div>