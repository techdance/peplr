<%@ include file="/init.jsp" %>
<%

%>
<div class="recommended box box-border-radius box-shadow bg-white pointerEventsNone">
	<!-- Loader -->
	<div id="dashboardRecommentedPartnersLoader" class="sectionloader"> 
		<div class="loader"></div>
	</div>
	<div class="inner-wrap">
		<div class="box-top position-relative">
			<h2 class="box-subhead icon-fa-box icon-user-friends pl-45">Recommended Partners</h2>
			<a href="javascript:void(0);" class="icon-setting icon-box"><i class="fas fa-cog"></i></a>
		</div>		
		<div class="box-middle dashboardnews">
			<div id="showErrorMessage">
				<p><a href="<%=themeDisplay.getURLPortal() %>/edit-profile">To view Recommended Partners, complete your Collaboration Interests on the Edit Profile screen.</a></p>
			</div>
		</div>
			<!-- <div class="item">
				<div class="item-img partner-img position-relative">
					<a href="javascript:void(0);"><img src="/o/ahea-theme/images/Karthik.png" width="59"></a>
					<div class="toltip3 any-toltip toltip-bg-black">
						<div class="d-flex">
							<a href="javascript:void(0);"><img src="images/contact-partner-1.png" width="50"></a>
							<a href="javascript:void(0);"><img src="images/contact-partner-2.png" width="50"></a>
							<a href="javascript:void(0);"><img src="images/contact-partner-3.png" width="50"></a>
						</div>
					</div>
				</div>
				<div class="item-text">
					<a href="javascript:void(0);" class="partner partner-name color-black hover-underline">Karthik Koothrappali, Ph.D.</a>
					<span class="partner partner-title">Lecturer, Business &amp; Economics </span>
					<span class="partner partner-university">University of Dubai </span>
					<span class="partner partner-address">Dubai, UAE</span>
				</div>
			</div> -->
		</div>
		
		<div class="box-bottom text-center font-weight-bold position-relative pt-4 pb-4">
			<a href="<%=themeDisplay.getURLPortal() %>/matching-screen" class="btn btn-blue btn-w-100" id="partner-search">View Matches</a>
		</div>
</div>