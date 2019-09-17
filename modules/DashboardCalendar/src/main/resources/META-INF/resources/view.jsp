<%@ include file="/init.jsp" %>

<!-- include the calendar js and css files -->
		<script src="/o/ahea-theme/js/jquery-ui.js"></script>
		<link rel="stylesheet" type="text/css" href="/o/ahea-theme/css/jquery-ui.css">

		<!-- initialize the calendar on ready -->
		<script type="text/javascript">
			$(document).ready(function () {
				$( "#datepicker" ).datepicker();
			});
		</script>
		
<div class="calendar box box-border-radius box-shadow bg-white">
	<div class="inner-wrap">
		<div class="box-top position-relative">
				<h2 class="box-subhead"><i class="far fa-calendar-alt"></i>My Calendar</h2>
			<a href="#" class="icon-setting icon-box"><i class="fas fa-cog"></i></a>
		</div>
	</div>
	<div class="box-middle">

		<!-- define the calendar element -->
		<div id='my-calendar-container'>
			<div id="datepicker"></div>
		</div>

		

	</div>
</div>