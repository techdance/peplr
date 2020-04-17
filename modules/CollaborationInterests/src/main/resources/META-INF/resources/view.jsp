<%@ include file="/init.jsp"%>



<div class="collaboration box box-border-radius box-shadow bg-white">
	<div class="inner-wrap">
		<!-- <div class="box-top position-relative">
			<h2 class="box-subhead">
				<i class="fas fa-user"></i>Collaboration Interests
			</h2>
		</div>
		<div class="box-middle">
			<div class="row row-custom">
				<div class="col-md-6">
					<div><i class="fas fa-search"></i><strong>Areas of Interest</strong></div>
					<div id="area-of-interest-block-profile"></div>
					
					<div id="view-more-interest-modal"	class="box-border-radius box-shadow interest-modal">
						<div class="view-more-interest-modal-inner position-relative">
							<div class="toltip-close2">
								<a href="javascript:void(0);"><i class="fa fa-times-circle"></i></a>
							</div>
							<div class="view-more-interest-modal-inner-content text-left">
								<div class="row mb-2">
									<div class="col-md-6">
										<strong>Project</strong><br><span class="view-project-type"></span>
									</div>
								</div>
								<div class="row  mb-2">
									<div class="col-md-6">
										<strong>Discipline</strong><br><span class="view-discipline"></span>
									</div>
									<div class="col-md-6 delivery-method">
										<strong>Delivery Method</strong><br><span class="view-delivery-type"></span>
									</div>
								</div>
								<div class="row mb-2">
									<div class="col-md-12"><span class="view-description"></div>
								</div>
								<div class="row mb-2">
									<div class="col-md-4">
										<strong>Collaboration Type</strong><br><span class="view-campus"></span>
									</div>
									<div class="col-md-4">
										<strong>Program Level</strong><br><span class="view-program-level"></span>
									</div>
									<div class="col-md-4">
										<strong>Program Length</strong><br><span class="view-program-length"></span>
									</div>
								</div>
								<div class="row mb-2">
									<div class="col-md-4">
										<strong>Credits</strong><br><span class="view-credits"></span>
									</div>
									<div class="col-md-4">
										<strong>Preferred Language</strong><br><span class="view-language"></span>
									</div>
									<div class="col-md-4">
										<strong>Preferred Location</strong><br><span class="view-location"></span>
									</div>
								</div>
								<div class="row text-center pt-2 view-find-matches">
									
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					
				<h4 class="mb-3">Introduction Video</h4>
					<div class="wrap-video img-resp mb-2">
                                            		<img src="images/video3.png">
                                            	</div>
						16:9 aspect ratio
					<div
						class="embed-responsive embed-responsive-16by9 wrap-video img-resp mb-2">
						<iframe class="embed-responsive-item"
							src="https://www.youtube.com/embed/ScMzIvxBSi4" frameborder="0"
							allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
							allowfullscreen></iframe>
					</div>
					<p>
						<a href="" class="view-more-interest">https://www.youtube/video/wztesglsv1</a>
					</p>
				</div>
			</div>
		</div> -->
		
		<div class="box-top position-relative">
				<h2 class="box-subhead"><i class="fas fa-user"></i>Collaboration Interests</h2>
				<a href="javascript:void(0);" class="icon-setting icon-box btn-menu"><i class="fas fa-cog"></i></a>
			</div>
			<div class="box-middle">
				<div class="row row-custom">
					<div class="col-md-12">
						<div class="content-icon">
							<div>
								<i class="fas fa-search"></i><strong>Areas of Interest</strong></div>
									<div class="areas-of-interest">
										<div id="area-of-interest-block-profile" class="row row-custom "></div>
										<!--row-->
										<div class="modal modalToltip modalareainterest" id="view-more-interest-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
										  <div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-body p-0">
													<div class="interest-modal p-0">
														<!-- Static Section -->
														<div class="view-more-interest-modal-inner">
															<div class="modal-header position-relative">
																<div class="toltip-close3"><a href="javascript:void(0);" data-dismiss="modal"><i class="fa fa-times-circle"></i></a></div>
																<div class="text-left font15"><strong>Project</strong><br><span class="view-project-type"></span></div>
															</div>
															<div class="view-more-interest-modal-inner-content text-left p-3">
																<div class="row mb-2">
																	<div class="col-md-12">
																		<strong>Description</strong><br>
																		<span class="view-description"></span>
																	</div>
																</div>
																
																<div class="row">
																	<div class="col-md-12 mb-2 order-md-1">
																		<strong>Preferred Language</strong><br><span class="view-language"></span>
																	</div>
																	<div class="col-md-6 mb-2 order-md-2">
																		<strong>Collaboration Type</strong><br><span class="view-campus"></span>
																	</div>
																	<div class="col-md-6 mb-2 order-md-4">
																		<strong>Discipline 1</strong><br><span class="view-discipline1"></span>
																	</div> 
																	<div class="col-md-6 mb-2 order-md-6">
																		<strong>Discipline 2</strong><br><span class="view-discipline2"></span>
																	</div>
																	<div class="col-md-6 mb-2 order-md-8">
																		<strong>Discipline 3</strong><br><span class="view-discipline3"></span>
																	</div>
																	<div class="col-md-6 mb-2 order-md-3">
																		<strong>Region 1</strong><br><span class="view-location1"></span>
																	</div>
																	<div class="col-md-6 mb-2 order-md-5">
																		<strong>Region 2</strong><br><span class="view-location2"></span>
																	</div>
																	<div class="col-md-6 mb-2 order-md-7">
																		<strong>Region 3</strong><br><span class="view-location3"></span>
																	</div>
																	<div class="col-md-6 mb-2 order-md-9">
																		<strong>Region 4</strong><br><span class="view-location4"></span>
																	</div>
																</div>
																
																<div class="row">
																	<div class="col-md-6 mb-2"><strong>Program Level</strong><br><span class="view-program-level"></span></div>
																	<div class="col-md-6 mb-2"><strong>Program Length</strong><br><span class="view-program-length"></span></div>
																	<div class="col-md-6 mb-2"><strong>Delivery Method</strong><br><span class="view-delivery-type"></span></div>
																	<div class="col-md-6 mb-2"><strong>Credits</strong><br><span class="view-credits"></span></div>
																</div>
																<div class="row mb-2">
																	<div class="col-md-12 rangerDisabled">
						 												 <strong>Project Date Range</strong>
						 												 <div class="top-label-range">
						 												 	<div class="top-init-range">
						 												 		<div id="currentdayCI2"></div>
						 												 	</div>
																			<div class="year-last-range pickerdata">
																				<input type="text" id="datePickerCI2" value="2020" readonly/>
																			</div>
																		</div>
						 												 <input type="text" class="js-range-slider" id="projectRangeCI2" name="my_range" value="" />
																	</div>
																</div>
																<div class="row text-center pt-2 mt-3">
																	<a href="javascript:void(0);" class="btn btn-blue btn-w-100 m-auto" data-dismiss="modal">Find Matches</a>
																	<div class="col-md-12 ac mt-3">
																		<strong>Created: 2019-10-31 11:34 AM</strong>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div><!-- areas of interest -->
						</div>
					</div>

				</div>

			</div>
		
	</div>
