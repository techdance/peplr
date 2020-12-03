<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDTB30uKJgKRGvIVHavUEPKACPZkqkkifg&sensor=false"></script>
 <script src="/o/ahea-theme/js/canvasjs.min.js"></script>
<!-- <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script> -->
<!-- <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDTB30uKJgKRGvIVHavUEPKACPZkqkkifg&sensor=false"></script> -->

<style>
.top .breadcrumb {
	display: none;
}
.ar {
    text-align: right;
}
/* .img-resp img {
    width: 100% !important;
} */
.ahea-icons {
    display: flex;
    justify-content: center;
    margin-top: 15px;
}
.ahea-icons a {
    color: black;
    font-size: 30px;
    margin: 0 3px;
}
.line-height-15 {
    line-height: 1.5 !important;
}
#profile-map {
    top: 60px;
    overflow: hidden;
}
select.select {
    border: 0;
    border-radius: 6px;
    padding: 9px 12px;
}
.border-grey {
    border: 1px solid grey !important;
}
.box-color-blue {
    background: #0a4366;
}
.box-color-orange {
    background: #ffcc19;
}
.box-color {
    border-radius: 5px;
    padding: 10px;
}
.box-color-blue .box-number {
    font-size: 80px;
    line-height: 1.2;
}
.box-color-orange .box-number {
    font-size: 42px;
    line-height: 1.2;
}
.font20 {
    font-size: 20px !important;
    line-height: 1.5;
}
.box-chart-pie {
    border: 1px solid #aaaaaa;
    border-radius: 5px;
    -moz-border-radius: 5px;
    -webkit-border-radius: 5px;
    -ms-border-radius: 5px;
    padding-bottom: 30px;
    height: 100%;
    position: relative;
    overflow: hidden;
}
.font60 {
    font-size: 60px !important;
    line-height: 1.5;
}
.list-bullet li {
    font-size: 14px;
    line-height: 24px;
}
.section-academics .list-bullet li a {
    color: black;
}


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
.img-resp {
    width: 230px;
    height: 230px;
    display: flex;
    align-items: center;
    justify-content: center;
}
.img-resp img {
    max-width: 100%;
    max-height: 100%;
}
.section-academics .list-bullet li a:hover{
	color: #007bff;
}
</style>