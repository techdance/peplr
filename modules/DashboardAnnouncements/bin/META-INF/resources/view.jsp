<%@ include file="/init.jsp" %>

<link rel="stylesheet" href="/o/ahea-theme/css/owl.carousel.min.css">
<link rel="stylesheet" href="/o/ahea-theme/css/owl.theme.default.min.css">
<script src="/o/ahea-theme/js/owl.carousel.js"></script>
<style>
	h1, h2, h3, h4, h5, h6, .h1, .h2, .h3, .h4, .h5, .h6{
		    font-family: inherit !important;
	}
	
</style>
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
		$("#dashboardAnnouncementLoader").fadeOut();
	});
</script>
									
<div class="box box-border-radius box-shadow bg-white w-100">
	<!-- Loader -->
	<div id="dashboardAnnouncementLoader" class="sectionloader">
		<div class="loader"></div>
	</div>
	<h2 class="box-subhead icon-fa-box icon-bullhorn"> Announcements</h2>
	<div id="wrap-owl-announcement">
		<div id="owl-announcement" class="owl-carousel owl-theme">
			<div class="item">
				<p>Fall Term registration is open Wednesday, April 1 through Friday, May 1, 2020.<br> <a href="#">Learn More</a> </p>
			</div>
			<div class="item">
				<p>AHEA Conference Grant Deadline is August 28, 2020.<br> <a href="#">Learn More</a> </p>
			</div>
			<div class="item">
				<p>Help us welcome our newest CollaboratED members: Georgia International University; &#8203;Ballsbridge University, Dominica; and Edinburgh Institute for Global Affairs. <a href="https://en.wikipedia.org/w/index.php?title=Ballsbridge_University,_Dominica&action=edit&redlink=1">Learn More</a> </p>
			</div>
			<div class="item">
				<p>Dr. Smith from Dominican University is looking for 6 students for a faculty-led study &#8203;abroad program to Singapore.  <a href="https://en.wikipedia.org/w/index.php?title=Ballsbridge_University,_Dominica&action=edit&redlink=1">Learn More</a> </p>
			</div>
		</div>
	</div>
	<div id="dots-number"></div>
</div>