<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />


<style>
section.top .breadcrumb {
	display: none;
}
.wrap-collaborated div.asset {
    padding: 35px 10px 6px;
}
div.asset {
    padding: 46px 26px 15px;
}
.inner-wrap-flex {
    display: flex;
}
.asset .content-left {
    margin-right: 27px;
}
.asset .box-top {
    margin-top: 0px;
}
.wrap-collaborated .asset h2 {
    color: #000;
    font-size: 18px;
    font-weight: 700;
    line-height: 24px;
}
.asset .box-middle {
    font-size: 14px;
    line-height: 24px;
    margin-bottom: 40px;
}
.asset h2 {
    color: #555555;
    font-size: 18px;
    font-weight: 900;
    line-height: 24px;
}
.asset-type-a h2 {
    color: #ffcc33;
}
.asset-type-b h2 {
    color: #9999ff;
}
.asset-type-c h2 {
    color: #ff6666;
}
.asset-type-d h2 {
    color: #ff993e;
}
@media (max-width: 767px){
	.asset .content-left {
	    margin-right: 0px;
	    margin-bottom: 20px;
	    text-align: center;
	}
	.inner-wrap-flex {
	    display: block;
	}
}
.color-green-light {
    color: #ffcc33 !important;
}
.color-blue2 {
    color: #9999ff !important;
}
.color-red-light {
    color: #ff6666 !important;
}
.color-orange {
    color: #ff993f !important;
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
.icon-th-large::before {
    content: "\f009";
}
.box-subhead span {
    position: absolute;
    left: 0px;
    top: 3px;
}
.icon-regular::before, .icon-regular::after {
    font-family: 'Font Awesome 5 Regular';
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
.list-bullet li {
    font-size: 14px;
    line-height: 24px;
    position: relative;
    padding-left: 23px;
    margin-bottom: 9px !important;
}
.box-bottom a{
	line-height: 14px;
	font-size: 14px;
}
.icon-regular::before, .icon-regular::after {
    font-family: 'Font Awesome 5 Regular';
}

.icon-size-95 {
    font-size: 95px !important;
}
.icon-duotone {
    position: relative;
    padding-left: 1.25em;
}
.icon-duotone::before, .icon-duotone::after {
    font-family: "Font Awesome 5 Duotone";
    font-weight: 900;
    position: absolute;
    left: 0;
    top: 50%;
    transform: translateY(-50%);
    width: 1.25em;
    text-align: center;
}
.icon-rocket-launch::before {
    content: "\f927";
}
.icon-duotone.icon-rocket-launch::after {
    content: "\10f927";
}
.icon-medal::before {
    content: "\f5a2";
}
.icon-duotone.icon-medal::after {
    content: "\10f5a2";
}
.icon-laptop::before {
    content: "\f109";
}
.icon-duotone.icon-laptop::after {
    content: "\10f109";
}
.cl-primary-asset-type-d::before {
	content: "\f737";
}
.icon-duotone.icon-clipboard-list-check::after {
    content: "\10f737";
}


.cl-primary-asset-type-a::before{
    color: var(--fa-primary-color, #ffcc33);

}
.cl-secondary-asset-type-a::after{
    color: var(--fa-secondary-color, #FFEBAD);
    opacity: var(--fa-secondary-opacity, 1);
}


.cl-primary-asset-type-b::before{
    color: var(--fa-primary-color, #9999ff);

}
.cl-secondary-asset-type-b::after{
    color: var(--fa-secondary-color, #D7D7ff);
    opacity: var(--fa-secondary-opacity, 1);
}
.cl-primary-asset-type-d::before{
    color: var(--fa-primary-color, #ff993e);

}
.cl-secondary-asset-type-d::after{
    color: var(--fa-secondary-color, #FFD7B3);
    opacity: var(--fa-secondary-opacity, 1);
}

.cl-primary-asset-type-e::before{
     color: var(--fa-primary-color, #ff6666);

 }
.cl-secondary-asset-type-e::after{
    color: var(--fa-secondary-color, #FFC3C3);
    opacity: var(--fa-secondary-opacity, 1);
}
.cl-primary-asset-type-f::before{
    color: var(--fa-primary-color, #0092f7);

}
.cl-secondary-asset-type-f::after{
    color: var(--fa-secondary-color, #99d4fc);
    opacity: var(--fa-secondary-opacity, 1);
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
	$(".ResourcesLoader").fadeOut();
});
</script>