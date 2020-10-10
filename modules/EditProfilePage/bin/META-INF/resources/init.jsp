<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
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
<portlet:resourceURL var="Test" id="Test"></portlet:resourceURL>
<portlet:resourceURL var="updateAreaofinterest" id="updateAreaofinterest"></portlet:resourceURL>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDTB30uKJgKRGvIVHavUEPKACPZkqkkifg&sensor=false"></script>
<style>
.top .breadcrumb {
	display: none;
}
.portlet {
	margin-bottom: 0 !important;
}
/* .yui3-widget-ft.modal-footer {
    display: block;
} */

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
.viewmoredetail{
	max-width:465px !important;
	position:relative;
	
}
.maxheight80{
    height: 80px !important; 
}
#view-more-interest-modal{
	display:none;
}

.modal.show .viewmoredetail{
	display:block;
}
.viewmoredetail .modal-content{
	padding:15px;
    line-height: 1.5;
        height: 490px;
    overflow: auto;
}
.interest-modal{
	width: 100%;
	max-width: 465px;
	left: auto;
    /* transform: translateX(-50%); */
}
.top-label-range {
    display: flex;
    justify-content: space-between;
}

.view-more-interest {
    cursor: pointer;
}
.interest-modal{
	width: 465px;
}
.viewmoredetail .toltip-close2 a{
	color:black;
	font-size: 20px;
	line-height: 20px;
	    cursor: pointer;
}
.cursor-pointer{
    cursor: pointer;
}
.viewmoredetail .toltip-close2{
	font-weight: bold;
	position:absolute;
    top: 15px;
    right: 15px;
	z-index: 100;
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

.online-status .control-label {
	color: #000;
    font-size: 16px;
    font-weight: 700;
    line-height: 18px;
}
.online-status .lfr-ddm-field-group {
	margin-bottom: 0;
} 
.font20 {
    font-size: 20px !important;
    line-height: 1.5;
}
.box-middle .form-group .form-control {
	background-color: #ececec !important;
    border: 1px solid #d4d4d4;
    padding: 6px;
    height: 32px !important;
}
.form-control option[disabled] {
    color: rgba(153, 153, 153, .5);
}
.modalareainterest .modal-header{
	background: #f1f3f7;
	border-radius: inherit !important;
	-webkit-border-radius: 0 !important;
	-moz-border-radius: 0 !important;
	color:black;
	font-size: 20px;
    line-height: 1.5;
    padding: 8px;
    text-align: center;
}
.modalareainterest .interest-modal{
	background:rgba(129,140,147,0.9);
	border:none;
	color:white;
}
.modalareainterest .modal-content{
	border-radius: .3rem;
    -webkit-border-radius: .3rem;
    -moz-border-radius: .3rem;
     max-width: 100%;
}
.modalareainterest .viewmoredetail .modal-content{
	background:rgba(129,140,147,0.9);
	border:none;
	color:white;
}
.modal.modalareainterest .interest-modal {
    bottom: inherit;
    display: block;
    left: inherit;
    overflow: hidden;
    position: relative;
    width: 100%;
    max-width: 100%;
    margin: 0;
}
.tooltipdata .toltip-close2 {

    font-weight: bold;
    position: absolute;
    top: 5px;
    right: 5px;
    z-index: 100;

}
.toltip-close3 {
    position: absolute;
    top: 5px;
    right: 8px;
}
.toltip-close2 a, .toltip-close3 a {
    color: #818c93;
}
.modalareainterest .modal-body {
    padding: 0px;
    margin: 0px;
    max-width: 100%;
}
.font15 {
    font-size: 15px !important;
    line-height: 1.5;
}
.modalToltip .modal-dialog {
	min-width: 300px;
	max-width: 500px;
    margin: 1.75rem auto;
}
.text-left {
	float: none;
}

.modalareainterest .interest-modal .edit-section .toltip-close2 {
    top: 10px;
    right: 10px;
}
.modalareainterest .interest-modal .toltip-close2 a {
    color: #fff;
}
.modalareainterest .interest-modal label {
    color: white !important;
}
.modalareainterest .interest-modal .form-group .form-control {
    background-color: #ececec !important;
    border: 1px solid #d4d4d4;
    padding: 6px;
    border-radius: 5px;
    -moz-border-radius: 5px;
    -webkit-border-radius: 5px;
}
.modal-open .modal#view-more-interest-modal {
    overflow-y: auto;
}
.modalareainterest.modal {
	overflow: auto;
}
.modalareainterest.modal .viewmoredetail .modal-content {
	height: auto;
	overflow: hidden;
}
.modalareainterest.modal .modal-body {
	overflow: hidden;
}

.irs-grid-pol {
    display: none !important;
}
.irs-grid-pol.small {
    display: none !important;
}
span.irs-grid-text.js-grid-text-0 {
    display: block;
    left: -9px !important;
    margin-left: 0px !important;
}