</div>
<script>
$(document).ready(function() {
	
	function formatDate(date) {
		  var monthNames = [
		    "Jan", "Feb", "Mar",
		    "Apr", "May", "Jun", "Jul",
		    "Aug", "Sept", "Oct",
		    "Novr", "Dec"
		  ];

		  var day = date.getDate();
		  var monthIndex = date.getMonth();
		  var year = date.getFullYear();

		  return  monthNames[monthIndex] +  ' ' + year;
		}

	
	document.getElementById("currentdayCI2").innerHTML = formatDate(new Date());
	
	var lang = "en-US";
    var year = 2018;
    
    function dateToTS (date) {
        return date.valueOf();
    }
    
    function tsToDate (ts) {
        var d = new Date(ts);
    
        return d.toLocaleDateString(lang, {
            month: 'short',
        });
    }
    var da = new Date();
    if (da.getMonth() == 11) {
        var current = new Date(da.getFullYear() + 1, 0, 1);
    } else {
        var current = new Date(da.getFullYear(), da.getMonth() + 11, 1);
    }
    
    $("#projectRangeCI").ionRangeSlider({
    	skin: "big",
    	type: "single",
        grid: true,
        grid_num: 11,
        min:dateToTS(new Date()),
        max: dateToTS(current),        
        prettify: tsToDate
    });
	
    $("#projectRangeCI2").ionRangeSlider({
    	skin: "big",
    	type: "single",
        grid: true,
        grid_num: 11,
        min:dateToTS(new Date()),
        max: dateToTS(current),        
        prettify: tsToDate
    });
    var end_year = da.getFullYear() + 15;
    var nd = new Date();
    nd.setFullYear(end_year)
    
    console.log(nd,"end_date")
	 $( "#datePickerCI" ).datepicker({
		 format: "yyyy",
	     viewMode: "years", 
	     minViewMode: "years",
	     autoclose: true,
	     startDate : new Date(),
	     endDate : nd
	 });
	
    $( "#datePickerCI2" ).datepicker({
		 format: "yyyy",
	     viewMode: "years", 
	     minViewMode: "years",
	     autoclose: true,
	     startDate : new Date(),
	     endDate : nd
	 });
    
});
</script>