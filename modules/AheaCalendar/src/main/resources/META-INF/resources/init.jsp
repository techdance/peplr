<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<portlet:resourceURL var="saveCalendarEvent" id="saveCalendarEvent"></portlet:resourceURL>

<link rel="stylesheet" type="text/css" href="/o/ahea-theme/css/jquery-ui.css">
<link rel="stylesheet" href="/o/ahea-theme/css/jquery.timepicker.css">

<!-- <script src="/o/ahea-theme/js/jquery-3.1.1.js"></script> -->

<!-- fullCalendar -->
<link rel="stylesheet" href="/o/ahea-theme/plugins/fullcalendar/main.min.css">
<link rel="stylesheet" href="/o/ahea-theme/plugins/fullcalendar-daygrid/main.min.css">
<link rel="stylesheet" href="/o/ahea-theme/plugins/fullcalendar-timegrid/main.min.css">
<link rel="stylesheet" href="/o/ahea-theme/plugins/fullcalendar-bootstrap/main.min.css">


<style>
.btn-grey {
    background: #989899;
}
.modal-header {
    font-size: 20px;
    line-height: 1.5;
    padding: 8px;
    text-align: center;
    height: auto;
}
.modal-dialog {
    min-width: 300px;
    max-width: 500px;
    position: relative;
}
.modal-footer {
	justify-content: center;
}
.ui-timepicker-standard, .ui-datepicker {
	z-index: 1200!important;
}
.modal-dialog {
    position: fixed;
    left: 0!important;
    right: 0;
    z-index: 999!important;
    background: #fff;
}
.modal-footer .btn-toolbar{
	flex-wrap: nowrap;
}
.fc-button {
	text-transform: capitalize;
}
.fc-button.fc-button-active {
    color: rgb(153, 153, 153) !important;
    background-color: rgb(236, 236, 236) !important;
    border-color: rgb(236, 236, 236) !important;
}
.fc-button-primary {
    background-color: rgb(153, 153, 153) !important;
    border-color: rgb(153, 153, 153) !important;
}
.fc-toolbar.fc-header-toolbar .fc-left {
    display: flex;
    flex-flow: row-reverse;
}
.fc-toolbar>*>:not(:first-child) {
	margin: 0 .75em 0 0;
}
.fc-day-grid-event .fc-content {
	white-space: normal;
}
.bg-grey {
    background: rgba(129,140,147,0.9) !important;
    color: white !important;
}
#eventModal .form-group {
	display: flex;
	align-items: center;
}
#eventModal .form-group .control-label {
	-webkit-box-flex: 0;
    -ms-flex: 0 0 25%;
    flex: 0 0 25%;
    max-width: 25%;
    color: #fff;
    margin: 0;
}
.form-group + .form-group .control-label {
    display: none;
}
.multiColumn {
    display: flex;
}
.multiColumn .form-group:first-child {
    width: 60%;
}
.multiColumn .form-group:last-child {
    width: 40%;
    padding-left: 10px;
}
#eventModal .multiColumn .form-group .control-label {
	-webkit-box-flex: 0;
    -ms-flex: 0 0 42%;
    flex: 0 0 42%;
    max-width: 42%;
}
#eventModal .has-error .help-block {
    color: #dc3545;
    position: absolute;
    bottom: -15px;
    margin: 0;
    line-height: 1;
    text-align: right;
    right: 0;
}
#eventModal textarea.form-control {
    height: 65px;
}
#eventModal .modal-header {
    background: #f1f3f7;
    border-radius: 0 !important;
    color: black;
    font-size: 20px;
    line-height: 1.5;
    padding: 8px;
}
#eventModal .modal-header h4 {
	font-size: 15px;
}
#eventModal .modal-content {
	border: 0;
    border-radius: 0;
}
#eventModal .toltip-close2 a {
    color: #818c93;
    font-size: 20px;
}
.modal-open #eventModal.modal {
    overflow-x: hidden;
    overflow-y: auto;
}
.form-group.form-inline.input-checkbox-wrapper label {
    display: flex;
    flex-flow: row-reverse;
    color: #fff;
}
.form-group.form-inline.input-checkbox-wrapper label .field {
    margin-left: 65px;
}
.orange-event {
	background-color: #ff993e;
    border-color: #ff993e;
}
.green-event {
	background-color: #339900;
    border-color: #339900;
}
.blue-event {
	background-color: #ff993e;
    border-color: #ff993e;
}
/* .form-group .ui-timepicker-input,
.form-group select.form-group {
    background: url(http://cdn1.iconfinder.com/data/icons/cc_mono_icon_set/blacks/16x16/br_down.png) no-repeat right #fff;
    -webkit-appearance: none;
    background-position-x: 98%;
} */
.datePickerFirst .form-group:first-child:after,
.datePickerLast .form-group:last-child:after {
    color: #414142;
    content: "\f073";
    font-family: "Font Awesome 5 Solid";
    font-size: 20px;
    height: 25px;
    right: 2px;
    position: absolute;
    top: 5px;
    width: 25px;
}
#eventModal .modal-dialog {
	position: relative;
}
</style>


