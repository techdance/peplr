<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>
.box-subhead {
	max-width: 100%;
}
.icon-comment-smile::before {
    content: "\f4b4";
}
.icon-s-search::before {
    content: "\f002";
}
div.collaboration .content-icon {
    margin-bottom: 10px;
    color: black;
}
section.wrap-profile .content-icon {
    color: black;
}
.ac {
    text-align: center;
}
.areas-of-interest p small {
	display: block;
    font-size: 12px;
    line-height: 14px !important;
}
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
	background: #ececec !important;
    border: 1px solid #d4d4d4;
    padding: 6px;
    height: 32px;
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
    background: #ececec !important;
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
.rangerDisabled {
	opacity: .85;
	pointer-events: none;
	cursor: not-allowed;
}
</style>

<link rel="stylesheet" href="https://www.jqueryscript.net/demo/Year-Picker-Text-Input/yearpicker.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.js"></script>
<script src="https://www.jqueryscript.net/demo/Year-Picker-Text-Input/yearpicker.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ion-rangeslider/2.3.1/css/ion.rangeSlider.min.css"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/ion-rangeslider/2.3.1/js/ion.rangeSlider.min.js"></script>

<portlet:resourceURL var="saveCollaborationInterest" id="saveCollaborationInterest"></portlet:resourceURL>
<script>
 $(document).ready(function() {
	 var monthNames = [
		    "Jan", "Feb", "Mar",
		    "Apr", "May", "Jun", "Jul",
		    "Aug", "Sept", "Oct",
		    "Novr", "Dec"
		  ];
	function formatDate(date) {
		  
		  var day = date.getDate();
		  var monthIndex = date.getMonth();
		  var year = date.getFullYear();

		  return  monthNames[monthIndex] +  ' ' + year;
		}

	
	/* document.getElementById("currentdayCI2").innerHTML = formatDate(new Date()); */
	document.getElementById("currentdayCI2").innerHTML = new Date().getFullYear();
	
	function monthNameToNum(monthname) {
	    var month = monthNames.indexOf(monthname);
	    return month ? month : 0;
	}
	
	/*	
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
    
    $("#projectRangeCI").ionRangeSlider({
    	skin: "big",
    	type: "single",
        grid: true,
        grid_num: 11,
        min:dateToTS(new Date()),
        max: dateToTS(current),        
        prettify: tsToDate
    });
	
    $("#projectRangeCI2").ionRangeSlider({
    	skin: "big",
    	type: "single",
        grid: true,
        grid_num: 11,
        min:dateToTS(new Date()),
        max: dateToTS(current),        
        prettify: tsToDate
    }); 
    var end_year = da.getFullYear() + 15;
    var nd = new Date();
    nd.setFullYear(end_year)
    
    console.log(nd,"end_date")
	 $( "#datePickerCI" ).datepicker({
		 format: "yyyy",
	     viewMode: "years", 
	     minViewMode: "years",
	     autoclose: true,
	     startDate : new Date(),
	     endDate : nd
	 });
	
    $( "#datePickerCI2" ).datepicker({
		 format: "yyyy",
	     viewMode: "years", 
	     minViewMode: "years",
	     autoclose: true,
	     startDate : new Date(),
	     endDate : nd
	 });
	 */
});

