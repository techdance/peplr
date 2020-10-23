<%@ include file="/init.jsp"%>

<!-- include the calendar js and css files -->
<script src="/o/ahea-theme/js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css"
	href="/o/ahea-theme/css/jquery-ui.css">

<!-- initialize the calendar on ready -->
<style>
	.event a {
	    border: 1px solid #ff6624 !important;
	    background: #ff6624 !important;
	    font-weight: normal;
	    color: #fff !important;
	    border-radius: 30px;
	}
	div#my-calendar-container .ui-widget.ui-widget-content .ui-datepicker-header .ui-datepicker-title .ui-datepicker-year{
		    display: inline-block;
	}
	div#my-calendar-container .ui-widget.ui-widget-content .ui-datepicker-header .ui-datepicker-title {
	   
	    font-size: 22px;
	    margin: 0 0.6em;
	}
</style>
<script type="text/javascript">
	var A = AUI();
	$(document).ready(function() {
		loadCalendarEvent(false);
		 /* var eventDates = {};
         eventDates[new Date('06/04/2020')] = new Date('06/04/2020').toString();
         eventDates[new Date('06/10/2020')] = new Date('06/10/2020').toString();
         eventDates[new Date('06/18/2020')] = new Date('06/18/2020').toString();
         console.log(eventDates);
		$("#datepicker").datepicker({
			 beforeShowDay: function (date) {
                 var highlight = eventDates[date];
                 if (highlight) {
                     return [true, "event", highlight];
                 } else {
                     return [true, '', ''];
                 }
             }
		}); */
		

	});

	function loadCalendarEvent() {
		AUI().use(
				'aui-io-request-deprecated',
				function(A) {
					A.io.request("<portlet:resourceURL id='getEventData'/>", {
						method : 'get',
						data : {},
						sync : true,
						on : {
							complete : function() {
							},
							success : function() {
								var value = this.get('responseData');
								debugger;
								if (value != null && value != "undefined"
										&& value != undefined && value!="null")  {
									var data = JSON.parse(value);
									if (data != null) {
										var eventDates = {};
										for(var i=0;i<data.length;i++){
											eventDates[new Date(data[i].start)] = new Date(data[i].start).toString();									        
									        console.log(eventDates);
										}								         
										$("#datepicker").datepicker({
											 beforeShowDay: function (date) {
								                 var highlight = eventDates[date];
								                 if (highlight) {
								                     return [true, "event", highlight];
								                 } else {
								                     return [true, '', ''];
								                 }
								             }
										});
									}

								}
								else {
									var eventDates = {};
							         eventDates[new Date('06/04/2020')] = new Date('06/04/2020').toString();
							         eventDates[new Date('06/10/2020')] = new Date('06/10/2020').toString();
							         eventDates[new Date('06/18/2020')] = new Date('06/18/2020').toString();
							         console.log(eventDates);
									$("#datepicker").datepicker({
										 beforeShowDay: function (date) {
							                 var highlight = eventDates[date];
							                 if (highlight) {
							                     return [true, "event", highlight];
							                 } else {
							                     return [true, '', ''];
							                 }
							             }
									});
								}
								$("#dashboardCalendarLoader").fadeOut();
							},
							error : function() {
							}
						},

					});
				});
	}
</script>

<div class="calendar box box-border-radius box-shadow bg-white">
	<!-- Loader -->
	<div id="dashboardCalendarLoader" class="sectionloader"> 
		<div class="loader"></div>
	</div>
	<div class="inner-wrap">
		<div class="box-top position-relative">
			<h2 class="box-subhead color-black hover-underline color-blue-light-hover"><i class="icon-regular fa-calendar-alt"></i> <a href="<%=themeDisplay.getURLPortal()%>/calendar">My Calendar</a></h2>
			<%-- <a href="<%=themeDisplay.getURLPortal()%>/calendar"><h2 class="box-subhead icon-fa-box icon-calendar-regular pl-4"> My Calendar</h2></a>  --%>
			<a href="javascript:void(0);" class="icon-setting icon-box"><i class="fas fa-cog"></i></a>
		</div>
	</div>
	<div class="box-middle">
		<!-- define the calendar element -->
		<div id='my-calendar-container'>
			<div id="datepicker"></div>
		</div>
	</div>
</div>