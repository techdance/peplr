<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<link rel="stylesheet" href="https://www.jqueryscript.net/demo/Year-Picker-Text-Input/yearpicker.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.css">
<%-- <portlet:resourceURL var="addTask" id="addTask"></portlet:resourceURL> --%>
<style>
.ar {
    text-align: right;
}
.color-blue {
    color: #247aba !important;
}
.table tbody td {
    font-weight: normal;
    padding: 8px 8px;
}
.table3 thead th{
	font-size: 20px !important;
	text-align:left !important;
	text-transform: initial !important;
	padding:5px 10px !important;
}
.table3  td{
	color:#7a7a7a !important;
	font-size: 16px !important;
	line-height: 1.5 !important;
}
.table3 thead th.td-center{
	text-align:center !important;
}
.table3 thead th.td-left{
	text-align:left !important;
}
.table3 thead th.td-right{
	text-align:right !important;
}

.modal .interest-modal{
	bottom: inherit;
	display: block;
	left: inherit;
	overflow: hidden;
	position: relative;
}

.modalareainterest .modal-header{
	background: #f1f3f7;
	border-radius: inherit !important;
	-webkit-border-radius: 0 !important;
	-moz-border-radius: 0 !important;
	color:black;
	height: auto;
    padding: 8px;
}
.modalareainterest .modal-dialog,
.modalareainterest .modal-content {
    min-width: 380px;
    max-width: 500px;
}
.modalareainterest .modal-body {
    margin-left: 0px;
    margin-right: 0px;
    max-width: inherit;
}
.modalareainterest .interest-modal {
    background: rgba(129,140,147,0.9);
    border: none;
    color: white;
    padding: 15px;
}
.modalareainterest .modal-body .form-group .control-label {
    font-size: 14px;
    line-height: 1.5;
    color: white;
    font-weight: 400;
    margin: 0;
}
.yui3-widget-mask,
.yui3-widget.modal-dialog {
	z-index: 1100 !important;
}
</style>

<script>
<%-- var A=AUI();

$(document).ready(function(){
	$( "#<portlet:namespace/>dueDate" ).datepicker({
		dateFormat: 'mm-dd-yy',
		changeMonth: true,
		changeYear: true,
		minDate: 0,
		onClose:function() {
			$(this).removeClass("error-field");
			$(this).parent(".form-group").removeClass("has-error");
			$(this).siblings(".help-block").remove();
	      }
	});
	loadTask();
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
			        zIndex: 1100,
			        width: 305,
			        toolbars: {
			        		 header: []
			         },
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

function addTask(){
	AUI().use('aui-io-request-deprecated', function(A){
        A.io.request('<%=addTask.toString()%>', {
               method: 'post',
               form: {
                   id: '<portlet:namespace/>addTaskForm',
                   upload:true
               },
               cache: false,
               contentType: false,
               processData: false,
               on: {
            	   start:function(){
            		   //$("#wait").show();
            	   },
            	   complete: function(data){
            		   debugger;
            		   if(data.details[1].responseText!=null && data.details[1].responseText=="add"){
            			   $("#addTask").modal("hide");
            			   //$(".modal-backdrop.fade.show").css("opacity","0");
            			   showMsg("Added successfully");
            			   loadTask();
            		   }else{
            			   showMsg("Error!!");
            		   }
                   },
                   failure:function(data){
                	   //$("#wait").hide();
                   }
               }
            });
    	});
}

function clearTask(){
	$("#<portlet:namespace/>dueDate").val("");
	$("#<portlet:namespace/>projectAssignedTo").val("");
	$("#<portlet:namespace/>taskName").val("");
}

function loadTask(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='viewTask'/>"
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
                    	if(value!=null && value!="undefined" && value!=undefined){
                    		$("#taskOverview").html("");
                    	    $("#taskOverview").html(value);
                 	   }
                    },error: function(){	             
                    }
				},

	         });
		});
} --%>
</script>

