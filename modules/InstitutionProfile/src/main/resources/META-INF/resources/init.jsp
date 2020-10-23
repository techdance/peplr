<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDTB30uKJgKRGvIVHavUEPKACPZkqkkifg&sensor=false"></script>
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
.icon-regular {
    margin-right: 5px;
}
.icon-user-shield::before {
    content: "\f505";
}
.icon-calendar-check::before {
    content: "\f274";
}
.icon-globe::before {
    content: "\f0ac";
}
.icon-globe-americas::before {
    content: "\f57d";
}
.icon-calendar-week::before {
    content: "\f784";
}
.icon-business-time::before {
    content: "\f64a";
}
.icon-hospital-user::before {
    content: "\f80d";
}
.gm-style-mtc > div:first-child {
    font-size: .75rem!important;
    padding: .5rem!important;
    height: auto!important;
}
#profile-map {
	position: relative;
	right: 0;
	-webkit-box-flex: 0;
    -ms-flex: 0 0 200px;
    flex: 0 0 200px;
    max-width: 200px;
}
</style>

<script>

jQuery(function() {
    //loadInstituteProfile();
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
                    	if(value!=null && value!="undefined" && value!=undefined && value!="null"){
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