.irs--big .irs-handle {
    top: 6px !important;
    width: 10px !important;
    height: 20px !important;
    border: 1px solid rgba(0,0,0,0.3);
    background-color: #cbcfd5;
    background: linear-gradient(to bottom, white 0%, #B4B9BE 30%, white 100%);
    box-shadow: 1px 1px 2px rgba(0,0,0,0.2), inset 0 0 3px 1px white;
    border-radius: 0px !important;
    -webkit-appearance: slider-horizontal !important;
}
.irs--big.irs-with-grid {
     height: 50px !important; 
}
.irs--big .irs-bar {
    top: 14px !important;
  }
.irs--big .irs-single {
    display: block;
       top: -10px !important;
}
.irs--big .irs-line {
    height: 4px !important;
        top: 14px !important;
}
.irs--big .irs-grid-text {
    color:white !important;
    font-family: 'Merriweather Sans',sans-serif;
    font-size: 14px;
}
.irs--big .irs-bar {
    top: 33px;
    height: 4px  !important;
    background-color: #f2f2f2;
    border: none  !important;
    background: #eaeaea  !important;
}
  .irs--big .irs-min, .irs--big .irs-max {
    font-family: 'Merriweather Sans',sans-serif;
    top: 0;
    padding: 1px 0px;
    color: white;
    text-shadow: none;
    background-color: #818c93;
    border-radius: 3px;
    font-size: 14px;
}
.irs--big .irs-min, .irs--big .irs-max {
    top: 0;
    padding: 1px 0px !important;
    color: white !important;
    text-shadow: none;
    background-color: transparent !important;
    border-radius: 3px;
    visibility: visible !important;
}
div#ui-datepicker-div {
    z-index: 9999 !important;
}
.pickerdata input {
    text-align: right;
    background: transparent;
    border: none;
    color: white;
    cursor: pointer;
}
.irs-min {
    display: none !important;
}
span.irs-max,.irs-from ,.irs-to ,.irs-single {
    display: none;
}
.yearpicker-container {
    z-index: 9999;
}
.formGroupmb0 .form-group {
	margin-bottom: 0;
}
/* .formGroupmb0:not(.lastFormGroup):not(.active):not(.showIcon) > a, */
.formGroupmb0.showIcon .form-group,
.selectableDR:not(.active),
.nonEditable {
	opacity: .85;
	pointer-events: none;
	cursor: not-allowed;
}
.formGroupmb0:not(.active):not(.showIcon) > a .showIfActive {
	display: inline-block
}
/* .formGroupmb0:not(.active):not(.showIcon) > a .showIfNotActive {
	display: none
} */
/* .formGroupmb0.active > a .showIfActive {
	display: none
} */
/* .formGroupmb0:not(.showIcon) > a .showIfActive {
	display: none;
}
.formGroupmb0.showIcon > a .showIfNotActive {
	display: none;
} */
.formGroupmb0.showIcon .form-control {
	opacity: 1;
}
.selectableDR.collaborationShow,
.selectableDR:not(.active),
.selectableDREdit:not(.active) {
	display: none;
}
.rangerDisabled {
	opacity: .85;
	pointer-events: none;
	cursor: not-allowed;
}
.labelOnly {
	opacity: 0;
    visibility: hidden;
    pointer-events: none;
}
.form-group.form-inline.input-checkbox-wrapper {
    min-height: 63px;
}
.form-group.form-inline.input-checkbox-wrapper label {
	color: #555555;
    font-size: 14px;
    margin-top: 25px;
}
.titleMultilineBottom {
	min-height: 44px;
    display: flex;
    align-items: flex-end;
}
.fullwidth .form-group {
	width: 100%;
}
.icon-regular::before, .icon-regular::after {
    font-family: 'Font Awesome 5 Regular';
}
.icon-book-user::before {
    content: "\f7e7";
}
.icon-globe-stand::before {
    content: "\f5f6";
}
.icon-user-ninja::before {
    content: "\f504";
}
.icon-shield-check::before {
    content: "\f2f7";
}
.icon-camcorder::before {
    content: "\f8a8";
}
.icon-user-secret::before {
    content: "\f21b";
}
.icon-s-search::before {
    content: "\f002";
}
.icon-comment-smile::before {
    content: "\f4b4";
}
.icon-trophy-alt::before {
    content: "\f2eb";
}
.icon-file-certificate::before {
    content: "\f5f3";
}
.icon-user-graduate::before {
    content: "\f501";
}
.icon-id-card::before {
    content: "\f2c2";
}
.icon-comment-dots::before {
    content: "\f4ad";
}
.icon-hospital-user::before {
    content: "\f80d";
}
.icon-user-circle::before {
    content: "\f2bd";
}
.icon-user-cog::before {
    content: "\f4fe";
}
.box-subhead span {
    position: absolute;
    left: 0px;
    top: 3px;
}
.cl-asset-type-d {
    color: #ff993e;
}	
.cl-hover-black:hover {
    color: #000 !important;
}

.fileinput-preview img {
    width: 170px;
    height: 170px;
    object-fit: cover;
}
.icon-info .info-toltip {
    background: black;
    color: white;
    display: none;
    font-family: 'Merriweather Sans', sans-serif;
    font-size: 10px;
    font-weight: normal;
    line-height: 13px;
    padding: 7px;
    position: absolute;
    bottom: 9px;
    left: 8px;
    width: 250px;
    z-index: 100;
}
.cl-blue {
	color: #0099ff !important;
}
.box-subhead {
	max-width: inherit;
}
.form-group .input.inactive-input {
    background-color: #848586 !important;
    color: #505050;
    pointer-events: none;
    cursor: default;
}
.overlay-inactive {
    position: absolute;
    top: 0;
    width: 100%;
    opacity: 0.5;
    background-color: #6f7880;
    pointer-events: none;
    cursor: default;
    height: 100%;
    left: 0;
    border-radius: 8px;
    -webkit-border-radius: 8px;
    -moz-border-radius: 8px;
    -ms-border-radius: 8px;
    -o-border-radius: 8px;
    z-index: 100;
}
</style>
<link rel="stylesheet" href="/o/ahea-theme/css/yearpicker.css" />
<link rel="stylesheet" href="/o/ahea-theme/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="/o/ahea-theme/css/ion.rangeSlider.min.css"/>

