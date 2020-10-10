<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<link rel="stylesheet" type="text/css" href="/o/ahea-theme/css/jquery-ui.css">

<script src="/o/ahea-theme/js/jquery-3.1.1.js"></script>
<script src="/o/ahea-theme/plugins/jquery-ui/jquery-ui.min.js"></script>

<style>
.wrap-input-calendar .form-group {
	position: relative;
}
.wrap-input-calendar .form-group .control-label:after {
    color: #414142;
    content: "\f073";
    font-family: "Font Awesome 5 Solid";
    font-size: 20px;
    height: 25px;
    right: 2px;
    position: absolute;
    top: 35px;
    width: 25px;
}
.form-group .form-control.datepicker.disabled {
    pointer-events: none !important;
    background-color: #e9ecef !important;
    opacity: 1;
}
.btn-grey {
    background: #989899;
}
.uploadCCD {
    position: relative;
    overflow: hidden;
}
.uploadCCD .form-group {
    position: absolute;
    top: 0;
    z-index: -1;
    opacity: 0;
}
.cl-blue {
    color: #0099ff !important;
}
.box-subhead i, .box-subhead span {
    position: absolute;
    left: 0px;
    top: 3px;
}
.icon-regular::before, .icon-regular::after {
    font-family: 'Font Awesome 5 Regular';
}
.icon-book-title:before {
    content: "\f02d";
}
</style>

<script>
var A=AUI();
$(document).ready(function(){
	
	$("#triggerFileUpload").on("click", function(){
		$("#<portlet:namespace/>courseControlDocument").trigger("click");
	})
	
	$("input[name='<portlet:namespace/>role']").click(function() {
        var role = $(this).val();
		if(role === "Ongoing") {
			$("#<portlet:namespace/>projectEndDate").addClass("disabled");
		} else {
			$("#<portlet:namespace/>projectEndDate").removeClass("disabled");
		}
    });
	
	var url_string = '<%=themeDisplay.getURLPortal()+themeDisplay.getURLCurrent() %>';
	var url = new URL(url_string);
	var param = url.searchParams.get("projectId");
	debugger;
	if(param!="" && param!=null && param!="null"){
		getProjectDetailsCreation(param);
	}else{
		getProjectDetailsCreation(0);
	}
	$("#<portlet:namespace/>projectDiscipline1").on("change", function(){
		var selectedDiscpiline = $(this).val();
		$("#<portlet:namespace/>projectDiscipline2 option[value='"+selectedDiscpiline+"']").remove();
		$("#<portlet:namespace/>projectDiscipline3 option[value='"+selectedDiscpiline+"']").remove();
	});
	$("#<portlet:namespace/>projectDiscipline2").on("change", function(){
		var selectedDiscpiline = $(this).val();
		$("#<portlet:namespace/>projectDiscipline3 option[value='"+selectedDiscpiline+"']").remove();
	});

	  	
	from = $( "#<portlet:namespace/>projectStartDate" ).datepicker({
		dateFormat: 'yy-mm-dd',
		changeMonth: true,
		changeYear: true,
		minDate: 0,
		onClose:function(selectedDate) {
			debugger;
			$( "#<portlet:namespace/>projectEndDate" ).datepicker( "option", "minDate", selectedDate);
	          $(this).removeClass("error-field");
				$(this).parent(".form-group").removeClass("has-error");
				$(this).siblings(".help-block").remove();
	      }
	}).datepicker('setDate',new Date());
	to = $( "#<portlet:namespace/>projectEndDate" ).datepicker({
		dateFormat: 'yy-mm-dd',
		changeMonth: true,
		changeYear: true,
		minDate: 0,
		onClose:function(selectedDate) {
			$( "#<portlet:namespace/>projectStartDate" ).datepicker( "option", "maxDate", selectedDate );
			$(this).removeClass("error-field");
			$(this).parent(".form-group").removeClass("has-error");
			$(this).siblings(".help-block").remove();
	      }
	}).datepicker('setDate',new Date());
	
	$('#<portlet:namespace/>courseControlDocument').change(function(e) {
		var filename = e.target.files[0].name; 
        $(".fileName").html(filename); 
    });
	
});

