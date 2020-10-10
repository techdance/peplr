<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<link rel="stylesheet" href="https://www.jqueryscript.net/demo/Year-Picker-Text-Input/yearpicker.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.js"></script>
<script src="https://www.jqueryscript.net/demo/Year-Picker-Text-Input/yearpicker.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ion-rangeslider/2.3.1/css/ion.rangeSlider.min.css"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/ion-rangeslider/2.3.1/js/ion.rangeSlider.min.js"></script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/tinymce/4.5.6/tinymce.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/tinymce/4.5.6/jquery.tinymce.min.js"></script>

<!-- <script src="/o/ahea-theme/js/jquery.tinymce.min.js"></script> -->

<liferay-theme:defineObjects />

<portlet:defineObjects />
<style>
.bg-profile {
	margin-right: 40px;
}
.btn-edit-profile {
    width: auto;
    max-width: inherit;
}

/* Modal */
#inviteModal.modalareainterest .modal-dialog {
	position: relative;
    max-width: 600px;
    margin: 1.75rem auto;
}
#inviteModal.modalareainterest .modal-header {
    background: #f1f3f7;
    border-radius: inherit !important;
    -webkit-border-radius: 0 !important;
    -moz-border-radius: 0 !important;
    color: black;
}
.toltip-close3 {
    position: absolute;
    top: 5px;
    right: 8px;
}
.toltip-close2 a, .toltip-close3 a {
    color: #818c93;
    font-size: 20px;
}
.font15 {
    font-size: 15px !important;
    line-height: 1.5;
}
#inviteModal.modalareainterest .modal-body {
    background: rgba(129,140,147,0.9);
    border: none;
    color: white;
    font-size: 14px;
    line-height: 1.5;
    padding: 15px;
    text-align: left;
}
#inviteModal.modalareainterest .modal-body .interest-modal {
	padding: 0;
}
.box-grey-light {
    background: #f0f2f7;
    border-radius: 10px;
}
.color-black {
    color: #000 !important;
}
.text-to {
    font-size: 26px;
    font-weight: 900;
}
.profile-name {
    margin-bottom: 15px !important;
}
.color-blue {
    color: #247aba !important;
}
.box-header {
    background: #f0f2f7;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
}
.box-bg-body {
    background: #6b7378;
}
.color-white {
    color: white !important;
}

.btn-grey {
    background: #989899;
}
.wrap-fa-comment {
    background: #0099ff;
    padding: 7px;
    color: white;
    border-radius: 50%;
    font-size: 20px;
    line-height: 1;
    width: 34px !important;
    height: 32px !important;
    line-height: 1;
    display: inline-block;
}
.box-subhead i, .box-subhead span {
    position: absolute;
    left: 0px;
    top: 3px;
}
.icon-regular::before, .icon-regular::after {
    font-family: 'Font Awesome 5 Regular';
}
.icon-user-circle::before {
    content: "\f2bd";
}
.icon-user-alt::before {
    content: "\f406";
}
.icon-user-tie::before {
    content: "\f508";
}
.progress {
  width: 210px;
  height: 210px;
  background: none;
  position: relative;
  margin-right: 40px;
}

.progress::after {
  content: "";
  width: 100%;
  height: 100%;
  border-radius: 50%;
  border: 40px solid #e6e6e6;
  position: absolute;
  top: 0;
  left: 0;
}

.progress>span {
  width: 50%;
  height: 100%;
  overflow: hidden;
  position: absolute;
  top: 0;
  z-index: 1;
}

.progress .progress-left {
  left: 0;
}

.progress .progress-bar {
  width: 100%;
  height: 100%;
  background: none;
  border-width: 40px;
  border-style: solid;
  position: absolute;
  top: 0;
}

.progress .progress-left .progress-bar {
  left: 100%;
  border-top-right-radius: 105px;
  border-bottom-right-radius: 105px;
  border-left: 0;
  -webkit-transform-origin: center left;
  transform-origin: center left;
}

.progress .progress-right {
  right: 0;
}

.progress .progress-right .progress-bar {
  left: -100%;
  border-top-left-radius: 105px;
  border-bottom-left-radius: 105px;
  border-right: 0;
  -webkit-transform-origin: center right;
  transform-origin: center right;
}

