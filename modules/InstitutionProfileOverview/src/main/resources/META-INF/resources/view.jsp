<%@page import="java.text.DecimalFormat"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="java.util.Calendar"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ include file="/init.jsp" %>
<%
JSONObject instituteProfile = null;JSONObject institutionContact = null;JSONObject institutionLocation = null;
JSONObject studentDetails = null;JSONObject facultyDetails = null;JSONObject academicDetails = null;
JSONArray socialMediaArray = null;JSONArray collegeSchoolsArray = null;JSONArray accrediationsArray = null;
JSONArray recognitionsArray = null;JSONArray degreesArray = null;
String instituteName = "",campusName="",year = "",academicCalendar="",department="",insType="",cityState="",region="",instituteOverview="",language="",otherLanguages="",president="",instituteImage="";
long founded = 0,totalEmployees=0,alumini=0;
String facebookUrl="",twitterUrl="",instagramUrl="",linkedInUrl="",youtubeUrl = "";
long currentYear = Calendar.getInstance().get(Calendar.YEAR);

String officeNumber = "", phoneNumber = "", emailAddress = "", website="";
String address1="",address2="",postalCode="",studentTermYear = "",facultyTermYear="", academicYear = "", academicTermYear="", country="";
float totalStudents = 0, femaleStudents = 0, maleStudents = 0, undergradStudents = 0, gradStudents = 0, otherStudents = 0;
long fullTimeStudents = 0, partTimeStudents =0, inStateStudents = 0, outOfStateStudents = 0, interNationalStudents = 0; 
long fullTimeFaculty = 0, studentFacultyRatio = 0, facultyHigherDegree = 0, avgUGClassSize = 0;
long associateDegrees = 0, bachelorsDegrees = 0, masterDegrees = 0, doctorateDegrees = 0, underGraduate = 0, graduate = 0;
float femalePercentage = 0, malePercentage = 0, othersPercentage = 0;
DecimalFormat df = new DecimalFormat("0.00");

