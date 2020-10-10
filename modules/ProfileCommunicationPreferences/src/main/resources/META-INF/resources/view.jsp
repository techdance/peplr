<%@ include file="/init.jsp" %>

<div class="institution box box-border-radius box-shadow bg-white">
	<div id="communicationPreferencesLoader" class="sectionloader"> 
		<div class="loader"></div>
	</div>
    <div class="inner-wrap">
        <div class="box-top position-relative">
            <h2 class="box-subhead"><i class="far fa-comment-dots" aria-hidden="true"></i>Communication Preferences</h2>
             <a href="javascript:void(0);" class="icon-setting icon-box btn-menu"><i class="fas fa-cog" aria-hidden="true"></i></a>
        </div>
        <div class="box-middle">
        	<div class="row row-custom">
			   <div class="col-md-12">
			      <div class="content-icon content-icon2 mb-2 ">
			         <span class="icon-regular icon-comment-check"></span> <span id="primaryLanguage_Communication"></span>
			      </div>
			      <div class="content-icon content-icon2 mb-2 ">
			         <span class="icon-regular icon-comment-medical"></span> <span id="secondaryLanguage_Communication"></span>
			      </div>
			      <div class="content-icon content-icon2 mb-2 ">
			         <span class="icon-regular icon-comment-medical"></span> <span id="tertiaryLanguage_Communication"></span>
			      </div>
			      <div class="content-icon content-icon2 mb-2 ">
			         <span class="icon-regular icon-envelope"></span> <a href="" id="emailId_Communication" class="d-inline text-truncate"></a>
			      </div>
			      <div class="content-icon content-icon2 mb-2 ">
			         <span class="icon-regular icon-phone-office"></span> <a href="" id="phoneNumber_Communication"></a>
			      </div>
			      <div class="content-icon content-icon2 mb-2 ">
			         <span class="icon-regular icon-phone-laptop"></span> <a href="" id="mobileNumber_Communication"></a>
			      </div>
			      <div class="content-icon content-icon2 mb-2 ">
			         <span class="icon-regular icon-desktop-alt"></span> <a href="" id="website_Communication" class="d-inline text-truncate"></a>
			      </div>
			   </div>
			</div>
        </div>
    </div>
</div>

<script>
$(document).ready(function(){
	loadUserCommunicationPreferences();
});
</script>