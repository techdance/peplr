<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>
.ahea-profile-new .portlet-topper {
	display: none;
}
</style>
<script>

jQuery(function() {
	loadProfessionalBio();
});

function loadProfessionalBio(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getProfessionalBio'/>"
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
                    	$("#professionalBioData").html("");
                    	if(value!=null && value!="undefined" && value!=undefined){
                    		$("#professionalBioData").html(value);
                 	   }
                    },error: function(){	             
                    }
				},

	         });
		});
}
</script>