var A=AUI();
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
                    	if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                    		var data = JSON.parse(value);
                    		if(data.length>0){
                    			for(var i=0;i<data.length;i++){
                    				var lang = "";var matchAction = '';
                    				var redirectURL = "<%=themeDisplay.getURLPortal() %>"+"/project-creation?projectId="+data[i].id;
                    				if(data[i].language!="undefined"){
                    					lang = data[i].language;
                    				}
                    				
                    				if(data[i].startProject==true && data[i].projectStarted==false){
                    					matchAction = "<a href='"+redirectURL+"' class='btn btn-blue btn-tiny'>Start Project</a>";
                    				}else if(data[i].startProject==true && data[i].projectStarted==true){
                    					matchAction = "<a href='#' class='btn btn-blue btn-tiny'>Project Created</a>";
                    				}else{
                    					matchAction = "<a href='#' class='btn btn-blue btn-tiny' onclick='goToMatching("+data[i].id+")'>FIND MATCHES</a>";
                    				}
                    				
                    				if(data[i].isEdit=="No"){
                    					matchAction = '';
                    				}
                    				
                    				//if(data[i].deliveryMethod==""){
                    				//	$("#area-of-interest-block-profile").append("<div class='col-xl-6 mb-3'><div class='editcollaboratedarea areas-of-interest"+i+"'><div class='row row-custom position-relative'> "
                    					//	+ "<span class='left-corner'>"+ (i + 1) +"</span><div class='col-md-6'><p> <strong>Project</strong><br> <small>"+data[i].projectType+"</small> </p>"
                    					//	+ "</div> <div class='col-md-6'> <p> <strong>Discipline</strong><br> <small>"+data[i].discipline+"</small> </p> <p> <strong>Region</strong><br> <small>"+data[i].region+" </small></p> </div> </div>"
                    						/* + " <div class='row row-custom mt-2'><div class='col-md-6'><div class='position-relative'><a href='javascript:void(0);' class='view-more-interest' onclick='getViewMoreData("+data[i].id+")'>View more</a><div id='popup-"+data[i].id+"'></div></div></div><div class='col-md-6 text-right'><a href='#'>Remove</a></div></div>" */
                    					//	+ " <div class='row row-custom mt-2'><div class='col-md-6 p-0'><div class='text-center position-relative'><a href='javascript:void(0);' class='view-more-interest' onclick='getViewMoreData("+data[i].id+")'>View more</a><div id='popup-"+data[i].id+"'></div></div></div><div class='col-md-6 p-0'>"+matchAction+"</div></div></div>"
                    				//	);
                    				// }
                    				/* else{ */
                    					$("#area-of-interest-block-profile").append("<div class='col-xl-6 mb-3'><div class='editcollaboratedarea areas-of-interest"+i+"'><div class='row row-custom position-relative'><span class='left-corner'>"+ (i + 1) +"</span><div class='col-md-6'><p> <strong>Project</strong><br> <small>"+data[i].projectType+"</small> </p>"
                    						+ " <p> <strong>Preferred Language</strong><br> <small>"+lang+"</small> </p>  </div> <div class='col-md-6'> <p> <strong>Discipline</strong><br> <small> "+data[i].discipline+"</small> </p> <p> <strong>Region</strong><br> <small> "+data[i].region+"</small> </p> </div> </div>"
                    						/* + " <div class='row row-custom mt-2'><div class='col-md-6'><div class='position-relative'><a href='javascript:void(0);' class='view-more-interest' onclick='getViewMoreData("+data[i].id+")'>View more</a><div id='popup-"+data[i].id+"'></div></div></div><div class='col-md-6 text-right'><a href='#'>Remove</a></div></div>" */
                    						+ " <div class='row row-custom mt-2'><div class='col-md-6 p-0'><div class='text-center position-relative'><a href='javascript:void(0);' class='view-more-interest' onclick='getViewMoreData("+data[i].id+")'>View more</a><div id='popup-"+data[i].id+"'></div></div></div><div class='col-md-6 p-0'>"+matchAction+"</div></div></div>" 
                    					);
                    				/* } */
                    			}                    			
                    		}
                 	   	}
                    	$("#collaborationInterestLoader").fadeOut();
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
                    	// $("#view-more-interest-modal").appendTo('#popup-'+id);
                    	var value=this.get('responseData');	
                    	if(value!=null && value!="undefined" && value!=undefined && value!="null"){ debugger;
                    		var data = JSON.parse(value);
                    		console.log("value", value);
                    		$(".view-project-type").text(data.projectType);
                    		$(".view-collaboration-type").text(data.collaborationType);
                    		$(".view-discipline1").text(data.discipline1);
                    		$(".view-discipline2").text(data.discipline2);
                    		$(".view-discipline3").text(data.discipline3);
                    		$(".view-delivery-type").text(data.deliveryMethod);
                    		$(".view-description").text(data.description);
                    		$(".view-campus").text(data.campus);
                    		$(".view-program-level").text(data.programLevel);
                    		$(".view-program-length").text(data.programLength);
                    		$(".view-credits").text(data.credits);
                    		$(".view-language").text(data.language);
                    		$(".view-location1").text(data.region1);
                    		$(".view-location2").text(data.region2);
                    		$(".view-location3").text(data.region3);
                    		$(".view-location4").text(data.region4);
                    		$(".created_date").text(data.created);
                    		$(".end-month").text(data.startMonth);
                    		$("#currentdayCI2").text(data.startYear);
                    		$(".view-find-matches").html("");
                    		$("#datePickerCI2").val(data.endYear);
                    		$("#projectRangeCI2").ionRangeSlider({
                    	    	skin: "big",
                    	    	type: "single",
                    	        grid: true,
                    	        values: [
                    	            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
                    	            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
                    	        ],
                    	        from: monthNameToNum(data.endMonth),
                    	    });
                    		if(data.matchButton==true){
                    			$(".view-find-matches").append('<a href="#" class="btn btn-blue btn-w-100 m-auto" onclick="goToMatching('+data.PK_areaofinterest+')">Find Matches</a>');
                    		}
                    		/* $("#view-more-interest-modal").slideToggle(); */
                    		$('#view-more-interest-modal').modal('show');
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