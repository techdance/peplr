<%@page import="com.collaborated.entity.model.labScreenProjectPartners"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.collaborated.entity.service.labScreenProjectPartnersLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.collaborated.entity.service.labScreenProjectOverviewLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page import="com.collaborated.entity.model.labScreenProjectOverview"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<link rel="stylesheet" href="https://www.jqueryscript.net/demo/Year-Picker-Text-Input/yearpicker.css" />
<link rel="stylesheet" type="text/css" href="/o/ahea-theme/css/jquery-ui.css">
<script src="/o/ahea-theme/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.js" type="text/javascript"></script> -->
<portlet:resourceURL var="addTask" id="addTask"></portlet:resourceURL>
<style>
.ar {
    text-align: right;
}
.color-blue {
    color: #247aba !important;
}
.table tbody td {
    font-weight: normal;
    padding: 8px 8px;
}
.table3 thead th{
	font-size: 20px !important;
	text-align:left !important;
	text-transform: initial !important;
	padding:5px 10px !important;
}
.table3  td{
	color:#7a7a7a !important;
	font-size: 16px !important;
	line-height: 1.5 !important;
}
.table3 thead th.td-center{
	text-align:center !important;
}
.table3 thead th.td-left{
	text-align:left !important;
}
.table3 thead th.td-right{
	text-align:right !important;
}

.modal .interest-modal{
	bottom: inherit;
	display: block;
	left: inherit;
	overflow: hidden;
	position: relative;
}

.modalareainterest .modal-header{
	background: #f1f3f7;
	border-radius: inherit !important;
	-webkit-border-radius: 0 !important;
	-moz-border-radius: 0 !important;
	color:black;
	height: auto;
    padding: 8px;
}
.modalareainterest .modal-dialog,
.modalareainterest .modal-content {
    min-width: 380px;
    max-width: 500px;
}
.modalareainterest .modal-body {
    margin-left: 0px;
    margin-right: 0px;
    max-width: inherit;
}
.modalareainterest .interest-modal {
    background: rgba(129,140,147,0.9);
    border: none;
    color: white;
    padding: 15px;
}
.modalareainterest .modal-body .form-group .control-label {
    font-size: 14px;
    line-height: 1.5;
    color: white;
    font-weight: 400;
    margin: 0;
}
.yui3-widget-mask,
.yui3-widget.modal-dialog {
	z-index: 1100 !important;
}
.modal-footer .btn-toolbar {
    flex-wrap: nowrap;
}
.wrap-input-calendar {
	position: relative;
	z-index: 0;
}
.wrap-input-calendar:after {
    color: #414142;
    content: "\f073";
    font-family: "Font Awesome 5 Solid";
    font-size: 20px;
    height: 25px;
    right: 2px;
    position: absolute;
    top: 10px;
    width: 25px;
    z-index: -1;
}
.table-task {
    color: #000;
}
.table-task tr {
    border-bottom: 1px solid #d6d6d6;
}
.td-valign-bottom .fas {
    font-size: 17px;
}
.icon-com-clip {
    font-size: 17px;
}
.table-task tbody td {
    padding: 15px 8px;
}
.td-icon-arrow {
    padding-bottom: 2.3rem !important;
}
.table-task tbody td, .table-task thead th {
    font-size: 13px !important;
}
.td-valign-top {
    vertical-align: top !important;
}
.td-valign-bottom {
    vertical-align: bottom !important;
    padding-bottom: 2.4rem !important;
}
.td-label {
    color: black;
    font-weight: bold;
    font-size: 15px;
    height: 32px;
}
.calendar-wrap .form-group .control-label:after {
    color: #414142;
    content: "\f073";
    font-family: "Font Awesome 5 Solid";
    font-size: 20px;
    height: 25px;
    right: 2px;
    position: absolute;
    top: 35px;
    width: 25px;
}
#addTask.modalareainterest .interest-modal .form-group .form-control {
    font-size: 14px;
}
.toltip-close {
    font-weight: bold;
    position: absolute;
    top: 8px;
    right: 10px;
}
.calendar-wrap #ui-datepicker-div {
	top: 65%!important;
    left: 70%!important;
}
.box-middle .form-group .form-control {
	font-family: 'Merriweather Sans',sans-serif;
}
</style>

