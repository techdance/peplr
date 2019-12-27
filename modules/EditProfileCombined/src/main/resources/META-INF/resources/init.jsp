<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<portlet:resourceURL var="saveCollaborationInterest" id="saveCollaborationInterest"></portlet:resourceURL>
<portlet:resourceURL var="updateProfile" id="updateProfile"></portlet:resourceURL>
<portlet:resourceURL var="saveCredentialsForm" id="saveCredentialsForm"></portlet:resourceURL> 
<portlet:resourceURL var="savecommunicationForm" id="savecommunicationForm"></portlet:resourceURL>
<portlet:resourceURL var="saveProfileForm" id="saveProfileForm"></portlet:resourceURL>
<style>
.portlet {
	margin-bottom: 0 !important;
}
.yui3-widget-ft.modal-footer {
    display: block;
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
    /* transform: translateX(-50%); */
}

.view-more-interest {
    cursor: pointer;
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
.interest-modal {
    background: white;
    border: 1px solid rgb(232, 232, 232);
    bottom: auto;
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
.research-uploadbtn {
	overflow:hidden;
}
.research-uploadbtn input{
	opacity:0;
	font-size:0px;
    position: absolute;
  		top: -24px;
}
.research-uploadbtn  .form-group{
	margin-bottom:0px;
}

.list-style-custom{
	padding-left: 0px;
    padding-right: 0px;
    border: 0px;
}
</style>

<script>
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
			        zIndex:9,
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
                    	var value=this.get('responseData');	
                    	debugger;
                    	if(value!=null && value!="undefined" && value!=undefined){
                    		var data = JSON.parse(value);
         	        		$("#<portlet:namespace/>firstName").val(data.firstName);
         	                $("#<portlet:namespace/>lastName").val(data.lastName);
         	                $("#<portlet:namespace/>jobTitle").val(data.jobTitle);
         	                $("#<portlet:namespace/>prefixValue").val(data.prefixValue);
         	               // $("#<portlet:namespace/>status").val(data.status);
         	                $("#userImage").attr("src",data.profileImage);
         	               // $("#<portlet:namespace/>ExpandoAttribute--profileStatus--").val(data.profileStatus);
         	                //$("input[id*='profileStatus']").val(data.profileStatus);
         	                $(".profile-status").find("textarea").val(data.profileStatus);
         	                $("input[name=<portlet:namespace/>ExpandoAttribute--onlineStatus--][value="+data.onlineStatus+"]").attr('checked', 'checked');
         	              // $("input[name=<portlet:namespace/>ExpandoAttribute--onlineStatus--][value="+data.onlineStatus+"]").attr('checked', 'checked');
                 	   }
                    },error: function(){	             
                    }
				},

	         });
		});
}

function removeProfileImage()
{
	AUI().use('aui-io-request-deprecated','aui-modal', function(A){
		var modal = new A.Modal(
			      {
			    	bodyContent: '<center> Are you Sure ? </center>',
			        centered: true,
			        headerContent: '<center>Message</center>',
			        modal: true,
			        render: '#modal',
			        zIndex: 9,
			        toolbars: {
			        		 header: []
			         },
			        width: 305
			      }
			    ).render();
		
			modal.addToolbar(
	  	      [
	  	        
	  	          {
	  	            label: 'Okay',
	  	            on: {
	  	              click: function() {
	  	       				modal.hide();
	  	    				deleteProfileImage();
 	  	    			   }
	  	              }
	  	            },
  	       			{
	  	            	label: 'Cancel',
	  	            	on:{
	  	              		click: function()
	  	              		{
	  	          	 			modal.hide();
	  	              		}
	  	            }
	  	          }
	  	      ]
	  	    );
	});
}

function deleteProfileImage(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='removeProfileImage'/>"
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
                    	if(value!=null && value!="undefined" && value!=undefined && value=="removed"){
                    		showMsg("Removed successfully");
                    		loadUserInfo();
                 	    }else{
                 	    	showMsg("Error!");
                 	    }                    	
                    },error: function(){	             
                    }
				},

	         });
		});
}



// Edit Credentials
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
         	             	$("#<portlet:namespace/>credentialId").val(data.credentialId);
                 	   }
                    },error: function(){	             
                    }
				},

	         });
		});
}


