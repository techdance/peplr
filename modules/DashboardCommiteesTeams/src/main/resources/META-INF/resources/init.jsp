<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>
	.box {
    padding: 10px 18px 20px;
}
.box-shadow {
    -webkit-box-shadow: 1px 1px 2px 0px rgba(194,194,194,1);
    -moz-box-shadow: 1px 1px 2px 0px rgba(194,194,194,1);
    box-shadow: 1px 1px 2px 0px rgba(194,194,194,1);
}
.box-border-radius {
    border-radius: 8px;
    -webkit-border-radius: 8px;
    -moz-border-radius: 8px;
    -ms-border-radius: 8px;
    -o-border-radius: 8px;
}
.icon-size-60 {
    font-size: 60px !important;
}
.fa-users-class:before {
    content: "\f63d";
}
.fad.fa-users-class:after {
    content: "\10f63d";
}
.resources .box-middle {
    margin-bottom: 24px;
}
.list-bullet li {
    font-size: 14px;
    line-height: 24px;
    position: relative;
    padding-left: 23px;
    margin-bottom: 9px !important;
}
.list-bullet li:before {
    display: inline-block;
    height: 15px;
    width: 15px;
    position: absolute;
    top: 5px;
    left: 0px;
    background: #ff993e;
    border-radius: 50%;
    content: "\f105";
    color: white;
    font-family: "Font Awesome 5 Regular";
    -webkit-border-radius: 50%;
    -moz-border-radius: 50%;
    -ms-border-radius: 50%;
    -o-border-radius: 50%;
    display: flex;
    justify-content: center;
    align-items: center;
    padding-left: 2px;
    font-size: 15px;
}
.icon-user-class:before {
    content: "\f63d";
    font-family: "Font Awesome 5 Light";
}
.icon-fa-box:before {
    /* font-family: "Font Awesome 5 Solid"; */
    font-size: 18px;
    height: auto;
    left: 0px;
    position: absolute;
    top: 0px;
}
</style>
<script>
$(document).ready(function(){
	$("#dashboardCommiteesTeamsLoader").fadeOut();
})
</script>