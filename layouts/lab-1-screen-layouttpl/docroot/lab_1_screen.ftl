<div class="lab-1-screen" id="main-content" role="main">
	<div class="portlet-layout row">
		<div class="col-lg-12 portlet-column portlet-column-first" id="column-1">
			${processor.processColumn("column-1", "portlet-column-content portlet-column-content-first")}
		</div>
	</div>
	<div class="portlet-layout row">
		<div class="col-lg-12 portlet-column portlet-column-first" id="column-2">
			${processor.processColumn("column-2", "portlet-column-content portlet-column-content-first")}
		</div>
		<div class="col-lg-12 portlet-column" id="column-3">
			${processor.processColumn("column-3", "portlet-column-content")}
		</div>
		<div class="col-lg-12 portlet-column" id="column-6">
			${processor.processColumn("column-6", "portlet-column-content")}
		</div>
		<div class="col-lg-9 portlet-column" id="column-4">
			${processor.processColumn("column-4", "portlet-column-content)}
		</div>
		<div class="col-lg-3 portlet-column portlet-column-last" id="column-5">
			${processor.processColumn("column-5", "portlet-column-content portlet-column-content-last")}
		</div>
	</div>
</div>