<!-- <script src="/o/ahea-theme/js/jquery-3.1.1.js"></script> -->
<!-- Bootstrap -->
<!-- <script src="/o/ahea-theme/plugins/bootstrap/js/bootstrap.bundle.min.js"></script> -->
	<!-- jQuery UI -->
<script src="/o/ahea-theme/plugins/jquery-ui/jquery-ui.min.js"></script>

<!-- AdminLTE for demo purposes -->
<script src="/o/ahea-theme/plugins/demo.js"></script> 

<!-- fullCalendar 2.2.5 -->
<script src="/o/ahea-theme/plugins/moment/moment.min.js"></script>
<script src="/o/ahea-theme/plugins/fullcalendar/main.min.js"></script>
<script src="/o/ahea-theme/plugins/fullcalendar-daygrid/main.min.js"></script>
<script src="/o/ahea-theme/plugins/fullcalendar-timegrid/main.min.js"></script>
<script src="/o/ahea-theme/plugins/fullcalendar-interaction/main.min.js"></script>
<script src="/o/ahea-theme/plugins/fullcalendar-bootstrap/main.min.js"></script>
<script src="/o/ahea-theme/js/jquery.timepicker.js"></script>

<!-- Page specific script -->
	<script>
	var A=AUI();
	$(document).ready(function(){
		$( "#<portlet:namespace/>startDate" ).datepicker({
			dateFormat: 'yy-mm-dd',
			changeMonth: true,
			changeYear: true,
			minDate: 0,
			onClose:function(selectedDate) {
				$(this).removeClass("error-field");
				$(this).parent(".form-group").removeClass("has-error");
				$(this).siblings(".help-block").remove();
				$( "#<portlet:namespace/>endDate" ).datepicker( "option", "minDate", selectedDate );
		      }
		});
		$( "#<portlet:namespace/>endDate" ).datepicker({
			dateFormat: 'yy-mm-dd',
			changeMonth: true,
			changeYear: true,
			onClose:function(selectedDate) {
				$(this).removeClass("error-field");
				$(this).parent(".form-group").removeClass("has-error");
				$(this).siblings(".help-block").remove();
				$( "#<portlet:namespace/>startDate" ).datepicker( "option", "maxDate", selectedDate );
		      }
		});
		
		$( "#<portlet:namespace/>endRepeat" ).datepicker({
			dateFormat: 'yy-mm-dd',
			changeMonth: true,
			changeYear: true,
			minDate: 0,
			onClose:function(selectedDate) {
				$(this).removeClass("error-field");
				$(this).parent(".form-group").removeClass("has-error");
				$(this).siblings(".help-block").remove();
		      }
		});
		
		$('#<portlet:namespace/>startTime').timepicker({ 
			'scrollDefault': 'now',
			'timeFormat': 'h:i A'
		}).on('changeTime', function () {
			$('#<portlet:namespace/>endTime').timepicker({
				'minTime': $(this).val(),
				'timeFormat': 'h:i A',
				'maxTime': '00:00'
				});
		});
		
		$("#<portlet:namespace/>deleteEvent").on("click", function(){
			$("#eventModal").modal("hide");
			$(this).addClass("d-none");
			
		})
		$("#<portlet:namespace/>deleteEvent").addClass("d-none");
		
		setTimeout(function(){ 
			loadCalendarEvent(false);
			$("#ui-datepicker-div").remove();
			$("#FullpageCalendarLoader").fadeOut();
		}, 500);
		
		
		
		/* var availableTags = userNames();
		$( "#<portlet:namespace/>eventInvitees" )
		// don't navigate away from the field on tab when selecting an item
		.on( "keydown", function( event ) {
			if ( event.keyCode === $.ui.keyCode.TAB &&
					$( this ).autocomplete( "instance" ).menu.active ) {
				event.preventDefault();
			}
		})
		.autocomplete({
			minLength: 0,
			source: function( request, response ) {
				// delegate back to autocomplete, but extract the last term
				response( $.ui.autocomplete.filter(
					availableTags, extractLast( request.term ) ) );
			},
			focus: function() {
				// prevent value inserted on focus
				return false;
			},
			select: function( event, ui ) {
				var terms = split( this.value );
				// remove the current input
				terms.pop();
				// add the selected item
				terms.push( ui.item.value );
				// add placeholder to get the comma-and-space at the end
				terms.push( "" );
				this.value = terms.join( ", " );
				return false;
			}
		}); */
		
	});
	
	$(function () { 

		/* initialize the external events
		-----------------------------------------------------------------*/
		function ini_events(ele) {
			ele.each(function () {
				// create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
				// it doesn't need to have a start or end
			var eventObject = {	title: $.trim($(this).text())  } // use the element's text as the event title
	
				// store the Event Object in the DOM element so we can get to it later
				$(this).data('eventObject', eventObject)
	
				// make the event draggable using jQuery UI
				$(this).draggable({
					zIndex        : 1070,
					revert        : true, // will cause the event to go back to its
					revertDuration: 0  //  original position after the drag
				})
	
			})
		}

	ini_events($('#external-events div.external-event'))

	/* initialize the calendar
	-----------------------------------------------------------------*/
	//Date for the calendar events (dummy data)
	var date = new Date()
	var d    = date.getDate(),
		m    = date.getMonth(),
		y    = date.getFullYear()

	var Calendar = FullCalendar.Calendar;
	
	var calendarEl = document.getElementById('calendar');

	// initialize the external events
	// -----------------------------------------------------------------

	

	/* var calendar = new Calendar(calendarEl, {
	plugins: [ 'bootstrap', 'interaction', 'dayGrid', 'timeGrid' ],
	header    : {
		left  : 'prev,next today',
		center: 'title',
		right : 'dayGridMonth,timeGridWeek,timeGridDay'
	},
	//Random default events
	events    : [
		{
		title          : 'All Day Event',
		start          : new Date(y, m, 1),
		backgroundColor: '#f56954', //red
		borderColor    : '#f56954', //red
		allDay         : true
		}
	],
	editable  : true,
	droppable : true, // this allows things to be dropped onto the calendar !!!
	});

	calendar.render(); */
	// jQuery('#calendar').fullCalendar()
	calendar = new Calendar(calendarEl, {
		plugins: [ 'bootstrap', 'interaction', 'dayGrid', 'timeGrid' ],
		header    : {
			left  : 'prev,next today',
			center: 'title',
			right : 'dayGridMonth,timeGridWeek,timeGridDay'
		},
		
		/* views: {
		  timelineDay: {
		    slotLabelFormat: ['H:mm'],
		  },
		  timelineMonth: {
		    slotLabelFormat: ['DD'],
		  },
		}, */
		//Random default events
		events    : [],
		timeFormat: 'H(:mm)',
		axisFormat: 'hh:mm a',
		eventTimeFormat: { // like '14:30:00'
			hour: 'numeric',
			minute: '2-digit',
			meridiem: 'short'
		},
		eventClick: function(info) {
	    	$("#<portlet:namespace/>deleteEvent").removeClass("d-none");
	    	$("#eventModal").modal("show");                    		    	
	      	var eventObj = info.event;
	      	if(eventObj.id){
	      		$("#eventHeader").text("Edit Event");
	      		$("#<portlet:namespace/>saveEvent").text("Update");
	      		loadSignleEvent(eventObj.id);
	      	}
	    },
	    
		editable  : true,
		droppable : false, // this allows things to be dropped onto the calendar !!!
	});
	calendar.render();
	/* ADDING EVENTS */
	var currColor = '#3c8dbc';//Red by default
	//Color chooser button
	var colorChooser = $('#color-chooser-btn');
	$('#color-chooser > li > a').click(function (e) {
		e.preventDefault();
		//Save color
		currColor = $(this).css('color')
		//Add color effect to button
		$('#add-new-event').css({
			'background-color': currColor,
			'border-color'    : currColor
		});
	});
	$('#add-new-event').click(function (e) {
		e.preventDefault();
		//Get value and make sure it is not null
		var startDate = $('#<portlet:namespace/>startDate').val();
		var endDate = $('#<portlet:namespace/>endDate').val();
		var startTime = $('#<portlet:namespace/>startTime').val();
		var endTime = $('#<portlet:namespace/>endTime').val();
		if (startDate != "") {
			saveCalendarEvent();
		}else{
			return false;
		}
	}); 
});

	
function loadCalendarEvent(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getEventData'/>"
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
                    		if(data!=null){
                    			calendar.axisFormat= 'h:mm p'
                    			calendar.getEventSources().map((source) => {source.remove()})
                    			calendar.addEventSource( data )
                    			
	                    		/* if(isUpdate){	                    			
	                    			calendar.addEventSource( [data[data.length - 1]] )	                    			
	                    		}else{
	                        		calendar.addEventSource( data )	                        		
	                    		} */
                    		}            
                    		calendar.render();
                 	   }
                    },error: function(){	             
                    }
				},

	         });
		});
}

