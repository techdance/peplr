<%@page import="com.liferay.portal.kernel.model.ListType"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.service.ContactLocalServiceUtil"%>
<%@ include file="/init.jsp" %>

<div class="personal box box-border-radius box-shadow bg-white">
	<!-- Loader -->
	<div id="personalInformationLoader" class="sectionloader"> 
		<div class="loader"></div>
	</div>
    <div class="inner-wrap">
        <div class="box-top position-relative">
            <h2 class="box-subhead"><span class="icon-regular icon-user-circle"></span> Personal Information</h2>
        </div>
        <div class="box-middle d-flex flex-column flex-md-row align-items-md-center">
            <div class="content-left">
                <%-- <div class="bg-profile">
                    <img src="<%=themeDisplay.getUser().getPortraitURL(themeDisplay) %>" class="rounded-circle" id="user-profile" alt="Profile Image">
                </div> --%>
                <div id="profileUpdate" class="progress" data-value='80'>
	               <span class="progress-left">
	               	<span class="progress-bar border-primary"></span>
	               </span>
	               <span class="progress-right">
	               	<span class="progress-bar border-primary"></span>
	               </span>
	               <div class="progress-value w-100 h-100 rounded-circle d-flex align-items-center justify-content-center">
	                  <img src="<%=themeDisplay.getUser().getPortraitURL(themeDisplay) %>" class="rounded-circle" id="user-profile" alt="Profile Image">
	               </div>
	            </div>
            </div>
            <div class="content-right">
                <div class="profile-info profile-name">
                    <div class="title"><span class="icon-regular icon-user-alt"></span> Name</div>
                    <div class="text color-black"><span id="prefixValue"></span> <span id="fullName"></span></div>
                </div>
                <div class="profile-info profile-title">
                    <div class="title"><span class="icon-regular icon-user-tie"></span> Position</div>
                    <div class="text color-black" id="jobTitle"></div>
                </div>
                <!-- Added department to profile -->
                <div class="profile-info profile-department">
                    <div class="title"><span class="icon-regular icon-user-tie"></span> Department</div>
                    <div class="text color-black profiled" id="profileDep"></div>
                </div>
                
                <div id="btn-invite" class="mt-2 d-none">
					<div class="d-flex">
						<a href="javascript:void(0)"><span class="wrap-fa-comment"><i class="far fa-comment-alt-lines"></i></span></a>
						<a href="javascript:void(0)" class="btn btn-blue ml-3 btn-invite-show" data-toggle="modal" onClick="viewData()">Invite</a>
						<span class="invitationStatus ml-3 align-self-center"></span>
					</div>
				</div>
            </div>
        </div>
        <div class="box-middle">
            <h4><i class="far fa-user-cog"></i> My Thoughts</h4>
            <p id="profileStatus"></p>
        </div>
    </div>
    <a href="<%=themeDisplay.getURLPortal() %>/edit-profile" class="btn btn-blue position-absolute btn-edit-profile">
	    <span class="position-relative">
	        Edit Profile
	        <span class="link-toltip">Profile 85% Complete</span>
	    </span>
	</a>
	<a href="<%=themeDisplay.getURLPortal() %>/edit-profile" id="btn-send-message" class="d-none btn btn-blue position-absolute btn-edit-profile">
	    <i class="fas fa-comments" aria-hidden="true"></i> Send Message
	</a>
	
</div>


