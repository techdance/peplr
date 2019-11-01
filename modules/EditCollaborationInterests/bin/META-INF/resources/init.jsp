<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>

.interest-modal{
	background: white;
	border: 1px solid rgb(232, 232, 232);
	bottom:35px;
	display: none;
	font-size: 14px;
	left: -10px;
	line-height: 1.5;
	padding:15px;
	position: absolute;
	z-index: 1;
}

.interest-modal{
	width: 465px;
}

.interest-modal .toltip-close2 a{
	color:black;
	font-size: 20px;
	line-height: 20px;
}
.interest-modal .toltip-close2{
	font-weight: bold;
	position:absolute;
	top:-5px;
	right: -5px;
	z-index: 100;
}
.font11 {
    font-size: 11px !important;
    line-height: 1.5;
}
.font-style-italic {
    font-style: italic !important;
}
.interest-modal .form-group {
    margin-bottom: 10px;
}
.input-multiselect {
	margin-bottom: 10px;
}
.input-multiselect .form-group {
	margin-bottom: 0px;
}
.radio-button-container label {
    display: flex;
    align-items: center;
}
.radio-button-container label input {
    margin-right: 5px;
}
.row-custom {
		    margin-right: -11px;
		    margin-left: -11px;
		}
    	.editcollaboratedarea {
		    border-radius: 4px;
		    -moz-border-radius: 4px;
		    -webkit-border-radius: 4px;
		    color: black;
		    border: 1px solid #e8e8e8;
		    font-size: 14px !important;
		    line-height: 1.5;
		    margin-bottom: .5rem;
		    padding: 15px 20px;
		}
		span.left-corner {
		    font-weight: bold;
		    left: 0px;
		    position: absolute;
		    top: -14px;
		}
		.editcollaboratedarea p {
		    line-height: 1.3 !important;
		    margin-bottom: 5px !important;
		}
		.interest-modal {
		    width: 465px;
		}
		.interest-modal {
		    background: white;
		    border: 1px solid rgb(232, 232, 232);
		    bottom: 35px;
		    display: none;
		    font-size: 14px;
		    left: -10px;
		    line-height: 1.5;
		    padding: 15px;
		    position: absolute;
		    z-index: 1;
		}
		.interest-modal .toltip-close2 {
		    font-weight: bold;
		    position: absolute;
		    top: -5px;
		    right: -5px;
		    z-index: 100;
		}
		.interest-modal .toltip-close2 a {
		    color: black;
		    font-size: 20px;
		    line-height: 20px;
		}
		.btn-tiny {
		    font-size: 11px !important;
		    line-height: 11px !important;
		    padding: 6px !important;
		}
		@media (max-width:767px){
			.profilecollabortioninterest {
			    left: 0px !important;
			}
			.interest-modal {
			    width: 100% !important;
			}
		}
</style>
<portlet:resourceURL var="saveCollaborationInterest" id="saveCollaborationInterest"></portlet:resourceURL>
<script>
jQuery(function() {
	$("#courseDevelopmentPopup").hide();
	loadProjectDetails();
	 
	jQuery("#add-interest").click(function(e){
		e.stopPropagation();
		$("#<portlet:namespace/>CollaborationInterestForm")[0].reset();
		jQuery("#add-interest-modal").slideToggle();
	});
	jQuery("#add-interest-modal .toltip-close2 a").click(function(e){
		e.stopPropagation();
		jQuery("#add-interest-modal").slideToggle();
	});
	
	/* jQuery(".view-more-interest").click(function(e){
		e.stopPropagation();
		jQuery("#view-more-interest-modal").slideToggle();
	}); */

	jQuery("#view-more-interest-modal .toltip-close2 a").click(function(e){
		e.stopPropagation();
		jQuery("#view-more-interest-modal").slideToggle();
	});
});

var A=AUI();
Liferay.provide(window,'showMsg',function(msg){
		AUI().use(
		 'aui-modal',
		 function(A) {
		   var modal = new A.Modal(
		     {
		     centered: true,
		       headerContent: '<center><h4 class="font-weight-semibold m-0"> Message</h4></center>',
		       modal: true,
		       render: '#modal',
	       toolbars: {
	        header: []
	        },
	       width: 305,
	       zIndex:1,
	     }
	   ).render();
	
	   modal.set('bodyContent', msg);
	   
	modal.addToolbar(
	         [
	           {
	               label: 'OK',
	               on: {
	                 click: function() {
	                 modal.hide();
	                 
	                 }
	                 
	                 }
	               }
	             
	         ]
	);
	});

});

