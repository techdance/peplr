<%@page import="javax.portlet.PortletSession"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ include file="/init.jsp" %>
<%
JSONObject instituteProfile = null;JSONObject institutionContact = null;JSONObject institutionLocation = null;
JSONObject studentDetails = null;JSONObject facultyDetails = null;JSONObject academicDetails = null;
JSONArray socialMediaArray = null;JSONArray collegeSchoolsArray = null;JSONArray accrediationsArray = null;
JSONArray recognitionsArray = null;JSONArray degreesArray = null;
String instituteName = "",campusName="",year = "",academicCalendar="",insType="",cityState="",region="",instituteOverview="",language="",otherLanguages="",president="",instituteImage="";
long founded = 0,totalEmployees=0,alumini=0;
String facebookUrl="",twitterUrl="",instagramUrl="",linkedInUrl="",youtubeUrl = "";
long currentYear = Calendar.getInstance().get(Calendar.YEAR);

String officeNumber = "", phoneNumber = "", emailAddress = "", website="", New="", contactaddress1="",contactaddress2="", contactstate="", contactcity="", contactFax="", mailingName="", department="";
String address1="",address2="",postalCode="",studentTerm = "",studentYear="",facultyTerm="",facultyYear="", academicYear = "", academicTerm="",academicTeYear="";
long contactpostalcode = 0;String locationCity="", locationState = "";
long totalStudents = 0, femaleStudents = 0, maleStudents = 0, undergradStudents = 0, gradStudents = 0, otherStudents = 0;
long fullTimeStudents = 0, partTimeStudents =0, inStateStudents = 0, outOfStateStudents = 0, interNationalStudents = 0; 
long fullTimeFaculty = 0, studentFacultyRatio = 0, facultyHigherDegree = 0, avgUGClassSize = 0;
long associateDegrees = 0, bachelorsDegrees = 0, masterDegrees = 0, doctorateDegrees = 0, underGraduate = 0, graduate = 0;