<div class="modal fade modalToltip modalareainterest" id="inviteModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    	<div class="modal-header position-relative">
    		<div class="toltip-close3"><a href="javascript:void(0);" data-dismiss="modal"><i class="fa fa-times-circle"></i></a></div>
    		<div class="d-flex justify-content-end align-items-center w-100 mr-4">
    			<div class="text-left font15 pr-5 mr-5"><strong>Project Invite</strong></div>
    			<div class="d-flex mr-2">
    				<a href="#" class="btn btn-grey mr-2" data-dismiss="modal">Cancel</a> <a href="#" class="btn btn-blue" data-dismiss="modal" onclick="sendInvite()">Send</a>
    			</div>
    		</div>
    	</div>
    	<div class="modal-body">
			<div class="interest-modal">
				<div class="box-grey-light m-2 p-3 color-black">
					<div class="row no-gutters justify-content-between align-items-center">
						<div class="col-md-4 text-to text-center">TO:</div>
						<div class="col-md-8">
							<div class="box-middle d-flex align-items-center box-border-radius mb-0 profileinvitesection">
								<div class="content-left">
									<div class="mr-4">
										<img src="" width="90" id="user-profile-new" class="rounded-circle">
									</div>
								</div>
								<div class="content-right">
									<div id="inviteProfileName" class="profile-name bold">
										Inez Campos, Bus.D.
									</div>
									<div id="inviteProfileTitle" class="profile-title">
										Professor of Business Management
									</div>
									<div id="inviteProfileUniversity" class="profile-uni font-style-italic color-blue">
										
									</div>
									<div id="inviteProfileCity" class="profile-city">
										
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="text-editor p-2">
					  <div class="wrap-text-area">
						  <textarea name="" id="editor-text" cols="30" rows="10">
							<strong>Hello <span id="editorFullname" class="profile-name bold"></span></strong>,<br>
							I saw your credentials and interests on CollaboratED and would like to work on a project with you. Please review the project information and respond to this invitation. Thank you.
						  </textarea>
					  </div>
				</div>
				<div class="view-more-interest-modal-inner">

					<div class="text-left">
						<div class="box-header ml-2 mt-2 mr-2 pl-3 pr-3 pt-2 pb-2 color-black">
							<strong>Project</strong><br>
							<span id="projectTitle">Course Development</span>
						</div>
						<div class="mx-2 p-3 color-white box-bg-body">
							<div class='row mb-2'>
							   <div class='col-md-12 d-flex flex-column'>
							      <strong>Description</strong>
							      <span id='description'></span>
							   </div>
							</div>
							<div class='row  mb-2'>
							   <div class='col-md-6 d-flex flex-column'>
							      <strong>Discipline</strong>
							      <span id='discipline'></span>
							   </div>
							   <div class='col-md-6 d-flex flex-column'>
							      <strong>Delivery Method</strong>
							      <span id='deliveryMethod'></span>
							   </div>
							</div>
							<div class='row mb-2'>
							   <div class='col-md-4 d-flex flex-column'>
							      <strong>Collaboration Type</strong>
							      <span id='collaborationType'></span>
							   </div>
							   <div class='col-md-4 d-flex flex-column'>
							      <strong>Region</strong>
							      <span id='region'></span>
							   </div>
							   <div class='col-md-4 d-flex flex-column'>
							      <strong>Program Length</strong>
							      <span id='programLength'></span>
							   </div>
							</div>
							<div class='row mb-2'>
							   <div class='col-md-4 d-flex flex-column'>
							      <strong>Preferred Language</strong>
							      <span id='preferredLanguage'></span>
							   </div>
							   <div class='col-md-4 d-flex flex-column'>
							      <strong>Credits</strong>
							      <span id='credits'></span>
							   </div>
							   <div class='col-md-4 d-flex flex-column'>
							      <strong>Program Level</strong>
							      <span id='programLevel'></span>
							   </div>
							</div>
							<div class='row mb-2'>
							   <div class='col-md-12 disabledRanger'>	
							      <strong>Project Date Range</strong>
									<div class="top-label-range">
										<div class="top-init-range">
											<div><span class="projectInviteStartMonth mr-1"></span><span id="projectInviteDay"></span></div>
										</div>
										<div class="year-last-range pickerdata">
											<input type="text" id="rangerDatepickerPID" value="2020" readonly/>
										</div>
									</div>
									<input type="text" class="js-range-slider" id="projectRangePID" name="my_rangeProject" value="" />
							   </div>
							</div>
						</div>
					</div>
				</div>
			</div>
        </div>
    </div>
  </div>
</div>

