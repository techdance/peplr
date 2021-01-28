

<%@page import="javax.portlet.PortletSession"%>
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

long primLangId=0,secoLangId=0,terLangId=0,commuId=0;
String primLangName="",secLangName="",terLangName="",email="",website="",phoneNum="",mobileNum="";

DynamicQuery dynamicQueryCommunication = DynamicQueryFactoryUtil.forClass(communicationPreferences.class, PortalClassLoaderUtil.getClassLoader());
dynamicQueryCommunication.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplay.getUserId())));
List<communicationPreferences> comList = communicationPreferencesLocalServiceUtil.dynamicQuery(dynamicQueryCommunication);
if(comList.size()>0){
	primLangId = comList.get(0).getPrimaryLanguageId();
	secoLangId = comList.get(0).getSecondaryLanguageId();
	terLangId = comList.get(0).getTertiaryLanguageId();
	commuId = comList.get(0).getPK_communicationPreferences();
	//phoneNum = comList.get(0).getPhoneNumber().substring(1);	
	phoneNum = comList.get(0).getPhoneNumber();
	primLangName = comList.get(0).getPrimaryLanguageName();
	secLangName = comList.get(0).getSecondaryLanguageName();
	terLangName = comList.get(0).getTertiaryLanguageName();
	email = comList.get(0).getEmailAddress();
	website = comList.get(0).getWebsite();
	mobileNum = comList.get(0).getMobileNumber();
	if(!(mobileNum.equalsIgnoreCase("")) && mobileNum.contains("-")){
		mobileNum = mobileNum.replace("-", "");
	}
	if(!(phoneNum.equalsIgnoreCase("")) && phoneNum.contains("-")){
		phoneNum = phoneNum.replace("-", "");
	}
}
%>
<!-- Professional Bio  -->
<%
long professionalBioId = 0;
String areasofexpertise1="",areasofexpertise2="",areasofexpertise3="",experienceLevel="",cvLink="",bioDescription="",bioDiscipline="";
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
	bioDiscipline = bioList.get(0).getBioDiscipline();
}
%>

<!-- Institution Profile -->


<aui:form name="updateProfileForm" onSubmit="event.preventDefault();" enctype='multipart/form-data'>

<nav aria-label="breadcrumb">
	<ol class="breadcrumb">
	  <li class="breadcrumb-item"><a href="/home1">Home</a></li>
	  <li class="breadcrumb-item"><a href="/profile">Profile</a></li>
	  <li class="breadcrumb-item active" aria-current="page">Edit Profile</li>
	</ol>
</nav>

<div class="d-flex flex-row row row-custom">
	
	<!-- <div class="col-lg-12 mb-4 mt-3 text-right">
		<aui:button  value="Save Profile" type="submit" onclick="saveProfile()"  cssClass="btn btn-blue"></aui:button>
	</div> -->
	<div class="col-lg-6 mb-3">
	<div class="personal box box-border-radius box-shadow bg-white position-relative">
	<!-- Loader -->
	<div id="editPersonalInformationLoader" class="sectionloader"> 
		<div class="loader"></div>
	</div>
	<div class="inner-wrap">
			<div class="box-top position-relative">
				<h2 class="box-subhead"><span class="icon-regular icon-user-circle"></span>Personal Information</h2>
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
														
							<a href="javascript:void(0);" class="fileinput-exists" data-dismiss="fileinput" onclick="removeProfileImage()"><i class="fa fa-close"></i></a>
					 	</div>
					</div>
					<div class="col-md-6">
						<aui:select name="prefixValue" label="Prefix" placeholder="" cssClass="wrap-input" disabled="true">
							<aui:option class="" value=""></aui:option> 
							<aui:option class="" value="dr"> Dr </aui:option>
							<aui:option class="" value="miss"> Miss </aui:option>
							<aui:option class="" value="mr"> Mr </aui:option>
							<aui:option class="" value="ms"> Ms </aui:option> 
							<aui:option class="" value="mrs"> Mrs </aui:option>
							<aui:option class="" value="mx"> Mx </aui:option>
						</aui:select>
						
						<aui:input type="text" name="firstName" id="firstName" label="First Name" placeholder="" cssClass="wrap-input" disabled="true">							
						</aui:input>
						
						
						<aui:input name="lastName" id="lastName" label="Last Name" placeholder="" cssClass="wrap-input" disabled="true">							
						</aui:input>
						
						<aui:input name="jobTitle" id="jobTitle" label="Position" placeholder="" cssClass="wrap-input" disabled="true">
						</aui:input>
						<aui:input name="userDepartment" id="userDep" label="Department" placeholder="" cssClass="wrap-input" disabled="true">							
						</aui:input>
					</div>
				</div>
			</div>
			<div class="wrap-input-icon wrap-input profile-status checkde">
				
				<liferay-ui:custom-attribute
			        className="<%= User.class.getName() %>"
			        classPK="<%= 0 %>"
			        editable="<%= true %>"
			        label="<%= true %>"
			        name="status"
			    /> 
			</div>	
			
			<div class="wrap-input-icon wrap-input online-status d-flex align-items-center checked">
				<label class="control-label mr-3 font-weight-bold">Online Status</label>
				<liferay-ui:custom-attribute
			        className="<%= User.class.getName() %>"
			        classPK="<%= 0 %>"
			        editable="<%= true %>"
			        label="<%= false %>"
			        name="onlineStatus"
			    /> 
			</div>		
	</div>
