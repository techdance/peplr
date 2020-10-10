<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="javax.portlet.PortletSession"%>
<%@ include file="/init.jsp" %>
<%
JSONObject instituteProfile = null;JSONObject instituteProfileContact = null, instituteContact = null;
String instituteName = "",year = "",academicCalendar="",department="",insType="",cityState="",region="",address1="",address2="",postalCode="",insName="",country="";
long currentYear = Calendar.getInstance().get(Calendar.YEAR);
PortletSession sessionObj = renderRequest.getPortletSession();
instituteProfile = (JSONObject)sessionObj.getAttribute("INSTITUTE_PROFILE",PortletSession.APPLICATION_SCOPE);
if(instituteProfile!=null){
	instituteName = instituteProfile.getString("institutionName")+","+instituteProfile.getString("campusName");
	insName = instituteProfile.getString("institutionName");
	academicCalendar = instituteProfile.getString("academicCalendar");
	insType = instituteProfile.getString("insType");
	year = (currentYear-instituteProfile.getLong("founded")) + " - year institution";
	instituteProfileContact = instituteProfile.getJSONObject("institutionLocation");
	instituteContact = instituteProfile.getJSONObject("institutionContact");
	if(instituteProfileContact!=null){
		cityState = instituteProfileContact.getString("city")+", "+instituteProfileContact.getString("state");
		address1 = instituteProfileContact.getString("address1");
		address2 = instituteProfileContact.getString("address2");
		postalCode = instituteProfileContact.getString("postalCode");
		region = instituteProfileContact.getString("region");
		country = instituteProfileContact.getString("country");
	}
	if(instituteContact!=null){
		department = instituteContact.getString("department");
	}
}
%>
<section class="wrap-profile">	
	<div class="comunication box box-border-radius box-shadow bg-white">
		<!-- Loader -->
		<div id="institutionalProfileLoader" class="sectionloader"> 
			<div class="loader"></div>
		</div>
		<div class="inner-wrap position-relative">
			<div class="box-top position-relative">
				<h2 class="box-subhead"><span class="icon-regular icon-hospital-user"></span>Institution Profile</h2>
				<a href="javascript:void(0);" class="icon-setting icon-box btn-menu"><i class="fas fa-cog" aria-hidden="true"></i></a>
			</div>	
			<div id="profile-map" style="height:200px;"></div>
			<div id="institutionProfileData">
				<div class="box-middle">
				   <div class="content-icon">
				      <span class="icon-regular icon-user-shield"></span><a href="/institution-profile-overview"><%=instituteName %></a>
				   </div>
				   <!-- <div class="content-icon">
				      <i class="fas fa-map"></i><a href="#">Google Maps</a>
				   </div> -->
				   <div class="content-icon">
				      <span class="icon-regular icon-calendar-check"></span><%=year %>
				   </div>
				   <div class="content-icon">
				      <span class="icon-regular icon-globe"></span><a href="#"><%=cityState %></a>
				   </div>
				   <div class="content-icon">
				      <span class="icon-regular icon-globe-americas"></span><%=region %>
				   </div>
				   <div class="content-icon">
				      <span class="icon-regular icon-calendar-week"></span><%=academicCalendar %>
				   </div>
				   <div class="content-icon">
				      <span class="icon-regular icon-business-time"></span><%=department %>
				   </div>
				</div>
			 	<!-- <div class="box-middle">
	                <div class="content-icon">
	                    <i class="fas fa-shield-alt"></i><a href="#">AHEA Institution</a>
	                </div>
	                <div class="content-icon">
	                        <i class="fas fa-map"></i><a href="#">Google Maps</a>
	                </div>
	                <div class="content-icon">
	                    <i class="far fa-building"></i><a href="#">4-year Institution</a>
	                </div>
	                <div class="content-icon">
	                        <i class="fas fa-globe"></i><a href="#">Boca Raton, FL USA</a>
	                </div>
	                <div class="content-icon">
	                    <i class="far fa-calendar-check"></i><a href="#">Trimester</a>
	                </div>
	                <div class="content-icon">
	                        <i class="fas fa-address-card"></i><a href="#">Department of American Sign Language and Deaf Studies</a>
	                </div>
	                <div class="content-icon with-title">
	                    <h4>Research Papers</h4>
	                    <i class="far fa-file-pdf"></i><a href="#">Foundation of Empathy in Establishing Clinical Best Practices</a>
	                </div>
				</div>  -->
			</div>
		</div>
	</div>
</section>

<script>
var geocoder;
var map;
var address = '<%=address1%>'+','+'<%=address2%>'+','+'<%=cityState %>'+','+'<%=postalCode %>';
function initMap() {
	debugger;
  	var map = new google.maps.Map(document.getElementById('profile-map'), {
    	zoom: 12,
    	center: {lat: -34.397, lng: 150.644}
  	});
  	geocoder = new google.maps.Geocoder();
  	codeAddress(geocoder, map);
}

function codeAddress(geocoder, map) {
  	geocoder.geocode({'address': address}, function(results, status) {
	    if (status === 'OK') {
	      	map.setCenter(results[0].geometry.location);
	      	//map.setZoom(15);
	      	var marker = new google.maps.Marker({
	        	map: map,
	        	position: results[0].geometry.location
	      	});
	    } else {
	      alert('Geocode was not successful for the following reason: ' + status);
	    }
  	});
}

$(window).on('load', function() {
	initMap();
	$("#inviteProfileUniversity").text('<%=insName %>');
	$("#inviteProfileCity").text('<%=cityState %>');
	/* $("#institutionalProfileLoader").fadeOut(); */
});

$(document).ready(function(){
	$("#institutionalProfileLoader").fadeOut();
});
</script>