<script src="/o/ahea-theme/js/bootstrap-datepicker.js"></script>
<script src="/o/ahea-theme/js/yearpicker.js"></script>
<script src="/o/ahea-theme/js/ion.rangeSlider.min.js"></script>
<%
long institutionProfileId=0;
String instituteName = "",academicCalendar="",department="", region = "",cityState="",address1="",address2="",postalCode="";
JSONObject instituteProfile = null;JSONObject institutionContact = null, instituteProfileContact = null;
PortletSession sessionObj = renderRequest.getPortletSession();
instituteProfile = (JSONObject)sessionObj.getAttribute("INSTITUTE_PROFILE",PortletSession.APPLICATION_SCOPE);
if(instituteProfile!=null){
	instituteName = instituteProfile.getString("institutionName");
	academicCalendar = instituteProfile.getString("academicCalendar");
	institutionContact = instituteProfile.getJSONObject("institutionContact");
	instituteProfileContact = instituteProfile.getJSONObject("institutionLocation");
	if(institutionContact!=null){
		department = institutionContact.getString("department");
	}
	if(instituteProfileContact!=null){
		cityState = instituteProfileContact.getString("city")+", "+instituteProfileContact.getString("state");
		address1 = instituteProfileContact.getString("address1");
		address2 = instituteProfileContact.getString("address2");
		postalCode = instituteProfileContact.getString("postalCode");
		region = instituteProfileContact.getString("region");
	}
}
%>
<script>
var A=AUI();
var userRegional = "<%=region %>";
var monthNames = [
    "Jan", "Feb", "Mar",
    "Apr", "May", "Jun", "Jul",
    "Aug", "Sept", "Oct",
    "Novr", "Dec"
];
function monthNameToNum(monthname) {
    var month = monthNames.indexOf(monthname);
    return month ? month : 0;
}
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
                    	if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                    		var data = JSON.parse(value);
         	        		$("#<portlet:namespace/>firstName").val(data.firstName);
         	                $("#<portlet:namespace/>lastName").val(data.lastName);
         	                $("#<portlet:namespace/>jobTitle").val(data.jobTitle);
         	                $("#<portlet:namespace/>prefixValue").val(data.prefixValue);
         	                // $("#<portlet:namespace/>status").val(data.status);
         	                if(data.isBase64==true){
         	                	$("#userImage").attr("src","data:image/png;base64,"+data.profileImage);
         	                	$(".img-circle").attr("src","data:image/png;base64,"+data.profileImage);
         	                }else{
         	                	$("#userImage").attr("src",data.profileImage);
         	                	$(".img-circle").attr("src",data.profileImage);
         	                }         	                
         	                
         	               // $("#<portlet:namespace/>ExpandoAttribute--profileStatus--").val(data.profileStatus);
         	                //$("input[id*='profileStatus']").val(data.profileStatus);
         	                $(".profile-status").find("textarea").val(data.profileStatus);
         	                if(data.onlineStatus.length>0){
         	                	$("input[name=<portlet:namespace/>ExpandoAttribute--onlineStatus--][value="+data.onlineStatus+"]").attr('checked', 'checked');
         	                }
         	               $("#editPersonalInformationLoader").fadeOut();
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
                    	if(value!=null && value!="undefined" && value!=undefined && value!="null" && value=="removed"){
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
                    	if(value!=null && value!="undefined" && value!=undefined && value!="null"){
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
	$(".showOnourseDevelopment").addClass("d-none");
	
	loadUserInfo();
    loadUserCredential();
    loadProjectDetails();
    loadProfessionalBio();
    //loadInstituteProfile();
	jQuery("#add-interest").click(function(e){
		e.stopPropagation();
		jQuery("#add-interest-modal").modal('show');
	});
	/* jQuery("#add-interest-modal .toltip-close2 a").click(function(e){
		e.stopPropagation();
		//jQuery("#add-interest-modal").slideToggle();
		jQuery("#add-interest-modal").hide();
		jQuery(".modal-backdrop").hide();
	}); */

	/* jQuery("#view-more-interest-modal .toltip-close2 a").click(function(e){
		e.stopPropagation();
		jQuery(".modal").hide();
		jQuery(".modal-backdrop").hide();
		//jQuery(".popupmodal").hide();
	}); */
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
	console.log(val);
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
                    	if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                    		var data = JSON.parse(value);
                    		if(data.length>0){
                    			$("#area-of-interest-block").html("");                    			
                    			for(var i=0;i<data.length;i++){
                    				var lang = "";var region = "";
                    				if(data[i].language!="undefined"){
                    					lang = data[i].language;
                    				}     
                    				if(data[i].collaborationType=="Departmental" || data[i].collaborationType=="Institutional"){
                    					region = "";
                    				}else{
                    					region = data[i].region1;
                    				}
                        			//if(data[i].language==""){
                    					//$("#area-of-interest-block").append("<div class='col-md-6 mb-3'><div class='editcollaboratedarea areas-of-interest"+i+"'><div class='row row-custom position-relative'><span class='left-corner'>"+ (i + 1) +"</span><div class='col-md-6'><p> <strong>Project</strong><br> "+data[i].projectType+" </p>"
    	                    				//	+ "</div> <div class='col-md-6'> <p> <strong>Discipline</strong><br> "+data[i].discipline1+" </p> <p> <strong>Region</strong><br> "+region+" </p> </div></div> "
    	                    				//	+ " <div class='row row-custom mt-2'><div class='col-md-6'><div class='position-relative cursor-pointer'><a href='javascript:void(0);' class='view-more-interest' onclick='getViewMoreData("+data[i].id+")'>View more</a><div id='popup-"+data[i].id+"' class='modal fade'></div></div></div><div class='col-md-6 text-right cursor-pointer'><a href='javascript:void(0);' onclick='removeCollaborationInterest("+data[i].id+")'>Remove</a></div></div></div></div>"
    	                    					/* + " <a href='#' class='btn btn-blue col-sm-6 p-2' onclick='goToMatching("+data[i].id+")'>Find Matches</a>"
    	                    					+ " <a href='javascript:void(0);' class='view-more-interest col-sm-6 ml-1 pt-1' onclick='getViewMoreData("+data[i].id+")'>View more</a>  </div>" */
       	                    					
    	                    			//	);
                    				// }
                    				// else{
                    					$("#area-of-interest-block").append("<div class='col-md-6 mb-3'><div class='editcollaboratedarea areas-of-interest"+i+"'><div class='row row-custom position-relative'><span class='left-corner'>"+ (i + 1) +"</span><div class='col-md-6'><p> <strong>Project</strong><br> "+data[i].projectType+" </p>"
   	                    					+ " <p> <strong>Preferred Language</strong><br> "+lang+" </p>  </div> <div class='col-md-6'> <p> <strong>Discipline</strong><br> "+data[i].discipline1+" </p> <p> <strong>Region</strong><br> "+region+" </p> </div></div> "
   	                    					+ " <div class='row row-custom mt-2'><div class='col-md-6'><div class='position-relative cursor-pointer'><a href='javascript:void(0);' class='view-more-interest' onclick='getViewMoreData("+data[i].id+")'>View more</a><div id='popup-"+data[i].id+"' class='modal fade'></div></div></div><div class='col-md-6 text-right cursor-pointer'><a href='javascript:void(0);' onclick='removeCollaborationInterest("+data[i].id+")'>Remove</a></div></div></div></div>"
   	                    					/* + " <a href='#' class='btn btn-blue col-sm-6  p-2' onclick='goToMatching("+data[i].id+")'>Find Matches</a>"
   	                    					+ " <a href='javascript:void(0);' class='view-more-interest col-sm-6 ml-1 pt-1' onclick='getViewMoreData("+data[i].id+")'>View more</a> </div>" */
   	                    					
   	                    				);
                    				// }
                    			}                    			
                    		}
                 	   	}
                    	$("#editCollaborationInterestLoader").fadeOut();
                    	<%-- var url_param = '<%=themeDisplay.getURLPortal()+themeDisplay.getURLCurrent() %>';
                    	var current_url = new URL(url_param);
                    	var param = current_url.searchParams.get("param");
                    	console.log("param==="+param);
                    	if(param!="" && param=="interest"){
                    		$("html, body").animate({ scrollTop: $(".collaboration").offset().top }, 500);
                    	} --%>
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
                    	debugger;
                    	
                    	// $("#view-more-interest-modal").appendTo('#popup-'+id);
                    	
                    	var value=this.get('responseData');	
                    	if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                    		var data = JSON.parse(value);
                    		$(".view-project-type").text(data.projectType);
                    		$(".view-discipline1").text(data.discipline1);
                    		$(".view-discipline2").text(data.discipline2);
                    		$(".view-discipline3").text(data.discipline3);
                    		$(".view-delivery-type").text(data.deliveryMethod);
                    		$(".view-description").text(data.description);
                    		$(".view-collaboration-type").text(data.collaborationType);
                    		//$("#<portlet:namespace />projectDescriptionEdit").val(data.description);
                    		if(data.programLevel=='Post Doctoral'){
                    			$(".view-program-level").text("Post-Doctoral");
                    		}else{
                    			$(".view-program-level").text(data.programLevel);
                    		}
                    		$(".view-program-level").text(data.programLevel);
                    		$(".view-program-length").text(data.programLength);
                    		$(".view-credits").text(data.credits);
                    		$(".view-language").text(data.language);
                    		$(".view-location1").text(data.region1);
                    		$(".view-location2").text(data.region2);
                    		$(".view-location3").text(data.region3);
                    		$(".view-location4").text(data.region4);
                    		$(".created_date").text(data.created);
                    		$(".currentMonthStart1").text(data.startMonth);
                    		$("#currentday1").text(data.startYear);
                    		$(".view-find-matches").html("");
                    		var slider = $("#projectRange1").data("ionRangeSlider");
                    		slider.update({ from: monthNameToNum(data.endMonth) });
                    		//$("#projectRange1").ionRangeSlider({ to: data.endMonth});
                    		$("#rangerDatepicker1").val(data.endYear);
                    		console.log("data.endMonth", data.endMonth);
                    		console.log("data.endYear", data.endYear);
                    		$(".view-find-matches").append('<button type="button" class="btn btn-blue btn-w-100 m-auto editInterest">Edit</button> <a href="#" class="btn btn-blue btn-w-100 m-auto" onclick="goToMatching('+data.PK_areaofinterest+')">Find Matches</a>');
                    		//$("#view-more-interest-modal").modal();
                    		// $('#popup-'+id).modal('show');
                    		$('#view-more-interest-modal').modal('show');
                    		
                    		$(".editInterest").on("click", function(){ debugger;
                    			$("#<portlet:namespace/>updateInterestId").val(data.PK_areaofinterest);
                    			$("#<portlet:namespace/>projectTypeEdit").val(data.projectType);
                    			// getProjectTypeStatus(data.projectType);
                    			$("#<portlet:namespace/>projectDescriptionEdit").val(data.description);
                    			if(data.collaborationType === "Global") {
                    				$('.selectableDREdit').show();
                    			} else {
                    				$('.selectableDREdit').not(".first").hide();
                    			}
                    			if(data.region1 === "All") {
                    				$("[id^='<portlet:namespace/>locationEdit']").parents('.selectableDREdit').not(".first").removeClass("active");
                    				$("#<portlet:namespace/>locationEdit2, #<portlet:namespace/>locationEdit3, #<portlet:namespace/>locationEdit4").val("");
                    			}
                    			
                    			$("#<portlet:namespace/>locationEdit1").parents('.selectableDREdit').addClass("active");
                    			$("#<portlet:namespace/>disciplineEdit1").parents('.selectableDREdit').addClass("active");
                    			$("#<portlet:namespace/>disciplineEdit1").val(data.discipline1);
                    			$("#<portlet:namespace/>locationEdit1").val(data.region1);
                    			$("#<portlet:namespace/>disciplineEdit2").val(data.discipline2);
                    			$("#<portlet:namespace/>locationEdit2").val(data.region2);
                    			$("#<portlet:namespace/>disciplineEdit3").val(data.discipline3);
                    			$("#<portlet:namespace/>locationEdit3").val(data.region3);
                    			$("#<portlet:namespace/>locationEdit4").val(data.region4);
                    			
                    			$("#<portlet:namespace/>deliveryMethodEdit").val(data.deliveryMethodEdit);
                    			$("#<portlet:namespace/>collaborationTypeEdit").val(data.collaborationType);
                    			$(".currentMonthStart2").text(data.startMonth);
                    			$("#currentday2").text(data.startYear);
                    			var sliderEdit = $("#projectRange2").data("ionRangeSlider");
                    			sliderEdit.update({ from: monthNameToNum(data.endMonth) });
                    			$("#rangerDatepicker2").val(data.endYear);
                    			$("#<portlet:namespace/>endYearRangeEdit").val(data.endYear);
                    			$("#<portlet:namespace/>endMonthRangeEdit").val(data.endMonth);
                    			/*var regionArray = data.region.split(',');
                    			for (var i=0;i<regionArray.length;i++){
                    				$("#<portlet:namespace/>locationEdit option[value='"+(regionArray[i])+"']").attr("selected",true);
                    			}
                    			
                    			var disciplneArray = data.discipline.split(',');
                    			for (var i=0;i<disciplneArray.length;i++){
                    				$("#<portlet:namespace/>disciplineEdit option[value='"+(disciplneArray[i])+"']").attr("selected",true);
                    			} */
                    			$("#<portlet:namespace/>preferredLanguageEdit").val(data.language);
                    			$("#<portlet:namespace/>programLengthEdit").val(data.programLength);
                    			$("#<portlet:namespace/>programLevelEdit").val(data.programLevel);
                    			$("#<portlet:namespace/>creditsEdit").val(data.credits);
                    			if(data.collaborationType === "Departmental" || data.collaborationType === "Institutional") {
                    				$('#<portlet:namespace/>locationEdit1').parents(".selectableDREdit").removeClass("active").show();
                    			} 
                    			else {
                    				$('#<portlet:namespace/>locationEdit1').parents(".selectableDREdit").addClass("active").show();
                    			}
                    			if($("#<portlet:namespace/>disciplineEdit1").val() != "") {
                    				$("#<portlet:namespace/>disciplineEdit1").parents('.selectableDREdit').addClass("active");
                    				$("#<portlet:namespace/>disciplineEdit1").parents('.selectableDREdit').next().addClass("active");
                    			}
                    			if($("#<portlet:namespace/>disciplineEdit2").val() != "") {
                    				$("#<portlet:namespace/>disciplineEdit2").parents('.selectableDREdit').addClass("active");
                    				$("#<portlet:namespace/>disciplineEdit2").parents('.selectableDREdit').next().addClass("active");
                    			}
                    			if($("#<portlet:namespace/>locationEdit1").val() != "") {
                    				$("#<portlet:namespace/>locationEdit1").parents('.selectableDREdit').addClass("active");
                    				$("#<portlet:namespace/>locationEdit1").parents('.selectableDREdit').next().addClass("active");
                    			}
                    			if($("#<portlet:namespace/>locationEdit2").val() != "") {
                    				$("#<portlet:namespace/>locationEdit2").parents('.selectableDREdit').addClass("active");
                    				$("#<portlet:namespace/>locationEdit2").parents('.selectableDREdit').next().addClass("active");
                    			}
                    			if($("#<portlet:namespace/>locationEdit3").val() != "") {
                    				$("#<portlet:namespace/>locationEdit3").parents('.selectableDREdit').addClass("active");
                    				$("#<portlet:namespace/>locationEdit3").parents('.selectableDREdit').next().addClass("active");
                    			}
                    			
                    			if(data.projectType =="Course Development"){
                    				$("#courseDevelopmentPopup1").show();
                    				$(".edit-section .showOnourseDevelopment").removeClass("d-none");
                    			} else if (data.projectType =="Curriculum Development"){
                    				$("#courseDevelopmentPopup1").show();
                    				$(".edit-section .programLength").hide();
                    			} else if(data.projectType =="Study Abroad" || value=="Other"){
                    				$(".edit-section .collaborationShow").hide();
                    				$(".selectableDREdit").not(".first").hide();
                    			}
                    			
                    			
                    			$(".view-more-interest-modal-inner").addClass("d-none");
                    			$(".edit-section").removeClass("d-none");
                    		});
                    		
                    		
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
	debugger;
	
	$("#<portlet:namespace/>addInterestButton").val(buttonRequest);
	/* var prefixValue = $("#<portlet:namespace/>prefixValue").val();
	var firstName = $("#<portlet:namespace/>firstName").val();
	var lastName = $("#<portlet:namespace/>lastName").val();
	var jobTitle = $("#<portlet:namespace/>jobTitle").val();	 */
	$("#<portlet:namespace/>endYearRangeAdd").val($("#rangerDatepicker3").val());
	var months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];;
    var date = new Date();
    $("#<portlet:namespace/>startMonthRange").val(months[date.getMonth()]);
    $("#<portlet:namespace/>startYearRange").val(date.getFullYear());
   
    /* if(buttonRequest=='AddInterest'){
		if($(".view-more-interest-modal-inner").find("hasError")){
			return false;
		}
		if($(".view-more-interest-modal-inner").find("error-field")){
			return false;
		}
	} */
    var submitAction = "false";var collaboartiontype = $("#<portlet:namespace/>collaborationType").val();
	debugger;
	if(buttonRequest=='AddInterest' && ($("#add-interest-modal textarea, #<portlet:namespace/>discipline1, #<portlet:namespace/>collaborationType, #<portlet:namespace/>projectType, #<portlet:namespace/>preferredLanguage").val() != "")){
		if((collaboartiontype=='Departmental' || collaboartiontype=='Institutional') && $("#<portlet:namespace/>location1").val()==""){
			submitAction = "true";
		}
		if(collaboartiontype=='Global' && $("#<portlet:namespace/>location1").val()!=""){
			submitAction = "true";
		}
		if(collaboartiontype=='Regional' && $("#<portlet:namespace/>location1").val()!=""){
			submitAction = "true";
		}
	} ///$("#<portlet:namespace/>communicationPhoneNumber").val().length>=15
	/* else if(buttonRequest=='profile' && ($("#comunication textarea, #comunication input").val()!=undefined) 
			&& ($("#<portlet:namespace/>communicationPhoneNumber").val().length>=15)
				){
		submitAction = "true";
	} */
	if (buttonRequest=='profile' && ($("#<portlet:namespace/>primaryLanguage").val()!="" && $("#<portlet:namespace/>communicationPhoneNumber").val()!=""
			&& $("#<portlet:namespace/>communicationMobileNumber").val()!="" && $("#<portlet:namespace/>communicationWebsite").val()!="") && ($("#<portlet:namespace/>communicationPhoneNumber").val().length<=15)	
	){
		submitAction = "true";
	}
	$("#add-interest-modal .selectableDR:not(.active)").each(function(){
		$(this).children(".form-group").removeClass("has-error");
		$(this).find(".form-validator-stack").remove();
	});
	if(submitAction == "true"){	
		$(".loaderContainer").addClass("d-flex");
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
		            	   },
		            	   complete: function(data){
		            		   debugger;
		            		   var collaborationInterestId = $("#<portlet:namespace/>collaborationInterestId").val();
		            		   var communicationId = $("#<portlet:namespace/>communicationId").val();
		            		   var credentialId = $("#<portlet:namespace/>credentialId").val();
		            		   var addInterestId = $("#<portlet:namespace/>addInterestId").val();
		            		   if(data.details[1].responseText!=null && data.details[1].responseText!=undefined){
		            			   $("#add-interest-modal").modal("hide");
		            			   $(".loaderContainer").removeClass("d-flex");
		            			   showMsg("Saved successfully");	            			
		            			   loadUserInfo();
		            			   loadUserCredential();
		            			   loadProjectDetails();
		            			   loadProfessionalBio();
		            			   //loadInstituteProfile();
		            			   loadUserCommunicationPreferences();
		            			   resetAddInterest();
		            			   
		            		   }else{
		            			   $("#add-interest-modal").modal("hide");
		            			   $(".loaderContainer").removeClass("d-flex");
		            			   loadUserInfo();
		            			   loadUserCredential();
		            			   loadProjectDetails();
		            			   loadProfessionalBio();
		            			   //loadInstituteProfile();
		            			   loadUserCommunicationPreferences();
		            			   resetAddInterest();
		            		   }
		                   },
		                   failure:function(data){
		                	   
		                   }
		               }
		            });
		    	});
	}
	
}