function removeEvent()
{
	$("#eventModal").modal("hide");
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
	  	            label: 'Yes',
	  	            on: {
	  	              click: function() {
	  	       				modal.hide();
	  	       				deleteEvent();
 	  	    			  }
	  	              }
	  	            },
  	       			{
	  	            	label: 'No',
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

function deleteEvent(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='removeCalendarEvent'/>"
			,{
               method: 'post',
               data:{ 
            	   '<portlet:namespace/>eventId':$("#<portlet:namespace/>eventId").val()
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
                    		loadCalendarEvent();
                    		showMsg("Removed successfully");   
                    		cancelEvent();
                    		
                 	    }else{
                 	    	showMsg("Error!");
                 	    }                    	
                    },error: function(){	             
                    }
				},

	         });
		});
}

function saveCalendarEvent(){
	debugger;
	var eventId = $('#<portlet:namespace/>eventId').val();
	var startDate = $('#<portlet:namespace/>startDate').val();
	var endDate = $('#<portlet:namespace/>endDate').val();
	var startTime = $('#<portlet:namespace/>startTime').val();
	var endTime = $('#<portlet:namespace/>endTime').val();
	var isPriority = $('input[name="eventAllDay"]:checked').val();
  	if(isPriority=="on"){
		$("#<portlet:namespace />iseventAllDay").val(1);	
	}else{
		$("#<portlet:namespace />iseventAllDay").val(0);
	}
  	var eventInvitees = $('#<portlet:namespace/>eventInvitees').val();
	if (startDate != "" && endDate!="" && startTime!="" && endTime!="" && eventInvitees!="") {
		AUI().use('aui-io-request-deprecated', function(A){
	        A.io.request('<%=saveCalendarEvent.toString()%>', {
	               method: 'post',
	               form: {
	                   id: '<portlet:namespace/>updateCalendarEvent',
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
               			console.log(calendar.getEventSources());
	            		   if(data.details[1].responseText=="add"){
	            			   showMsg("Added successfully");
	            			   loadCalendarEvent();
	            		   }
	            		   else if(data.details[1].responseText=="update"){	            			  
	            			   showMsg("Updated successfully");
	            			   loadCalendarEvent();
	            			   cancelEvent();
	            		   }
	            		},
	                   failure:function(data){
	                	   //$("#wait").hide();
	                   }
	               }
	          });
	    });
	}else{
		cancelEvent();
		return false;
	}
} 

