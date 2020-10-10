<%@ include file="/init.jsp" %>

<!-- <p>
	<b><liferay-ui:message key="MyProjects.caption"/></b>
</p>-->
<nav aria-label="breadcrumb">
	<ol class="breadcrumb">
	  <li class="breadcrumb-item"><a href="/home1">Home</a></li>
	  <li class="breadcrumb-item active" aria-current="page">My Projects</li>
	</ol>
</nav>
<section class="wrap-best-practices position-relative">
	<!-- Loader -->
	<div id="myProjectLoader" class="sectionloader"> 
		<div class="loader"></div>
	</div>
	<div class="row row-custom sortable">
		<div class="col-lg-12 mb-4">
			<div class="resources box box-border-radius box-shadow bg-white">
				<div class="inner-wrap">
					<div class="box-top position-relative">
						<h2 class="box-subhead mw-100"><i class="fal fa-book"></i><a href="#" class="color-black hover-underline color-blue-light-hover">My Projects</a></h2>
					</div>
				</div>
				<div class="box-middle">

					<ul class="nav nav-tabs" id="tabs" role="tablist">
						<li class="nav-item">
						<a class="nav-link active" id="projects-tab" data-toggle="tab" href="#projects" role="tab" aria-controls="projects" aria-selected="true">Projects</a>
						</li>
						<li class="nav-item">
						<a class="nav-link" id="tasks-tab" data-toggle="tab" href="#tasks" role="tab" aria-controls="tasks" aria-selected="false">Tasks</a>
						</li>

					</ul>
					<div class="tab-content" id="myTabContent">
						<div class="tab-pane fade show active" id="projects" role="tabpanel" aria-labelledby="projects-tab">

							<ul class="nav nav-tabs nav-tabs-whithout-style" role="tablist">
								<li class="nav-item">
								<a class="nav-link active" id="progress-tab" data-toggle="tab" href="#progress" role="tab" aria-controls="progress" aria-selected="true">In Progress</a>
								</li>
								<li class="nav-item">
								<a class="nav-link" id="past-tab" data-toggle="tab" href="#past" role="tab" aria-controls="past" aria-selected="false">Past</a>
								</li>

							</ul>
							<div class="tab-content" id="myTabContent">
								<div class="tab-pane fade show active" id="progress" role="tabpanel" aria-labelledby="progress-tab">
									<div class="row templateProgress">										
									</div>
								</div>
								<div class="tab-pane fade" id="past" role="tabpanel" aria-labelledby="past-tab">
									<div class="row templatePast">										
									</div>
								</div>
							</div>

						</div>
						<div class="tab-pane fade" id="tasks" role="tabpanel" aria-labelledby="tasks-tab">
							<table class="table">
								<thead>
									<tr>
										<th></th>
										<th class="al">Project</th>
										<th class="al">Title</th>
										<th class="al">Due Date</th>
									</tr>
								</thead>
								<tbody class="templateTasks">									
								</tbody>
							</table>
						</div>

					</div>

				</div>
			</div>
		</div><!--col-lg-4-->

	</div><!-- row -->
</section>

