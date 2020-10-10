<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="javax.portlet.PortletResponse"%>
<%@page import="com.liferay.portal.kernel.service.PortletLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Portlet"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page import="com.collaborated.entity.service.labScreenProjectOverviewLocalServiceUtil"%>
<%@page import="com.collaborated.entity.model.labScreenProjectOverview"%>
<%@page import="javax.portlet.PortletSession"%>

<!-- FlexSlider -->

<link rel="stylesheet" href="/o/ahea-theme/css/flexslider.css" type="text/css" media="screen" />
<script defer src="/o/ahea-theme/js/jquery.flexslider.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/0.2.0/Chart.min.js"></script>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<portlet:resourceURL var="courseIdentificationAddEdit" id="courseIdentificationAddEdit"></portlet:resourceURL>
<portlet:resourceURL var="courseHoursAddEdit" id="courseHoursAddEdit"></portlet:resourceURL>
<portlet:resourceURL var="courseResourcesAddEdit" id="courseResourcesAddEdit"></portlet:resourceURL>
<portlet:resourceURL var="courseInstructorQualificationAddEdit" id="courseInstructorQualificationAddEdit"></portlet:resourceURL>
<portlet:resourceURL var="courseSummaryAddEdit" id="courseSummaryAddEdit"></portlet:resourceURL>

<style>
#submitForReview {
	display: block !important;
}
.box-top.w-btn {
	margin-bottom: 30px;
}
.icon-setting.icon-box .btn {
	font-family: 'Merriweather Sans', sans-serif;
}
#donut1 .text {
	color: rgb(0, 0, 0);
    font-size: 31.1111px;
    font-family: "Merriweather Sans";
    letter-spacing: -4px;
}
.modalToltip .modal-dialog, .modalToltip .modal-body, .modalToltip .modal-content {
    background: none;
    border: none;
    padding: 0px;
}
/*.modal-dialog {
    position: initial !important;
}*/
.portlet-dropzone .box {
    height: auto;
}
.mb-7 {
    margin-bottom: 2.5rem !important;
}
.color-orange {
    color: #ff993f !important;
}
.wrap-course-information{
	border:1px solid #c0c0c0;
	border-radius:5px;
	-webkit-border-radius:5px;
	-moz-border-radius:5px;
	-ms-border-radius:5px;
	-o-border-radius:5px;

	padding:25px 20px;
}
.course-information-define{
	background:#1087ca;
	border-radius: 5px;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	-ms-border-radius: 5px;
	-o-border-radius: 5px;
	color:white;
	/* font-size:18px; */
	font-weight: bold;
	padding:10px 15px;
}
.btn-grey {
    background: #989899;
}
.table-border {
    box-shadow: 0 0 0 1px #ebebeb;
}
.th-bg th {
	background:#daeefa !important;
}
.table-border-radius{
	border-radius: 5px !important;
	-webkit-border-radius: 5px !important;
	-moz-border-radius: 5px !important;
	-ms-border-radius: 5px !important;
	-o-border-radius: 5px !important;

	overflow: hidden !important;
}

.table.table-color-black  td{
	color:#000 !important;
}
.table-tbody-tr-border-bottom tbody tr{
	border-bottom: 1px solid #ebebeb;
}
#step-3 .table-tbody-tr-border-bottom tbody tr{
	border-color: transparent;
}
.td-nothover tbody tr:hover{
	background: none !important;
}
.table-border{
	box-shadow: 0 0 0 1px #ebebeb;
}
.vertical-align-top{
	vertical-align: top !important;
}
.w-60px{
	width: 60px !important;
}
#CourseInfo .nav-tabs a.active,
#CourseInfo .nav-tabs a.step-complete {
	color: #fff;
}
#CourseInfo .nav-tabs a {
	color: #2c2929;
}
#CourseInfo .nav-tabs a[disabled] {
    pointer-events: none;
}
#CourseInfo .nav-tabs a:not(.step-complete) i {
	display: none;
}
#CourseInfo .nav-tabs a:hover,
#CourseInfo .nav-tabs a.active,
#CourseInfo .nav-tabs a.active:hover,
#CourseInfo .nav-tabs a.active:focus {
    border: 0;
}
#CourseInfo .nav-tabs a:first-child {
    background: url(/o/ahea-theme/images/button-lead-one.png) no-repeat;
}
#CourseInfo .nav-tabs a.active:first-child {
    background: url(/o/ahea-theme/images/button-blue-hover.png) no-repeat;
}
#CourseInfo .nav-tabs a.active:not(:first-child):not(:last-child) {
    background: url(/o/ahea-theme/images/button-blue.png) no-repeat;
}
#CourseInfo .nav-tabs a.step-complete:not(:first-child):not(:last-child) {
    background: url(/o/ahea-theme/images/button-green-2.png) no-repeat;
}
#CourseInfo .nav-tabs a.step-complete:first-child {
    background: url(/o/ahea-theme/images/button-green.png) no-repeat;
}
#CourseInfo .nav-tabs a.active:last-child,
#CourseInfo .nav-tabs a.step-complete:last-child {
    background: url(/o/ahea-theme/images/button-green-3.png) no-repeat;
}
#CourseInfo .nav-tabs a.active:last-child i,
#CourseInfo .nav-tabs a.step-complete:last-child i {
	display: inline-block!important;
}
#submitModal .modal-content {
	background: transparent;
	border:none;
}
.modal-backdrop.show {
    opacity: .5;
}
#submitModal .modal-body{
	color:white;
	font-size:24px;
	text-align:center;
}
#submitModal .modal-dialog {
	max-width: 850px;
	position: relative;
}
#submitModal{
	margin-top:100px;
}
.wrap-top-search {
    display: flex;
    align-items: center;
}
.courseInfoModal.modalareainterest .modal-dialog, 
.courseInfoModal.modalareainterest .modal-content {
	max-width: 800px;
	position: relative;
}
.courseInfoModal.modalareainterest .form-group {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 15px;
}
/* .modalareainterest .form-group .control-label,
.modalareainterest div {
    color: #000!important;
} */
.courseInfoModal.modalareainterest .form-group .form-control {
    padding: 0px;
    max-width: inherit;
    min-width: auto;
    width: 100%;
    max-width: 100%;
    height: 27px;
    border-radius: 0;
}
.courseInfoModal.modalareainterest .form-group textarea.form-control {
	height: 55px;
}
.courseInfoModal.modalareainterest .form-group .form-control[type='number'] {
	width: 60px;
	max-width: inherit;
}
.courseInfoModal.modalareainterest .form-group .form-control[input='number'] {
	width: 60px;
}
.courseInfoModal.modalareainterest .form-group.has-error .help-block {
    position: absolute;
    bottom: -25px;
}
.courseInfoModal .text-right {
	float: none!important;
}
@media (min-width: 1200px) {
	#modalWeek.modal .modal-dialog, 
	#modalWeek.modal .modal-content {
		max-width: 1100px;
		min-width: 1100px;
	}
}
.modal-activity-table .course-box {
    background: white;
    height: 100%;
    padding: 15px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
}
.modal-activity-table .courses-box-content {
    position: relative;
    padding-left: 25px;
}
.modal-activity-table .course-box .btn-remove {
    position: absolute;
    left: 0px;
    top: 0px;
}
.courses-box-content p {
	line-height: 1.5;
}
#modalWeek.modal .flex-control-paging {
    /* display: none; */
    opacity: 0;
    visibility: hidden;
}
#modalWeek.modal .flex-direction-nav a:before {
	line-height: 2;
}

@media (min-width: 992px) {
#modalCourseDesign .modal-dialog, 
#modalCourseDesign .modal-content,
#openCourseSummary .modal-dialog, 
#openCourseSummary .modal-content {
	min-width: 800px !important;
	max-width: 800px !important;
}
}
#modalCourseDesign h5 {
	font-size: 1.25rem;
}
#modalCourseDesign p {
	line-height: 1.5;
}
#modalCourseDesign ol.pl-15 {
	padding-left: 20px;
}
#openCourseSummary .interest-modal {
	max-height: calc(100vh - 100px);
    overflow: auto;
}
#openCourseSummary .text-right {
	float: none;
}
.btn-green {
    background-color: #03941F;
}
#weekPopup .toltip-close {
    top: 10px;
    right: 15px;
}
#weekPopup .toltip-close a {
	color: #333!important;
}
.editCourseDesign.enableEdit span {
	display: none;
}
.editCourseDesign:not(.enableEdit) input {
	display: none;
}
.editCourseDesign.enableEdit .form-control {
    display: inline-block;
    width: calc(100% - 25px);
}
.table.table3 tr th {
	padding: .75rem !important;
    vertical-align: top;
    border-top: 1px solid #dee2e6;
}
.table.table3 tr th {
    color: black;
    font-size: 20px !important;
    font-weight: bold !important;
    line-height: 32px !important;
    text-align: left;
    text-transform: none;
}
.table.table4 tr {
    border-top: 1px solid #dee2e6;
}
.table.table3 tbody:not(.noHoverColor) tr:hover {
    background: #e8f4ff !important;
}
.table.table3 td {
    color: black;
    font-size: 18px !important;
    font-weight: normal !important;
    line-height: 28px !important;
    text-transform: capitalize;
    text-align: left;
}
.table.table3 td#courseDescription {
	text-transform: none;
}
.table.table3 td#courseDescription:first-letter {
    text-transform: capitalize;
}
#modalWeek h5 {
	font-size: 1.25rem;
}
#modalWeek.modalareainterest div.color-white {
    color: #fff!important;
}

.box-subhead i, .box-subhead span {
    position: absolute;
    left: 0px;
    top: 3px;
}
.icon-binoculars::before {
    content: "\f1e5";
    font-family: 'Font Awesome 5 Regular';
}
[id*="step-"].btn-grey,
#submitForReview:not(.active) {
    pointer-events: none;
}
.table.table3 tr td table tr th.title-row-th.text-center {
    text-align: center!important;
}
#IQTable.table tbody tr td {
	text-transform: none;
}
#IQTable.table tbody tr td:first-letter {
	text-transform: capitalize;
}
.modal-dialog.modal-dialog-centered {
	display: flex;
}
.cl-asset-type-d {
    color: #ff993e;
}
.font20 {
    font-size: 20px !important;
    line-height: 1.5;
}
.cl-hover-black:hover {
    color: #000 !important;
}
.modalareainterest .interest-modal #courseTopicForm .form-group .form-control {
    line-height: 18px;
    border-radius: 0;
    height: auto;
}
</style>

<%
String projectId = "", projectName = "", description = "";long donutPercentage = 0, interestId=0;
boolean editProjectEnable = false;

HttpServletRequest httprequest = PortalUtil.getOriginalServletRequest(request);

HttpSession httpsession = httprequest.getSession();
String sessionProjectID = (String)httpsession.getAttribute("PROJECT_KEY");
String sessionInterestID = (String)httpsession.getAttribute("PROJECT_INTEREST_KEY");
long PK_projectId = new Long(0);
long PK_interestId = new Long(0);
long currentUser = (Long)httpsession.getAttribute("currentUser");		
if(currentUser==themeDisplay.getUserId()){
	PK_projectId = new Long(sessionProjectID);	
	PK_interestId = new Long(sessionInterestID);
}

if(PK_projectId!=0){
	labScreenProjectOverview labScreenProjectOverview = labScreenProjectOverviewLocalServiceUtil.getlabScreenProjectOverview(Long.valueOf(PK_projectId));
	projectName = labScreenProjectOverview.getProjectName();
	description = labScreenProjectOverview.getProjectDescription();
	donutPercentage = labScreenProjectOverview.getPercentage();
	interestId = labScreenProjectOverview.getInterestId();
	if(themeDisplay.getUserId()==labScreenProjectOverview.getProjectOwnerId()){
		editProjectEnable = true;
	}
	//out.println("donutPercentage==="+donutPercentage+"==="+projectId);
}
%>

