<%@page import="com.collaborated.entity.service.communicationPreferencesLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page import="com.collaborated.entity.model.communicationPreferences"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.jdbc.DataAccess"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ include file="/init.jsp" %>
<%@page import="java.util.List"%>
<%
JSONArray listArray = null;
if(null!=request.getAttribute("languageList")){
	listArray = (JSONArray)request.getAttribute("languageList");
}

long primLangId=0,secoLangId=0,terLangId=0,commuId=0;
String primLangName="",secLangName="",terLangName="",email="",website="",phoneNum="";

DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(communicationPreferences.class, PortalClassLoaderUtil.getClassLoader());
dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplay.getUserId())));
List<communicationPreferences> comList = communicationPreferencesLocalServiceUtil.dynamicQuery(dynamicQuery);
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

<portlet:resourceURL var="savecommunicationForm" id="savecommunicationForm"></portlet:resourceURL>

<div class="credentials box box-border-radius box-shadow bg-white">
<!-- Loader -->
<div id="editCommunicationPreferencesLoader" class="sectionloader"> 
	<div class="loader"></div>
</div>
<div class="inner-wrap">
	<div class="box-top position-relative">
	    <h2 class="box-subhead mw-100"><i class="fas fa-user"></i>Communication Preferences</h2>
	</div>
	<aui:form name="communicationForm" onSubmit="event.preventDefault();saveUserCommuncationPreferences();">
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
							<aui:validator name="email" />
						</aui:input>
					</div>
					<div class="form-group">
						<aui:input name="communicationPhoneNumber" required='true' label="Phone Number" placeholder="Please enter phone number" value="<%=phoneNum %>" cssClass="w-100 input-border-bottom">
							<aui:validator name="number" />
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
		<aui:button-row cssClass="custom-button">
			<aui:button  id="communicationSubmit" value="Save" type="submit"  cssClass="btn btn-outline-primary prf-btn"></aui:button>
		</aui:button-row>
	</aui:form>
</div>
</div>
<script>
var A= AUI();

$(document).ready(function(){
	if(<%=comList.size() %>!=0){
		$("#<portlet:namespace/>communicationSubmit").html("Update");
	}
	$("#editCommunicationPreferencesLoader").fadeOut();
});

function saveUserCommuncationPreferences(){
	
	AUI().use('aui-io-request-deprecated', function(A){
        A.io.request('<%=savecommunicationForm.toString()%>', {
               method: 'post',
               form: {
                   id: '<portlet:namespace/>communicationForm',
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
            		   var id = $("#<portlet:namespace/>communicationId").val();
            		   if(data.details[1].responseText=="add"){
            			   showMsg("Saved successfully");
            		   }else if(data.details[1].responseText=="update"){
            			   showMsg("Updated successfully");
            		   }else{
            			   showMsg("Not saved");
            		   }
            		   $("#editCommunicationPreferencesLoader").fadeOut();
                   },
                   failure:function(data){
                	   //$("#wait").hide();
                   }
               }
            });
    	});
}



</script>

<style>
.custom-button{
	margin:0px !important;
}
</style>


