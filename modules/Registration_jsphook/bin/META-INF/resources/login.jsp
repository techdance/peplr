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


<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@ include file="/init.jsp" %>


<c:choose>
	<c:when test="<%= themeDisplay.isSignedIn() %>">

		<%
		String signedInAs = HtmlUtil.escape(user.getFullName());

		if (themeDisplay.isShowMyAccountIcon() && (themeDisplay.getURLMyAccount() != null)) {
			String myAccountURL = String.valueOf(themeDisplay.getURLMyAccount());

			signedInAs = "<a class=\"signed-in\" href=\"" + HtmlUtil.escape(myAccountURL) + "\">" + signedInAs + "</a>";
		}
		%>

		<liferay-ui:message arguments="<%= signedInAs %>" key="you-are-signed-in-as-x" translateArguments="<%= false %>" />
	</c:when>
	<c:otherwise>

		<%
		String formName = "loginForm";

		if (windowState.equals(LiferayWindowState.EXCLUSIVE)) {
			formName += "Modal";
		}

		String redirect = ParamUtil.getString(request, "redirect");

		String login = (String)SessionErrors.get(renderRequest, "login");

		if (Validator.isNull(login)) {
			login = LoginUtil.getLogin(request, "login", company);
		}

		String password = StringPool.BLANK;
		boolean rememberMe = ParamUtil.getBoolean(request, "rememberMe");

		if (Validator.isNull(authType)) {
			authType = company.getAuthType();
		}
		%>

		<div class="login-container">
			<portlet:actionURL name="/login/login" secure="<%= PropsValues.COMPANY_SECURITY_AUTH_REQUIRES_HTTPS || request.isSecure() %>" var="loginURL">
				<portlet:param name="mvcRenderCommandName" value="/login/login" />
			</portlet:actionURL>

			<aui:form action="<%= loginURL %>" autocomplete='<%= PropsValues.COMPANY_SECURITY_LOGIN_FORM_AUTOCOMPLETE ? "on" : "off" %>' cssClass="sign-in-form" method="post" name="<%= formName %>" onSubmit="event.preventDefault();" validateOnBlur="<%= false %>">
				<aui:input name="saveLastPath" type="hidden" value="<%= false %>" />
				<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
				<aui:input name="doActionAfterLogin" type="hidden" value="<%= portletName.equals(PortletKeys.FAST_LOGIN) ? true : false %>" />

				<div class="inline-alert-container lfr-alert-container"></div>

				<liferay-util:dynamic-include key="com.liferay.login.web#/login.jsp#alertPre" />

				<c:choose>
					<c:when test='<%= SessionMessages.contains(request, "passwordSent") %>'>
						<div class="alert alert-success">
							<liferay-ui:message key="your-password-was-sent-to-the-provided-email-address" />
						</div>
					</c:when>
					<c:when test='<%= SessionMessages.contains(request, "userAdded") %>'>

						<%
						String userEmailAddress = (String)SessionMessages.get(request, "userAdded");
						String userPassword = (String)SessionMessages.get(request, "userAddedPassword");
						%>

						<div class="alert alert-success">
							<c:choose>
								<c:when test="<%= company.isStrangersVerify() || Validator.isNull(userPassword) %>">
									<liferay-ui:message key="thank-you-for-creating-an-account" />

									<c:if test="<%= company.isStrangersVerify() %>">
										<liferay-ui:message arguments="<%= HtmlUtil.escape(userEmailAddress) %>" key="your-email-verification-code-was-sent-to-x" translateArguments="<%= false %>" />
									</c:if>
								</c:when>
								<c:otherwise>
									<liferay-ui:message arguments="<%= HtmlUtil.escape(userPassword) %>" key="thank-you-for-creating-an-account" translateArguments="<%= false %>" />
									<%-- <liferay-ui:message arguments="<%= HtmlUtil.escape(userPassword) %>" key="thank-you-for-creating-an-account." translateArguments="<%= false %>" /> --%>
								</c:otherwise>
							</c:choose>

							<c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_USER_ADDED_ENABLED) %>">
								<liferay-ui:message arguments="<%= HtmlUtil.escape(userEmailAddress) %>" key="your-password-was-sent-to-x" translateArguments="<%= false %>" />
							</c:if>
						</div>
					</c:when>
					<c:when test='<%= SessionMessages.contains(request, "userPending") %>'>

						<%
						String userEmailAddress = (String)SessionMessages.get(request, "userPending");
						%>

						<div class="alert alert-success">
							<liferay-ui:message arguments="<%= HtmlUtil.escape(userEmailAddress) %>" key="thank-you-for-creating-an-account.-you-will-be-notified-via-email-at-x-when-your-account-has-been-approved" translateArguments="<%= false %>" />
						</div>
					</c:when>
				</c:choose>

				<liferay-ui:error exception="<%= AuthException.class %>" message="Incorrect username or password" />
				<liferay-ui:error exception="<%= CompanyMaxUsersException.class %>" message="unable-to-log-in-because-the-maximum-number-of-users-has-been-reached" />
				<liferay-ui:error exception="<%= CookieNotSupportedException.class %>" message="authentication-failed-please-enable-browser-cookies" />
				<liferay-ui:error exception="<%= NoSuchUserException.class %>" message="authentication-failed" />
				<liferay-ui:error exception="<%= PasswordExpiredException.class %>" message="your-password-has-expired" />
				<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeNull.class %>" message="please-enter-an-email-address" />
				<liferay-ui:error exception="<%= UserLockoutException.LDAPLockout.class %>" message="this-account-is-locked" />

				<liferay-ui:error exception="<%= UserLockoutException.PasswordPolicyLockout.class %>">

					<%
					UserLockoutException.PasswordPolicyLockout ule = (UserLockoutException.PasswordPolicyLockout)errorException;
					%>

					<c:choose>
						<c:when test="<%= ule.passwordPolicy.isRequireUnlock() %>">
							<liferay-ui:message key="this-account-is-locked" />
						</c:when>
						<c:otherwise>
							<liferay-ui:message arguments="<%= ule.user.getUnlockDate() %>" key="this-account-is-locked-until-x" translateArguments="<%= false %>" />
						</c:otherwise>
					</c:choose>
				</liferay-ui:error>

				<liferay-ui:error exception="<%= UserPasswordException.class %>" message="authentication-failed" />
				<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeNull.class %>" message="the-screen-name-cannot-be-blank" />

				<liferay-util:dynamic-include key="com.liferay.login.web#/login.jsp#alertPost" />

				<aui:fieldset>

					<%
					String loginLabel = null;

					if (authType.equals(CompanyConstants.AUTH_TYPE_EA)) {
						loginLabel = "email-address";
					}
					else if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
						loginLabel = "screen-name";
					}
					else if (authType.equals(CompanyConstants.AUTH_TYPE_ID)) {
						loginLabel = "id";
					}
					%>
					
					<div class="wrap-input-icon icon-user">
						<aui:input autoFocus="<%= windowState.equals(LiferayWindowState.EXCLUSIVE) || windowState.equals(WindowState.MAXIMIZED) %>" cssClass="clearable" label="<%= loginLabel %>" name="login" showRequiredLabel="<%= false %>" type="text" value="" placeholder="Email Address">
							<aui:validator name="required" />
						</aui:input>
					</div>
					
					<div class="wrap-input-icon icon-lock">
						<aui:input name="password" showRequiredLabel="<%= false %>" type="password" value="<%= password %>"  placeholder="Password">
							<aui:validator name="required" />
						</aui:input>
						<span class="icon-eye fa fa-fw fa-eye field-icon toggle-password"></span>
					</div>

					<span id="<portlet:namespace />passwordCapsLockSpan" style="display: none;"><liferay-ui:message key="caps-lock-is-on" /></span>

					<div class="d-flex justify-content-between align-items-center">
						<c:if test="<%= company.isAutoLogin() && !PropsValues.SESSION_DISABLED %>">
							<aui:input checked="<%= rememberMe %>" name="rememberMe" type="checkbox" />
						</c:if>
						<div class="forgot mb-3">
							<a href="<%=themeDisplay.getURLPortal() %>/web/guest/home?p_p_id=com_liferay_login_web_portlet_LoginPortlet&amp;p_p_lifecycle=0&amp;p_p_state=maximized&amp;p_p_mode=view&amp;_com_liferay_login_web_portlet_LoginPortlet_mvcRenderCommandName=%2Flogin%2Fforgot_password">
								Forgot Password?
							</a>
						</div>
					</div>
				</aui:fieldset>


				<aui:button-row cssClass="wrap-input-submit my-0">
					<aui:button type="submit" value="sign-in" id="input-submit"/>
				</aui:button-row>
			</aui:form>
			<div class="create-account ac m0">
				<p class="m-0">Don't have an account? 
					<a href="<%=themeDisplay.getURLPortal() %>/web/guest/home?p_p_id=com_liferay_login_web_portlet_LoginPortlet&amp;p_p_lifecycle=0&amp;p_p_state=maximized&amp;p_p_mode=view&amp;saveLastPath=false&amp;_com_liferay_login_web_portlet_LoginPortlet_mvcRenderCommandName=%2Flogin%2Fcreate_account">
						Create an Account
					</a>
				</p>
			</div>
			<%-- <%@ include file="/navigation.jspf" %> --%>
			
		</div>

		<aui:script sandbox="<%= true %>">
			var form = AUI.$(document.<portlet:namespace /><%= formName %>);

			form.on(
				'submit',
				function(event) {
					<c:if test="<%= Validator.isNotNull(redirect) %>">
						var redirect = form.fm('redirect');

						if (redirect) {
							var redirectVal = redirect.val();

							redirect.val(redirectVal + window.location.hash);
						}
					</c:if>

					submitForm(form);
				}
			);

			form.fm('password').on(
				'keypress',
				function(event) {
					Liferay.Util.showCapsLock(event, '<portlet:namespace />passwordCapsLockSpan');
				}
			);
		</aui:script>
	</c:otherwise>
</c:choose>


<script>
$(window).on('load', function() {
	$(".taglib-text").text(function () {
	    return $(this).text().replace("Create Account", "Sign Up"); 
	});
	window.location.href="<%=PropsUtil.get("REDIRECT_REACT_URL") %>"; 
});

jQuery(document).ready(function(){
	$(".toggle-password").click(function() {
		$(this).toggleClass("fa-eye fa-eye-slash");
		var input = $("#_com_liferay_login_web_portlet_LoginPortlet_password");
		if (input.attr("type") == "password")
			input.attr("type", "text");
		else
			input.attr("type", "password");
	});
});

</script>