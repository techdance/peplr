<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<style>
.icon-regular::before, .icon-regular::after {
    font-family: 'Font Awesome 5 Regular';
}
.icon-solid::after, .icon-solid::before {
    font-family: 'Font Awesome 5 Solid';
}
.box-subhead i, .box-subhead span {
    position: absolute;
    left: 0px;
    top: 3px;
}
.icon-school::before {
    content: "\f549";
}
.icon-comment-dots::before {
    content: "\f4ad";
}
.icon-phone-alt::before {
    content: "\f879";
}
.icon-phone-office::before {
    content: "\f67d";
}
.fa-desktop-alt:before {
    content: "\f390";
}
.icon-envelope::before {
    content: "\f0e0";
}
.icon-globe-americas::before {
    content: "\f57d";
}
.icon-user-tie::before {
    content: "\f508";
}
.icon-book-user::before {
    content: "\f7e7";
}
.icon-share::before {
    content: "\f1e0";
}

.border-grey {
    border: 1px solid grey !important;
}
.box-color {
    border-radius: 5px;
    padding: 10px;
}
.color-orange {
    color: #ff993f !important;
}
.font20 {
    font-size: 20px !important;
    line-height: 1.5;
}


.box-middle .form-group label.control-label {
    color: #000000;
    font-size: 14px;
    font-weight: 700;
    line-height: 18px;
    margin-bottom: 4px;
}
.box-middle .form-group .form-control {
    color: #505050;
    display: block;
    font-size: 14px;
    font-weight: 300;
    line-height: 18px;
    width: 100%;
    background: #ececec !important;
    border: 1px solid #d4d4d4;
    padding: 6px;
    height: 32px;
}
.box-middle .form-group textarea.form-control {
	min-height: 74px;
	height: auto;
    padding: 12px 6px;
}
.box-middle .form-group select.form-control:not([size]):not([multiple]) {
	height: 32px;
	border-radius: 5px;
}
.formGroupmb0 .form-group {
    width: 100%;
    margin: 0;
}
.formGroupmb0 .form-group .control-label {
    margin-left: -25px;
}
.formGroupmb0 .form-group textarea.form-control {
    min-height: inherit;
    height: auto;
    padding: 6px;
}
.form-group {
    pointer-events: none;
}
.img-resp {
	width: 250px;
}
.img-resp img {
	object-fit: cover;
    width: 230px!important;
    height: 230px;
}
</style>