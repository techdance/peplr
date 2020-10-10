<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>
.box-subhead i, .box-subhead span {
    position: absolute;
    left: 0px;
    top: 3px;
}
.icon-regular::before, .icon-regular::after {
    font-family: 'Font Awesome 5 Regular';
}
.icon-users::before {
    content: "\f0c0";
}
.font-bold {
    font-weight: bold !important;
}
.tooltips {
    display: inline-block !important;
}
.row-custom {
    margin-right: -11px;
    margin-left: -11px;
}
.rightSideContentPP {
	margin-top: 38px;
}
</style>

<script>
$(document).ready(function(){
	getMyProjectsPartners();
});

function getMyProjectsPartners(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getMyProjectsPartners'/>"
		,{
              method: 'post',
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
            		   //$(".templatePast").html("");
                	   if(value !=undefined && value!="undefined" &&  value!=null && value!="null"){
                		   $("#projectPartnersContent").html("");
                		   $("#projectPartnersContent").html(value);
                	   }     
                	   $("#projectPartnersLoader").fadeOut();
                   },error: function(){	             
                   }
			},

         });
	});
}
</script>