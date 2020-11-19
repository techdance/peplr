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
				<p>We are pleased to welcome our AHEA Faculty Fellows to InspirED. Thank you for your partnership, participation, and feedback.<br> <a href="https://www.ahealliance.org/virtualexchangefellowship/">Learn More</a> </p>
			</div>
			<div class="item">
				<p>Discover tips and techniques to help you optimize InspirED. Download how-to guides, best practices, and templates from the platform's Resources library.<br> <a href="/resources">Learn More</a> </p>
			</div>
			<div class="item">
				<p>Join CONAHEC and AMPEI for the Virtual North American International Education Conference: Rebuilding the Global Village. December 1-5, 2020.<br>  <a href="https://elnet.org">Learn More</a> </p>
			</div>
			<div class="item">
				<p>ISEP celebrates 40 years of collaboration and partnership. With over 350 member institutions, ISEP has provided cross-cultural experiences for over 60K students. <br> <a href="https://www.isepstudyabroad.org/">Learn More</a> </p>
			</div>
		</div>
	</div>
	<div id="dots-number"></div>
</div>