// Edit Collaboration Interests
jQuery(function() {
	$("#courseDevelopmentPopup").hide();
	loadUserInfo();
    loadUserCredential();
    loadProjectDetails();
    loadProfessionalBio();
    loadInstituteProfile();
	jQuery("#add-interest").click(function(e){
		e.stopPropagation();
		jQuery("#add-interest-modal").slideToggle();
	});
	jQuery("#add-interest-modal .toltip-close2 a").click(function(e){
		e.stopPropagation();
		jQuery("#add-interest-modal").slideToggle();
	});

	jQuery("#view-more-interest-modal .toltip-close2 a").click(function(e){
		e.stopPropagation();
		jQuery("#view-more-interest-modal").slideToggle();
	});
	$('#<portlet:namespace />uploadedDocument').change(function() {
        if ($(this).val()) {
            error = false;
            var filename = $(this).val();
            filename = this.value.replace(/\\/g, '/').replace(/.*\//, '');
            $(this).closest('.browse-file').find('.input-values').html(filename).addClass("available");
            $("#doc-upload-chipset").html("");
            if (error) {
                parent.addClass('error').prepend.after('<div class="alert alert-error">' + error + '</div>');
            }
        }
    });
});

function clearFile(){
	debugger;
	var test=$("#<portlet:namespace />uploadedDocument").val();
	if(test!=""){
		$('.input-values').html("");
	}
}

function updateTextInput(val) {
	$("#<portlet:namespace/>experienceLevel").val(val); 
}

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
                    			
                    			for(var i=0;i<data.length;i++){
                    				if(data[i].deliveryMethod==""){
	                    				$("#area-of-interest-block").append("<div class='col-md-6 mb-3'><div class='editcollaboratedarea areas-of-interest"+i+"'><div class='row row-custom position-relative'><span class='left-corner'>"+ (i + 1) +"</span><div class='col-md-6'><p> <strong>Project</strong><br> "+data[i].projectType+" </p>"
	                    					+ "</div> <div class='col-md-6'> <p> <strong>Discipline</strong><br> "+data[i].discipline+" </p> <p> <strong>Region</strong><br> "+data[i].region+" </p> </div></div> "
	                    					+ " <div class='row row-custom mt-2'><div class='col-md-6'><div class='position-relative'><a href='javascript:void(0);' class='view-more-interest' onclick='getViewMoreData("+data[i].id+")'>View more</a><div id='popup-"+data[i].id+"'></div></div></div><div class='col-md-6 text-right'><a href='#' onclick='removeCollaborationInterest("+data[i].id+")'>Remove</a></div></div></div></div>"
	                    					/* + " <a href='#' class='btn btn-blue col-sm-6 p-2' onclick='goToMatching("+data[i].id+")'>Find Matches</a>"
	                    					+ " <a href='javascript:void(0);' class='view-more-interest col-sm-6 ml-1 pt-1' onclick='getViewMoreData("+data[i].id+")'>View more</a>  </div>" */
   	                    					
	                    				);
                    				}
                    				else{
                    					$("#area-of-interest-block").append("<div class='col-md-6 mb-3'><div class='editcollaboratedarea areas-of-interest"+i+"'><div class='row row-custom position-relative'><span class='left-corner'>"+ (i + 1) +"</span><div class='col-md-6'><p> <strong>Project</strong><br> "+data[i].projectType+" </p>"
   	                    					+ " <p> <strong>Delivery Method</strong><br> "+data[i].deliveryMethod+" </p>  </div> <div class='col-md-6'> <p> <strong>Discipline</strong><br> "+data[i].discipline+" </p> <p> <strong>Region</strong><br> "+data[i].region+" </p> </div></div> "
   	                    					+ " <div class='row row-custom mt-2'><div class='col-md-6'><div class='position-relative'><a href='javascript:void(0);' class='view-more-interest' onclick='getViewMoreData("+data[i].id+")'>View more</a><div id='popup-"+data[i].id+"'></div></div></div><div class='col-md-6 text-right'><a href='#' onclick='removeCollaborationInterest("+data[i].id+")'>Remove</a></div></div></div></div>"
   	                    					/* + " <a href='#' class='btn btn-blue col-sm-6  p-2' onclick='goToMatching("+data[i].id+")'>Find Matches</a>"
   	                    					+ " <a href='javascript:void(0);' class='view-more-interest col-sm-6 ml-1 pt-1' onclick='getViewMoreData("+data[i].id+")'>View more</a> </div>" */
   	                    					
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

function updateProfileInformation(){
	AUI().use('aui-io-request-deprecated', function(A){
        A.io.request('<%=updateProfile.toString()%>', {
               method: 'post',
               form: {
                   id: '<portlet:namespace/>updateProfileForm',
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
            		   showMsg("Updated successfully");
            		   /* if(data.details[1].responseText=="update"){
            			   showMsg("Updated successfully");
            		   }else{
            			   showMsg("Not saved");
            		   } */
            		   loadUserInfo();
                   },
                   failure:function(data){
                	   //$("#wait").hide();
                   }
               }
            });
    	});
}



// Edit Credentials

function saveUserCredentials(){
	AUI().use('aui-io-request-deprecated', function(A){
        A.io.request('<%=saveCredentialsForm.toString()%>', {
               method: 'post',
               form: {
                   id: '<portlet:namespace/>credentialsForm',
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
            		   var id = $("#<portlet:namespace/>credentialId").val();
            		   if(data.details[1].responseText=="add"){
            			   showMsg("Saved successfully");
            		   }else if(data.details[1].responseText=="update"){
            			   showMsg("Updated successfully");
            		   }else{
            			   showMsg("Not saved");
            		   }
                   },
                   failure:function(data){
                	   //$("#wait").hide();
                   }
               }
            });
    	});
} 

// Edit Communication Preferences

function saveUserCommuncationPreferences(){
	AUI().use('aui-io-request-deprecated', function(A){
        A.io.request('<%=savecommunicationForm.toString()%>', {
               method: 'post',
               form: {
                   id: '<portlet:namespace/>communicationForm',
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
            		   var id = $("#<portlet:namespace/>communicationId").val();
            		   if(data.details[1].responseText=="add"){
            			   showMsg("Saved successfully");
            		   }else if(data.details[1].responseText=="update"){
            			   showMsg("Updated successfully");
            		   }else{
            			   showMsg("Not saved");
            		   }
                   },
                   failure:function(data){
                	   //$("#wait").hide();
                   }
               }
            });
    	});
} 

function saveProfile(buttonRequest){
	$("#<portlet:namespace/>addInterestButton").val(buttonRequest);
	var prefixValue = $("#<portlet:namespace/>prefixValue").val();
	var firstName = $("#<portlet:namespace/>firstName").val();
	var lastName = $("#<portlet:namespace/>lastName").val();
	var jobTitle = $("#<portlet:namespace/>jobTitle").val();
	
	if(prefixValue!="" && firstName!="" && lastName!="" && jobTitle!=""){
		AUI().use('aui-io-request-deprecated', function(A){
	        A.io.request('<%=saveProfileForm.toString()%>', {
	               method: 'post',
	               form: {
	                   id: '<portlet:namespace/>updateProfileForm',
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
	            		   var collaborationInterestId = $("#<portlet:namespace/>collaborationInterestId").val();
	            		   var communicationId = $("#<portlet:namespace/>communicationId").val();
	            		   var credentialId = $("#<portlet:namespace/>credentialId").val();
	            		   var addInterestId = $("#<portlet:namespace/>addInterestId").val();
	            		   if(data.details[1].responseText!=null && data.details[1].responseText!=undefined){
	            			   $("#add-interest-modal").hide();
	            			   showMsg("Saved successfully");
	            			   loadUserInfo();
	            			   loadUserCredential();
	            			   loadProjectDetails();
	            			   loadProfessionalBio();
	            			   loadInstituteProfile();
	            		   }else{
	            			   $("#add-interest-modal").hide();
	            			  // showMsg("Not saved");
	            			   loadUserInfo();
	            			   loadUserCredential();
	            			   loadProjectDetails();
	            			   loadProfessionalBio();
	            			   loadInstituteProfile();
	            		   }
	                   },
	                   failure:function(data){
	                	   //$("#wait").hide();
	                   }
	               }
	            });
	    	});
	}
}

