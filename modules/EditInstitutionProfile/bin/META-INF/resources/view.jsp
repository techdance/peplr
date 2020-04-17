<%@ include file="/init.jsp" %>

<div class="comunication box box-border-radius box-shadow bg-white">
                                        <div class="inner-wrap position-relative">
											<div class="box-top position-relative">
                                                <h2 class="box-subhead"><i class="fas fa-user"></i>Institution Profile</h2>
											</div>
											<div id="profile-map">
												<div id="map"></div>
											</div>
											<div class="box-middle">
												<div class="row row-custom">
	                                                <div class="col-md-6">
	                                               		<aui:input type="text" name="institution" label="Institution" value="AHEA Institution" cssClass="input" />
	                                               		<aui:input type="text" name="academic-calendar" label="Academic Calendar" value="Trimester" cssClass="input" />
	                                               		<aui:input type="textarea" name="departament" label="Department" value="Department of American Sign Language and Deaf Studies" cssClass="input" style="min-height: 120px;" />
	                                                </div>
	                                            </div>
											</div>
											<div class="box-bottom">
                                                <p><i class="fa fa-paperclip" aria-hidden="true"></i> Foundation of Empathy in Establishing Clinical Best Practices</p>
                                                <!-- <p><a href="#" class="btn btn-blue btn-w-100 btn2"><i class="fa fa-cloud-upload" aria-hidden="true"></i> Upload Research Paper PDF</a></p> -->
                                            </div>
                                        </div>
                                    </div>
                                    
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