<%@ include file="/init.jsp" %>

<div class="box box-border-radius box-shadow bg-white block-top">
	<div class="inner-wrap">
		<div class="box-top position-relative">
			<h3 class="box-subhead"><i class="fas fa-address-card"></i> Project Overview</h3>
			<a href="#" class="icon-setting icon-box"><i class="fas fa-cog"></i></a>
		</div>
		<div class="box-middle text1 d-flex">
			<div class="box-middle-inner">
				<h4>Course Name: <span style="font-weight: normal;font-style: italic;">Reduction in Epidural Puncture</span></h4>
				<h5>Course Description: </h5>
				<p>This course is designed to develop a student's ability to recognize and reason about ethical issues connected with multinational business management. At the completion of this course, students will be able to 1) identify possible ethical dilemmas arising from a cross-cultural context, 2) understand the factors in a cross-cultural context that inform a manager's decisions, and 3) apply knowledge of the cross-cultural context to resolve an ethical dilemma. All assignments will be read and completed in English.</p>
			</div>
			<div class="box-middle-inner text-center box-status">
				<h4>STATUS</h4>
				<div id="donut1" class="wrap-donut">
					<div class="text"></div>
					<canvas id="donut"></canvas>
				</div>
			</div>
		</div>

	</div>
</div>


<!-- JAVASCRIPT FOR DONUT CHART -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/0.2.0/Chart.min.js"></script>
<script type="text/javascript">

	var canvas = document.getElementById("donut");
	canvas.width = 140;
	canvas.height = 140;
	var percentage = "0";
	var colorDonut = "#339900";
	var fontSizeText = (parseInt(canvas.width)/3.5)+"px";

	jQuery("#donut1 .text").html(percentage+"%").css("color",colorDonut).css("font-size", fontSizeText).css("font-family","arial");

	var donutEl = document.getElementById("donut").getContext("2d");

	var donut = new Chart(donutEl).Doughnut(
	// Datas
	[
		{
			value: parseInt(percentage),
			color:colorDonut,//green
			highlight: "#FF5A5E",
			label: "Red"
		},
		{
			value: (parseInt(100) - parseInt(percentage)),
			color: "#e6e6e6",//grey
			highlight: "#5AD3D1",
			label: "Green"
		}
	],
	// Options
	{
		segmentShowStroke : true,
		segmentStrokeColor : "#fff",
		segmentStrokeWidth : 2,
		percentageInnerCutout : 70,
		animationSteps : 100,
		//animationEasing : "easeOutBounce",
		//animateRotate : true,
		//animateScale : false,
		responsive: true,
		maintainAspectRatio: true

	});

</script>
								