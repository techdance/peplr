<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>



<%@ include file="/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

String openId = ParamUtil.getString(request, "openId");
boolean male = ParamUtil.getBoolean(request, "male", true);

Calendar birthdayCalendar = CalendarFactoryUtil.getCalendar();

birthdayCalendar.set(Calendar.MONTH, Calendar.JANUARY);
birthdayCalendar.set(Calendar.DATE, 1);
birthdayCalendar.set(Calendar.YEAR, 1970);
%>


<portlet:actionURL name="/login/create_account" secure="<%= PropsValues.COMPANY_SECURITY_AUTH_REQUIRES_HTTPS || request.isSecure() %>" var="createAccountURL" windowState="<%= LiferayWindowState.MAXIMIZED.toString() %>">
	<portlet:param name="mvcRenderCommandName" value="/login/create_account" />
</portlet:actionURL>


<aui:form action="<%= createAccountURL %>" method="post" name="fm">
	<aui:input name="saveLastPath" type="hidden" value="<%= false %>" />
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="openId" type="hidden" value="<%= openId %>" />

	<liferay-ui:error exception="<%= AddressCityException.class %>" message="please-enter-a-valid-city" />
	<liferay-ui:error exception="<%= AddressStreetException.class %>" message="please-enter-a-valid-street" />
	<liferay-ui:error exception="<%= AddressZipException.class %>" message="please-enter-a-valid-postal-code" />
	<liferay-ui:error exception="<%= CaptchaConfigurationException.class %>" message="a-captcha-error-occurred-please-contact-an-administrator" />
	<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="text-verification-failed" />
	<liferay-ui:error exception="<%= CompanyMaxUsersException.class %>" message="unable-to-create-user-account-because-the-maximum-number-of-users-has-been-reached" />
	<liferay-ui:error exception="<%= ContactBirthdayException.class %>" message="please-enter-a-valid-birthday" />
	<liferay-ui:error exception="<%= ContactNameException.MustHaveFirstName.class %>" message="please-enter-a-valid-first-name" />
	<liferay-ui:error exception="<%= ContactNameException.MustHaveLastName.class %>" message="please-enter-a-valid-last-name" />
	<liferay-ui:error exception="<%= ContactNameException.MustHaveValidFullName.class %>" message="please-enter-a-valid-first-middle-and-last-name" />
	<liferay-ui:error exception="<%= DuplicateOpenIdException.class %>" message="a-user-with-that-openid-already-exists" />
	<liferay-ui:error exception="<%= EmailAddressException.class %>" message="please-enter-a-valid-email-address" />

	<liferay-ui:error exception="<%= GroupFriendlyURLException.class %>">

		<%
		GroupFriendlyURLException gfurle = (GroupFriendlyURLException)errorException;
		%>

		<c:if test="<%= gfurle.getType() == GroupFriendlyURLException.DUPLICATE %>">
			<liferay-ui:message key="the-screen-name-you-requested-is-associated-with-an-existing-friendly-url" />
		</c:if>
	</liferay-ui:error>

	<liferay-ui:error exception="<%= NoSuchCountryException.class %>" message="please-select-a-country" />
	<liferay-ui:error exception="<%= NoSuchListTypeException.class %>" message="please-select-a-type" />
	<liferay-ui:error exception="<%= NoSuchRegionException.class %>" message="please-select-a-region" />
	<liferay-ui:error exception="<%= PhoneNumberException.class %>" message="please-enter-a-valid-phone-number" />
	<liferay-ui:error exception="<%= PhoneNumberExtensionException.class %>" message="please-enter-a-valid-phone-number-extension" />
	<liferay-ui:error exception="<%= RequiredFieldException.class %>" message="please-fill-out-all-required-fields" />
	<liferay-ui:error exception="<%= TermsOfUseException.class %>" message="you-must-agree-to-the-terms-of-use" />
	<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeDuplicate.class %>" message="the-email-address-you-requested-is-already-taken" />
	<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeNull.class %>" message="please-enter-an-email-address" />
	<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBePOP3User.class %>" message="the-email-address-you-requested-is-reserved" />
	<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeReserved.class %>" message="the-email-address-you-requested-is-reserved" />
	<liferay-ui:error exception="<%= UserEmailAddressException.MustNotUseCompanyMx.class %>" message="the-email-address-you-requested-is-not-valid-because-its-domain-is-reserved" />
	<liferay-ui:error exception="<%= UserEmailAddressException.MustValidate.class %>" message="please-enter-a-valid-email-address" />
	<liferay-ui:error exception="<%= UserIdException.MustNotBeNull.class %>" message="please-enter-a-user-id" />
	<liferay-ui:error exception="<%= UserIdException.MustNotBeReserved.class %>" message="the-user-id-you-requested-is-reserved" />

	<liferay-ui:error exception="<%= UserPasswordException.MustBeLonger.class %>">

		<%
		UserPasswordException.MustBeLonger upe = (UserPasswordException.MustBeLonger)errorException;
		%>

		<liferay-ui:message arguments="<%= String.valueOf(upe.minLength) %>" key="that-password-is-too-short" translateArguments="<%= false %>" />
	</liferay-ui:error>

	<liferay-ui:error exception="<%= UserPasswordException.MustComplyWithModelListeners.class %>" message="that-password-is-invalid-please-enter-a-different-password" />

	<liferay-ui:error exception="<%= UserPasswordException.MustComplyWithRegex.class %>">

		<%
		UserPasswordException.MustComplyWithRegex upe = (UserPasswordException.MustComplyWithRegex)errorException;
		%>

		<liferay-ui:message arguments="<%= HtmlUtil.escape(upe.regex) %>" key="that-password-does-not-comply-with-the-regular-expression" translateArguments="<%= false %>" />
	</liferay-ui:error>

	<liferay-ui:error exception="<%= UserPasswordException.MustMatch.class %>" message="the-passwords-you-entered-do-not-match" />
	<liferay-ui:error exception="<%= UserPasswordException.MustNotBeNull.class %>" message="the-password-cannot-be-blank" />
	<liferay-ui:error exception="<%= UserPasswordException.MustNotBeTrivial.class %>" message="that-password-uses-common-words-please-enter-a-password-that-is-harder-to-guess-i-e-contains-a-mix-of-numbers-and-letters" />
	<liferay-ui:error exception="<%= UserPasswordException.MustNotContainDictionaryWords.class %>" message="that-password-uses-common-dictionary-words" />
	<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeDuplicate.class %>" focusField="screenName" message="the-screen-name-you-requested-is-already-taken" />
	<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeNull.class %>" focusField="screenName" message="the-screen-name-cannot-be-blank" />
	<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeNumeric.class %>" focusField="screenName" message="the-screen-name-cannot-contain-only-numeric-values" />
	<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeReserved.class %>" message="the-screen-name-you-requested-is-reserved" />
	<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeReservedForAnonymous.class %>" focusField="screenName" message="the-screen-name-you-requested-is-reserved-for-the-anonymous-user" />
	<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeUsedByGroup.class %>" focusField="screenName" message="the-screen-name-you-requested-is-already-taken-by-a-site" />
	<liferay-ui:error exception="<%= UserScreenNameException.MustProduceValidFriendlyURL.class %>" focusField="screenName" message="the-screen-name-you-requested-must-produce-a-valid-friendly-url" />

	<liferay-ui:error exception="<%= UserScreenNameException.MustValidate.class %>" focusField="screenName">

		<%
		UserScreenNameException.MustValidate usne = (UserScreenNameException.MustValidate)errorException;
		%>

		<liferay-ui:message key="<%= usne.screenNameValidator.getDescription(locale) %>" />
	</liferay-ui:error>

	<liferay-ui:error exception="<%= WebsiteURLException.class %>" message="please-enter-a-valid-url" />

	<c:if test='<%= SessionMessages.contains(request, "openIdUserInformationMissing") %>'>
		<div class="alert alert-info">
			<liferay-ui:message key="you-have-successfully-authenticated-please-provide-the-following-required-information-to-access-the-portal" />
		</div>
	</c:if>

	<aui:model-context model="<%= Contact.class %>" />

	<aui:fieldset column="<%= true %>">
		<aui:col width="<%= 100 %>">

			<%
			Boolean autoGenerateScreenName = PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_SCREEN_NAME_ALWAYS_AUTOGENERATE);
			%>

			<c:if test="<%= !autoGenerateScreenName %>">
				<aui:input autoFocus="<%= true %>" model="<%= User.class %>" name="screenName">

					<%
					ScreenNameValidator screenNameValidator = ScreenNameValidatorFactory.getInstance();
					%>

					<c:if test="<%= Validator.isNotNull(screenNameValidator.getAUIValidatorJS()) %>">
						<aui:validator errorMessage="<%= screenNameValidator.getDescription(locale) %>" name="custom">
							<%= screenNameValidator.getAUIValidatorJS() %>
						</aui:validator>
					</c:if>
				</aui:input>
			</c:if>
			<div class="wrap-input-icon icon-briefcase">
			<aui:select name="prefixValue" label="" placeholder="" required="true" cssClass="wrap-input">
				<aui:option class="" value="">Prefix</aui:option> 
				<aui:option class="" value="Dr"> Dr </aui:option>
				<aui:option class="" value="Miss"> Miss </aui:option>
				<aui:option class="" value="Mr"> Mr </aui:option>
				<aui:option class="" value="Mrs"> Mrs </aui:option>
				<aui:option class="" value="Ms"> Ms </aui:option> 				
				<aui:option class="" value="Mx"> Mx </aui:option>
		     </aui:select>
			</div>
			<!-- <liferay-ui:user-name-fields />  -->
			<div class="wrap-input-icon icon-user">
			<aui:input type="text" name="firstName" id="firstName" label="" placeholder="First Name (50 character maximum)" cssClass="wrap-input">