function resetAddInterest() {
	$("#add-interest-modal .form-control, #add-interest-modal .js-range-slider").val("");
	$("#add-interest-modal .collaborationShow").show();
	$("#add-interest-modal .selectableDR").not(".first").removeClass("active").hide();
	$("#add-interest-modal #courseDevelopmentPopup").hide();
	$(".js-range-slider").data("ionRangeSlider").destory();
	$("#rangerDatepicker3").val("");
	
}
function resetEditInterest() {
	$("#view-more-interest-modal .form-control, #add-interest-modal .js-range-slider").val("");
	$("#view-more-interest-modal .collaborationShow").show();
	$("#view-more-interest-modal .selectableDREdit").not(".first").removeClass("active").hide();
	$("#view-more-interest-modal #courseDevelopmentPopup1").hide();
	$("#rangerDatepicker2").val();
	
}

function updateAreaofInterest(){
	var submitAction = "false";
	var months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
    var date = new Date();
    $("#<portlet:namespace/>startMonthRange").val(months[date.getMonth()]);
    $("#<portlet:namespace/>startYearRange").val(date.getFullYear());
   
    //var monthRangeEdit = $(".js-irs-1 span.irs-single").text();
	$("#<portlet:namespace/>endYearRangeEdit").val($("#rangerDatepicker2").val());
	var collaborationtype = $("#<portlet:namespace/>collaborationTypeEdit").val();
	if(($("#add-interest-modal textarea, #<portlet:namespace/>disciplineEdit1, #<portlet:namespace/>locationEdit1, #<portlet:namespace/>collaborationTypeEdit, #<portlet:namespace/>projectTypeEdit, #<portlet:namespace/>preferredLanguageEdit").val() != "")){
		// return false;edit-section
		if((collaborationtype=='Departmental' || collaborationtype=='Institutional') && $("#<portlet:namespace/>locationEdit1").val()==""){
			submitAction = "true";
		}
		if(collaborationtype=='Global' && $("#<portlet:namespace/>locationEdit1").val()!=""){
			submitAction = "true";
		}
		$("#view-more-interest-modal .selectableDR:not(.active)").each(function(){
			$(this).children(".form-group").removeClass("has-error");
			$(this).find(".form-validator-stack").remove();
		});
		if(submitAction == "true"){	
			AUI().use('aui-io-request-deprecated', function(A){
		        A.io.request('<%=updateAreaofinterest.toString()%>', {
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
		            		   if(data.details[1].responseText!=null && data.details[1].responseText=="update"){
		            			   $('#view-more-interest-modal').modal('hide');
		            			   showMsg("Updated successfully");
		            			   loadProjectDetails();
		            		   }else{
		            			   $("#add-interest-modal").modal("hide");
		            			   $('#view-more-interest-modal').modal('hide');
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
                    	if(value!=null && value!="undefined" && value!=undefined && value!="null"){
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
         	           	    $("#<portlet:namespace/>communicationMobileNumber").val(data.mobileNum);
         	           		$("#<portlet:namespace/>communicationWebsite").val(data.website);       
                 	   }
                    },error: function(){	             
                    }
				},

	         });
		});
}


function saveProfileTest(buttonRequest){
	  var frm = $('#<portlet:namespace/>updateProfileForm');
	  frm.submit(function (e) {
		  e.preventDefault(e);
	  var formData = new FormData(this);

	  $.ajax({
	    async: true,
	    type: 'POST',
	    url: "<%=Test.toString() %>",
	    data: formData,
	    cache: false,
	    enctype: "multipart/form-data",
	    processData: false,

	    success: function (data) {
	      console.log("success")
	    },
	    error: function(request, status, error) {
	      console.log("error")
	    }
	  });
	});
	
	/* AUI().use('aui-io-request-deprecated', function(A){
        A.io.request("<portlet:resourceURL id='saveProfileFormTest'/>", {
               method: 'get',
               data:{ 		            	   
               },
               form: {
                   id: '<portlet:namespace/>updateProfileForm',
                   upload:true
               },
               cache: false,
               contentType: false,
               processData: false,
               on: {
            	   start:function(){
            	   },
            	   complete: function(data){
            		   debugger;
            		   
                   },
                   failure:function(data){
                	   
                   }
               }
            });
    	}); */
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
                    	if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                    		var data = JSON.parse(value);
         	        		$("#<portlet:namespace/>professionalBioId").val(data.professionalBioId);
         	                $("#<portlet:namespace/>areasofexpertise1").val(data.areasofexpertise1);
         	                $("#<portlet:namespace/>areasofexpertise2").val(data.areasofexpertise2);
         	                $("#<portlet:namespace/>areasofexpertise3").val(data.areasofexpertise3);         	            
         	               	$("#<portlet:namespace/>experienceLevelUI").val(data.experienceLevelUI);
         	              	$("#<portlet:namespace/>experienceLevel").val(data.experienceLevel);
         	             	$("#<portlet:namespace/>cvLink").val(data.cvLink);
         	           		$("#<portlet:namespace/>bioDescription").val(data.bioDescription);
         	           		$("#<portlet:namespace/>bioDiscipline").val(data.bioDiscipline);
                 	   }
                    	$("#editProfessionalBioLoader").fadeOut();
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
                    	if(value!=null && value!="undefined" && value!=undefined && value!="null"){
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
                    		// scrollToInterest();
                 	    }else{
                 	    	showMsg("Error!");
                 	    }                    	
                    },error: function(){	             
                    }
				},

	         });
		});
}




