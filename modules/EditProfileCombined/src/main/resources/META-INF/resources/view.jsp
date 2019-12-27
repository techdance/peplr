<%@page import="com.collaborated.entity.service.userProfessionalBioLocalServiceUtil"%>
<%@page import="com.collaborated.entity.model.userProfessionalBio"%>
<%@ include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.collaborated.entity.service.communicationPreferencesLocalServiceUtil"%>
<%@page import="com.collaborated.entity.model.communicationPreferences"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="java.util.List"%>
<%@page import="com.collaborated.entity.service.userCredentialLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page import="com.collaborated.entity.model.userCredential"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>

<portlet:resourceURL var="saveCollaborationInterest" id="saveCollaborationInterest"></portlet:resourceURL>

<!-- Edit Credentials --> 
<% 
long credentialId=0; 
String membership1="",membership2="",membership3="",membership4="",certificate1="",certificate2="",certificate3="";

DynamicQuery dynamicQueryCredential = DynamicQueryFactoryUtil.forClass(userCredential.class, PortalClassLoaderUtil.getClassLoader());
dynamicQueryCredential.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplay.getUserId())));
List<userCredential> creList = userCredentialLocalServiceUtil.dynamicQuery(dynamicQueryCredential);
if(creList.size()>0){
	membership1 = creList.get(0).getMembership1();
	membership2 = creList.get(0).getMembership2();
	membership3 = creList.get(0).getMembership3();
	membership4 = creList.get(0).getMembership4();
	certificate1 = creList.get(0).getCertificate1();
	certificate2 = creList.get(0).getCertificate2();
	certificate3 = creList.get(0).getCertificate3();
	credentialId = creList.get(0).getPK_userCredential();
}
%> 


<!-- Edit Communication Preferences -->
<%
JSONArray listArray = null;
if(null!=request.getAttribute("languageList")){
	listArray = (JSONArray)request.getAttribute("languageList");
}

long primLangId=0,secoLangId=0,terLangId=0,commuId=0,phoneNum=0;
String primLangName="",secLangName="",terLangName="",email="",website="";

DynamicQuery dynamicQueryCommunication = DynamicQueryFactoryUtil.forClass(communicationPreferences.class, PortalClassLoaderUtil.getClassLoader());
dynamicQueryCommunication.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplay.getUserId())));
List<communicationPreferences> comList = communicationPreferencesLocalServiceUtil.dynamicQuery(dynamicQueryCommunication);
if(comList.size()>0){
	primLangId = comList.get(0).getPrimaryLanguageId();
	secoLangId = comList.get(0).getSecondaryLanguageId();
	terLangId = comList.get(0).getTertiaryLanguageId();
	commuId = comList.get(0).getPK_communicationPreferences();
	phoneNum = comList.get(0).getPhoneNumber();
	primLangName = comList.get(0).getPrimaryLanguageName();
	secLangName = comList.get(0).getSecondaryLanguageName();
	terLangName = comList.get(0).getTertiaryLanguageName();
	email = comList.get(0).getEmailAddress();
	website = comList.get(0).getWebsite();
}
%>
<!-- Professional Bio  -->
<%
long professionalBioId = 0;
String areasofexpertise1="",areasofexpertise2="",areasofexpertise3="",experienceLevel="",cvLink="",bioDescription="";
DynamicQuery dynamicQueryProfessionalBio = DynamicQueryFactoryUtil.forClass(userProfessionalBio.class, PortalClassLoaderUtil.getClassLoader());
dynamicQueryProfessionalBio.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplay.getUserId())));
List<userProfessionalBio> bioList = userProfessionalBioLocalServiceUtil.dynamicQuery(dynamicQueryProfessionalBio);
if(bioList.size()>0){
	areasofexpertise1 = bioList.get(0).getAreaofexpertise1();
	areasofexpertise2 = bioList.get(0).getAreaofexpertise2();
	areasofexpertise3 = bioList.get(0).getAreaofexpertise3();
	professionalBioId = bioList.get(0).getPK_userProfessionalBio();
	experienceLevel = bioList.get(0).getExperienceyears();
	cvLink = bioList.get(0).getCvlink();
	bioDescription = bioList.get(0).getBiodescription();
}
%>

