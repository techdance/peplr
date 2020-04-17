<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<script>
function loadUserCredential(){
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
                    	if(value!=null && value!="undefined" && value!=undefined){
                    		var data = JSON.parse(value);
         	        		$("#<portlet:namespace/>membership1").val(data.membership1);
         	                $("#<portlet:namespace/>membership2").val(data.membership2);
         	                $("#<portlet:namespace/>membership3").val(data.membership3);
         	                $("#<portlet:namespace/>membership4").val(data.membership4);         	            
         	               	$("#<portlet:namespace/>certificate1").val(data.certificate1);
         	              	$("#<portlet:namespace/>certificate2").val(data.certificate2);
         	             	$("#<portlet:namespace/>certificate3").val(data.certificate3);
                 	   }
                    },error: function(){	             
                    }
				},

	         });
		});
}

</script>