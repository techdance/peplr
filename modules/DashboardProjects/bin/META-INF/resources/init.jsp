<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>
.toltip2.menu-toltip ul li a {
    pointer-events: none;
}
.icon-book-alt-light2:before {
    content: "\f02d";
    font-family: "Font Awesome 5 Regular";
}
.icon-fa-box:before {
    font-size: 18px;
    height: auto;
    left: 0px;
    position: absolute;
    top: 0px;
}
tr.row-color-green td, tr.row-color-green td a {
    color: #339900 !important;
    line-height: 1;
}
tr.row-color-blue, tr.row-color-blue td a {
    color: #084265 !important;
    line-height: 1;
}
tr.row-color-orange td, tr.row-color-orange td a {
    color: #ff993e !important;
    line-height: 1;
}
.row-color-blue {
    color: #084265;
}
.table thead th:first-child,
.table tbody td:first-child {
	text-align: left;
	padding-left: 0;
}
.table tbody td, .table thead th {
    font-size: 13px !important;
}
.icon-size-40 {
    font-size: 40px !important;
}
.table tbody td {
    font-weight: 600;
    padding: 8px 8px;
    font-size: 13px;
}
.row-color-orange {
    color: #ff993e;
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
.dashboardMyProjects .icon-box {
	pointer-events: none;
}
</style>

<script>
$(document).ready(function(){
	var tbody = $("#projectTable tbody");
	if (tbody.children().length == 0) {
	    tbody.html("<tr><td colspan='8' class='text-center'>No Projects Added</td></tr>");
	}

	getMyProjects();
});

function getMyProjects(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='loadMyProjectDetails'/>"
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
                	   $("#templateData").html("");
                	   var value=this.get('responseData');
                	   if(value!=null && value!="undefined" && value!=undefined && value!="null"){
	                	   $("#templateData").html(value);
	                	   $('.circular-chart').easyPieChart({
	                		   scaleColor: "transparent",
	                           lineWidth: 10,
	                       });
                	   }
                	   $("#dashboardMyProjectsLoader").fadeOut();
                   },error: function(){	             
                   }
			},

         });
	});
}

function goToLabScreen(labId){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='goToLabScreen'/>"
		,{
              method: 'post',
              data:{
            	  '<portlet:namespace/>projectId':labId
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
                		location.href="/lab-detailed-screen";
                	  
                   },error: function(){	             
                   }
			},

         });
	});
}
</script>