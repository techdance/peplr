<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-cron.js"></script>

<link type="text/css" href="<%=request.getContextPath() %>/css/jquery-cron.css" rel="stylesheet" />

<style>
#submitForReview {
	display: none;
}
body .toltip-overlay {
	background: rgba(136,145,152,0.95);
}
.menu-toltip.toltip-overlay a:hover {
    background: #929292;
}
.top-icon {
    vertical-align: middle;
}
.toltip-item {
    padding: 15px 0px;
}
div p:last-child {
    font-family: 'Merriweather Sans',sans-serif;
}
.modalToltip .toltip {
    display: block !important;
    margin: auto;
    position: relative;
    top: 0px;
}
.modalToltip .modal-dialog {
    position: relative;
    display: table;
    overflow-y: auto;
    overflow-x: auto;
    width: 100%;
    min-width: 300px;
}
.modalToltip .modal-dialog, .modalToltip .modal-body, .modalToltip .modal-content {
    background: none;
    border: none;
    padding: 0px;
    max-width: 370px;
}
.modalToltip .toltip-overlay {
    background: #889299;
}

#badgesModal .modal-dialog {
    margin: 135px 0 0 200px;
}
#notificationModal .modal-dialog {
    margin: 135px 0 0 325px;
}
#messagesModal .modal-dialog {
    margin: 135px 0 0 400px;
}
#userModal .modal-dialog {
    margin: 125px 0 0 450px;
}
#page-register-default > :not(#wrapper) #userModal .modal-dialog {
    margin: 65px 0 0 450px;
}
.portlet-body{
	height:auto;
}
.toltip-item .close-times {
    position: absolute;
    right: 5px;
    top: 0;
    color: #fff;
    font-size: 20px;
}




.top-icon-fa {
    color: #0099ff !important;
    height: 50px;
    width: 40px;
}
.top-icon-fa:before {
    font-family: "Font Awesome 5 Solid";
    font-size: 37px;
    position: absolute;
    top: 11px;
}
.top-icon-award:before {
    content: "\f559";
}
.top-icon-bell:before {
    content: "\f0f3";
    font-family: "Font Awesome 5 Pro";
    transform: rotate(15deg);
}
.top-icon-comment:before {
    content: "\f075";
    font-family: "Font Awesome 5 Pro";
}

.btn-group-menu .dropdown-menu {
    background: transparent !important;
    border: none !important;
    border-radius: 0px;
    padding: 0px !important;
    max-width: inherit;
}
.btn-group-menu .toltip {
    color: white;
    display: block !important;
    position: relative;
    border-radius: 5px;
    top: 0px;
}
.icon-fa-box {
    position: relative;
}
.toltip-title {
    font-size: 18px;
    font-family: 'Merriweather Sans', sans-serif;
}
.icon-award:before {
    content: "\f559";
}
.icon-fa-box:before {
    font-family: "Font Awesome 5 Solid";
    font-size: 18px;
    height: auto;
    left: 0px;
    position: absolute;
    top: 0px;
}
.icon-size-120 {
    font-size: 120px !important;
}
#email-toltip .toltip-header .toltip-header-right {
    font-size: 12px;
    font-weight: bold;
    float: right;
    line-height: 1;
    margin-right: 10px;
}
.top-icon span.note {
    top: 7px !important;
    right: 2px !important;
}
.top-icon.icon-2 img {
    -ms-transform: rotate(0);
    -webkit-transform: rotate(0);
    transform: rotate(0);
}
#notification-toltip {
	max-height: 400px;
    overflow: auto;
}
#notification-toltip .toltip-overlay:hover,
#email-toltip .toltip-overlay:hover {
    background: rgba(61,68,73,0.95);
}
.top-icon-fa.disabled:before {
	color: #c0c0c0;
}
.top-icon-fa.disabled .note {
	display: none;
}
body .toltip-overlay {
	background: rgb(124, 135, 142)!important;
}
body .toltip-overlay:hover {
    background: rgba(61,68,73,0.95)!important;
}
.menu-toltip a:hover {
    background: #929292!important;
}
.top-icon.hello .menu-toltip a {
	color: #fff!important;
}
.btn-group-menu .toltip {
    color: white;
    display: block !important;
    position: relative;
    border-radius: 5px;
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    top: 0px;
}
#sign-out-logo-image {
	max-width: 150px;
    max-height: 130px;
}
</style>
<%
long selectedProfileMatching = 0;long userId = 0;User selectedUser = null;String selectedUserName = "";
HttpServletRequest httprequest = PortalUtil.getHttpServletRequest(renderRequest);
httprequest = PortalUtil.getOriginalServletRequest(httprequest);

