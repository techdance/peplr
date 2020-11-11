<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<style>
.partner-name:hover .toltip-phone {
	display: none;
}
#projectPartners .item-img {
    width: 58px;
}
#projectPartners .item-img img {
    width: 58px;
    height: 58px;
    object-fit: cover;
    border-radius: 50%;
}
.box-subhead i, .box-subhead span {
    position: absolute;
    left: 0px;
    top: 3px;
}
.icon-users::before {
    content: "\f0c0";
    font-family: 'Font Awesome 5 Regular';
}

.partner-title {
    color: #09f !important;
    font-weight: 400 !important;
    font-style: italic !important;
}
.partner {
    font-size: 12px;
    line-height: 16px;
}
.partner-university, .partner-address {
    color: #000 !important;
    font-weight: bold !important;
    font-style: normal !important;
}

</style>
<script>
var A=AUI();
var matchingRequestedId = 0;
$(document).ready(function(){
	loadProjectPartners();
});

function loadProjectPartners(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='loadProjectPartners'/>"
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
                    		$("#projectPartners").html("");
                    	    $("#projectPartners").html(value);
                 	   }
                    	$("#bradleyLabProjectPartnersLoader").fadeOut();
                    },error: function(){	             
                    }
				},

	         });
		});
}

function goToProfile(userId,interestId){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='loadProfileDetails'/>"
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
                	   location.href="<%=themeDisplay.getURLPortal() %>"+"/profile?showInvite=true";
                   },error: function(){	             
                   }
			},

         });
	});
}
</script>