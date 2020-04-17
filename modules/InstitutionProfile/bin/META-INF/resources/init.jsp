<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>
.list-style-custom{
	padding-left: 0px;
    padding-right: 0px;
    border: 0px;
}
.resourcepaper{
 	color: #09f !important;
     word-break: break-all;
}
.resourcepaper:hover{
        color: #0056b3 !important;
    background: transparent;
    
}

.headingresource{
    font-size: 16px !important;
}
</style>

<script>

jQuery(function() {
    loadInstituteProfile();
});

function loadInstituteProfile(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getInstituteProfile'/>"
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
                    		$("#institutionProfileData").html("");
                    		$("#institutionProfileData").html(value);
                 	   }
                    },error: function(){	             
                    }
				},

	         });
		});
}
</script>