PortletSession sessionObj = renderRequest.getPortletSession();
instituteProfile = (JSONObject)sessionObj.getAttribute("INSTITUTE_PROFILE",PortletSession.APPLICATION_SCOPE);
if(instituteProfile!=null){
	socialMediaArray = instituteProfile.getJSONArray("socialMedias");
	institutionContact = instituteProfile.getJSONObject("institutionContact");
	institutionLocation = instituteProfile.getJSONObject("institutionLocation");
	studentDetails = instituteProfile.getJSONObject("studentDetails");
	facultyDetails = instituteProfile.getJSONObject("facultyDetails");
	academicDetails = instituteProfile.getJSONObject("academicDetails");
	collegeSchoolsArray = instituteProfile.getJSONArray("collegeSchools");
	accrediationsArray = instituteProfile.getJSONArray("accrediations");
	recognitionsArray = instituteProfile.getJSONArray("recognitions");
	degreesArray = instituteProfile.getJSONArray("degrees");
	
	instituteName = instituteProfile.getString("institutionName");
	campusName = instituteProfile.getString("campusName");
	instituteOverview = instituteProfile.getString("overview");
	academicCalendar = instituteProfile.getString("academicCalendar");
	insType = instituteProfile.getString("insType");
	year = (currentYear-instituteProfile.getLong("founded")) + " - year institution";
	founded = instituteProfile.getLong("founded");
	totalEmployees = instituteProfile.getLong("totalEmployees");
	alumini = instituteProfile.getLong("alumini");
	language = instituteProfile.getString("language");
	otherLanguages = instituteProfile.getString("otherLanguages");
	president = instituteProfile.getString("president");
	instituteImage = instituteProfile.getString("insProfileImage");
	
	if(institutionLocation!=null){
		cityState = institutionLocation.getString("city")+", "+institutionLocation.getString("state");
		address1 = institutionLocation.getString("address1");
		address2 = institutionLocation.getString("address2");
		postalCode = institutionLocation.getString("postalCode");
		region = institutionLocation.getString("region");
		country = institutionLocation.getString("country");
	}
	
	if(institutionContact!=null){
		officeNumber = institutionContact.getString("officeNumber");
		phoneNumber = institutionContact.getString("officeNumber");
		emailAddress = institutionContact.getString("email");
		website = institutionContact.getString("website");
		department = institutionContact.getString("department");
	}
	
	if(socialMediaArray.length()>0){
		for(int i=0;i<socialMediaArray.length();i++){
			JSONObject socialMedia = socialMediaArray.getJSONObject(i);
			if(socialMedia.getString("socialMedia").equalsIgnoreCase("Facebook")){ facebookUrl = socialMedia.getString("url"); }
			if(socialMedia.getString("socialMedia").equalsIgnoreCase("Twitter")){ twitterUrl = socialMedia.getString("url"); }
			if(socialMedia.getString("socialMedia").equalsIgnoreCase("Linkedin")){ linkedInUrl = socialMedia.getString("url"); }
			if(socialMedia.getString("socialMedia").equalsIgnoreCase("Youtube")){ youtubeUrl = socialMedia.getString("url"); }
			if(socialMedia.getString("socialMedia").equalsIgnoreCase("Instagram")){ instagramUrl = socialMedia.getString("url"); }
		}
	}
	
	if(studentDetails!=null){
		studentTermYear = studentDetails.getString("term") + " " + studentDetails.getString("year");
		totalStudents = (float)studentDetails.getLong("totalStudents");
		femaleStudents = (float)studentDetails.getLong("femaleStudents");
		maleStudents = (float)studentDetails.getLong("maleStudents");
		undergradStudents = (float)studentDetails.getLong("undergradStudents");
		gradStudents = (float)studentDetails.getLong("gradStudents");
		otherStudents = (float)studentDetails.getLong("otherStudents");
		fullTimeStudents = studentDetails.getLong("fullTimeStudents");
		partTimeStudents = studentDetails.getLong("partTimeStudents");
		inStateStudents = studentDetails.getLong("inStateStudents");
		outOfStateStudents = studentDetails.getLong("outOfStateStudents");
		interNationalStudents = studentDetails.getLong("interNationalStudents");
		femalePercentage = (float)((femaleStudents/totalStudents)* 100);
		malePercentage = (float)((maleStudents/totalStudents)* 100);
		othersPercentage = (float)((otherStudents/totalStudents)* 100);
	}
	
	if(facultyDetails!=null){
		facultyTermYear = facultyDetails.getString("term") + " " + facultyDetails.getString("year");
		fullTimeFaculty = facultyDetails.getLong("fullTimeFaculty");
		studentFacultyRatio = facultyDetails.getLong("studentFacultyRatio");
		facultyHigherDegree = facultyDetails.getLong("facultyHigherDegree");
		avgUGClassSize = facultyDetails.getLong("avgUGClassSize");
	}
	
	if(academicDetails!=null){
		academicTermYear = academicDetails.getString("term") + " " + academicDetails.getString("year");
		academicYear = academicDetails.getString("academicYear");
		associateDegrees = academicDetails.getLong("associateDegrees");
		bachelorsDegrees = academicDetails.getLong("bachelorsDegrees");
		masterDegrees = academicDetails.getLong("masterDegrees");
		doctorateDegrees = academicDetails.getLong("doctorateDegrees");
		underGraduate = academicDetails.getLong("underGraduate");
		graduate =  academicDetails.getLong("graduate");
	}
}
%>

<nav aria-label="breadcrumb">
	<ol class="breadcrumb">
	  <li class="breadcrumb-item"><a href="/home1">Home</a></li>
	  <li class="breadcrumb-item"><a href="#">Institution Profile</a></li>
		<li class="breadcrumb-item active" aria-current="page">Institution</li>
	</ol>
