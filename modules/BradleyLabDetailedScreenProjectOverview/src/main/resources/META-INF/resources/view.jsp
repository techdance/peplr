<!-- <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/0.2.0/Chart.min.js"></script> -->
<%@ include file="/init.jsp" %>


<nav aria-label="breadcrumb">
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href='javascript:void(0);'>Home</a></li>
		<li class="breadcrumb-item">My Projects</li>
		<li class="breadcrumb-item active" aria-current="page"><%=projectName %></li>
	</ol>
</nav>
<div class="box box-border-radius box-shadow bg-white block-top position-relative">
	<!-- Loader -->
	<div id="bradleyLabDetailedScreenLoader" class="sectionloader"> 
		<div class="loader"></div>
	</div>
    <div class="inner-wrap mb-7">
        <div class="box-top position-relative w-btn">
            <h3 class="box-subhead"><span class="icon-regular icon-binoculars"></span> Project Overview</h3>
            <% if(editProjectEnable){ %>
            <a href="/project-creation?projectId=<%=interestId %>" class="icon-setting icon-box mb-5">
            <span class="btn btn-blue btn-w-100 mr-2 text-uppercase">Edit Project</span><i class="fas fa-cog"></i> </a>           
        	<% } else { %>
        	<a href="#" class="icon-setting icon-box mb-5"><i class="fas fa-cog"></i></a> <% } %>
        </div>
        <div class="box-middle text1 d-flex">
            <div class="box-middle-inner w-100">
                <h4>Name: <span style="font-weight: normal;"><%=projectName %></span></h4>
                <h5>Description</h5>
                <p><%=description %></p>
            </div>
            <a href="javascript:void(0)" id="donutRedirect">
                <div class="box-middle-inner text-center box-status">
                    <h4>STATUS</h4>
                    <div id="donut1" class="wrap-donut">
                        <div class="text"></div>
                        <canvas id="donut"></canvas>
                    </div>
                </div>
            </a>
        </div>

    </div>
    <div id="CourseInfo" class="wrap-course-information">
        <div class="nav nav-tabs wrap-step mb-4">
            <a data-toggle="tab" href="#step-1" id="step1" class="nav-item nav-link active step step-current bar-progress button-blue-init mr--15">
                <span>
                	<i class="fa fa-check  mr-1" aria-hidden="true"></i>
                	Course Information
                </span>
            </a>
            <a data-toggle="tab" href="#step-2"  id="step2" class="step bar-progress button-lead mr--15">
                <span>
                	<i class="fa fa-check  mr-1" aria-hidden="true"></i>
                	Course Design
                </span>
            </a>
            <a data-toggle="tab" href="#step-3" id="step3" class="step bar-progress button-lead mr--15">
                <span>
                	<i class="fa fa-check  mr-1" aria-hidden="true"></i>
                	Activity Table
                </span>
            </a>
            <a data-toggle="tab" href="#step-4"  id="step4" class="bar-progress button-lead-2">
                <span>
                	<i class="fa fa-check  mr-1" aria-hidden="true"></i>
                	Course Summary
                </span>
            </a>
        </div>
        <div class="tab-content p-0">
            <div class="tab-pane fade show active" id="step-1">
                <div class="course-information-define d-flex justify-content-between align-items-center mb-4">
                    <div>Course Information: Define the basics of the course using the tools below.</div>
                    <a href="javascript:void(0)" class="btn btn-grey btn-w-100 ml-3" disabled="disabled" id="step-1-milestone">Complete Milestone <!-- <i class="far fa-arrow-alt-circle-right"></i> --></a>
                </div>

                <div class="table-course mb-4">
                    <table class="table table3 table-border table-border-radius table-color-black table-tbody-tr-border-bottom td-nothover">
                        <thead>
                            <tr class="th-bg">
                                <th class="td-left" width="30%">Course Identification</th>
                                <th class="td-right"><a href="javascript:void(0)" id="openCourseIdentification" data-toggle="modal" data-target="#courseInfoModal"><i class="fas fa-edit"></i></a></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th class="title-row-th-1" scope="row">Course Title:</th>
                                <td id="courseTitle"></td>
                            </tr>
                            <tr>
                                <th class="title-row-th-1" scope="row">Course Number:</th>
                                <td id="courseNumber"></td>
                            </tr>
                            <tr>
                                <th class="title-row-th-1" scope="row">Prerequisites:</th>
                                <td id="prerequisites"></td>
                            </tr>
                            <tr>
                                <th class="title-row-th-1" scope="row">Course Description:</th>
                                <td id="courseDescription"></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="table-course mb-4">
                    <table class="table table3 table-border table-border-radius table-color-black table-tbody-tr-border-bottom td-nothover">
                        <thead>
                            <tr class="th-bg">
                                <th class="td-left" width="30%">Course Hours</th>
                                <th class="td-right"><a href="javascript:void(0)" id="openCourseInfoModal" data-toggle="modal" data-target="#courseInfoModal"><i class="fas fa-edit"></i></a></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th class="title-row-th-1" scope="row">Credit Hours:</th>
                                <td id="CreditoHours"></td>
                            </tr>
                            <tr>
                                <th class="title-row-th-1" scope="row">Contact Hours:</th>
                                <td id="ContactHours"></td>
                            </tr>
                            <tr>
                                <th class="title-row-th-1" scope="row">Lecture Hours:</th>
                                <td id="LectureHours"></td>
                            </tr>
                            <tr>
                                <th class="title-row-th-1" scope="row">Laboratory Hours:</th>
                                <td id="LaboratoryHours"></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="table-course mb-4">
                    <table class="table table3 table-border table-border-radius table-color-black table-tbody-tr-border-bottom td-nothover">
                        <thead>
                            <tr class="th-bg">
                                <th class="td-left" width="30%">Course Resources</th>
                                <th class="td-right"><a href="javascript:void(0)" id="openCourseResources" data-toggle="modal" data-target="#courseInfoModal"><i class="fas fa-edit"></i></a></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th class="title-row-th-1" scope="row">Textbook Title:</th>
                                <td id="TextbookTitle"></td>
                            </tr>
                            <tr>
                                <th class="title-row-th-1" scope="row">Publisher's Name:</th>
                                <td id="PublisherName"></td>
                            </tr>
                            <tr>
                                <th class="title-row-th-1" scope="row">Author:</th>
                                <td id="Author"></td>
                            </tr>
                            <tr>
                                <th class="title-row-th-1" scope="row">ISBN:</th>
                                <td id="ISBN"></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="table-course">
                    <table id="IQTable" class="table table3 table-border table-border-radius table-color-black table-tbody-tr-border-bottom td-nothover">
                        <thead>
                            <tr class="th-bg">
                                <th class="td-left" width="30%">Instructor Qualifications</th>
                                <th class="td-right"><a href="javascript:void(0)" id="openCourseInstructorQualification" data-toggle="modal" data-target="#courseInfoModal"><i class="fas fa-edit"></i></a></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th class="title-row-th-1" scope="row">Instructor 1 Qualifications:</th>
                                <td id="instQual1"></td>
                            </tr>
                            <tr>
                                <th class="title-row-th-1" scope="row">Instructor 2 Qualifications:</th>
                                <td id="instQual2"></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="tab-pane fade" id="step-2">
                <div class="course-information-define d-flex justify-content-between align-items-center mb-4">
                    <div>Course Design: Begin defining the basic details of the course. Topics covered, course objectives, and learning environments.</div>
                    <a href="javascript:void(0)" class="btn btn-grey btn-w-100 ml-3" id="step-2-milestone">Complete Milestone <!-- <i class="far fa-arrow-alt-circle-right"></i> --></a>
                </div>

                <div class="table-course mb-4">
                    <table class="table table3 table-border table-border-radius table-color-black table-tbody-tr-border-bottom td-nothover">
                        <thead>
                            <tr class="th-bg">
                                <th class="td-left" width="30%">Course Topics</th>
                                <th class="td-right"><a href='javascript:void(0);' id="courseTopics" data-target="#modalCourseDesign" data-toggle="modal"><i class="fas fa-edit"></i></a></th>
                            </tr>
                        </thead>
                        <tbody class="courseTopicsDynamicValue">
                            
                        </tbody>
                    </table>
                </div>
                <div class="table-course mb-4">
                    <table class="table table3 table-border table-border-radius table-color-black table-tbody-tr-border-bottom td-nothover">
                        <thead>
                            <tr class="th-bg">
                                <th class="td-left" width="30%">Course Objectives</th>
                                <th class="td-right"><a href='javascript:void(0);' id="courseObjetives" data-target="#modalCourseDesign" data-toggle="modal"><i class="fas fa-edit"></i></a></th>
                            </tr>
                        </thead>
                        <tbody class="courseObjectiveDynamicValue">
                            
                        </tbody>
                    </table>
                </div>
                <div class="table-course mb-4">
                    <table class="table table3 table-border table-border-radius table-color-black table-tbody-tr-border-bottom td-nothover">
                        <thead>
                            <tr class="th-bg">
                                <th class="td-left" width="30%">Learning Environments</th>
                                <th class="td-right"><a href='javascript:void(0);' id="learningEnvironment" data-target="#modalCourseDesign" data-toggle="modal"><i class="fas fa-edit"></i></a></th>
                            </tr>
                        </thead>
                        <tbody class="learningEnvironmentDynamicValue">
                        </tbody>
                    </table>
                </div>

            </div>
            <div class="tab-pane fade" id="step-3">
                <div class="course-information-define d-flex justify-content-between align-items-center mb-4">
                    <div>Activity Table: Define the details for each week.</div>
                    <a href="javascript:void(0)" class="btn btn-grey btn-w-100 ml-3" id="step-3-milestone">Complete Milestone <!-- <i class="far fa-arrow-alt-circle-right"></i> --></a>
                </div>

                <div class="table-course mb-4">
                    <table class="table table3 table-border table-border-radius table-color-black table-tbody-tr-border-bottom td-nothover">
                        <thead>
                            <tr class="th-bg">
                                <th class="td-left color-blue" width="30%">Week #1</th>
                                <th class="td-right"><a href="javascript:void(0)" id="week1"
                                 data-toggle="modal" data-target="#modalWeek" data-backdrop="static" data-keyboard="false"><i class="fas fa-edit"></i></a></th>
                            </tr>
                        </thead>
                        <tbody class="noHoverColor">
                        	<tr>
                        		<td colspan="2" class="p-0">
                        			<table class="w-100">
                        				<thead>
                        					<tr>
				                                <th class="title-row-th text-center" scope="row" width="25%">Course Objective</th>
				                                <th class="title-row-th text-center" scope="row" width="25%">Learning Environment Design</th>
				                                <th class="title-row-th text-center" scope="row" width="25%">Activity</th>
				                                <th class="title-row-th text-center" scope="row" width="25%">Content</th>
				                            </tr>
                        				</thead>
                        				<!-- <tbody id="week1CLAC"></tbody> -->
                        				<tbody>
                        					<tr>
												<td class="text-center" valign="top">
													<div class="text-left wrap-course-objectives-content-week-1"></div>
												</td>
												<td class="text-center" valign="top">
													<div class="text-left wrap-learning-content-week-1"></div>
												</td>
												<td class="text-center" align='left' valign="top">
													<div class="td-activity-1"></div>
													<div class="td-activity-1-input" style="display:none;">
														<div class='d-flex align-items-center form-group mb-1'>
															<a href='javascript::void(0);' class='color-orange font20 mr-1' onclick="hideInput('activity', '1')"><i class='fas fa-minus-circle fas-16'></i></a>

															<input type='text' value='Syllabus Review' class='input2 bg-grey-light border-none' onkeypress="return keyPressActivity(event, '1', this.value)">
														</div>
													</div>
												</td>
												<td class="text-center" align='center' valign="top">
													<div class="td-content-1"></div>
													<div class="td-content-1-input" style="display:none;">
														<div class='d-flex align-items-center form-group mb-1'>
															<a href='javascript::void(0);' class='color-orange font20 mr-1' onclick="hideInput('content','1')"><i class='fas fa-minus-circle fas-16'></i></a>

															<textarea class='input2 bg-grey-light border-none' onkeypress="return keyPressContent(event, '1', this.value)"> Text Book: Global Ethics: An Introduction, Chapter 1</textarea>
														</div>
													</div>
												</td>
											</tr>
                        				</tbody>
                        				<tfoot>
                        					 <tr>
				                                <td class="text-center">
				                                	<!-- <a href="javascript:void(0);" class="weekPopup" data-title="Course Objective" data-param="1" data-param-name="courseObjective"></a> -->
				                                	<div class="dropdown tableDropdown">
													  <a class="dropdown-toggle" href="#" role="button" data-week="1" id="CourseObjective1Link" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
													  <div class="dropdown-menu CourseObjectiveValue" aria-labelledby="CourseObjective1Link"></div>
													</div>
				                                </td>
				                                <td class="text-center">
					                                <!-- <a href="javascript:void(0);" class="weekPopup" data-title="Learning Environment Design" data-param="1" data-param-name="learningEnvironment"><i class="fas fa-plus-circle color-orange"></i></a> -->
					                                <div class="dropdown tableDropdown">
													  <a class="dropdown-toggle" href="#" role="button" data-week="1" id="LearningEnvironment1Link" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
													  <div class="dropdown-menu LearningEnvironmentValue" aria-labelledby="LearningEnvironment1Link"></div>
													</div>
				                                </td>
				                                <td class="text-center">
				                                	<!-- <a href="javascript:void(0);" class="weekPopup" data-title="Activity" data-param="1" data-param-name="activity"><i class="fas fa-plus-circle color-orange"></i></a> -->
				                                	<a href="javascript:void(0)" class="add-activity" data-activity="1"><i class="fas fa-plus-circle color-orange"></i></a>
				                                </td>
				                                <td class="text-center">
				                                	<!-- <a href="javascript:void(0);" class="weekPopup" data-title="Content" data-param="1" data-param-name="content"><i class="fas fa-plus-circle color-orange"></i></a> -->
				                                	<a href="javascript:void(0)" class="add-content" data-content="1"><i class="fas fa-plus-circle color-orange"></i></a>
				                                </td>
				                            </tr>
                        				</tfoot>
                        			</table>
                        		</td>
                        	</tr>
                        </tbody>
                    </table>
                </div>
                <div class="table-course mb-4">
                    <table class="table table3 table-border table-border-radius table-color-black table-tbody-tr-border-bottom td-nothover">
                        <thead>
                            <tr class="th-bg">
                                <th class="td-left color-blue" width="30%">Week #2</th>
                                <th class="td-right" colspan="3"><a href="javascript:void(0)" id="week2" data-toggle="modal" data-target="#modalWeek" data-backdrop="static" data-keyboard="false"><i class="fas fa-edit"></i></a></th>
                            </tr>
                        </thead>
                        <tbody class="noHoverColor">
                        	<tr>
								<td colspan="2" class="p-0">
									<table class="w-100">
										<thead>
											<tr>
				                                <th class="title-row-th text-center" scope="row" width="25%">Course Objective</th>
				                                <th class="title-row-th text-center" scope="row" width="25%">Learning Environment Design</th>
				                                <th class="title-row-th text-center" scope="row" width="25%">Activity</th>
				                                <th class="title-row-th text-center" scope="row" width="25%">Content</th>
				                            </tr>
										</thead>
										<!-- <tbody id="week2CLAC">
										
										</tbody>
										<tfoot>
											<tr>
				                                <td class="text-center"><a href="javascript:void(0);" class="weekPopup" data-title="Course Objective" data-param="2" data-param-name="courseObjective"><i class="fas fa-plus-circle color-orange"></i></a></td>
				                                <td class="text-center"><a href="javascript:void(0);" class="weekPopup" data-title="Learning Environment Design" data-param="2" data-param-name="learningEnvironment"><i class="fas fa-plus-circle color-orange"></i></a></td>
				                                <td class="text-center"><a href="javascript:void(0);" class="weekPopup" data-title="Activity" data-param="2" data-param-name="activity"><i class="fas fa-plus-circle color-orange"></i></a></td>
				                                <td class="text-center"><a href="javascript:void(0);" class="weekPopup" data-title="Content" data-param="2" data-param-name="content"><i class="fas fa-plus-circle color-orange"></i></a></td>
				                            </tr>
										</tfoot> -->
										<tbody>
                        					<tr>
												<td class="text-center" valign="top">
													<div class="text-left wrap-course-objectives-content-week-2"></div>
												</td>
												<td class="text-center" valign="top">
													<div class="text-left wrap-learning-content-week-2"></div>
												</td>
												<td class="text-center" align='left' valign="top">
													<div class="td-activity-2"></div>
													<div class="td-activity-2-input" style="display:none;">
														<div class='d-flex align-items-center form-group mb-1'>
															<a href='javascript::void(0);' class='color-orange font20 mr-1' onclick="hideInput('activity', '2')"><i class='fas fa-minus-circle fas-16'></i></a>

															<input type='text' value='Syllabus Review' class='input2 bg-grey-light border-none' onkeypress="return keyPressActivity(event, '2', this.value)">
														</div>
													</div>
												</td>
												<td class="text-center" align='center' valign="top">
													<div class="td-content-2"></div>
													<div class="td-content-2-input" style="display:none;">
														<div class='d-flex align-items-center form-group mb-1'>
															<a href='javascript::void(0);' class='color-orange font20 mr-1' onclick="hideInput('content','2')"><i class='fas fa-minus-circle fas-16'></i></a>

															<textarea class='input2 bg-grey-light border-none' onkeypress="return keyPressContent(event, '2', this.value)"> Text Book: Global Ethics: An Introduction, Chapter 1</textarea>
														</div>
													</div>
												</td>
											</tr>
                        				</tbody>
                        				<tfoot>
                        					 <tr>
				                                <td class="text-center">
				                                	<div class="dropdown tableDropdown">
													  <a class="dropdown-toggle" href="#" role="button" data-week="2" id="CourseObjective2Link" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
													  <div class="dropdown-menu CourseObjectiveValue" aria-labelledby="CourseObjective2Link"></div>
													</div>
				                                </td>
				                                <td class="text-center">
					                                <div class="dropdown tableDropdown">
													  <a class="dropdown-toggle" href="#" role="button" data-week="2" id="LearningEnvironment2Link" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
													  <div class="dropdown-menu LearningEnvironmentValue" aria-labelledby="LearningEnvironment2Link"></div>
													</div>
				                                </td>
				                                <td class="text-center">
				                                	<a href="javascript:void(0)" class="add-activity" data-activity="2"><i class="fas fa-plus-circle color-orange"></i></a>
				                                </td>
				                                <td class="text-center">
				                                	<a href="javascript:void(0)" class="add-content" data-content="2"><i class="fas fa-plus-circle color-orange"></i></a>
				                                </td>
				                            </tr>
                        				</tfoot>
									</table>
								</td>
							</tr>
                        </tbody>
                    </table>
                </div>
                <div class="table-course mb-4">
                    <table class="table table3 table-border table-border-radius table-color-black table-tbody-tr-border-bottom td-nothover">
                        <thead>
                            <tr class="th-bg">
                                <th class="td-left color-blue" width="30%">Week #3</th>
                                <th class="td-right" colspan="3"><a href="javascript:void(0)" id="week3" data-toggle="modal" data-target="#modalWeek" data-backdrop="static" data-keyboard="false"><i class="fas fa-edit"></i></a></th>
                            </tr>
                        </thead>
                        <tbody class="noHoverColor">
                        	<tr>
								<td colspan="2" class="p-0">
									<table class="w-100">
										<thead>
											<tr>
				                                <th class="title-row-th text-center" scope="row" width="25%">Course Objective</th>
				                                <th class="title-row-th text-center" scope="row" width="25%">Learning Environment Design</th>
				                                <th class="title-row-th text-center" scope="row" width="25%">Activity</th>
				                                <th class="title-row-th text-center" scope="row" width="25%">Content</th>
				                            </tr>
										</thead>
										<!-- <tbody id="week3CLAC">
										
										</tbody>
										<tfoot>
											<tr>
				                                <td class="text-center"><a href="javascript:void(0);" class="weekPopup" data-title="Course Objective" data-param="3" data-param-name="courseObjective"><i class="fas fa-plus-circle color-orange"></i></a></td>
				                                <td class="text-center"><a href="javascript:void(0);" class="weekPopup" data-title="Learning Environment Design" data-param="3" data-param-name="learningEnvironment"><i class="fas fa-plus-circle color-orange"></i></a></td>
				                                <td class="text-center"><a href="javascript:void(0);" class="weekPopup" data-title="Activity" data-param="3" data-param-name="activity"><i class="fas fa-plus-circle color-orange"></i></a></td>
				                                <td class="text-center"><a href="javascript:void(0);" class="weekPopup" data-title="Content" data-param="3" data-param-name="content"><i class="fas fa-plus-circle color-orange"></i></a></td>
				                            </tr>
										</tfoot> -->
										<tbody>
                        					<tr>
												<td class="text-center" valign="top">
													<div class="text-left wrap-course-objectives-content-week-3"></div>
												</td>
												<td class="text-center" valign="top">
													<div class="text-left wrap-learning-content-week-3"></div>
												</td>
												<td class="text-center" align='left' valign="top">
													<div class="td-activity-3"></div>
													<div class="td-activity-3-input" style="display:none;">
														<div class='d-flex align-items-center form-group mb-1'>
															<a href='javascript::void(0);' class='color-orange font20 mr-1' onclick="hideInput('activity', '3')"><i class='fas fa-minus-circle fas-16'></i></a>

															<input type='text' value='Syllabus Review' class='input2 bg-grey-light border-none' onkeypress="return keyPressActivity(event, '3', this.value)">
														</div>
													</div>
												</td>
												<td class="text-center" align='center' valign="top">
													<div class="td-content-3"></div>
													<div class="td-content-3-input" style="display:none;">
														<div class='d-flex align-items-center form-group mb-1'>
															<a href='javascript::void(0);' class='color-orange font20 mr-1' onclick="hideInput('content','3')"><i class='fas fa-minus-circle fas-16'></i></a>

															<textarea class='input2 bg-grey-light border-none' onkeypress="return keyPressContent(event, '3', this.value)"> Text Book: Global Ethics: An Introduction, Chapter 1</textarea>
														</div>
													</div>
												</td>
											</tr>
                        				</tbody>
                        				<tfoot>
                        					 <tr>
				                                <td class="text-center">
				                                	<div class="dropdown tableDropdown">
													  <a class="dropdown-toggle" href="#" role="button" data-week="3" id="CourseObjective3Link" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
													  <div class="dropdown-menu CourseObjectiveValue" aria-labelledby="CourseObjective3Link"></div>
													</div>
				                                </td>
				                                <td class="text-center">
					                                <div class="dropdown tableDropdown">
													  <a class="dropdown-toggle" href="#" role="button" data-week="3" id="LearningEnvironment3Link" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
													  <div class="dropdown-menu LearningEnvironmentValue" aria-labelledby="LearningEnvironment3Link"></div>
													</div>
				                                </td>
				                                <td class="text-center">
				                                	<a href="javascript:void(0)" class="add-activity" data-activity="3"><i class="fas fa-plus-circle color-orange"></i></a>
				                                </td>
				                                <td class="text-center">
				                                	<a href="javascript:void(0)" class="add-content" data-content="3"><i class="fas fa-plus-circle color-orange"></i></a>
				                                </td>
				                            </tr>
                        				</tfoot>
									</table>
								</td>
							</tr>
                        </tbody>
                    </table>
                </div>
                <div class="table-course mb-4">
                    <table class="table table3 table-border table-border-radius table-color-black table-tbody-tr-border-bottom td-nothover">
                        <thead>
                            <tr class="th-bg">
                                <th class="td-left color-blue" width="30%">Week #4</th>
                                <th class="td-right" colspan="3"><a href="javascript:void(0)" id="week4" data-toggle="modal" data-target="#modalWeek" data-backdrop="static" data-keyboard="false"><i class="fas fa-edit"></i></a></th>
                            </tr>
                        </thead>
                        <tbody class="noHoverColor">
                        	<tr>
								<td colspan="2" class="p-0">
									<table class="w-100">
										<thead>
											<tr>
				                                <th class="title-row-th text-center" scope="row" width="25%">Course Objective</th>
				                                <th class="title-row-th text-center" scope="row" width="25%">Learning Environment Design</th>
				                                <th class="title-row-th text-center" scope="row" width="25%">Activity</th>
				                                <th class="title-row-th text-center" scope="row" width="25%">Content</th>
				                            </tr>
										</thead>
										<!-- <tbody id="week4CLAC">
										
										</tbody>
										<tfoot>
											<tr>
				                                <td class="text-center"><a href="javascript:void(0);" class="weekPopup" data-title="Course Objective" data-param="4" data-param-name="courseObjective"><i class="fas fa-plus-circle color-orange"></i></a></td>
				                                <td class="text-center"><a href="javascript:void(0);" class="weekPopup" data-title="Learning Environment Design" data-param="4" data-param-name="learningEnvironment"><i class="fas fa-plus-circle color-orange"></i></a></td>
				                                <td class="text-center"><a href="javascript:void(0);" class="weekPopup" data-title="Activity" data-param="4" data-param-name="activity"><i class="fas fa-plus-circle color-orange"></i></a></td>
				                                <td class="text-center"><a href="javascript:void(0);" class="weekPopup" data-title="Content" data-param="4" data-param-name="content"><i class="fas fa-plus-circle color-orange"></i></a></td>
				                            </tr>
										</tfoot> -->
										<tbody>
                        					<tr>
												<td class="text-center" valign="top">
													<div class="text-left wrap-course-objectives-content-week-4"></div>
												</td>
												<td class="text-center" valign="top">
													<div class="text-left wrap-learning-content-week-4"></div>
												</td>
												<td class="text-center" align='left' valign="top">
													<div class="td-activity-4"></div>
													<div class="td-activity-4-input" style="display:none;">
														<div class='d-flex align-items-center form-group mb-1'>
															<a href='javascript::void(0);' class='color-orange font20 mr-1' onclick="hideInput('activity', '4')"><i class='fas fa-minus-circle fas-16'></i></a>

															<input type='text' value='Syllabus Review' class='input2 bg-grey-light border-none' onkeypress="return keyPressActivity(event, '4', this.value)">
														</div>
													</div>
												</td>
												<td class="text-center" align='center' valign="top">
													<div class="td-content-4"></div>
													<div class="td-content-4-input" style="display:none;">
														<div class='d-flex align-items-center form-group mb-1'>
															<a href='javascript::void(0);' class='color-orange font20 mr-1' onclick="hideInput('content','4')"><i class='fas fa-minus-circle fas-16'></i></a>

															<textarea class='input2 bg-grey-light border-none' onkeypress="return keyPressContent(event, '4', this.value)"> Text Book: Global Ethics: An Introduction, Chapter 1</textarea>
														</div>
													</div>
												</td>
											</tr>
                        				</tbody>
                        				<tfoot>
                        					 <tr>
				                                <td class="text-center">
				                                	<div class="dropdown tableDropdown">
													  <a class="dropdown-toggle" href="#" role="button" data-week="4" id="CourseObjective4Link" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
													  <div class="dropdown-menu CourseObjectiveValue" aria-labelledby="CourseObjective4Link"></div>
													</div>
				                                </td>
				                                <td class="text-center">
					                                <div class="dropdown tableDropdown">
													  <a class="dropdown-toggle" href="#" role="button" data-week="4" id="LearningEnvironment4Link" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
													  <div class="dropdown-menu LearningEnvironmentValue" aria-labelledby="LearningEnvironment4Link"></div>
													</div>
				                                </td>
				                                <td class="text-center">
				                                	<a href="javascript:void(0)" class="add-activity" data-activity="4"><i class="fas fa-plus-circle color-orange"></i></a>
				                                </td>
				                                <td class="text-center">
				                                	<a href="javascript:void(0)" class="add-content" data-content=""><i class="fas fa-plus-circle color-orange"></i></a>
				                                </td>
				                            </tr>
                        				</tfoot>
									</table>
								</td>
							</tr>
                        </tbody>
                    </table>
                </div>

            </div>
            <div class="tab-pane fade" id="step-4">
                <div class="mb-4">
                    <a href='javascript:void(0);' class="btn btn-grey btn-w-100 mr-3 mb-2">Export Syllabus</a>
                    <a href='javascript:void(0);' class="btn btn-grey btn-w-100 mr-3 mb-2">Export Course Control Document</a>
                    <a href='javascript:void(0);' class="btn btn-grey btn-w-100 mr-3 mb-2">Export To BlendED</a>
                </div>

                <div class="table-course">
                    <table class="table table3 table-border table-border-radius table-color-black table-tbody-tr-border-bottom td-nothover">
                        <thead>
                            <tr class="th-bg">
                                <th class="td-left color-blue" width="30%">Course Identification</th>
                                <th class="td-right"><!-- <a href='javascript:void(0);' data-target="#openCourseSummary" data-toggle="modal"><i class="fas fa-edit"></i></a> --></th> 
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th class="title-row-th-1" scope="row">Course Title:</th>
                                <td id="s_courseTitle"></td>
                            </tr>
                            <tr>
                                <th class="title-row-th-1" scope="row">Course Number:</th>
                                <td id="s_courseNumber"></td>
                            </tr>
                            <tr>
                                <th class="title-row-th-1" scope="row">Prerequisites:</th>
                                <td id="s_prerequisites"></td>
                            </tr>
                            <tr>
                                <th class="title-row-th-1" scope="row">Credit Hours:</th>
                                <td id="s_creditHours"></td>
                            </tr>
                            <tr>
                                <th class="title-row-th-1" scope="row">Contact Hours:</th>
                                <td id="s_contactHours"></td>
                            </tr>
                            <tr>
                                <th class="title-row-th-1" scope="row">Lecture Hours:</th>
                                <td id="s_lectureHours"></td>
                            </tr>
                            <tr>
                                <th class="title-row-th-1" scope="row">Laboratory Hours:</th>
                                <td id="s_laboratoryHours"></td>
                            </tr>
                            <tr>
                                <th class="title-row-th-1" scope="row">Textbook Title: </th>
                                <td id="s_textbookTitle"></td>
                            </tr>
                            <tr>
                                <th class="title-row-th-1" scope="row">Publisher's Name:</th>
                                <td id="s_publisherName"></td>
                            </tr>
                            <tr>
                                <th class="title-row-th-1" scope="row">Authors:</th>
                                <td id="s_authors"></td>
                            </tr>
                            <tr>
                                <th class="title-row-th-1" scope="row">ISBN:</th>
                                <td id="s_ISBN"></td>
                            </tr>
                            <tr>
                                <th class="title-row-th-1" scope="row">Instructor 1 Qualifications:</th>
                                <td id="s_instructor1Qualifications"></td>
                            </tr>
                            <tr>
                                <th class="title-row-th-1" scope="row">Instructor 2 Qualifications:</th>
                                <td id="s_instructor2Qualifications"></td>
                            </tr>
                            <tr>
                                <th class="title-row-th-1" scope="row">Course Description:</th>
                                <td id="s_courseDescription"></td>
                            </tr>
                            <tr>
                                <th class="title-row-th-1" scope="row">Course Topics:</th>
                                <td class="list-no-padding s_courseTopics"></td>
                            </tr>
                            <tr>
                                <th class="title-row-th-1" scope="row">Course Objectives:</th>
                                <td class="list-no-padding s_courseObjective"></td>
                            </tr>
                            <tr>
                                <th class="title-row-th-1" scope="row">Learning Environments:</th>
                                <td class="list-no-padding s_learningEnvironment" ></td>
                            </tr>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
    </div>
