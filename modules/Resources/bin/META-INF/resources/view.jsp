<%@ include file="/init.jsp" %>
<portlet:renderURL var="bestPracticesLibrary">
	<portlet:param name="jspPage" value="/META-INF/resources/bestPractices.jsp"/>
</portlet:renderURL>
<section class="wrap-resources">
	<div class="row row-custom sortable">
		<div class="col-lg-6 mb-4">
			<div class="box box-border-radius box-shadow bg-white">
				<div class="inner-wrap inner-wrap-flex asset asset-type-a">
					<div class="content-left">
						<img src="/o/ahea-theme/images/resources-icon-1.png" alt="">
					</div>
					<div class="content-right">
						<div class="box-top position-relative text-uppercase">
							<h2>Getting Started </h2>
						</div>
						<div class="box-middle">
							<p>Begin using CollaboratED with these quick tips and instructions.</p>
						</div>
						<div class="box-bottom font-weight-bold">
							<p><a href="#" class="view-more">Learn More</a></p>
						</div>
					</div>
				</div>
			</div>
		</div><!-- END COL -->
		<div class="col-lg-6 mb-4">
			<div class="box box-border-radius box-shadow bg-white">
				<div class="inner-wrap inner-wrap-flex asset asset-type-b">
					<div class="content-left">
						<img src="/o/ahea-theme/images/resources-icon-2.png" alt="">
					</div>
					<div class="content-right">
						<div class="box-top position-relative text-uppercase">
							<h2>Best Practices & How-To Guides </h2>
						</div>
						<div class="box-middle">
							<p>Find methods and techniques that will help you best utilize CollaboratED for networking, collaborating and developing courses.</p>
						</div>
						<div class="box-bottom font-weight-bold">
							<p><a href="<%=bestPracticesLibrary.toString() %>" class="view-more">Enter Best Practices Library</a></p>
						</div>
					</div>
				</div>
			</div>
		</div><!-- END COL -->
		<div class="col-lg-6 mb-4">
			<div class="box box-border-radius box-shadow bg-white">
				<div class="inner-wrap inner-wrap-flex asset asset-type-c">
					<div class="content-left">
						<img src="/o/ahea-theme/images/resources-icon-5.png" alt="">
					</div>
					<div class="content-right">
						<div class="box-top position-relative text-uppercase">
							<h2>Tutorials </h2>
						</div>
						<div class="box-middle">
							<p>View a collection of tutorials designed to help you use CollaboratED effectively.</p>
						</div>
						<div class="box-bottom font-weight-bold">
							<p><a href="#" class="view-more">Browser Tutorials</a></p>
						</div>
					</div>
				</div>
			</div>
		</div><!-- END COL -->
		<div class="col-lg-6 mb-4">
			<div class="box box-border-radius box-shadow bg-white">
				<div class="inner-wrap inner-wrap-flex asset asset-type-d">
					<div class="content-left">
						<img src="/o/ahea-theme/images/resources-icon-4.png" alt="">
					</div>
					<div class="content-right">
						<div class="box-top position-relative text-uppercase">
							<h2>TEMPLATES</h2>
						</div>
						<div class="box-middle">
							<p>Design teaching plans, syllabi and other instructional material with AHEA's professionally constructed templates.</p>
						</div>
						<div class="box-bottom font-weight-bold">
							<p><a href="#" class="view-more">Learn More</a></p>
						</div>
					</div>
				</div>
			</div>
		</div><!-- END COL -->
	</div><!-- row -->
</section>