function loadProjectDetails(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getCollaborationInterest'/>"
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
                    		if(data.length>0){
                    			$("#area-of-interest-block").html("");
                    			$("#<portlet:namespace/>CollaborationInterestForm")[0].reset();
                    			for(var i=0;i<data.length;i++){
                    				if(data[i].deliveryMethod==""){
	                    				$("#area-of-interest-block").append("<div class='editcollaboratedarea areas-of-interest"+i+"'><div class='row'><div class='col-md-6'><p> <strong>Project</strong><br> "+data[i].projectType+" </p>"
	                    					+ "</div> <div class='col-md-6'> <p> <strong>Discipline</strong><br> "+data[i].discipline+" </p> <p> <strong>Region</strong><br> "+data[i].region+" </p> </div> "
	                    					+ " <a href='#' class='btn btn-blue col-sm-6 p-2' onclick='goToMatching("+data[i].id+")'>Find Matches</a>"
	                    					+ " <a href='javascript:void(0);' class='view-more-interest col-sm-6 ml-1 pt-1' onclick='getViewMoreData("+data[i].id+")'>View more</a>  </div>"
   	                    					
	                    				);
                    				}
                    				else{
                    					$("#area-of-interest-block").append("<div class='editcollaboratedarea areas-of-interest"+i+"'><div class='row'><div class='col-md-6'><p> <strong>Project</strong><br> "+data[i].projectType+" </p>"
   	                    					+ " <p> <strong>Delivery Method</strong><br> "+data[i].deliveryMethod+" </p>  </div> <div class='col-md-6'> <p> <strong>Discipline</strong><br> "+data[i].discipline+" </p> <p> <strong>Region</strong><br> "+data[i].region+" </p> </div> "
   	                    					+ " <a href='#' class='btn btn-blue col-sm-6  p-2' onclick='goToMatching("+data[i].id+")'>Find Matches</a>"
   	                    					+ " <a href='javascript:void(0);' class='view-more-interest col-sm-6 ml-1 pt-1' onclick='getViewMoreData("+data[i].id+")'>View more</a> </div>"
   	                    					
   	                    				);
                    				}
                    			}                    			
                    		}
                 	   	}
                    },error: function(){	             
                    }
				},

	         });
		});
}


function getViewMoreData(id){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getViewMoreData'/>"
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
                    	if(value!=null && value!="undefined" && value!=undefined){
                    		var data = JSON.parse(value);
                    		$(".view-project-type").text(data.projectType);
                    		$(".view-discipline").text(data.discipline);
                    		$(".view-delivery-type").text(data.deliveryMethod);
                    		$(".view-description").text(data.description);
                    		$(".view-campus").text(data.campus);
                    		$(".view-program-level").text(data.programLevel);
                    		$(".view-program-length").text(data.programLength);
                    		$(".view-credits").text(data.credits);
                    		$(".view-language").text(data.language);
                    		$(".view-location").text(data.region);
                    		$(".view-find-matches").html("");
                    		$(".view-find-matches").append('<a href="#" class="btn btn-blue btn-w-100 m-auto" onclick="goToMatching('+data.PK_areaofinterest+')">Find Matches</a>');
                    		$("#view-more-interest-modal").slideToggle();
                 	   	}
                    },error: function(){	             
                    }
				},

	         });
		});
}

function saveCollaborationInterest(){
	debugger;
	AUI().use('aui-io-request-deprecated', function(A){
        A.io.request('<%=saveCollaborationInterest.toString()%>', {
               method: 'post',
               form: {
                   id: '<portlet:namespace/>CollaborationInterestForm',
                   upload:true
               },
               cache: false,
               contentType: false,
               processData: false,
               on: {
            	   start:function(){
            		   //$("#wait").show();
            	   },
            	   complete: function(data){
            		   debugger;
            		   var id = $("#<portlet:namespace/>collaborationInterestId").val();
            		   if(data.details[1].responseText=="add"){
            			   $("#add-interest-modal").hide();
            			   showMsg("Saved successfully");
            			   loadProjectDetails();
            		   }else if(data.details[1].responseText=="update"){
            			   $("#add-interest-modal").hide();
            			   showMsg("Updated successfully");
            			   loadProjectDetails();
            		   }else{
            			   $("#add-interest-modal").hide();
            			   showMsg("Not saved");
            			   loadProjectDetails();
            		   }
                   },
                   failure:function(data){
                	   //$("#wait").hide();
                   }
               }
            });
    	});
}

function goToMatching(id){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='goToMatchingScreen'/>"
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
                    	location.href="<%=themeDisplay.getURLPortal() %>"+"/matching-screen?randamId="+id; 
                    },error: function(){	             
                    }
				},

	         });
		});
}
</script>