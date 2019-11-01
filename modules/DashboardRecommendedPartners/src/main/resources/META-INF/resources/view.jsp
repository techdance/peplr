<%@ include file="/init.jsp" %>
<%

%>
<div class="recommended box box-border-radius box-shadow bg-white">
	<div class="inner-wrap">
		<div class="box-top position-relative">
			<h2 class="box-subhead"><i class="fa fa-users" aria-hidden="true"></i>Recommended Partners</h2>
			<a href="#" class="icon-setting icon-box"><i class="fas fa-cog"></i></a>
		</div>

		<div class="box-middle dashboardnews"> 
			
			<div id="showErrorMessage">
			<p><a href="<%=themeDisplay.getURLPortal() %>/edit-profile">To view Recommended Partners, complete your Collaboration Interests on the Edit Profile screen.</a></p>
			</div>
		</div>

		<div class="box-bottom text-center font-weight-bold position-relative">
			Find Additional Partners <a href="javascript:void();" class="btn btn-blue" id="partner-search">Search</a>
			<div class="toltip4 text-left any-toltip" id="search-toltip">
				<div class="search-box-header position-relative">
					<a href="javascript:void(0);" class="btn-close color-white"><i class="fa fa-times-circle"></i></a>
					<p>What Are You Looking For?</p>
				</div>
				<div class="search-box-body">
					<table class="table-search" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td class="label-td" width="150">Program</td>
							<td class="input-td">
								<select name="" id="">
									<option value="Anthropology">Anthropology</option>
									<option value="Biochemistry">Biochemistry</option>
									<option value="Biology">Biology</option>
									<option value="Chemistry">Chemistry</option>
									<option value="Economics">Economics</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="label-td">Location</td>
							<td class="input-td">
								<input type="text" placeholder="Enter Region Or Country">
							</td>
						</tr>
					</table>

					<table>
						<tr>
							<td class="label-td2">Program Start Date</td>
							<td class="input-td">
								<input type="text" class="datepicker" placeholder=" dd / mm / yy " readonly>
							</td>
						</tr>
					</table>
				</div>
				<div class="search-box-footer position-relative text-center">
					<a href="#" class="btn btn-blue">Search</a>
				</div>
			</div>
		</div>
	</div>
</div>