<%@page import="com.liferay.portal.kernel.model.User"%>
<%@ include file="/init.jsp" %>

<portlet:resourceURL var="updateProfile" id="updateProfile"></portlet:resourceURL>

<div class="personal box box-border-radius box-shadow bg-white">
	<div class="inner-wrap">
		<aui:form name="updateProfileForm" onSubmit="event.preventDefault();updateProfileInformation();">
			<div class="box-top position-relative">
				<h2 class="box-subhead"><i class="fas fa-user"></i>Personal Information</h2>
			</div>
			<div class="box-middle">
				<div class="row row-custom">
					<div class="col-md-6">
						<!-- <div class="bg-profile">
							<img src="images/change-image.png" alt="">
						</div> -->
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
						
						<aui:input name="jobTitle" id="jobTitle" label="Title" placeholder="" cssClass="wrap-input">
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
			
			<aui:button-row cssClass="custom-button">
				<aui:button  id="profileInformationSave" value="Update" type="submit"  cssClass="btn btn-outline-primary prf-btn"></aui:button>
			</aui:button-row>
			
			<!-- <div class="box-bottom">
				<aui:input type="textarea" name="status" label="Status" cssClass="input" 
				value="The function of education is to teach one to think intensively and to think critically. Intelligence plus character - that is the goal of true education. - MLK, Jr." />
			</div> -->
		</aui:form>
	</div>
</div>

<%-- <aui:form name="updateProfileForm" onSubmit="event.preventDefault();updateProfileInformation();">
	       
	<div class="fileinput fileinput-new" data-provides="fileinput">
	   		<div class="fileinput-preview thumbnail" data-trigger="fileinput" style="width: 200px; height: 150px;">
	           <span>
	               <img height="auto" width="100%" src="<%=themeDisplay.getUser().getPortraitURL(themeDisplay) %>" class="img-responsive" alt="Responsive image">
	         	</span>
	         	<span>Profile Photo</span>
			</div>
		<div>
			<span class="btn btn-default btn-file">
				<span class="fileinput-new">Select image</span>
				<span class="fileinput-exists">Change</span> 
				<input type="file" name='<portlet:namespace/>file'/> 
			</span>
		    <a href="#" class="btn btn-default fileinput-exists" data-dismiss="fileinput">Remove</a>
	 	</div>
	 	</div>
	
	<div class="wrap-input-icon wrap-input icon-shield">
		<liferay-ui:custom-attribute
	        className="<%= User.class.getName() %>"
	        classPK="<%= 0 %>"
	        editable="<%= true %>"
	        label="<%= true %>"
	        name="profileStatus"
	    />
	</div>
</aui:form> --%>

<script>
$(document).ready(function(){
	loadUserInfo();
	$("#<portlet:namespace/>file").change(function() {
		readURL(this);
	});
});

$(window).on('load', function() {
	$(".profile-status").find("textarea").css({"width":"100%","height":"0px"});
	$(".profile-status").find("span.control-label").text("Status");
	$(".online-status").find("span.control-label").text("Availability Status");
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



function updateProfileInformation(){
	AUI().use('aui-io-request-deprecated', function(A){
        A.io.request('<%=updateProfile.toString()%>', {
               method: 'post',
               form: {
                   id: '<portlet:namespace/>updateProfileForm',
                   upload:true
               },
               cache: false,
               contentType: false,
               processData: false,
               on: {
            	   start:function(){
            		   //$("#wait").show();
            	   },
            	   complete: function(data){
            		   debugger;   
            		   showMsg("Updated successfully");
            		   /* if(data.details[1].responseText=="update"){
            			   showMsg("Updated successfully");
            		   }else{
            			   showMsg("Not saved");
            		   } */
            		   loadUserInfo();
                   },
                   failure:function(data){
                	   //$("#wait").hide();
                   }
               }
            });
    	});
}
</script>