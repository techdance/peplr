jQuery(document).ready(function(){ 
		jQuery('.sub-menu .sub-sub-menu').hide();

		jQuery('.sub-menu a').click(function(){
			// hide all .sub-sub-menu
			var $this = jQuery(this).parent().find('.sub-sub-menu');
			jQuery(".sub-menu .sub-sub-menu").not($this).slideUp();
			
			// here is what I want to do
			$this.slideToggle();				
		});

		jQuery("a#menu-button-responsive").click(function(){
			
			if ( jQuery( "#sidebar-content-mobile" ).is( ":hidden" ) ) {
				jQuery("#container").css("margin-top","0px");
			}else{
				jQuery("#container").css("margin-top","70px");
			}

			jQuery("#sidebar-content-mobile").slideToggle();
		});

		jQuery('#sidebar-content-mobile #nav li').click(function(e){
			jQuery("#sidebar-content-mobile #nav li ul.sub-menu").hide();
			jQuery(this).find("ul.sub-menu").show();
		});
		//jQuery("#menu-button-hide-show").click(function(){
			//jQuery(".group-hide").toggle();
			//jQuery("#sidebar").toggleClass("hidden");
		//});
		$('#sidebar ul#nav li a').each(function() { 
			   var menuVal=$(this).attr("href"); 
			var menuimg=menuVal.split("/").pop();
			$(this).find('span').addClass(menuimg);
		});
		$("#sidebar ul#nav li a span.my-tiles").append("<span class='note'><span class='outer'>12</span></span>")
		
		jQuery("#menu-button-hide-show").click(function(){
			if(jQuery( "#sidebar" ).hasClass( "hidden" ))
				jQuery(this).html("<i class='fas fa-arrow-circle-left'></i>");
			else
				jQuery(this).html("<i class='fas fa-arrow-circle-right'></i>");
			jQuery(".group-hide").toggle();
			jQuery("#sidebar").toggleClass("hidden");
		});
		
	});	

jQuery(function() {
	jQuery('.sortable').sortable({
		placeholderClass: 'col-lg-3'
	});
	
	
});

jQuery(function() {
	jQuery("ul#nav ul > li").click(function(){
		/*jQuery("ul#nav li.active ul").hide();
		jQuery("ul#nav ul li").removeClass("active");
		jQuery(this).addClass("active");
		jQuery(this).find("ul.sub-sub-menu").toggle();*/

		jQuery("a#menu-button-responsive").click(function(){
			jQuery("#sidebar-content").slideToggle()
		});
	});
});

jQuery(function() {
	// jQuery("#btn-badges, .toltip-close a").click(function(){
	// 	jQuery("#badges-toltip").slideToggle();
	// 	jQuery("#btn-badges .note").slideToggle();
	// });

	// jQuery("#btn-notification").click(function(){
	// 	jQuery("#notification-toltip").slideToggle();
	// 	jQuery("#btn-notification .note").slideToggle();
	// });

	// jQuery(".toltip-close-details a.close-this").click(function(){
	// 	jQuery(this).closest(".toltip-item").attr('style','display:none !important');
	// });
});

jQuery(function() {
	jQuery(document).click(function () {
        jQuery('.any-toltip').slideUp();
	});
	
	jQuery("#btn-badges, .toltip-close a").click(function(e){
		e.stopPropagation();
		jQuery("#badges-toltip").slideToggle();
		jQuery("#btn-badges .note").slideToggle();
	});

	// jQuery("#btn-notification").click(function(e){
	// 	e.stopPropagation();
	// 	jQuery("#notification-toltip").slideToggle();
	// 	jQuery("#btn-notification .note").slideToggle();
	// 	jQuery("#email-toltip").hide();
	// 	jQuery("#btn-email .note").hide();
	// 	jQuery("#user-toltip").hide();
	// });

	// jQuery(".toltip-close-details a.close-this").click(function(){
	// 	jQuery(this).closest(".toltip-item").attr('style','display:none !important');
	// });

	// jQuery("#btn-email").click(function(e){
	// 	e.stopPropagation();
	// 	jQuery("#email-toltip").slideToggle();
	// 	jQuery("#btn-email .note").slideToggle();
	// 	jQuery("#notification-toltip").hide();
	// 	jQuery("#btn-notification .note").hide();
	// 	jQuery("#user-toltip").hide();
	// });

	// jQuery("#btn-user").click(function(e){
	// 	e.stopPropagation();
	// 	jQuery("#user-toltip").slideToggle();
	// 	jQuery("#email-toltip").hide();
	// 	jQuery("#btn-email .note").hide();
	// 	jQuery("#notification-toltip").hide();
	// 	jQuery("#btn-notification .note").hide();
	// });

	// jQuery(".toltip-header-right a.icon-close").click(function(){
	// 	jQuery(this).closest(".toltip-item").attr('style','display:none !important');
	// });
	
	jQuery(".box-top .icon-box").click(function(e){ 
		e.stopPropagation();
		jQuery(this).siblings(".toltip2").slideToggle();
	});

	jQuery("a.btn-remove").click(function(e){
		e.stopPropagation();
		jQuery(this).closest(".col-lg-3").toggle("slide",{ direction: "left" }, 1000);
	});

	jQuery(".partner-img").click(function(e){
		e.stopPropagation();
		jQuery(this).find(".toltip3").slideToggle();
	});

	jQuery("#partner-search, .btn-close").click(function(e){
		e.stopPropagation();
		jQuery("#search-toltip").slideToggle();
	});
	jQuery('.datepicker').datepicker({
		changeMonth: true,
		changeYear: true,
		dateFormat: 'dd-mm-yy'
	});
});

Liferay.provide(window,'showMsg',function(msg){	
	AUI().use(
			  'aui-modal',
			  function(A) {
			    var modal = new A.Modal(
			      {
			    	  centered: true,
			        headerContent: '<center><h4 class="font-weight-semibold m-0"> Message</h4></center>',
			        modal: true,
			        render: '#modal',
			        toolbars: {
			        		 header: []
			         },
			        width: 305,
			        zIndex:1,
			      }
			    ).render();
	
  	  modal.set('bodyContent', msg);
			    
	modal.addToolbar(
    	      [
    	        {
    	            label: 'OK',
    	            on: {
    	              click: function() {
    	            	  modal.hide();
    	            	  
    	              }
    	               
    	              }
    	            }
    	          
    	      ]
		);
});
});