</div>


<!-- Course Hours modal -->

<div class="modal fade modalToltip modalareainterest courseInfoModal" id="courseInfoModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div id="courseInfoContent" class="modal-dialog" role="document">
		
	</div>
  </div>

<!-- Modal -->
<div class="modal fade" id="submitModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" data-keyboard="false" data-backdrop="static">
	<div class="modal-dialog" role="document">
	  <div class="modal-content">
		<div class="modal-body">
			<p id="spinner"><img src="/o/ahea-theme/images/giphy.gif" alt="" width="70"></p>
			<p>Your course is being submitted for review by AHEA University.</p>
		</div>
	  </div>
	</div>
</div>

<!-- Modal Week -->
<div class="modal fade modalToltip modalareainterest modal-activity-table" id="modalWeek" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    	<div class="modal-header position-relative text-center">
    		<div class="text-left font15 m-auto"><strong>Activity Table</strong></div>
    	</div>
    	<div class="modal-body">
			<div class="interest-modal color-black">
				<div class="row">
					<div class="col-md-12">
						<div id="flexslider-1" class="flexslider mb-4">
						    <ul class="slides">
						      	<li>
									<h5 class="bold mb-4 text-center color-white">Week 1</h5>
									<h6 class="color-white font-weight-bold	mb-3">Activity Table - Assign Weeks</h6>
									<div class="row">
										<div class="col-md-3">
											<div class="text-center bold mb-2 color-white">Course Objectives</div>
											<div id="week1CourseObjectives" class="course-box">
												<div class="courses-box-body">
													<!-- <div class="courses-box-content">
														<div class="btn-remove">
															<a href="javascript:void(0);" data-toggle="modal" data-target="#weekContentRemovePopup" data-backdrop="static" data-keyboard="false"><i class="fas fa-minus-circle color-orange"></i></a>
														</div>
														<p>Connect with a partner in another country and engage in conversations that result in a joint project that enhances student's intercultural competency skills and knowledge</p>
													</div> -->
												</div>
												<div class="courses-box-footer text-center">
													<!-- <a href="javascript:void(0);" class="weekPopup" data-title="Course Objective" data-param="1" data-param-name="courseObjective"><i class="fas fa-plus-circle color-orange"></i></a> -->
													<div class="dropdown tableDropdown">
													  <a class="dropdown-toggle" href="#" role="button" data-week="1" id="CourseObjectivepopup1Link" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
													  <div class="dropdown-menu CourseObjectiveValue" aria-labelledby="CourseObjectivepopup1Link"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-3">
											<div class="text-center bold mb-2 color-white">Learning Environment Design</div>
											<div id="week1LearningEnvironmentDesign" class="course-box">
												<div class="courses-box-body">
													<!-- <div class="courses-box-content">
														<div class="btn-remove">
															<a href="javascript:void(0);" data-toggle="modal" data-target="#weekContentRemovePopup" data-backdrop="static" data-keyboard="false"><i class="fas fa-minus-circle color-orange"></i></a>
														</div>
														<p>Synchronous Video Lecture</p>
													</div>
													<div class="courses-box-content">
														<div class="btn-remove">
															<a href="javascript:void(0);" data-toggle="modal" data-target="#weekContentRemovePopup" data-backdrop="static" data-keyboard="false"><i class="fas fa-minus-circle color-orange"></i></a>
														</div>
														<p>Independent Assignments</p>
													</div> -->
												</div>
												<div class="courses-box-footer text-center">
													<!-- <a href="javascript:void(0);" class="weekPopup" data-title="Learning Environment Design" data-param="1" data-param-name="learningEnvironment"><i class="fas fa-plus-circle color-orange"></i></a> -->
													<div class="dropdown tableDropdown">
													  <a class="dropdown-toggle" href="#" role="button" data-week="1" id="LearningEnvironmentpopup1Link" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
													  <div class="dropdown-menu LearningEnvironmentValue" aria-labelledby="LearningEnvironmentpopup1Link"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-3">
											<div class="text-center bold mb-2 color-white">Activity</div>
											<div id="week1Activity" class="course-box">
												<div class="courses-box-body">
													<!-- <div class="courses-box-content">
														<div class="btn-remove">
															<a href="javascript:void(0);" data-toggle="modal" data-target="#weekContentRemovePopup" data-backdrop="static" data-keyboard="false"><i class="fas fa-minus-circle color-orange"></i></a>
														</div>
														<p>Syllabus Review</p>
													</div> -->
												</div>
												<div>
													<div class="td-activity-popupActivity1"></div>
													<div class="td-activity-popupActivity1-input" style="display:none;">
														<div class='d-flex align-items-center form-group mb-1'>
															<a href='javascript::void(0);' class='color-orange font20 mr-1' onclick="hideInput('activity', 'popupActivity1')"><i class='fas fa-minus-circle fas-16'></i></a>
															<input type='text' value='Syllabus Review' class='input2 bg-grey-light border-none' onkeypress="return keyPressActivity(event, 'popupActivity1', this.value)">
														</div>
													</div>
												</div>
												<div class="courses-box-footer text-center">
													<!-- <a href="javascript:void(0);" class="weekPopup" data-title="Activity" data-param="1" data-param-name="activity"><i class="fas fa-plus-circle color-orange"></i></a> -->
													<a href="javascript:void(0)" class="add-activity" data-activity="popupActivity1"><i class="fas fa-plus-circle color-orange"></i></a>
												</div>
											</div>
										</div>
										<div class="col-md-3">
											<div class="text-center bold mb-2 color-white">Content</div>
											<div id="week1Content" class="course-box">
												<div class="courses-box-body">
													<!-- <div class="courses-box-content">
														<div class="btn-remove">
															<a href="javascript:void(0);" data-toggle="modal" data-target="#weekContentRemovePopup" data-backdrop="static" data-keyboard="false"><i class="fas fa-minus-circle color-orange"></i></a>
														</div>
														<p><strong>Text Book: </strong>Global Marketing, Chapter 1</p>
													</div>
													<div class="courses-box-content">
														<div class="btn-remove">
															<a href="javascript:void(0);" data-toggle="modal" data-target="#weekContentRemovePopup" data-backdrop="static" data-keyboard="false"><i class="fas fa-minus-circle color-orange"></i></a>
														</div>
														<p>Video: Introduction to COIL</p>
													</div> -->
												</div>
												<div>
													<div class="td-content-popupContent1"></div>
													<div class="td-content-popupContent1-input" style="display:none;">
														<div class='d-flex align-items-center form-group mb-1'>
															<a href='javascript::void(0);' class='color-orange font20 mr-1' onclick="hideInput('content','popupContent1')"><i class='fas fa-minus-circle fas-16'></i></a>
															<textarea class='input2 bg-grey-light border-none' onkeypress="return keyPressContent(event, 'popupContent1', this.value)"> Text Book: Global Ethics: An Introduction, Chapter 1</textarea>
														</div>
													</div>
												</div>
												<div class="courses-box-footer text-center">
													<!-- <a href="javascript:void(0);" class="weekPopup" data-title="Content" data-param="1" data-param-name="content"><i class="fas fa-plus-circle color-orange"></i></a> -->
													<a href="javascript:void(0)" class="add-content" data-content="popupContent1"><i class="fas fa-plus-circle color-orange"></i></a>
												</div>
											</div>
										</div>
									</div>
								</li>
								<li>
									<h5 class="bold mb-4 text-center color-white">Week 2</h5>
									<h6 class="color-white font-weight-bold	mb-3">Activity Table - Assign Weeks</h6>
									<div class="row">
										<div class="col-md-3">
											<div class="text-center bold mb-2 color-white">Course Objectives</div>
											<div id="week2CourseObjectives" class="course-box">
												<div class="courses-box-body">
													<!-- <div class="courses-box-content">
														<div class="btn-remove">
															<a href="javascript:void(0);" data-toggle="modal" data-target="#weekContentRemovePopup" data-backdrop="static" data-keyboard="false"><i class="fas fa-minus-circle color-orange"></i></a>
														</div>
														<p>Connect with a partner in another country and engage in conversations that result in a joint project that enhances student's intercultural competency skills and knowledge</p>
													</div> -->
												</div>
												<div class="courses-box-footer text-center">
													<!-- <a href="javascript:void(0);" class="weekPopup" data-title="Course Objective" data-param="2" data-param-name="courseObjective"><i class="fas fa-plus-circle color-orange"></i></a> -->
													<div class="dropdown tableDropdown">
													  <a class="dropdown-toggle" href="#" role="button" data-week="2" id="CourseObjectivepopup2Link" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
													  <div class="dropdown-menu CourseObjectiveValue" aria-labelledby="CourseObjectivepopup2Link"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-3">
											<div class="text-center bold mb-2 color-white">Learning Environment Design</div>
											<div id="week2LearningEnvironmentDesign" class="course-box">
												<div class="courses-box-body">
													<!-- <div class="courses-box-content">
														<div class="btn-remove">
															<a href="javascript:void(0);" data-toggle="modal" data-target="#weekContentRemovePopup" data-backdrop="static" data-keyboard="false"><i class="fas fa-minus-circle color-orange"></i></a>
														</div>
														<p>Synchronous Video Lecture</p>
													</div>
													<div class="courses-box-content">
														<div class="btn-remove">
															<a href="javascript:void(0);" data-toggle="modal" data-target="#weekContentRemovePopup" data-backdrop="static" data-keyboard="false"><i class="fas fa-minus-circle color-orange"></i></a>
														</div>
														<p>Independent Assignments</p>
													</div> -->
												</div>
												<div class="courses-box-footer text-center">
													<!-- <a href="javascript:void(0);" class="weekPopup" data-title="Learning Environment Design" data-param="2" data-param-name="learningEnvironment"><i class="fas fa-plus-circle color-orange"></i></a> -->
													<div class="dropdown tableDropdown">
													  <a class="dropdown-toggle" href="#" role="button" data-week="2" id="LearningEnvironmentpopup2Link" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
													  <div class="dropdown-menu LearningEnvironmentValue" aria-labelledby="LearningEnvironmentpopup2Link"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-3">
											<div class="text-center bold mb-2 color-white">Activity</div>
											<div id="week2Activity" class="course-box">
												<div class="courses-box-body">
													<!-- <div class="courses-box-content">
														<div class="btn-remove">
															<a href="javascript:void(0);" data-toggle="modal" data-target="#weekContentRemovePopup" data-backdrop="static" data-keyboard="false"><i class="fas fa-minus-circle color-orange"></i></a>
														</div>
														<p>Manager Superpower</p>
													</div>
													<div class="courses-box-content">
														<div class="btn-remove">
															<a href="javascript:void(0);" data-toggle="modal" data-target="#weekContentRemovePopup" data-backdrop="static" data-keyboard="false"><i class="fas fa-minus-circle color-orange"></i></a>
														</div>
														<p>Respond to Online Discussion Forum</p>
													</div> -->
												</div>
												<div>
													<div class="td-activity-popupActivity2"></div>
													<div class="td-activity-popupActivity2-input" style="display:none;">
														<div class='d-flex align-items-center form-group mb-1'>
															<a href='javascript::void(0);' class='color-orange font20 mr-1' onclick="hideInput('activity', 'popupActivity2')"><i class='fas fa-minus-circle fas-16'></i></a>
															<input type='text' value='Syllabus Review' class='input2 bg-grey-light border-none' onkeypress="return keyPressActivity(event, 'popupActivity2', this.value)">
														</div>
													</div>
												</div>
												<div class="courses-box-footer text-center">
													<!-- <a href="javascript:void(0);" class="weekPopup" data-title="Activity" data-param="2" data-param-name="activity"><i class="fas fa-plus-circle color-orange"></i></a> -->
													<a href="javascript:void(0)" class="add-activity" data-activity="popupActivity2"><i class="fas fa-plus-circle color-orange"></i></a>
												</div>
											</div>
										</div>
										<div class="col-md-3">
											<div class="text-center bold mb-2 color-white">Content</div>
											<div id="week2Content" class="course-box">
												<div class="courses-box-body">
													<!-- <div class="courses-box-content">
														<div class="btn-remove">
															<a href="javascript:void(0);" data-toggle="modal" data-target="#weekContentRemovePopup" data-backdrop="static" data-keyboard="false"><i class="fas fa-minus-circle color-orange"></i></a>
														</div>
														<p><strong>Text Book:</strong> Global Marketing, Chapter 2</p>
													</div> -->
												</div>
												<div>
													<div class="td-content-popupContent2"></div>
													<div class="td-content-popupContent2-input" style="display:none;">
														<div class='d-flex align-items-center form-group mb-1'>
															<a href='javascript::void(0);' class='color-orange font20 mr-1' onclick="hideInput('content','popupContent2')"><i class='fas fa-minus-circle fas-16'></i></a>
															<textarea class='input2 bg-grey-light border-none' onkeypress="return keyPressContent(event, 'popupContent2', this.value)"> Text Book: Global Ethics: An Introduction, Chapter 1</textarea>
														</div>
													</div>
												</div>
												<div class="courses-box-footer text-center">
													<!-- <a href="javascript:void(0);" class="weekPopup" data-title="Content" data-param="2" data-param-name="content"><i class="fas fa-plus-circle color-orange"></i></a>	 -->
													<a href="javascript:void(0)" class="add-content" data-content="popupContent2"><i class="fas fa-plus-circle color-orange"></i></a>
												</div>
											</div>
										</div>
									</div>
								</li>
								<li>
									<h5 class="bold mb-4 text-center color-white">Week 3</h5>
									<h6 class="color-white font-weight-bold	mb-3">Activity Table - Assign Weeks</h6>
									<div class="row">
										<div class="col-md-3">
											<div class="text-center bold mb-2 color-white">Course Objectives</div>
											<div id="week3CourseObjectives" class="course-box">
												<div class="courses-box-body">
													<!-- <div class="courses-box-content">
														<div class="btn-remove">
															<a href="javascript:void(0);" data-toggle="modal" data-target="#weekContentRemovePopup" data-backdrop="static" data-keyboard="false"><i class="fas fa-minus-circle color-orange"></i></a>
														</div>
														<p>Use online tools to develop business communication skills in a cross-cultural virtual team environment.</p>
													</div> -->
												</div>
												<div class="courses-box-footer text-center">
													<!-- <a href="javascript:void(0);" class="weekPopup" data-title="Course Objective" data-param="3" data-param-name="courseObjective"><i class="fas fa-plus-circle color-orange"></i></a> -->
													<div class="dropdown tableDropdown">
													  <a class="dropdown-toggle" href="#" role="button" data-week="3" id="CourseObjectivepopup3Link" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
													  <div class="dropdown-menu CourseObjectiveValue" aria-labelledby="CourseObjectivepopup3Link"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-3">
											<div class="text-center bold mb-2 color-white">Learning Environment Design</div>
											<div id="week3LearningEnvironmentDesign" class="course-box">
												<div class="courses-box-body">
													<!-- <div class="courses-box-content">
														<div class="btn-remove">
															<a href="javascript:void(0);" data-toggle="modal" data-target="#weekContentRemovePopup" data-backdrop="static" data-keyboard="false"><i class="fas fa-minus-circle color-orange"></i></a>
														</div>
														<p>Synchronous Video Lecture</p>
													</div>
													<div class="courses-box-content">
														<div class="btn-remove">
															<a href="javascript:void(0);" data-toggle="modal" data-target="#weekContentRemovePopup" data-backdrop="static" data-keyboard="false"><i class="fas fa-minus-circle color-orange"></i></a>
														</div>
														<p>Discussion Forum</p>
													</div> -->
												</div>
												<div class="courses-box-footer text-center">
													<!-- <a href="javascript:void(0);" class="weekPopup" data-title="Learning Environment Design" data-param="3" data-param-name="learningEnvironment"><i class="fas fa-plus-circle color-orange"></i></a> -->
													<div class="dropdown tableDropdown">
													  <a class="dropdown-toggle" href="#" role="button" data-week="3" id="LearningEnvironmentpopup3Link" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
													  <div class="dropdown-menu LearningEnvironmentValue" aria-labelledby="LearningEnvironmentpopup3Link"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-3">
											<div class="text-center bold mb-2 color-white">Activity</div>
											<div id="week3Activity" class="course-box">
												<div class="courses-box-body">
													<!-- <div class="courses-box-content">
														<div class="btn-remove">
															<a href="javascript:void(0);" data-toggle="modal" data-target="#weekContentRemovePopup" data-backdrop="static" data-keyboard="false"><i class="fas fa-minus-circle color-orange"></i></a>
														</div>
														<p>Manager Superpower</p>
													</div>
													<div class="courses-box-content">
														<div class="btn-remove">
															<a href="javascript:void(0);" data-toggle="modal" data-target="#weekContentRemovePopup" data-backdrop="static" data-keyboard="false"><i class="fas fa-minus-circle color-orange"></i></a>
														</div>
														<p>Respond to Online Discussion Forum</p>
													</div> -->
												</div>
												<div>
													<div class="td-activity-popupActivity3"></div>
													<div class="td-activity-popupActivity3-input" style="display:none;">
														<div class='d-flex align-items-center form-group mb-1'>
															<a href='javascript::void(0);' class='color-orange font20 mr-1' onclick="hideInput('activity', 'popupActivity3')"><i class='fas fa-minus-circle fas-16'></i></a>
															<input type='text' value='Syllabus Review' class='input2 bg-grey-light border-none' onkeypress="return keyPressActivity(event, 'popupActivity3', this.value)">
														</div>
													</div>
												</div>
												<div class="courses-box-footer text-center">
														<!-- <a href="javascript:void(0);" class="weekPopup" data-title="Activity" data-param="3" data-param-name="activity"><i class="fas fa-plus-circle color-orange"></i></a> -->
														<a href="javascript:void(0)" class="add-activity" data-activity="popupActivity3"><i class="fas fa-plus-circle color-orange"></i></a>
													</div>
											</div>
										</div>
										<div class="col-md-3">
											<div class="text-center bold mb-2 color-white">Content</div>
											<div id="week3Content" class="course-box">
												<div class="courses-box-body">
													<!-- <div class="courses-box-content">
														<div class="btn-remove">
															<a href="javascript:void(0);" data-toggle="modal" data-target="#weekContentRemovePopup" data-backdrop="static" data-keyboard="false"><i class="fas fa-minus-circle color-orange"></i></a>
														</div>
														<p><strong>Text Book:</strong> Global Marketing, Chapter 3</p>
													</div> -->
												</div>
												<div>
													<div class="td-content-popupContent3"></div>
													<div class="td-content-popupContent3-input" style="display:none;">
														<div class='d-flex align-items-center form-group mb-1'>
															<a href='javascript::void(0);' class='color-orange font20 mr-1' onclick="hideInput('content','popupContent3')"><i class='fas fa-minus-circle fas-16'></i></a>
															<textarea class='input2 bg-grey-light border-none' onkeypress="return keyPressContent(event, 'popupContent3', this.value)"> Text Book: Global Ethics: An Introduction, Chapter 1</textarea>
														</div>
													</div>
												</div>
												<div class="courses-box-footer text-center">
													<!-- <a href="javascript:void(0);" class="weekPopup" data-title="Content" data-param="3" data-param-name="content"><i class="fas fa-plus-circle color-orange"></i></a> -->
													<a href="javascript:void(0)" class="add-content" data-content="popupContent3"><i class="fas fa-plus-circle color-orange"></i></a>
												</div>
											</div>
										</div>
									</div>
								</li>
								<li>
									<h5 class="bold mb-4 text-center color-white">Week 4</h5>
									<h6 class="color-white font-weight-bold	mb-3">Activity Table - Assign Weeks</h6>
									<div class="row">
										<div class="col-md-3">
											<div class="text-center bold mb-2 color-white">Course Objectives</div>
											<div id="week4CourseObjectives" class="course-box">
												<div class="courses-box-body">
													<!-- <div class="courses-box-content">
														<div class="btn-remove">
															<a href="javascript:void(0);" data-toggle="modal" data-target="#weekContentRemovePopup" data-backdrop="static" data-keyboard="false"><i class="fas fa-minus-circle color-orange"></i></a>
														</div>
														<p>Use online tools to develop business communication skills in a cross-cultural virtual team environment.</p>
													</div> -->
												</div>
												<div class="courses-box-footer text-center">
													<!-- <a href="javascript:void(0);" class="weekPopup" data-title="Course Objective" data-param="4" data-param-name="courseObjective"><i class="fas fa-plus-circle color-orange"></i></a> -->
													<div class="dropdown tableDropdown">
													  <a class="dropdown-toggle" href="#" role="button" data-week="4" id="CourseObjectivepopup4Link" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
													  <div class="dropdown-menu CourseObjectiveValue" aria-labelledby="CourseObjectivepopup4Link"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-3">
											<div class="text-center bold mb-2 color-white">Learning Environment Design</div>
											<div id="week4LearningEnvironmentDesign" class="course-box">
												<div class="courses-box-body">
													<!-- <div class="courses-box-content">
														<div class="btn-remove">
															<a href="javascript:void(0);" data-toggle="modal" data-target="#weekContentRemovePopup" data-backdrop="static" data-keyboard="false"><i class="fas fa-minus-circle color-orange"></i></a>
														</div>
														<p>Synchronous Video Lecture</p>
													</div>
													<div class="courses-box-content">
														<div class="btn-remove">
															<a href="javascript:void(0);" data-toggle="modal" data-target="#weekContentRemovePopup" data-backdrop="static" data-keyboard="false"><i class="fas fa-minus-circle color-orange"></i></a>
														</div>
														<p>Discussion Forum</p>
													</div> -->
												</div>
												<div class="courses-box-footer text-center">
													<!-- <a href="javascript:void(0);" class="weekPopup" data-title="Learning Environment Design" data-param="4" data-param-name="learningEnvironment"><i class="fas fa-plus-circle color-orange"></i></a> -->
													<div class="dropdown tableDropdown">
													  <a class="dropdown-toggle" href="#" role="button" data-week="4" id="LearningEnvironmentpopup4Link" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
													  <div class="dropdown-menu LearningEnvironmentValue" aria-labelledby="LearningEnvironmentpopup4Link"></div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-3">
											<div class="text-center bold mb-2 color-white">Activity</div>
											<div id="week4Activity" class="course-box">
												<div class="courses-box-body">
													<!-- <div class="courses-box-content">
														<div class="btn-remove">
															<a href="javascript:void(0);" data-toggle="modal" data-target="#weekContentRemovePopup" data-backdrop="static" data-keyboard="false"><i class="fas fa-minus-circle color-orange"></i></a>
														</div>
														<p>Respond to Online Discussion Forum</p>
													</div> -->
												</div>
												<div>
													<div class="td-activity-popupActivity4"></div>
													<div class="td-activity-popupActivity4-input" style="display:none;">
														<div class='d-flex align-items-center form-group mb-1'>
															<a href='javascript::void(0);' class='color-orange font20 mr-1' onclick="hideInput('activity', 'popupActivity4')"><i class='fas fa-minus-circle fas-16'></i></a>
															<input type='text' value='Syllabus Review' class='input2 bg-grey-light border-none' onkeypress="return keyPressActivity(event, 'popupActivity4', this.value)">
														</div>
													</div>
												</div>
												<div class="courses-box-footer text-center">
													<!-- <a href="javascript:void(0);" class="weekPopup" data-title="Activity" data-param="4" data-param-name="activity"><i class="fas fa-plus-circle color-orange"></i></a> -->
													<a href="javascript:void(0)" class="add-activity" data-activity="popupActivity4"><i class="fas fa-plus-circle color-orange"></i></a>
												</div>
											</div>
										</div>
										<div class="col-md-3">
											<div class="text-center bold mb-2 color-white">Content</div>
											<div id="week4Content" class="course-box">
												<div class="courses-box-body">
													<!-- <div class="courses-box-content">
														<div class="btn-remove">
															<a href="javascript:void(0);" data-toggle="modal" data-target="#weekContentRemovePopup" data-backdrop="static" data-keyboard="false"><i class="fas fa-minus-circle color-orange"></i></a>
														</div>
														<p><strong>Text Book:</strong> Global Marketing, Chapter 4</p>
													</div> -->
												</div>
												<div>
													<div class="td-content-popupContent4"></div>
													<div class="td-content-popupContent4-input" style="display:none;">
														<div class='d-flex align-items-center form-group mb-1'>
															<a href='javascript::void(0);' class='color-orange font20 mr-1' onclick="hideInput('content','popupContent4')"><i class='fas fa-minus-circle fas-16'></i></a>
															<textarea class='input2 bg-grey-light border-none' onkeypress="return keyPressContent(event, 'popupContent4', this.value)"> Text Book: Global Ethics: An Introduction, Chapter 1</textarea>
														</div>
													</div>
												</div>
												<div class="courses-box-footer text-center">
													<!-- <a href="javascript:void(0);" class="weekPopup" data-title="Content" data-param="4" data-param-name="content"><i class="fas fa-plus-circle color-orange"></i></a> -->
													<a href="javascript:void(0)" class="add-content" data-content="popupContent4"><i class="fas fa-plus-circle color-orange"></i></a>
												</div>
											</div>
										</div>
									</div>
								</li>
							</ul>
						</div>
					</div>
				</div>

				<div class="row mt-5">
					<div class="col-md-12">
						<div class="float-left">
							<a href='javascript:void(0);' class="btn btn-blue">Learn more</a>
						</div>
						<div class="float-right d-flex">
							<button class="btn btn-grey mr-2" data-dismiss="modal">Cancel</button>
							<a href='javascript:void(0);' class="btn btn-blue mr-2" onclick="weekPopupClose()"> Save</a>
							<!-- <a href='javascript:void(0);' class="btn btn-blue">Complete</a> -->
						</div>
					</div>
				</div>
			</div>
        </div>
    </div>
  </div>
