<%@ include file="/init.jsp" %>

<link rel="stylesheet" href="/o/ahea-theme/css/owl.carousel.min.css">
<link rel="stylesheet" href="/o/ahea-theme/css/owl.theme.default.min.css">
<script src="/o/ahea-theme/js/owl.carousel.js"></script>

<script>
	jQuery(document).ready(function() {
		jQuery('.owl-carousel').owlCarousel({
			singleItem:true,
			autoplay:true,
			autoplayTimeout:5000,
			autoplayHoverPause:true,
			loop: true,
			margin: 10,
			navigation: true,
			responsiveClass: true,
			responsive: {
				1000: {
					items: 1,
					nav: true,
					loop: true,
					margin: 20
				},
				300: {
					items: 1,
					nav: true,
					loop: true,
					margin: 20
				}
			}
		});

		jQuery(".owl-dots").appendTo("#dots-number");
	});
</script>
									
<div class="box box-border-radius box-shadow bg-white w-100">
	<h2 class="box-subhead"><i class="fas fa-bullhorn"></i> Announcements</h2>
	<div id="wrap-owl-announcement">
		<div id="owl-announcement" class="owl-carousel owl-theme">
			<div class="item">
				<p>Dr. Smith from Dominican University is looking for 6 students for faculty led study abroad program to Singapore. <a href="#">Learn More</a>. </p>
			</div>
			<div class="item">
				<p>AHEA Conference Grant Deadline is August 30, 2019.<br> <a href="#">Learn More</a>. </p>
			</div>
			<div class="item">
				<p>Help us welcome our newest CollaboratED members: Institute of Internal Medicine, Patriots College, and Manna University. <a href="#">Learn More</a>. </p>
			</div>
		</div>
	</div>
	<div id="dots-number"></div>
</div>