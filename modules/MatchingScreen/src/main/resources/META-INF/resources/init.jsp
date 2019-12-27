<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>
	/* #portlet_com_collaborated_matching_portlet_MatchingScreenPortlet_INSTANCE_3YgDJpoVUMhb{
		margin-bottom: 0px !important;
	}
	.wrap-collaborated {
	    padding-bottom: 80px;
	}
	.wrap-collaborated div.asset {
	    padding: 35px 10px 6px;
	}
	.inner-wrap-flex {
	    display: flex;
	}
	.asset .content-left {
	    margin-right: 27px;
	}
	.asset .box-top {
	    margin-top: 0px;
	}
	.wrap-collaborated .asset h2 {
	    color: #000;
	    font-size: 18px;
	    font-weight: 700;
	    line-height: 24px;
	}
	.asset .box-middle {
	    font-size: 14px;
	    line-height: 24px;
	    margin-bottom: 26px;
	}
	.wrap-collaborated div.asset .content-left img {
	    width: 143px;
	    height: 143px;
	    border-radius: 50%;
	}
	.wrap-collaborated .asset h2:hover {
	    color: #09f;
	    transition: .2s;
	}
	@media (max-width: 767px){
		.asset .content-left {
		    margin-right: 0px;
		    margin-bottom: 20px;
		    text-align: center;
		}
		.inner-wrap-flex {
		    display: block;
		}
	} */
	
.inner-wrap-flex {
    display: flex;
    padding: 35px 10px 6px;
}
.asset .content-left {
    margin-right: 27px;
}
.wrap-collaborated .asset h2 {
    color: #000;
    font-size: 18px;
    font-weight: 700;
    line-height: 24px;
}
.hover-underline:hover {
    text-decoration: underline !important;
}
.color-blue-light, .color-blue-light-hover:hover {
    color: #2a9eff !important;
}
.asset .box-middle {
    font-size: 14px;
    line-height: 24px;
    margin-bottom: 20px;
}

</style>

<script>
function getAllDetails(id){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getAllDetails'/>"
		,{
              method: 'post',
              data:{
           	   '<portlet:namespace/>key':id
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
                   		if(data.length>0){
                   			for(var i=0;i<data.length;i++){
                   				$("#card-section").append("<div class='col-lg-6 mb-4'><div class='box box-border-radius box-shadow bg-white'><div class='inner-wrap inner-wrap-flex asset'> "
                   					+ "<div class='content-left'> <a href=''><img src='"+data[i].imageURL+"' alt=''></a> </div>" 
                   					+ "<div class='content-right'><div class='box-top position-relative'><h2><a href=''>"+data[i].userName+"</a></h2> </div>"
                   					/* + "<div class='box-middle p0'> <p>"+data[i].department+"</p><p><span class='font-style-italic color-blue-light'>"+data[i].institutionName+"</span></p><p>"+data[i].institutionLocation+"</p>" */
                   					+ "<div class='box-middle p0'> <p>Biochemistry & Cell Biology Research Faculty</p><p><span class='font-style-italic color-blue-light'>University of Oslo</span></p><p>Oslo, Norway</p>"
                   					+ " </div> </div> </div> </div> </div>"
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
function loadRecommenedPartners(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='loadRecommenedPartners'/>"
		,{
              method: 'post',
              data:{},
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
                   		if(data.length>0){
                   			for(var i=0;i<data.length;i++){
                   				$("#card-section").append("<div class='col-lg-6 mb-4'><div class='box box-border-radius box-shadow bg-white'><div class='inner-wrap inner-wrap-flex asset'> "
                   					+ "<div class='content-left'> <a href=''><img src='"+data[i].imageURL+"' alt=''></a> </div>" 
                   					+ "<div class='content-right'><div class='box-top position-relative'><h2><a href=''>"+data[i].userName+"</a></h2> </div>"
                   					/* + "<div class='box-middle p0'> <p>"+data[i].department+"</p><p><span class='font-style-italic color-blue-light'>"+data[i].institutionName+"</span></p><p>"+data[i].institutionLocation+"</p>" */
                   					+ "<div class='box-middle p0'> <p>Biochemistry & Cell Biology Research Faculty</p><p><span class='font-style-italic color-blue-light'>University of Oslo</span></p><p>Oslo, Norway</p>"
                   					+ " </div> </div> </div> </div> </div>"
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