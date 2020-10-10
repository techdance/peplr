<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>
.box-shadow {
    box-shadow: 1px 1px 2px 1px #c2c2c2;
}
/* .testing_section #column-1 {
	padding: 0 4px;
} */
.testing_section #column-1 .portlet-decorate .portlet-content {
    background: transparent;
}
.portlet-icon-back {
	display: none;
}
.box-subhead {
    font-size: 18px;
}
.box-subhead span {
    position: absolute;
    left: 0px;
    top: 3px;
}
.icon-regular::before, .icon-regular::after {
    font-family: 'Font Awesome 5 Regular';
}
.icon-user-plus::before {
    content: "\f234";
}
.icon-user-profile::before {
    content: "\f007";
}
.icon-bullhorn::before {
    content: "\f0a1";
}
.icon-book-spells::before {
    content: "\f6b8";
}
.icon-th-large::before {
    content: "\f009";
}

.fa-th-large:before {
    content: "\f009";
}
.fad.fa-th-large:after {
    content: "\10f009";
}
.icon-th-large:before {
    content: "\f009";
    font-family: "Font Awesome 5 Solid";
}
.icon-size-60 {
    font-size: 60px !important;
}
	.icon-th-large-regular:before {
    content: "\f009";
    font-family: "Font Awesome 5 Regular";
}
.icon-fa-box:before {
    font-size: 18px;
    height: auto;
    left: 0px;
    position: absolute;
    top: 0px;
}
.list-bullet li {
    font-size: 14px;
    line-height: 24px;
    position: relative;
    padding-left: 23px;
    margin-bottom: 9px !important;
}

#qfkd____{
	display:none;
}

.hover-underline:hover {
    text-decoration: underline !important;
}
.icon-book-spells::before {
    content: "\f6b8";
}
.icon-plane-alt::before {
    content: "\f3de";
}
.color-blue-light, .color-blue-light-hover:hover {
    color: #2a9eff !important;
}
.icon-pen::before {
    content: "\f304";
}
.icon-compress-arrows-alt::before {
    content: "\f78c";
}
.icon-comment-alt-smile::before {
    content: "\f4aa";
}
</style>
<script>
$(document).ready(function(){
	$("#dashboardResourcesLoader, .Resources").fadeOut();
	
});
</script>