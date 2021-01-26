<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<link rel="stylesheet" href="https://www.jqueryscript.net/demo/Year-Picker-Text-Input/yearpicker.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.js"></script>
<script src="https://www.jqueryscript.net/demo/Year-Picker-Text-Input/yearpicker.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ion-rangeslider/2.3.1/css/ion.rangeSlider.min.css"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/ion-rangeslider/2.3.1/js/ion.rangeSlider.min.js"></script>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>
.yui3-widget-ft.modal-footer .btn-toolbar-content {
    width: 100%;
    display: flex;
    justify-content: center;
}
.block-invite-content .item-img{
	margin-right: 30px;
}
.block-invite-content .invites-head{
	font-weight: bold;
	font-size: 16px;
	margin-bottom: 5px;
}
.block-invite-content .invites-content{
	font-size: 14px;
	margin-bottom: 12px;
}
.block-invite-content .invites-date{
	color:#a4a4a4;
	font-size: 14px;
}
.block-invite-inner{
	align-items: center;
	display: flex;
	margin-top:30px;
}
.block-invite-inner a{
	font-weight: normal !important;
}
.table-invite td {
    border-bottom: 2px solid #a4a4a4 !important;
    vertical-align: top !important;
    padding: 25px 8px 20px!important
    font-size: 13px !important;
    font-weight: normal!important;
}
.table-invite td.border-bottom-none{
	border-bottom: 2px solid transparent!important
}
.nav-tabs .nav-item a.active {
	background: rgba(0, 0, 0, 0) linear-gradient(rgb(42, 158, 255) 0%, rgb(125, 185, 232) 0%, rgb(125, 185, 232) 0%, rgb(125, 185, 232) 21%, rgb(125, 185, 232) 21%, rgb(32, 124, 202) 71%, rgb(32, 124, 202) 78%, rgb(32, 124, 202) 78%, rgb(32, 124, 202) 78%, rgb(41, 137, 216) 100%) repeat scroll 0% 0% !important;
}
.btn-sm {
    padding: 9px 10px !important;
}

/* Modal */
.modalareainterest .modal-dialog {
	position: relative;
    max-width: 500px;
    margin: 1.75rem auto;
}
.modalareainterest .modal-header {
    background: #f1f3f7;
    border-radius: inherit !important;
    -webkit-border-radius: 0 !important;
    -moz-border-radius: 0 !important;
    color: black;
}
.toltip-close3 {
    position: absolute;
    top: 5px;
    right: 8px;
}
.toltip-close2 a, .toltip-close3 a {
    color: #818c93;
    font-size: 20px;
}
.font15 {
    font-size: 15px !important;
    line-height: 1.5;
}
.modalareainterest .modal-body {
    background: rgba(129,140,147,0.9);
    border: none;
    color: white;
    font-size: 14px;
    line-height: 1.5;
    padding: 15px;
    text-align: left;
}



.irs-grid-pol {
    display: none !important;
}
.irs-grid-pol.small {
    display: none !important;
}
span.irs-grid-text.js-grid-text-0 {
    display: block;
    left: -9px !important;
    margin-left: 0px !important;
}