<!-- Institution Profile -->

<%
long institutionProfileId=0;

%>

<aui:form name="updateProfileForm" onSubmit="event.preventDefault();">
<div class="d-flex flex-row row row-custom sortable">
	
	<div class="col-lg-12 mb-4 mt-3 text-right">
		<aui:button  value="Save Profile" type="submit" onclick="saveProfile()"  cssClass="btn btn-blue"></aui:button>
	</div>
	<div class="col-lg-6 mb-3">
	<div class="personal box box-border-radius box-shadow bg-white">
	<div class="inner-wrap">
			<div class="box-top position-relative">
				<h2 class="box-subhead"><i class="fas fa-user"></i>Personal Information</h2>
			</div>
			<div class="box-middle">
				<div class="row row-custom">
					<div class="col-md-6">						
						<div class="fileinput fileinput-new" data-provides="fileinput">
					   		<div class="fileinput-preview thumbnail d-flex align-items-center justify-content-center" data-trigger="fileinput">
					   			<img  src="<%=themeDisplay.getUser().getPortraitURL(themeDisplay) %>" id="userImage" class="img-responsive rounded-circle" alt="Responsive image">					      
					          	<div class="upload-file position-absolute">
					          		<input type="file" id="<portlet:namespace/>file" name='<portlet:namespace/>file' accept="image/*" /> 
					          	</div>
					         	<span class="upload-text d-flex flex-column text-center position-absolute">
					         		<i class="fa fa-camera"></i>
					         		Change Photo
					         	</span>
							</div>
														
							<a href="#" class="fileinput-exists" data-dismiss="fileinput" onclick="removeProfileImage()"><i class="fa fa-close"></i></a>
					 	</div>
					</div>
					<div class="col-md-6">
						<aui:select name="prefixValue" label="Prefix" placeholder="" required="true" cssClass="wrap-input">
							<aui:option class="" value=""></aui:option> 
							<aui:option class="" value="dr"> Dr </aui:option>
							<aui:option class="" value="miss"> Miss </aui:option>
							<aui:option class="" value="mr"> Mr </aui:option>
							<aui:option class="" value="ms"> Ms </aui:option> 
							<aui:option class="" value="mrs"> Mrs </aui:option>
							<aui:option class="" value="mx"> Mx </aui:option>
						</aui:select>
						
						<aui:input type="text" name="firstName" id="firstName" label="First Name" placeholder="" cssClass="wrap-input">
							<aui:validator name="required" />
							<aui:validator errorMessage="Please enter valid first name" name="custom" >
							function(val, fieldNode, ruleValue) {                         
								var result = true;
								var fileName=$('#<portlet:namespace/>firstName').val(); 
								if(fileName!=''){
									var tt = /^[a-zA-Z ]*$/.test(fileName);
									if(tt==false){
										result = false;
									}else{
										result = true;
									}
								}
								return result;
							}
							</aui:validator> 
						</aui:input>
						
						<aui:input name="lastName" id="lastName" label="Last Name" placeholder="" cssClass="wrap-input">
							<aui:validator name="required" />
						    <aui:validator errorMessage="Please enter valid last name" name="custom">
						   	function(val, fieldNode, ruleValue) {                         
								var result = true;
								var fileName=$('#<portlet:namespace/>lastName').val(); 
								if(fileName!=''){
									var tt = /^[a-zA-Z ]*$/.test(fileName);
									if(tt==false){
										result = false;
									}else{
										result = true;
									}
								}
								return result;
							}
						    </aui:validator>
						</aui:input>
						
						<aui:input name="jobTitle" id="jobTitle" label="Position" placeholder="" cssClass="wrap-input">
							<aui:validator name="required" />
						</aui:input>
					</div>
				</div>
			</div>
			<div class="wrap-input-icon wrap-input profile-status">
				<liferay-ui:custom-attribute
			        className="<%= User.class.getName() %>"
			        classPK="<%= 0 %>"
			        editable="<%= true %>"
			        label="<%= true %>"
			        name="status"
			    /> 
			</div>	
			
			<div class="wrap-input-icon wrap-input online-status">
				<liferay-ui:custom-attribute
			        className="<%= User.class.getName() %>"
			        classPK="<%= 0 %>"
			        editable="<%= true %>"
			        label="<%= true %>"
			        name="onlineStatus"
			    /> 
			</div>		
	</div>