$(document).ready(function(){
	
	var url_param = '<%=themeDisplay.getURLPortal()+themeDisplay.getURLCurrent() %>';
	var current_url = new URL(url_param);
	var param = current_url.searchParams.get("param");
	console.log("param==="+param);
	if(param!="" && param=="interest"){
		$("html, body").animate({ scrollTop: $(".collaboration").offset().top }, 500);
	}
		
	$('.formGroupmb0 .form-control').each(
    function(){ 
        var val = $(this).val().trim();
        if (val != ''){ 
        	$(this).parents('.formGroupmb0').addClass("d-flex");
        }
    });

	$('#add-interest-modal').on('hidden.bs.modal', function () {
		 resetAddInterest();
	}); 
	$('#view-more-interest-modal').on('hidden.bs.modal', function () {
		resetEditInterest();
	}); 
	
	$("#updateInterest").on("click", function(){
		$(".edit-section").addClass("d-none");
		$(".view-more-interest-modal-inner").removeClass("d-none");
	});
	$('#view-more-interest-modal').on('hidden.bs.modal', function () { debugger;
		$(".edit-section").addClass("d-none");
		$(".view-more-interest-modal-inner").removeClass("d-none");
	});
	checkFormFields();
	
	$(".fa-plus-circle").on("click", function(){
		/* $(this).parents('.formGroupmb0').addClass("showIcon"); */
		$(this).parents('.formGroupmb0').next().removeClass("d-none");
		$(this).parents('.formGroupmb0').next().addClass("d-flex");
		checkFormFields();
	});
	$(".fa-minus-circle").on("click", function(){
		$(this).parents().removeClass("active");
		$(this).parents('.formGroupmb0').removeClass("d-flex");
		$(this).parents('.formGroupmb0').addClass("d-none");
		/* $(this).parents('.formGroupmb0').prev().removeClass("showIcon"); */
		$(this).parent().siblings().find('.form-control').val('');
		checkFormFields();
	});
	
	$("[id^='<portlet:namespace/>discipline']").on("change", function(){
		// $(this).parents('.selectableDR').addClass("active");
		$(this).parents('.selectableDR').next().addClass("active");
	});
	
	$("[id^='<portlet:namespace/>location']").on("change", function(){ debugger;
		$(this).parents('.selectableDR').next().addClass("active");
		var selectedLocation = $(this).val();
		if(selectedLocation === "All") {
			$("[id^='<portlet:namespace/>location']").parents('.selectableDR').removeClass("active");
			$(this).parents('.selectableDR').addClass("active");
			$("#<portlet:namespace/>location2, #<portlet:namespace/>location3, #<portlet:namespace/>location4").val("");
			$(".selectableDR.showIfNotAll").hide();
		} else {
			$(".selectableDR.showIfNotAll").show();
		}
		
	});
	
	/* $("#<portlet:namespace/>location1").on("change", function(){ debugger;
		var selectedLocation = $(this).val();
		if(selectedLocation === "All") {
			$("#<portlet:namespace/>location1, #<portlet:namespace/>locationEdit1").parents('.selectableDR').addClass("active");
			$("#<portlet:namespace/>location2, #<portlet:namespace/>location3, #<portlet:namespace/>location3").parents('.selectableDR').removeClass("active");
			// Remove if Region all selected discipline not editable 
			//$("#<portlet:namespace/>discipline2, #<portlet:namespace/>discipline3").addClass("nonEditable");
			//$("#<portlet:namespace/>disciplineEdit2, #<portlet:namespace/>disciplineEdit3").addClass("nonEditable");
		}else{
			$("#<portlet:namespace/>location2, #<portlet:namespace/>location3, #<portlet:namespace/>location4").parents('.selectableDR').addClass("active");
		}
	}); */
	
	/* $("#<portlet:namespace/>locationEdit1").on("change", function(){ debugger;
		var selectedLocation = $(this).val();
		if(selectedLocation === "All") {
			$("#<portlet:namespace/>locationEdit1").parents('.selectableDR').addClass("active");
			$("#<portlet:namespace/>locationEdit2, #<portlet:namespace/>locationEdit3, #<portlet:namespace/>locationEdit3").parents('.selectableDR').removeClass("active");
			// Remove if Region all selected discipline not editable 
			//$("#<portlet:namespace/>discipline2, #<portlet:namespace/>discipline3").addClass("nonEditable");
			//$("#<portlet:namespace/>disciplineEdit2, #<portlet:namespace/>disciplineEdit3").addClass("nonEditable");
		}else{
			$("#<portlet:namespace/>locationEdit2, #<portlet:namespace/>locationEdit3, #<portlet:namespace/>locationEdit4").parents('.selectableDR').addClass("active");
		}
	}); */
	
	$("#<portlet:namespace/>location1").on("change", function(){
		var selectedLocation = $(this).val();
		$("#<portlet:namespace/>location2 option[value='"+selectedLocation+"']").remove();
		$("#<portlet:namespace/>location3 option[value='"+selectedLocation+"']").remove();
		$("#<portlet:namespace/>location4 option[value='"+selectedLocation+"']").remove();
	});
	$("#<portlet:namespace/>location2").on("change", function(){
		var selectedLocation = $(this).val();
		$("#<portlet:namespace/>location3 option[value='"+selectedLocation+"']").remove();
		$("#<portlet:namespace/>location4 option[value='"+selectedLocation+"']").remove();
	});
	$("#<portlet:namespace/>location3").on("change", function(){
		var selectedLocation = $(this).val();
		$("#<portlet:namespace/>location4 option[value='"+selectedLocation+"']").remove();
	});
	$("#<portlet:namespace/>locationEdit1").on("change", function(){
		var selectedLocation = $(this).val();
		$("#<portlet:namespace/>locationEdit2 option[value='"+selectedLocation+"']").remove();
		$("#<portlet:namespace/>locationEdit3 option[value='"+selectedLocation+"']").remove();
		$("#<portlet:namespace/>locationEdit4 option[value='"+selectedLocation+"']").remove();
	});
	$("#<portlet:namespace/>locationEdit2").on("change", function(){
		var selectedLocation = $(this).val();
		$("#<portlet:namespace/>locationEdit3 option[value='"+selectedLocation+"']").remove();
		$("#<portlet:namespace/>locationEdit4 option[value='"+selectedLocation+"']").remove();
	});
	$("#<portlet:namespace/>locationEdit3").on("change", function(){
		var selectedLocation = $(this).val();
		$("#<portlet:namespace/>locationEdit4 option[value='"+selectedLocation+"']").remove();
	});
	
	$("#<portlet:namespace/>discipline1").on("change", function(){
		var selectedDiscpiline = $(this).val();
		if(selectedDiscpiline != "") {
			$("#<portlet:namespace/>discipline2 option[value='"+selectedDiscpiline+"']").remove();
			$("#<portlet:namespace/>discipline3 option[value='"+selectedDiscpiline+"']").remove();
		}
		if(selectedDiscpiline == "") {
			$("#<portlet:namespace/>discipline2, #<portlet:namespace/>discipline3").parents(".selectableDR").removeClass("active");
			$("#<portlet:namespace/>discipline2, #<portlet:namespace/>discipline3").val("");
		}
	});
	$("#<portlet:namespace/>discipline2").on("change", function(){
		var selectedDiscpiline = $(this).val();
		if(selectedDiscpiline != "") {
			$("#<portlet:namespace/>discipline3 option[value='"+selectedDiscpiline+"']").remove();
		}
		if(selectedDiscpiline == "") {
			$("#<portlet:namespace/>discipline3").parents(".selectableDR").removeClass("active");
			$("#<portlet:namespace/>discipline3").val("");
		}
	});
	$("#<portlet:namespace/>disciplineEdit1").on("change", function(){
		var selectedDiscpiline = $(this).val();
		if(selectedDiscpiline != "") {
			$(" #<portlet:namespace/>disciplineEdit2 option[value='"+selectedDiscpiline+"']").remove();
			$(" #<portlet:namespace/>disciplineEdit3 option[value='"+selectedDiscpiline+"']").remove();
		}
		if(selectedDiscpiline == "") {
			$("#<portlet:namespace/>disciplineEdit2, #<portlet:namespace/>disciplineEdit3").parents(".selectableDR").removeClass("active");
			$("#<portlet:namespace/>disciplineEdit2, #<portlet:namespace/>disciplineEdit3").val("");
		}
	});
	$("#<portlet:namespace/>disciplineEdit2").on("change", function(){
		var selectedDiscpiline = $(this).val();
		if(selectedDiscpiline != "") {
			$(" #<portlet:namespace/>disciplineEdit3 option[value='"+selectedDiscpiline+"']").remove();
		}
		if(selectedDiscpiline == "") {
			$("#<portlet:namespace/>disciplineEdit3").parents(".selectableDR").removeClass("active");
			$("#<portlet:namespace/>disciplineEdit3").val("");
		}
	});
	
	$("[id^='<portlet:namespace/>collaborationType']").on("change", function(){ debugger;
		$('.selectableDR, .selectableDREdit').not(".first").hide();
		var selectedCollaborationType = $(this).val();
		if(selectedCollaborationType === "Global") {
			$(".selectableDR:not(.showIfNotAll)").show();
			$('#<portlet:namespace/>location1, #<portlet:namespace/>locationEdit1').val("All");
		} 
		if(selectedCollaborationType === "Departmental" || selectedCollaborationType === "Institutional") {
			$('#<portlet:namespace/>location1, #<portlet:namespace/>locationEdit1').parents(".selectableDR").removeClass("active").show();
		} 
		else {
			$('#<portlet:namespace/>location1, #<portlet:namespace/>locationEdit1').parents(".selectableDR").addClass("active").show();
		}
		if(selectedCollaborationType === "Regional") {
			$('#<portlet:namespace/>location1, #<portlet:namespace/>locationEdit1').val(userRegional);
			$('#<portlet:namespace/>location1, #<portlet:namespace/>locationEdit1').parents(".selectableDR").removeClass("active").show();
			$('#<portlet:namespace/>location1, #<portlet:namespace/>locationEdit1').parent(".form-group").removeClass("has-error");
			$('#<portlet:namespace/>location1, #<portlet:namespace/>locationEdit1').parent(".form-group").find(".form-validator-stack").remove();
		} else if (selectedCollaborationType === "Departmental" || selectedCollaborationType === "Institutional") {
			$('#<portlet:namespace/>location1, #<portlet:namespace/>locationEdit1').val("");
		} 
	});
	
	$('#add-interest-modal, #view-more-interest-modal').on('shown.bs.modal', function () {
		$("#add-interest-modal .form-group, #view-more-interest-modal .form-group").removeClass("has-error");
		$("#add-interest-modal .form-group .form-validator-stack, #view-more-interest-modal .form-group .form-validator-stack").remove();
	});
	
	/* $(".loaderContainer").removeClass("d-flex"); */
	$("#editInstitutionalProfileLoader").fadeOut();
	$("#editCommunicationPreferencesLoader").fadeOut();
	$("#editCredentialsLoader").fadeOut();
	
});

function checkFormFields() {
	$('#credentials-fields .form-control').each(function(){ 
	    if(!$(this).val()){
	        $(this).parents('.formGroupmb0').removeClass("active");
	    } else{
	        $(this).parents('.formGroupmb0').addClass("active");
	    }
	});
	$('#credentials-fields .form-control').on("blur", function(){ 
	    if(!$(this).val()){
	        $(this).parents('.formGroupmb0').removeClass("active");
	    } else{
	        $(this).parents('.formGroupmb0').addClass("active");
	    }
	});
	
}

function scrollToInterest() {
	$('html,body').animate({
        scrollTop: $("#interest").offset().top},
        'slow');
}

   /* $(window).click(function(e) {
       relativeY = (e.pageY - $('.editcollaboratedarea').offset().top);
           $('#view-more-interest-modal').css('top',relativeY +"px");
   }); */
</script>