</div>
	</div>
	<div class="col-lg-6 mb-3">
		<div class="comunication box box-border-radius box-shadow bg-white position-relative">
			<!-- Loader -->
			<div id="editInstitutionalProfileLoader" class="sectionloader"> 
				<div class="loader"></div>
			</div>
                                        <div class="inner-wrap position-relative">
											<div class="box-top position-relative">
                                                <h2 class="box-subhead"><span class="icon-regular icon-hospital-user"></span> Institution Profile</h2>
											</div>
											<div id="profile-map">
												<div id="map"></div>
											</div>
											<div class="box-middle">
												<div class="row row-custom">
	                                                <div class="col-md-6">
	                                                	<aui:input type="hidden" name="institutionProfileId" label="" value="<%=institutionProfileId %>" cssClass="input" />
	                                               		<aui:input type="text" name="institutionName" label="Institution Name" value="<%=instituteName %>" cssClass="input" disabled="true"/>
	                                               		<aui:input type="text" name="academCalendar" label="Academic Calendar" value="<%=academicCalendar %>" cssClass="input" disabled="true"/>
	                                               		<%-- <aui:input type="textarea" name="departamentDescription" label="Department" value="<%=department %>" cssClass="input" style="min-height: 120px;" disabled="true"/> --%>
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
	<div class="credentials box box-border-radius box-shadow bg-white position-relative comm-pref">
	<!-- Loader -->
	<div id="editCommunicationPreferencesLoader" class="sectionloader"> 
		<div class="loader"></div>
	</div>
	<div class="inner-wrap">
	<div class="box-top position-relative">
	    <h2 class="box-subhead mw-100"><span class="icon-regular icon-comment-dots"></span>Communication Preferences</h2>
	</div>
		<aui:input name="communicationId" placeholder="" value="<%=commuId %>" type="hidden" cssClass="w-100 input-border-bottom"></aui:input>
		<aui:input name="primaryLanguageName" placeholder="" value="<%=primLangName %>" type="hidden" cssClass="w-100 input-border-bottom"></aui:input>
		<aui:input name="secondaryLanguageName" placeholder="" value="<%=secLangName %>" type="hidden" cssClass="w-100 input-border-bottom"></aui:input>
		<aui:input name="tertiaryLanguageName" placeholder="" value="<%=terLangName %>" type="hidden" cssClass="w-100 input-border-bottom"></aui:input> 
		<div class="box-middle">
	        <div class="row row-custom">
	        	
				<!-- <div class="col-md-6">
					<div class="form-group">
						<aui:select name="primaryLanguage" label="Languages" placeholder="" cssClass="wrap-input labelOnly">
							<aui:option class="" value="">  </aui:option>
					    </aui:select> 
					</div>
				</div>-->
				<div class="col-md-6">
					<h4 class="mb-3">Languages</h4>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<aui:input name="communicationEmail" required='true' label="Email" placeholder="Please enter email address" value= "<%=email %>" cssClass="w-100 input-border-bottom">							
						</aui:input>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<aui:select name="primaryLanguage" required='true' label="Primary Language" placeholder="" cssClass="wrap-input">
							<aui:option class="" value="">  </aui:option>
							<% if(listArray!=null && listArray.length()>0){
								for(int l=0;l<listArray.length();l++){
									 JSONObject jsonobj=listArray.getJSONObject(l);	
								 %>
								<option value="<%=jsonobj.getLong("languageId") %>" <%=(jsonobj.getLong("languageId")==primLangId)?"selected":"" %>> <%=jsonobj.getString("languageName") %> </option> 
							<% } } %> 
					    </aui:select>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<aui:input name="communicationPhoneNumber" required='true' label="Office" placeholder="Please enter phone number" value="<%=phoneNum %>" cssClass="w-100 input-border-bottom">							
							<aui:validator name="maxLength">15</aui:validator>
							<aui:validator name="myValidator" errorMessage="numbers-not-allowed">
						        function(val, fieldNode, ruleValue){ 
						        	var pattern=/^(?=.*?[1-9])[0-9()-]+$/;
						            var matches = pattern.test(val);
						            if(matches != null)
						                return false;
						            else
						                return true;
						       }
						    </aui:validator>
						</aui:input>
					</div>
				</div>
				<div class="col-md-6">
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
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<aui:input name="communicationMobileNumber" required='true' label="Mobile" placeholder="Please enter phone number" value="<%=mobileNum %>" cssClass="w-100 input-border-bottom">							
							<aui:validator name="maxLength">15</aui:validator>
							<aui:validator name="myValidator" errorMessage="numbers-not-allowed">
						        function(val, fieldNode, ruleValue){ 
						        	var pattern=/^(?=.*?[1-9])[0-9()-]+$/;
						            var matches = pattern.test(val);
						            if(matches != null)
						                return false;
						            else
						                return true;
						       }
						    </aui:validator>
						</aui:input>
					</div>
				</div>
				<div class="col-md-6">
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
				<div class="col-md-6 position-relative d-flex align-items-center">
					<aui:input name="check" label="Receive SMS Notifications" type="checkbox" value="SMSNotifications"></aui:input>
					<i class="fa fa-info-circle icon-info cl-blue" aria-hidden="true">
						<span class="info-toltip">Standard messaging rates may apply.</span>
					</i>
				</div>
				<div class="col-md-12">
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
		<div class="credentials box box-border-radius box-shadow bg-white position-relative">
		<!-- Loader -->
	<div id="editCredentialsLoader" class="sectionloader"> 
		<div class="loader"></div>
	</div>
    <div class="inner-wrap">
        <div class="box-top position-relative">
            <h2 class="box-subhead"><span class="icon-regular icon-id-card"></span>Credentials</h2>
        </div>
        	<aui:input name="credentialId" placeholder="" value="<%=credentialId %>" type="hidden" cssClass="w-100 input-border-bottom"></aui:input>
	        <div class="box-middle">
	            <div id="credentials-fields" class="row row-custom">
	            	<div class="col-md-6">
	            		<div>
            				<h4 class="mb-3"><span class="icon-regular icon-user-graduate"></span> Highest Education Level</h4>
            				<aui:input type="text" name="membership4" label="" value="<%=membership4 %>" cssClass="input" /> 
            			</div>
            		</div>
            		<div class="col-md-6">&nbsp;</div>
	            	<div class="col-md-6">
		             	<h4 class="mb-3"><span class="icon-regular icon-trophy-alt"></span> Professional Memberships</h4>
		             	<div class="d-flex align-items-end formGroupmb0 mb-2 firstFormGroup">
		             		<a href="javascript::void(0);" id="add-membership" class="d-flex cl-asset-type-d cl-hover-black font20 mr-1">
		             			<i class="fas fa-minus-circle invisible"></i>
		             			<i class="fas fa-plus-circle"></i>
		             		</a>
		             		<aui:input type="text" name="membership1" label="" value="<%=membership1 %>" cssClass="input" />
		             	</div>
		             	<div id="membership-2" class="d-none align-items-end formGroupmb0 mb-2">
		             		<a href="javascript::void(0);" id="remove-membership-2" class="d-flex cl-asset-type-d cl-hover-black font20 mr-1">
		             			<i class="fas fa-plus-circle showIfNotActive mr-1"></i>
		             			<i class="fas fa-minus-circle showIfActive"></i>
		             		</a>
		             		<aui:input type="text" name="membership2" label="" value="<%=membership2 %>" cssClass="input" />
		             	</div>
		             	<div id="membership-3" class="d-none align-items-end formGroupmb0 mb-2 lastFormGroup">
		             		<a href="javascript::void(0);" id="remove-membership-3" class="d-flex cl-asset-type-d cl-hover-black font20 mr-1">
		             			<i class="fas fa-minus-circle invisible"></i>
		             			<i class="fas fa-minus-circle"></i>
		             		</a>
		             		<aui:input type="text" name="membership3" label="" value="<%=membership3 %>" cssClass="input" />
		             	</div>
		             </div>
		             <div class="col-md-6">
		             	<h4 class="mb-3"><span class="icon-regular icon-file-certificate"></span> Certificates</h4>
		             	<div class="d-flex align-items-end formGroupmb0 mb-2 firstFormGroup">
		             		<a href="javascript::void(0);" id="add-certificate" class="d-flex cl-asset-type-d cl-hover-black font20 mr-1">
		             			<i class="fas fa-minus-circle invisible"></i>
		             			<i class="fas fa-plus-circle"></i>
		             		</a>
		             		<aui:input type="text" name="certificate1" label="" value="<%=certificate1 %>" cssClass="input" />
		             	</div>
		             	<div id="certificate-2" class="d-none align-items-end formGroupmb0 mb-2">
		             		<a href="javascript::void(0);" id="remove-certificate-2" class="d-flex cl-asset-type-d cl-hover-black font20 mr-1">
		             			<i class="fas fa-plus-circle showIfNotActive mr-1"></i>
		             			<i class="fas fa-minus-circle showIfActive"></i>
		             		</a>
		             		<aui:input type="text" name="certificate2" label="" value="<%=certificate2 %>" cssClass="input" />
		             	</div>
		             	<div id="certificate-3" class="d-none align-items-end formGroupmb0 mb-2 lastFormGroup">
		             		<a href="javascript::void(0);" id="remove-certificate-3" class="d-flex cl-asset-type-d cl-hover-black font20 mr-1">
		             			<i class="fas fa-minus-circle invisible"></i>
		             			<i class="fas fa-minus-circle"></i>
		             		</a>
		             		<aui:input type="text" name="certificate3" label="" value="<%=certificate3 %>" cssClass="input" />
		             	</div>
		             </div>
		             
	        	</div>
	        </div>
    </div>
