<%@ include file="/init.jsp" %>

<!-- include the calendar js and css files -->
<script src="/o/ahea-theme/js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="/o/ahea-theme/css/jquery-ui.css">

<!-- initialize the calendar on ready -->
<script type="text/javascript">
	$(document).ready(function () {
		$( "#my-calendar" ).datepicker();
	});
</script>

<div>
	<div class="calendar box box-border-radius box-shadow bg-white height-auto">
		<div class="inner-wrap">
			<div class="box-top position-relative">
					<h2 class="box-subhead"><i class="icon-regular fa-calendar-alt"></i>My Calendar</h2>
				<a href="#" class="icon-setting icon-box"><i class="fas fa-cog"></i></a>
			</div>
		</div>
		<div class="box-middle">
			<!-- define the calendar element -->
			<div id='my-calendar-container'>
				<div id="my-calendar"></div>
			</div>
	
			<!-- include the calendar js and css files -->
			<!-- <script src="js/zabuto_calendar.js"></script>
			<link rel="stylesheet" type="text/css" href="css/zabuto_calendar.css"> -->
	
			<!-- initialize the calendar on ready -->
			<!-- <script type="text/javascript">
				$(document).ready(function () {
					var eventData = [
						{
							"date":"2019-10-15",
							"badge":true,
							"title":"Refine Course Description",
							"description":"<b>Organizer</b>, <i>Organizer</i>",
							"hour":"3:00pm EST",
							"link":"http://www.facebook.com",
							"classname":"green-event"
						},
						{
							"date":"2019-10-18",
							"badge":true,
							"title":"Determine credit hours",
							"description":"<b>Organizer</b>, <i>Organizer</i>",
							"hour":"3:00pm EST",
							"link":"http://www.facebook.com",
							"classname":"green-event"
						},
						{
							"date":"2019-10-25",
							"badge":true,
							"title":"Review Accreditation Guidelines",
							"description":"<b>Organizer</b>, <i>Organizer</i>",
							"hour":"3:00pm EST",
							"link":"http://www.facebook.com",
							"classname":"green-event"
						},
						{
							"date":"2019-10-29",
							"badge":true,
							"title":"Write Student Learning Outcomes",
							"description":"<b>Organizer</b>, <i>Organizer</i>",
							"hour":"3:00pm EST",
							"link":"http://www.facebook.com",
							"classname":"green-event"
						}
					];
					$("#my-calendar").zabuto_calendar({
						data: eventData,
						weekstartson: 0,
						nav_icon: {
							prev: '<i class="fa fa-angle-left"></i>',
							next: '<i class="fa fa-angle-right"></i>'
						}
					});
	
					$('#my-calendar-container').on('click', '.zabuto_calendar .event-styled .day', function(){
					//$(".zabuto_calendar .event-styled .day").live('click', function(){
						var myId = $(this).parent(".event-styled").attr("id");
						var date = myId.substr(-10, 10);
						var title="";
						var description="";
						var hour="";
						var link="";
	
						for (var i = 0; i < eventData.length; i++)
						{
							if (eventData[i].date == date){
								title = eventData[i].title;
								description = eventData[i].description;
								hour = eventData[i].hour;
								link = eventData[i].link;
							}
						}
	
						if($(this).find(".popup").length === 0)
							$(this).append("<span class='popup'><span class='event-title'>"+title+"<span class='popup-close'>x</span></span><span class='event-content'>"+description+"<br>"+hour+"</span><span class='event-link'><span onclick=\"location.href='"+link+"'\">View Event</span></span></span>");
	
						if($(this).find(".popup").css("display") == "none"){
							$(this).find(".popup").css("display","block");
						}
	
					});
	
					$('#my-calendar-container').on('click', '.event-styled .popup-close', function(e){
						e.stopPropagation();
						$(this).parents(".popup").css("display","none");
					});
				});
			</script> -->
		</div>
	</div>
</div>