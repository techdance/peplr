<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>
	.pl-45 {
    padding-left: 2rem!important;
}
.box-subhead {
    color: black;
    font-size: 18px;
    font-weight: bold;
    line-height: 25px;
    margin-bottom: 15px;
    margin-left: 3px;
    max-width: 260px;
    padding-left: 35px;
    padding-right: 1.4rem;
    position: relative;
}
.icon-signal-stream:before {
    content: "\f8dd";
    font-family: "Font Awesome 5 Regular";
}
</style>
<script>
$(document).ready(function(){
	$("#dashboardNewsLoader").fadeOut();
});
</script>