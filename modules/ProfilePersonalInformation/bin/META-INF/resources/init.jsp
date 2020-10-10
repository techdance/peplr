<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>
.yui3-widget-ft.modal-footer {
    display: block;
}
</style>

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
			        zIndex:9,
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


function loadUserInfo(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getProfileData'/>"
			,{
               method: 'get',
               data:{ 		            	   
               },
               sync : true, 
               on:{
            	   complete:function()
             		{		            		   
             		},
                    success:function()
                    {			                    	
                    	var value=this.get('responseData');	
                    	debugger;
                    	if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                    		var data = JSON.parse(value);
         	        		$("#<portlet:namespace/>firstName").val(data.firstName);
         	                $("#<portlet:namespace/>lastName").val(data.lastName);
         	                $("#<portlet:namespace/>jobTitle").val(data.jobTitle);
         	                $("#<portlet:namespace/>prefixValue").val(data.prefixValue);
         	               // $("#<portlet:namespace/>status").val(data.status);
         	                $("#userImage").attr("src",data.profileImage);
         	               // $("#<portlet:namespace/>ExpandoAttribute--profileStatus--").val(data.profileStatus);
         	                //$("input[id*='profileStatus']").val(data.profileStatus);
         	                $(".profile-status").find("textarea").val(data.profileStatus);
         	                $("input[name=<portlet:namespace/>ExpandoAttribute--onlineStatus--][value="+data.onlineStatus+"]").attr('checked', 'checked');
         	              // $("input[name=<portlet:namespace/>ExpandoAttribute--onlineStatus--][value="+data.onlineStatus+"]").attr('checked', 'checked');
                 	   }
                    },error: function(){	             
                    }
				},

	         });
		});
}

function removeProfileImage()
{
	AUI().use('aui-io-request-deprecated','aui-modal', function(A){
		var modal = new A.Modal(
			      {
			    	bodyContent: '<center> Are you Sure ? </center>',
			        centered: true,
			        headerContent: '<center>Message</center>',
			        modal: true,
			        render: '#modal',
			        zIndex: 9,
			        toolbars: {
			        		 header: []
			         },
			        width: 305
			      }
			    ).render();
		
			modal.addToolbar(
	  	      [
	  	        
	  	          {
	  	            label: 'Okay',
	  	            on: {
	  	              click: function() {
	  	       				modal.hide();
	  	    				deleteProfileImage();
 	  	    			   }
	  	              }
	  	            },
  	       			{
	  	            	label: 'Cancel',
	  	            	on:{
	  	              		click: function()
	  	              		{
	  	          	 			modal.hide();
	  	              		}
	  	            }
	  	          }
	  	      ]
	  	    );
	});
}

function deleteProfileImage(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='removeProfileImage'/>"
			,{
               method: 'get',
               data:{ 		            	   
               },
               sync : true, 
               on:{
            	   complete:function()
             		{		            		   
             		},
                    success:function()
                    {			                    	
                    	var value=this.get('responseData');
                    	if(value!=null && value!="undefined" && value!=undefined && value=="removed"){
                    		showMsg("Removed successfully");
                    		loadUserInfo();
                 	    }else{
                 	    	showMsg("Error!");
                 	    }                    	
                    },error: function(){	             
                    }
				},

	         });
		});
}


</script>