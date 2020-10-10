<%@ include file="/init.jsp" %>
<portlet:renderURL var="bestPracticesLibrary">
	<portlet:param name="jspPage" value="/META-INF/resources/bestPractices.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="templatesLibrary">
	<portlet:param name="jspPage" value="/META-INF/resources/templates.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="gettingStartedLibrary">
	<portlet:param name="jspPage" value="/META-INF/resources/gettingStarted.jsp"/>
</portlet:renderURL>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="/home1"><!-- <i class="fas fa-home" aria-hidden="true"></i> --> Home</a></li>
        <li class="breadcrumb-item active" aria-current="page"><a href="/resources">Resources</a></li>
    </ol>
</nav>
<section class="wrap-resources">
    <div class="row row-custom sortable">
        <div class="col-lg-6 mb-4">
            <div class="box box-border-radius box-shadow bg-white">
            	<!-- Loader -->
				<div class="ResourcesLoader sectionloader"> 
					<div class="loader"></div>
				</div>
                <div class="inner-wrap inner-wrap-flex asset asset-type-a align-items-center">
                    <div class="content-left">
                        <span class="icon-duotone icon-rocket-launch icon-size-95 cl-primary-asset-type-a cl-secondary-asset-type-a"></span>
                    </div>
                    <div class="content-right">
                        <div class="box-top position-relative text-uppercase">
                            <h2>Getting Started </h2>
                        </div>
                        <div class="box-middle">
                            <p>Begin using the InspirED platform, and its solutions, with these quick tips and instructions.</p>
                        </div>
                        <div class="box-bottom font-weight-bold">
                            <p><a href="<%=gettingStartedLibrary.toString() %>" class="btn btn-blue">View More</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END COL -->
        <div class="col-lg-6 mb-4">
            <div class="box box-border-radius box-shadow bg-white">
            	<!-- Loader -->
				<div class="ResourcesLoader sectionloader"> 
					<div class="loader"></div>
				</div>
                <div class="inner-wrap inner-wrap-flex asset asset-type-b align-items-center">
                    <div class="content-left">
                        <span class="icon-duotone icon-medal icon-size-95 cl-primary-asset-type-b cl-secondary-asset-type-b"></span>
                    </div>
                    <div class="content-right">
                        <div class="box-top position-relative text-uppercase">
                            <h2>Best Practices & How-To Guides</h2>
                        </div>
                        <div class="box-middle">
                            <p>Discover techniques that will help you optimize InspirED to manage the academic lifecycle, collaborate with peers, and engage constituents.</p>
                        </div>
                        <div class="box-bottom font-weight-bold">
                            <p><a href="<%=bestPracticesLibrary.toString() %>" class="btn btn-blue">View More</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END COL -->
        <div class="col-lg-6 mb-4">
            <div class="box box-border-radius box-shadow bg-white">
            	<!-- Loader -->
				<div class="ResourcesLoader sectionloader"> 
					<div class="loader"></div>
				</div>
                <div class="inner-wrap inner-wrap-flex asset asset-type-c align-items-center">
                    <div class="content-left">
                        <span class="icon-duotone icon-laptop icon-size-95 cl-primary-asset-type-e cl-secondary-asset-type-e"></span>
                    </div>
                    <div class="content-right">
                        <div class="box-top position-relative text-uppercase">
                            <h2>Tutorials </h2>
                        </div>
                        <div class="box-middle">
                            <p>View these brief videos to get you up and running in InspirED.</p>
                        </div>
                        <div class="box-bottom font-weight-bold">
                            <p><a href="#" class="btn btn-blue">View More</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END COL -->
        <div class="col-lg-6 mb-4">
            <div class="box box-border-radius box-shadow bg-white">
            	<!-- Loader -->
				<div class="ResourcesLoader sectionloader"> 
					<div class="loader"></div>
				</div>
                <div class="inner-wrap inner-wrap-flex asset asset-type-d align-items-center">
                    <div class="content-left">
                        <span class="icon-duotone icon-clipboard-list-check icon-size-95 cl-primary-asset-type-d cl-secondary-asset-type-d"></span>
                    </div>
                    <div class="content-right">
                        <div class="box-top position-relative text-uppercase">
                            <h2>TEMPLATES</h2>
                        </div>
                        <div class="box-middle">
                            <p>Utilize AHEA's professionally-constructed templates to support curriculum development, campus programs, and strategic initiatives.</p>
                        </div>
                        <div class="box-bottom font-weight-bold">
                            <p><a href="<%=templatesLibrary.toString() %>" class="btn btn-blue">View More</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END COL -->
    </div>
    <!-- row -->
</section>