function getDate( element ) {
    var date;
    try {
      date = $.datepicker.parseDate( dateFormat, element.value );
    } catch( error ) {
      date = null;
    }

    return date;
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
                 pageRedirect();
                 location.href="/lab-detailed-screen";
                 }
                 
                 }
               }
             
         ]
);
});

});

function pageRedirect() {
    window.location.href = "<%=themeDisplay.getURLPortal() %>"+"/lab-detailed-screen";
}   

function getProjectDetailsCreation(id){
	$("#<portlet:namespace/>interestId").val(id);
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getProjectDetailsCreation'/>"
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
                    		var data = JSON.parse(value);
                    		$("#<portlet:namespace/>projectTypeSave").val(data.projectType);
                    		$("#<portlet:namespace/>projectType").val(data.projectType);
                    		$("#<portlet:namespace/>projectDescription").val(data.description);
                    		$("#<portlet:namespace/>projectDiscipline1").val(data.discipline1);
                    		$("#<portlet:namespace/>projectDiscipline2").val(data.discipline2);
                    		$("#<portlet:namespace/>projectDiscipline3").val(data.discipline3);
                    		$(".courseControlDoc").show();
                    		
                    		if(data.isEdit=="Yes"){
	                    		 //$("#<portlet:namespace/>projectDiscipline3").val(data.discipline3);
	                    		$("#<portlet:namespace/>projectStartDate").val(data.startDate);	                    		
	                    		$("#<portlet:namespace/>projectCreationId").val(data.projectCreationId);
	                    		$("#<portlet:namespace/>projectName").val(data.projectName);
	                    		$(".courseControlDoc").hide();
	                    		if(data.role=="Ongoing") {
	                    			$("#<portlet:namespace/>ongoing_checked").attr("checked",true);
	                    			$("#<portlet:namespace/>projectEndDate").addClass("disabled");
	                    		} else if(data.role=="Fixed") {
	                    			$("#<portlet:namespace/>fixed_checked").attr("checked",true);
	                    			$("#<portlet:namespace/>projectEndDate").val(data.endDate);
	                    			$("#<portlet:namespace/>projectEndDate").removeClass("disabled");
	                    		}
	                    		
	                    		$("#<portlet:namespace/>role").attr("checked","true");
	                    		$("#createEditProjectBC, #editHeading").html("Edit Project");
	                    		$("#<portlet:namespace/>endProject").removeClass("d-none");
	                    		$("#<portlet:namespace/>creatSaveProject").html("Save");
                    		}
                    	}
                    },error: function(){	             
                    }
				},

	         });
		});
}

function saveProjectCreation(){
	/* if($(".fileName").text()!=""){ */
		AUI().use('aui-io-request-deprecated', function(A){
			A.io.request("<portlet:resourceURL id='projectCreation'/>", {
               method: 'post',
               form: {
                   id: '<portlet:namespace/>ProjectCreationForm',
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
            		   if(data.details[1].responseText=="add"){
            			   showMsg("Saved successfully");
            			   window.location.href = "<%=themeDisplay.getURLPortal() %>"+"/lab-detailed-screen";
            			   document.getElementById("<portlet:namespace/>ProjectCreationForm").reset();
            		   }else if(data.details[1].responseText=="update"){
            			   showMsg("Updated successfully");
            			   location.href="/lab-detailed-screen";
            		   }else{
            			   //showMsg("Not saved");
            		   }
                   },
                   failure:function(data){
                	   //$("#wait").hide();
                   }
               }
            });
    	});
	/* } */
}

/* function readSingleFile(evt) {
    var f = evt.target.files[0]; 
    if (f) {
      var r = new FileReader();
      r.onload = function(e) { 
          var contents = e.target.result;
          document.write("File Uploaded! <br />" + "name: " + f.name + "<br />" + "content: " + contents + "<br />" + "type: " + f.type + "<br />" + "size: " + f.size + " bytes <br />");

          var lines = contents.split("\n"), output = [];
          for (var i=0; i<lines.length; i++){
            output.push("<tr><td>" + lines[i].split(",").join("</td><td>") + "</td></tr>");
          }
          output = "<table>" + output.join("") + "</table>";
          document.write(output);
     }
      r.readAsText(f);
      document.write(output);
    } else { 
      alert("Failed to load file");
    }
  } */
</script>