<%

List<labScreenProjectPartners> partnersList = null;
labScreenProjectOverview labScreenProjectOverview = null;

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
	labScreenProjectOverview = labScreenProjectOverviewLocalServiceUtil.fetchlabScreenProjectOverview(PK_projectId);
	if(labScreenProjectOverview!=null){
		PK_interestId = labScreenProjectOverview.getInterestId();
	}
	DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(labScreenProjectPartners.class, PortalClassLoaderUtil.getClassLoader());
	 
	Criterion criterion = null;
	criterion = RestrictionsFactoryUtil.eq("PK_projectId", new Long(PK_interestId));
	 
	criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("isActive", new Long(0)));
	dynamicQuery.add(criterion);
	 
	partnersList = labScreenProjectPartnersLocalServiceUtil.dynamicQuery(dynamicQuery);
} 

%>

<script>
var A=AUI();
var namespaceId = "<%=renderResponse.getNamespace() %>";
$(document).ready(function(){
	debugger;
	loadDate();
	loadTask();
	$("#addTask").on('show.bs.modal', function(){
		$("#ui-datepicker-div").appendTo(".calendar-wrap");
	});
	$("#addTask").on('hide.bs.modal', function(){
		$("#ui-datepicker-div").appendTo("body");
	});
});

$(document).on("focus", ".dueDate", function(){
	$(this).datepicker({
			dateFormat: 'yy-mm-dd',
			changeMonth: true,
			changeYear: true,
			minDate: 0,
		}).on('changeDate', function() {
            
        });
});

$(document).on("focus", "#<portlet:namespace/>dueDate", function(){
	$(this).datepicker({
		dateFormat: 'yy-mm-dd',
		changeMonth: true,
		changeYear: true,
		minDate: 0,
		onClose:function() {
			$(this).removeClass("error-field");
			$(this).parent(".form-group").removeClass("has-error");
			$(this).siblings(".help-block").remove();
	      }
        });
});

function loadDate() {
	$( "#<portlet:namespace/>dueDate" ).datepicker({
		dateFormat: 'yy-mm-dd',
		changeMonth: true,
		changeYear: true,
		minDate: 0,
		onClose:function() {
			$(this).removeClass("error-field");
			$(this).parent(".form-group").removeClass("has-error");
			$(this).siblings(".help-block").remove();
	      }
	});
}

function dueDateChange(value,taskId){
	//alert(value+taskId)
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='dueDateChangeTask'/>"
		,{
              method: 'post',
              data:{ 	
            	  '<portlet:namespace/>taskId':taskId,
            	  '<portlet:namespace/>taskdueDate':value
              },
              sync : true, 
              on:{
           	   complete:function()
            		{		            		   
            		},
                   success:function()
                   {			                    	
                   		var value=this.get('responseData');	
			     		if(value=="update"){
                   			loadTask();   
                   			clearTask();
                   			/* loadDetailedScreen(); */
             		    }else{
             			   showMsg("Error!!");
             		    }
                   },error: function(){	             
                   }
			},

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

function addTask(){
	AUI().use('aui-io-request-deprecated', function(A){
        A.io.request('<%=addTask.toString()%>', {
               method: 'post',
               form: {
                   id: '<portlet:namespace/>addTaskForm',
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
            			   $("#addTask").modal("hide");
            			   showMsg("Added successfully");
            			   loadTask();
            			   clearTask();
            		   }else  if(data.details[1].responseText!=null && data.details[1].responseText=="update"){
            			   $("#addTask").modal("hide");
            			   showMsg("Updated successfully");
            			   loadTask();
            			   clearTask();
            		   }else{
            			   showMsg("You can't assign task to others");
            		   }
                   },
                   failure:function(data){
                	   //$("#wait").hide();
                   }
               }
            });
    	});
}

function clearTask(){
	$("#popup_title").html("Add Task");
	$("#<portlet:namespace/>taskId").val("0");
	$("#<portlet:namespace/>dueDate").val("");
	$("#<portlet:namespace/>projectAssignedTo").val("");
	$("#<portlet:namespace/>taskName").val("");
}