</div>
	</div>
	<div class="col-lg-6 mb-3">
	<%-- <div class="profesional box box-border-radius box-shadow bg-white position-relative">
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
         </div> --%>
         
         <div class="profesional box box-border-radius box-shadow bg-white position-relative">
         <!-- Loader -->
	<div id="editProfessionalBioLoader" class="sectionloader"> 
		<div class="loader"></div>
	</div>
	<div class="inner-wrap">
		<div class="box-top position-relative">
			<h2 class="box-subhead"><span class="icon-regular icon-user-secret"></span>Professional Bio</h2>
		</div>
		<div class="box-middle">
			<div class="row row-custom mb-4">
				<div class="col-md-6">
					<div class="wrap-video img-resp mb-2 position-relative">
						<div class="overlay-inactive"></div>
						<h3 class="mb-3"><span class="icon-regular icon-camcorder pr-3"></span> Introduction Video</h3>
						<img src="/o/ahea-theme/images/video-bradley.png">
						<!-- <a href="http://youtube.com/jkfvljfg786" target="_blank">http://youtube.com/jkfvljfg786</a> -->
					</div>
				</div>
				<div class="col-md-6">
					<!-- <div class="form-group">
						<input type="text" name="" placeholder="http://youtube.com/jkfvljfg786" class="field input form-control">
					</div> -->
					<aui:input type="text" name="youtubeVideo" label="" value="" cssClass="input" placeholder="http://youtube.com/jkfvljfg786" />
					<p><a href="#" class="btn btn-blue btn-w-100" style="pointer-events: none;">Upload Video</a></p>
				</div>
			</div>
			
			<aui:input name="professionalBioId" placeholder="" label="" value="<%=professionalBioId %>" type="hidden" cssClass="w-100 input-border-bottom"></aui:input>
                                  	
                                  	
                                  	
			<div class="row row-custom mb-4">
				<div class="col-md-12">
					<div class="content-icon position-relative mb-4">
						<div><span class="icon-regular icon-shield-check"></span> <strong>Discipline</strong></div>
						<aui:select name="bioDiscipline" label="" cssClass="wrap-input input select" style="width: auto; margin-left: 25px;">
							<aui:option value="Anthropology"></aui:option>
							<aui:option value="Archaeology">Archaeology</aui:option>
							<aui:option value="Arts">Arts</aui:option>
							<aui:option value="Biology">Biology</aui:option>
							<aui:option value="Business">Business</aui:option>
							<aui:option value="Chemistry">Chemistry</aui:option>
							<aui:option value="Computer Science">Computer Science</aui:option>
							<aui:option value="Earth Science">Earth Science</aui:option>
							<aui:option value="Economics">Economics</aui:option>
							<aui:option value="Education">Education</aui:option>
							<aui:option value="Engineering">Engineering</aui:option>
							<aui:option value="History">History</aui:option>
							<aui:option value="Human Geography">Human Geography</aui:option>
							<aui:option value="Languages">Languages</aui:option>
							<aui:option value="Law">Law</aui:option>
							<aui:option value="Literature">Literature</aui:option>
							<aui:option value="Mathematics">Mathematics</aui:option>
							<aui:option value="Medicine and Health">Medicine and Health</aui:option>
							<aui:option value="Philosophy">Philosophy</aui:option>
							<aui:option value="Physics">Physics</aui:option>
							<aui:option value="Political Science">Political Science</aui:option>
							<aui:option value="Psychology">Psychology</aui:option>
							<aui:option value="Sociology">Sociology</aui:option>
							<aui:option value="Space Sciences">Space Sciences</aui:option>
							<aui:option value="Statistics">Statistics</aui:option>
							<aui:option value="Theology">Theology</aui:option>
						</aui:select>
					</div>
				</div>
				<div class="col-md-12">
					<div class="mb-4">
						<h4 class="mb-3"><span class="icon-regular icon-user-ninja"></span> Areas Of Expertise</h4>
						<div class="d-flex align-items-end formGroupmb0 mb-2 fullwidth firstFormGroup">
								<a href="javascript::void(0);" id="add-area" class="d-flex cl-asset-type-d cl-hover-black font20 mr-1">
									<i class="fas fa-minus-circle invisible mr-1" aria-hidden="true"></i>
									<i class="fas fa-plus-circle"></i>
								</a>
								<!-- <input type="text" name="" value="Business Analytics & Intelligence" class="field input form-control"> -->
								<aui:input type="text" name="areasofexpertise1" label="" value="<%=areasofexpertise1 %>" cssClass="field input form-control" />
							</div>
						<div id="area-2" class="d-none align-items-end formGroupmb0 mb-2 fullwidth">
								<a href="javascript::void(0);" id="remove-area-2" class="d-flex cl-asset-type-d cl-hover-black font20 mr-1">
									<i class="fas fa-plus-circle mr-1"></i>
									<i class="fas fa-minus-circle"></i>
								</a>
								<!-- <input type="text" name="" value="Business Ethics" class="field input form-control"> -->
								<aui:input type="text" name="areasofexpertise2" label="" value="<%=areasofexpertise2 %>" cssClass="field input form-control" />
							</div>
						<div id="area-3" class="d-none align-items-end formGroupmb0 mb-2 fullwidth lastFormGroup">
								<a href="javascript::void(0);" id="remove-area-3" class="d-flex cl-asset-type-d cl-hover-black font20 mr-1">
									<i class="fas fa-minus-circle invisible mr-1"></i>
									<i class="fas fa-minus-circle"></i>
								</a>
								<!-- <input type="text" name="" value="International Operations Research &#38; Management" class="field input form-control"> -->
								<aui:input type="text" name="areasofexpertise3" label="" value="<%=areasofexpertise3 %>" cssClass="field input form-control" />
							</div>
					</div>
				</div>
			</div>
			<div class="row row-custom">
				<div class="col-md-6">
					<div class="form-group">
						<label class="position-relative">
							<span class="icon-regular icon-globe-stand"></span> International Experience
							<i class="fa fa-info-circle cl-blue icon-info" aria-hidden="true">
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
						 	<input type="range" name="experienceLevelUI" min="0" max="3" value="<%=experienceLevel %>" onchange="updateTextInput(this.value);"> 
						 	<aui:input name="experienceLevel" type="hidden" value="<%=experienceLevel %>" ></aui:input> 
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group w-100">
						<label>Link Your CV</label>
						<!-- <input type="url" name="" value="http://www.abcdefge/hijk/lmnop/tuvw.xyz" class="field input form-control"> -->
						<aui:input type="url" name="cvLink" label="" value="<%=cvLink %>" cssClass="field input form-control inactive-input" />
					</div>
				</div>
			</div>
			<div class="row row-custom">
				<div class="col-md-12">
					<div class="form-group">
						<label><span class="icon-regular icon-book-user"></span> Bio</label>
						<!-- <textarea class="field input form-control" style="min-height: 100px;">Divides professional time between teaching undergraduate courses in both classroom and online settings, and providing private consulting specializing in the growth and globalization of small businesses. I also serve on the editorial board of The Academy of Management Journal.</textarea> -->
						<aui:input type="textarea" name="bioDescription" label="" cssClass="field input form-control" style="min-height: 100px; height: auto;" 
                  		value="<%=bioDescription %>"  />
					</div>
				</div>
			</div>

		</div>
	</div>