//Communication Preferences 

function loadUserCommunicationPreferences(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getCommunicationData'/>"
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
         	        		$("#<portlet:namespace/>communicationId").val(data.communicationId);
         	                $("#<portlet:namespace/>primaryLanguageName").val(data.primLangName);
         	                $("#<portlet:namespace/>secondaryLanguageName").val(data.secLangName);
         	                $("#<portlet:namespace/>tertiaryLanguageName").val(data.terLangName);         	            
         	               	$("#<portlet:namespace/>primaryLanguage").val(data.primLangId);
         	              	$("#<portlet:namespace/>secondaryLanguage").val(data.secoLangId);
         	             	$("#<portlet:namespace/>tertiaryLanguage").val(data.terLangId);
         	           		$("#<portlet:namespace/>communicationEmail").val(data.email);
         	           	    $("#<portlet:namespace/>communicationPhoneNumber").val(data.phoneNum);
         	           		$("#<portlet:namespace/>communicationWebsite").val(data.website);         	           		
                 	   }
                    },error: function(){	             
                    }
				},

	         });
		});
}

function  loadProfessionalBio(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getProfessionalBio'/>"
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
         	        		$("#<portlet:namespace/>professionalBioId").val(data.professionalBioId);
         	                $("#<portlet:namespace/>areasofexpertise1").val(data.areasofexpertise1);
         	                $("#<portlet:namespace/>areasofexpertise2").val(data.areasofexpertise2);
         	                $("#<portlet:namespace/>areasofexpertise3").val(data.areasofexpertise3);         	            
         	               	$("#<portlet:namespace/>experienceLevelUI").val(data.experienceLevelUI);
         	              	$("#<portlet:namespace/>experienceLevel").val(data.experienceLevel);
         	             	$("#<portlet:namespace/>cvLink").val(data.cvLink);
         	           		$("#<portlet:namespace/>bioDescription").val(data.bioDescription);      	           		
                 	   }
                    },error: function(){	             
                    }
				},

	         });
		});
}

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
                    		var data = JSON.parse(value);
         	        		$("#<portlet:namespace/>institutionProfileId").val(data.institutionProfileId);
         	                $("#<portlet:namespace/>institutionName").val(data.institutionName);
         	                $("#<portlet:namespace/>academCalendar").val(data.academCalendar);
         	                $("#<portlet:namespace/>departamentDescription").val(data.departamentDescription);         	            
         	                if(data.subDetails.length>0){
         	                	var sub = data.subDetails;
         	                	for(var i=0;i<sub.length;i++){
         	                		console.log(sub[i].fileName+"======="+sub[i].url);
        	                		$('#file-nameapnd').append("<a target='_blank' class='list-group-item list-group-item-action list-style-custom' href="+ sub[i].url +"><i class='fa fa-paperclip mr-2'></i>" +sub[i].fileName + "</a>");
         	                	}
         	                }      		
                 	   }
                    },error: function(){	             
                    }
				},

	         });
		});
}

