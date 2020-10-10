<%@ include file="/init.jsp" %>

<nav aria-label="breadcrumb">
	<ol class="breadcrumb">
	  <li class="breadcrumb-item"><a href="/home1"> Home</a></li>
	  <li class="breadcrumb-item active" aria-current="page">My Calendar</li>
	</ol>
</nav>

<div class="row row-custom ">
								
<div class="col-lg-12 mb-4">
	<div class="p-3 box-border-radius box-shadow bg-white block-invite">
		<!-- Loader -->
		<div id="FullpageCalendarLoader" class="sectionloader"> 
			<div class="loader"></div>
		</div>
		<div class="inner-wrap">
			<div class="position-relative mb-3 d-flex justify-content-between align-items-start">
				<h3 class="box-subhead"><i class="fas fa-calendar"></i> My Calendar</h3>
				<a class="btn btn-grey btn-w-100" href="javascript:void(0);" data-toggle="modal" data-target="#eventModal">Add New Event</a>
			</div>
			<div class="box-middle">
				<!-- THE CALENDAR -->
        		<div id="calendar"></div>
			</div>
		</div>
	</div>
</div><!-- END COL -->

</div><!-- row -->				

	<!-- event -->
	<div class="modal fade event-modal" id="eventModal" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header text-white" style="background:rgba(136, 145, 152, 0.95)">
					<h4 id="eventHeader">New Event</h4>
				</div>
				<div class="modal-body">
					<aui:form name="updateCalendarEvent" onSubmit="event.preventDefault();">
						<aui:input type="hidden" name="eventId" label="Event Id" value="" class="form-control"></aui:input>
						<div class="row">
							<div class="col-md-12 mb-2">
								<aui:input type="text" name="eventTitle" label="Event Name" value="" required="true" class="form-control"></aui:input>
							</div>
							<div class="col-md-6 mb-2">
								<aui:input type="text" name="startDate" label="Start Date" class="form-control" value="" placeholder="yyyy-mm-dd" autocomplete="off" onkeydown='return false' />
							</div>
							<div class="col-md-6 mb-2">
								<aui:input type="text" name="endDate" label="End Date" class="form-control" value="" placeholder="yyyy-mm-dd" autocomplete="off" onkeydown='return false' />
							</div>
							<div class="col-md-6 mb-2">
								<aui:input type="text" name="startTime" label="Start Time" class="form-control" value="" placeholder="10:00 AM" autocomplete="off" onkeydown='return false' />
							</div>
							<div class="col-md-6 mb-2">
								<aui:input type="text" name="endTime" label="End Time" class="form-control" value="" placeholder="11:00 AM" autocomplete="off" onkeydown='return false' />
							</div>
						</div>	
						<div class="modal-footer ac">
							<aui:button value="Cancel" type="reset" class="btn btn-grey" data-dismiss="modal" aria-label="Close" onclick="cancelEvent()"></aui:button>
							<aui:button value="Delete" type="button" class="btn btn-red d-none" onclick="removeEvent()" id="deleteEvent"></aui:button>
							<aui:button value="Save" type="submit"  class="btn btn-blue" id="saveEvent" data-dismiss="modal" aria-label="Close" onclick="saveCalendarEvent()"></aui:button>
						</div>
				</aui:form>
			</div>
		</div>
	</div>
																																							