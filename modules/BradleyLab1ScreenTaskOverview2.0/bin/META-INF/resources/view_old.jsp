<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.collaborated.entity.model.labScreenProjectPartners"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>
<%
List<labScreenProjectPartners> partnersList = null;
if(null!=request.getAttribute("projectPartnersList")){
	partnersList = (List<labScreenProjectPartners>)request.getAttribute("projectPartnersList");
}

%>
<div class="box box-border-radius box-shadow bg-white block-top">
     <div class="inner-wrap">
         <div class="box-top position-relative">
             <h3 class="box-subhead"><i class="fas fa-tasks"></i> Task Overview</h3>
             <a href="#" class="icon-setting icon-box"><i class="fas fa-cog"></i></a>
         </div>
         <div class="box-middle">
             <table class="table table3">
                 <thead>
                     <tr>
                         <th align="center" class="td-center">Tasks</th>
                         <th align="left">Task</th>
                         <th align="left">Status</th>
                         <th align="left">Owner</th>
                         <th align="left">Due date</th>
                         <th align="left"></th>
                     </tr>
                 </thead>
                 <tbody id="taskOverview">
                     <tr>
                         <td align="center"><i class="fas fa-envelope fa-2x color-blue"></i></td>
                         <td>Refine Course Description</td>
                         <td><strong class="color-black">Not Started</strong></td>
                         <td>Bradley Dexter</td>
                         <td>10-15-2019</td>
                         <td><img class="ml-4" src="/o/ahea-theme/images/icon-sms.png"> 2</td>
                     </tr>
                     <tr>
                         <td align="center"><i class="fas fa-sync fa-2x color-blue"></i></td>
                         <td>Determine Credit Hours</td>
                         <td><strong class="color-black">Not Started</strong></td>
                         <td>Bradley Dexter</td>
                         <td>10-18-2019</td>
                         <td><img class="ml-4" src="/o/ahea-theme/images/icon-clip.png"> 1</td>
                     </tr> 
                 </tbody>
             </table>

             <div class="ar mt-2">
                 <a href="javascript:void(0);" data-toggle="modal" data-target="#addTask"  class="btn btn-blue">Add</a>
             </div>
         </div>

     </div>
 </div>
 
 <div class="modal fade modalToltip modalareainterest" id="addTask" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
	  <div class="modal-content">
		  <div class="modal-header position-relative text-center">
			  <div class="text-left font15 m-auto"><strong>Add Task</strong></div>
		  </div>
		  <aui:form name="addTaskForm" onSubmit="event.preventDefault();addTask()">
			  <div class="modal-body">
				  <div class="interest-modal">
					  <div class="row mb-2">
						  <div class="col-md-4">
						  	<aui:input type="text" name="taskName" label="Task" value="" cssClass="wrap-input input" required="true"/>
						  </div>
						  <div class="col-md-4">
						  	<aui:select name="projectAssignedTo" label="Assigned" cssClass="wrap-input input select" required="true">
								<aui:option value=""></aui:option>
								<% if(partnersList!=null && partnersList.size()>0){
								for(labScreenProjectPartners parList:partnersList){
									
								 %>
								<option value="<%=parList.getProjectPartnerId() %>"> <%=(parList.getProjectPartnerId()>0)?(UserLocalServiceUtil.getUser(parList.getProjectPartnerId()).getFullName()):"" %> </option> 
								<% } } %> 
								<!-- <aui:option value="Inez Campos">Inez Campos</aui:option>
								<aui:option value="Bradley Dexter">Bradley Dexter</aui:option> -->
							</aui:select>
						  </div>
						  <div class="col-md-4">
							  <aui:input type="text" name="dueDate" label="Due Date" value="" cssClass="wrap-input input" required="true" autocomplete="off" />
						  </div>
					  </div>
					  <div class="row">
						  <div class="col-md-12 text-right">							 
							  <!-- <a href="#" class="btn btn-grey mr-2" data-dismiss="modal">Cancel</a> -->
							  <!-- <a href="#" class="btn btn-blue">Save</a> -->
							  <aui:button  value="Cancel" class="btn btn-grey mr-2" data-dismiss="modal" type="button" onclick="clearTask()"></aui:button>
							  <aui:button  value="Save" type="submit" cssClass="btn btn-blue"></aui:button>
						  </div>
					  </div>
				  </div>
			  </div>
		  </aui:form>
	  </div>
	</div>
  </div>