function removeCollaborationInterest(id)
{
	AUI().use('aui-io-request-deprecated','aui-modal', function(A){
		var modal = new A.Modal(
			      {
			    	bodyContent: '<center> Are you Sure ? </center>',
			        centered: true,
			        headerContent: '<center>Message</center>',
			        modal: true,
			        render: '#modal',
			        zIndex: 9,
			        toolbars: {
			        		 header: []
			         },
			        width: 305
			      }
			    ).render();
		
			modal.addToolbar(
	  	      [
	  	        
	  	          {
	  	            label: 'Okay',
	  	            on: {
	  	              click: function() {
	  	       				modal.hide();
	  	    				deleteCollaborationInterest(id);
 	  	    			   }
	  	              }
	  	            },
  	       			{
	  	            	label: 'Cancel',
	  	            	on:{
	  	              		click: function()
	  	              		{
	  	          	 			modal.hide();
	  	              		}
	  	            }
	  	          }
	  	      ]
	  	    );
	});
}

function deleteCollaborationInterest(id){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='removeCollaborationInterest'/>"
			,{
               method: 'post',
               data:{ 		
            	   "<portlet:namespace/>profileInterestId":id
               },
               sync : true, 
               on:{
            	   complete:function()
             		{		            		   
             		},
                    success:function()
                    {			                    	
                    	var value=this.get('responseData');
                    	if(value!=null && value!="undefined" && value!=undefined && value=="removed"){
                    		showMsg("Removed successfully");
                    		loadProjectDetails();
                 	    }else{
                 	    	showMsg("Error!");
                 	    }                    	
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