</div>
	</div>
	<div class="col-lg-6 mb-3">
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
	                                                	<aui:input type="hidden" name="institutionProfileId" label="" value="<%=institutionProfileId %>" cssClass="input" />
	                                               		<aui:input type="text" name="institutionName" label="Institution" value="" cssClass="input" />
	                                               		<aui:input type="text" name="academCalendar" label="Academic Calendar" value="" cssClass="input" />
	                                               		<aui:input type="textarea" name="departamentDescription" label="Department" value="" cssClass="input" style="min-height: 120px;" />
	                                                </div>
	                                            </div>
											</div>
											<!-- <div class="box-bottom">
                                                
                                                <div id="file-nameapnd" class="list-group list-group-flush"></div>
                                             
                                           
                                           
                                            <div id="document-file-upload" class="browse-file pt-1 mb-3 position-relative label-fixed ">
	                                            <div class="browse-file position-relative marbot15">
													<div class="btn btn-blue btn-w-100 btn2 position-relative research-uploadbtn">
															<i class="fa fa-cloud-upload" aria-hidden="true"></i> Upload Research Paper PDF
															<aui:input type="file" name="uploadedDocument" onclick="clearFile()"  label="" cssClass="inputfile inputfile-6 w-100 input-border-bottom ">
															<aui:validator  name="custom"  errorMessage="Please Upload jpeg,jpg,png,pdf,doc,docx" > 
																function (val, fieldNode, ruleValue) {
																	var result = false;
																	console.log(val);
																	if(val!=null && val!="" &&val.length>0){
																	var fileName=$('#<portlet:namespace/>uploadedDocument')[0].files[0].name;
																	console.log("fileName"+fileName);
																	var ext = $('#<portlet:namespace/>uploadedDocument').val().split('.').pop().toLowerCase();
																	console.log("ext"+ext);
																		if($.inArray(ext, ['jpg','jpeg','png','pdf','doc','docx']) != -1) {
																			result=true;
																		}
																	}
																return result;
																}
															</aui:validator> 
														</aui:input>
													</div>
													<div class="input-files d-flex flex-row align-items-center mt-1">
														<div class="input-values"></div>
														
													</div>
												</div>
                                            	
												
                                            </div>
                                        </div> -->
                                    </div></div>
	</div>
	<div class="col-lg-6 mb-3">
	<div class="credentials box box-border-radius box-shadow bg-white">
	<div class="inner-wrap">
	<div class="box-top position-relative">
	    <h2 class="box-subhead mw-100"><i class="fas fa-user"></i>Communication Preferences</h2>
	</div>
		<aui:input name="communicationId" placeholder="" value="<%=commuId %>" type="hidden" cssClass="w-100 input-border-bottom"></aui:input>
		<aui:input name="primaryLanguageName" placeholder="" value="<%=primLangName %>" type="hidden" cssClass="w-100 input-border-bottom"></aui:input>
		<aui:input name="secondaryLanguageName" placeholder="" value="<%=secLangName %>" type="hidden" cssClass="w-100 input-border-bottom"></aui:input>
		<aui:input name="tertiaryLanguageName" placeholder="" value="<%=terLangName %>" type="hidden" cssClass="w-100 input-border-bottom"></aui:input> 
		<div class="box-middle">
	       	<h4 class="mb-3">Languages</h4>
	        <div class="row row-custom">
				<div class="col-md-6">
					<div class="form-group">
						<aui:select name="primaryLanguage" label="Primary Language" placeholder="" cssClass="wrap-input">
							<aui:option class="" value="">  </aui:option>
							<% if(listArray!=null && listArray.length()>0){
								for(int l=0;l<listArray.length();l++){
									 JSONObject jsonobj=listArray.getJSONObject(l);	
								 %>
								<option value="<%=jsonobj.getLong("languageId") %>" <%=(jsonobj.getLong("languageId")==primLangId)?"selected":"" %>> <%=jsonobj.getString("languageName") %> </option> 
							<% } } %> 
					    </aui:select>
					</div>
					<div class="form-group">
						<aui:select name="secondaryLanguage" label="Secondary Language" placeholder="" cssClass="wrap-input">
							<aui:option class="" value="">  </aui:option>
							<% if(listArray!=null && listArray.length()>0){
								for(int l=0;l<listArray.length();l++){
									 JSONObject jsonobj=listArray.getJSONObject(l);	
								 %>
								<option value="<%=jsonobj.getLong("languageId") %>" <%=(jsonobj.getLong("languageId")==secoLangId)?"selected":"" %>> <%=jsonobj.getString("languageName") %> </option> 
							<% } } %>
					    </aui:select>
					</div>
					<div class="form-group">
						<aui:select name="tertiaryLanguage" label="Tertiary Language" placeholder="" cssClass="wrap-input">
							<aui:option class="" value="">  </aui:option>
							<% if(listArray!=null && listArray.length()>0){
								for(int l=0;l<listArray.length();l++){
									 JSONObject jsonobj=listArray.getJSONObject(l);	
								 %>
								<option value="<%=jsonobj.getLong("languageId") %>" <%=(jsonobj.getLong("languageId")==terLangId)?"selected":"" %>> <%=jsonobj.getString("languageName") %> </option> 
							<% } } %> 							
					    </aui:select>
					</div> 
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<aui:input name="communicationEmail" required='true' label="Email" placeholder="Please enter email address" value= "<%=email %>" cssClass="w-100 input-border-bottom">							
						</aui:input>
					</div>
					<div class="form-group">
						<aui:input name="communicationPhoneNumber" required='true' label="Phone Number" placeholder="Please enter phone number" value="<%=phoneNum %>" cssClass="w-100 input-border-bottom">							
							<aui:validator name="maxLength">10</aui:validator>
						</aui:input>
					</div>
					<div class="form-group">
						<aui:input name="communicationWebsite" required='true' label="Website" placeholder="" value="<%=website %>" cssClass="w-100 input-border-bottom">
						</aui:input>
					</div> 
				</div>
			</div>
		</div>
