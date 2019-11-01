<%@ include file="/init.jsp" %>

<section class="wrap-collaborated">
	<div class="row row-custom sortable" id="card-section">
		
	</div><!-- row -->
	<div class="row">
		<div class="col-md-12 text-center font16 font-weight-bold">
			<a href="profile-edit.html" style="font-style: italic">Still not finding what you're looking for?</a>
		</div>
	</div>
</section>
<script>
$(document).ready(function(){
	var url_string = '<%=themeDisplay.getURLPortal()+themeDisplay.getURLCurrent() %>';
	var url = new URL(url_string);
	var param = url.searchParams.get("randamId");
	getAllDetails(param);
});
</script>
