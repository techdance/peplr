<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<script>
var A = AUI();
$(document).ready(function(){
	$("#showErrorMessage").hide();
	loadRecommenedPartners();
});

function loadRecommenedPartners(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='loadRecommenedPartners'/>"
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
                    	var value=this.get('responseData');
                    	debugger;                    	
                    	if(value!=null && value!="undefined" && value!=undefined && value=="showmessage"){
                    		$("#showErrorMessage").show();
                    	}
                    	if(value!=null && value!="undefined" && value!=undefined && value!="showmessage"){
                    		$("#showErrorMessage").hide();
                    		var data = JSON.parse(value);
                    		if(data.length>0){
                    			for(var i=0;i<data.length;i++){
                    				$(".dashboardnews").append("<div class='item'><div class='item-img partner-img position-relative'>"
                    					+ "<a href='javascript:void(0);''><img  src='"+data[i].imageURL+"' alt=''></a> </div>"
                    					+ "<div class='item-text dynamicitemtext'><span class='partner partner-name'>"+data[i].userName+"</span>"
                    					+ "<span class='partner partner-title'>"+data[i].department+"</span>"
                    					+ "<span class='partner partner-university'>"+data[i].institutionName+"</span>"
                    					+ "<span class='partner partner-address'>"+data[i].institutionLocation+"</span>"
                    					+ "</div></div>"
                    				);
                    			}
                    		}
                    	}
                    	
                    },error: function(){	             
                    }
				},

	         });
		});
}
</script>
<style>
	.dynamicitemtext{
		margin-left:4px;
	}
	.dashboardnews .item .item-img img{
	   border-radius:50%;
	}
	#showErrorMessage p {
	    line-height: 22px;
	    font-size: 14px;
	    border: 1px solid #80808021;
	    padding: 5px;
	    box-shadow: 0 0 2px #0000001f;
	    border-radius: 4px;
        border-left: 2px solid #299eff;
	}
</style>