<script type="text/javascript">
var A=AUI();
var donutPercentage = 0;
$(document).ready(function(){
	
	$("#courseTopics").on("click", function() { debugger;
		$("#modalCourseDesignContent").html("");
		loadCourseTopics();
	});
	$("#courseObjetives").on("click", function() { 
		$("#modalCourseDesignContent").html("");
		loadCourseObjectives();
	});
	$("#learningEnvironment").on("click", function() { 
		$("#modalCourseDesignContent").html("");
		loadCourseLearningEnvironment();
	});
	
	$(".weekPopup").on("click", function(){
		$(".weekTitle").html($(this).attr("data-title"));
		$("#<portlet:namespace/>selectedWeek").val($(this).attr("data-param"));
		$("#<portlet:namespace/>input-dynamic-name").attr("name",'<portlet:namespace/>'+$(this).attr("data-param-name"));
		$("#<portlet:namespace/>selectedParam").val($(this).attr("data-param-name"));
		$("#weekPopup").modal("show");
	});
	
	$("#modalWeek").on('show.bs.modal', function () {
		loadWeekWiseData();
	});
	
	
	
	$("#week1").on("click", function(){
		setTimeout(function(){ 
			$("#flexslider-1 .flex-control-paging li:nth-child(1) a").trigger("click");
		}, 1000);
	});
	$("#week2").on("click", function(){
		setTimeout(function(){ 
			$("#flexslider-1 .flex-control-paging li:nth-child(2) a").trigger("click");
		}, 1000);
	});
	$("#week3").on("click", function(){
		setTimeout(function(){ 
			$("#flexslider-1 .flex-control-paging li:nth-child(3) a").trigger("click");
		}, 1000);
	});
	$("#week4").on("click", function(){
		setTimeout(function(){ 
			$("#flexslider-1 .flex-control-paging li:nth-child(4) a").trigger("click");
		}, 1000);
	})
	
	loadCourseInformation();
	loadCourseIdentification();
	loadCourseTopics();
	loadCourseObjectives();
	loadCourseLearningEnvironment();
	loadProjectPartners();
	loadWeekWiseDataMain();
	
	var url_string = '<%=themeDisplay.getURLPortal()+themeDisplay.getURLCurrent() %>';
	var url = new URL(url_string);
	var milestoneName = url.searchParams.get("milestoneName");
	console.log("milestoneName=="+milestoneName);
	if(milestoneName!="" && milestoneName!=null && milestoneName!="null" && milestoneName!=undefined && milestoneName!="undefined" ){
		$("#"+namespaceId+"milestoneName").val(milestoneName);
		setTimeout(function(){ 
			if(milestoneName === "Course Information") {
		   		$('#CourseInfo .nav-tabs [href="#step-1"]').tab('show');
			}
			if(milestoneName === "Course Design") {
				$("#CourseInfo .nav-tabs #step1").addClass("step-complete"); 
			    $('#CourseInfo .nav-tabs #step2').removeAttr("disabled");
		   		$('#CourseInfo .nav-tabs [href="#step-2"]').tab('show');
			}
			if(milestoneName === "Activity Table") {
				$("#CourseInfo .nav-tabs #step2").addClass("step-complete"); 
			    $('#CourseInfo .nav-tabs #step3').removeAttr("disabled");
		   		$('#CourseInfo .nav-tabs [href="#step-3"]').tab('show');
			}
			if(milestoneName === "Course Summary") {
				$("#CourseInfo .nav-tabs #step3").addClass("step-complete"); 
			    $('#CourseInfo .nav-tabs #step4').removeAttr("disabled");
		   		$('#CourseInfo .nav-tabs [href="#step-4"]').tab('show');
			}
			$("#bradleyLabDetailedScreenLoader").fadeOut();
		}, 3500);
	}
	
});

function numberMax(maxVal) { debugger;
	if(this.value>=maxVal && this.value.length==2){
		this.value='maxVal';
	}else if(this.value<0){
		this.value='0';
	}
}

$(document).on("click", ".editCourseDesign a", function(){
	$(this).parent("li").toggleClass("enableEdit");
	
});

function totalHours(){
	var totalHours = parseInt($("#studyHoursPerWeek").val()) + parseInt($("#numberOfCredits").val()) + parseInt($("#numberOfCourseWeeks").val()) + 
	 parseInt($("#courseHoursPerWeek").val()) + parseInt($("#lectureHoursPerWeek").val()) + parseInt($("#labHoursPerWeek").val());
	$(".totalHoursCal").text(totalHours);
}

/* $(document).on("keyup keydown change", "#studyHoursPerWeek", function(){
	$(".independentHoursCal").text($(this).val()+ " Hours");
	totalHours();
});
$(document).on("keyup keydown change", "#numberOfCredits", function(){
	totalHours();
});
$(document).on("keyup keydown change", "#numberOfCourseWeeks", function(){
	totalHours();
});
$(document).on("keyup keydown change", "#courseHoursPerWeek", function(){
	 $(".contactHoursCal").text($(this).val()+ " Hours");
	 totalHours();
});
$(document).on("keyup keydown change", "#lectureHoursPerWeek", function(){
	totalHours();
});
$(document).on("keyup keydown change", "#labHoursPerWeek", function(){
	totalHours();
}); */


$(document).on("keyup keydown change", "#lectureHoursPerWeek", function(){
	contactHoursPerWeek();
});
$(document).on("keyup keydown change", "#labHoursPerWeek", function(){
	contactHoursPerWeek();
});

function contactHoursPerWeek(){
	var contactHoursPerWeek = parseInt($("#lectureHoursPerWeek").val()) + parseInt($("#labHoursPerWeek").val()) ;
	$("#courseHoursPerWeek").val(contactHoursPerWeek);
	contactHours();
}


$(document).on("keyup keydown change", "#numberOfCourseWeeks", function(){
	contactHours();
	independentStudyHours();
});
$(document).on("keyup keydown change", "#courseHoursPerWeek", function(){
	 contactHours();
});

function contactHours(){
	var contactHours = parseInt($("#courseHoursPerWeek").val()) * parseInt($("#numberOfCourseWeeks").val()) ;
	$(".contactHoursCal").text(contactHours+ " Hours");
	var totalHours = parseInt(contactHours)+parseInt($(".independentHoursCal").text());
	$(".totalHoursCal").text(totalHours);
}

$(document).on("keyup keydown change", "#studyHoursPerWeek", function(){
	independentStudyHours();
});

function independentStudyHours(){
	var independentHours = parseInt($("#studyHoursPerWeek").val()) * parseInt($("#numberOfCourseWeeks").val()) ;
	$(".independentHoursCal").text(independentHours+ " Hours");
	var totalHours = parseInt($(".contactHoursCal").text())+parseInt(independentHours);
	$(".totalHoursCal").text(totalHours);
}

function weekPopupClose(){
	$("#modalWeek").modal("hide");
	loadWeekWiseDataMain();
}

$(document).ready(function(){
	
	setTimeout(function(){ 
		getProjectPercentageLoad();
		updateDonut();
		$("#bradleyLabDetailedScreenLoader").fadeOut();
	}, 3000);
	//donutinitalization();
	loadCourseInformation();
	$("#CourseInfo .nav-tabs a").attr("disabled","disabled");
	$("#CourseInfo .nav-tabs a.active, #CourseInfo .nav-tabs a.step-complete").removeAttr("disabled");
	
	$("#openCourseIdentification").on("click", function() { 
		loadCourseIdentification();
	});
	$("#openCourseInfoModal").on("click", function() { 
		loadCourseHours();
	});
	$("#openCourseResources").on("click", function() { 
		loadCourseResources();
	});
	$("#openCourseInstructorQualification").on("click", function() { 
		loadCourseInstructorQualification();
	});
	$("#step-1-milestone").on("click", function(){
	    $('#CourseInfo .nav-tabs #step2').removeAttr("disabled");
   		$('#CourseInfo .nav-tabs [href="#step-2"]').tab('show');
   		$("#"+namespaceId+"milestoneName").val("Course Design");
   		loadTask();
   		/* updateDonutteps(); */
   		//updateDonut();
   		/* donutinitalization(); */
	});
$("#step-1-milestone").on("click", function(){
		
		debugger;
	    /* $("#CourseInfo .nav-tabs #step1").addClass("step-complete"); */
	    $('#CourseInfo .nav-tabs #step2').removeAttr("disabled");
   		$('#CourseInfo .nav-tabs [href="#step-2"]').tab('show');
   		$("#"+namespaceId+"milestoneName").val("Course Design");
   		loadTask();
   		/* updateDonutteps(); */
   		//updateDonut();
   		donutinitalization();
	});
	$("#step1").on("click", function(){
		debugger;
		$("#"+namespaceId+"milestoneName").val("Course Information");
   		loadTask();
   		if(donutPercentage==100){
   			$("#CourseInfo .nav-tabs #step4").addClass("step-complete");
   		}
	});
	$("#step-2-milestone").on("click", function(){
		debugger;
	    $("#CourseInfo .nav-tabs #step2").addClass("step-complete"); 
	    $('#CourseInfo .nav-tabs #step3').removeAttr("disabled");
   		$('#CourseInfo .nav-tabs [href="#step-3"]').tab('show');
   		$("#"+namespaceId+"milestoneName").val("Activity Table");
   		loadTask();
   		/* updateDonutteps(); */
   		//updateDonut();
   		donutinitalization();
	});
	$("#step2").on("click", function(){
		debugger;
		$("#"+namespaceId+"milestoneName").val("Course Design");
   		loadTask();
   		if(donutPercentage==100){
   			$("#CourseInfo .nav-tabs #step4").addClass("step-complete");
   		}
	});
	$("#step-3-milestone").on("click", function(){
	    $("#CourseInfo .nav-tabs #step3").addClass("step-complete");
	    $('#CourseInfo .nav-tabs #step4').removeAttr("disabled");
   		$('#CourseInfo .nav-tabs [href="#step-4"]').tab('show');
   		//$("#"+namespaceId+"milestoneName").val("Activity Table");
   		$("#"+namespaceId+"milestoneName").val("Course Summary");
   		loadTask();
   		loadCourseInformation();
   		/* updateDonutteps(); */
   		//updateDonut();
   		donutinitalization();
	});
	$("#step3").on("click", function(){
		$("#"+namespaceId+"milestoneName").val("Activity Table"); 
		/* $("#"+namespaceId+"milestoneName").val("Course Summary"); */
   		loadTask();
   		if(donutPercentage==100){
   			$("#CourseInfo .nav-tabs #step4").addClass("step-complete");
   		}
	});
	
	$("#donutRedirect").on("click", function(){
		updateDonutteps();
   		//updateDonut();
   		donutinitalization();
	});
	
	$("#step4").on("click", function(){
		$("#"+namespaceId+"milestoneName").val("Course Summary");
		loadCourseInformation();
	});
	
	if(donutPercentage!=null && donutPercentage!=undefined && donutPercentage!="undefined" && donutPercentage!="null"){
		$("#donut1 .text").html(donutPercentage+"%").css("color",colornumberDonut).css("font-size", fontSizeText).css("font-family","Merriweather Sans").css("letter-spacing", letterSpace);
		//updateDonut();
		donutinitalization();
	} 
	//donutPercentage(donutPercentage);
	
});


/* jQuery(window).load(function(){								
	jQuery('#flexslider-1').flexslider({
	animation: "fade",
	slideshow: false,
	animationLoop:false,
	startAt: 0,
	start: function(slider){
		startAt:0
	} 
	}); */
	

$(window).on("load", function() {								
	$('#flexslider-1').flexslider({
		animation: "fade",
		slideshow: false,
		animationLoop:false,
		startAt: 0,
		start: function(slider){
			startAt:0
		} 
	});
$(".btn-week-edit").click(function(){
	var id;
	id=$(this).data("week");
	var idNo = parseInt(id);
	$('#flexslider-1').flexslider(idNo); 
});
}); 


