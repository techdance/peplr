<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />


<script>
var A=AUI();
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
</script>