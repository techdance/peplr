<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<script>

function loadUserInfo(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getProfileData'/>"
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
                    	if(value!=null && value!="undefined" && value!=undefined){
                    		var data = JSON.parse(value);
                    		$("#fullName").text(data.fullName);
                    		$("#jobTitle").text(data.jobTitle);      	                
                    		$("#prefixValue").text(data.prefixValue+". ").addClass("text-capitalize");
         	               // $("#<portlet:namespace/>status").val(data.status);
         	                $("#user-profile").attr("src",data.profileImage);
         	               // $("#<portlet:namespace/>ExpandoAttribute--profileStatus--").val(data.profileStatus);
         	                $("#profileStatus").text(data.profileStatus);
                 	   }
                    },error: function(){	             
                    }
				},

	         });
		});
}

</script>