</nav>
<section class="wrap-institution">
	<div class="row row-custom ">
		<div class="col-lg-12 mb-4">
			<div class="personal box box-border-radius box-shadow bg-white position-relative position-relative">
				<!-- Loader -->
				<div id="IPIOLoader" class="sectionloader"> 
					<div class="loader"></div>
				</div>
				<div class="inner-wrap">
					<div class="box-top position-relative">
						<h2 class="box-subhead"><span class="icon-regular icon-school"></span>Institution Overview</h2>
					</div>
					<div class="box-middle">
						<div class="row row-custom">
							<div class="col-md-9">
								<p><%=instituteOverview %></p>
								<div class="row">
									<div class="col-md-3">
										<div class="mb-2">
											<strong>Founded</strong><br>
											<%=founded %>
										</div>
										<div class="mb-2">
											<strong>Academic Calendar</strong><br>
											&#8203;<%=academicCalendar %>
										</div>
									</div>
									<div class="col-md-3">
										<div class="mb-2">
											<strong>Type</strong><br>
											<%=insType %>
										</div>
										<%-- <div class="mb-2">
											<strong>Academic Calendar</strong><br>
											&#8203;<%=academicCalendar %>
										</div> --%>
									</div>
									<div class="col-md-3">
										<div class="mb-2">
											<strong>Language</strong><br>
											<%=language %>
										</div>
										<div class="mb-2">
											<strong>Other Languages</strong><br>
											<%=otherLanguages %>
										</div>
									</div>
									<div class="col-md-3">
										<div class="mb-2">
											<strong>President</strong><br>
											<%=president %>
										</div>
										<div class="mb-2">
											<strong>Total Employees: <%=totalEmployees %></strong><br>
											Alumni: <%=alumini %>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="img-resp">
									<img src="http://<%=instituteImage %>" class="img-responsive img-circle">
								</div>
								<div class="ahea-icons">
									<a href="<%=facebookUrl %>"><i class="fab fa-facebook-square"></i></a>
									<a href="<%=twitterUrl %>"><i class="fab fa-twitter-square"></i></a>
									<a href="<%=instagramUrl %>"><i class="fab fa-instagram-square"></i></a>
									<a href="<%=linkedInUrl %>"><i class="fab fa-linkedin"></i></a>
									<a href="<%=youtubeUrl %>"><i class="fab fa-youtube-square"></i></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div><!-- END COL -->
	</div>
