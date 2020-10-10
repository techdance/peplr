<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@ include file="/init.jsp" %>

<nav aria-label="breadcrumb">
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="#">Home</a></li>
		<li class="breadcrumb-item"><a href="/resources">Resources</a></li>
		<li class="breadcrumb-item active" aria-current="page">Getting Started</li>
	</ol>
</nav>
<section class="wrap-best-practices">
	<div class="row row-custom sortable">
		<div class="col-lg-4 mb-4">
			<div class="resources box box-border-radius box-shadow bg-white">
				<!-- Loader -->
				<div class="ResourcesLoader sectionloader"> 
					<div class="loader"></div>
				</div>
				<div class="inner-wrap">
					<div class="box-top position-relative">
						<h2 class="box-subhead"><span class="icon-regular icon-user-plus"></span><a href="#" class="color-black hover-underline color-blue-light-hover">Collaboration</a></h2>
					</div>
				</div>
				<div class="box-middle list-bullet">
					<ul>
						<li><a href="#" id="add_interest">Add an Interest and View Matches</a></li>
					</ul>
				</div>
			</div>
		</div><!--col-lg-4-->
		<div class="col-lg-4 mb-4">
			<div class="resources box box-border-radius box-shadow bg-white">
				<!-- Loader -->
				<div class="ResourcesLoader sectionloader"> 
					<div class="loader"></div>
				</div>
				<div class="inner-wrap">
					<div class="box-top position-relative">
						<h2 class="box-subhead"><span class="icon-regular icon-user-profile"></span><a href="#" class="color-black hover-underline color-blue-light-hover">Profile</a></h2>
					</div>
				</div>
				<div class="box-middle list-bullet">
					<ul>
						<li><a href="#" id="edit_faculty">Edit Faculty Profile</a></li>
						<li><a href="#" id="intro_video">Create Introduction Video for Collaboration</a></li>
					</ul>
				</div>
			</div>
		</div><!--col-lg-4-->
		<div class="col-lg-4 mb-4">
			<div class="resources box box-border-radius box-shadow bg-white">
				<!-- Loader -->
				<div class="ResourcesLoader sectionloader"> 
					<div class="loader"></div>
				</div>
				<div class="inner-wrap">
					<div class="box-top position-relative">
						<h2 class="box-subhead"><span class="icon-regular icon-bullhorn"></span><a href="#" class="color-black hover-underline color-blue-light-hover">Announcement</a></h2>
					</div>
				</div>
				<div class="box-middle list-bullet">
					<ul>
						<li><a href="#" id="event_request">Submit an Announcement or Event Request</a></li>
					</ul>
				</div>
			</div>
		</div><!--col-lg-4-->
		<div class="col-lg-4 mb-4">
			<div class="resources box box-border-radius box-shadow bg-white">
				<!-- Loader -->
				<div class="ResourcesLoader sectionloader"> 
					<div class="loader"></div>
				</div>
				<div class="inner-wrap">
					<div class="box-top position-relative">
						<h2 class="box-subhead"><span class="icon-regular icon-book-spells"></span><a href="#" class="color-black hover-underline color-blue-light-hover">Courses</a></h2>
					</div>
				</div>
				<div class="box-middle list-bullet">
					<ul>
						<li><a href="#" id="course_intro">Create Instructor and Course Introduction Videos</a></li>
					</ul>
				</div>
			</div>
		</div><!--col-lg-4-->
		<div class="col-lg-4 mb-4">
			<div class="resources box box-border-radius box-shadow bg-white">
				<!-- Loader -->
				<div class="ResourcesLoader sectionloader"> 
					<div class="loader"></div>
				</div>
				<div class="inner-wrap">
					<div class="box-top position-relative">
						<h2 class="box-subhead"><span class="icon-regular icon-th-large"></span><a href="#" class="color-black hover-underline color-blue-light-hover">Resources</a></h2>
					</div>
				</div>
				<div class="box-middle list-bullet">
					<ul>
						<li><a href="#" id="access_guides">Access Guides, Templates, and Best Practices</a></li>
					</ul>
				</div>
			</div>
		</div><!--col-lg-4-->
	</div><!-- row -->
</section>


<script>
$(document).ready(function(){
	getDetails();
});
function getDetails(){
	$.ajax({
		url:'<%=PropsUtil.get("GLOBAL_API_URL") %>'+"api/get_documents/gettingStarted",
		type: "get",
		dataType: "json",
		contentType:"application/json",
		success: function(data){
		debugger;
			if(data!=null && data!=undefined && data!="undefined" && data!="null"){	
				if(data.addInterestViewMatches!=null && data.addInterestViewMatches!="" && data.addInterestViewMatches!=undefined){
					$("#add_interest").attr("href",data.addInterestViewMatches);
				}
				if(data.editFacultyProfile!=null && data.editFacultyProfile!="" && data.editFacultyProfile!=undefined){
					$("#edit_faculty").attr("href",data.editFacultyProfile);
				}
				if(data.introductionVideCollaboration!=null && data.introductionVideCollaboration!="" && data.introductionVideCollaboration!=undefined){
					$("#intro_video").attr("href",data.introductionVideCollaboration);
				}
				if(data.announcementEventRequest!=null && data.announcementEventRequest!="" && data.announcementEventRequest!=undefined){
					$("#event_request").attr("href",data.announcementEventRequest);
				}
				if(data.instructorCourseIntroduction!=null && data.instructorCourseIntroduction!="" && data.instructorCourseIntroduction!=undefined){
					$("#course_intro").attr("href",data.instructorCourseIntroduction);
				}
				if(data.accessGuides!=null && data.accessGuides!="" && data.accessGuides!=undefined){
					$("#access_guides").attr("href",data.accessGuides);
				}
			}	
		}
	});
}

</script>