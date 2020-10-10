<%@ include file="/init.jsp" %>

<section class="wrap-lab">
	<div class="row row-custom">
		<div class="col-lg-12 mb-4">
			<div class="box box-border-radius box-shadow bg-white block-invite">
				<div class="inner-wrap">
					<div class="box-top position-relative mb-3">
						<h3 class="box-subhead"><i class="fas fa-comments"></i> Messages</h3>
					</div>
					<div class="box-middle">
						<ul class="nav nav-tabs" id="tabs" role="tablist">
							<li class="nav-item">
								<a class="nav-link nav-grey active" id="received-tab" data-toggle="tab" href="#discussion" role="tab" aria-controls="discussion" aria-selected="false">Received</a>
							</li>
							<li class="nav-item">
								<a class="nav-link nav-blue" id="sent-tab" data-toggle="tab" href="#file" role="tab" aria-controls="file" aria-selected="true">Sent</a>
							</li>
						</ul>
						<div class="tab-content" id="myTabContent">
						  <div class="tab-pane fade show active" id="discussion" role="tabpanel" aria-labelledby="received-tab">
								<div class="block-invite-content block-invite-receive-content pt-2">
								</div>
						  </div>
						  <div class="tab-pane fade" id="file" role="tabpanel" aria-labelledby="sent-tab">
						  	<div class="block-invite-content block-invite-sent-content pt-2">
							</div>
						  </div>

						</div>
					</div>
				</div>
			</div>
		</div><!-- END COL -->
	</div><!-- row -->
</section>