</div>
	</div>
	<div class="col-lg-6 mb-3">
	<div id="interest" class="collaboration box box-border-radius box-shadow bg-white position-relative">
	<!-- Loader -->
	<div id="editCollaborationInterestLoader" class="sectionloader"> 
		<div class="loader"></div>
	</div>
	<div class="inner-wrap">
		<div class="box-top position-relative">
			<h2 class="box-subhead">
				<span class="icon-regular icon-comment-smile"></span>Collaboration Interests
			</h2>
		</div>
		<div class="box-middle">
			<div class="row row-custom">
				<div class="col-md-12">
					<h4 class="mb-3"><span class="icon-regular icon-s-search pr-3"></span> Areas of Interest
						<i class="fa fa-info-circle icon-info cl-blue" aria-hidden="true">
							<span class="info-toltip">Click "Learn More" to learn about CollaboratED Projects in our Resources section.</span>
						</i>
					</h4>
					
					<div class="clearfix">
					<div id="area-of-interest-block" class="row row-custom "></div>
					
					<!-- <div id="view-more-interest-modal"	class="box-border-radius box-shadow modal-dialog viewmoredetail">
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
										<strong>Created: 12-20-2019 11:34 PM</strong>
									</div>
								</div>
								<div class="row text-center pt-2 view-find-matches">
									
								</div>
							</div>
						</div>
					</div> -->
					
					<div class="modal interestModal" id="view-more-interest-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
						<div class="modal-content">
								
							<!-- Static Section -->
							<div class="modal-body view-more-interest-modal-inner">
													<div class="modal-header position-relative">
									<div class="toltip-close3"><a href="javascript:void(0);" data-dismiss="modal"><i class="fa fa-times-circle"></i></a></div>
									<div class="text-left font15"><strong>Project Test</strong><br><span class="view-project-type"></span></div>
								</div>
									<div class="row mb-2">
										<div class="col-md-12">
											<strong>Description</strong><br>
											<span class="view-description"></span>
										</div>
									</div>
									
									<div class="row">
										<div class="col-md-12 mb-2 order-md-1">
											<strong>Preferred Language</strong><br><span class="view-language"></span>
										</div>
										<div class="col-md-6 mb-2 order-md-2">
											<strong>Collaboration Type</strong><br><span class="view-collaboration-type"></span>
										</div>
										<div class="col-md-6 mb-2 order-md-4">
											<strong>Discipline 1</strong><br><span class="view-discipline1"></span>
										</div> 
										<div class="col-md-6 mb-2 order-md-6">
											<strong>Discipline 2</strong><br><span class="view-discipline2"></span>
										</div>
										<div class="col-md-6 mb-2 order-md-8">
											<strong>Discipline 3</strong><br><span class="view-discipline3"></span>
										</div>
										<div class="col-md-6 mb-2 order-md-3">
											<strong>Region 1</strong><br><span class="view-location1"></span>
										</div>
										<div class="col-md-6 mb-2 order-md-5">
											<strong>Region 2</strong><br><span class="view-location2"></span>
										</div>
										<div class="col-md-6 mb-2 order-md-7">
											<strong>Region 3</strong><br><span class="view-location3"></span>
										</div>
										<div class="col-md-6 mb-2 order-md-9">
											<strong>Region 4</strong><br><span class="view-location4"></span>
										</div>
									</div>
									
									<div class="row">
										<div class="col-md-6 mb-2"><strong>Program Level</strong><br><span class="view-program-level"></span></div>
										<div class="col-md-6 mb-2"><strong>Program Length</strong><br><span class="view-program-length"></span></div>
										<div class="col-md-6 mb-2"><strong>Delivery Method</strong><br><span class="view-delivery-type"></span></div>
										<div class="col-md-6 mb-2"><strong>Credits</strong><br><span class="view-credits"></span></div>
									</div>
									
									<div class="row mb-2">
										<div class="col-md-12 rangerDisabled">
												 <strong>Project Date Range</strong>
												 <div class="top-label-range">
												 	<div class="top-init-range">
												 		<div><span class="currentMonthStart1 mr-1"></span><span id="currentday1"></span></div>
												 	</div>
												<div class="year-last-range pickerdata">
													<input type="text" id="rangerDatepicker1" value="2020" readonly/>
												</div>
											</div>
												 <input type="text" class="js-range-slider" id="projectRange1" name="my_range1" value="" />
												  
												 
										</div>
									</div>
									<div class="text-center pt-2 mt-3 view-find-matches justify-content-around d-flex">
										
									</div>
									<div class="row text-center">
										<div class="col-md-12 ac mt-3 text-center">
											<strong>Created: <span class="created_date">2019-10-31</span></strong>
										</div>
									</div>
								
							</div>
						
						
							<!-- Edit Section -->
							<div class="modal-body edit-section d-none">
								<div class="toltip-close3">
									<a href="javascript:void(0);" data-dismiss="modal" class="text-white"><i class="fa fa-times-circle"></i></a>
								</div>
								<aui:input  name="updateInterestId" value="0" type="hidden"></aui:input>
								<div class="row mb-2">
									<div class="col-md-12">
										<aui:select name="projectTypeEdit" label="What type of project are you interested in?" cssClass="wrap-input input select" required="true" onChange="getProjectTypeStatus(this.value)">
											<aui:option value="">Select a Project</aui:option>
											<aui:option value="Academic Journal" disabled="true">Academic Journal</aui:option>
											<aui:option value="Best Practices" disabled="true">Best Practices</aui:option>
											<aui:option value="Course Development">Course Development</aui:option>
											<aui:option value="Curriculum Development" disabled="true">Curriculum Development</aui:option>
											<aui:option value="General Publication" disabled="true">General Publication</aui:option>
											<aui:option value="Mentorship" disabled="true">Mentorship</aui:option>
											<aui:option value="Peer Review" disabled="true">Peer Review</aui:option>
											<aui:option value="Research" disabled="true">Research</aui:option>
											<aui:option value="Study Abroad" disabled="true">Study Abroad</aui:option>
											<aui:option value="Other" disabled="true">Other</aui:option>
										</aui:select>
										<aui:input type="textarea" name="projectDescriptionEdit" label="Description:" value="" cssClass="wrap-input input textarea" style="height: 55px;" required="true"/>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6 mb-2">
										<aui:select name="preferredLanguageEdit" label="Preferred Language" cssClass="wrap-input input select" required="true">
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
									<div class="col-md-6 input-multiselect  mb-2">&nbsp;</div>
									<div class="col-md-6 mb-2">
										<div class="collaborationShow">
											<aui:select name="collaborationTypeEdit" label="Collaboration Type" cssClass="wrap-input input select">
												<aui:option value=""></aui:option>													
												<aui:option value="Departmental">Departmental </aui:option>
												<aui:option value="Institutional">Institutional </aui:option>
												<aui:option value="Regional">Regional </aui:option>	
												<aui:option value="Global">Global</aui:option>																																
											</aui:select>
										</div>
										<div class="selectableDR selectableDREdit first active">
											<aui:select name="disciplineEdit1" label="Discipline 1" cssClass="wrap-input input select mb-0">
												<aui:option value=""></aui:option>
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
											<!-- <span class="font-style-italic font11">Hold CTRL for multi-select</span> -->
										</div>
										<div class="selectableDR selectableDREdit d-block">
											<aui:select name="disciplineEdit2" label="Discipline 2" cssClass="wrap-input input select mb-0">
												<aui:option value=""></aui:option>
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
										</div>
										<div class="selectableDR selectableDREdit d-block">
											<aui:select name="disciplineEdit3" label="Discipline 3" cssClass="wrap-input input select mb-0">
												<aui:option value=""></aui:option>
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
										</div>
									</div>
									<div class="col-md-6 mb-2">
										<div class="selectableDR selectableDREdit first active">
											<aui:select name="locationEdit1" label="Region 1" cssClass="wrap-input input select">
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
										<div class="selectableDR selectableDREdit showIfNotAll">
												<aui:select name="locationEdit2" label="Region 2" cssClass="wrap-input input select">
													<aui:option value=""></aui:option>
													<!-- <aui:option value="All">All</aui:option> -->
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
											<div class="selectableDR selectableDREdit showIfNotAll">
												<aui:select name="locationEdit3" label="Region 3" cssClass="wrap-input input select">
													<aui:option value=""></aui:option>
													<!-- <aui:option value="All">All</aui:option> -->
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
											<div class="selectableDR selectableDREdit showIfNotAll">
												<aui:select name="locationEdit4" label="Region 4" cssClass="wrap-input input select">
													<aui:option value=""></aui:option>
													<!-- <aui:option value="All">All</aui:option> -->
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
									</div>
									
									<div class="col-md-6 programLength showOnourseDevelopment mb-2">
										<aui:select name="programLengthEdit" label="Program Length:" cssClass="wrap-input input select">
											<aui:option value="Mini Term">Mini Term</aui:option>
											<aui:option value="Ongoing">Ongoing</aui:option>
											<aui:option value="Quarter">Quarter </aui:option>
											<aui:option value="Semester">Semester </aui:option>
											<aui:option value="Summer">Summer </aui:option>
											<aui:option value="Trimester">Trimester </aui:option>										
										</aui:select>
									</div>
									<div class="col-md-6 showOnourseDevelopment mb-2">
										<aui:select name="programLevelEdit" label="Program Level:" cssClass="wrap-input input select">		
											<aui:option value=""></aui:option>
											<aui:option value="Certificate">Certificate</aui:option>					
											<aui:option value="Associate">Associate</aui:option>	
											<aui:option value="Undergraduate">Undergraduate</aui:option>	
											<aui:option value="Graduate">Graduate</aui:option>	
											<aui:option value="Doctoral">Doctoral</aui:option>
											<aui:option value="Post Doctoral">Post-Doctoral </aui:option>							
										</aui:select>
									</div>
									<div class="col-md-6 showOnourseDevelopment mb-2">
										<aui:select name="deliveryMethodEdit" label="Delivery Method:" cssClass="wrap-input input select">
											<aui:option value="Online">Online</aui:option>	
											<aui:option value="Blended or Hybrid">Blended</aui:option>	
											<aui:option value="On-ground">On-Ground</aui:option>																																																	
										</aui:select>
									</div>
									<div class="col-md-6 showOnourseDevelopment mb-2">
										<aui:select name="creditsEdit" label="Credits" cssClass="wrap-input input select">													
											<aui:option value="1">1</aui:option>
											<aui:option value="2">2 </aui:option>
											<aui:option value="3">3 </aui:option>
											<aui:option value="4">4 </aui:option>	
											<aui:option value="Other">Other </aui:option>											
									</aui:select>
									</div>		
									<!-- <div class="col-md-6">
										<aui:field-wrapper cssClass="d-flex flex-column radio-button-container">
											<aui:input name="intracampus" type="radio" value="1" label="Intracampus" checked="true"/>
											<aui:input name="intracampus" type="radio" value="2" label="Intercampus" />
										</aui:field-wrapper>
									</div> -->
								</div>
								<div class="row mb-2">
										<div class="col-md-12">
												 <strong>Project Date Range</strong>
												 <div class="top-label-range">
												 	<div class="top-init-range">
												 		<div><span class="currentMonthStart2 mr-1"></span><span id="currentday2"></span></div>
												 	</div>
												<div class="year-last-range pickerdata">
													<input type="text" id="rangerDatepicker2" value="2020" readonly/>
													<aui:input name="endYearRangeEdit" type="hidden" value="" ></aui:input>
												</div>
											</div>
												 <input type="text" class="js-range-slider" id="projectRange2" name="my_range2" value="" />
												  
												 <aui:input name="endMonthRangeEdit" type="hidden" value="" ></aui:input>
												 <aui:input name="startMonthRange" type="hidden" value="" ></aui:input>
												 <aui:input name="startYearRange" type="hidden" value="" ></aui:input>
										</div>
									</div>
								<div class="row text-center pt-2 justify-content-center">
									<aui:button value="Save" type="button" id="updateInterest"  cssClass="btn btn-blue btn-w-100 m-auto" onclick="updateAreaofInterest()"></aui:button>
								</div>
							</div>
				
						</div>
					  </div>
					</div>
					
					
				</div>
					
					
					
					
					<div class="mb-2">
						<a href="javascript:void(0);" class="btn btn-blue btn-w-100 cursor-pointer"
							id="loadMore-interest">Learn More</a> 
						<a href="javascript:void(0);" class="btn btn-blue btn-w-100 cursor-pointer"
							id="add-interest">Add</a>
					</div>
					<div id="add-interest-modal" class="modalareainterest color-black font14 modal fade">
						<aui:input  name="addInterestId" value="" type="hidden"></aui:input>
						<aui:input  name="addInterestButton" value="" type="hidden"></aui:input>
						<div class=" modal-dialog viewmoredetail  view-more-interest-modal-inner  ">
							<div class="modal-content p-0">
								<div class="modal-body p-0">								
									<div class="interest-modal">
										<div class="view-more-interest-modal-inner tooltipdata">
											<div class="toltip-close2">
												<a href="javascript:void(0);" data-dismiss="modal"><i class="fa fa-times-circle"></i></a>
											</div>
											<div class="row mb-2">
												<div class="col-md-12">
													<aui:select name="projectType" label="What type of project are you interested in?" cssClass="wrap-input input select" required="true" onChange="getProjectTypeStatus(this.value)">
														<aui:option value="">Select a Project</aui:option>
														<aui:option value="Academic Journal" disabled="true">Academic Journal</aui:option>
														<aui:option value="Best Practices" disabled="true">Best Practices</aui:option>
														<aui:option value="Course Development">Course Development</aui:option>
														<aui:option value="Curriculum Development" disabled="true">Curriculum Development</aui:option>
														<aui:option value="General Publication" disabled="true">General Publication</aui:option>
														<aui:option value="Mentorship" disabled="true">Mentorship</aui:option>
														<aui:option value="Peer Review" disabled="true">Peer Review</aui:option>
														<aui:option value="Research" disabled="true">Research</aui:option>
														<aui:option value="Study Abroad" disabled="true">Study Abroad</aui:option>
														<aui:option value="Other" disabled="true">Other</aui:option>
													</aui:select>
													<aui:input type="textarea" name="projectDescription" label="Description:" value="" cssClass="wrap-input input textarea" style="height: 65px; min-height: auto;" required="true"/>
												</div>
											</div>
											<div class="row  mb-2">
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
													<div class="collaborationShow">
														<aui:select name="collaborationType" label="Collaboration Type" cssClass="wrap-input input select" required="true">													
															<aui:option value=""></aui:option>															
															<aui:option value="Departmental">Departmental </aui:option>
															<aui:option value="Institutional">Institutional </aui:option>
															<aui:option value="Regional">Regional </aui:option>
															<aui:option value="Global">Global</aui:option>											
														</aui:select>
													</div>
													<div class="selectableDR first active">
														<aui:select name="discipline1" label="Discipline 1" cssClass="wrap-input input select mb-0" >
															<aui:option value=""></aui:option>
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
														<!-- <span class="font-style-italic font11">Hold CTRL for multi-select</span> -->
													</div>
													<div class="selectableDR d-block">
														<aui:select name="discipline2" label="Discipline 2" cssClass="wrap-input input select mb-0">
															<aui:option value=""></aui:option>
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
													</div>
													<div class="selectableDR d-block">
														<aui:select name="discipline3" label="Discipline 3" cssClass="wrap-input input select mb-0">
															<aui:option value=""></aui:option>
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
													</div>
												</div>
												<div class="col-md-6">
													<div class="selectableDR first active">
														<aui:select name="location1" label="Region 1" cssClass="wrap-input input select">
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
													<div class="selectableDR showIfNotAll">
														<aui:select name="location2" label="Region 2" cssClass="wrap-input input select ">
															<aui:option value=""></aui:option>
															<!-- <aui:option value="All">All</aui:option> -->
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
													<div class="selectableDR showIfNotAll">
														<aui:select name="location3" label="Region 3" cssClass="wrap-input input select">
															<aui:option value=""></aui:option>
															<!-- <aui:option value="All">All</aui:option> -->
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
													<div class="selectableDR showIfNotAll">
														<aui:select name="location4" label="Region 4" cssClass="wrap-input input select">
															<aui:option value=""></aui:option>
															<!-- <aui:option value="All">All</aui:option> -->
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
												</div>
												
												<!-- <div class="col-md-6">
													<aui:field-wrapper cssClass="d-flex flex-column radio-button-container">
														<aui:input name="intracampus" type="radio" value="1" label="Intracampus" checked="true"/>
														<aui:input name="intracampus" type="radio" value="2" label="Intercampus" />
													</aui:field-wrapper>
												</div> -->
											</div>
											<div id="courseDevelopmentPopup" >
												<div class="row mb-2">
													<div class="col-md-6">
														<aui:select name="programLevel" label="Program Level" cssClass="wrap-input input select">													
															<aui:option value=""></aui:option>											
															<aui:option value="Certificate">Certificate</aui:option>					
															<aui:option value="Associate">Associate</aui:option>	
															<aui:option value="Undergraduate">Undergraduate</aui:option>	
															<aui:option value="Graduate">Graduate</aui:option>	
															<aui:option value="Doctoral">Doctoral</aui:option>
															<aui:option value="Post Doctoral">Post-Doctoral</aui:option>									
														</aui:select>
													</div>
													<div class="col-md-6 programLength">
														<aui:select name="programLength" label="Program Length" cssClass="wrap-input input select">
															<aui:option value="Mini Term">Mini Term</aui:option>
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
														<aui:select name="deliveryMethod" label="Delivery Method" cssClass="wrap-input input select">
															<aui:option value="Online">Online</aui:option>	
															<aui:option value="Blended or Hybrid">Blended</aui:option>	
															<aui:option value="On-ground">On-Ground</aui:option>																							
														</aui:select>
													</div>	
													<div class="col-md-6">
														<aui:select name="credits" label="Credits" cssClass="wrap-input input select">													
															<aui:option value="1">1</aui:option>
															<aui:option value="2">2 </aui:option>
															<aui:option value="3">3 </aui:option>
															<aui:option value="4">4 </aui:option>	
															<aui:option value="Other">Other </aui:option>											
														</aui:select>
													</div>
												</div>								
											</div>
											<div class="row mb-2">
												<div class="col-md-12">
	 												 <strong>Project Date Range</strong>
	 												 <div class="top-label-range">
	 												 	<div class="top-init-range">
	 												 		<div><span class="currentMonthStart3 mr-1">Jan</span><span id="currentday3"></span></div>
	 												 	</div>
														<div class="year-last-range pickerdata">
															<input type="text" id="rangerDatepicker3" value="2020" readonly/>
															<aui:input name="endYearRangeAdd" type="hidden" value="" ></aui:input>
														</div>
													</div>
	 												 <input type="text" class="js-range-slider" id="projectRange3" name="my_range3" value="" />
	 												 <aui:input name="endMonthRangeAdd" type="hidden" value="" ></aui:input>
	 												 
												</div>
											</div>
											
											<div class="row text-center pt-2 justify-content-center">
												<aui:button value="Save" type="submit"  cssClass="btn btn-blue btn-w-100 m-auto" onclick="saveProfile('AddInterest')"></aui:button>
											</div> 
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<p>
						<!-- <a href="#">Learn More</a><i class="fa fa-info-circle icon-info"
							aria-hidden="true"> <span class="info-toltip">Click	"Learn More" to learn about CollaboratED Projects in our Resources section.</span>
						</i> -->
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
	<div class="col-lg-12 mb-4 mt-3 text-right"> <!-- onclick="saveProfileTest('profile')" -->
		<aui:button  value="Save Profile" type="submit" onclick="saveProfile('profile')"  cssClass="btn btn-blue" id="saveProfile"></aui:button>
	</div>
	
