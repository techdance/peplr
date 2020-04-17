AUI().ready(
	'liferay-hudcrumbs', 'liferay-navigation-interaction', 'liferay-sign-in-modal',
	function(A) {
	
		/*$(".wrap-input-icon .form-control").val("");
		$('.wrap-input-icon .form-control').attr('autocomplete','off');
		$('.wrap-input-icon .form-control').click(function() {
		    $('.form-control').attr('value', '');  
		});*/
	}
);

Liferay.Portlet.ready(

		/*
		This function gets loaded after each and every portlet on the page.

		portletId: the current portlet's id
		node: the Alloy Node object of the current portlet
		*/

		function(portletId, node) {
			/*$(".wrap-input-icon .form-control").val("");
			$('.wrap-input-icon .form-control').attr('autocomplete','off');
			$('.wrap-input-icon .form-control').click(function() {
			    $('.form-control').attr('value', '');  
			});*/
		}
	);

Liferay.on(
	'allPortletsReady',

	/*
	This function gets loaded when everything, including the portlets, is on
	the page.
	*/
	
	function() {
		/*$(".wrap-input-icon .form-control").val("");
		$('.wrap-input-icon .form-control').attr('autocomplete','off');
		$('.wrap-input-icon .form-control').click(function() {
		    $('.form-control').attr('value', '');  
		});*/
	}
);
