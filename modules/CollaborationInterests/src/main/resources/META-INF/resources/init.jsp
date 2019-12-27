<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>
div.collaboration .content-icon {
    margin-bottom: 10px;
    color: black;
}
.interest-modal{
	background: white;
	border: 1px solid rgb(232, 232, 232);
	bottom:auto;
	display: none;
	font-size: 14px;
	left: -10px;
	line-height: 1.5;
	padding:15px;
	position: absolute;
	z-index: 1;
	margin-top:15px;
}

.interest-modal{
	width: 100%;
	max-width: 465px;
	left: auto;
	right: 0;
    /* transform: translateX(-50%); */
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
		    height: 100%;
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
		section.wrap-profile .content-icon {
		    color: black;
		}
		.top-label-range {
		    display: flex;
		    justify-content: space-between;
		}
		.ac {
		    text-align: center;
		}
		.areas-of-interest p small {
		    display: block;
		    font-size: 12px;
		    line-height: 14px !important;
		}
</style>
<portlet:resourceURL var="saveCollaborationInterest" id="saveCollaborationInterest"></portlet:resourceURL>
<script>
jQuery(function() {
	$("#courseDevelopmentPopup").hide();
	loadProjectDetails();
	 
	jQuery("#add-interest").click(function(e){
		e.stopPropagation();
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
                    			for(var i=0;i<data.length;i++){
                    				console.log("i is", i);
                    				if(data[i].deliveryMethod==""){
                    					$("#area-of-interest-block-profile").append("<div class='col-md-6 mb-3'><div class='editcollaboratedarea areas-of-interest"+i+"'><div class='row row-custom position-relative'> "
                    						+ "<span class='left-corner'>"+ (i + 1) +"</span><div class='col-md-6'><p> <strong>Project</strong><br> <small>"+data[i].projectType+"</small> </p>"
                    						+ "</div> <div class='col-md-6'> <p> <strong>Discipline</strong><br> <small>"+data[i].discipline+"</small> </p> <p> <strong>Region</strong><br> <small>"+data[i].region+" </small></p> </div> </div>"
                    						/* + " <div class='row row-custom mt-2'><div class='col-md-6'><div class='position-relative'><a href='javascript:void(0);' class='view-more-interest' onclick='getViewMoreData("+data[i].id+")'>View more</a><div id='popup-"+data[i].id+"'></div></div></div><div class='col-md-6 text-right'><a href='#'>Remove</a></div></div>" */
                    						+ " <div class='row row-custom mt-2'><div class='col-md-6'><div class='text-center position-relative'><a href='javascript:void(0);' class='view-more-interest' onclick='getViewMoreData("+data[i].id+")'>View more</a><div id='popup-"+data[i].id+"'></div></div></div><div class='col-md-6'><a href='#' class='btn btn-blue btn-tiny' onclick='goToMatching("+data[i].id+")'>Find Matches</a></div></div></div>"
                    					);
                    				}
                    				else{
                    					$("#area-of-interest-block-profile").append("<div class='col-md-6 mb-3'><div class='editcollaboratedarea areas-of-interest"+i+"'><div class='row row-custom position-relative'><span class='left-corner'>"+ (i + 1) +"</span><div class='col-md-6'><p> <strong>Project</strong><br> <small>"+data[i].projectType+"</small> </p>"
                    						+ " <p> <strong>Delivery Method</strong><br> <small>"+data[i].deliveryMethod+"</small> </p>  </div> <div class='col-md-6'> <p> <strong>Discipline</strong><br> <small> "+data[i].discipline+"</small> </p> <p> <strong>Region</strong><br> <small> "+data[i].region+"</small> </p> </div> </div>"
                    						/* + " <div class='row row-custom mt-2'><div class='col-md-6'><div class='position-relative'><a href='javascript:void(0);' class='view-more-interest' onclick='getViewMoreData("+data[i].id+")'>View more</a><div id='popup-"+data[i].id+"'></div></div></div><div class='col-md-6 text-right'><a href='#'>Remove</a></div></div>" */
                    						+ " <div class='row row-custom mt-2'><div class='col-md-6'><div class='text-center position-relative'><a href='javascript:void(0);' class='view-more-interest' onclick='getViewMoreData("+data[i].id+")'>View more</a><div id='popup-"+data[i].id+"'></div></div></div><div class='col-md-6'><a href='#' class='btn btn-blue btn-tiny' onclick='goToMatching("+data[i].id+")'>Find Matches</a></div></div></div>" 
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
                    	console.log("id", id);
                    	$("#view-more-interest-modal").appendTo('#popup-'+id);
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

/* $(window).click(function(e) {
    relativeY = (e.pageY - $('.editcollaboratedarea').offset().top);
        $('#view-more-interest-modal').css('top',relativeY +"px");
}); */
</script>