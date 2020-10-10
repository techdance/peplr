<%@page import="com.collaborated.entity.service.labScreenProjectOverviewLocalServiceUtil"%>
<%@page import="com.collaborated.entity.model.labScreenProjectOverview"%>
<%@page import="javax.portlet.PortletSession"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<liferay-theme:defineObjects />

<portlet:defineObjects />


<%
String projectId = "", projectName = "", description = "";long donutPercentage = 0;
PortletSession sessionObject = renderRequest.getPortletSession();
projectId = (String)sessionObject.getAttribute("LIFERAY_SHARED_PROJECT_KEY", PortletSession.APPLICATION_SCOPE);
if(projectId!="" && projectId!=null){
	labScreenProjectOverview labScreenProjectOverview = labScreenProjectOverviewLocalServiceUtil.getlabScreenProjectOverview(Long.valueOf(projectId));
	projectName = labScreenProjectOverview.getProjectName();
	description = labScreenProjectOverview.getProjectDescription();
	donutPercentage = labScreenProjectOverview.getPercentage();
	//out.println("donutPercentage==="+donutPercentage+"==="+projectId);
}
%>

<style>
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
	font-size:18px;
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
#CourseInfo .nav-tabs a:not(.step-complete) i {
	display: none;
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
#CourseInfo .nav-tabs a.active:last-child {
    background: url(/o/ahea-theme/images/button-blue-3.png) no-repeat;
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
.box-subhead i, .box-subhead span {
    position: absolute;
    left: 0px;
    top: 3px;
}
.icon-binoculars::before {
    content: "\f1e5";
    font-family: 'Font Awesome 5 Regular';
}

</style>

<script>
var A = AUI();
var donutPercentage = "<%=donutPercentage %>";
console.log('donutPercentage outer' ,donutPercentage)
$(document).ready(function(){
	console.log('donutPercentage inner' ,donutPercentage);
	getProjectPercentage();
	updateDonut();
	loadDetailedScreen();
	$("#CourseInfo .nav-tabs a").on("click", function(){
		$(this).prev().addClass("step-complete");
		updateDonut();
	});
	$("#submitForReview").removeClass("d-none");
	$("#submitForReview").on("click", function(){ 
		setTimeout(function(){ 
			$("#submitModal").modal("show");
		}, 300);
	});
});

function updateDonut() {
	var numItems = $('.wrap-step').children('a.step').length;
	var numPerc = 100/numItems;
	var stepComplete = $('.wrap-step').children('a.step-complete').length;
	var percCurrent = numPerc*stepComplete;

	var canvas = document.getElementById("donut");
	canvas.width = 140;
	canvas.height = 140;
	var percentage = parseInt(percCurrent);
	var colorDonut = "#339900";
	var colornumberDonut = "#000000";
	var fontSizeText = (parseInt(canvas.width)/4.5)+"px";
	var letterSpace = "-4px";
	percentage = donutPercentage;
	console.log("percentage==="+percentage);

	jQuery("#donut1 .text").html(percentage+ " %").css("color",colornumberDonut).css("font-size", fontSizeText).css("font-family","Merriweather Sans").css("letter-spacing", letterSpace);

	var donutEl = document.getElementById("donut").getContext("2d");

	var donut = new Chart(donutEl).Doughnut(
	// Datas
	[
		{
			value: parseInt(percentage),
			color:colorDonut,//green
			highlight: "#FF5A5E",
			label: "Red"
		},
		{
			value: (parseInt(100) - parseInt(percentage)),
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
                   	donutPercentage = value;
                   },error: function(){	             
                   }
			},

         });
	});
}

function loadDetailedScreen(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='moveDetailedScreen'/>"
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
                    	if(value=="false"){
                    		$("#donut_status").attr("href","<%=themeDisplay.getURLPortal() %>"+"/lab-detailed-screen");
                    	}
                    },error: function(){	             
                    }
				},

	         });
		});
}
</script>