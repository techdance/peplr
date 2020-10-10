<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>
	.icon-calendar-regular:before {
    content: "\f073";
    font-family: "Font Awesome 5 Regular";
}
.icon-fa-box:before {
    font-size: 18px;
    height: auto;
    left: 0px;
    position: absolute;
    top: 0px;
}
div#my-calendar-container .ui-widget.ui-widget-content .ui-datepicker-header .ui-datepicker-title {
	font-weight: bold;
}
div#my-calendar-container .ui-widget.ui-widget-content .ui-datepicker-header .ui-datepicker-title {
	line-height: 18px;
}
h2.color-black a {
    color: #000 !important;
}
h2.color-blue-light-hover:hover a {
    color: #2a9eff !important;
    text-decoration: underline;
}
</style>