<aui:validator name="required" />
<aui:validator errorMessage="Please enter valid first name" name="custom" >
                                function(val, fieldNode, ruleValue) {                         
	var result = true;
	
		var fileName=$('#<portlet:namespace/>firstName').val(); 
		if(fileName!=''){
		var tt = /^[a-zA-Z ]*$/.test(fileName);
		console.log("tttt"+tt);
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
<a href="#" title="More Info"><i class="fas fa-info-circle"></i></a>
</div>
<div class="wrap-input-icon icon-user">
<aui:input name="lastName" id="lastName" label="" placeholder="Last Name" cssClass="wrap-input">
<aui:validator name="required" />
         <aui:validator errorMessage="Please enter valid last name" name="custom">
                                function(val, fieldNode, ruleValue) {                         
	var result = true;
	
		var fileName=$('#<portlet:namespace/>lastName').val(); 
		if(fileName!=''){
		var tt = /^[a-zA-Z ]*$/.test(fileName);
		console.log("tttt"+tt);
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
    <a href="#" title="More Info"><i class="fas fa-info-circle"></i></a>
    </div>
    <div class="wrap-input-icon icon-envelope">
    <aui:input label="" placeholder="Institution Email Address" model="<%= User.class %>" name="emailAddress" cssClass="wrap-input">
				<c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_EMAIL_ADDRESS_REQUIRED) %>">
					<aui:validator name="required" />
				</c:if>
			</aui:input>
	</div>
			<div class="institute-name wrap-input-icon wrap-input icon-shield">
				<liferay-ui:custom-attribute
			        className="<%= User.class.getName() %>"
			        classPK="<%= 0 %>"
			        editable="<%= true %>"
			        label="<%= true %>"
			        name="instituteName"
			    />
			</div>
			 
			 
		<div class="wrap-input-icon icon-lock">
		<aui:input label="" placeholder="password" name="password1" type="password" value="" cssClass="wrap-input">
			<aui:validator name="required" />
			<aui:validator  name="custom"  errorMessage="Password should contain atleast one (Uppercase Letter,lowercase Letter,Numeric digit and Symbol)" >                                                       
          	function(val, fieldNode, ruleValue) {
              var passwordPattern = new RegExp("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$^&*!~])");
                           var result = passwordPattern.test(val);
                                    if(result){
                                             return result;
                                        }else{
                                               return result;
                                            }
                                    }
           </aui:validator>
           <aui:validator name="minLength">8</aui:validator>
		</aui:input>
		</div>
		<div class="wrap-input-icon icon-lock">
				<aui:input label="" placeholder="Confirm Password" name="password2" type="password" value="" cssClass="wrap-input">
					<aui:validator name="equalTo">
						'#<portlet:namespace />password1'
					</aui:validator>
				</aui:input>
				<a href="#" title="More Info"><i class="fas fa-info-circle"></i></a>
			</div>
			<%-- <c:if test="<%= PropsValues.LOGIN_CREATE_ACCOUNT_ALLOW_CUSTOM_PASSWORD %>">
				<aui:input label="password" name="password1" size="30" type="password" value="" />

				<aui:input label="enter-again" name="password2" size="30" type="password" value="">
					<aui:validator name="equalTo">
						'#<portlet:namespace />password1'
					</aui:validator>
				</aui:input>
			</c:if> --%>

			<c:choose>
				<c:when test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_KERNEL_MODEL_CONTACT_BIRTHDAY) %>">
					<aui:input name="birthday" value="<%= birthdayCalendar %>" />
				</c:when>
				<c:otherwise>
					<aui:input name="birthdayMonth" type="hidden" value="<%= Calendar.JANUARY %>" />
					<aui:input name="birthdayDay" type="hidden" value="1" />
					<aui:input name="birthdayYear" type="hidden" value="1970" />
				</c:otherwise>
			</c:choose>

			<c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_KERNEL_MODEL_CONTACT_MALE) %>">
				<aui:select label="gender" name="male">
					<aui:option label="male" value="1" />
					<aui:option label="female" selected="<%= !male %>" value="0" />
				</aui:select>
			</c:if>

			<c:if test="<%= captchaConfiguration.createAccountCaptchaEnabled() %>">
				<portlet:resourceURL id="/login/captcha" var="captchaURL" />

				<liferay-captcha:captcha url="<%= captchaURL %>" />
			</c:if>
		</aui:col>
	</aui:fieldset>

	<aui:button-row cssClass="text-center wrap-input-submit">
		<aui:button type="submit" value="Create Account" />
	</aui:button-row>
</aui:form>


<%@ include file="/navigation.jspf" %>


<script>
$(window).on('load', function() {
	$(".lfr-ddm-field-group span.control-label").text("Institution Name");
	$(".lfr-ddm-field-group span.control-label").addClass("customFieldLabel");
	$(".lfr-input-text ").addClass("field");
	$(".lfr-input-text ").addClass("form-control");
	$(".lfr-input-text ").addClass("lfr-input-text");
});

$( document ).ready(function() {
	
	$('.institute-name .lfr-input-text').on('focus blur', function (e) {
		   $(this).parents('.lfr-ddm-field-group').toggleClass('show-label', (e.type === 'focus' || this.value.length > 0));
		   //$('.form-validator-stack').parent(".control-group").addClass('error');
		  }).trigger('blur');
});


$(function(){
	$(".institute-name .lfr-ddm-field-group.field-wrapper").append("<div class='form-validator-stack help-block' id='pqai___instituteNameHelperClass'><div role='alert' class='required' style='color: #dc3545;'>This field is required.</div></div>");
	$("#pqai___instituteNameHelperClass").css("display","none");
	function createAccount(event) {
    	var instituteName = $('#pqai___instituteName').val();
    	if(instituteName==""){
    		$("#pqai___instituteNameHelperClass").css("display","block");
    		return false;
    	}        
    }
    $('.wrap-input-submit button').click(createAccount);
    $("#pqai___instituteName").keydown(function (event) {
    	$("#pqai___instituteNameHelperClass").css("display","block");
    	if($("#pqai___instituteName").val()!=""){
    		$("#pqai___instituteNameHelperClass").css("display","none");
    	}
    });
    $("#pqai___instituteName").keypress(function (event) {
    	$("#pqai___instituteNameHelperClass").css("display","block");
    	if($("#pqai___instituteName").val()!=""){
    		$("#pqai___instituteNameHelperClass").css("display","none");
    	}
    });
    $("#pqai___instituteName").keyup(function (event) {
    	$("#pqai___instituteNameHelperClass").css("display","block");
    	if($("#pqai___instituteName").val()!=""){
    	        $("#pqai___instituteNameHelperClass").css("display","none");
    	}
    });
    $("#pqai___instituteName").blur(function (event) {
    	$("#pqai___instituteNameHelperClass").css("display","block");
    	if($("#pqai___instituteName").val()!=""){
    		$("#pqai___instituteNameHelperClass").css("display","none");
    	}
    });
});

</script>




