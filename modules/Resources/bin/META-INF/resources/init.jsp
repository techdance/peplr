<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>
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
	    margin-bottom: 26px;
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
</style>