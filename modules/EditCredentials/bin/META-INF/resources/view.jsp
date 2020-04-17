<%@page import="com.collaborated.entity.service.userCredentialLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page import="com.collaborated.entity.model.userCredential"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@ include file="/init.jsp" %>
<portlet:resourceURL var="saveCredentialsForm" id="saveCredentialsForm"></portlet:resourceURL>
<% 
long credentialId=0; 
String membership1="",membership2="",membership3="",membership4="",certificate1="",certificate2="",certificate3="";

DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(userCredential.class, PortalClassLoaderUtil.getClassLoader());
dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(Long.valueOf(themeDisplay.getUserId())));
List<userCredential> creList = userCredentialLocalServiceUtil.dynamicQuery(dynamicQuery);
if(creList.size()>0){
	membership1 = creList.get(0).getMembership1();
	membership2 = creList.get(0).getMembership2();
	membership3 = creList.get(0).getMembership3();
	membership4 = creList.get(0).getMembership4();
	certificate1 = creList.get(0).getCertificate1();
	certificate2 = creList.get(0).getCertificate2();
	certificate3 = creList.get(0).getCertificate3();
}
%>
<div class="credentials box box-border-radius box-shadow bg-white">
    <div class="inner-wrap">
        <div class="box-top position-relative">
            <h2 class="box-subhead"><i class="fas fa-user"></i>Credentials</h2>
        </div>
        <aui:form name="credentialsForm" onSubmit="event.preventDefault();saveUserCredentials();">
        	<aui:input name="credentialId" placeholder="" value="<%=credentialId %>" type="hidden" cssClass="w-100 input-border-bottom"></aui:input>
	        <div class="box-middle">
	            <div class="row row-custom">
	            	<div class="col-md-6">
		             	<h4 class="mb-3">Professional Memberships</h4>
		             	<aui:input type="text" name="membership1" label="Membership &ndash; 1" value="<%=membership1 %>" cssClass="input" />
		             	<aui:input type="text" name="membership2" label="Membership &ndash; 2" value="<%=membership2 %>" cssClass="input" />
		             	<aui:input type="text" name="membership3" label="Membership &ndash; 3" value="<%=membership3 %>" cssClass="input" />
		             	<aui:input type="text" name="membership4" label="Membership &ndash; 4" value="<%=membership4 %>" cssClass="input" />
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
	        
	        <aui:button-row cssClass="custom-button">
				<aui:button  id="credentialSubmit" value="Save" type="submit"  cssClass="btn btn-outline-primary prf-btn"></aui:button>
			</aui:button-row>    
		</aui:form>
    </div>
</div>

<script>
var A= AUI();
$(document).ready(function(){
	loadUserCredential();
	if(<%=creList.size() %>!=0){ 
		$("#<portlet:namespace/>credentialSubmit").html("Update");
	}
});

function saveUserCredentials(){
	AUI().use('aui-io-request-deprecated', function(A){
        A.io.request('<%=saveCredentialsForm.toString()%>', {
               method: 'post',
               form: {
                   id: '<portlet:namespace/>credentialsForm',
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
            		   var id = $("#<portlet:namespace/>credentialId").val();
            		   if(data.details[1].responseText=="add"){
            			   showMsg("Saved successfully");
            		   }else if(data.details[1].responseText=="update"){
            			   showMsg("Updated successfully");
            		   }else{
            			   showMsg("Not saved");
            		   }
                   },
                   failure:function(data){
                	   //$("#wait").hide();
                   }
               }
            });
    	});
}
</script>