.irs--big .irs-handle {
    top: 6px !important;
    width: 10px !important;
    height: 20px !important;
    border: 1px solid rgba(0,0,0,0.3);
    background-color: #cbcfd5;
    background: linear-gradient(to bottom, white 0%, #B4B9BE 30%, white 100%);
    box-shadow: 1px 1px 2px rgba(0,0,0,0.2), inset 0 0 3px 1px white;
    border-radius: 0px !important;
    -webkit-appearance: slider-horizontal !important;
}
.irs--big.irs-with-grid {
     height: 50px !important; 
}
.irs--big .irs-bar {
    top: 14px !important;
  }
.irs--big .irs-single {
    display: block;
       top: -10px !important;
}
.irs--big .irs-line {
    height: 4px !important;
        top: 14px !important;
}
.irs--big .irs-grid-text {
    color:white !important;
    font-family: 'Merriweather Sans',sans-serif;
    font-size: 12px;
}
.irs--big .irs-bar {
    top: 33px;
    height: 4px  !important;
    background-color: #f2f2f2;
    border: none  !important;
    background: #eaeaea  !important;
}
  .irs--big .irs-min, .irs--big .irs-max {
    font-family: 'Merriweather Sans',sans-serif;
    top: 0;
    padding: 1px 0px;
    color: white;
    text-shadow: none;
    background-color: #818c93;
    border-radius: 3px;
    font-size: 14px;
}
.irs--big .irs-min, .irs--big .irs-max {
    top: 0;
    padding: 1px 0px !important;
    color: white !important;
    text-shadow: none;
    background-color: transparent !important;
    border-radius: 3px;
    visibility: visible !important;
}
.irs-min {
    display: none !important;
}
span.irs-max,.irs-from ,.irs-to ,.irs-single {
    display: none;
}
.yearpicker-container {
    z-index: 9999;
}
.rangerDisabled {
	opacity: .85;
	pointer-events: none;
	cursor: not-allowed;
}
.pickerdata input {
    text-align: right;
    background: transparent;
    border: none;
    color: white;
    cursor: pointer;
}
.top-label-range {
    display: flex;
    justify-content: space-between;
}
.disableField {
    pointer-events: none;
}
.person-img img {
    width: 95px;
    height: 95px;
    object-fit: cover;
    border-radius: 50%;
}

/* Modal */
#view-more-interest-modal{
	display:none;
}
.interestModal .modal-header {
	justify-content: center;
	border-radius: 0;
	background: #f1f3f7;
	font-size: 20px;
    line-height: 1.5;
    padding: 8px;
    text-align: center;
}
.interestModal .modal-header a i {
	width: auto;
	color: inherit;
	font-size: inherit;
}
.interestModal .modal-dialog {
	position: relative;
	max-width: 500px;
}
.interestModal .modal-content {
	border-radius: 0;
	background: transparent;
    border: 0;
}
.interestModal .modal-body {
	background: rgba(129,140,147,0.9);
    border: none;
    color: white;
    font-size: 14px;
    line-height: 1.5;
}

</style>

<script>
var A=AUI();
$(document).ready(function(){	
	loadProjectInvites('receive');
	$('.nav-tabs a[href="#discussion"]').click(function(){ 
		loadProjectInvites('receive');
	});
	$('.nav-tabs a[href="#file"]').click(function(){ 
		loadProjectInvites('sent');
	});
	
	/* $('.nav-tabs a[href="#file"]').trigger("click", function(){ 
		loadProjectInvites('sent');
	}); */
	
	ranger();
	
});

$(window).on("load", function(){
	ranger();
})

function ranger() {

	function formatDate(date) {
		  var monthNames = [
		    "Jan", "Feb", "Mar",
		    "Apr", "May", "Jun", "Jul",
		    "Aug", "Sept", "Oct",
		    "Novr", "Dec"
		  ];

		  var day = date.getDate();
		  var monthIndex = date.getMonth();
		  var year = date.getFullYear();

		  return  monthNames[monthIndex] +  ' ' + year;
		}

	
	/* document.getElementById("projectInviteDay").innerHTML = formatDate(new Date()); */
	document.getElementById("projectInviteDay").innerHTML = new Date().getFullYear();
	
	var lang = "en-US";
  var year = 2018;
  
  function dateToTS (date) {
      return date.valueOf(); 
  }
  
  function tsToDate (ts) {
      var d = new Date(ts);
  
      return d.toLocaleDateString(lang, {
          month: 'short',
      });
  }
  var da = new Date();
  if (da.getMonth() == 11) {
      var current = new Date(da.getFullYear() + 1, 0, 1);
  } else {
      var current = new Date(da.getFullYear(), da.getMonth() + 11, 1);
  }
  
  
  $(".js-range-slider").ionRangeSlider({
  	skin: "round",
  	type: "single",
      grid: true,
      grid_num: 11,
      /* min:dateToTS(new Date()),
      max: dateToTS(current), */       
      prettify: tsToDate, 
      /* from: dateToTS(new Date()), */
      
  });
  var end_year = da.getFullYear() + 15;
  var nd = new Date();
  nd.setFullYear(end_year)
  
  console.log(nd,"end_date")
	 $( ".rangerDatepickerPID" ).datepicker({
		 format: "yyyy",
	     viewMode: "years", 
	     minViewMode: "years",
	     autoclose: true,
	     startDate : new Date(),
	     endDate : nd
	 });
}

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