HttpSession httpsession = httprequest.getSession();
long currentUser = 0;String sessionuserID = "";
//out.println(httpsession.getAttribute("currentUser"));
if(httpsession.getAttribute("currentUser")!=null){
	currentUser = (Long)httpsession.getAttribute("currentUser");
	if(currentUser>0 && currentUser==themeDisplay.getUserId()){
		if(httpsession.getAttribute("MATCHING_KEY")!=null){
			sessionuserID = (String)httpsession.getAttribute("MATCHING_KEY");
			if(sessionuserID!=""){
			selectedProfileMatching = new Long(sessionuserID); }	
		}
	}
} 
if(selectedProfileMatching>0){
	userId = selectedProfileMatching;
	selectedUser = UserLocalServiceUtil.getUser(userId);
	if(selectedUser!=null){
	selectedUserName = selectedUser.getFullName();}
}
%>
<script>
var A = AUI();
$(document).ready(function() {
	var showChar = 100;
	var ellipsestext = "...";
	var moretext = "more";
	var lesstext = "less";
	$('.messagecontent .toltip-body .toltip-content p').each(function() {
		var content = $(this).html();

		if(content.length > showChar) {

			var c = content.substr(0, showChar);
			var h = content.substr(showChar-1, content.length - showChar);

			var html = c + '<span class="moreellipses">' + ellipsestext+ '&nbsp;</span><span class="morecontent"><span>' + h + '</span></span>';

			$(this).html(html);
		}

	});
	$("#submitForReview").on("click", function(){
		setTimeout(function(){ 
			$("#submitModal").modal("show");
		}, 300);
	});
	
	$('#submitModal').on('shown.bs.modal', function (e) {
		setTimeout(function(){ 
			$('#submitModal').modal("hide");
			$("#confirmationMessage").modal("show");
		}, 2000);
	});
	$('#moveToDashboard').on('click', function () {
		$("#confirmationMessage").modal("hide");
		$("#submitedForApproval").modal("show");
	})
	
	var url_string = '<%=themeDisplay.getURLPortal()+themeDisplay.getURLCurrent() %>';
	var url = new URL(url_string);
	var param = url.searchParams.get("project");
	var fromMatches = url.searchParams.get("showInvite");
	if(param!="" && param!=null && param!="null" && param=="approved"){
		projectApproved();
		//projectComplete();
	}
	if(fromMatches!="" && fromMatches!=null && fromMatches!="null" && fromMatches=="true"){
		//Add extra breadcrumb here 
		<%--  username = '<%=selectedUserName %>' --%>
		<%-- $(".breadcrumb").html("");
		$(".breadcrumb").append("<li class='breadcrumb-item'><a href='/home1'>Home</a></li><li class='breadcrumb-item'><a href='/profile'>Profile</a></li><li class='breadcrumb-item'><a href='/resources'>Matches</a></li><li class='breadcrumb-item active' aria-current='page'><%=selectedUserName %></li>"); --%>
		$(".breadcrumb").html("");
		$(".breadcrumb").html("<li class='breadcrumb-item'><a href='/home1'>Home</a></li><li class='breadcrumb-item'><a href='/profile'>Profile</a></li><li class='breadcrumb-item'><a href='/matching-screen'>Matches</a></li><li class='breadcrumb-item active' aria-current='page'><%=selectedUserName %></li>");
	}
});

$(document).ready(function(){
	$("#btn-sign-out").click(function(){
		$('#userModal').modal('hide');
	});
	$("#badgesModalClose").click(function(){
		$('#badgesModal').modal('hide');
	});
	getMyNotificationCount();
	
	$(".top-icon-fa.top-icon-comment").on("dblclick", function(){
		document.location.href = "/web/guest/project-invites";
	})
	setInterval(function(){ 
	    //this code runs every second 
		getMyNotificationCount();
	}, 45*1000);
});

function goToMyProfile(userId){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='loadMyProfileDetails'/>"
		,{
              method: 'post',
              data:{
              	  '<portlet:namespace/>key':userId
              },
              sync : true, 
              on:{
           	   complete:function()
            		{		            		   
            		},
                   success:function()
                   {	
                	   location.href="<%=themeDisplay.getURLPortal() %>"+"/profile";
                   },error: function(){	             
                   }
			},

         });
	});
}

function getMyNotificationCount(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getMyNotificationCount'/>"
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
                	   $("#notification-toltip").html("");
                	   $("#email-toltip .toltip-body").html("");
                	   $("#notifyCount").html("");
            		   $("#messageCount").html("");
                	   if(value !=undefined && value!="undefined" &&  value!=null && value!="null"){
                		   var data = JSON.parse(value);
                		   $("#notifyCount").html(data.notificationCount);
                		   $("#messageCount").html(data.messageCount);
                		   $("#notification-toltip").append(data.template2);
                		   $("#email-toltip .toltip-body").append(data.template1);
                		   /* $("#email-toltip .toltip-body").append(data.template1); */
                	   }               	                  	   
                   },error: function(){	             
                   }
			},

         });
	});
}

function closeActionNotification(actionId,type){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='closeAction'/>"
		,{
              method: 'post',
              data:{
            	  '<portlet:namespace/>actionId':actionId,
            	  '<portlet:namespace/>type':'notification'
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
                	   if(value !=undefined && value!="undefined" &&  value!=null && value!="null"){
                		   getMyNotificationCount();
                	   }               	                  	   
                   },error: function(){	             
                   }
			},

         });
	});
}

function closeActionMessage(actionId,type){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='closeAction'/>"
		,{
              method: 'post',
              data:{
            	  '<portlet:namespace/>actionId':actionId,
            	  '<portlet:namespace/>type':'message'
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
                	   if(value !=undefined && value!="undefined" &&  value!=null && value!="null"){
                		   getMyNotificationCount();
                	   }               	                  	   
                   },error: function(){	             
                   }
			},

         });
	});
}

function closeActionMessageDiscussion(actionId,type){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='closeActionMessageDiscussion'/>"
		,{
              method: 'post',
              data:{
            	  '<portlet:namespace/>actionId':actionId,
            	  '<portlet:namespace/>type':'message'
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
                	   if(value !=undefined && value!="undefined" &&  value!=null && value!="null"){
                		   getMyNotificationCount();
                	   }               	                  	   
                   },error: function(){	             
                   }
			},

         });
	});
}

/* function projectComplete(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='projectComplete'/>"
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
                   },error: function(){	             
                   }
			},

         });
	});
}  */

function projectApproved(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='projectApproved'/>"
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
                	   $(".modal-backdrop.fade.show").remove();
                   },error: function(){	             
                   }
			},

         });
	});
}

</script>
