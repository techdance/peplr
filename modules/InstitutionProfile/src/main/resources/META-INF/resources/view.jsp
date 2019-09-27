<%@ include file="/init.jsp" %>

<section class="wrap-profile">	
	<div class="comunication box box-border-radius box-shadow bg-white">
		<div class="inner-wrap position-relative">
			<div class="box-top position-relative">
				<h2 class="box-subhead"><i class="fas fa-comments"></i>Institution Profile</h2>
				<a href="javascript:void(0);" class="icon-setting icon-box btn-menu"><i class="fas fa-cog" aria-hidden="true"></i></a>
			</div>	
			<div id="profile-map">
				<div id="map"></div>
			</div>
		 	<div class="box-middle">
                          <div class="content-icon">
                              <i class="fas fa-shield-alt"></i><a href="#">AHEA Institution</a>
                          </div>
                          <div class="content-icon">
                                  <i class="fas fa-map"></i><a href="#">Google Maps</a>
                          </div>
                          <div class="content-icon">
                              <i class="far fa-building"></i> 4-year Institution
                          </div>
                          <div class="content-icon">
                                  <i class="fas fa-globe"></i><a href="#">Boca Raton, FL USA</a>
                          </div>
                          <div class="content-icon">
                              <i class="far fa-calendar-check"></i>Trimester
                          </div>
                          <div class="content-icon">
                                  <i class="fas fa-address-card"></i>Department of American Sign Language and Deaf Studies
                          </div>
                          <div class="content-icon with-title">
                              <h4>Research Papers</h4>
                              <i class="far fa-file-pdf"></i><a href="#">Foundation of Empathy in Establishing Clinical Best Practices</a>
                          </div>
			</div>
		</div>
	</div>
</section>

<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDTB30uKJgKRGvIVHavUEPKACPZkqkkifg&sensor=false"></script>
<script>
$( document ).ready(function() {
	initMap();
});
$( window ).load(function() {
	initMap();
});
initMap();
function initMap() {
  var culver = {lat: 34.021122, lng: -118.396469};
  var map = new google.maps.Map(
  document.getElementById('map'), {zoom: 14, center: culver});
  var marker = new google.maps.Marker({position: culver, map: map});
}
</script>