</div>


</aui:form>

<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDTB30uKJgKRGvIVHavUEPKACPZkqkkifg&sensor=false"></script>

<script>
var A= AUI();
$( document ).ready(function() {
	initMap();
	loadUserInfo();
	$(".profile-status span.control-label").html("<span class='icon-regular icon-user-cog'></span> My Thoughts");
	$("#<portlet:namespace/>file").change(function() {
		readURL(this);
	});
	loadUserCredential();
	
	function formatDate(date) {
		  var day = date.getDate();
		  var monthIndex = date.getMonth();
		  var year = date.getFullYear();

		  return  monthNames[monthIndex] +  ' ' + year;
		}

	/* document.getElementById("currentday1").innerHTML = formatDate(new Date());
	document.getElementById("currentday2").innerHTML = formatDate(new Date());
	document.getElementById("currentday3").innerHTML = formatDate(new Date()); */
	//document.getElementById("currentday1").innerHTML = new Date().getFullYear();
	//document.getElementById("currentday2").innerHTML = new Date().getFullYear();
	document.getElementById("currentday3").innerHTML = new Date().getFullYear();
	var lang = "en-US";
    var year = 2018;
    
    function dateToTS (date) {
        return date.valueOf();
    }
    
    function tsToDate (ts) {
        var d = new Date(ts);
    
        return d.toLocaleDateString(lang, {
            month: 'short',
        });
    }
    

    var da = new Date();
    if (da.getMonth() == 11) {
        var current = new Date(da.getFullYear() + 1, 0, 1);
    } else {
        var current = new Date(da.getFullYear(), da.getMonth() + 11, 1);
    }
    
    $("[id^='projectRange']").ionRangeSlider({
    	skin: "round",
    	type: "single",
        grid: true,
        grid_num: 11,
        min:dateToTS(new Date()),
        max: dateToTS(current),
        values: [
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        ],
        /* from: 1,
        to: 10, */
        prettify: tsToDate,
        onChange: function (data) {
            console.dir(data.from_value);
            $("#<portlet:namespace/>endMonthRangeAdd").val(data.from_value);
            $("#<portlet:namespace/>endMonthRangeEdit").val(data.from_value);
        }
    });
	
   /*  $("#projectRange2").ionRangeSlider({
    	skin: "big",
    	type: "single",
        grid: true,
        grid_num: 11,
        min:dateToTS(new Date()),
        max: dateToTS(current),        
        prettify: tsToDate
    }); */
    var end_year = da.getFullYear() + 15;
    var nd = new Date();
    nd.setFullYear(end_year)
    
    console.log(nd,"end_date")
	 $( "[id^='rangerDatepicker']" ).datepicker({
		 format: "yyyy",
	     viewMode: "years", 
	     minViewMode: "years",
	     autoclose: true,
	     startDate : new Date(),
	     endDate : nd
	 });
	/* 
    $( "#datepicker2" ).datepicker({
		 format: "yyyy",
	     viewMode: "years", 
	     minViewMode: "years",
	     autoclose: true,
	     startDate : new Date(),
	     endDate : nd
	 }); */
    
    var last_valid_selection = null;

    $('#<portlet:namespace/>location').change(function(event) {

      if ($(this).val().length > 4) {

        $(this).val(last_valid_selection);
      } else {
        last_valid_selection = $(this).val();
      }
    });
    
    var last_valid_selection_edit = null;
    $('#<portlet:namespace/>locationEdit').change(function(event) {

        if ($(this).val().length > 4) {

          $(this).val(last_valid_selection_edit);
        } else {
        	last_valid_selection_edit = $(this).val();
        }
      });
    
});

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
	initMap()
});


