<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />


<style>
	.icon-book-alt-light:before {
    content: "\f5d9";
    font-family: "Font Awesome 5 Light";
}
.icon-fa-box:before {
    font-size: 18px;
    height: auto;
    left: 0px;
    position: absolute;
    top: 0px;
}
.table.table2 tbody td, .table.table2 thead th {
    font-weight: bold;
}
.table2 thead th {
    line-height: 1.5;
    text-align: center;
}
.table tbody td, .table thead th {
    font-size: 13px !important;
}
.table thead th {
    border: none;
    font-weight: bold;
    text-transform: uppercase;
    text-align: center;
    padding: 10px 8px 10px;
}
</style>
<script>
$(document).ready(function(){
	var tbody = $("#courseTable tbody");

	if (tbody.children().length == 0) {
	    tbody.html("<tr><td colspan='8' class='text-center'>No Course Added</td></tr>");
	}
	$("#dashboardMyCoursesLoader").fadeOut();
})
</script>