</div>


<!-- Modal Course Design -->
<div class="modal fade modalToltip modalareainterest" id="modalCourseDesign" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-800" role="document">
	  <div id="modalCourseDesignContent" class="modal-content">
		
	  </div>
	</div>
  </div>
  
<!-- Modal Course Summary -->
<div class="modal fade modalToltip modalareainterest" id="openCourseSummary" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
	  <div id="modalCourseSummaryContent" class="modal-content">
	  	<div class="modal-header position-relative text-center">
			<div class="text-left font15 m-auto">
				<strong>Course Summary</strong> 
			</div> 
		</div>
		<div class='modal-body'> 
			<div class='interest-modal'>
			<form name='courseSummaryForm' id='courseSummaryForm'>
				<input type="hidden" id="summary_courseIdentificationsId" name="summary_courseIdentificationsId" value="0" class="wrap-input input form-control">
				<input type="hidden" id="summary_courseHoursId" name="summary_courseHoursId" value="0" class="wrap-input input form-control">
				<input type="hidden" id="summary_courseResourcesId" name="summary_courseResourcesId" value="0" class="wrap-input input form-control">
				<input type="hidden" id="summary_instructorQualificationsFormId" name="summary_instructorQualificationsFormId" value="0" class="wrap-input input form-control">
				<div class="form-group row">
					<label class="col-md-4 control-label" for="courseTitle">Course Title</label>
					<div class="col-md-8">
						<input type="text" id="summary_courseTitle" name="summary_courseTitle" value="Ethics in Multi-National Management" class="wrap-input input form-control" required="true">
					</div> 
				</div>
				<div class="form-group row">
					<label class="col-md-4 control-label" for="courseNumber">Course Number</label>
					<div class="col-md-8">
						<input type="text" id="summary_courseNumber" name="summary_courseNumber" value="BUS 131" class="wrap-input input form-control" required="true">
					</div> 
				</div>
				<div class="form-group row">
					<label class="col-md-4 control-label" for="prerequisites">Prerequisites</label>
					<div class="col-md-8">
						<input type="text" id="summary_prerequisites" name="summary_prerequisites" value="None" class="wrap-input input form-control" required="true">
					</div> 
				</div>
				<div class="form-group row">
					<label class="col-md-4 control-label" for="creditHours">Credit Hours</label>
					<div class="col-md-8">
						<input type="text" id="summary_creditHours" name="summary_creditHours" value="3.0 Semester Credit Hours" class="wrap-input input form-control" required="true">
					</div> 
				</div>
				<div class="form-group row">
					<label class="col-md-4 control-label" for="contactHours">Contact Hours</label>
					<div class="col-md-8">
						<input type="number" id="summary_contactHours" name="summary_contactHours" value="48" class="wrap-input input form-control" required="true">
					</div> 
				</div>
				<div class="form-group row">
					<label class="col-md-4 control-label" for="lectureHours">Lecture Hours</label>
					<div class="col-md-8">
						<input type="number" id="summary_lectureHours" name="summary_lectureHours" value="45" class="wrap-input input form-control" required="true">
					</div> 
				</div>
				<div class="form-group row">
					<label class="col-md-4 control-label" for="laboratoryHours">Laboratory Hours</label>
					<div class="col-md-8">
						<input type="number" id="summary_laboratoryHours" name="summary_laboratoryHours" value="3" class="wrap-input input form-control" required="true">
					</div> 
				</div>
				<div class="form-group row">
					<label class="col-md-4 control-label" for="textbookTitle">Textbook Title</label>
					<div class="col-md-8">
						<input type="text" id="summary_textbookTitle" name="summary_textbookTitle" value="Global Marketing: Foreign Entry, Local Marketing, and Global Management" class="wrap-input input form-control" required="true">
					</div> 
				</div>
				<div class="form-group row">
					<label class="col-md-4 control-label" for="publisherName">Publisher's Name</label>
					<div class="col-md-8">
						<input type="text" id="summary_publisherName" name="summary_publisherName" value="McGraw Hill / Irwin" class="wrap-input input form-control" required="true">
					</div> 
				</div>
				<div class="form-group row">
					<label class="col-md-4 control-label" for="authors">Authors</label>
					<div class="col-md-8">
						<input type="text" id="summary_authors" name="summary_authors" value="Johny Johanasson" class="wrap-input input form-control" required="true">
					</div> 
				</div>
				<div class="form-group row">
					<label class="col-md-4 control-label" for="ISBN">ISBN</label>
					<div class="col-md-8">
						<input type="number" id="summary_ISBN" name="summary_ISBN" value="0073381012" class="wrap-input input form-control" required="true">
					</div> 
				</div>
				<div class="form-group row">
					<label class="col-md-4 control-label" for="instructor1Qualifications">Instructor 1 Qualifications</label>
					<div class="col-md-8">
						<textarea id="summary_instructor1Qualifications" name="summary_instructor1Qualifications" value="" class="wrap-input input form-control" required="true">
							Earned Master's Degree in Business Administration and 5-10 years of experience in private sector business management
						</textarea>
					</div> 
				</div>
				<div class="form-group row">
					<label class="col-md-4 control-label" for="instructor2Qualifications">Instructor 2 Qualifications</label>
					<div class="col-md-8">
						<textarea id="summary_instructor2Qualifications" name="summary_instructor2Qualifications" value="" class="wrap-input input form-control" required="true">
							Earned Masters/Doctorate in Social Sciences (Sociology, Anthropology, Economics)
						</textarea>
					</div> 
				</div>
				<div class="form-group row">
					<label class="col-md-4 control-label" for="courseDescription">Course Description</label>
					<div class="col-md-8">
						<textarea id="summary_courseDescription" name="summary_courseDescription" value="" class="wrap-input input form-control" required="true">
							Management and Cultural Influences is part of the course you are currently enrolled in. This course will provide you with the opportunity to gain international business experience. You will have a real multicultural experience by working with students in other countries and cultures. Using technology, you will work in cross cultural teams to explore and analyze management issues such as, leadership, decision making, and employee problems.
						</textarea>
					</div> 
				</div>
				<div class="form-group row">
					<label class="col-md-4 control-label" for="courseTopics">Course Topics</label>
					<div class="col-md-8 ">
						<ol class="pl-15">
						    <li>
						        Management Qualities <a href='javascript:void(0);' class="color-white"><i class="fas fa-edit" aria-hidden="true"></i></a>
						    </li>
						    <li>
						        Management Decisions <a href='javascript:void(0);' class="color-white"><i class="fas fa-edit" aria-hidden="true"></i></a>
						    </li>
						    <li>
						        Management Analysis <a href='javascript:void(0);' class="color-white"><i class="fas fa-edit" aria-hidden="true"></i></a>
						    </li>
						    <li>
						        Analysis of Management Cultures and Decisions <a href='javascript:void(0);' class="color-white"><i class="fas fa-edit" aria-hidden="true"></i></a>
						    </li>
						    <li>
						        Cross-Cultural Product Analysis and Advertising <a href='javascript:void(0);' class="color-white"><i class="fas fa-edit" aria-hidden="true"></i></a>
						    </li>
						</ol>

					</div> 
				</div>
				<div class="form-group row">
					<label class="col-md-4 control-label" for="courseObjectives">Course Objectives</label>
					<div class="col-md-8">
						<ol class="pl-15">
						    <li>
						        Connect with a partner in another country and engage in conversations that results in a joint project that enhances student's intercultural competency skills and knowledge.
						        <a href='javascript:void(0);' class="color-white"><i class="fas fa-edit"></i></a>
						    </li>
						    <li>
						        Use online tools to develop global business communication skills in cross-cultural virtual team environment. <a href='javascript:void(0);' class="color-white"><i class="fas fa-edit"></i></a>
						    </li>
						    <li>
						        Use case studies, understand similarities and differences in how management issues may be handled in different cultures. <a href='javascript:void(0);' class="color-white"><i class="fas fa-edit"></i></a>
						    </li>
						</ol>
					</div> 
				</div>
				<div class="form-group row">
					<label class="col-md-4 control-label" for="learningEnvironments">Learning Environments</label>
					<div class="col-md-8">
						<ol class="pl-15">
						    <li>
						        Synchronous Video Lecture <a href='javascript:void(0);' class="color-white"><i class="fas fa-edit"></i></a>
						    </li>
						    <li>
						        Independent Assignments <a href='javascript:void(0);' class="color-white"><i class="fas fa-edit"></i></a>
						    </li>
						    <li>
						        Group Assignments <a href='javascript:void(0);' class="color-white"><i class="fas fa-edit"></i></a>
						    </li>
						</ol>
					</div> 
				</div>
				<div class="text-right">
					<button value='Cancel' class='btn btn-grey mr-2' data-dismiss='modal' type='reset' onclick='clearModal()'>Cancel</button>
					<button value='Save' type='submit' class='btn btn-blue' onclick="courseSummaryAddEdit()">Save</button>
				</div>
			</form>
			</div>
		</div>
	  </div>
	</div>
  </div>
  

