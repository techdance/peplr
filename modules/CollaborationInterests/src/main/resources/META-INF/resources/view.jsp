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
							<div><i class="fas fa-search"></i><strong>Areas of Interest</strong></div>
							
								
									<div class="areas-of-interest">
										<div id="area-of-interest-block-profile" class="row row-custom "></div>
										<!--row-->
										<div id="view-more-interest-modal" class="box-border-radius box-shadow interest-modal">
												<div class="view-more-interest-modal-inner position-relative">
													<div class="toltip-close2"><a href="javascript:void(0);"><i class="fa fa-times-circle"></i></a></div>
													<div class="view-more-interest-modal-inner-content text-left">
														<div class="row mb-2">
															<div class="col-md-6"><strong>Project</strong><br><span class="view-project-type"></span></div>
														</div>
														<div class="row  mb-2">
															<div class="col-md-6"><strong>Discipline</strong><br><span class="view-discipline"></span></div>
															<div class="col-md-6"><strong>Delivery Method</strong><br><span class="view-delivery-type"></span></div>
														</div>
														<div class="row mb-2">
															<div class="col-md-12">
																<strong>Description</strong><br>
																<span class="view-description"></span>
															</div>
														</div>
														<div class="row mb-2">
															<div class="col-md-4"><strong>Collaboration Type</strong><br><span class="view-campus"></span></div>
															<div class="col-md-4"><strong>Program Level</strong><br><span class="view-program-level"></span></div>
															<div class="col-md-4"><strong>Program Length</strong><br><span class="view-program-length"></span></div>
														</div>
														<div class="row mb-2">
															<div class="col-md-4"><strong>Credits</strong><br><span class="view-credits"></span></div>
															<div class="col-md-4"><strong>Preferred Language</strong><br><span class="view-language"></span></div>
															<div class="col-md-4"><strong>Region</strong><br><span class="view-location"></span></div>
															<!-- <div class="col-md-4"><strong>Region</strong><br>All</div> -->
														</div>
														<div class="row mb-2">
															<div class="col-md-12">
																<strong>Project Date Range</strong>
																<div class="top-label-range">
																	<div class="year-init-range">Today 2020</div>
																	<div class="year-last-range">2021</div>
																</div>
																<div class="wrap-range">
																	<input type="range">
																</div>
																<div class="wrap-range-label width-inherit">
																	<ul class="d-flex">
																		<li>Jan</li>
																		<li>Feb</li>
																		<li>Mar</li>
																		<li>Apr</li>
																		<li>May</li>
																		<li>Jun</li>
																		<li>Jul</li>
																		<li>Aug</li>
																		<li>Sep</li>
																		<li>Oct</li>
																		<li>Nov</li>
																		<li>Dec</li>
																		<li>Jan</li>
																		<li>Feb</li>
																	</ul>
																</div>
															</div>
															<div class="col-md-12 ac mt-3">
																<strong>Create: 12-20-2019 11:34 AM</strong>
															</div>
														</div>
														<div class="row text-center pt-2 mt-3">
															<a href="#" class="btn btn-blue btn-w-100 m-auto">Find Matches</a>
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