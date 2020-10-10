<%@ include file="/init.jsp" %>

<nav aria-label="breadcrumb">
	<ol class="breadcrumb">
	  <li class="breadcrumb-item"><a href="/home1">Home</a></li>
	  <li class="breadcrumb-item">My Projects</li>
	  <li id="createEditProjectBC" class="breadcrumb-item active" aria-current="page">New Project</li>
	</ol>
</nav>
<section class="wrap-profile">
	<div class="">
		<div class="mb-4"><!-- Project Information -->
		<aui:form name="ProjectCreationForm" onSubmit="event.preventDefault();saveProjectCreation();" enctype="multipart/form-data">
			<div class="personal box box-border-radius box-shadow bg-white position-relative">
				<div class="inner-wrap">
					<div class="box-top position-relative">
						<h2 class="box-subhead"><span class="icon-regular icon-book-title"></span> <p id="editHeading">Project Information</p></h2>
					</div>
					<div class="box-middle">						
						<aui:input type="hidden" name="projectCreationId" label="Project Type" value="0" cssClass="wrap-input input"/>
						<aui:input type="hidden" name="interestId" label="Project Type" value="0" cssClass="wrap-input input"/>
						<aui:input type="hidden" name="projectTypeSave" label="Project Type" value="0" cssClass="wrap-input input"/>
						<aui:input type="text" name="projectType" label="Project Type" value="" cssClass="wrap-input input" disabled="true"/>
						<aui:input type="text" name="projectName" label="Name" value="" cssClass="wrap-input input" required="true"/>
						<aui:input type="textarea" name="projectDescription" label="Description" value="" cssClass="wrap-input input textarea"/>
						
						<aui:select name="projectDiscipline1" label="Discipline 1" cssClass="wrap-input input select mb-0" required="true">
							<aui:option value=""></aui:option>
							<aui:option value="Anthropology">Anthropology </aui:option>
							<aui:option value="Archaeology">Archaeology </aui:option>
							<aui:option value="Arts">Arts </aui:option>
							<aui:option value="Biology">Biology </aui:option>
							<aui:option value="Business">Business </aui:option>
							<aui:option value="Chemistry">Chemistry </aui:option>
							<aui:option value="Computer Science">Computer Science </aui:option>
							<aui:option value="Earth Science">Earth Science </aui:option>
							<aui:option value="Economics">Economics </aui:option>
							<aui:option value="Engineering">Engineering </aui:option>
							<aui:option value="History">History </aui:option>
							<aui:option value="Human Geography">Human Geography </aui:option>
							<aui:option value="Languages">Languages </aui:option>
							<aui:option value="Law">Law </aui:option>
							<aui:option value="Literature">Literature </aui:option>
							<aui:option value="Mathematics">Mathematics </aui:option>
							<aui:option value="Medicine and Health">Medicine and Health </aui:option>
							<aui:option value="Philosophy">Philosophy </aui:option>
							<aui:option value="Physics">Physics </aui:option>
							<aui:option value="Political Science">Political Science </aui:option>
							<aui:option value="Psychology">Psychology </aui:option>
							<aui:option value="Sociology">Sociology </aui:option>
							<aui:option value="Space Sciences">Space Sciences </aui:option>
							<aui:option value="Statistics">Statistics </aui:option>
							<aui:option value="Theology">Theology </aui:option>
						</aui:select>
						
						<aui:select name="projectDiscipline2" label="Discipline 2" cssClass="wrap-input input select mb-0">
							<aui:option value=""></aui:option>
							<aui:option value="Anthropology">Anthropology </aui:option>
							<aui:option value="Archaeology">Archaeology </aui:option>
							<aui:option value="Arts">Arts </aui:option>
							<aui:option value="Biology">Biology </aui:option>
							<aui:option value="Business">Business </aui:option>
							<aui:option value="Chemistry">Chemistry </aui:option>
							<aui:option value="Computer Science">Computer Science </aui:option>
							<aui:option value="Earth Science">Earth Science </aui:option>
							<aui:option value="Economics">Economics </aui:option>
							<aui:option value="Engineering">Engineering </aui:option>
							<aui:option value="History">History </aui:option>
							<aui:option value="Human Geography">Human Geography </aui:option>
							<aui:option value="Languages">Languages </aui:option>
							<aui:option value="Law">Law </aui:option>
							<aui:option value="Literature">Literature </aui:option>
							<aui:option value="Mathematics">Mathematics </aui:option>
							<aui:option value="Medicine and Health">Medicine and Health </aui:option>
							<aui:option value="Philosophy">Philosophy </aui:option>
							<aui:option value="Physics">Physics </aui:option>
							<aui:option value="Political Science">Political Science </aui:option>
							<aui:option value="Psychology">Psychology </aui:option>
							<aui:option value="Sociology">Sociology </aui:option>
							<aui:option value="Space Sciences">Space Sciences </aui:option>
							<aui:option value="Statistics">Statistics </aui:option>
							<aui:option value="Theology">Theology </aui:option>
						</aui:select>
						
						<aui:select name="projectDiscipline3" label="Discipline 3" cssClass="wrap-input input select mb-0" >
							<aui:option value=""></aui:option>
							<aui:option value="Anthropology">Anthropology </aui:option>
							<aui:option value="Archaeology">Archaeology </aui:option>
							<aui:option value="Arts">Arts </aui:option>
							<aui:option value="Biology">Biology </aui:option>
							<aui:option value="Business">Business </aui:option>
							<aui:option value="Chemistry">Chemistry </aui:option>
							<aui:option value="Computer Science">Computer Science </aui:option>
							<aui:option value="Earth Science">Earth Science </aui:option>
							<aui:option value="Economics">Economics </aui:option>
							<aui:option value="Engineering">Engineering </aui:option>
							<aui:option value="History">History </aui:option>
							<aui:option value="Human Geography">Human Geography </aui:option>
							<aui:option value="Languages">Languages </aui:option>
							<aui:option value="Law">Law </aui:option>
							<aui:option value="Literature">Literature </aui:option>
							<aui:option value="Mathematics">Mathematics </aui:option>
							<aui:option value="Medicine and Health">Medicine and Health </aui:option>
							<aui:option value="Philosophy">Philosophy </aui:option>
							<aui:option value="Physics">Physics </aui:option>
							<aui:option value="Political Science">Political Science </aui:option>
							<aui:option value="Psychology">Psychology </aui:option>
							<aui:option value="Sociology">Sociology </aui:option>
							<aui:option value="Space Sciences">Space Sciences </aui:option>
							<aui:option value="Statistics">Statistics </aui:option>
							<aui:option value="Theology">Theology </aui:option>
						</aui:select>
						
						<div class="form-group pt-2 pb-2">
							<aui:field-wrapper name="role">
								<aui:input label="Ongoing" name="role" type="radio" value="Ongoing" id="ongoing_checked" />
            					<aui:input label="Fixed" name="role" type="radio" value="Fixed" checked="true" id="fixed_checked"/>
            				</aui:field-wrapper>
						</div>
						<div class="row">
							<div class="col-md-6 wrap-input-calendar">
								<aui:input type="text" name="projectStartDate" label="Start Date" value="" cssClass="wrap-input input datepicker" autocomplete="off"  onkeydown='return false'/>
							</div>
							<div class="col-md-6 wrap-input-calendar">
								<aui:input type="text" name="projectEndDate" label="End Date" value="" cssClass="wrap-input input datepicker" autocomplete="off"  onkeydown='return false'/>
							</div>
						</div>
						<div class="form-group pt-2 pb-2 courseControlDoc">
							<div class="d-flex">
								<div class="uploadCCD mr-1">
									<button type="button" id="triggerFileUpload" class="btn btn-blue btn-w-100">Upload Course Control Document</button> 
									<aui:input name="courseControlDocument" id="courseControlDocument" type="file" label=""></aui:input>
								</div>
								<sup><i class="fas fa-info-circle fa-2x cl-blue"></i></sup>
							</div>
							<p class="fileName mt-2 mb-0"></p>
						</div>
					</div>
					
				</div>
				<div class="d-flex justify-content-end mt-3 mb-3">
					<aui:button id="endProject" value="End Project" type="button" cssClass="btn btn-grey btn-w-100 mr-2 d-none"></aui:button>
					<div class="ml-auto">
						<aui:button value="Cancel" type="reset"  cssClass="btn btn-grey btn-w-100 mr-2"></aui:button>
						<aui:button id="creatSaveProject" value="Create" type="submit"  cssClass="btn btn-blue btn-w-100"></aui:button> 
					</div>
				</div>
			</div>
			</aui:form>
		</div><!-- END COL -->
	</div>
</section>