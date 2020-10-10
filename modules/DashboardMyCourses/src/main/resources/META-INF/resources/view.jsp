<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="javax.portlet.PortletSession"%>
<%@ include file="/init.jsp" %>
<% 
JSONArray coursesDetails = null;
PortletSession sessionObj = renderRequest.getPortletSession();
coursesDetails = (JSONArray)sessionObj.getAttribute("MY_COURSES",PortletSession.APPLICATION_SCOPE);
%>

<div class="box box-border-radius box-shadow bg-white">
	<!-- Loader -->
	<div id="dashboardMyCoursesLoader" class="sectionloader"> 
		<div class="loader"></div>
	</div>
	<div class="inner-wrap">
		<div class="box-top position-relative">
			<h2 class="box-subhead icon-fa-box icon-book-alt-light pl-4">My Courses</h2>
			<a href="javascript:void(0);" class="icon-setting icon-box btn-menu"><i class="fas fa-cog"></i></a>
		</div>
		<div class="box-middle">
			<div class="table-wrapper-scroll-x my-custom-scrollbar">
				<table id="courseTable" class="table table2 table-sm">
					<thead>
						<th align="left">COURSE NAME AND NUMBER</th>
						<th align="center">SCHEDULE</th>
						<th align="center">LOCATION</th>
						<th align="center">ROSTER</th>
						<th align="center">SYLLABUS</th>
						<th align="center">ATTENDANCE</th>
						<th align="center">GRADEBOOK</th>
						<th align="center">REPORTS</th>
					</thead>
					<tbody>
					
						<%
						if(coursesDetails!=null && coursesDetails.length()>0){
							for(int i=0;i<coursesDetails.length();i++){
								JSONObject courseData = coursesDetails.getJSONObject(i);
						%>
						<tr class="row-color-blue">
							<td><%=courseData.getString("name") %><br>BUS 105</td>
							<td class="align-center">
								<span class="txt">T</span><span class="txt">TH</span>
								<span class="d-block">10:00-11:00 AM</span>
							</td>
							<td class="align-center">
								<a href="javascript:void(0);"><i class="fad fa-backpack icon-size-40"></i></a>
							</td>
							<td class="align-center font20">
								<a href="javascript:void(0);"><i class="fad fa-user-check icon-size-40"></i></a>
							</td>
							<td class="align-center">
								<a href="javascript:void(0);"><i class="fad fa-tasks icon-size-40"></i></a>
							</td>
							<td class="align-center">
								<a href="javascript:void(0);"><i class="fad fa-ballot-check icon-size-40"></i></a>
							</td>
							<td class="align-center">
								<a href="javascript:void(0);"><i class="fad fa-address-book icon-size-40"></i></a>
							</td>
							<td class="align-center">
								<a href="javascript:void(0);"><i class="fad fa-file-chart-pie icon-size-40"></i></a>
							</td>
						</tr>
						<%
							}
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