PortletSession sessionObj = renderRequest.getPortletSession();
instituteProfile = (JSONObject)sessionObj.getAttribute("LIFERAY_SHARED_INSTITUTE_PROFILE",PortletSession.APPLICATION_SCOPE);
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
		locationCity = institutionLocation.getString("city");
		locationState = institutionLocation.getString("state");
	}
	
	if(institutionContact!=null){
		officeNumber = institutionContact.getString("officeNumber");
		phoneNumber = institutionContact.getString("officeNumber");
		emailAddress = institutionContact.getString("email");
		website = institutionContact.getString("website");
		New = institutionContact.getString("new");
		contactaddress1 = institutionContact.getString("address1");
		contactaddress2 = institutionContact.getString("address2");
		contactcity = institutionContact.getString("city");
		contactstate = institutionContact.getString("state");
		contactFax = institutionContact.getString("faxNumber");
		contactpostalcode = institutionContact.getLong("postalCode");
		mailingName = institutionContact.getString("mailingName");
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
		studentTerm = studentDetails.getString("term");
		studentYear = studentDetails.getString("year");
		totalStudents = studentDetails.getLong("totalStudents");
		femaleStudents = studentDetails.getLong("femaleStudents");
		maleStudents = studentDetails.getLong("maleStudents");
		undergradStudents = studentDetails.getLong("undergradStudents");
		gradStudents = studentDetails.getLong("gradStudents");
		otherStudents = studentDetails.getLong("otherStudents");
		fullTimeStudents = studentDetails.getLong("fullTimeStudents");
		partTimeStudents = studentDetails.getLong("partTimeStudents");
		inStateStudents = studentDetails.getLong("inStateStudents");
		outOfStateStudents = studentDetails.getLong("outOfStateStudents");
		interNationalStudents = studentDetails.getLong("interNationalStudents");
	}
	
	if(facultyDetails!=null){
		facultyTerm = facultyDetails.getString("term");
		facultyYear = facultyDetails.getString("year");
		fullTimeFaculty = facultyDetails.getLong("fullTimeFaculty");
		studentFacultyRatio = facultyDetails.getLong("studentFacultyRatio");
		facultyHigherDegree = facultyDetails.getLong("facultyHigherDegree");
		avgUGClassSize = facultyDetails.getLong("avgUGClassSize");
	}
	
	if(academicDetails!=null){
		academicTerm = academicDetails.getString("term");
		academicTeYear = academicDetails.getString("year");
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
<section class="wrap-institution">
<div class="row row-custom ">
	<div class="col-lg-12 mb-4">
		<div class="personal box box-border-radius box-shadow bg-white position-relative">
			<div class="inner-wrap">
				<div class="box-top position-relative">
					<h2 class="box-subhead"><span class="icon-regular icon-school"></span>Institution Overview</h2>
				</div>
				<div class="box-middle">
					<div class="row row-custom">
						<div class="col-md-9">
							<div class="mb-3">
								<aui:input type="textarea" name="" label="" rows="6" value="<%=instituteOverview %>" cssClass="input" />
							</div>
							<div class="row">
								<div class="col-md-3">
									<div class="mb-2">
										<aui:input type="text" name="Founded" label="Founded" value="<%=founded %>" cssClass="input" />
									</div>
									<div class="mb-2">
										<aui:input type="text" name="academicCalendar" label="Academic Calendar" value="<%=academicCalendar %>" cssClass="input" />
									</div>
								</div>
								<div class="col-md-3">
									<div class="mb-2">
										<aui:select name="Type" label="Type" cssClass="input select" value="<%=insType %>">
											<aui:option>Not-for-Profit</aui:option>
											<aui:option>Private</aui:option>
											<aui:option>Coed</aui:option>
										</aui:select>
									</div>
								</div>
								<div class="col-md-3">
									<div class="mb-2">
										<aui:input type="text" name="Language" label="Language" value="<%=language %>" cssClass="input" />
									</div>
									<div class="mb-2">
										<aui:select name="otherLanguages" label="Other Languages" cssClass="input select" value="<%=otherLanguages %>">
											<aui:option>Spanish</aui:option>
											<aui:option>Mandarin</aui:option>
											<aui:option>French</aui:option>
										</aui:select>
									</div>
								</div>
								<div class="col-md-3">
									<div class="mb-2">
										<aui:input type="text" name="President" label="President" value="<%=president %>" cssClass="input" />
									</div>
									<div class="mb-2">
										<aui:input type="text" name="totalEmployees" label="Total Employees" value="<%=totalEmployees %>" cssClass="input" />
									</div>
									<div class="mb-2">
										<aui:input type="text" name="Alumni" label="Alumni" value="<%=alumini %>" cssClass="input" />
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-3 img-resp">
							<img src="http://<%=instituteImage %>" class="img-responsive img-circle">
						</div>
					</div>
				</div>
			</div>
			<div class="box-top position-relative">
				<h2 class="box-subhead"><span class="icon-regular icon-share"></span>Social Media</h2>
			</div>
			<div class="box-middle">
				<div class="row row-custom">
					<div class="col-md-4">
						<div class="d-flex align-items-end formGroupmb0 mb-2">
							<a href="javascript::void(0);" class="color-orange font20 mr-1"><i class="fas fa-minus-circle"></i></a>
							<aui:input type="text" name="Facebook" label="Facebook" value="<%=facebookUrl %>" cssClass="input" />
						</div>
						<div class="d-flex align-items-end formGroupmb0 mb-2">
							<a href="javascript::void(0);" class="color-orange font20 mr-1"><i class="fas fa-minus-circle"></i></a>
							<aui:input type="text" name="Twitter" label="Twitter" value="<%=twitterUrl %>" cssClass="input" />
						</div>
						<div class="d-flex align-items-end formGroupmb0 mb-2">
							<a href="javascript::void(0);" class="color-orange font20 mr-1"><i class="fas fa-minus-circle"></i></a>
							<aui:input type="text" name="Instagram" label="Instagram" value="<%=instagramUrl %>" cssClass="input" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="d-flex align-items-end formGroupmb0 mb-2">
							<a href="javascript::void(0);" class="color-orange font20 mr-1"><i class="fas fa-minus-circle"></i></a>
							<aui:input type="text" name="LinkedIn" label="LinkedIn" value="<%=linkedInUrl %>" cssClass="input" />
						</div>
						<div class="d-flex align-items-end formGroupmb0 mb-2">
							<a href="javascript::void(0);" class="color-orange font20 mr-1"><i class="fas fa-minus-circle"></i></a>
							<aui:input type="text" name="YouTube" label="YouTube" value="<%=youtubeUrl %>" cssClass="input" />
						</div>
						<div class="form-group mb-2 mt-4">
							<div class="d-flex align-items-center">
								<a href="javascript::void(0);" class="color-orange font20 mr-1"><i class="fas fa-plus-circle"></i></a>
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
					<div class="institution box box-border-radius box-shadow bg-white">
						<div class="inner-wrap">
							<div class="box-top position-relative">
								<h2 class="box-subhead mw-100"><span class="icon-regular icon-comment-dots"></span> Contact info</h2>
							</div>
							<div class="box-middle">
								<div class="row row-custom">
									<div class="col-md-6">
										<div class="mb-2">
											<aui:input type="text" name="Office" label="Office" value="<%=officeNumber %>" cssClass="input" />
										</div>
										<div class="mb-2">
											<aui:input type="text" name="Fax" label="Fax" value="<%=phoneNumber %>" cssClass="input" />
										</div>
										<div class="mb-2">
											<aui:input type="text" name="Website" label="Website" value="<%=website %>" cssClass="input" />
										</div>
										<div class="mb-2">
											<aui:input type="text" name="Email" label="Email" value="<%=emailAddress %>" cssClass="input" />
										</div>
										<div class="mb-2">
											<aui:input type="text" name="New" label="New" value="<%=New %>" cssClass="input" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="mb-2">
											<aui:input type="text" name="MailingName" label="Mailing Name" value="<%=mailingName %>" cssClass="input" />
										</div>
										<div class="mb-2">
											<aui:input type="text" name="Department" label="Department" value="<%=department %>" cssClass="input" />
										</div>
										<div class="mb-2">
											<aui:input type="text" name="Address1" label="Address 1" value="<%=contactaddress1 %>" cssClass="input" />
										</div>
										<div class="mb-2">
											<aui:input type="text" name="Address2" label="Address 2" value="<%=contactaddress2 %>" cssClass="input" />
										</div>
										
										
										<div class="form-group d-flex">
											<div class="pr-2">
												<aui:input type="text" name="City" label="City" value="<%=contactcity %>" cssClass="input" />
											</div>
											<div class="pr-2">
												<aui:input type="text" name="State" label="State" value="<%=contactstate %>" cssClass="input" />
											</div>
											<div>
												<aui:input type="text" name="PostalCode" label="Postal C." value="<%=contactpostalcode %>" cssClass="input" />
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div><!-- END COL -->
				<div class="col-lg-6 mb-4"><!-- Location -->
					<div class="institution box box-border-radius box-shadow bg-white">
						<div class="inner-wrap">
							<div class="box-top position-relative">
								<h2 class="box-subhead"><span class="icon-regular icon-globe-americas"></span> Location</h2>
							</div>
							<div class="box-middle">
								<div class="row row-custom">
									<div class="col-md-6">
										<div class="mb-2">
											<aui:input type="text" name="CampusName" label="Campus Name" value="<%=campusName %>" cssClass="input" />
										</div>
										<div class="mb-2">
											<aui:input type="text" name="InstitutionName" label="Institution Name" value="<%=instituteName %>" cssClass="input" />
										</div>
										<div class="mb-2">
											<aui:input type="text" name="Address1" label="Address 1" value="<%=address1 %>" cssClass="input" />
										</div>
										<div class="mb-2">
											<aui:input type="text" name="AHEAUniversity" label="AHEA University" value="<%=address2 %>" cssClass="input" />
										</div>
										
									</div>
									<div class="col-md-6">
										<div class="mb-3">
											<div id="map-canvas" class="w-100 mb-4" style="height:275px;"></div>
										</div>

									</div>
								</div>
								<div class="row row-custom">
									<div class="col-md-6">
										<div class="form-group d-flex">
											<div class="pr-2">
												<aui:input type="text" name="City" label="City" value="<%=locationCity %>" cssClass="input" />
											</div>
											<div class="pr-2">
												<aui:input type="text" name="State" label="State" value="<%=locationState %>" cssClass="input" />
											</div>
											<div>
												<aui:input type="text" name="PostalCode" label="Postal C." value="<%=postalCode %>" cssClass="input" />
											</div>
										</div>
									</div>
									<div class="col-md-6">
										<aui:input type="text" name="Region" label="Region" value="<%=region %>" cssClass="input" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div><!-- END COL -->
			</div>
		</div>
	</div><!-- row -->

	<div class="row row-custom mb-3">
		<div class="col-lg-12">
			<div class=" box box-border-radius box-shadow bg-white">
				<div class="inner-wrap">
					<div class="box-top d-flex justify-content-between">
						<h2 class="box-subhead mw-100"><i class="far fa-user-graduate"></i> Student Body</h2>
					</div>
					<div class="box-middle color-white">
						<div class="row row-custom mb-5">
							<div class="col-md-6"></div>
							<div class="col-md-6">
								<div class="row">
									<div class="col-md-6">
										<div class="mb-2">
											<aui:input type="text" name="Term" label="Term" value="<%=studentTerm %>" cssClass="input" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="mb-2">
											<aui:input type="text" name="Year" label="Year" value="<%=studentYear %>" cssClass="input" />
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="row row-custom mb-5">
							<div class="col-md-6">
								<div class="row">
									<div class="col-md-6">
										<div class="mb-2">
											<aui:input type="text" name="Total" label="Total" value="<%=totalStudents %>" cssClass="input" />
										</div>
										<div class="mb-2">
											<aui:input type="text" name="UndergraduateStudents" label="Undergraduate Students" value="<%=undergradStudents %>" cssClass="input" />
										</div>
										<div class="mb-2">
											<aui:input type="text" name="GraduateStudents" label="Graduate Students" value="<%=gradStudents %>" cssClass="input" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="mb-2">
											<aui:input type="text" name="FemaleStudents" label="Female Students" value="<%=femaleStudents %>" cssClass="input" />
										</div>
										<div class="mb-2">
											<aui:input type="text" name="MaleStudents" label="Male Students" value="<%=maleStudents %>" cssClass="input" />
										</div>
										<div class="mb-2">
											<aui:input type="text" name="OtherStudents" label="Other Students" value="<%=otherStudents %>" cssClass="input" />
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="row">
									<div class="col-md-6">
										<div class="mb-2">
											<aui:input type="text" name="FullTime" label="Full-Time" value="<%=fullTimeStudents %>" cssClass="input" />
										</div>
										<div class="mb-2">
											<aui:input type="text" name="PartTime" label="Part-Time" value="<%=partTimeStudents %>" cssClass="input" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="mb-2">
											<aui:input type="text" name="InState" label="In-State" value="<%=inStateStudents %>" cssClass="input" />
										</div>
										<div class="mb-2">
											<aui:input type="text" name="Outoftate" label="Out of State" value="<%=outOfStateStudents %>" cssClass="input" />
										</div>
										<div class="mb-2">
											<aui:input type="text" name="International" label="International" value="<%=interNationalStudents %>" cssClass="input" />
										</div>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div><!-- row -->

	<div class="row row-custom mb-3">
		<div class="col-lg-12">
			<div class=" box box-border-radius box-shadow bg-white">
				<div class="inner-wrap">
					<div class="box-top d-flex justify-content-between">
						<h2 class="box-subhead mw-100"><span class="icon-regular icon-user-tie"></span> Faculty</h2>
					</div>
					<div class="box-middle color-white">
						<div class="row row-custom mb-5">
							<div class="col-md-6"></div>
							<div class="col-md-6">
								<div class="row">
									<div class="col-md-6">
										<div class="mb-2">
											<aui:input type="text" name="Term" label="Term" value="<%=facultyTerm %>" cssClass="input" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="mb-2">
											<aui:input type="text" name="Year" label="Year" value="<%=facultyYear %>" cssClass="input" />
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="row row-custom mb-5">
							<div class="col-md-6">
								<div class="row">
									<div class="col-md-6">
										<div class="mb-2">
											<aui:input type="text" name="Full-Time Faculty" label="Full-Time Faculty" value="<%=fullTimeFaculty %>" cssClass="input" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="mb-2">
											<aui:input type="text" name="StudentFacultyRatio" label="Student-Faculty Ratio" value="<%=studentFacultyRatio %>" cssClass="input" />
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="row">
									<div class="col-md-6">
										<div class="mb-2">
											<aui:input type="text" name="FacultywitHighestDegreeinField" label="Faculty with Highest Degree in Field" value="<%=facultyHigherDegree %>" cssClass="input" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="mb-2">
											<aui:input type="text" name="AverageUndergraduateClassSize" label="Average Undergraduate Class Size" value="<%=avgUGClassSize %>" cssClass="input" />
										</div>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div><!-- row -->

	<div class="row row-custom mb-3">
		<div class="col-lg-12">
			<div class=" box box-border-radius box-shadow bg-white">
				<div class="inner-wrap">
					<div class="box-top d-flex justify-content-between">
						<h2 class="box-subhead mw-100">
							<span class="icon-book-user icon-regular"></span> Academic
						</h2>
					</div>
					<div class="box-middle color-white">
						<div class="row row-custom mb-5">
							<div class="col-md-6"></div>
							<div class="col-md-6">
								<div class="row">
									<div class="col-md-6">
										<div class="mb-2">
											<aui:input type="text" name="Term" label="Term" value="<%=academicTerm %>" cssClass="input" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="mb-2">
											<aui:input type="text" name="Year" label="Year" value="<%=academicTeYear %>" cssClass="input" />
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="row row-custom">
							<div class="col-md-4 mb-4">
								<div class="box-color border-grey h-100">
									<h4 class="mb-3">Colleges &amp; Schools</h4>
									
									<%
									if(collegeSchoolsArray.length()>0){
										for(int i=0;i<collegeSchoolsArray.length();i++){
											JSONObject collegeSchools = collegeSchoolsArray.getJSONObject(i);
											String collegeSchoolsName =  "collegeSchoolsName"+i;
											%>
											<div class="d-flex align-items-center formGroupmb0 mb-2">
												<a href="javascript::void(0);" class="color-orange font20 mr-1"><i class="fas fa-minus-circle"></i></a>
												<aui:input type="textarea" name="<%=collegeSchoolsName %>" label="" value="<%=collegeSchools.getString("collegeSchoolName") %>" cssClass="input"  rows="2" />
											</div>
											<%
										}
									}
									%>
									<div class="form-group d-flex align-items-center">
										<a href="javascript::void(0);" class="color-orange font20 mr-1"><i class="fas fa-plus-circle"></i></a>
									</div>
								</div>
							</div>
							<div class="col-md-4 mb-4">
								<div class="box-color border-grey h-100">
									<h4 class="mb-3">Degree Programs</h4>
									<div class="mb-2">
										<aui:input type="text" name="Undergraduate" label="Undergraduate" value="<%=underGraduate %>" cssClass="input" />
									</div>
									<div class="mb-2">
										<aui:input type="text" name="Graduate" label="Graduate" value="<%=graduate %>" cssClass="input" />
									</div>
								</div>
							</div>
							<div class="col-md-4 mb-4">
								<div class="box-color border-grey h-100">
									<h4 class="mb-3">Degrees Granted During</h4>
									<div class="mb-2">
										<aui:input type="text" name="AcademicYear" label="Academic Year" value="<%=academicYear %>" cssClass="input" />
									</div>
									<div class="mb-2">
										<aui:input type="text" name="AssociateDegrees" label="Associate Degrees" value="<%=associateDegrees %>" cssClass="input" />
									</div>
									<div class="mb-2">
										<aui:input type="text" name="BachelorDegrees" label="Bachelor's Degrees" value="<%=bachelorsDegrees %>" cssClass="input" />
									</div>
									<div class="mb-2">
										<aui:input type="text" name="MasterDegrees" label="Master's Degrees" value="<%=masterDegrees %>" cssClass="input" />
									</div>
									<div class="mb-2">
										<aui:input type="text" name="DoctorateDegrees" label="Doctorate Degrees" value="<%=doctorateDegrees %>" cssClass="input" />
									</div>
								</div>
							</div>
							<div class="col-md-4 mb-4">
								<div class="box-color border-grey h-100">
									<h4 class="mb-3">Accreditation</h4>
									
									<%
									if(accrediationsArray.length()>0){
										for(int i=0;i<accrediationsArray.length();i++){
											JSONObject accrediations = accrediationsArray.getJSONObject(i);
											String accreditationName =  "acreditation"+i;
											%>
											<div class="d-flex align-items-center formGroupmb0 mb-2">
												<a href="javascript::void(0);" class="color-orange font20 mr-1"><i class="fas fa-minus-circle"></i></a>
												<aui:input type="textarea" name="<%=accreditationName %>" label="" value="<%=accrediations.getString("accrediation") %>" cssClass="input"  rows="2" />
											</div>
											<%
										}
									}
									%>
									
									<div class="form-group d-flex align-items-center">
										<a href="javascript::void(0);" class="color-orange font20 mr-1"><i class="fas fa-plus-circle"></i></a>
									</div>
								</div>
							</div>
							<div class="col-md-4 mb-4">
								<div class="box-color border-grey h-100">
									<h4 class="mb-3">Recognition</h4>
									
									<%
									if(recognitionsArray.length()>0){
										for(int i=0;i<recognitionsArray.length();i++){
											JSONObject recognitions = recognitionsArray.getJSONObject(i);
											String recognitionName =  "recognition"+i;
											%>
											<div class="d-flex align-items-center formGroupmb0 mb-2">
												<a href="javascript::void(0);" class="color-orange font20 mr-1"><i class="fas fa-minus-circle"></i></a>
												<aui:input type="textarea" name="<%=recognitionName %>" label="" value="<%=recognitions.getString("recognition") %>" cssClass="input"  rows="2" />
											</div>
											<%
										}
									}
									%>
									
									<div class="form-group d-flex align-items-center">
										<a href="javascript::void(0);" class="color-orange font20 mr-1"><i class="fas fa-plus-circle"></i></a>
									</div>
								</div>
							</div>
							<div class="col-md-4 mb-4">
								<div class="box-color border-grey h-100">
									<h4 class="mb-3">Degrees Offered</h4>									
									<%
									if(degreesArray.length()>0){
										for(int i=0;i<degreesArray.length();i++){
											JSONObject degrees = degreesArray.getJSONObject(i);
											String degreeName =  "degreesOffered"+i;
											%>
											<div class="d-flex align-items-center formGroupmb0 mb-2">
												<a href="javascript::void(0);" class="color-orange font20 mr-1"><i class="fas fa-minus-circle"></i></a>
												<aui:input type="textarea" name="<%=degreeName %>" label="" value="<%=degrees.getString("degreeName") %>" cssClass="input"  rows="2" />
											</div>
											<%
										}
									}
									%>
									<div class="form-group d-flex align-items-center">
										<a href="javascript::void(0);" class="color-orange font20 mr-1"><i class="fas fa-plus-circle"></i></a>
									</div>
								</div>
							</div>
						</div><!-- row -->

					</div>
				</div>
			</div>
		</div>
	</div><!-- row -->
</section>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDTB30uKJgKRGvIVHavUEPKACPZkqkkifg&sensor=false"></script>					
<script>
var geocoder;
var map;
var address = '<%=address1%>'+','+'<%=address2%>'+','+'<%=cityState %>'+','+'<%=postalCode %>';
function initMap() {
	debugger;
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

$(window).on('load', function() {
	initMap()
});
</script>
