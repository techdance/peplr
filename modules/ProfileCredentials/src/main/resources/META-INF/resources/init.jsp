<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />


<script>

jQuery(function() {
	loadProfessionalCredentials();
});

function loadProfessionalCredentials(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getCredentialData'/>"
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
                    	$("#profileCredentials").html("");
                    	if(value!=null && value!="undefined" && value!=undefined){
                    		$("#profileCredentials").html(value);
                 	   }
                    },error: function(){	             
                    }
				},

	         });
		});
}
</script>