</section>
<section class="wrap-profile">
	<div class="row row-custom ">
		<div class="col-lg-12">
			<div class="row row-custom sortable">
				<div class="col-lg-6 mb-4"><!-- Contact Info -->
					<div class="institution box box-border-radius box-shadow bg-white position-relative">
						<!-- Loader -->
						<div id="IPContactInfoLoader" class="sectionloader"> 
							<div class="loader"></div>
						</div>
						<div class="inner-wrap">
							<div class="box-top position-relative">
								<h2 class="box-subhead mw-100"><span class="icon-regular icon-comment-dots"></span> Contact Info</h2>
							</div>
							<div class="box-middle">
								<div class="row row-custom">
									<div class="col-md-6">
										<div class="content-icon content-icon2">
											<p class="mb-1"><span class="icon-solid icon-phone-alt"></span> <a href="#">+<%=officeNumber %></a></p>
											<p class="mb-1"><span class="icon-solid icon-phone-office"></span> <a href="#">+<%=phoneNumber %></a></p>
											<p class="mb-1"><span class="icon-solid fa-desktop-alt"></span> <a href="https://www.ahea.edu"><%=website %></a></p>
											<p class="mb-1"><span class="icon-solid icon-envelope"></span> <a href="mailto:info@ahea.edu"><%=emailAddress %></a></p>
										</div>
									</div>
									<div class="col-md-6 mp0 line-height-15">
										<strong><%=instituteName %></strong>
										<p class="mb-0"><%=department %> </p>
										<p class="mb-0"><%=address1 %></p>
										<p class="mb-0"><%=address2 %></p>
										<p class="mb-0"><%=cityState %> <%=country %> <%=postalCode %></p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div><!-- END COL -->
				<div class="col-lg-6 mb-4"><!-- Location -->
					<div class="comunication box box-border-radius box-shadow bg-white position-relative">
						<!-- Loader -->
						<div id="locationLoader" class="sectionloader"> 
							<div class="loader"></div>
						</div>
						<div class="inner-wrap position-relative">
							<div class="box-top position-relative">
								<h2 class="box-subhead"><span class="icon-regular icon-globe-americas"></span> </span>Location</h2>
								<div class="form-group">
									<select class="select border-grey">
									<option><%=campusName %></option>
									</select>
								</div>
							</div>
							<div id="profile-map">
								<div id="map-canvas" class="w-100 mb-4" style="height:235px;"></div>
							</div>
							<div class="box-middle">
								<div class="content-icon line-height-15">
									<i class="fas fa-map"></i> <strong><%=instituteName %></strong> <br>
									<%=address1 %> <br>
									<%=cityState %> <%=country %> <%=postalCode %> <br>
								</div>
								<div class="content-icon line-height-15">
									<i class="fas fa-map-marker-alt"></i> <strong><%=region %></strong>
								</div>
							</div>

						</div>
					</div>
				</div><!-- END COL -->
			</div>
		</div>
	</div><!-- row -->
	<div class="row row-custom section-student-body mb-3">
		<div class="col-lg-12">
			<div class=" box box-border-radius box-shadow bg-white position-relative">
				<!-- Loader -->
				<div id="studentBodyLoader" class="sectionloader"> 
					<div class="loader"></div>
				</div>
				<div class="inner-wrap">
					<div class="box-top d-flex justify-content-between">
						<h2 class="box-subhead mw-100"><i class="far fa-user-graduate"></i> Student Body</h2>
						<div>
							<h3 class="ar"><%=studentTermYear %></h3>
							<!-- <em>Updated 2020-03-16</em> -->
						</div>
					</div>
					<div class="box-middle color-white">
						<div class="row row-custom">
							<div class="col-md-4 mb-2">
								<div class="box-color box-color-blue mb-2">
									<h4 class="color-white">Total</h4>
									<div class="box-number font-100 text-center"><%=(long)totalStudents %></div>
								</div>
								<div class="box-color box-color-blue mb-2">
									<h4 class="color-white">Undergraduate Students</h4>
									<div class="box-number font-100 text-center"><%=(long)undergradStudents %></div>
								</div>
								<div class="box-color box-color-blue">
									<h4 class="color-white">Graduate Students</h4>
									<div class="box-number text-center"><%=(long)gradStudents %></div>
								</div>
							</div>

							<div class="col-md-4 mb-2">
								<div class="box-chart-pie">

									<div id="chartContainer" style="height: 320px; width: 100%;"></div>

								</div>

							</div>
							<div class="col-md-4 mb-2">
								<div class="box-chart-pie">
									<div id="chartContainer2" style="height: 320px; width: 100%;"></div>
								</div>

							</div>
						</div>
						<div class="row row-custom">
							<div class="col-md-4 mb-2">
								<div class="box-color box-color-orange color-blak">
									<h4>Female Students</h4>
									<div class="box-number text-center color-black"><%=(long)femaleStudents %> (<%=df.format(femalePercentage) %>%)</div>
								</div>
							</div>
							<div class="col-md-4 mb-2">
								<div class="box-color box-color-orange">
									<h4>Male Students</h4>
									<div class="box-number text-center color-black"><%=(long)maleStudents %> (<%=df.format(malePercentage) %>%)</div>
								</div>
							</div>
							<div class="col-md-4 mb-2">
								<div class="box-color box-color-orange">
									<h4>Other Students</h4>
									<div class="box-number text-center color-black"><%=(long)otherStudents %> (<%=df.format(othersPercentage) %>%)</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div><!-- row -->

	<div class="row row-custom section-faculty mb-3">
		<div class="col-lg-12">
			<div class="box box-border-radius box-shadow bg-white position-relative">
				<!-- Loader -->
				<div id="facultyLoader" class="sectionloader"> 
					<div class="loader"></div>
				</div>
				<div class="inner-wrap">
					<div class="box-top d-flex justify-content-between">
						<h2 class="box-subhead mw-100"><span class="icon-regular icon-user-tie"></span> Faculty</h2>
						<div>
							<h3 class="ar"><%=facultyTermYear %></h3>
							<!-- <em>Updated 2020-03-16</em> -->
						</div>
					</div>
					<div class="box-middle color-white">
						<div class="row row-custom">
							<div class="col-md-3 mb-2">
								<div class="box-color box-color-blue mb-2 h-100">
									<h4 class="color-white">Full-Time Faculty</h4>
									<div class="box-number font-100 text-center"><%=fullTimeFaculty %></div>
								</div>
							</div>
							<div class="col-md-3 mb-2">
								<div class="box-color box-color-blue mb-2 h-100">
									<h4 class="color-white">Student-Faculty Ratio</h4>
									<div class="box-number font-100 text-center"><%=studentFacultyRatio %></div>
								</div>
							</div>
							<div class="col-md-3 mb-2">
								<div class="box-color box-color-blue mb-2 h-100">
									<h4 class="color-white">Faculty with Highest Degree in Field</h4>
									<div class="box-number font-100 text-center"><%=facultyHigherDegree %></div>
									<div class="text-center font20"><strong>84.9%</strong></div>
								</div>
							</div>
							<div class="col-md-3 mb-2">
								<div class="box-color box-color-blue mb-2 h-100">
									<h4 class="color-white">Average Undergraduate Class Size</h4>
									<div class="box-number font-100 text-center"><%=avgUGClassSize %></div>
									<div class="text-center"><strong>Students</strong></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div><!-- row -->

	<div class="row row-custom section-academics mb-3">
		<div class="col-lg-12">
			<div class=" box box-border-radius box-shadow bg-white position-relative">
				<!-- Loader -->
				<div id="academicLoader" class="sectionloader"> 
					<div class="loader"></div>
				</div>
				<div class="inner-wrap">
					<div class="box-top d-flex justify-content-between">
						<h2 class="box-subhead mw-100">
							<span class="icon-book-user icon-regular"></span> Academic
						</h2>
						<div>
							<h3 class="ar"><%=academicTermYear %></h3>
							<!-- <em>Updated 2020-03-16</em> -->
						</div>
					</div>
					<div class="box-middle color-white">
						<div class="row row-custom">
							<div class="col-md-4 mb-4">
								<div class="box-color border-grey h-100">
									<h4 class="mb-3">Colleges & Schools</h4>
									<div class="text-center font60 color-black mb-4">
										<%=collegeSchoolsArray.length() %>
									</div>
									<div class="list-bullet">
										<ul>
											<%
											if(collegeSchoolsArray.length()>0){
												for(int i=0;i<collegeSchoolsArray.length();i++){
													JSONObject collegeSchools = collegeSchoolsArray.getJSONObject(i);
													%><li><a href="#"><%=collegeSchools.getString("collegeSchoolName") %></a></li>
													<%
												}
											}
											%>
										</ul>
									</div>
								</div>
							</div>
							<div class="col-md-4 mb-4">
								<div class="box-color border-grey h-100">
									<h4 class="mb-3">Degree Programs</h4>
									<div id="chartContainer3" style="height: 300px; width: 100%;"></div>
								</div>
							</div>
							<div class="col-md-4 mb-4">
								<div class="box-color border-grey h-100">
									<h4 class="mb-3">Degrees Granted During</h4>

									<div class="color-black line-height-15">
										<p><strong>Academic Year: <%=academicYear %></strong></p>
										<p>
											Associate Degrees:<%=associateDegrees %><br>
											Bachelors Degrees: <%=bachelorsDegrees %><br>
											Masters Degrees: <%=masterDegrees %> <br>
											Doctorate Degrees: <%=doctorateDegrees %>
										</p>
									</div>

									<div id="chartContainer4" style="height: 170px; width: 100%;"></div>
								</div>
							</div>


							<div class="col-md-4 mb-4">
								<div class="box-color border-grey h-100">
									<h4 class="mb-3">Accreditation</h4>
									<div class="list-bullet">
										<ul>								
											<%
											if(accrediationsArray.length()>0){
												for(int i=0;i<accrediationsArray.length();i++){
													JSONObject accrediations = accrediationsArray.getJSONObject(i);
													%><li><a href="#"><%=accrediations.getString("accrediation") %></a></li>
													<%
												}
											}
											%>
										</ul>
									</div>
								</div>
							</div>
							<div class="col-md-4 mb-4">
								<div class="box-color border-grey h-100">
									<h4 class="mb-3">Recognition</h4>
									<div class="list-bullet">
										<ul>
											<%
											if(recognitionsArray.length()>0){
												for(int i=0;i<recognitionsArray.length();i++){
													JSONObject recognitions = recognitionsArray.getJSONObject(i);
													%><li><a href="#"><%=recognitions.getString("recognition") %></a></li>
													<%
												}
											}
											%>
										</ul>
									</div>
								</div>
							</div>
							<div class="col-md-4 mb-4">
								<div class="box-color border-grey h-100">
									<h4 class="mb-3">Degrees Offered</h4>
									<div class="list-bullet">
										<ul>
											<%
											if(degreesArray.length()>0){
												for(int i=0;i<degreesArray.length();i++){
													JSONObject degrees = degreesArray.getJSONObject(i);
													%><li><a href="#"><%=degrees.getString("degreeName") %></a></li>
													<%
												}
											}
											%>
										</ul>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div><!-- row -->
