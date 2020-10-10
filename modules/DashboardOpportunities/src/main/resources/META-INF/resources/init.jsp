<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>
.icon-sun-haze-light:before {
    content: "\f765";
    font-family: "Font Awesome 5 Light" !important;
}
.icon-sun-haze-regular:before {
    content: "\f765";
    font-family: "Font Awesome 5 Solid";
}
.icon-fa-box:before {
    font-size: 18px;
    height: auto;
    left: 0px;
    position: absolute;
    top: 0px;
}
.view-more::after {
	top: 7px;
}
</style>
<script>
$(document).ready(function(){
	$("#dashboardOpertunitiesLoader").fadeOut();
});
</script>