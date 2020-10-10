<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<!-- <script type="text/javascript" src="o/ahea-theme/js/jquery.easy-pie-chart.min.js"></script>-->
<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>
	.box-subhead {
	    color: black;
	    font-size: 18px;
	    font-weight: bold;
	    line-height: 25px;
	    margin-bottom: 15px;
	    margin-left: 3px;
	    max-width: 260px;
	    padding-left: 35px;
	    padding-right: 1.4rem;
	    position: relative;
	}
	.nav-tabs-whithout-style{
	border:none;
	justify-content: center;
	margin-top:40px;
	margin-bottom: 40px;
}
.nav-tabs-whithout-style a.nav-link {
	background:white !important;
	border:1px solid #dee2e6 !important;
	color:#777777 !important;
	min-width: 93px;
    text-align: center;
}

.nav-tabs-whithout-style a.nav-link.active {
	background:#2a9eff !important;
	color:#fff !important;
}


.box-project-progress{
	border:1px solid #e8e8e8;
}

.box-project-progress-header{
	height:150px;
}

.box-project-progress-orange .box-project-progress-header{
	background-color:#FF993E;
}
.box-project-progress-orange h4{
	color:#FF993E;
	margin-bottom: 20px;
}
.box-project-progress-green .box-project-progress-header{
	background-color:#339937;
}
.box-project-progress-green h4{
	color:#339937;
	margin-bottom: 20px;
}
.box-project-progress-brown .box-project-progress-header{
	background-color:#A05C1D;
}
.box-project-progress-brown h4{
	color:#A05C1D;
	margin-bottom: 20px;
}
.box-project-progress-body{
	line-height: 1.8;
	padding:15px;
}
.easyPieChart {
    position: relative;
    text-align: center;
    font-weight: bold;
    font-size: 11px;
}
.easyPieChart canvas {
    position: absolute;
    top: 0;
    left: 0;
}
.td-valign-bottom .fas {
    font-size: 17px;
}
.color-orange {
    color: #ff993f !important;
}
.table tbody td {
    font-weight: normal;
    padding: 8px 8px;
}
.table tbody td, .table thead th {
    font-size: 13px !important;
}
.al {
    text-align: left !important;
}
/* Modal */
.modalareainterest .modal-dialog {
	position: relative;
    max-width: 900px;
    margin: 1.75rem auto;
}
.modalareainterest .modal-content{
	max-width:100% !important;
}
.modalareainterest .modal-header {
    background-color: #DAEEFA;
    color: #0099ff !important;
      font-weight: bold;
    line-height: 32px;
    text-transform: capitalize;
    text-align: left;
}
.toltip-close3 {
    position: absolute;
    top: 15px;
    right: 15px;
}
.toltip-close2 a, .toltip-close3 a {
    color: #818c93;
    font-size: 20px;
}
.font15 {
    font-size: 15px !important;
    line-height: 1.5;
}
.modalareainterest .modal-body {
    background: #ffffff;
    border: none;
    color: white;
    font-size: 14px;
    line-height: 1.5;
    padding: 15px;
    text-align: left;
        max-width: 100%;
       max-height: 500px;
    overflow-y: auto;
}
.headingtext{
    color: black;
    font-size: 16px !important;
    font-weight: bold !important;
    line-height: 32px !important;
    text-transform: capitalize;
    text-align: left;
        margin-top: 5px !important;
}
.detailtext{
    color: black;
    font-size: 16px !important;
    font-weight: normal !important;
    line-height: 28px !important;
    text-transform: capitalize;
    text-align: left;
        padding-left: 30px;
            margin-top: 5px !important;
}
.portlet-dropzone .portlet-boundary, .portlet-dropzone .portlet, .portlet-dropzone .portlet-content-editable, .portlet-dropzone .portlet-content-container, .portlet-dropzone .portlet-content, .portlet-dropzone .portlet-body, .portlet-dropzone .box {
	height: auto!important;
}
.box-project-progress-orange .box-project-progress-header{
	background-color:#FF993E;
}
.box-project-progress-orange h4{
	color:#FF993E;
	margin-bottom: 20px;
}
.box-project-progress-green .box-project-progress-header{
	background-color:#339937;
}
.box-project-progress-green h4{
	color:#339937;
	margin-bottom: 20px;
}
.box-project-progress-blue .box-project-progress-header{
	background-color:#084265;
}
.box-project-progress-blue h4{
	color:#084265;
	margin-bottom: 20px;
}
.box-text {
    color: #777777;
    font-weight: normal;
    font-size: 18px;
    font-family: "Merriweather Sans"," SansSerif";
    line-height: 1.2;
}
.easyPieChart {
    font-size: 30px;
    color: black !important;
    font-family: 'Barlow Condensed', sans-serif !important;
}
</style>
<script type="text/javascript">
	


var A = AUI();

/* $(function() {
    //create instance
    $('.chart-donnut').easyPieChart({
        lineWidth: 15
    });
}); */
/* $(window).load(function() {
	$('.chart-donnut').easyPieChart({
        lineWidth: 15
    });
}); */

$(document).ready(function(){
	$('.chart-donnut').easyPieChart({
		scaleColor: "transparent",
	    lineWidth: 20,
	    barColor: '#009CEF',
	    trackColor:	"#eeeeee",
    });
	getMyProjectsAndTasks();
});

function getMyProjectsAndTasks(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getMyProjectsAndTasks'/>"
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
                	   debugger;
                	   var value=this.get('responseData');	
                	   $(".templateProgress").html("");
            		   $(".templatePast").html("");
                	   if(value !=undefined && value!="undefined" &&  value!=null && value!="null"){
                		   var data = JSON.parse(value);
                		   $(".templateProgress").append(data.templateProgress);
                		   $(".templatePast").append(data.templatePast);
                		   $(".templateTasks").append(data.templateTasks);
                		   $('.chart-donnut').easyPieChart({
                				scaleColor: "transparent",
                			    lineWidth: 20,
                			    barColor: '#009CEF',
                			    trackColor:	"#eeeeee",
                		    });
                	   }     
                	   $("#myProjectLoader").fadeOut();
                   },error: function(){	             
                   }
			},

         });
	});
}

function getCourseSummaryData(id){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getCourseSummaryData'/>"
		,{
              method: 'post',
              data:{
           	   '<portlet:namespace/>key':id
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
                  			$("#popup-"+id).html(value);
               		}
                  },error: function(){	             
                  }
			},

         });
	});
}

function goToLabScreen(key){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='moveToLabScreen'/>"
		,{
              method: 'post',
              data:{
              	  '<portlet:namespace/>key':key
              },
              sync : true, 
              on:{
           	   complete:function()
            		{		            		   
            		},
                   success:function()
                   {	
                	   window.location.href = "<%=themeDisplay.getURLPortal() %>"+"/lab-detailed-screen";
                   },error: function(){	             
                   }
			},

         });
	});
}

function goToLabScreenMileStone(labId,milestoneName){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='moveToLabScreen'/>"
		,{
              method: 'post',
              data:{
            	  '<portlet:namespace/>key':labId
              },
              sync : true, 
              on:{
           	   complete:function()
            		{		            		   
            		},
                   success:function()
                   {	
                		debugger;
                		<%-- location.href="<%=themeDisplay.getURLPortal() %>"+"/lab-detailed-screen"; --%>
                		window.location = "<%=themeDisplay.getURLPortal() %>"+"/lab-detailed-screen?milestoneName="+milestoneName;
                	  
                   },error: function(){	             
                   }
			},

         });
	});
}
</script>