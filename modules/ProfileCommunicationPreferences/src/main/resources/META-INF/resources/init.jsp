<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<script>
function loadUserCommunicationPreferences(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getProfileCommunicationPreferenceData'/>"
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
                    	debugger;
                    	var value=this.get('responseData');	
                    	if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                    		var data = JSON.parse(value);
                    		$("#primaryLanguage_Communication").text(data.primaryLanguage_Communication);
                    		$("#secondaryLanguage_Communication").text(data.secondaryLanguage_Communication);      	                
                    		$("#emailId_Communication").text(data.emailId_Communication);
         	                $("#phoneNumber_Communication").text(data.phoneNumber_Communication);
         	                $("#website_Communication").text(data.website_Communication);
         	                $("#emailId_Communication").attr("href", "mailto:"+data.emailId_Communication);
         	                $("#phoneNumber_Communication").attr("href", "tel:"+data.phoneNumber_Communication);
         	                $("#website_Communication").attr("href", data.website_Communication);
                 	   }
                    },error: function(){	             
                    }
				},

	         });
		});
}
</script>