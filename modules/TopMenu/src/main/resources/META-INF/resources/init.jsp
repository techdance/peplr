<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>
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
</style>

<script>
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

$(document).ready(function(){
	$("#btn-sign-out").click(function(){
		$('#userModal').modal('hide');
	});
	$("#badgesModalClose").click(function(){
		$('#badgesModal').modal('hide');
	});
})
</script>