function updateDonut() {
	
	var numItems = $('.wrap-step').children('a.step').length;
	var stepComplete = $('.wrap-step').children('a.step-complete').length;
	var numPerc = 100/numItems;
	var percCurrent = numPerc*stepComplete;
	
	var canvas = document.getElementById("donut");
	canvas.width = 140;
	canvas.height = 140;
	var percentage = parseInt(percCurrent);
	var colorDonut = "#339900";
	var colornumberDonut = "#000000";
	var fontSizeText = (parseInt(canvas.width)/4.5)+"px";
	var letterSpace = "-4px";
	console.log('percentage',percentage)
	/* if(donutPercentage!=100){
		$("#donut1 .text").html(donutPercentage+"%").css("color",colornumberDonut).css("font-size", fontSizeText).css("font-family","Merriweather Sans").css("letter-spacing", letterSpace);
	} */
	
	$("#donut1 .text").html(donutPercentage+"%").css("color",colornumberDonut).css("font-size", fontSizeText).css("font-family","Merriweather Sans").css("letter-spacing", letterSpace);
	
	debugger;
	/* To load the tasks based on milestone*/
	/*if(donutPercentage!=100){
		donutPercentage(percentage); }*/
	//donutPercentage(percentage);
	loadTask();
	/*end*/
	
	console.log('numItems',numItems)
	console.log('donutPercentage',(donutPercentage / 100))
	var percentCount=Math.round((donutPercentage / 100) * numItems);
	console.log('percentCount',percentCount)
	var getNumCompletedItems = percentCount;
	percentage = donutPercentage;
	console.log('percent',percentage)
	console.log("sfdsdfnumPerc"+ getNumCompletedItems);
	
	/* if(getNumCompletedItems === 3) {
	    $("#CourseInfo .nav-tabs #step1, #CourseInfo .nav-tabs #step2, #CourseInfo .nav-tabs #step3").addClass("step-complete");
	    $('#CourseInfo .nav-tabs #step4').removeAttr("disabled");
   		$('#CourseInfo .nav-tabs [href="#step-4"]').tab('show');
   		//$("#"+namespaceId+"milestoneName").val("Activity Table");
	}
	if(getNumCompletedItems === 2) {
		 $("#CourseInfo .nav-tabs #step1, #CourseInfo .nav-tabs #step2").addClass("step-complete");
	    $('#CourseInfo .nav-tabs #step3').removeAttr("disabled");
   		$('#CourseInfo .nav-tabs [href="#step-3"]').tab('show');
   		$("#"+namespaceId+"milestoneName").val("Activity Table");
   		loadTask();
	}
	if(getNumCompletedItems === 1) {
		$("#CourseInfo .nav-tabs #step1").addClass("step-complete");
	    $('#CourseInfo .nav-tabs #step2').removeAttr("disabled");
   		$('#CourseInfo .nav-tabs [href="#step-2"]').tab('show');
   		$("#"+namespaceId+"milestoneName").val("Course Design");
   		loadTask();
	} */
	
	/* if(getNumCompletedItems === 0) {
		$("#"+namespaceId+"milestoneName").val("Course Information");
		loadTask();
	} */
	
	var donutEl = document.getElementById("donut").getContext("2d");

	var donut = new Chart(donutEl).Doughnut(
	// Datas
	[
		{
			value: parseInt(donutPercentage),
			color:colorDonut,//green
			highlight: "#FF5A5E",
			label: "Red"
		},
		{
			value: (parseInt(100) - parseInt(donutPercentage)),
			color: "#e6e6e6",//grey
			highlight: "#5AD3D1",
			label: "Green"
		}
	],
	// Options
	{
		segmentShowStroke : true,
		segmentStrokeColor : "#fff",
		segmentStrokeWidth : 2,
		percentageInnerCutout : 70,
		animationSteps : 100,
		//animationEasing : "easeOutBounce",
		//animateRotate : true,
		//animateScale : false,
		responsive: true,
		maintainAspectRatio: true

	});
	
	
}
function donutinitalization(){
	

	var numItems = $('.wrap-step').children('a.step').length;
	var stepComplete = $('.wrap-step').children('a.step-complete').length;
	var numPerc = 100/numItems;
	var percCurrent = numPerc*stepComplete;
	
	var canvas = document.getElementById("donut");
	canvas.width = 140;
	canvas.height = 140;
	var percentage = parseInt(percCurrent);
	var colorDonut = "#339900";
	var colornumberDonut = "#000000";
	var fontSizeText = (parseInt(canvas.width)/4.5)+"px";
	var letterSpace = "-4px";
	console.log('percentage',percentage)
	/* if(donutPercentage!=100){
		$("#donut1 .text").html(donutPercentage+"%").css("color",colornumberDonut).css("font-size", fontSizeText).css("font-family","Merriweather Sans").css("letter-spacing", letterSpace);
	} */
	
	$("#donut1 .text").html(donutPercentage+"%").css("color",colornumberDonut).css("font-size", fontSizeText).css("font-family","Merriweather Sans").css("letter-spacing", letterSpace);
	
	/* To load the tasks based on milestone*/
	
	/*if(donutPercentage!=100){
		donutPercentage(percentage); }*/
	//donutPercentage(percentage);
	loadTask();
	/*end*/
	var donutEl = document.getElementById("donut").getContext("2d");

	var donut = new Chart(donutEl).Doughnut(
	// Datas
	[
		{
			value: parseInt(donutPercentage),
			color:colorDonut,//green
			highlight: "#FF5A5E",
			label: "Red"
		},
		{
			value: (parseInt(100) - parseInt(donutPercentage)),
			color: "#e6e6e6",//grey
			highlight: "#5AD3D1",
			label: "Green"
		}
	],
	// Options
	{
		segmentShowStroke : true,
		segmentStrokeColor : "#fff",
		segmentStrokeWidth : 2,
		percentageInnerCutout : 70,
		animationSteps : 100,
		//animationEasing : "easeOutBounce",
		//animateRotate : true,
		//animateScale : false,
		responsive: true,
		maintainAspectRatio: true

	});
}
function updateDonutteps() {
	/* var stepComplete = $('.wrap-step').children('a.step-complete').length;
	if(stepComplete === 0) {
	    $("#CourseInfo .nav-tabs #step1").addClass("step-complete");
	    $('#CourseInfo .nav-tabs #step2').removeAttr("disabled");
   		$('#CourseInfo .nav-tabs [href="#step-2"]').tab('show');
	}
	if(stepComplete === 1) {
	    $("#CourseInfo .nav-tabs #step2").addClass("step-complete");
	    $('#CourseInfo .nav-tabs #step3').removeAttr("disabled");
   		$('#CourseInfo .nav-tabs [href="#step-3"]').tab('show');
	}
	if(stepComplete === 2) {
	    $("#CourseInfo .nav-tabs #step3").addClass("step-complete");
	    $('#CourseInfo .nav-tabs #step4').removeAttr("disabled");
   		$('#CourseInfo .nav-tabs [href="#step-4"]').tab('show');
	} */
}

function loadCourseInformation(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='loadCourseInformation'/>"
		,{
              method: 'get',
              data:{ 
              },
              sync : true, 
              on:{
           	   complete:function()
            		{		            		   
            		},
                   success:function()
                   {			                    	
                   	var value=this.get('responseData');	
                   	debugger;
                   	if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                   		var j = JSON.parse(value);
                   		$("#courseTitle").text(j.couseTitle);
                   		$("#courseNumber").text(j.courseNumber);
                   		$("#prerequisites").text(j.prerequisites);
                   		$("#courseDescription").text(j.couseDescription);
                   		$("#CreditoHours").text("");
                   		$("#ContactHours").text("");
                   		$("#LectureHours").text("");
                   		$("#LaboratoryHours").text("");
                   		/* if(j.numberOfCredits>0){
                   			$("#CreditoHours").text(j.numberOfCredits);
                   			$("#summary_creditHours").val(j.numberOfCredits);
                   		}
                   		if(j.contactHours>0){
                   			$("#ContactHours").text(j.contactHours);
                   			$("#summary_contactHours").val(j.contactHours);
                   		}
                   		if(j.lectureHoursPerWeek>0){
                   			$("#LectureHours").text(j.lectureHoursPerWeek);
                   			$("#summary_lectureHours").val(j.lectureHoursPerWeek);
                   		}
                   		if(j.labHoursPerWeek>0){
                   			$("#LaboratoryHours").text(j.labHoursPerWeek);
                   			$("#summary_laboratoryHours").val(j.labHoursPerWeek);
                   		}    */   
                   		$("#CreditoHours").text(j.numberOfCredits);
               			$("#summary_creditHours").val(j.numberOfCredits);
               			$("#ContactHours").text(j.contactHours);
               			$("#summary_contactHours").val(j.contactHours);
               			$("#LectureHours").text(j.lectureHoursPerWeek);
               			$("#summary_lectureHours").val(j.lectureHoursPerWeek);
               			$("#LaboratoryHours").text(j.labHoursPerWeek);
               			$("#summary_laboratoryHours").val(j.labHoursPerWeek);
                   		$("#TextbookTitle").text(j.textbookTitle);
                   		$("#PublisherName").text(j.publisherName);
                   		$("#Author").text(j.author);
                   		$("#ISBN").text(j.ISBN);
                   		$("#instQual1").text(j.instructor1Qualifications);
                   		$("#instQual2").text(j.instructor2Qualifications);
                   		
                   		
                   		$("#summary_courseTitle").val(j.couseTitle);
                   		$("#summary_courseNumber").val(j.courseNumber);
                   		$("#summary_prerequisites").val(j.prerequisites);
                   		$("#summary_courseDescription").val(j.couseDescription);
                   		
                   		$("#summary_textbookTitle").val(j.textbookTitle);
                   		$("#summary_publisherName").val(j.publisherName);
                   		$("#summary_authors").val(j.author);
                   		$("#summary_ISBN").val(j.ISBN);
                   		$("#summary_instructor1Qualifications").val(j.instructor1Qualifications);
                   		$("#summary_instructor2Qualifications").val(j.instructor2Qualifications);
                   		$("#summary_courseIdentificationsId").val(j.courseId);
                   		$("#summary_courseHoursId").val(j.courseHoursId);
                   		$("#summary_courseResourcesId").val(j.courseResourceId);
                   		$("#summary_instructorQualificationsFormId").val(j.courseInstId);
                   		
                   		$("#s_courseTitle").text(j.couseTitle);
                   		$("#s_courseNumber").text(j.courseNumber);
                   		$("#s_prerequisites").text(j.prerequisites);
                   		$("#s_courseDescription").text(j.couseDescription);
                   		$("#s_creditHours").text(j.numberOfCredits);
                   		$("#s_contactHours").text(j.contactHours);
                   		$("#s_lectureHours").text(j.lectureHoursPerWeek);
                   		$("#s_laboratoryHours").text(j.labHoursPerWeek);
                   		$("#s_textbookTitle").text(j.textbookTitle);
                   		$("#s_publisherName").text(j.publisherName);
                   		$("#s_authors").text(j.author);
                   		$("#s_ISBN").text(j.ISBN);
                   		$("#s_instructor1Qualifications").text(j.instructor1Qualifications);
                   		$("#s_instructor2Qualifications").text(j.instructor2Qualifications);
                   		var topics = "",objectives="",env="";
                   		if(j.courseTopic.length>0){
                   			for(var k=0;k<j.courseTopic.length;k++){
                   				topics = topics + "<li>"+j.courseTopic[k].couseTopic+"</li>";
                   			}
                   		}
                   		if(j.learningEnvironment.length>0){
                   			for(var k=0;k<j.learningEnvironment.length;k++){
                   				env = env + "<li>"+j.learningEnvironment[k].learningEnvironment+"</li>";
                   			}
                   		}
                   		if(j.courseObjective.length>0){
                   			for(var k=0;k<j.courseObjective.length;k++){
                   				objectives = objectives + "<li>"+j.courseObjective[k].couseObjectives+"</li>";
                   			}
                   		}
                   		$(".s_courseTopics, .s_courseObjective, .s_learningEnvironment").html("");
                   		$(".s_courseTopics").append("<ol>"+topics+"</ol>");
                   		$(".s_courseObjective").append("<ol>"+objectives+"</ol>");
                   		$(".s_learningEnvironment").append("<ol>"+env+"</ol>");
                   		// Tab change
                   		/* if(j.enable==true){
                   			$("#step-1-milestone").removeAttr("disabled").removeClass("btn-grey").addClass("btn-green");
                   		} */
                	}
                   },error: function(){	   
                	   
                   }
			},

         });
	});
}

function courseIdentificationAddEdit(){
	debugger;
	AUI().use('aui-io-request-deprecated', function(A){
        A.io.request('<%=courseIdentificationAddEdit.toString()%>', {
               method: 'post',
               form: {
                   id: 'courseIdentificationsForm',
                   upload:true
               },
               cache: false,
               contentType: false,
               processData: false,
               on: {
            	   start:function(){
            		   //$("#wait").show();
            	   },
            	   complete: function(data){
            		   debugger;
            		   if(data.details[1].responseText!=null && data.details[1].responseText=="add"){
            			   $("#courseInfoModal").modal("hide");
            			   showMsg("Added successfully");
            			   loadCourseInformation();
            		   }if(data.details[1].responseText!=null && data.details[1].responseText=="update"){
            			   $("#courseInfoModal").modal("hide");
            			   showMsg("Updated successfully");
            			   loadCourseInformation();
            		   }else{
            			   //showMsg("Error!!");
            		   }
                   },
                   failure:function(data){
                	   //$("#wait").hide();
                   }
               }
            });
    	});
}

function courseHoursAddEdit(){
	debugger;
	AUI().use('aui-io-request-deprecated', function(A){
        A.io.request('<%=courseHoursAddEdit.toString()%>', {
               method: 'post',
               form: {
                   id: 'courseHoursForm',
                   upload:true
               },
               cache: false,
               contentType: false,
               processData: false,
               on: {
            	   start:function(){
            		   //$("#wait").show();
            	   },
            	   complete: function(data){
            		   debugger;
            		   if(data.details[1].responseText!=null && data.details[1].responseText=="add"){
            			   $("#courseInfoModal").modal("hide");
            			   showMsg("Added successfully");
            			   loadCourseInformation();
            		   }if(data.details[1].responseText!=null && data.details[1].responseText=="update"){
            			   $("#courseInfoModal").modal("hide");
            			   showMsg("Updated successfully");
            			   loadCourseInformation();
            		   }else{
            			   //showMsg("Error!!");
            		   }
                   },
                   failure:function(data){
                	   //$("#wait").hide();
                   }
               }
            });
    	});
}

function courseResourcesAddEdit(){
	debugger;
	AUI().use('aui-io-request-deprecated', function(A){
        A.io.request('<%=courseResourcesAddEdit.toString()%>', {
               method: 'post',
               form: {
                   id: 'courseResourcesForm',
                   upload:true
               },
               cache: false,
               contentType: false,
               processData: false,
               on: {
            	   start:function(){
            		   //$("#wait").show();
            	   },
            	   complete: function(data){
            		   debugger;
            		   if(data.details[1].responseText!=null && data.details[1].responseText=="add"){
            			   $("#courseInfoModal").modal("hide");
            			   showMsg("Added successfully");
            			   loadCourseInformation();
            		   }if(data.details[1].responseText!=null && data.details[1].responseText=="update"){
            			   $("#courseInfoModal").modal("hide");
            			   showMsg("Updated successfully");
            			   loadCourseInformation();
            		   }else{
            			   //showMsg("Error!!");
            		   }
                   },
                   failure:function(data){
                	   //$("#wait").hide();
                   }
               }
            });
    	});
}