function  loadSignleEvent(id){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getSingleEventData'/>"
			,{
               method: 'get',
               data:{ 		
            	   '<portlet:namespace/>eventId': id
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
         	        		$("#<portlet:namespace/>eventTitle").val(data.eventTitle);
         	                $("#<portlet:namespace/>startDate").val(data.startDate);
         	                $("#<portlet:namespace/>endDate").val(data.endDate);
         	                $("#<portlet:namespace/>startTime").val(data.startTime);
         	                $("#<portlet:namespace/>endTime").val(data.endTime); 
         	                $("#<portlet:namespace/>eventLocation").val(data.eventLocation); 
         	                $("#<portlet:namespace/>iseventAllDay").val(data.iseventAllDay); 
         	                if(data.iseventAllDay==1){
         	                	$('input[name="eventAllDay"]').prop("checked",true);
         	          		}else if(data.iseventAllDay==0){
         	          			$('input[name="eventAllDay"]').prop("checked",false);
         	          		}         	                
         	                $("#<portlet:namespace/>eventTimeZone").val(data.eventTimeZone); 
         	                $("#<portlet:namespace/>eventRepeat1").val(data.eventRepeat1); 
         	                $("#<portlet:namespace/>eventRepeat2").val(data.eventRepeat2); 
         	                $("#<portlet:namespace/>endRepeat").val(data.endRepeat); 
         	                $("#<portlet:namespace/>eventInvitees").val(data.eventInvitee); 
         	                $("#<portlet:namespace/>eventAlert").val(data.eventAlert);
         	               	$("#<portlet:namespace/>eventURL").val(data.eventURL); 
         	                $("#<portlet:namespace/>eventNotes").val(data.eventNotes); 
         	                $("#<portlet:namespace/>eventId").val(data.eventId);
                 	   }                    	
                    },error: function(){	             
                    }
				},

	         });
		});
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
    	            	  location.reload();
    	              }    	               
    	              }
    	            }
    	          
    	      ]
		);
	});
});

