<%@ include file="/init.jsp" %>

<nav aria-label="breadcrumb">
	<ol class="breadcrumb">
	  <li class="breadcrumb-item"><a href="/home1">Home</a></li>
	  <li class="breadcrumb-item"><a href="/profile">Profile</a></li>
		<li class="breadcrumb-item active" aria-current="page">Matches</li>
	</ol>
</nav>
<section class="wrap-collaborated">
	<div class="row row-custom sortable" id="card-section">
	</div>
	<div class="row row-custom sortable" id="card-lazyload">
	</div>
	<!-- row -->
	<div class="row">
		<div class="col-md-12 text-center font16 font-weight-bold">
			<a href="<%=themeDisplay.getURLPortal() %>/edit-profile?param=interest" class="font-style-italic hover-underline">Still not finding what you're looking for?</a>
		</div>
	</div>
	
</section>
					


<script>
	
	<%-- $(document).ready(function(){
			var url_string = '<%=themeDisplay.getURLPortal()+themeDisplay.getURLCurrent() %>';
			var url = new URL(url_string);
			var param = url.searchParams.get("randamId");
			if(param!="" && param!=null && param!="null"){
				getAllDetails(param);
			}else{
				//loadRecommenedPartners();
			}
	}); --%>
	
	
		var page = 1;
		/* $(window).scroll(function() { */
		      console.log('pagescroll',++page);
		      	var url_string = '<%=themeDisplay.getURLPortal()+themeDisplay.getURLCurrent() %>';
			  	var url = new URL(url_string);
			  	var param = url.searchParams.get("randamId");
			  	matchingRequestedId = param; 
			  	if(param!="" && param!=null && param!="null"){
			  		getAllDetails(param);
			  	}else{
			  		//loadRecommenedPartners();
			  	}
		/* }); */
	
</script>