.progress .progress-value {
  position: absolute;
  top: 0;
  left: 0;
}
.progress-value img {
	width: 130px;
    height: 130px;
    object-fit: cover;
    object-position: top;
}
.progress.removePercentage span.progress-left, 
.progress.removePercentage span.progress-right {
    opacity: 0;
}
.progress.removePercentage:after {
    border-color: transparent;
}
.disabledRanger {
    pointer-events: none;
}
#user-profile-new {
	width: 90px;
    height: 90px;
    object-fit: cover;
    object-position: top;
}
</style>
<script>
var A=AUI();


var interestId = 0;
$(document).ready(function(){
	debugger;
	//$(".btn-invite-show").hide();
	var url_string = '<%=themeDisplay.getURLPortal()+themeDisplay.getURLCurrent() %>';
	var url = new URL(url_string);
	var param = url.searchParams.get("showInvite");
	interestId = url.searchParams.get("interestId");
	loadUserInfo(interestId);
	if(param!="" && param!=null && param!="null" && param=="true"){
		$("#btn-invite").removeClass("d-none");
	}
	if(interestId!="" && interestId!=null && interestId!="null" && interestId=="true"){		
		$(".btn-invite-show").show();
	}
});
function viewData(){
	if(interestId!=0){
		getViewMoreDataInvite(interestId);
	}
}

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

function loadUserInfo(interestId){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getProfileData'/>"
			,{
               method: 'post',
               data:{ 	
            	   '<portlet:namespace/>interestId':interestId
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
                    	$(".btn-edit-profile").show();
                    	$("#profileUpdate").removeClass("removePercentage");
                    	if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                    		var data = JSON.parse(value);
                    		$("#fullName").text(data.fullName);
                    		$("#jobTitle").text(data.jobTitle);      	                
                    		$("#prefixValue").text(data.prefixValue+". ").addClass("text-capitalize");
         	               // $("#<portlet:namespace/>status").val(data.status);
         	                $("#user-profile").attr("src",data.profileImage);
         	               // $("#<portlet:namespace/>ExpandoAttribute--profileStatus--").val(data.profileStatus);
         	                $("#profileStatus").text(data.profileStatus);
         	                console.log(data.onlineStatus);
         	                if(data.isEdit=="No"){
         	                	$(".btn-edit-profile").hide();
         	                	$(".btn-invite-show").show();
         	                	$("#profileUpdate").addClass("removePercentage");
         	                }
         	                if(data.isAlreadySent==true){ $(".btn-invite-show").hide(); $(".invitationStatus").text("Invitation sent"); }
         	                if(data.onlineStatus){
         	                	
         	                	
         	                }
         	               $(".link-toltip").text("");
         	               $(".link-toltip").text("Profile "+data.profilePercentage+"% Complete");
         	               $("#profileUpdate").attr("data-value", data.profilePercentage)
         	              $(".progress").each(function() {
         	            	    var value = $(this).attr('data-value');
         	            	    var left = $(this).find('.progress-left .progress-bar');
         	            	    var right = $(this).find('.progress-right .progress-bar');
         	            	    if (value > 0) {
         	            	      if (value <= 50) {
         	            	        right.css('transform', 'rotate(' + percentageToDegrees(value) + 'deg)')
         	            	      } else {
         	            	        right.css('transform', 'rotate(180deg)')
         	            	        left.css('transform', 'rotate(' + percentageToDegrees(value - 50) + 'deg)')
         	            	      }
         	            	    }
         	            	})
         	            	function percentageToDegrees(percentage) {
         	            		return percentage / 100 * 360
         	            	}
         	               
                 	   }
                    	$("#personalInformationLoader").fadeOut();
                    },error: function(){	             
                    }
				},

	         });
		});
}
function getViewMoreDataInvite(id){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getViewMoreDataInvite'/>"
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
                    	if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                    		var data = JSON.parse(value);
                    		console.log("data", data);
                    		$("#editorFullname").append(data.fullName);
                    		/* $(tinymce.get('editorFullname').getBody()).html(data.fullName); */
                    		/* tinymce.get('editorFullname').getBody().innerHTML = data.fullName; */
                    		/* tinymce.get('editorFullname').setContent(data.fullName); */
                    		$("#inviteProfileName").text(data.fullName);
                    		$("#inviteProfileTitle").text(data.jobTitle);
                    		$("#inviteProfileUniversity").text(data.instituteName);
                    		//$("#inviteProfileCity").text(data.discipline3);
                    		$("#projectTitle").text(data.projectType);
                    		$("#description").text(data.description);
                    		$("#discipline").text(data.discipline1);
                    		$("#deliveryMethod").text(data.deliveryMethod);                    		
                    		$("#collaborationType").text(data.collaborationType);
                    		//$("#<portlet:namespace />projectDescriptionEdit").val(data.description);
                    		$("#programLevel").text(data.programLevel);
                    		$("#programLength").text(data.programLength);
                    		$("#credits").text(data.credits);
                    		$("#preferredLanguage").text(data.language);
                    		$("#region").text(data.region1);
                    		
                    		/* var rangerSliderPID = $("#projectRangePID").data("ionRangeSlider");
                    		rangerSliderPID.update({ from: monthNameToNum(data.endMonth) }); */
                    		
                    		$("#projectRangePID").ionRangeSlider({
            				    skin: "big",
            				    grid: true,
              			  		type: "single",
            			        values: [
            			            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            			            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
            			        ],
            			        from: monthNameToNum(data.endMonth),
            			    });
                    		
                    		/* $("#projectRangePID").ionRangeSlider({ to: data.endMonth}); */
                    		$(".projectInviteStartMonth").text(data.startMonth);
                    		$("#projectInviteDay").text(data.startYear);
                    		$("#rangerDatepickerPID").val(data.endYear);
                    		console.log("data.endMonth", data.endMonth);
                    		console.log("data.endYear", data.endYear);
                    		
                    		$("#user-profile-new").attr("src",data.profileImage);
                    		$("#inviteModal").modal('show');
                    		$("#editorFullname").append(data.fullName);
                 	   	}
                    },error: function(){	             
                    }
				},

	         });
		});
}

