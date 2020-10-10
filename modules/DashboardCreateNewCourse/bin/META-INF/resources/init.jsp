<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>
	.bg-orange {
	    background: #ff993e !important;
	}
	.box {
	    padding: 10px 18px 20px;
	}
	.box-top {
    margin-top: 7px;
    margin-bottom: 4px;
}
.box-top, .box-middle, .box-bottom {
    display: block;
}
.box-top {
    clear: both;
    display: block;
}
.pl-45 {
    padding-left: 2rem!important;
}
.icon-fa-box {
    position: relative;
}
.color-white {
    color: white !important;
}
.icon-handshake-light:before {
    content: "\f2b5";
    font-family: "Font Awesome 5 Light";
}
.icon-fa-box:before {
    font-size: 18px;
    height: auto;
    left: 0px;
    position: absolute;
    top: 0px;
}
.create-new .box-middle {
    font-size: 15px;
    line-height: 20px;
    margin-bottom: 20px;
}
.box-bottom {
    line-height: 20px;
}
.btn.btn-w-100 {
    display: inline-block;
    max-width: inherit !important;
    width: auto !important;
}
.btn-blue {
    background: #299eff;
}
.icon-size-40 {
    font-size: 40px !important;
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
</style>

<script>
function goToEdit(){
	window.location.href="<%=themeDisplay.getURLPortal() %>/edit-profile?param=interest";
}

$(document).ready(function(){
	$("#dashboardCreateNewCourseLoader").fadeOut();
});

</script>