function cancelEvent(){
	 $("#<portlet:namespace/>eventTitle").val("");
     $("#<portlet:namespace/>startDate").val("");
     $("#<portlet:namespace/>endDate").val("");
     $("#<portlet:namespace/>startTime").val("");
     $("#<portlet:namespace/>endTime").val("");
     $("#<portlet:namespace/>eventId").val("0");
     $("#<portlet:namespace/>eventLocation").val(""); 
     $("#<portlet:namespace/>iseventAllDay").val("");  
     $("#<portlet:namespace/>eventTimeZone").val("");
     $("#<portlet:namespace/>eventRepeat1").val(""); 
     $("#<portlet:namespace/>eventRepeat2").val("");
     $("#<portlet:namespace/>endRepeat").val(""); 
     $("#<portlet:namespace/>eventInvitees").val("");
     $("#<portlet:namespace/>eventAlert").val("");
     $("#<portlet:namespace/>eventURL").val("");
     $("#<portlet:namespace/>eventNotes").val("");
     $("#eventHeader").text("Add Event");
	 $("#<portlet:namespace/>saveEvent").text("Save");
	 $("#<portlet:namespace/>deleteEvent").addClass("d-none");
}
function userNames(){
	var userList = null;
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getUserNamesData'/>"
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
                    	userList = value;
                    },error: function(){	             
                    }
				},

	         });
	});
	return userList;
}

 
function split( val ) {
	return val.split( /,\s*/ );
}
function extractLast( term ) {
	return split( term ).pop();
}


/* var testData=[];
AUI().use('aui-io-request-deprecated','aui-modal', function(A){
	AUI().ready('aui-io-request', function(A){
		var jsonArray = [];
	 	AUI().use('autocomplete-list','aui-base','aui-io-request-deprecated','autocomplete-filters','autocomplete-highlighters',function (A) {
	 	new A.AutoCompleteList({
	 	allowBrowserAutocomplete: 'true',
	 	activateFirstItem: 'true',
	 	inputNode: '#<portlet:namespace />eventInvitees',
	 	resultTextLocator:'emailAddress',
	 	render: 'true',
	 	resultHighlighter: 'phraseMatch',
	 	resultFilters:['phraseMatch'],
	 	on: {
		    select: function(event) {
			debugger;
		    var data = event.result.raw;		    
		    var terms = split( data.emailAddress );
		 	// remove the current input
			terms.pop();
			// add the selected item
			terms.push( data.emailAddress );
			// add placeholder to get the comma-and-space at the end
			terms.push( "" );
			this.value = terms.join( ", " );
			//$("#<portlet:namespace />eventInvitees").val(data.emailAddress);
			$("#<portlet:namespace />eventInvitees").val(this.value);
			return false;

		    }
		   },
		   focus: function() {
				// prevent value inserted on focus
				return false;
			},
	 	source:function(request, response){
	 		var myAjaxRequest=A.io.request("<portlet:resourceURL id='getUserNamesData'/>",{
			 	dataType: 'json',
			 	method:'get',
			 	autoLoad:false,
			 	sync:false,
			 	on: {
			 	success:function(){
			 	var doctorName=this.get('responseData');
			 	var doctorName1=JSON.stringify(doctorName);
			 	var data=JSON.parse(doctorName1);
			 	if(data.length>0)
			 		testData=data;
			 		$(".form-validator-stack").show();
			 	}}
			 	}); 
			 	myAjaxRequest.start();
			 	
	 		return testData;
	 	},
	 	});
	 	});
	});
}); */

</script>