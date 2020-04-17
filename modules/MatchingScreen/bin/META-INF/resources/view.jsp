<%@ include file="/init.jsp" %>

<!-- <section class="wrap-collaborated">
	<div class="row row-custom sortable" id="card-section">
		
	</div>row
	<div class="row">
		<div class="col-md-12 text-center font16 font-weight-bold">
			<a href="profile-edit.html" style="font-style: italic">Still not finding what you're looking for?</a>
		</div>
	</div>
</section> -->

<section class="wrap-collaborated">
	<div class="row row-custom sortable" id="card-section">
		<!-- <div class="col-lg-6 mb-4">
			<div class="box box-border-radius box-shadow bg-white">
				<div class="inner-wrap inner-wrap-flex asset">
					<div class="content-left">
						<a href="kjersty-ahlquist-profile-1h.html"><img src="/o/ahea-theme/images/coll-1.png" alt=""></a>
					</div>
					<div class="content-right">
						<div class="box-top position-relative">
							<h2><a href="kjersty-ahlquist-profile-1h.html" class="hover-underline color-black color-blue-light-hover">Kjersti Ahlquist, Ph.D.</a></h2>
						</div>
						<div class="box-middle p0">
							<p>Biochemistry & Cell Biology Research Faculty</p>
							<p><span class="font-style-italic color-blue-light">University of Oslo</span></p>
							<p>Oslo, Norway</p>
						</div>
					</div>
				</div>
			</div>
		</div>END COL
		<div class="col-lg-6 mb-4">
			<div class="box box-border-radius box-shadow bg-white">
				<div class="inner-wrap inner-wrap-flex asset">
					<div class="content-left">
						<a href="#"><img src="/o/ahea-theme/images/coll-2.png" alt=""></a>
					</div>
					<div class="content-right">
						<div class="box-top position-relative">
							<h2><a href="#" class="hover-underline color-black color-blue-light-hover">Enes Batur, Ph.D.</a></h2>
						</div>
						<div class="box-middle p0">
							<p>Assistant Professor of Biochemistry and Molecular Biology</p>
							<p><span class="font-style-italic color-blue-light">Istanbul University</span></p>
							<p>Istanbul, Turkey</p>
						</div>
					</div>
				</div>
			</div>
		</div>END COL
		<div class="col-lg-6 mb-4">
			<div class="box box-border-radius box-shadow bg-white">
				<div class="inner-wrap inner-wrap-flex asset">
					<div class="content-left">
						<a href="#"><img src="/o/ahea-theme/images/coll-3.png" alt=""></a>
					</div>
					<div class="content-right">
						<div class="box-top position-relative">
							<h2><a href="#" class="hover-underline color-black color-blue-light-hover">Anaishe Mawere, M.D.</a></h2>
						</div>
						<div class="box-middle p0">
							<p>Director, Center for Molecular Biology & Biotechnology Research</p>
							<p><span class="font-style-italic color-blue-light">National University of Science and Technology</span></p>
							<p>Bulawayo, Zimbabwe</p>
						</div>
					</div>
				</div>
			</div>
		</div>END COL
		<div class="col-lg-6 mb-4">
			<div class="box box-border-radius box-shadow bg-white">
				<div class="inner-wrap inner-wrap-flex asset">
					<div class="content-left">
						<a href="#"><img src="/o/ahea-theme/images/coll-4.png" alt=""></a>
					</div>
					<div class="content-right">
						<div class="box-top position-relative">
							<h2><a href="#" class="hover-underline color-black color-blue-light-hover">Aleixo Silva, Ph.D.</a></h2>
						</div>
						<div class="box-middle p0">
							<p>Chair, Department of Chemistry & Biochemistry</p>
							<p><span class="font-style-italic color-blue-light">Federal University of Rio Grande do Sul</span></p>
							<p>Porto Alegre, Brazil</p>
						</div>
					</div>
				</div>
			</div>
		</div>END COL -->
	</div><!-- row -->
	<div class="row">
		<div class="col-md-12 text-center font16 font-weight-bold">
			<a href="<%=themeDisplay.getURLPortal() %>/edit-profile?param=interest" class="font-style-italic hover-underline">Still not finding what you're looking for?</a>
		</div>
	</div>
</section>
					


<script>
$(document).ready(function(){
	debugger;
	loadRecommenedPartners();
	var url_string = '<%=themeDisplay.getURLPortal()+themeDisplay.getURLCurrent() %>';
	var url = new URL(url_string);
	var param = url.searchParams.get("randamId");
	if(param!="" && param!=null && param!="null"){
		getAllDetails(param);
	}
});
</script>
