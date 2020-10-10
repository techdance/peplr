<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@ include file="/init.jsp" %>

<nav aria-label="breadcrumb">
	<ol class="breadcrumb">
	  <li class="breadcrumb-item"><a href="#">Home</a></li>
	  <li class="breadcrumb-item"><a href="/resources">Resources</a></li>
	  <li class="breadcrumb-item active" aria-current="page">Templates</li>
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
						<h2 class="box-subhead mw-100"><span class="icon-regular icon-book-spells"></span><a href="#" class="color-black hover-underline color-blue-light-hover">Course Development</a></h2>
					</div>
				</div>
				<div class="box-middle list-bullet">
					<ul>
						<li><a href="#" id="courseControlDocument">AHEA Course Control Document</a></li>												
						<li><a href="#" id="syllabus">AHEA Syllabus</a></li>
						<li><a href="#" id="courseIntroMgmt">AHEA Course - Intro Business Mgmt</a></li>
						<li><a href="#" id="syllabusIntroMgmt">AHEA Syllabus - Intro Business Mgmt</a></li>
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
						<h2 class="box-subhead"><span class="icon-regular icon-plane-alt"></span><a href="#" class="color-black hover-underline color-blue-light-hover">Study Abroad</a></h2>
					</div>
				</div>
				<div class="box-middle list-bullet">
					<ul>
						<li><a href="#" id="healthForm">Health Form</a></li>
						<li><a href="#" id="parentGuide">Parent Guide</a></li>
						<li><a href="#" id="programFactSheet">Program Fact Sheet</a></li>
						<li><a href="#" id="studyAbroadPackingChecklist">Study Abroad Packing Checklist</a></li>
						<li><a href="#" id="studyAbroadPreDepartureChecklist">Study Abroad Pre-Departure Checklist</a></li>
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
		url:'<%=PropsUtil.get("GLOBAL_API_URL") %>'+"api/get_documents/templates",
		type: "get",
		dataType: "json",
		contentType:"application/json",
		success: function(data){
		debugger;
			if(data!=null && data!=undefined && data!="undefined" && data!="null"){	
				if(data.courseControlDocument!=null && data.courseControlDocument!="" && data.courseControlDocument!=undefined){
					$("#courseControlDocument").attr("href",data.courseControlDocument);
				}
				if(data.syllabus!=null && data.syllabus!="" && data.syllabus!=undefined){
					$("#syllabus").attr("href",data.syllabus);
				}
				if(data.courseIntroMgmt!=null && data.courseIntroMgmt!="" && data.courseIntroMgmt!=undefined){
					$("#courseIntroMgmt").attr("href",data.courseIntroMgmt);
				}
				if(data.syllabusIntroMgmt!=null && data.syllabusIntroMgmt!="" && data.syllabusIntroMgmt!=undefined){
					$("#syllabusIntroMgmt").attr("href",data.syllabusIntroMgmt);
				}
				if(data.healthForm!=null && data.healthForm!="" && data.healthForm!=undefined){
					$("#healthForm").attr("href",data.healthForm);
				}
				if(data.parentGuide!=null && data.parentGuide!="" && data.parentGuide!=undefined){
					$("#parentGuide").attr("href",data.parentGuide);
				}
				if(data.programFactSheet!=null && data.programFactSheet!="" && data.programFactSheet!=undefined){
					$("#programFactSheet").attr("href",data.programFactSheet);
				}
				if(data.studyAbroadPackingChecklist!=null && data.studyAbroadPackingChecklist!="" && data.studyAbroadPackingChecklist!=undefined){
					$("#studyAbroadPackingChecklist").attr("href",data.studyAbroadPackingChecklist);
				}
				if(data.studyAbroadPreDepartureChecklist!=null && data.studyAbroadPreDepartureChecklist!="" && data.studyAbroadPreDepartureChecklist!=undefined){
					$("#studyAbroadPreDepartureChecklist").attr("href",data.studyAbroadPreDepartureChecklist);
				}
			}	
		}
	});
}
</script>