function loadTask(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='viewTask'/>"
			,{
               method: 'post',
               data:{ 	
            	   '<portlet:namespace/>milestoneName':$("#<portlet:namespace/>milestoneName").val()
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
                    		$("#taskOverview").html("");
                    	    $("#taskOverview").html(j.template);
                    	    if(j.isNotLink=="false"){
                        		$("#donut_status").attr("href","<%=themeDisplay.getURLPortal() %>"+"/lab-detailed-screen");
                        	}
                 	   }
                    	$("#bradleyTaskOverviewLoader").fadeOut();
                    },error: function(){	             
                    }
				},

	         });
		});
}

function getViewData(taskId){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getViewTask'/>"
		,{
              method: 'post',
              data:{ 	
            	  '<portlet:namespace/>taskId':taskId
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
                   		$("#popup_title").html("Edit Task");
                   		$("#<portlet:namespace/>taskId").val(j.taskId);
                   		$("#<portlet:namespace/>taskName").val(j.taskName);
                   		$("#<portlet:namespace/>projectAssignedTo").val(j.projectAssignedTo);
                   		$("#<portlet:namespace/>dueDate").val(j.dueDate);
                   		$("#addTask").modal("show");
                	   }
                   },error: function(){	             
                   }
			},

         });
	});
}

function statusChange(value,taskId){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='statusChangeTask'/>"
		,{
              method: 'post',
              data:{ 	
            	  '<portlet:namespace/>taskId':taskId,
            	  '<portlet:namespace/>status':value
              },
              sync : true, 
              on:{
           	   complete:function()
            		{		            		   
            		},
                   success:function()
                   {			                    	
                   		var value=this.get('responseData');	
			     		if(value=="update"){
                   			loadTask();   
                   			getProjectPercentage();
                   			updateDonut();
                   			/* loadDetailedScreen(); */
             		    }else{
             			   showMsg("Error!!");
             			  loadTask();
             		    }
                   },error: function(){	             
                   }
			},

         });
	});
}

function projectAssignedToChange(value,taskId){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='projectAssignedTask'/>"
		,{
              method: 'post',
              data:{ 	
            	  '<portlet:namespace/>taskId':taskId,
            	  '<portlet:namespace/>projectAssigned':value
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
                   		if(value=="update"){
                   			loadTask();             			   
             		    }else{
             			   showMsg("You can't assign task to others");
             			   loadTask();     
             		    }
                   },error: function(){	             
                   }
			},

         });
	});
}

function removeData(taskId){
	AUI().use('aui-io-request-deprecated','aui-modal', function(A){
		var modal = new A.Modal(
			      {
			    	bodyContent: '<center> Are you Sure ? </center>',
			        centered: true,
			        headerContent: '<center><h4 class="font-weight-semibold m-0"> Message</h4></center>',
			        modal: true,
			        render: '#modal',
			        zIndex: 9,
			        toolbars: {
			        		 header: []
			         },
			        width: 305
			      }
			    ).render();
		
			modal.addToolbar(
	  	      [
	  	        
	  	          {
	  	            label: 'Okay',
	  	            on: {
	  	              click: function() {
	  	       				modal.hide();
	  	    				removeTask(taskId);
 	  	    			   }
	  	              }
	  	            },
  	       			{
	  	            	label: 'Cancel',
	  	            	on:{
	  	              		click: function()
	  	              		{
	  	          	 			modal.hide();
	  	              		}
	  	            }
	  	          }
	  	      ]
	  	    );
	});
}

function removeTask(taskId){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='removeTask'/>"
			,{
               method: 'post',
               data:{ 		
            	   "<portlet:namespace/>taskId":taskId
               },
               sync : true, 
               on:{
            	   complete:function()
             		{		            		   
             		},
                    success:function()
                    {			                    	
                    	var value=this.get('responseData');
                    	if(value!=null && value!="undefined" && value!=undefined  && value!="null" && value=="removed"){
                    		showMsg("Removed successfully");
                    		loadTask();
                    		// scrollToInterest();
                 	    }else{
                 	    	showMsg("Error!");
                 	    }                    	
                    },error: function(){	             
                    }
				},

	         });
		});
}
</script>