Liferay.provide(window,'showSuccessMsg',function(msg){
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

function loadProjectInvites(key){
	if(key=='sent'){
   		$(".block-invite-sent-content").html("");
   	}else{
   		$(".block-invite-receive-content").html("");
   	}	  
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='loadProjectInvites'/>"
		,{
              method: 'post',
              data:{
            	  '<portlet:namespace/>key':key
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
	                   		if(key=='sent'){
		                   		$(".block-invite-sent-content").html(value);
		                   	}else{
		                   		$(".block-invite-receive-content").html(value);
		                   	}
	                	}
                   	
                   },error: function(){	             
                   }
			},

         });
	});
}

/* function updateProjectInviteStatus(status,inviteId){
	if(status==1){
		confirmationFunction(status,inviteId);
	}else{
		updateInviteStatus(status,inviteId);
	}
} */

function updateProjectInviteStatusDeclined(status,inviteId){
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
	  	       			AUI().use('aui-io-request-deprecated', function(A){
	  	       			A.io.request("<portlet:resourceURL id='updateProjectInvites'/>"
	  	       			,{
	  	       	              method: 'post',
	  	       	              data:{
	  	       	            	  '<portlet:namespace/>status':status,
	  	       	            	  '<portlet:namespace/>inviteId':inviteId
	  	       	              },
	  	       	              sync : true, 
	  	       	              on:{
	  	       	           	   complete:function()
	  	       	            		{		            		   
	  	       	            		},
	  	       	                   success:function()
	  	       	                   {			                    	
	  	       	                	    var value=this.get('responseData');
	  	       	                  		if(value!=null && value!="undefined" && value!=undefined && value=="saved"){                
	  	       	                  			//showSuccessMsg("Saved");
	  	       	                  			loadProjectInvites('receive');
	  	       	                  			getMyNotificationCount();
	  	       		               	    }else{
	  	       		               	    	showMsg("Error!");
	  	       		               	    }                 
	  	       	                   	
	  	       	                   },error: function(){	             
	  	       	                   }
	  	       				},

	  	       	         });
	  	       		});
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

function updateProjectInviteStatus(status,inviteId){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='updateProjectInvites'/>"
		,{
              method: 'post',
              data:{
            	  '<portlet:namespace/>status':status,
            	  '<portlet:namespace/>inviteId':inviteId
              },
              sync : true, 
              on:{
           	   complete:function()
            		{		            		   
            		},
                   success:function()
                   {			                    	
                	    var value=this.get('responseData');
                  		if(value!=null && value!="undefined" && value!=undefined && value=="saved"){                
                  			//showSuccessMsg("Saved");
                  			loadProjectInvites('receive');
                  			getMyNotificationCount();
	               	    }else{
	               	    	showMsg("Error!");
	               	    }                 
                   	
                   },error: function(){	             
                   }
			},

         });
	});
}



function getViewMoreData(id){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getViewMoreData'/>"
			,{
               method: 'post',
               data:{
            	   '<portlet:namespace/>key':id
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
                    		var j = JSON.parse(value);
                    		console.log(j.rangerData.endMonth);
                    		console.log(j.rangerData.endYear);
                    		$("#popup-"+id).html(j.template);
                    		
                    		setTimeout(function(){ 
                    			
                    			  $(".js-range-slider").ionRangeSlider({
                    				    skin: "round",
                    				    grid: true,
                      			  		type: "single",
                    			        values: [
                    			            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
                    			            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
                    			        ],
                    			        from_value: j.rangerData.endMonth,
                    			    });
                    		}, 1000);
                 	   	}
                    },error: function(){	             
                    }
				},

	         });
		});
}

/* function confirmationFunction(status,inviteId){
	var execute = false;
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
	  	       				updateInviteStatus(status,inviteId)
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
} */
</script>