AUI().ready(
	'liferay-hudcrumbs', 'liferay-navigation-interaction', 'liferay-sign-in-modal',
	function(A) {
	
		$(".form-control").val("");
		
		
	}
);

Liferay.Portlet.ready(

		/*
		This function gets loaded after each and every portlet on the page.

		portletId: the current portlet's id
		node: the Alloy Node object of the current portlet
		*/

		function(portletId, node) {
			$(".form-control").val("");
		}
	);

Liferay.on(
	'allPortletsReady',

	/*
	This function gets loaded when everything, including the portlets, is on
	the page.
	*/
	
	function() {
		$(".form-control").val("");
	}
);