<!-- Modal Week -->
<div class="modal fade modalToltip modalareainterest" id="weekPopup" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
	  <div id="modalCourseSummaryContent" class="modal-content">
	  	<div class="modal-header position-relative text-center">
			<div class="text-left font15">
				<strong class="weekTitle">Course Summary</strong> 
			</div> 
			<div class="toltip-close">
				<button type="button" class="close" data-dismiss="modal"><i class="fa fa-times-circle"></i></button>
			</div>
		</div>
		<div class='modal-body'> 
			<div class='interest-modal'>
			<aui:form name='weekForm' id='weekForm' onSubmit="event.preventDefault();saveActivityTable();">
				<aui:input type="hidden" name="selectedKey" value="0" cssClass="input" />
				<aui:input type="hidden" name="selectedWeek" value="" cssClass="input" />
				<aui:input type="hidden" name="selectedParam" value="" cssClass="input" />
				<aui:input type="textarea" name="" label="" rows="6" value="" cssClass="input" id="input-dynamic-name"/>
				<div class="text-right">
					<aui:button value="Cancel" type="reset"  cssClass="btn btn-grey btn-w-100 mr-2" data-dismiss="modal"></aui:button>
					<aui:button value="Save" type="submit"  cssClass="btn btn-blue btn-w-100"></aui:button>
				</div>	
			</aui:form>
			</div>
		</div>
		</div>
	</div>