</div>
</div>
	</div>
	<div class="col-lg-6 mb-3">
		<div class="credentials box box-border-radius box-shadow bg-white">
    <div class="inner-wrap">
        <div class="box-top position-relative">
            <h2 class="box-subhead"><i class="fas fa-user"></i>Credentials</h2>
        </div>
        	<aui:input name="credentialId" placeholder="" value="<%=credentialId %>" type="hidden" cssClass="w-100 input-border-bottom"></aui:input>
	        <div class="box-middle">
	            <div class="row row-custom">
	            	<div class="col-md-6">
		             	<h4 class="mb-3">Professional Memberships</h4>
		             	<aui:input type="text" name="membership1" label="Membership &ndash; 1" value="<%=membership1 %>" cssClass="input" />
		             	<aui:input type="text" name="membership2" label="Membership &ndash; 2" value="<%=membership2 %>" cssClass="input" />
		             	<aui:input type="text" name="membership3" label="Membership &ndash; 3" value="<%=membership3 %>" cssClass="input" />
		             	<aui:input type="text" name="membership4" label="Highest Education Level" value="<%=membership4 %>" cssClass="input" /> 
		             </div>
		             <div class="col-md-6">
		             	<h4 class="mb-3">Certificates
		             		<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
		             	</h4>
		                <aui:input type="text" name="certificate1" label="Certificate" value="<%=certificate1 %>" cssClass="input" />
		             	<aui:input type="text" name="certificate2" label="Certificate" value="<%=certificate2 %>" cssClass="input" />
		             	<aui:input type="text" name="certificate3" label="Certificate" value="<%=certificate3 %>" cssClass="input" /> 
		             </div>
	        	</div>
	        </div>
    </div>
