<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>
.box-subhead {
	display: block;
}
.icon-book-user:before {
    content: "\f7e7";
    font-family: "Font Awesome 5 Light";
}
div.item {
    color: #555555;
    font-size: 12px;
    line-height: 13px;
    margin-bottom: 13px;
}
.item-img, .item-text {
    display: inline-block;
    vertical-align: middle;
}
@media (max-width: 1500px) and (min-width: 992px){
	.recommended .item-img {
	    margin-right: 5px;
	    max-width: 48px;
	}
	.recommended .item-img img {
    max-width: 100%;
}
}
div.item a {
    color: #0099ff;
    font-weight: bold;
    text-decoration: none;
}
div.item span {
    color: #555555;
    display: block;
    font-weight: normal;
}
.recommended .partner-title {
    color: #000 !important;
}
.pointerEventsNone {
	pointer-events: none;
	position: relative;
}
.pointerEventsNone:before {
	content: '';
	position: absolute;
    top: 0;
    width: 100%;
    opacity: 0.5;
    background-color: #6f7880;
    pointer-events: none;
    cursor: default;
    height: 100%;
    left: 0;
    border-radius: 8px;
    z-index: 100;
}
</style>

<script>
$(document).ready(function(){
	$("#dashboardMyAdviseesLoader").fadeOut();
})
</script>