</section>

<script>
$(document).ready(function() {
	
	initMap();

	CanvasJS.addColorSet("customColorSet", [
		"#0a4366",
		"#ff7900",
		"#808184",
		"#f98461",
		"#d9695f",
		"#e05850",
	]);

	var chart = new CanvasJS.Chart("chartContainer", {
		animationEnabled: true,
		colorSet: "customColorSet",
		legend:{
			cursor: "pointer"
		},
		data: [{
			type: "pie",
			showInLegend: true,
			toolTipContent: "{name}: <strong>{y}</strong>",
			indexLabel: "{y}",
			dataPoints: [
				{ y: <%=fullTimeStudents %>, name: "Full-Time" },
				{ y: <%=partTimeStudents %>, name: "Part-Time" },
			],
			indexLabelPlacement: "inside",
			indexLabelFontColor: "#fff",
			indexLabelFontSize: 22,
			indexLabelFontWeight: "bolder",
		}]
	});
	chart.render();



	var chart2 = new CanvasJS.Chart("chartContainer2", {
		animationEnabled: true,
		colorSet: "customColorSet",
		legend:{
			cursor: "pointer"
		},
		data: [{
			type: "pie",
			showInLegend: true,
			toolTipContent: "{name}: <strong>{y}</strong>",
			indexLabel: "{y}",
			dataPoints: [
				{ y: <%=inStateStudents %>, name: "In-State" },
				{ y: <%=outOfStateStudents %>, name: "Out of State" },
				{ y: <%=interNationalStudents %>, name: "International" },
			],
			indexLabelPlacement: "inside",
			indexLabelFontColor: "#fff",
			indexLabelFontSize: 22,
			indexLabelFontWeight: "bolder",
		}]
	});
	chart2.render();


	var chart3 = new CanvasJS.Chart("chartContainer3", {
		animationEnabled: true,
		colorSet: "customColorSet",
		title: {
			dockInsidePlotArea: true,
			fontSize: 50,
			fontWeight: "normal",
			horizontalAlign: "center",
			verticalAlign: "center",
			text: <%=underGraduate %> + <%=graduate %>
		},
		legend: {
			cursor: "pointer"
		},
		data: [{
			type: "doughnut",
			showInLegend: true,
			startAngle: 60,
			//innerRadius: 60,
			indexLabelFontSize: 17,
			indexLabel: "{y}",
			toolTipContent: "{y} (#percent%)",
			dataPoints: [
				{ y: <%=underGraduate %>, name: "Undergraduate" },
				{ y: <%=graduate %>, name: "Graduate" },
			]
		}],
		indexLabelPlacement: "inside",
		indexLabelFontColor: "#fff",
		indexLabelFontSize: 11,
		indexLabelFontWeight: "bolder",
	});
	chart3.render();




	var chart4 = new CanvasJS.Chart("chartContainer4", {
		animationEnabled: true,



		data: [{
			type: "bar",
			name: "companies",
			axisYType: "secondary",
			color: "#0a4366",
			dataPoints: [
				{ y: <%=doctorateDegrees %>, label: "Doctorate Degrees" },
				{ y: <%=masterDegrees %>, label: "Master's Degrees" },
				{ y: <%=bachelorsDegrees %>, label: "Bachelor's Degrees" },
				{ y: <%=associateDegrees %>, label: "Associate Degrees" },
			]
		}]
	});
	chart4.render();
	
	$(".sectionloader").fadeOut();
});

var geocoder;
var map;
var address = '<%=address1%>'+','+'<%=address2%>'+','+'<%=cityState %>'+','+'<%=postalCode %>';
function initMap() {
  	var map = new google.maps.Map(document.getElementById('map-canvas'), {
    	zoom: 8,
    	center: {lat: -34.397, lng: 150.644}
  	});
  	geocoder = new google.maps.Geocoder();
  	codeAddress(geocoder, map);
}

function codeAddress(geocoder, map) {
  	geocoder.geocode({'address': address}, function(results, status) {
	    if (status === 'OK') {
	      	map.setCenter(results[0].geometry.location);
	      	var marker = new google.maps.Marker({
	        	map: map,
	        	position: results[0].geometry.location
	      	});
	    } else {
	      alert('Geocode was not successful for the following reason: ' + status);
	    }
  	});
}

</script>