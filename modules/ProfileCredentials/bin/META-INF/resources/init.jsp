<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>
.icon-id-card::before {
    content: "\f2c2";
}
.icon-user-graduate::before {
    content: "\f501";
}
.icon-trophy-alt::before {
    content: "\f2eb";
}
.icon-file-certificate::before {
    content: "\f5f3";
}
</style>

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
                    	if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                    		$("#profileCredentials").html(value);
                 	   }
                    	$("#profileCredentialsLoader").fadeOut();
                    },error: function(){	             
                    }
				},

	         });
		});
}
</script>