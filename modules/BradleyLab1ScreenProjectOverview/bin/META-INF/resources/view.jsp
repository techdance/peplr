<%@page import="com.collaborated.entity.service.labScreenProjectOverviewLocalServiceUtil"%>
<%@page import="com.collaborated.entity.model.labScreenProjectOverview"%>
<%@page import="javax.portlet.PortletSession"%>
<%@ include file="/init.jsp" %>

<nav aria-label="breadcrumb">
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="#">Home</a></li>
		<li class="breadcrumb-item">My Projects</li>
		<li class="breadcrumb-item active" aria-current="page">Ethics in Multinational Management</li>
	</ol>
</nav>
<div class="box box-border-radius box-shadow bg-white block-top">
    <div class="inner-wrap mb-7">
        <div class="box-top position-relative">
            <h3 class="box-subhead"><i class="fas fa-binoculars"></i> Project Overview</h3>
            <a href="#" class="icon-setting icon-box"><i class="fas fa-cog"></i></a>
        </div>
        <div class="box-middle text1 d-flex">
            <div class="box-middle-inner">
                <h4>Name: <span style="font-weight: normal;"><%=projectName %></span></h4>
                <h5>Description</h5>
                <p><%=description %></p>
            </div>
            <a href="#" id="donut_status">
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
    <div id="CourseInfo" class="wrap-course-information d-none">
        <div class="nav nav-tabs wrap-step mb-4">
            <a data-toggle="tab" href="#step-1" class="nav-item nav-link active step step-current bar-progress button-blue-init mr--15">
                <span>
                	<i class="fa fa-check  mr-1" aria-hidden="true"></i>
                	Course Information
                </span>
            </a>
            <a data-toggle="tab" href="#step-2" class="step bar-progress button-lead mr--15">
                <span>
                	<i class="fa fa-check  mr-1" aria-hidden="true"></i>
                	Course Design
                </span>
            </a>
            <a data-toggle="tab" href="#step-3" class="step bar-progress button-lead mr--15">
                <span>
                	<i class="fa fa-check  mr-1" aria-hidden="true"></i>
                	Activity Table
                </span>
            </a>
            <a data-toggle="tab" href="#step-4" class="bar-progress button-lead-2">
                <span>
                	<i class="fa fa-check  mr-1" aria-hidden="true"></i>
                	Couse Summary
                </span>
            </a>
        </div>
        <div class="tab-content p-0">
            <div class="tab-pane fade show active" id="step-1">
                <div class="course-information-define d-flex justify-content-between align-items-center mb-4">
                    <div>Course Information: Define the basics of the course using the tools below.</div>
                    <a href="#" class="btn btn-grey btn-w-100">Complete Milestone <i class="far fa-arrow-alt-circle-right"></i></a>
                </div>

                <div class="table-course mb-4">
                    <table class="table table3 table-border table-border-radius table-color-black table-tbody-tr-border-bottom td-nothover">
                        <thead>
                            <tr class="th-bg">
                                <th class="td-left" width="30%">Course Identification</th>
                                <th class="td-right"><a href="#"><i class="fas fa-edit"></i></a></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><strong>Course Title:</strong></td>
                                <td>Ethics in Multi-National Management</td>
                            </tr>
                            <tr>
                                <td><strong>Course Number:</strong></td>
                                <td>BUS 131</td>
                            </tr>
                            <tr>
                                <td><strong>Prerequisites:</strong></td>
                                <td>None</td>
                            </tr>
                            <tr>
                                <td class="vertical-align-top"><strong>Course Description:</strong></td>
                                <td>Management and Cultural Influences is part of the course you are currently enrolled in. This course will provide you with the opportunity to gain international business experience. You will have a real multicultural experience by working with students in other countries and cultures. Using technology, you will work in cross cultural teams to explore and analyze management issues such as, leadership, decision making, and employee problems.</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="table-course mb-4">
                    <table class="table table3 table-border table-border-radius table-color-black table-tbody-tr-border-bottom td-nothover">
                        <thead>
                            <tr class="th-bg">
                                <th class="td-left" width="30%">Course Hours</th>
                                <th class="td-right"><a href="#" data-toggle="modal" data-target="#addTask"><i class="fas fa-edit"></i></a></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><strong>Credito Hours:</strong></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td><strong>Contact Hours:</strong></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td><strong>Lecture Hours:</strong></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td><strong>Laboratory Hours:</strong></td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="table-course mb-4">
                    <table class="table table3 table-border table-border-radius table-color-black table-tbody-tr-border-bottom td-nothover">
                        <thead>
                            <tr class="th-bg">
                                <th class="td-left" width="30%">Course Resources</th>
                                <th class="td-right"><a href="#"><i class="fas fa-edit"></i></a></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><strong>Textbook Title:</strong></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td><strong>Publisher's Name:</strong></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td><strong>Author:</strong></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td><strong>ISBN:</strong></td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="table-course">
                    <table class="table table3 table-border table-border-radius table-color-black table-tbody-tr-border-bottom td-nothover">
                        <thead>
                            <tr class="th-bg">
                                <th class="td-left" width="30%">Instructor Quanlifications</th>
                                <th class="td-right"><a href="#"><i class="fas fa-edit"></i></a></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><strong>Instructor 1 Qualifications:</strong></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td><strong>Instructor 2 Qualifications:</strong></td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="tab-pane fade" id="step-2">
                <div class="course-information-define d-flex justify-content-between align-items-center mb-4">
                    <div>Course Design: Begin defining the basic details of the course. Topics covered, course objectives, and learning environments.</div>
                    <a href="#" class="btn btn-green btn-w-100">Complete Milestone <i class="far fa-arrow-alt-circle-right"></i></a>
                </div>

                <div class="table-course mb-4">
                    <table class="table table3 table-border table-border-radius table-color-black table-tbody-tr-border-bottom td-nothover">
                        <thead>
                            <tr class="th-bg">
                                <th class="td-left" width="30%">Course Topics</th>
                                <th class="td-right"><a href="#"><i class="fas fa-edit"></i></a></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td width="25%"></td>
                                <td>1. Management Qualities </td>
                            </tr>
                            <tr>
                                <td width="25%"></td>
                                <td>2. Management Decisions </td>
                            </tr>
                            <tr>
                                <td width="25%"></td>
                                <td>3. Management Analysis </td>
                            </tr>
                            <tr>
                                <td width="25%"></td>
                                <td>4. Analysis of Management Cultures and Decisions </td>
                            </tr>
                            <tr>
                                <td width="25%"></td>
                                <td>5. Cross-Cultural Product Analysis and Advertising </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="table-course mb-4">
                    <table class="table table3 table-border table-border-radius table-color-black table-tbody-tr-border-bottom td-nothover">
                        <thead>
                            <tr class="th-bg">
                                <th class="td-left" width="30%">Course Objetives</th>
                                <th class="td-right"><a href="#" data-toggle="modal" data-target="#addTask"><i class="fas fa-edit"></i></a></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td width="25%"></td>
                                <td>1. Connect with a partner in another country and engage in conversations that result in a joint project that enhances student's intercultural competency skills and knowledge </td>
                            </tr>
                            <tr>
                                <td width="25%"></td>
                                <td>2. Use online tools to develop global business communication skills in a cross-cultural virtual team environment</td>
                            </tr>
                            <tr>
                                <td width="25%"></td>
                                <td>3. Use case studies to understand similarities and differences in how management issues may be handled different cultures</td>
                            </tr>

                        </tbody>
                    </table>
                </div>
                <div class="table-course mb-4">
                    <table class="table table3 table-border table-border-radius table-color-black table-tbody-tr-border-bottom td-nothover">
                        <thead>
                            <tr class="th-bg">
                                <th class="td-left" width="30%">Learning Environment</th>
                                <th class="td-right"><a href="#"><i class="fas fa-edit"></i></a></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td width="25%"></td>
                                <td>Synchronous Video Lecture </td>
                            </tr>
                            <tr>
                                <td width="25%"></td>
                                <td>Independent Assignments </td>
                            </tr>
                            <tr>
                                <td width="25%"></td>
                                <td>Group Assignments</td>
                            </tr>
                        </tbody>
                    </table>
                </div>

            </div>
            <div class="tab-pane fade" id="step-3">
                <div class="course-information-define d-flex justify-content-between align-items-center mb-4">
                    <div>Activity Table: Define the details for each week.</div>
                    <a href="#" class="btn btn-grey btn-w-100">Complete Milestone <i class="far fa-arrow-alt-circle-right"></i></a>
                </div>

                <div class="table-course mb-4">
                    <table class="table table3 table-border table-border-radius table-color-black table-tbody-tr-border-bottom td-nothover">
                        <thead>
                            <tr class="th-bg">
                                <th class="td-left color-blue" width="30%">Week #1</th>
                                <th class="td-right" colspan="3"><a href="#"><i class="fas fa-edit"></i></a></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td align="center"><strong>Course Objective</strong></td>
                                <td align="center"><strong>Learning Environment Design</strong></td>
                                <td align="center"><strong>Activity</strong></td>
                                <td align="center"><strong>Content</strong></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td align="center"><a href="#"><i class="fas fa-plus-circle color-orange"></i></a></td>
                                <td align="center"><a href="#"><i class="fas fa-plus-circle color-orange"></i></a></td>
                                <td align="center"><a href="#"><i class="fas fa-plus-circle color-orange"></i></a></td>
                                <td align="center"><a href="#"><i class="fas fa-plus-circle color-orange"></i></a></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="table-course mb-4">
                    <table class="table table3 table-border table-border-radius table-color-black table-tbody-tr-border-bottom td-nothover">
                        <thead>
                            <tr class="th-bg">
                                <th class="td-left color-blue" width="30%">Week #2</th>
                                <th class="td-right" colspan="3"><a href="#"><i class="fas fa-edit"></i></a></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td align="center"><strong>Course Objective</strong></td>
                                <td align="center"><strong>Learning Environment Design</strong></td>
                                <td align="center"><strong>Activity</strong></td>
                                <td align="center"><strong>Content</strong></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td align="center"><a href="#"><i class="fas fa-plus-circle color-orange"></i></a></td>
                                <td align="center"><a href="#"><i class="fas fa-plus-circle color-orange"></i></a></td>
                                <td align="center"><a href="#"><i class="fas fa-plus-circle color-orange"></i></a></td>
                                <td align="center"><a href="#"><i class="fas fa-plus-circle color-orange"></i></a></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="table-course mb-4">
                    <table class="table table3 table-border table-border-radius table-color-black table-tbody-tr-border-bottom td-nothover">
                        <thead>
                            <tr class="th-bg">
                                <th class="td-left color-blue" width="30%">Week #3</th>
                                <th class="td-right" colspan="3"><a href="#"><i class="fas fa-edit"></i></a></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td align="center"><strong>Course Objective</strong></td>
                                <td align="center"><strong>Learning Environment Design</strong></td>
                                <td align="center"><strong>Activity</strong></td>
                                <td align="center"><strong>Content</strong></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td align="center"><a href="#"><i class="fas fa-plus-circle color-orange"></i></a></td>
                                <td align="center"><a href="#"><i class="fas fa-plus-circle color-orange"></i></a></td>
                                <td align="center"><a href="#"><i class="fas fa-plus-circle color-orange"></i></a></td>
                                <td align="center"><a href="#"><i class="fas fa-plus-circle color-orange"></i></a></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="table-course mb-4">
                    <table class="table table3 table-border table-border-radius table-color-black table-tbody-tr-border-bottom td-nothover">
                        <thead>
                            <tr class="th-bg">
                                <th class="td-left color-blue" width="30%">Week #4</th>
                                <th class="td-right" colspan="3"><a href="#"><i class="fas fa-edit"></i></a></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td align="center"><strong>Course Objective</strong></td>
                                <td align="center"><strong>Learning Environment Design</strong></td>
                                <td align="center"><strong>Activity</strong></td>
                                <td align="center"><strong>Content</strong></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td align="center"><a href="#"><i class="fas fa-plus-circle color-orange"></i></a></td>
                                <td align="center"><a href="#"><i class="fas fa-plus-circle color-orange"></i></a></td>
                                <td align="center"><a href="#"><i class="fas fa-plus-circle color-orange"></i></a></td>
                                <td align="center"><a href="#"><i class="fas fa-plus-circle color-orange"></i></a></td>
                            </tr>
                        </tbody>
                    </table>
                </div>

            </div>
            <div class="tab-pane fade" id="step-4">
                <div class="mb-4">
                    <a href="#" class="btn btn-blue btn-w-100 mr-1">Export Syllabus</a>
                    <a href="#" class="btn btn-blue btn-w-100 mr-1">Export Course Control Document</a>
                    <a href="#" class="btn btn-blue btn-w-100">Export To BlendED</a>
                </div>

                <div class="table-course">
                    <table class="table table3 table-border table-border-radius table-color-black table-tbody-tr-border-bottom td-nothover">
                        <thead>
                            <tr class="th-bg">
                                <th class="td-left color-blue" width="30%">Course Identification</th>
                                <th class="td-right"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><strong>Course Title:</strong></td>
                                <td>Ethics in Multi-National Management</td>
                            </tr>
                            <tr>
                                <td><strong>Course Number:</strong></td>
                                <td>BUS 131</td>
                            </tr>
                            <tr>
                                <td><strong>Prerequisites:</strong></td>
                                <td>None</td>
                            </tr>
                            <tr>
                                <td class="vertical-align-top"><strong>Credit Hours:</strong></td>
                                <td>3.0 Semester Credit Hours</td>
                            </tr>
                            <tr>
                                <td class="vertical-align-top"><strong>Contact Hours:</strong></td>
                                <td>48</td>
                            </tr>
                            <tr>
                                <td class="vertical-align-top"><strong>Lecture Hours:</strong></td>
                                <td>45</td>
                            </tr>
                            <tr>
                                <td class="vertical-align-top"><strong>Laboratory Hours:</strong></td>
                                <td>3</td>
                            </tr>
                            <tr>
                                <td class="vertical-align-top"><strong>Textbook Title: </strong></td>
                                <td>Global Marketing: Foreign Entry, Local Marketing, and Global Management</td>
                            </tr>
                            <tr>
                                <td class="vertical-align-top"><strong>Publisher's Name:</strong></td>
                                <td>McGraw Hill / Irwin</td>
                            </tr>
                            <tr>
                                <td class="vertical-align-top"><strong>Authors:</strong></td>
                                <td>Johny Johanasson
                                </td>
                            </tr>
                            <tr>
                                <td class="vertical-align-top"><strong>ISBN:</strong></td>
                                <td>0073381012</td>
                            </tr>
                            <tr>
                                <td class="vertical-align-top"><strong>Instructor 1 Qualifications:</strong></td>
                                <td>Earned Master's Degree in Business Administration and 5-10 years of experience in private sector business management</td>
                            </tr>
                            <tr>
                                <td class="vertical-align-top"><strong>Instructor 2 Qualifications:</strong></td>
                                <td>Earned Masters/Doctorate in Social Sciences (Sociology, Anthropology, Economics)</td>
                            </tr>
                            <tr>
                                <td class="vertical-align-top"><strong>Course Description:</strong></td>
                                <td>Management and Cultural Influences is part of the course you are currently enrolled in. This course will provide you with the opportunity to gain international business experience. You will have a real multicultural experience by working with students in other countries and cultures. Using technology, you will work in cross cultural teams to explore and analyze management issues such as, leadership, decision making, and employee problems.</td>
                            </tr>
                            <tr>
                                <td class="vertical-align-top"><strong>Course Topics:</strong></td>
                                <td class="list-no-padding">
                                    <ol>
                                        <li>Management Qualities</li>
                                        <li>Management Decisions </li>
                                        <li>Management Analysis</li>
                                        <li>Analysis of Management Cultures and Decisions</li>
                                        <li>Cross-Cultural Product Analysis and Advertising</li>
                                    </ol>
                                </td>
                            </tr>
                            <tr>
                                <td class="vertical-align-top"><strong>Course Objectives:</strong></td>
                                <td class="list-no-padding">
                                    <ol>
                                        <li>Connect with a partner in another country and engage in conversations that result in a joint project that enhances student's intercultural competency skills and knowledge</li>
                                        <li>Use online tools to develop global business communication skills in cross-cultural virtual team environment</li>
                                        <li>Use case studies to understand similarities and differences in how management issues may be handled in different cultures</li>
                                    </ol>
                                </td>
                            </tr>
                            <tr>
                                <td class="vertical-align-top"><strong>Learning Environments</strong></td>
                                <td class="list-no-padding">
                                    <ol>
                                        <li>Synchronous Video Lecture </li>
                                        <li>Independent Assignments</li>
                                        <li>Group Assignments</li>
                                    </ol>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
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

<!-- JAVASCRIPT FOR DONUT CHART -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/0.2.0/Chart.min.js"></script>
<script type="text/javascript">

	/* var canvas = document.getElementById("donut");
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
	

</script>
								