</div>
	</div>
	<div class="col-lg-6 mb-3">
	<div class="profesional box box-border-radius box-shadow bg-white">
                         <div class="inner-wrap">
                             <div class="box-top position-relative">
                                 <h2 class="box-subhead"><i class="fas fa-user"></i>Professional Bio</h2>
                             </div>
                             <div class="box-middle">
                                 <div class="row row-custom">
                                  <div class="col-md-6">
                                  	<h4 class="mb-3">Areas Of Expertise</h4>
                                  	<aui:input name="professionalBioId" placeholder="" value="<%=professionalBioId %>" type="hidden" cssClass="w-100 input-border-bottom"></aui:input>
                                  	<aui:input type="text" name="areasofexpertise1" label="Areas of Expertise &ndash; 1" value="<%=areasofexpertise1 %>" cssClass="input" />
                                  	<aui:input type="text" name="areasofexpertise2" label="Areas of Expertise &ndash; 2" value="<%=areasofexpertise2 %>" cssClass="input" />
                                  	<aui:input type="text" name="areasofexpertise3" label="Areas of Expertise &ndash; 3" value="<%=areasofexpertise3 %>" cssClass="input" />
                                      
                                      <div class="form-group">
										<label class="position-relative">
											International Experience
											<i class="fa fa-info-circle icon-info" aria-hidden="true">
													<span class="info-toltip">Please select the range that most accurately matches your international skills, experience, and studies.</span>
												</i>
										</label>
										<div class="wrap-range-label">
											<ul>
												<li>1 &ndash; 2 Years</li>
												<li>3 &ndash; 7 Years</li>
												<li>7+ Years</li>
											</ul>
										</div>
										<div class="wrap-range">
										 	<input type="range" name="experienceLevelUI" min="1" max="10" value="<%=experienceLevel %>" onchange="updateTextInput(this.value);"> 
										 	<aui:input name="experienceLevel" type="hidden" value="<%=experienceLevel %>" ></aui:input> 
										</div>

                                      </div>
                                  </div>
                                  <div class="col-md-6 d-flex flex-column justify-content-end">
                                  	<aui:input type="url" name="cvLink" label="Link Your CV" value="<%=cvLink %>" cssClass="input" />
                                  </div>
                              </div>
                              <div class="row row-custom">
                              	<div class="col-md-12">
                              		<aui:input type="textarea" name="bioDescription" label="Bio"  cssClass="input" style="min-height: 100px; height: auto;" 
                  		value="<%=bioDescription %>"  />
                  	</div>
                  </div>
                 </div>
             </div>
         </div>
	</div>
	<div class="col-lg-6 mb-3">
	<div class="collaboration box box-border-radius box-shadow bg-white">
	<div class="inner-wrap">
		<div class="box-top position-relative">
			<h2 class="box-subhead">
				<i class="fas fa-user"></i>Collaboration Interests
			</h2>
		</div>
		<div class="box-middle">
			<div class="row row-custom">
				<div class="col-md-12">
					<h4 class="mb-3">Areas of Interest</h4>
					
					<div class="clearfix">
					<div id="area-of-interest-block" class="row row-custom "></div>
					
					<div id="view-more-interest-modal"	class="box-border-radius box-shadow modal-dialog viewmoredetail">
						<div class=" position-relative modal-content">
							<div class="toltip-close2">
								<a href="javascript:void(0);"  data-dismiss="modal"><i class="fa fa-times-circle"></i></a>
							</div>
							<div class="view-more-interest-modal-inner-content text-left">
								<div class="row mb-2">
									<div class="col-md-6">
										<strong>Project</strong><br><span class="view-project-type"></span>
									</div>
								</div>
								<div class="row  mb-2">
									<div class="col-md-6">
										<strong>Discipline</strong><br><span class="view-discipline"></span>
									</div>
									<div class="col-md-6 delivery-method">
										<strong>Delivery Method</strong><br><span class="view-delivery-type"></span>
									</div>
								</div>
								<div class="row mb-2">
									<div class="col-md-12"><span class="view-description"></div>
								</div>
								<div class="row mb-2">
									<div class="col-md-4">
										<strong>Collaboration Type</strong><br><span class="view-campus"></span>
									</div>
									<div class="col-md-4">
										<strong>Program Level</strong><br><span class="view-program-level"></span>
									</div>
									<div class="col-md-4">
										<strong>Program Length</strong><br><span class="view-program-length"></span>
									</div>
								</div>
								<div class="row mb-2">
									<div class="col-md-4">
										<strong>Credits</strong><br><span class="view-credits"></span>
									</div>
									<div class="col-md-4">
										<strong>Preferred Language</strong><br><span class="view-language"></span>
									</div>
									<div class="col-md-4">
										<strong>Preferred Location</strong><br><span class="view-location"></span>
									</div>
								</div>
								<div class="row mb-2">
									<div class="col-md-12">
										<strong>Project Date Range</strong>
										<div class="top-label-range">
											<div class="year-init-range">Today 2020</div>
											<div class="year-last-range">2021</div>
										</div>
										<div class="wrap-range">
											<input type="range">
										</div>
										<div class="wrap-range-label width-inherit">
											<ul class="d-flex">
												<li>Jan</li>
												<li>Feb</li>
												<li>Mar</li>
												<li>May</li>
												<li>Jun</li>
												<li>Jul</li>
												<li>Aug</li>
												<li>Sep</li>
												<li>Oct</li>
												<li>Nov</li>
												<li>Dec</li>
												<li>Jan</li>
												<li>Feb</li>
											</ul>
										</div>
									</div>
									<div class="col-md-12 ac mt-3 text-center">
										<strong>Create: 12-20-2019 11:34 PM</strong>
									</div>
								</div>
								<div class="row text-center pt-2 view-find-matches">
									
								</div>
							</div>
						</div>
					</div>
				</div>
					
					
					
					
					<div class="mb-2">
						<a href="javascript:void(0);" class="btn btn-blue btn-w-100 cursor-pointer"
							id="add-interest">Add An Interest</a>
					</div>
					<div id="add-interest-modal" class="color-black font14 modal fade">
						<aui:input  name="addInterestId" value="0" type="hidden"></aui:input>
						<aui:input  name="addInterestButton" value="" type="hidden"></aui:input>
						<div class=" modal-dialog viewmoredetail  view-more-interest-modal-inner position-relative ">
							<div class="modal-content">
								<div class="toltip-close2">
									<a href="javascript:void(0);" data-dismiss="modal"><i class="fa fa-times-circle"></i></a>
								</div>
								<div class="row mb-2">
									<div class="col-md-12">
										<aui:select name="projectType" label="What type of project you are interested in?" cssClass="wrap-input input select" required="true" onChange="getProjectTypeStatus(this.value)">
											<aui:option value="">Select a Project</aui:option>
											<aui:option value="Academic Journal">Academic Journal</aui:option>
											<aui:option value="Best Practices">Best Practices</aui:option>
											<aui:option value="Course Development">Course Development</aui:option>
											<aui:option value="Curriculum Development">Curriculum Development</aui:option>
											<aui:option value="General Publication">General Publication</aui:option>
											<aui:option value="Mentorship">Mentorship</aui:option>
											<aui:option value="Peer Review">Peer Review</aui:option>
											<aui:option value="Research">Research</aui:option>
											<aui:option value="Study Abroad">Study Abroad</aui:option>
											<aui:option value="Other">Other</aui:option>
										</aui:select>
										<aui:input type="textarea" name="projectDescription" label="Description:" value="" cssClass="wrap-input input textarea" style="height: 55px;" required="true"/>
									</div>
								</div>
								<div class="row  mb-2">
									<div class="col-md-6 input-multiselect">
										<aui:select name="discipline" label="Discipline:" cssClass="wrap-input input select mb-0" required="true">
											<aui:option value="Anthropology">Anthropology </aui:option>
											<aui:option value="Archaeology">Archaeology </aui:option>
											<aui:option value="Arts">Arts </aui:option>
											<aui:option value="Biology">Biology </aui:option>
											<aui:option value="Business">Business </aui:option>
											<aui:option value="Chemistry">Chemistry </aui:option>
											<aui:option value="Computer Science">Computer Science </aui:option>
											<aui:option value="Earth Science">Earth Science </aui:option>
											<aui:option value="Economics">Economics </aui:option>
											<aui:option value="Engineering">Engineering </aui:option>
											<aui:option value="History">History </aui:option>
											<aui:option value="Human Geography">Human Geography </aui:option>
											<aui:option value="Languages">Languages </aui:option>
											<aui:option value="Law">Law </aui:option>
											<aui:option value="Literature">Literature </aui:option>
											<aui:option value="Mathematics">Mathematics </aui:option>
											<aui:option value="Medicine and Health">Medicine and Health </aui:option>
											<aui:option value="Philosophy">Philosophy </aui:option>
											<aui:option value="Physics">Physics </aui:option>
											<aui:option value="Political Science">Political Science </aui:option>
											<aui:option value="Psychology">Psychology </aui:option>
											<aui:option value="Sociology">Sociology </aui:option>
											<aui:option value="Space Sciences">Space Sciences </aui:option>
											<aui:option value="Statistics">Statistics </aui:option>
											<aui:option value="Theology">Theology </aui:option>
										</aui:select>
										<span class="font-style-italic font11">Hold shift for multi-select</span>
									</div>
									<div class="col-md-6">
										<aui:select name="preferredLanguage" label="Preferred Language" cssClass="wrap-input input select" required="true">
											<aui:option value=""></aui:option>
											<aui:option value="Arabic">Arabic </aui:option>
											<aui:option value="Bengali">Bengali </aui:option>
											<aui:option value="English">English </aui:option>
											<aui:option value="French">French </aui:option>
											<aui:option value="Hindi">Hindi </aui:option>
											<aui:option value="Japanese">Japanese </aui:option>
											<aui:option value="Mandarin">Mandarin </aui:option>
											<aui:option value="Norwegian">Norwegian </aui:option>
											<aui:option value="Punjabi">Punjabi </aui:option>
											<aui:option value="Russian">Russian </aui:option>
											<aui:option value="Spanish">Spanish</aui:option>
										</aui:select>
									</div>
								</div>
								<div class="row  mb-2">
									<div class="col-md-6">
										<aui:select name="location" label="Region:" cssClass="wrap-input input select" required="true">
											<aui:option value=""></aui:option>
											<aui:option value="All">All</aui:option>
											<aui:option value="Africa">Africa </aui:option>
											<aui:option value="Asia">Asia </aui:option>
											<aui:option value="Central America">Central America </aui:option>
											<aui:option value="Europe">Europe </aui:option>
											<aui:option value="Middle East">Middle East </aui:option>
											<aui:option value="North America">North America </aui:option>
											<aui:option value="Oceania">Oceania </aui:option>
											<aui:option value="South America">South America </aui:option>
											<aui:option value="The Caribbean">The Caribbean </aui:option>
										</aui:select>
									</div>
									<div class="col-md-6">
										<aui:field-wrapper cssClass="d-flex flex-column radio-button-container">
											<aui:input name="intracampus" type="radio" value="1" label="Intracampus" checked="true"/>
											<aui:input name="intracampus" type="radio" value="2" label="Intercampus" />
										</aui:field-wrapper>
									</div>
								</div>
								<div id="courseDevelopmentPopup" >
									<div class="row mb-2">
										<div class="col-md-6">
											<aui:select name="programLevel" label="Program Level:" cssClass="wrap-input input select">													
												<aui:option value="Certificate">Certificate</aui:option>
												<aui:option value="Associates">Associates </aui:option>
												<aui:option value="Undergraduate">Undergraduate </aui:option>
												<aui:option value="Graduate">Graduate </aui:option>
												<aui:option value="Masters">Masters </aui:option>
												<aui:option value="Doctoral">Doctoral </aui:option>												
											</aui:select>
										</div>
										<div class="col-md-6 programLength">
											<aui:select name="programLength" label="Program Length:" cssClass="wrap-input input select">
												<aui:option value="Ongoing">Ongoing</aui:option>
												<aui:option value="Quarter">Quarter </aui:option>
												<aui:option value="Semester">Semester </aui:option>
												<aui:option value="Summer">Summer </aui:option>
												<aui:option value="Trimester">Trimester </aui:option>										
											</aui:select>
										</div>
									</div>
									<div class="row mb-2">
										<div class="col-md-6">
											<aui:select name="deliveryMethod" label="Delivery Method:" cssClass="wrap-input input select">
												<aui:option value="Online">Online</aui:option>	
												<aui:option value="Offline">Offline</aui:option>																						
											</aui:select>
											<aui:input type="text" name="credits" label="Credits" placeholder="" cssClass="wrap-input"></aui:input>
										</div>	
									</div>								
								</div>

								<div class="row text-center pt-2 justify-content-center">
									<aui:button value="Save" type="button"  cssClass="btn btn-blue btn-w-100 m-auto" onclick="saveProfile('AddInterest')"></aui:button>
								</div> 
							</div>
						</div>
					</div>
					<p>
						<a href="#">Learn More</a><i class="fa fa-info-circle icon-info"
							aria-hidden="true"> <span class="info-toltip">Click	"Learn More" to learn about CollaboratED Projects in our Resources section.</span>
						</i>
					</p>
				</div>
				<!-- <div class="col-md-6">
					
				<h4 class="mb-3">Introduction Video</h4>
				
					<div
						class="embed-responsive embed-responsive-16by9 wrap-video img-resp mb-2">
						<iframe class="embed-responsive-item"
							src="https://www.youtube.com/embed/ScMzIvxBSi4" frameborder="0"
							allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
							allowfullscreen></iframe>
					</div>
					<aui:input type="text" name="video" label=""
						placeholder="https://www.youtube/video/wztesglsv1"
						cssClass="wrap-input input" />
					<p>
						<a href="#" class="btn btn-blue btn-w-100">Upload Video</a>
					</p>
				</div> -->
			</div>
		</div>
	</div>
