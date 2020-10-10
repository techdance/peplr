<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.collaborated.entity.model.labScreenProjectPartners"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>

<div class="box box-border-radius box-shadow bg-white block-top">
	<!-- Loader -->
	<div id="bradleyTaskOverviewLoader" class="sectionloader"> 
		<div class="loader"></div>
	</div>
     <div class="inner-wrap">
         <div class="box-top position-relative">
             <h3 class="box-subhead"><i class="fas fa-tasks"></i> Task Overview</h3>
             <a href="#" class="icon-setting icon-box"><i class="fas fa-cog"></i></a>
         </div>
         <div class="box-middle">
             <table class="table table-task">
                 <!-- <thead>
                     <tr>
                         <th align="center" class="td-center"></th>
                         <th align="left">Task</th>
                         <th align="left">Status</th>
                         <th align="left">Owner</th>
                         <th align="left">Due date</th>
                         <th align="left">Assets</th>
                         <th align="left"></th>
                     </tr>
                 </thead> -->
                 <tbody id="taskOverview">
                     <!-- <tr>
                         <td align="center"><i class="fas fa-envelope fa-2x color-blue"></i></td>
                         <td>Refine Course Description</td>
                         <td><strong class="color-black">Not Started</strong></td>
                         <td>Bradley Dexter</td>
                         <td>10-15-2019</td>
                         <td>
                         	<div class='td-text d-flex'>
							   <span class='icon-com-clip mr-2'><i class='fal fa-comment-alt-lines'></i> 2</span>
							   <span class='icon-com-clip'><i class='fal fa-paperclip'></i> 1</span>
							</div>
						 </td>
                         <td><img class="ml-4" src="/o/ahea-theme/images/icon-sms.png"> 2</td>
                     </tr>
                     <tr>
                         <td align="center"><i class="fas fa-sync fa-2x color-blue"></i></td>
                         <td>Determine Credit Hours</td>
                         <td><strong class="color-black">Not Started</strong></td>
                         <td>Bradley Dexter</td>
                         <td>10-18-2019</td>
                         <td><img class="ml-4" src="/o/ahea-theme/images/icon-clip.png"> 1</td>
                     </tr>  -->
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
			  <div class="text-left font15 m-auto" id="popup_title"><strong>Add Task</strong></div>
			  <div class="toltip-close">
				<button type="button" class="close" data-dismiss="modal"><i class="fa fa-times-circle" aria-hidden="true"></i></button>
			</div>
		  </div>
		  <aui:form name="addTaskForm" onSubmit="event.preventDefault();addTask()">
			  <aui:input type="hidden" name="taskId" label="Task" value="0" cssClass="wrap-input input" required="true"/>
			  <aui:input type="hidden" name="milestoneName" label="Task" value="Course Information" cssClass="wrap-input input"/>
			  <div class="modal-body">
				  <div class="interest-modal">
					  <div class="row mb-2">
						  <div class="col-md-4">
						  	<aui:input type="text" name="taskName" label="Task Name" value="" cssClass="wrap-input input" required="true"/>
						  </div>
						  <div class="col-md-4">
						  	<aui:select name="projectAssignedTo" label="Assigned" cssClass="wrap-input input select" required="true">
								<aui:option value=""></aui:option>
								<% if(partnersList!=null && partnersList.size()>0){
									/* DynamicQuery dynamicQueryResources = DynamicQueryFactoryUtil.forClass(labScreenProjectOverview.class, PortalClassLoaderUtil.getClassLoader());
									dynamicQueryResources.add(PropertyFactoryUtil.forName("interestId").eq(partnersList.get(0).getPK_projectId()));
									List<labScreenProjectOverview> labScreenProjectOverviewPartners = labScreenProjectOverviewLocalServiceUtil.dynamicQuery(dynamicQueryResources); */
									long inviteFrom = 0;
									inviteFrom = partnersList.get(0).getUserId();									
									for(labScreenProjectPartners parList:partnersList){									
								 %>
								<option value="<%=parList.getProjectPartnerId() %>"> <%=(parList.getProjectPartnerId()>0)?(UserLocalServiceUtil.getUser(parList.getProjectPartnerId()).getFullName()):"" %> </option> 
								<% } if(inviteFrom>0){
										%>
										<option value="<%=inviteFrom %>"> <%=(inviteFrom>0)?(UserLocalServiceUtil.getUser(inviteFrom).getFullName()):"" %> </option>
										<%
									}
								} %>
								<!-- <aui:option value="Inez Campos">Inez Campos</aui:option>
								<aui:option value="Bradley Dexter">Bradley Dexter</aui:option> -->
							</aui:select>
						  </div>
						  <div class="col-md-4 calendar-wrap">
							  <aui:input type="text" name="dueDate" label="Due Date" value="" placeholder="YYYY-MM-DD" cssClass="wrap-input input" autocomplete="off" onkeydown='return false' />
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