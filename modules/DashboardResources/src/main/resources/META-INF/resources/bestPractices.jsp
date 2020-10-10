<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@ include file="/init.jsp" %>
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="bradley home screen.html">Home</a></li>
        <li class="breadcrumb-item" aria-current="page"><a href="/resources">Resources</a></li>
        <li class="breadcrumb-item active" aria-current="page"><a href="#">Best Practices & How-To Guides</a></li>
    </ol>
</nav>
<section class="wrap-best-practices">
    <div class="row row-custom sortable">
        <div class="col-lg-4 mb-4">
            <div class="resources box box-border-radius box-shadow bg-white position-relative">
            	<!-- Loader -->
				<div class="Resources sectionloader"> 
					<div class="loader"></div>
				</div>
                <div class="inner-wrap">
                    <div class="box-top position-relative">
                        <h2 class="box-subhead">
                        	<span class="icon-regular icon-pen"></span>
                        	<a href="#" class="color-black hover-underline color-blue-light-hover">Write</a>
                        </h2>
                    </div>
                </div>
                <div class="box-middle list-bullet">
                    <ul>
                        <li><a href="#" id="generalPublication">Author a General Publication</a></li>
                        <li><a href="#" id="academicJournal">Author an Academic Journal</a></li>
                        <li><a href="#" id="writingProject">Join a Writing Project</a></li>
                        <li><a href="#" id="createBestPractices">Create Best Practices</a></li>
                        <li><a href="#" id="academivWritingStyle">Hone Your Academic Writing Style</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-lg-4 mb-4">
            <div class="resources box box-border-radius box-shadow bg-white position-relative">
            	<!-- Loader -->
				<div class="Resources sectionloader"> 
					<div class="loader"></div>
				</div>
                <div class="inner-wrap">
                    <div class="box-top position-relative">
                        <h2 class="box-subhead">
                        	<span class="icon-solid icon-compress-arrows-alt"></span>
                        	<a href="#" class="color-black hover-underline color-blue-light-hover">Develop</a>
                        </h2>
                    </div>
                </div>
                <div class="box-middle list-bullet">
                    <ul>
                        <li><a href="#" id="courseDevelopmentBeginners">Course Development for Beginners</a></li>
                        <li><a href="#" id="createCoursewithPeers">Create a Course with Peers</a></li>
                        <li><a href="#" id="createStudyAbroadProgram">Create a Study Abroad Program</a></li>
                        <li><a href="#" id="becomeProgramLeader">Become a Study Abroad Program Leader</a></li>
                        <li><a href="#" id="startResearchProject">Start a Research Project</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-lg-4 mb-4">
            <div class="resources box box-border-radius box-shadow bg-white position-relative">
            	<!-- Loader -->
				<div class="Resources sectionloader"> 
					<div class="loader"></div>
				</div>
                <div class="inner-wrap">
                    <div class="box-top position-relative">
                        <h2 class="box-subhead">
                        	<span class="icon-regular icon-comment-alt-smile"></span>
                        	<a href="#" class="color-black hover-underline color-blue-light-hover">Engage</a>
                        </h2>
                    </div>
                </div>
                <div class="box-middle list-bullet">
                    <ul>
                        <li><a href="#" id="influentialMentor">Be an Influential Mentor</a></li>
                        <li><a href="#" id="findMentor">Find a Mentor</a></li>
                        <li><a href="#" id="initiatePeerReview">Initiate a Peer Review</a></li>
                        <li><a href="#" id="participatePeerReview">Participate in a Peer Review</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>

<script>
$(document).ready(function(){
	getDetails();
});
function getDetails(){
	$.ajax({
		url:'<%=PropsUtil.get("GLOBAL_API_URL") %>'+"api/get_documents/bestPractices",
		type: "get",
		dataType: "json",
		contentType:"application/json",
		success: function(data){
		debugger;
			if(data!=null && data!=undefined && data!="undefined" && data!="null"){	
				if(data.generalPublication!=null && data.generalPublication!="" && data.generalPublication!=undefined){
					$("#generalPublication").attr("href",data.generalPublication);
				}
				if(data.academicJournal!=null && data.academicJournal!="" && data.academicJournal!=undefined){
					$("#academicJournal").attr("href",data.academicJournal);
				}
				if(data.writingProject!=null && data.writingProject!="" && data.writingProject!=undefined){
					$("#writingProject").attr("href",data.writingProject);
				}
				if(data.createBestPractices!=null && data.createBestPractices!="" && data.createBestPractices!=undefined){
					$("#createBestPractices").attr("href",data.createBestPractices);
				}
				if(data.academivWritingStyle!=null && data.academivWritingStyle!="" && data.academivWritingStyle!=undefined){
					$("#academivWritingStyle").attr("href",data.academivWritingStyle);
				}
				if(data.courseDevelopmentBeginners!=null && data.courseDevelopmentBeginners!="" && data.courseDevelopmentBeginners!=undefined){
					$("#courseDevelopmentBeginners").attr("href",data.courseDevelopmentBeginners);
				}
				if(data.createCoursewithPeers!=null && data.createCoursewithPeers!="" && data.createCoursewithPeers!=undefined){
					$("#createCoursewithPeers").attr("href",data.createCoursewithPeers);
				}
				if(data.createStudyAbroadProgram!=null && data.createStudyAbroadProgram!="" && data.createStudyAbroadProgram!=undefined){
					$("#createStudyAbroadProgram").attr("href",data.createStudyAbroadProgram);
				}
				if(data.becomeProgramLeader!=null && data.becomeProgramLeader!="" && data.becomeProgramLeader!=undefined){
					$("#becomeProgramLeader").attr("href",data.becomeProgramLeader);
				}
				if(data.startResearchProject!=null && data.startResearchProject!="" && data.startResearchProject!=undefined){
					$("#startResearchProject").attr("href",data.startResearchProject);
				}
				if(data.influentialMentor!=null && data.influentialMentor!="" && data.influentialMentor!=undefined){
					$("#influentialMentor").attr("href",data.influentialMentor);
				}
				if(data.findMentor!=null && data.findMentor!="" && data.findMentor!=undefined){
					$("#findMentor").attr("href",data.findMentor);
				}
				if(data.initiatePeerReview!=null && data.initiatePeerReview!="" && data.initiatePeerReview!=undefined){
					$("#initiatePeerReview").attr("href",data.initiatePeerReview);
				}
				if(data.participatePeerReview!=null && data.participatePeerReview!="" && data.participatePeerReview!=undefined){
					$("#participatePeerReview").attr("href",data.participatePeerReview);
				}
			}	
		}
	});
}

</script>