</div>

<!-- Modal Week -->
<div class="modal fade modalToltip modalareainterest" id="weekContentRemovePopup" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
	  <div id="modalCourseSummaryContent" class="modal-content">
	  	<div class="modal-header position-relative text-center">
			<div class="text-left font15 m-auto">
				<strong class="weekTitle">Message</strong> 
			</div> 
		</div>
		<div class='modal-body'> 
			<div class='interest-modal'>
				<p class="text-center text-white">Are You sure, you want to remove?</p>
				<input type="hidden" name="contentRemovePopup" value="0" id="contentRemovePopup" />
				<!-- <input type="hidden" name="contentRemovePopupType" value="" id="contentRemovePopupType" />  -->
				<div class="text-right w-100">
					<button type='button' class='btn btn-blue' data-dismiss="modal" onclick="cancelContent()">Cancel</button>
					<button type='button' class='btn btn-blue' onclick="removeContent()">Ok</button>
				</div>	
			</div>
		</div>
		</div>
	</div>
</div>
		

<!-- JAVASCRIPT FOR DONUT CHART -->
<!-- <script type="text/javascript"> 
	
	 var canvas = document.getElementById("donut");
	canvas.width = 140;
	canvas.height = 140;
	var percentage = "0";
	var colorDonut = "#000000";
	var fontSizeText = (parseInt(canvas.width)/4)+"px";

	jQuery("#donut1 .text").html(percentage+"%").css("color",colorDonut).css("font-size", fontSizeText).css("font-family","arial");

	var donutEl = document.getElementById("donut").getContext("2d");

	var donut = new Chart(donutEl).Doughnut(
	// Datas
	[
		{
			value: parseInt(percentage),
			color:colorDonut,//green
			highlight: "#FF5A5E",
			label: "Red"
		},
		{
			value: (parseInt(100) - parseInt(percentage)),
			color: "#e6e6e6",//grey
			highlight: "#5AD3D1",
			label: "Green"
		}
	],
	// Options
	{
		segmentShowStroke : true,
		segmentStrokeColor : "#fff",
		segmentStrokeWidth : 2,
		percentageInnerCutout : 70,
		animationSteps : 100,
		//animationEasing : "easeOutBounce",
		//animateRotate : true,
		//animateScale : false,
		responsive: true,
		maintainAspectRatio: true

	}); */
	

</script> -->
								