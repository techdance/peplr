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
</script>