function courseInstructorQualificationAddEdit(){
	debugger;
	AUI().use('aui-io-request-deprecated', function(A){
        A.io.request('<%=courseInstructorQualificationAddEdit.toString()%>', {
               method: 'post',
               form: {
                   id: 'instructorQualificationsForm',
                   upload:true
               },
               cache: false,
               contentType: false,
               processData: false,
               on: {
            	   start:function(){
            		   //$("#wait").show();
            	   },
            	   complete: function(data){
            		   debugger;
            		   if(data.details[1].responseText!=null && data.details[1].responseText=="add"){
            			   $("#courseInfoModal").modal("hide");
            			   showMsg("Added successfully");
            			   loadCourseInformation();
            		   }if(data.details[1].responseText!=null && data.details[1].responseText=="update"){
            			   $("#courseInfoModal").modal("hide");
            			   showMsg("Updated successfully");
            			   loadCourseInformation();
            		   }else{
            			   //showMsg("Error!!");
            		   }
                   },
                   failure:function(data){
                	   //$("#wait").hide();
                   }
               }
            });
    	});
}

function courseSummaryAddEdit(){
	AUI().use('aui-io-request-deprecated', function(A){
        A.io.request('<%=courseSummaryAddEdit.toString()%>', {
               method: 'post',
               form: {
                   id: 'courseSummaryForm',
                   upload:true
               },
               cache: false,
               contentType: false,
               processData: false,
               on: {
            	   start:function(){
            		   //$("#wait").show();
            	   },
            	   complete: function(data){
            		   debugger;
            		   if(data.details[1].responseText!=null && data.details[1].responseText=="save"){
            			   $("#openCourseSummary").modal("hide");
            			   showMsg("Saved successfully");
            			   loadCourseInformation();
            		   }else{
            			   //showMsg("Error!!");
            		   }
                   },
                   failure:function(data){
                	   //$("#wait").hide();
                   }
               }
            });
    	});
}

Liferay.provide(window,'showMsg',function(msg){	
	AUI().use(
		  'aui-modal',
			  function(A) {
			    var modal = new A.Modal(
			      {
			    	  centered: true,
			        headerContent: '<center><h4 class="font-weight-semibold m-0"> Message</h4></center>',
			        modal: true,
			        render: '#modal',
			        zIndex: 1100,
			        width: 305,
			        toolbars: {
			        		 header: []
			         },
			      }
			    ).render();
	
  	  modal.set('bodyContent', msg);
			    
	modal.addToolbar(
    	      [
    	        {
    	            label: 'OK',
    	            on: {
    	              click: function() {
    	            	  modal.hide();    	            	  
    	              }    	               
    	              }
    	            }
    	          
    	      ]
		);
});

});

function loadCourseIdentification(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='viewCourseIdentification'/>"
			,{
               method: 'get',
               data:{ 
               },
               sync : true, 
               on:{
            	   complete:function()
             		{		            		   
             		},
                    success:function()
                    {			                    	
                    	var value=this.get('responseData');	
                    	debugger;
                    	if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                    		$("#courseInfoContent").html("");
                    	    $("#courseInfoContent").html(value);
                 	   }
                    },error: function(){	             
                    }
				},

	         });
		});
}

function loadCourseHours(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='viewCourseHours'/>"
			,{
               method: 'get',
               data:{ 
               },
               sync : true, 
               on:{
            	   complete:function()
             		{		            		   
             		},
                    success:function()
                    {			                    	
                    	var value=this.get('responseData');	
                    	debugger;
                    	if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                    		$("#courseInfoContent").html("");
                    	    $("#courseInfoContent").html(value);
                 	   }
                    },error: function(){	             
                    }
				},

	         });
		});
}

function loadCourseResources(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='viewCourseResources'/>"
			,{
               method: 'get',
               data:{ 
               },
               sync : true, 
               on:{
            	   complete:function()
             		{		            		   
             		},
                    success:function()
                    {			                    	
                    	var value=this.get('responseData');	
                    	debugger;
                    	if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                    		$("#courseInfoContent").html("");
                    	    $("#courseInfoContent").html(value);
                 	   }
                    },error: function(){	             
                    }
				},

	         });
		});
}

function loadCourseInstructorQualification(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='viewCourseInstructorQualification'/>"
			,{
               method: 'get',
               data:{ 
               },
               sync : true, 
               on:{
            	   complete:function()
             		{		            		   
             		},
                    success:function()
                    {			                    	
                    	var value=this.get('responseData');	
                    	debugger;
                    	if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                    		$("#courseInfoContent").html("");
                    	    $("#courseInfoContent").html(value);
                 	   }
                    },error: function(){	             
                    }
				},

	         });
		});
}

function donutPercentage(percentage){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='donutPercentage'/>"
		,{
              method: 'post',
              data:{ 
            	  '<portlet:namespace/>donutPercentage':percentage
              },
              sync : true, 
              on:{
           	   complete:function()
            		{		            		   
            		},
                   success:function()
                   {			                    	
                   	var value=this.get('responseData');	
                   	debugger;
                   	if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                   		$("#courseInfoContent").html("");
                   	    $("#courseInfoContent").html(value);
                	   }
                   },error: function(){	             
                   }
			},

         });
	});
}

function getProjectPercentage(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getProjectPercentage'/>"
		,{
              method: 'get',
              data:{ 
              },
              sync : true, 
              on:{
           	   complete:function()
            		{		            		   
            		},
                   success:function()
                   {			                    	
                   	var value=this.get('responseData');	
                   	debugger;
                   	if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                   		var j = JSON.parse(value);
                   		donutPercentage = j.percentage;	
                   		console.log("j", j)
                   		if(donutPercentage==100){
                   			$("#submitForReview").removeClass("btn-grey").addClass("btn-green active");
                   		}else{
                   			$("#submitForReview").addClass("btn-grey").removeClass("btn-green active");
                   		}
                   		if(j.milestone1 == true) {
                   			$("#step-1-milestone").removeClass("btn-grey").addClass("btn-green");
                   			$("#CourseInfo .nav-tabs #step1").removeAttr("disabled").addClass("step-complete");                   			
                   		}
                   		if(j.milestone2 == true) {
                   			$("#step-2-milestone").removeClass("btn-grey").addClass("btn-green");
                   			$("#CourseInfo .nav-tabs #step2").removeAttr("disabled").addClass("step-complete");                   			
                   		}
                   		if(j.milestone3 == true) {
                   			$("#step-3-milestone").removeClass("btn-grey").addClass("btn-green");
                   			$("#CourseInfo .nav-tabs #step3").removeAttr("disabled").addClass("step-complete");                   			
                   	   		
                   		} 
                   		if(j.milestone1 == false) {
                   			$("#step-1-milestone").removeClass("btn-green").addClass("btn-grey");
                   			$("#CourseInfo .nav-tabs #step1").attr("disabled","disabled").removeClass("step-complete");                   			
                   		}
                   		if(j.milestone2 == false) {
                   			$("#step-2-milestone").removeClass("btn-green").addClass("btn-grey");
                   			$("#CourseInfo .nav-tabs #step2").attr("disabled","disabled").removeClass("step-complete");             			
                   		}
                   		if(j.milestone3 == false) {
                   			$("#step-3-milestone").removeClass("btn-green").addClass("btn-grey");
                   			$("#CourseInfo .nav-tabs #step3").attr("disabled","disabled").removeClass("step-complete");                			
                   	   		
                   		} 
                   	}
                   	
                   	
                   },error: function(){	             
                   }
			},

         });
	});
}

function getProjectPercentageLoad(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getProjectPercentage'/>"
		,{
              method: 'get',
              data:{ 
              },
              sync : true, 
              on:{
           	   complete:function()
            		{		            		   
            		},
                   success:function()
                   {			                    	
                   	var value=this.get('responseData');	
                   	debugger;
                   	if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                   		var j = JSON.parse(value);
                   		donutPercentage = j.percentage;                   		
                   		
   						console.log("donutPercentage", donutPercentage);
   						console.log("j.milestone1", j.milestone1 == true);
   						console.log("j.milestone2", j.milestone2 == true);
   						console.log("j.milestone3", j.milestone3 == true);
                   		if(donutPercentage>0 && donutPercentage<=36){                   			
                   			/* $("#CourseInfo .nav-tabs #step1").addClass("step-complete"); 
                   			 $("#step-1-milestone").trigger("click");  */
                   			/* $("#"+namespaceId+"milestoneName").val("Course Information");
       						loadTask(); */
                   		}
                   		if(donutPercentage>36 && donutPercentage<=63){
                   			$("#CourseInfo .nav-tabs #step1").removeAttr("disabled").addClass("step-complete");
                   			$('#CourseInfo .nav-tabs #step2').removeAttr("disabled");
                   	   		/* $('#CourseInfo .nav-tabs [href="#step-2"]').tab('show');
	                   	   	$("#"+namespaceId+"milestoneName").val("Course Design");
	                   		loadTask(); */
                   			 /* $("#step-2-milestone").trigger("click");  */
                   		}
                   		if(donutPercentage>63 && donutPercentage<100) {
                   			//$("#CourseInfo .nav-tabs #step3").addClass("step-complete"); 
                   			 /* $("#step-3-milestone").trigger("click");  */
                   			$("#CourseInfo .nav-tabs #step2").removeAttr("disabled").addClass("step-complete");
                   			$('#CourseInfo .nav-tabs #step3').removeAttr("disabled");
                   	   		/* $('#CourseInfo .nav-tabs [href="#step-3"]').tab('show');
	                   	   	$("#"+namespaceId+"milestoneName").val("Activity Table");
	                   		loadTask(); */
                   		}
                   		
                   		if(donutPercentage==100){
                   			$("#CourseInfo .nav-tabs #step3").removeAttr("disabled").addClass("step-complete");
                   			$('#CourseInfo .nav-tabs #step4').removeAttr("disabled");
                   	   		$('#CourseInfo .nav-tabs [href="#step-4"]').tab('show');
                   			$("#submitForReview").removeClass("btn-grey").addClass("btn-green active");
                   			$("#"+namespaceId+"milestoneName").val("Course Summary");
                   			loadTask();
                   			loadCourseInformation();
                   		}else{
                   			$("#submitForReview").addClass("btn-grey").removeClass("btn-green active");
                   		}
                   		
                   		if(j.milestone1 == false) {
                   			$('#CourseInfo .nav-tabs [href="#step-1"]').tab('show');
                   			$("#"+namespaceId+"milestoneName").val("Course Information");
       						loadTask();
                   		} 
                   		else if(j.milestone1 == true) {
                   			if(j.milestone2 == false) {
                       			$('#CourseInfo .nav-tabs [href="#step-2"]').tab('show');
                       			$("#"+namespaceId+"milestoneName").val("Course Design");
    	                   		loadTask();
                       		} 
                   		} 
                   		else if(j.milestone1 == true && j.milestone2 == true) {
                   			if(j.milestone3 == false) {
                       			$('#CourseInfo .nav-tabs [href="#step-3"]').tab('show');
                       			$("#"+namespaceId+"milestoneName").val("Activity Table");
    	                   		loadTask();
                       		} 
                   		} 
                   		
                   		
                   		
                   		if(j.milestone1 == true) {
                   			$("#step-1-milestone").removeClass("btn-grey").addClass("btn-green");
                   			$("#CourseInfo .nav-tabs #step1").addClass("step-complete");                   			
                   		}
                   		if(j.milestone2 == true) {
                   			$("#step-2-milestone").removeClass("btn-grey").addClass("btn-green");
                   			$("#CourseInfo .nav-tabs #step2").addClass("step-complete");                   			
                   		}
                   		if(j.milestone3 == true) {
                   			$("#step-3-milestone").removeClass("btn-grey").addClass("btn-green");
                   			$("#CourseInfo .nav-tabs #step3").addClass("step-complete");                   			
                   	   		//$("#submitForReview").addClass("active");
                   		}
                   		
                   		
                   	}
                   	
                   	
                   },error: function(){	             
                   }
			},

         });
	});
}

function saveActivityTable(){
	AUI().use('aui-io-request-deprecated', function(A){
        A.io.request('<portlet:resourceURL id='saveActivityTable'/>', {
	          method: 'post',
	          form: {
	              id: '<portlet:namespace/>weekForm',
	              upload:true
	          },
	          cache: false,
	          contentType: false,
	          processData: false,
	          on: {
	       	   start:function(){
	       		   //$("#wait").show();
	       	   },
	       	   complete: function(data){
	       		   debugger;
	       		   if(data.details[1].responseText!=0 && data.details[1].responseText!="0" && data.details[1].responseText!=null && data.details[1].responseText!="null"){
	       				//$("#<portlet:namespace/>selectedKey").val(data.details[1].responseText);
	       				$("#weekPopup").modal("hide");
	       				$("#<portlet:namespace/>input-dynamic-name").val("");
	       				loadWeekWiseData();
	       				loadWeekWiseDataMain();
	       			    showMsg("Saved successfully");	       			 	
	       		   }else{
	       			   showMsg("Not saved");
	       		   }
	              },
	              failure:function(data){
	           	   //$("#wait").hide();
	              }
	          }
	       });
	});
}