function sendInvite(){
	if(interestId!=0){
		AUI().use('aui-io-request-deprecated', function(A){
			A.io.request("<portlet:resourceURL id='sendInvite'/>"
			,{
	              method: 'post',
	              data:{
	              	  '<portlet:namespace/>interestId':interestId
	              },
	              sync : true, 
	              on:{
	           	   complete:function()
	            		{		            		   
	            		},
	                   success:function()
	                   {	
	                	    var value=this.get('responseData');
	                   		if(value!=null && value!="undefined" && value!=undefined && value!="null"){
	                   			var data = JSON.parse(value);
	                   			if(data.message=="sent"){ showMsg("Invitation sent");getMyNotificationCount(); }
	                   			loadUserInfo(interestId);
	                	    }else{
	                	    	showMsg("Error!");
	                	    }                    	
	                	   
	                   },error: function(){	             
	                   }
				},

	         });
		});
	}
}

$(document).ready(function(){
	$(".returnToResult").removeClass("d-none");
	

	function formatDate(date) {
		  var monthNames = [
		    "Jan", "Feb", "Mar",
		    "Apr", "May", "Jun", "Jul",
		    "Aug", "Sept", "Oct",
		    "Novr", "Dec"
		  ];

		  var day = date.getDate();
		  var monthIndex = date.getMonth();
		  var year = date.getFullYear();

		  return  monthNames[monthIndex] +  ' ' + year;
		}

	
	/* document.getElementById("projectInviteDay").innerHTML = formatDate(new Date()); */
	document.getElementById("projectInviteDay").innerHTML = new Date().getFullYear();
	
	var lang = "en-US";
    var year = 2018;
    
    function dateToTS (date) {
        return date.valueOf();
    }
    
    function tsToDate (ts) {
        var d = new Date(ts);
    
        return d.toLocaleDateString(lang, {
            month: 'short',
        });
    }
    var da = new Date();
    if (da.getMonth() == 11) {
        var current = new Date(da.getFullYear() + 1, 0, 1);
    } else {
        var current = new Date(da.getFullYear(), da.getMonth() + 11, 1);
    }
    
    
    /* $("#projectRangePID").ionRangeSlider({
    	skin: "big",
    	type: "single",
        grid: true,
        grid_num: 11,
        min:dateToTS(new Date()),
        max: dateToTS(current),        
        prettify: tsToDate
    }); */
    var end_year = da.getFullYear() + 15;
    var nd = new Date();
    nd.setFullYear(end_year)
    
    console.log(nd,"end_date")
	 $( "#rangerDatepickerPID" ).datepicker({
		 format: "yyyy",
	     viewMode: "years", 
	     minViewMode: "years",
	     autoclose: true,
	     startDate : new Date(),
	     endDate : nd
	 });
	
    
	
	tinyMCE.init({
		menubar:false,
		statusbar: false,
		selector:'textarea#editor-text',
		plugins: [
	        "advlist autolink lists link image charmap print preview anchor",
	        "searchreplace visualblocks code fullscreen",
	        "insertdatetime media table paste"
	    ],
	    toolbar: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | outdent indent"
	});
});
</script>