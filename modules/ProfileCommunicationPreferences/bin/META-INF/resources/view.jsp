<%@ include file="/init.jsp" %>

<div class="institution box box-border-radius box-shadow bg-white">
    <div class="inner-wrap">
        <div class="box-top position-relative">
            <h2 class="box-subhead"><i class="fas fa-user"></i>Communication Preferences</h2>
             <a href="javascript:void(0);" class="icon-setting icon-box btn-menu"><i class="fas fa-cog" aria-hidden="true"></i></a>
        </div>
        <div class="box-middle">
        	<div class="row">
				<div class="col-md-4">
		            <div class="content-icon">
		                <i class="text">#1</i><a href="#" id="primaryLanguage_Communication"></a>
		            </div>
		            <div class="content-icon">
		                   <i class="text">#2</i><a href="" id="secondaryLanguage_Communication"></a>
		            </div>
	            </div>
	         	<div class="col-md-4">   
		            <div class="content-icon text-truncate">
		                <i class="far fa-envelope" aria-hidden="true"></i><a href="" id="emailId_Communication" class="d-inline text-truncate
"></a>
		            </div>
		            <div class="content-icon ">
		                    <i class="far fa-calendar-alt" aria-hidden="true"></i><a href="" id="phoneNumber_Communication"></a>
		            </div>
	            </div>
	            <div class="col-md-4">
		            <div class="content-icon text-truncate">
		                <i class="fa fa-desktop" aria-hidden="true"></i><a href="" id="website_Communication" class="d-inline text-truncate"></a>
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