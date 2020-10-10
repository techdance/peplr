<div class="ahea-my-projects" id="main-content" role="main">
	<div class="portlet-layout row row-custom">
		<div class="col-md-12 portlet-column portlet-column-only" id="column-1">
			${processor.processColumn("column-1", "portlet-column-content portlet-column-content-only")}
		</div>
	</div>
	<div class="portlet-layout row">
		<div class="col-lg-9 portlet-column portlet-column-first mb-4" id="column-2">
			${processor.processColumn("column-2", "portlet-column-content ")}
		</div>
		<div class="col-lg-3 mb-4 rightSideContentPP">
			<div class="portlet-layout row">
				<div class="col-lg-12 portlet-column portlet-column-first" id="column-3">
					${processor.processColumn("column-3", "portlet-column-content ")}
				</div>
				<div class="col-lg-12 portlet-column portlet-column-last" id="column-4">
					${processor.processColumn("column-4", "portlet-column-content portlet-column-content-last")}
				</div>
			</div>
		</div>
	</div>
</div>