//Edit Collaboration Interests
function getProjectTypeStatus(value){
	$("#courseDevelopmentPopup").hide();
	$(".showOnourseDevelopment").addClass("d-none");
	$(".programLength").hide();
	$(".collaborationShow").show();
	if(value=="Course Development"){
		$("#courseDevelopmentPopup").show();
		$(".showOnourseDevelopment").removeClass("d-none");
		$(".programLength").show();
	} else if (value=="Curriculum Development"){
		$("#courseDevelopmentPopup").show();
		$(".showOnourseDevelopment").removeClass("d-none");
		$(".programLength").hide();
	} else if(value=="Study Abroad" || value=="Other"){
		$(".collaborationShow").hide();
		$(".selectableDR").not(".first").hide();
	}
}

//Edit Profile Personal Information

$(window).on('load', function() { debugger;
	$(".profile-status").find("textarea").css({"width":"100%","height":"0px"});
	//$(".profile-status").find("span.control-label").text("");
	$(".online-status").find("span.control-label").text("Online Status");
	$(".profile-status span.control-label").html("<span class='icon-regular icon-user-cog'></span>  My Thoughts");
	//$( ".profile-status span.control-label" ).append( document.createTextNode( "My Thoughts" ) );
	
	var url_param = '<%=themeDisplay.getURLPortal()+themeDisplay.getURLCurrent() %>';
	var current_url = new URL(url_param);
	var param = current_url.searchParams.get("param");
	console.log("param==="+param);
	if(param!="" && param=="interest"){
		$("html, body").animate({ scrollTop: $(".collaboration").offset().top }, 500);
	}
});

function readURL(input) {
  debugger;
  if (input.files && input.files[0]) {
    var reader = new FileReader();
    var file_size = $("#<portlet:namespace />file")[0].files[0].size;
	if(file_size>1048576) {
		showMsg("File size should not exceed 1 MB");
		return false;
	} else {
		reader.onload = function(e) {
	      $('#userImage').attr('src', e.target.result);
	    }	    
	    reader.readAsDataURL(input.files[0]);
	}
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