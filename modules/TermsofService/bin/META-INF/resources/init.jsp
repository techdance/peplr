<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>
body{
    color:#404040;
    line-height: 1.5
}
p {
	margin-top: 1em;
	background: transparent;
}
#content{
	background: #fff;
}
#sidebar {
	display: none;
}
h1.title,h2.title{
    border-bottom:1px solid #abca37;
    font-weight: normal;
    font-size: 26px;
    margin:auto;
    max-width: 580px;
    text-align: center;
}
h2.title{
    border:none;
    font-size: 16px;
    margin-top:5px;
    margin-bottom: 80px;
}
h3.title{
    color:#abca37;
    font-weight: bold;
    font-size: 14px;
}
.container.terms{
    margin:auto auto 50px auto;
    max-width: 1100px;
}
.wrap-logo{
    margin-bottom: 70px;
}
.wrap-logo img{
    height: auto;
    max-width: 247px;
    width: 100%;
}
</style>