<%@ include file="/init.jsp"%>



<div class="collaboration box box-border-radius box-shadow bg-white">
	<div class="inner-wrap">
		<div class="box-top position-relative">
			<h2 class="box-subhead">
				<i class="fas fa-user"></i>Collaboration Interests
			</h2>
		</div>
		<div class="box-middle">
			<div class="row row-custom">
				<div class="col-md-6">
					<h4 class="mb-3">Areas of interest</h4>
					<div id="area-of-interest-block"></div>
					
					<div id="view-more-interest-modal"	class="box-border-radius box-shadow interest-modal">
						<div class="view-more-interest-modal-inner position-relative">
							<div class="toltip-close2">
								<a href="javascript:void(0);"><i class="fa fa-times-circle"></i></a>
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
								<div class="row text-center pt-2 view-find-matches">
									
								</div>
							</div>
						</div>
					</div>
					
					
					<!-- <div class="areas-of-interest">
						<div class="row">
							<div class="col-md-6">
								<p>
									<strong>Project</strong><br> Course Development
								</p>
								<p>
									<strong>Delivery Method</strong><br> Online
								</p>
							</div>
							<div class="col-md-6">
								<p>
									<strong>Discipline</strong><br> Biology
								</p>
								<p>
									<strong>Region</strong><br> All
								</p>
							</div>
							<div class="col-md-12">
								<div class="text-center position-relative">
									<a href="javascript:void(0);" id="view-more-interest">View
										more</a>
									
								</div>
							</div>
						</div>
					</div> -->
					<div class="mb-2">
						<a href="javascript:void(0);" class="btn btn-blue btn-w-100"
							id="add-interest">Add An Interest</a>
					</div>
					<div id="add-interest-modal" class="box-border-radius box-shadow color-black font14 interest-modal">
						<aui:form name="CollaborationInterestForm" onSubmit="event.preventDefault();saveCollaborationInterest();">
						<aui:input  name="collaborationInterestId" value="0" type="hidden"></aui:input>
						<div class="view-more-interest-modal-inner position-relative">
							<div class="toltip-close2">
								<a href="javascript:void(0);"><i class="fa fa-times-circle"></i></a>
							</div>
							<div class="view-more-interest-modal-inner-content w-100">
								<div class="row mb-2">
									<div class="col-md-12">
										<aui:select name="projectType" label="What type of project are you interest in?" cssClass="wrap-input input select" required="true" onChange="getProjectTypeStatus(this.value)">
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
									<!-- <a href="#" class="btn btn-blue btn-w-100 m-auto">Save</a> -->
									<aui:button value="Save" type="submit"  cssClass="btn btn-blue btn-w-100 m-auto"></aui:button>
								</div>
							</div>
						</div>
						</aui:form>
					</div>
					<p>
						<a href="#">Learn More</a><i class="fa fa-info-circle icon-info"
							aria-hidden="true"> <span class="info-toltip">Click	"Learn More" to learn about CollaboratED Projects in our Resources section.</span>
						</i>
					</p>
				</div>
				<div class="col-md-6">
					
				<h4 class="mb-3">Introduction Video</h4>
					<!-- <div class="wrap-video img-resp mb-2">
                                            		<img src="images/video3.png">
                                            	</div> -->
						<!-- 16:9 aspect ratio -->
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
				</div>
			</div>
		</div>
	</div>
</div>

<script>
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
</script>