</div>
</div>
	<div class="col-lg-12 mb-4 mt-3 text-right">
		<aui:button  value="Save Profile" type="submit" onclick="saveProfile()" cssClass="btn btn-blue"></aui:button>
	</div>
	
</div>


</aui:form>

<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDTB30uKJgKRGvIVHavUEPKACPZkqkkifg&sensor=false"></script>

<script>
var A= AUI();
$( document ).ready(function() {
	initMap();
	loadUserInfo();
	$("#<portlet:namespace/>file").change(function() {
		readURL(this);
	});
	loadUserCredential();
	<%-- if(<%=creList.size() %>!=0){ 
		$("#<portlet:namespace/>credentialSubmit").html("Update");
	}
	if(<%=comList.size() %>!=0){
		$("#<portlet:namespace/>communicationSubmit").html("Update");
	} --%>
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


//Edit Collaboration Interests
function getProjectTypeStatus(value){
	$("#courseDevelopmentPopup").hide();
	$(".programLength").hide();
	if(value=="Course Development"){
		$("#courseDevelopmentPopup").show();
		$(".programLength").show();
	} else if (value=="Curriculum Development"){
		$("#courseDevelopmentPopup").show();
		$(".programLength").hide();
	}
}

//Edit Profile Personal Information

$(window).on('load', function() {
	$(".profile-status").find("textarea").css({"width":"100%","height":"0px"});
	$(".profile-status").find("span.control-label").text("Status");
	$(".online-status").find("span.control-label").text("Online Status");
});

function readURL(input) {
  debugger;
  if (input.files && input.files[0]) {
    var reader = new FileReader();
    reader.onload = function(e) {
      $('#userImage').attr('src', e.target.result);
    }	    
    reader.readAsDataURL(input.files[0]);
  }
}

jQuery(function($) {
	$('#<portlet:namespace />documents').change(function() {
	   if ($(this).val()) {
	   error = false;
	      var filename = $(this).val();
	filename = this.value.replace(/\\/g, '/').replace(/.*\//, '');
	$(this).closest('.browse-file').find('.input-values').html(filename);
	     if (error) {
	       parent.addClass('error').prepend.after('<div class="alert alert-error">' + error + '</div>');
	     }
	   }
	 });

	});

</script>