function loadWeekWiseData(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='loadWeekWiseData'/>"
			,{
               method: 'get',
               data:{ 
               },
               sync : true, 
               on:{
            	   complete:function()
             		{		            		   
             		},
                    success:function()
                    {			                    	
                    	var value=this.get('responseData');	
                    	$("#week1CourseObjectives .courses-box-body").html("");
                		$("#week1LearningEnvironmentDesign .courses-box-body").html("");
                		$("#week1Activity .courses-box-body").html("");
                		$("#week1Content .courses-box-body").html("");
                		$("#week2CourseObjectives .courses-box-body").html("");
                		$("#week2LearningEnvironmentDesign .courses-box-body").html("");
                		$("#week2Activity .courses-box-body").html("");
                		$("#week2Content .courses-box-body").html("");
                		$("#week3CourseObjectives .courses-box-body").html("");
                		$("#week3LearningEnvironmentDesign .courses-box-body").html("");
                		$("#week3Activity .courses-box-body").html("");
                		$("#week3Content .courses-box-body").html("");
                		$("#week4CourseObjectives .courses-box-body").html("");
                		$("#week4LearningEnvironmentDesign .courses-box-body").html("");
                		$("#week4Activity .courses-box-body").html("");
                		$("#week4Content .courses-box-body").html("");
                    	debugger;
                    	if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                    		var data = JSON.parse(value);                   		
                    		console.log("data", data);
                    		console.log("dataLength", data.length);
                    		for(var i=0; i<data.length; i++) {
                    			if(data[i].week === "1"){                    				
                    				if(data[i].courseObjective!=null && data[i].courseObjective!="null" && data[i].courseObjective!=undefined && data[i].courseObjective!="undefined"  && data[i].courseObjective!=""){
	                        			$("#week1CourseObjectives .courses-box-body").append("<div class='courses-box-content'>"+
	    		            					" <div class='btn-remove'> "+
	    		            					" <a href='javascript:void(0);' onclick='getDataRemove("+ data[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false'><i class='fas fa-minus-circle color-orange'></i></a> "+
	    		            				" </div> "+
	    		            				" <p id='"+ data[i].id +"'>"+ data[i].courseObjective +"</p> "+
	    		            			" </div>");
                        			}
                    				if(data[i].learningEnvironment!=null && data[i].learningEnvironment!="null" && data[i].learningEnvironment!=undefined && data[i].learningEnvironment!="undefined"  && data[i].learningEnvironment!=""){                   				
	                    				$("#week1LearningEnvironmentDesign .courses-box-body").append("<div class='courses-box-content'>"+
	    		            					" <div class='btn-remove'> "+
	    		            					" <a href='javascript:void(0);' onclick='getDataRemove("+ data[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false'><i class='fas fa-minus-circle color-orange'></i></a> "+
	    		            				" </div> "+
	    		            				" <p id='"+ data[i].id +"'>"+ data[i].learningEnvironment +"</p> "+
	    		            			" </div>");
	                    			}
									if(data[i].activity!=null && data[i].activity!="null" && data[i].activity!=undefined && data[i].activity!="undefined"  && data[i].activity!=""){
										$("#week1Activity .courses-box-body").append("<div class='courses-box-content'>"+
	    		            					" <div class='btn-remove'> "+
	    		            					" <a href='javascript:void(0);' onclick='getDataRemove("+ data[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false'><i class='fas fa-minus-circle color-orange'></i></a> "+
	    		            				" </div> "+
	    		            				" <p id='"+ data[i].id +"'>"+ data[i].activity +"</p> "+
	    		            			" </div>");
	                    			}
									if(data[i].content!=null && data[i].content!="null" && data[i].content!=undefined && data[i].content!="undefined"  && data[i].content!=""){
										$("#week1Content .courses-box-body").append("<div class='courses-box-content'>"+
	    		            					" <div class='btn-remove'> "+
	    		            					" <a href='javascript:void(0);' onclick='getDataRemove("+ data[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false'><i class='fas fa-minus-circle color-orange'></i></a> "+
	    		            				" </div> "+
	    		            				" <p id='"+ data[i].id +"'>"+ data[i].content +"</p> "+
	    		            			" </div>");
	                    			}
                    			}
                    			
                    			if(data[i].week === "2"){
                    				if(data[i].courseObjective!=null && data[i].courseObjective!="null" && data[i].courseObjective!=undefined && data[i].courseObjective!="undefined"  && data[i].courseObjective!=""){
	                        			$("#week2CourseObjectives .courses-box-body").append("<div class='courses-box-content'>"+
	    		            					" <div class='btn-remove'> "+
	    		            					" <a href='javascript:void(0);' onclick='getDataRemove("+ data[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false'><i class='fas fa-minus-circle color-orange'></i></a> "+
	    		            				" </div> "+
	    		            				" <p id='"+ data[i].id +"'>"+ data[i].courseObjective +"</p> "+
	    		            			" </div>");
                        			}
                    				if(data[i].learningEnvironment!=null && data[i].learningEnvironment!="null" && data[i].learningEnvironment!=undefined && data[i].learningEnvironment!="undefined"  && data[i].learningEnvironment!=""){                   				
	                    				$("#week2LearningEnvironmentDesign .courses-box-body").append("<div class='courses-box-content'>"+
	    		            					" <div class='btn-remove'> "+
	    		            					" <a href='javascript:void(0);' onclick='getDataRemove("+ data[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false'><i class='fas fa-minus-circle color-orange'></i></a> "+
	    		            				" </div> "+
	    		            				" <p id='"+ data[i].id +"'>"+ data[i].learningEnvironment +"</p> "+
	    		            			" </div>");
	                    			}
									if(data[i].activity!=null && data[i].activity!="null" && data[i].activity!=undefined && data[i].activity!="undefined"  && data[i].activity!=""){
										$("#week2Activity .courses-box-body").append("<div class='courses-box-content'>"+
	    		            					" <div class='btn-remove'> "+
	    		            					" <a href='javascript:void(0);' onclick='getDataRemove("+ data[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false'><i class='fas fa-minus-circle color-orange'></i></a> "+
	    		            				" </div> "+
	    		            				" <p id='"+ data[i].id +"'>"+ data[i].activity +"</p> "+
	    		            			" </div>");
	                    			}
									if(data[i].content!=null && data[i].content!="null" && data[i].content!=undefined && data[i].content!="undefined"  && data[i].content!=""){
										$("#week2Content .courses-box-body").append("<div class='courses-box-content'>"+
	    		            					" <div class='btn-remove'> "+
	    		            					" <a href='javascript:void(0);' onclick='getDataRemove("+ data[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false'><i class='fas fa-minus-circle color-orange'></i></a> "+
	    		            				" </div> "+
	    		            				" <p id='"+ data[i].id +"'>"+ data[i].content +"</p> "+
	    		            			" </div>");
	                    			}
                    			}
                    			
                    			if(data[i].week === "3"){
                    				if(data[i].courseObjective!=null && data[i].courseObjective!="null" && data[i].courseObjective!=undefined && data[i].courseObjective!="undefined"  && data[i].courseObjective!=""){
	                        			$("#week3CourseObjectives .courses-box-body").append("<div class='courses-box-content'>"+
	    		            					" <div class='btn-remove'> "+
	    		            					" <a href='javascript:void(0);' onclick='getDataRemove("+ data[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false'><i class='fas fa-minus-circle color-orange'></i></a> "+
	    		            				" </div> "+
	    		            				" <p id='"+ data[i].id +"'>"+ data[i].courseObjective +"</p> "+
	    		            			" </div>");
                        			}
                    				if(data[i].learningEnvironment!=null && data[i].learningEnvironment!="null" && data[i].learningEnvironment!=undefined && data[i].learningEnvironment!="undefined"  && data[i].learningEnvironment!=""){                   				
	                    				$("#week3LearningEnvironmentDesign .courses-box-body").append("<div class='courses-box-content'>"+
	    		            					" <div class='btn-remove'> "+
	    		            					" <a href='javascript:void(0);' onclick='getDataRemove("+ data[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false'><i class='fas fa-minus-circle color-orange'></i></a> "+
	    		            				" </div> "+
	    		            				" <p id='"+ data[i].id +"'>"+ data[i].learningEnvironment +"</p> "+
	    		            			" </div>");
	                    			}
									if(data[i].activity!=null && data[i].activity!="null" && data[i].activity!=undefined && data[i].activity!="undefined"  && data[i].activity!=""){
										$("#week3Activity .courses-box-body").append("<div class='courses-box-content'>"+
	    		            					" <div class='btn-remove'> "+
	    		            					" <a href='javascript:void(0);' onclick='getDataRemove("+ data[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false'><i class='fas fa-minus-circle color-orange'></i></a> "+
	    		            				" </div> "+
	    		            				" <p id='"+ data[i].id +"'>"+ data[i].activity +"</p> "+
	    		            			" </div>");
	                    			}
									if(data[i].content!=null && data[i].content!="null" && data[i].content!=undefined && data[i].content!="undefined"  && data[i].content!=""){
										$("#week3Content .courses-box-body").append("<div class='courses-box-content'>"+
	    		            					" <div class='btn-remove'> "+
	    		            					" <a href='javascript:void(0);' onclick='getDataRemove("+ data[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false'><i class='fas fa-minus-circle color-orange'></i></a> "+
	    		            				" </div> "+
	    		            				" <p id='"+ data[i].id +"'>"+ data[i].content +"</p> "+
	    		            			" </div>");
	                    			}
                    			}
                    			
                    			if(data[i].week === "4"){
                    				if(data[i].courseObjective!=null && data[i].courseObjective!="null" && data[i].courseObjective!=undefined && data[i].courseObjective!="undefined"  && data[i].courseObjective!=""){
	                        			$("#week4CourseObjectives .courses-box-body").append("<div class='courses-box-content'>"+
	    		            					" <div class='btn-remove'> "+
	    		            					" <a href='javascript:void(0);' onclick='getDataRemove("+ data[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false'><i class='fas fa-minus-circle color-orange'></i></a> "+
	    		            				" </div> "+
	    		            				" <p id='"+ data[i].id +"'>"+ data[i].courseObjective +"</p> "+
	    		            			" </div>");
                        			}
                    				if(data[i].learningEnvironment!=null && data[i].learningEnvironment!="null" && data[i].learningEnvironment!=undefined && data[i].learningEnvironment!="undefined"  && data[i].learningEnvironment!=""){                   				
	                    				$("#week4LearningEnvironmentDesign .courses-box-body").append("<div class='courses-box-content'>"+
	    		            					" <div class='btn-remove'> "+
	    		            					" <a href='javascript:void(0);' onclick='getDataRemove("+ data[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false'><i class='fas fa-minus-circle color-orange'></i></a> "+
	    		            				" </div> "+
	    		            				" <p id='"+ data[i].id +"'>"+ data[i].learningEnvironment +"</p> "+
	    		            			" </div>");
	                    			}
									if(data[i].activity!=null && data[i].activity!="null" && data[i].activity!=undefined && data[i].activity!="undefined"  && data[i].activity!=""){
										$("#week4Activity .courses-box-body").append("<div class='courses-box-content'>"+
	    		            					" <div class='btn-remove'> "+
	    		            					" <a href='javascript:void(0);' onclick='getDataRemove("+ data[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false'><i class='fas fa-minus-circle color-orange'></i></a> "+
	    		            				" </div> "+
	    		            				" <p id='"+ data[i].id +"'>"+ data[i].activity +"</p> "+
	    		            			" </div>");
	                    			}
									if(data[i].content!=null && data[i].content!="null" && data[i].content!=undefined && data[i].content!="undefined"  && data[i].content!=""){
										$("#week4Content .courses-box-body").append("<div class='courses-box-content'>"+
	    		            					" <div class='btn-remove'> "+
	    		            					" <a href='javascript:void(0);' onclick='getDataRemove("+ data[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false'><i class='fas fa-minus-circle color-orange'></i></a> "+
	    		            				" </div> "+
	    		            				" <p id='"+ data[i].id +"'>"+ data[i].content +"</p> "+
	    		            			" </div>");
	                    			}
                    			}
                    			
                    		}
                 	   }
                    },error: function(){	             
                    }
				},

	         });
		});
}

function loadWeekWiseDataMain(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='loadWeekWiseDataMain'/>"
			,{
               method: 'get',
               data:{ 
               },
               sync : true, 
               on:{
            	   complete:function()
             		{		            		   
             		},
                    success:function()
                    {			                    	
                    	var value=this.get('responseData');	
                    	
                    	debugger;
                    	/* $("#week1CLAC").html(""); */
                    	$("#week1CLAC, #week2CLAC, #week3CLAC, #week4CLAC").html("");
                    	console.log("data load week wise data main value", value);
                    	if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                    		var data = JSON.parse(value);
                        	console.log("data load week wise data main", data);
                        	/* console.log("data.week1.courseObjective.length", data.week1.courseObjective.length); */
                        	/*$("#week1CLAC tr:not('.week1CLACHeading'), #week1CLAC tr:not('.week1CLACCFooter')").remove();*/
                        	$("#week1CLAC, #week2CLAC, #week3CLAC, #week4CLAC").html("");
                    	if(data.week1){
                    		var maxNumber1 = Math.max(data.week1.courseObjective.length, data.week1.learningEnv.length, data.week1.activity.length, data.week1.content.length);
                    		var running = true; 
                    		if(maxNumber1>0){                       			                   			                   			
	                    		for (var i=0; i<maxNumber1; i++) {
	                    			console.log("looping data maxNumber1==="+i+"==="+running);
	                    			/* if(("#week1CLAC tr").length >0){
	                    				 $("#week1CLAC").remove(" #week1CLAC tr:not('.week1CLACCFooter')")
	                    				//$("#week1CLAC tr:not('.week1CLACHeading'), #week1CLAC tr:not('.week1CLACCFooter')").remove();
	                    			} */
	                    			
	                    			$("#week1CLAC").append("<tr id='week1tr"+i+"'><td class='text-center' id='week1CourseObjective"+i+"'></td><td class='text-center' id='week1LearningEnv"+i+"'></td><td class='text-center' id='week1Activity"+i+"'></td><td class='text-center' id='week1Content"+i+"'></td></tr>")
	                    			/* if(running==true){ */
		                    			if(data.week1.courseObjective.length>0){		                    				
		                    				if(data.week1.courseObjective[i]!=undefined){
		                    					$("#week1CourseObjective"+i).html("<a href='javascript:void(0);' onclick='getDataRemove("+ data.week1.courseObjective[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false' class='mr-2 removeWeek1CO'><i class='fas fa-minus-circle color-orange' aria-hidden='true'></i></a>" + data.week1.courseObjective[i].courseObjective);
		                    				}
		                        		}
		                    			if(data.week1.learningEnv.length>0){
		                    				if(data.week1.learningEnv[i]!=undefined){
		                    					$("#week1LearningEnv"+i).html("<a href='javascript:void(0);' onclick='getDataRemove("+ data.week1.learningEnv[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false' class='mr-2 removeWeek1LE'><i class='fas fa-minus-circle color-orange' aria-hidden='true'></i></a>" + data.week1.learningEnv[i].learningEnvironment);
		                    				}
		                        		}
		                    			if(data.week1.activity.length>0){
		                    				if(data.week1.activity[i]!=undefined){
		                    					$("#week1Activity"+i).html("<a href='javascript:void(0);' onclick='getDataRemove("+ data.week1.activity[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false' class='mr-2 removeWeek1ACT'><i class='fas fa-minus-circle color-orange' aria-hidden='true'></i></a>" + data.week1.activity[i].activity);
		                    				}
		                        		}
		                    			if(data.week1.content.length>0){
		                    				if(data.week1.content[i]!=undefined){
		                    					$("#week1Content"+i).html("<a href='javascript:void(0);' onclick='getDataRemove("+ data.week1.content[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false' class='mr-2 removeWeek1CON'><i class='fas fa-minus-circle color-orange' aria-hidden='true'></i></a>" + data.week1.content[i].content);
		                    				}
		                        		} 
		                    			/* if(i==(maxNumber1-1)){ running = false; } */
		                    		/* } */
                    			}
                    		}
                    	}
                    	if(data.week2){
                    		var maxNumber2 = Math.max(data.week2.courseObjective.length, data.week2.learningEnv.length, data.week2.activity.length, data.week2.content.length);
                    		var running = true; 
                    		if(maxNumber2>0){
                    			/* if(running==true){ */
	                    			for (var i=0; i<maxNumber2; i++) {
		                    			console.log("looping data maxNumber2==="+i);
		                    			/* if(("#week2CLAC tr").length >0){
		                    				$("#week2CLAC").remove(" #week2CLAC tr:not('.week2CLACFooter')")
		                    				//$("#week1CLAC tr:not('.week1CLACHeading'), #week1CLAC tr:not('.week1CLACCFooter')").remove();
		                    			} */
		                    			
		                    			
		                    			$("#week2CLAC").append("<tr><td class='text-center' id='week2CourseObjective"+i+"'></td><td class='text-center' id='week2LearningEnv"+i+"'></td><td class='text-center' id='week2Activity"+i+"'></td><td class='text-center' id='week2Content"+i+"'></td></tr>");
		                    			
		                    			if(data.week2.courseObjective.length>0){
		                    				if(data.week2.courseObjective[i]!=undefined){
		                    					$("#week2CourseObjective"+i).html("<a href='javascript:void(0);' onclick='getDataRemove("+ data.week2.courseObjective[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false' class='mr-2 removeWeek2CO'><i class='fas fa-minus-circle color-orange' aria-hidden='true'></i></a>" + data.week2.courseObjective[i].courseObjective);
		                    				}
		                        		}
		                    			if(data.week2.learningEnv.length>0){
		                    				if(data.week2.learningEnv[i]!=undefined){
		                    					$("#week2LearningEnv"+i).html("<a href='javascript:void(0);' onclick='getDataRemove("+ data.week2.learningEnv[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false' class='mr-2 removeWeek2LE'><i class='fas fa-minus-circle color-orange' aria-hidden='true'></i></a>" + data.week2.learningEnv[i].learningEnvironment);
		                    				}
		                        		}
		                    			if(data.week2.activity.length>0){
		                    				if(data.week2.activity[i]!=undefined){
		                    					$("#week2Activity"+i).html("<a href='javascript:void(0);' onclick='getDataRemove("+ data.week2.activity[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false' class='mr-2 removeWeek2ACT'><i class='fas fa-minus-circle color-orange' aria-hidden='true'></i></a>" + data.week2.activity[i].activity);
		                    				}
		                        		}
		                    			if(data.week2.content.length>0){
		                    				if(data.week2.content[i]!=undefined){
		                    					$("#week2Content"+i).html("<a href='javascript:void(0);' onclick='getDataRemove("+ data.week2.content[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false' class='mr-2 removeWeek2CON'><i class='fas fa-minus-circle color-orange' aria-hidden='true'></i></a>" + data.week2.content[i].content);
		                    				}
		                        		} 
		                    			/* if(i==(maxNumber2-1)){ running = false; } */
		                    		}
                    			/* } */
                    		}
                    	}
                    	if(data.week3){
                    		var maxNumber3 = Math.max(data.week3.courseObjective.length, data.week3.learningEnv.length, data.week3.activity.length, data.week3.content.length);
                    		var running = true;
                    		if(maxNumber3>0){
                    			/* if(running==true){ */
	                    			for (var i=0; i<maxNumber3; i++) {
		                    			console.log("looping data maxNumber3==="+i);
		                    			/* if(("#week3CLAC tr").length >0){
		                    				$("#week3CLAC").remove(" #week3CLAC tr:not('.week3CLACFooter')")
		                    				//$("#week1CLAC tr:not('.week1CLACHeading'), #week1CLAC tr:not('.week1CLACCFooter')").remove();
		                    			} */
		                    			$("#week3CLAC").append("<tr><td class='text-center' id='week3CourseObjective"+i+"'></td><td class='text-center' id='week3LearningEnv"+i+"'></td><td class='text-center' id='week3Activity"+i+"'></td><td class='text-center' id='week3Content"+i+"'></td></tr>");
		                    			
		                    			if(data.week3.courseObjective.length>0){
		                    				if(data.week3.courseObjective[i]!=undefined){
		                    					$("#week3CourseObjective"+i).append("<a href='javascript:void(0);' onclick='getDataRemove("+ data.week3.courseObjective[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false' class='mr-2 removeWeek3CO'><i class='fas fa-minus-circle color-orange' aria-hidden='true'></i></a>" + data.week3.courseObjective[i].courseObjective);
		                    				}
		                        		}
		                    			if(data.week3.learningEnv.length>0){
		                    				if(data.week3.learningEnv[i]!=undefined){
		                    					$("#week3LearningEnv"+i).append("<a href='javascript:void(0);' onclick='getDataRemove("+ data.week3.learningEnv[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false' class='mr-2 removeWeek3LE'><i class='fas fa-minus-circle color-orange' aria-hidden='true'></i></a>" + data.week3.learningEnv[i].learningEnvironment);
		                    				}
		                        		}
		                    			if(data.week3.activity.length>0){
		                    				if(data.week3.activity[i]!=undefined){
		                    					$("#week3Activity"+i).append("<a href='javascript:void(0);' onclick='getDataRemove("+ data.week3.activity[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false' class='mr-2 removeWeek3ACT'><i class='fas fa-minus-circle color-orange' aria-hidden='true'></i></a>" + data.week3.activity[i].activity);
		                    				}
		                        		}
		                    			if(data.week3.content.length>0){
		                    				if(data.week3.content[i]!=undefined){
		                    					$("#week3Content"+i).append("<a href='javascript:void(0);' onclick='getDataRemove("+ data.week3.content[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false' class='mr-2 removeWeek3CON'><i class='fas fa-minus-circle color-orange' aria-hidden='true'></i></a>" + data.week3.content[i].content);
		                    				}
		                        		} 
		                    			/* if(i==(maxNumber3-1)){ running = false; } */
		                    		}
                    			/* } */
                    		}
                    	}
                    	if(data.week4){
                    		var maxNumber4 = Math.max(data.week4.courseObjective.length, data.week4.learningEnv.length, data.week4.activity.length, data.week4.content.length);
                    		var running = true;
                    		if(maxNumber4>0){
                    			/* if(running==true){ */
	                    			for (var i=0; i<maxNumber4; i++) {
		                    			console.log("looping data maxNumber4==="+i);
		                    			/* if(("#week4CLAC tr").length >0){
		                    				$("#week4CLAC").remove(" #week4CLAC tr:not('.week4CLACFooter')")
		                    				//$("#week1CLAC tr:not('.week1CLACHeading'), #week1CLAC tr:not('.week1CLACCFooter')").remove();
		                    			} */
		                    			$("#week4CLAC").append("<tr><td class='text-center' id='week4CourseObjective"+i+"'></td><td class='text-center' id='week4LearningEnv"+i+"'></td><td class='text-center' id='week4Activity"+i+"'></td><td class='text-center' id='week4Content"+i+"'></td></tr>");
		                    			
		                    			if(data.week4.courseObjective.length>0){
		                    				if(data.week4.courseObjective[i]!=undefined){
		                    					$("#week4CourseObjective"+i).append("<a href='javascript:void(0);' onclick='getDataRemove("+ data.week4.courseObjective[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false' class='mr-2 removeWeek4CO'><i class='fas fa-minus-circle color-orange' aria-hidden='true'></i></a>" + data.week4.courseObjective[i].courseObjective);
		                    				}
		                        		}
		                    			if(data.week4.learningEnv.length>0){
		                    				if(data.week4.learningEnv[i]!=undefined){
		                    					$("#week4LearningEnv"+i).append("<a href='javascript:void(0);' onclick='getDataRemove("+ data.week4.learningEnv[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false' class='mr-2 removeWeek4LE'><i class='fas fa-minus-circle color-orange' aria-hidden='true'></i></a>" + data.week4.learningEnv[i].learningEnvironment);
		                    				}
		                        		}
		                    			if(data.week4.activity.length>0){
		                    				if(data.week4.activity[i]!=undefined){
		                    					$("#week4Activity"+i).append("<a href='javascript:void(0);' onclick='getDataRemove("+ data.week4.activity[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false' class='mr-2 removeWeek4ACT'><i class='fas fa-minus-circle color-orange' aria-hidden='true'></i></a>" + data.week4.activity[i].activity);
		                    				}
		                        		}
		                    			if(data.week4.content.length>0){
		                    				if(data.week4.content[i]!=undefined){
		                    					$("#week4Content"+i).append("<a href='javascript:void(0);' onclick='getDataRemove("+ data.week4.content[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false' class='mr-2 removeWeek4CON'><i class='fas fa-minus-circle color-orange' aria-hidden='true'></i></a>" + data.week4.content[i].content);
		                    				}
		                        		} 
		                    			/* if(i==(maxNumber4-1)){ running = false; } */
		                    		}
                    			/* } */
                    		}
                    	}
                    	}
                    	
                    },error: function(){	             
                    }
				},

	         });
		});
}

function loadCourseTopics(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='loadCourseTopics'/>"
		,{
              method: 'post',
              data:{ 
              },
              sync : true, 
              on:{
           	   complete:function()
            		{		            		   
            		},
                   success:function()
                   {			                    	
                   	var value=this.get('responseData');
                   	debugger;
                   	var content = "";var mainContent = "";
                   	if(value!=null && value!="null" && value!=undefined && value!="undefined"){
                   		var j = JSON.parse(value);
                   		for(var i=0;i<j.length;i++){
                   			/* content = content + "<li class='editCourseDesign text-white'><span>"+j[i].courseTopic+"</span> <input class='form-control' name='courseTopics"+i+"' id='courseTopics"+i+"' value='"+j[i].courseTopic+"'> <input type='hidden' class='form-control' id='courseTopics"+i+"Id' name='courseTopics"+i+"Id' value='"+j[i].id+"'> <a href='javascript:void(0);' class='color-white'><i class='fas fa-edit' aria-hidden='true'></i></a></li>"; */
                   			content = content + "<div class='form-group d-flex'><a href='javascript:void(0);' onclick='getDataRemove("+ j[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false' id='remove-course-design-"+i+"' class='cl-asset-type-d cl-hover-black font20 mr-1'><i class='fas fa-minus-circle'></i></a><input class='form-control' name='courseTopics"+i+"' id='courseTopics"+i+"' value='"+j[i].courseTopic+"'> <input type='hidden' class='form-control' id='courseTopics"+i+"Id' name='courseTopics"+i+"Id' value='"+j[i].id+"'></div>";
                   			mainContent = mainContent + "<tr><th class='title-row-th-1' scope='row'></th><td>"+(i+1)+". "+j[i].courseTopic+"</td></tr>";
                   		}            
                   	}              		
                   	
               		$("#modalCourseDesignContent").html("<div class='modal-header position-relative text-center'><div class='text-left font15 m-auto'><strong>Course Topics</strong></div></div><div class='modal-body'><div class='interest-modal color-black'><div class='row'><div class='col-md-12'><h5 class='bold mb-3 text-white'>Course Topics</h5><form name='courseTopicForm' id='courseTopicForm'>"+content+"</form><div id='courseTopicDiableField'><input class='form-control mb-3' id='courseTopicAdd' name='courseTopicAdd' value='' placeholder='Goes Here'><div><button class='btn btn-blue btn-w-100' type='button' onclick='courseTopicSave()'>Add</button></div></div></div></div><div class='row mt-5'><div class='col-md-12'><div class='float-left'><a href='#' class='btn btn-blue'>Learn more</a></div><div class='float-right d-flex'><a href='#' class='btn btn-grey mr-2' data-dismiss='modal'>Cancel</a> <input class='form-control' type='hidden' id='courseTopicId' value='0'><button class='btn btn-blue' type='button' onclick='courseTopicUpdate()'>Save</button></div></div></div></div></div>");
               		if(value!=null && value!="null" && value!=undefined && value!="undefined"){
               			if(j.length==5){
                   			$("#courseTopicDiableField .form-control").attr("disabled", "disabled");
                   			$("#courseTopicDiableField .btn").addClass("disabled");
                   		}else{
                   			$("#courseTopicDiableField .form-control").removeAttr("disabled");
                   			$("#courseTopicDiableField .btn").removeClass("disabled");
                   		}
               		}
                   	$(".courseTopicsDynamicValue").html(mainContent);
                   	
                   	 
                   	
                   	/* if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                   		var data = JSON.parse(value);
                   		console.log("loadCourseTopics", data);
                   		$("#modalCourseDesignContent").html("<div class='modal-header position-relative text-center'><div class='text-left font15 m-auto'><strong>Course Topics</strong></div></div><div class='modal-body'><div class='interest-modal color-black'><div class='row'><div class='col-md-12'><h5 class='bold mb-3 text-white'>Course Topics</h5><ol class='pl-15'><li class='editCourseDesign text-white'><span>"+data.courseTopic1+"</span> <input class='form-control' id='courseTopics1' value="+data.courseTopic1+"> <a href='javascript:void(0);' class='color-white'><i class='fas fa-edit' aria-hidden='true'></i></a></li><li class='editCourseDesign text-white'><span>"+data.courseTopic2+"</span> <input class='form-control' id='courseTopics2' value="+data.courseTopic2+"> <a href='javascript:void(0);' class='color-white'><i class='fas fa-edit' aria-hidden='true'></i></a></li><li class='editCourseDesign text-white'><span>"+data.courseTopic3+"</span> <input class='form-control' id='courseTopics3' value="+data.courseTopic3+"> <a href='javascript:void(0);' class='color-white'><i class='fas fa-edit' aria-hidden='true'></i></a></li><li class='editCourseDesign text-white'><span>"+data.courseTopic4+"</span> <input class='form-control' id='courseTopics4' value="+data.courseTopic4+"> <a href='javascript:void(0);' class='color-white'><i class='fas fa-edit' aria-hidden='true'></i></a></li><li class='editCourseDesign text-white'><span>"+data.courseTopic5+"</span> <input class='form-control' id='courseTopics5' value="+data.courseTopic5+"> <a href='javascript:void(0);' class='color-white'><i class='fas fa-edit' aria-hidden='true'></i></a></li></ol><div id='courseTopicDiableField'><input class='form-control mb-3' placeholder='Goes Here'><div><a href='#' class='btn btn-blue btn-w-100'>Add</a></div></div></div></div><div class='row mt-5'><div class='col-md-12'><div class='float-left'><a href='#' class='btn btn-blue'>Learn more</a></div><div class='float-right d-flex'><a href='#' class='btn btn-grey mr-2' data-dismiss='modal'>Cancel</a> <input class='form-control' type='hidden' id='courseTopicId' value="+data.id+"><a href='#' class='btn btn-blue' onclick='courseTopicSave()'>Save</a></div></div></div></div></div>");
                   		if(data.courseTopic1!="" && data.courseTopic1!=null && data.courseTopic1!="undefined" && data.courseTopic1!=undefined) {
                   			$("#courseTopicsDynamicValue").append("<tr><td width='25%'></td><td>Topic</td></tr>");
                   		}
                   		if(data.courseTopic2!="" && data.courseTopic2!=null && data.courseTopic2!="undefined" && data.courseTopic2!=undefined) {
							$("#courseTopicsDynamicValue").append("<tr><td width='25%'></td><td>"+data.courseTopic2+"</td></tr>");
                   		}
                   		if(data.courseTopic3!="" && data.courseTopic3!=null && data.courseTopic3!="undefined" && data.courseTopic3!=undefined) {
							$("#courseTopicsDynamicValue").append("<tr><td width='25%'></td><td>"+data.courseTopic3+"</td></tr>");
                   		}
                   		if(data.courseTopic4!="" && data.courseTopic4!=null && data.courseTopic4!="undefined" && data.courseTopic4!=undefined) {
							$("#courseTopicsDynamicValue").append("<tr><td width='25%'></td><td>"+data.courseTopic4+"</td></tr>");
                   		}
                   		if(data.courseTopic5!="" && data.courseTopic5!=null && data.courseTopic5!="undefined" && data.courseTopic5!=undefined) {
							$("#courseTopicsDynamicValue").append("<tr><td width='25%'></td><td>"+data.courseTopic5+"</td></tr>");
                   		}
                   		if(data.courseTopic1!="" && data.courseTopic2!="" && data.courseTopic3!="" && data.courseTopic4!="" && data.courseTopic5!=""){
                   			$("#courseTopicDiableField .form-control").attr("disabled", "disabled");
                   			$("#courseTopicDiableField .btn").addClass("disabled");
                   		}else{
                   			$("#courseTopicDiableField .form-control").removeAttr("disabled");
                   			$("#courseTopicDiableField .btn").removeClass("disabled");
                   		} 
                   	}  */
                   	},error: function(){	             
                   }
			},

         });
	});
}

function loadCourseObjectives(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='loadCourseObjectives'/>"
		,{
              method: 'post',
              data:{ 
              },
              sync : true, 
              on:{
           	   complete:function()
            		{		            		   
            		},
                   success:function()
                   {			                    	
                   	var value=this.get('responseData');	
                   	debugger;
               		//$("#modalCourseDesignContent").html("<div class='modal-header position-relative text-center'><div class='text-left font15 m-auto'><strong>Course Objectives</strong></div></div><div class='modal-body'><div class='interest-modal color-black'><div class='row'><div class='col-md-12'><h5 class='bold mb-3 text-white'>Course Objectives</h5><ol class='pl-15'><li class='editCourseDesign text-white'><span>Connect With A Partner In Another Country And Engage In Conversations That Result In A Joint Project That Enhances Student's Intercultural Competency Skills And Knowledge</span> <input class='form-control' id='courseObjectives1' > <a href='javascript:void(0);' class='color-white'><i class='fas fa-edit'></i></a></li><li class='editCourseDesign text-white'><span>Use Online Tools To Develop Global Business Communication Skills In A Cross-Cultural Virtual Team Environment</span> <input class='form-control' id='courseObjectives2' > <a href='javascript:void(0);' class='color-white'><i class='fas fa-edit'></i></a></li><li class='editCourseDesign text-white'><span>Use Case Studies To Understand Similarities And Differences In How Management Issues May Be Handled Different Cultures</span> <input class='form-control' id='courseObjectives3' > <a href='javascript:void(0);' class='color-white'><i class='fas fa-edit'></i></a></li></ol><div id='courseObjectiveDiableField'><input class='form-control mb-3' placeholder='Goes Here'><div><a href='#' class='btn btn-blue btn-w-100'>Add</a></div></div></div></div><div class='row mt-5'><div class='col-md-12'><div class='float-left'><a href='#' class='btn btn-blue'>Learn more</a></div><div class='float-right d-flex'><a href='#' class='btn btn-grey mr-2' data-dismiss='modal'>Cancel</a><a href='#' class='btn btn-blue' onclick='courseObjectiveSave()'>Save</a></div></div></div></div></div>"); 
               		var content = "";var mainContent = "";
                   	if(value!=null && value!="null" && value!=undefined && value!="undefined"){
                   		var j = JSON.parse(value);
                   		for(var i=0;i<j.length;i++){
                   			/* content = content + "<li class='editCourseDesign text-white'><span>"+j[i].courseObjectives+"</span> <input class='form-control' name='courseObjectives"+i+"' id='courseObjectives"+i+"' value='"+j[i].courseObjectives+"'> <input type='hidden' class='form-control' id='courseObjectives"+i+"Id' name='courseObjectives"+i+"Id' value='"+j[i].id+"'> <a href='javascript:void(0);' class='color-white'><i class='fas fa-edit' aria-hidden='true'></i></a></li>"; */
                   			content = content + "<div class='form-group text-white d-flex mb-2'><a href='javascript:void(0);' onclick='getDataRemove("+ j[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false' id='remove-course-objective-"+i+"' class='cl-asset-type-d cl-hover-black font20 mr-1'><i class='fas fa-minus-circle'></i></a><input class='form-control' name='courseObjectives"+i+"' id='courseObjectives"+i+"' value='"+j[i].courseObjectives+"'><input type='hidden' class='form-control' id='courseObjectives"+i+"Id' name='courseObjectives"+i+"Id' value='"+j[i].id+"'></div>";
                   			mainContent = mainContent + "<tr><th class='title-row-th-1' scope='row'></th><td>"+(i+1)+". "+j[i].courseObjectives+"</td></tr>";
                   		}                   		
                   	}           		                  	
               		$("#modalCourseDesignContent").html("<div class='modal-header position-relative text-center'><div class='text-left font15 m-auto'><strong>Course Objectives</strong></div></div><div class='modal-body'><div class='interest-modal color-black'><div class='row'><div class='col-md-12'><h5 class='bold mb-3 text-white'>Course Objectives</h5><form name='courseTopicForm' id='courseObjectiveForm'>"+content+"</form><div id='courseObjectiveDiableField'><input class='form-control mb-3' id='courseObjectiveAdd' name='courseObjectiveAdd' value='' placeholder='Goes Here'><div><button type='button' type='button' class='btn btn-blue btn-w-100' onclick='courseObjectiveSave()'>Add</button></div></div></div></div><div class='row mt-5'><div class='col-md-12'><div class='float-left'><a href='#' class='btn btn-blue'>Learn more</a></div><div class='float-right d-flex'><a href='#' class='btn btn-grey mr-2' data-dismiss='modal'>Cancel</a> <input class='form-control' type='hidden' id='courseObjectiveId' value='0'><button type='button' class='btn btn-blue' onclick='courseObjectiveUpdate()'>Save</button></div></div></div></div></div>");
               		if(value!=null && value!="null" && value!=undefined && value!="undefined"){
               			if(j.length==3){
                   			$("#courseObjectiveDiableField .form-control").attr("disabled", "disabled");
                   			$("#courseObjectiveDiableField .btn").addClass("disabled");
                   		}else{
                   			$("#courseObjectiveDiableField .form-control").removeAttr("disabled");
                   			$("#courseObjectiveDiableField .btn").removeClass("disabled");
                   		}
               		}
                   	$(".courseObjectiveDynamicValue").html(mainContent);
                   	
                   },error: function(){	             
                   }
			},

         });
	});
}

function loadCourseLearningEnvironment(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='loadCourseLearningEnvironment'/>"
		,{
              method: 'post',
              data:{ 
              },
              sync : true, 
              on:{
           	   complete:function()
            		{		            		   
            		},
                   success:function()
                   {			                    	
                   	var value=this.get('responseData');	
                   	debugger;
               		//$("#modalCourseDesignContent").html("<div class='modal-header position-relative text-center'><div class='text-left font15 m-auto'><strong>Learning Environment</strong></div></div><div class='modal-body'><div class='interest-modal color-black'><div class='row'><div class='col-md-12'><h5 class='bold mb-3 text-white'>Learning Environment</h5><ol class='pl-15'><li class='editCourseDesign text-white'><span>Synchronous Video Lecture</span> <input class='form-control' id='learningEnvironment1' > <a href='javascript:void(0);' class='color-white'><i class='fas fa-edit'></i></a></li><li class='editCourseDesign text-white'><span>Independent Assignments</span><input class='form-control' id='learningEnvironment2' > <a href='javascript:void(0);' class='color-white'><i class='fas fa-edit'></i></a></li><li class='editCourseDesign text-white'><span>Group Assignments</span><input class='form-control' id='learningEnvironment3' > <a href='javascript:void(0);' class='color-white'><i class='fas fa-edit'></i></a></li></ol><div id='courseLearningEnvironmentDiableField'><input class='form-control mb-3' placeholder='Goes Here'><div><a href='#' class='btn btn-blue btn-w-100'>SLO</a></div></div></div></div><div class='row mt-5'><div class='col-md-12'><div class='float-left'><a href='#' class='btn btn-blue'>Learn more</a></div><div class='float-right d-flex'><a href='#' class='btn btn-grey mr-2' data-dismiss='modal'>Cancel</a> <a href='#' class='btn btn-blue' onclick='courseLearningEnvironmentSave()'>Save</a></div></div></div></div></div>");
               		var content = "";var mainContent = "";
                   	if(value!=null && value!="null" && value!=undefined && value!="undefined"){
                   		var j = JSON.parse(value);
                   		for(var i=0;i<j.length;i++){
                   			/* content = content + "<li class='editCourseDesign text-white'><span>"+j[i].learningEnvironment+"</span> <input class='form-control' name='learningEnvironment"+i+"' id='learningEnvironment"+i+"' value='"+j[i].learningEnvironment+"'> <input type='hidden' class='form-control' id='learningEnvironment"+i+"Id' name='learningEnvironment"+i+"Id' value='"+j[i].id+"'> <a href='javascript:void(0);' class='color-white'><i class='fas fa-edit' aria-hidden='true'></i></a></li>"; */
                   			content = content + "<div class='form-group text-white d-flex mb-2'><a href='javascript:void(0);' onclick='getDataRemove("+ j[i].id +")' data-toggle='modal' data-target='#weekContentRemovePopup' data-backdrop='static' data-keyboard='false' id='remove-course-le-"+i+"' class='cl-asset-type-d cl-hover-black font20 mr-1'><i class='fas fa-minus-circle'></i></a><input class='form-control' name='learningEnvironment"+i+"' id='learningEnvironment"+i+"' value='"+j[i].learningEnvironment+"'><input type='hidden' class='form-control' id='learningEnvironment"+i+"Id' name='learningEnvironment"+i+"Id' value='"+j[i].id+"'></div>";
                   			mainContent = mainContent + "<tr><th class='title-row-th-1' scope='row'></th><td>"+(i+1)+". "+j[i].learningEnvironment+"</td></tr>";
                   		}                   		
                   	}              		
                   	
               		$("#modalCourseDesignContent").html("<div class='modal-header position-relative text-center'><div class='text-left font15 m-auto'><strong>Learning Environments</strong></div></div><div class='modal-body'><div class='interest-modal color-black'><div class='row'><div class='col-md-12'><h5 class='bold mb-3 text-white'>Learning Environments</h5><form name='courseTopicForm' id='courseObjectiveForm'>"+content+"</form><div id='courseLearningEnvironmentDiableField'><input class='form-control mb-3' id='learningEnvironmentAdd' name='learningEnvironmentAdd' value='' placeholder='Goes Here'><div><button type='button' class='btn btn-blue btn-w-100' onclick='courseLearningEnvironmentSave()'>Add</button></div></div></div></div><div class='row mt-5'><div class='col-md-12'><div class='float-left'><a href='#' class='btn btn-blue'>Learn more</a></div><div class='float-right d-flex'><a href='#' class='btn btn-grey mr-2' data-dismiss='modal'>Cancel</a> <input class='form-control' type='hidden' id='learningEnvironmentId' value='0'><button type='button' class='btn btn-blue' onclick='courseLearningEnvironmentUpdate()'>Save</button></div></div></div></div></div>");
               		if(value!=null && value!="null" && value!=undefined && value!="undefined"){
               			if(j.length==3){
                   			$("#courseLearningEnvironmentDiableField .form-control").attr("disabled", "disabled");
                   			$("#courseLearningEnvironmentDiableField .btn").addClass("disabled");
                   		}else{
                   			$("#courseLearningEnvironmentDiableField .form-control").removeAttr("disabled");
                   			$("#courseLearningEnvironmentDiableField .btn").removeClass("disabled");
                   		}
               		}
                   	$(".learningEnvironmentDynamicValue").html(mainContent);

                   },error: function(){	             
                   }
			},

         });
	});
}

function courseTopicSave(){
	var courseTopicAdd = $("#courseTopicAdd").val();
	if(courseTopicAdd!=""){
		AUI().use('aui-io-request-deprecated', function(A){
			A.io.request("<portlet:resourceURL id='courseTopicSave'/>"
			,{
	              method: 'post',
	              data:{ 
	              	'<portlet:namespace/>courseTopics':courseTopicAdd,
	              	'<portlet:namespace/>courseTopicId':courseTopicId
	              },
	              sync : true, 
	              on:{
	           	   complete:function()
	            		{		            		   
	            		},
	                   success:function()
	                   {			                    	
	                   	var value=this.get('responseData');	
	                   	debugger;
	                   	if(value!="" && value!="undefined" && value!=undefined && value=="add"){
	                   		loadCourseTopics();
	                   		showMsg("Added");
	                   		$(".modal-backdrop").removeClass("show");
						}
	                   },error: function(){	             
	                   }
				},
	
	         });
		});
	}
}

function courseObjectiveSave(){
	var courseObjectiveAdd = $("#courseObjectiveAdd").val();
	if(courseObjectiveAdd!=""){
		AUI().use('aui-io-request-deprecated', function(A){
			A.io.request("<portlet:resourceURL id='courseObjectiveSave'/>"
			,{
	              method: 'post',
	              data:{ 
	              	'<portlet:namespace/>courseObjectiveAdd':courseObjectiveAdd,
	              	'<portlet:namespace/>courseObjectiveId':courseObjectiveId
	              },
	              sync : true, 
	              on:{
	           	   complete:function()
	            		{		            		   
	            		},
	                   success:function()
	                   {			                    	
	                   	var value=this.get('responseData');	
	                   	debugger;
	                   	if(value!="" && value!="undefined" && value!=undefined && value=="add"){
	                   		loadCourseObjectives();
	                   		showMsg("Added");
	                   		$(".modal-backdrop").removeClass("show");
						}
	                   },error: function(){	             
	                   }
				},
	
	         });
		});
	}
}

function courseLearningEnvironmentSave(){
	var learningEnvironmentAdd = $("#learningEnvironmentAdd").val();
	if(learningEnvironmentAdd!=""){
		AUI().use('aui-io-request-deprecated', function(A){
			A.io.request("<portlet:resourceURL id='courseLearningEnvironmentSave'/>"
			,{
	              method: 'post',
	              data:{ 
	              	'<portlet:namespace/>learningEnvironmentAdd':learningEnvironmentAdd,
	              	'<portlet:namespace/>learningEnvironmentId':learningEnvironmentId
	              },
	              sync : true, 
	              on:{
	           	   complete:function()
	            		{		            		   
	            		},
	                   success:function()
	                   {			                    	
	                   	var value=this.get('responseData');	
	                   	debugger;
	                   	if(value!="" && value!="undefined" && value!=undefined && value=="add"){
	                   		loadCourseLearningEnvironment();
	                   		showMsg("Added");
	                   		$(".modal-backdrop").removeClass("show");
						}
	                   },error: function(){	             
	                   }
				},
	
	         });
		});
	}
}

function courseTopicUpdate(){	
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='courseTopicUpdate'/>"
		,{
              method: 'post',
              data:{ 
            	  '<portlet:namespace/>courseTopics0':$("#courseTopics0").val(),
                	'<portlet:namespace/>courseTopics0Id':$("#courseTopics0Id").val(),
                	'<portlet:namespace/>courseTopics1':$("#courseTopics1").val(),
                	'<portlet:namespace/>courseTopics1Id':$("#courseTopics1Id").val(),
                	'<portlet:namespace/>courseTopics2':$("#courseTopics2").val(),
                	'<portlet:namespace/>courseTopics2Id':$("#courseTopics2Id").val(),
                	'<portlet:namespace/>courseTopics3':$("#courseTopics3").val(),
                	'<portlet:namespace/>courseTopics3Id':$("#courseTopics3Id").val(),
                	'<portlet:namespace/>courseTopics4':$("#courseTopics4").val(),
                	'<portlet:namespace/>courseTopics4Id':$("#courseTopics4Id").val()
              },
              sync : true, 
              on:{
           	   complete:function()
            		{		            		   
            		},
                   success:function()
                   {			                    	
                   	var value=this.get('responseData');	
                   	debugger;
                   	if(value!="" && value!="undefined" && value!=undefined && value!=null){
                   		loadCourseTopics();
                   		$("#modalCourseDesign").modal("hide");
                   		//showMsg("Updated");
                   		//$(".modal-backdrop").removeClass("show");
					}
                   },error: function(){	             
                   }
			},

         });
	});
	
}

function courseObjectiveUpdate(){	
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='courseObjectiveUpdate'/>"
		,{
              method: 'post',
              data:{ 
              	'<portlet:namespace/>courseObjectives0':$("#courseObjectives0").val(),
              	'<portlet:namespace/>courseObjectives0Id':$("#courseObjectives0Id").val(),
              	'<portlet:namespace/>courseObjectives1':$("#courseObjectives1").val(),
              	'<portlet:namespace/>courseObjectives1Id':$("#courseObjectives1Id").val(),
              	'<portlet:namespace/>courseObjectives2':$("#courseObjectives2").val(),
              	'<portlet:namespace/>courseObjectives2Id':$("#courseObjectives2Id").val()
              },
              sync : true, 
              on:{
           	   complete:function()
            		{		            		   
            		},
                   success:function()
                   {			                    	
                   	var value=this.get('responseData');	
                   	debugger;
                   	if(value!="" && value!="undefined" && value!=undefined && value!=null){
                   		loadCourseObjectives();
                   		$("#modalCourseDesign").modal("hide");
                   		//showMsg("Updated");
                   		//$(".modal-backdrop").removeClass("show");
					}
                   },error: function(){	             
                   }
			},

         });
	});
	
}

function courseLearningEnvironmentUpdate(){	
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='courseLearningEnvironmentUpdate'/>"
		,{
              method: 'post',
              data:{ 
              	'<portlet:namespace/>learningEnvironment0':$("#learningEnvironment0").val(),
              	'<portlet:namespace/>learningEnvironment0Id':$("#learningEnvironment0Id").val(),
              	'<portlet:namespace/>learningEnvironment1':$("#learningEnvironment1").val(),
              	'<portlet:namespace/>learningEnvironment1Id':$("#learningEnvironment1Id").val(),
              	'<portlet:namespace/>learningEnvironment2':$("#learningEnvironment2").val(),
              	'<portlet:namespace/>learningEnvironment2Id':$("#learningEnvironment2Id").val()
              },
              sync : true, 
              on:{
           	   complete:function()
            		{		            		   
            		},
                   success:function()
                   {			                    	
                   	var value=this.get('responseData');	
                   	debugger;
                   	if(value!="" && value!="undefined" && value!=undefined && value!=null){
                   		loadCourseLearningEnvironment();
                   		$("#modalCourseDesign").modal("hide");
                   		//showMsg("Updated");
                   		//$(".modal-backdrop").removeClass("show");
					}
                   },error: function(){	             
                   }
			},

         });
	});
	
}

function getDataRemove(key){
	$("#contentRemovePopup").val(key);
	/* $("#contentRemovePopupType").val(type); */
}

function removeContent(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='removeContent'/>"
		,{
              method: 'post',
              data:{ 
              	'<portlet:namespace/>activityKey':$("#contentRemovePopup").val()
              	/* '<portlet:namespace/>activityType':$("#contentRemovePopupType").val() */
              },
              sync : true, 
              on:{
           	   complete:function()
            		{		            		   
            		},
                   success:function()
                   {	
                	   
          debugger;
                   	var value=this.get('responseData');                   	
                   	if(value!=null && value!="null" && value!=undefined && value!="undefined"){
                   		var j = JSON.parse(value);
                   		if(j.message=="delete"){
	                   		$("#weekContentRemovePopup").modal("hide");
	                   		showMsg("Removed");
	                   		$(".modal-backdrop").removeClass("show");
                   		}
                   		if(j.type=="objective"){
                   			loadCourseObjectives();
                   		}if(j.type=="topic"){
                   			loadCourseTopics();
                   		}if(j.type=="env"){
                   			loadCourseLearningEnvironment();
                   		}if(j.type=="activity"){
                   			loadWeekWiseData();
                           	loadWeekWiseDataMain();
                   		}
					}else{
						showMsg("Error!");
					}
                   },error: function(){	             
                   }
			},

         });
	});
}

function cancelContent(){
	$("#contentRemovePopup").val("0");
}



</script>