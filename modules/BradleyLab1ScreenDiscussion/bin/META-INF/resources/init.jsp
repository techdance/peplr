<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>
.box-subhead i, .box-subhead span {
    position: absolute;
    left: 0px;
    top: 3px;
}
.icon-comments-alt::before {
    content: "\f4b6";
    font-family: 'Font Awesome 5 Regular';
}
.ac {
    text-align: center;
}
.font12 {
    font-size: 12px !important;
    line-height: 1.5;
}

.wrap-top-search{
	float:right;
}
.top-search{
    display:flex;
    justify-content: flex-end;
}
.box-search {
    background:#fff;
    font-style: italic;
    margin-right: 8px;
}
.box-search button{
    border:0px;
    background: none;
}
.box-search input{
    border:0px;
    background: none;
    width: 170px;
}
.top-search form{
    max-width:225px;
    width:100%;
}
.top-search form input[type="text"]{
    padding:5px 15px;
    display:inline-block;
    vertical-align:middle;
}
.top-search form button{
    color:#aeaeae;
    display:inline-block;
    margin-right: 10px;
    vertical-align:middle;
}

.top-search ::-webkit-input-placeholder { /* WebKit browsers */
	color:#aeaeae;
    font-size:14px;
    font-style:italic;
}
.top-search:-moz-placeholder { /* Mozilla Firefox 4 to 18 */
   	color:#aeaeae;
       font-size:14px;
       font-style:italic;
   	opacity:  1;
}
.top-search ::-moz-placeholder { /* Mozilla Firefox 19+ */
   	color:#aeaeae;
       font-size:14px;
       font-style:italic;
   	opacity:  1;
}
.top-search :-ms-input-placeholder { /* Internet Explorer 10+ */
   	color:#aeaeae;
}
.top-text{
	color:#2a9eff;
	font-weight: bold;
	font-style: italic;
	font-size: 12px;
	text-align: right;
}
.top-text a{
	font-style: normal;
}
.box-question{
    font-size: 38px;
}
.box h4 {
    color: #000;
    font-weight: bold;
    font-size: 18px;
    line-height: 22px;
}
.img-resp img{
	width: 100% !important;
}


.box-search-border{
	border:1px solid #ccc;
}

.tree-sidebar{
	background:#011173;
	color:white;
	padding: 10px 0px;
	width:300px;
}
.tree-folder ul,
.tree-folder li{
	list-style: none;
	padding: 0px;
	margin:0px;
}
.tree-sidebar a{
	color:white;
	display: block;
}
.tree-folder ul ul{
	margin-left:50px;
}
.tree-folder li a{
	padding:5px 20px;
}
.tree-folder ul ul li a {
    padding: 0 10px;
    color: #fff;
}
.tree-sidebar ul li.active > a {
	background: #2a9eff;
}
.tree-sidebar ul ul li.active > a {
	color: #fff;
}
.tree-folder a.active-href{
	background: #2a9eff;
}
.item-text .form-group {
	width: 100%;
	margin: 0;
}
.item-text .form-group .form-control {
    padding: 4px 10px;
    width: 100%;
    border: 1px solid #d4d4d4;
    height: 32px;
    border-radius: 5px;
}
.item-text .btn {
    width: 32px;
    min-width: 32px;
    height: 32px;
    padding: 0;
    border-radius: 50%;
    margin-left: 10px;
}
.item-text .btn span {
    display: none;
}
.block-discussion .person-top {
	font-weight: bold;
}
.item-img {
    margin-top: 12px;
    width: 80px;
}
.item-text + .item-img {
    margin-right: 0px;
    margin-left: 20px;
}
.modalareainterest .modal-dialog {
    position: relative;
}
.modalareainterest .toltip-close2 a {
    color: #fff;
    font-size: 20px;
    line-height: 20px;
    position: relative;
    z-index: 2;
}
.modalareainterest .interest-modal .form-group .form-control {
    background-color: #ececec !important;
    border: 1px solid #d4d4d4;
    padding: 6px;
    border-radius: 5px;
}
.modalareainterest .interest-modal label {
    color: #000;
    font-size: 16px;
    font-weight: 700;
    line-height: 18px;
}
#treeActiveContent a {
	display: flex;
    flex-flow: column;
}
#treeActiveContent a i {
	font-size: 76px;
	margin-bottom: 5px;
}
#pptModal .modal-dialog {
    position: relative;
    max-width: 800px;
}
#pptModal .close {
    color: white;
    font-size: 20px;
    line-height: 20px;
    font-weight: bold;
    position: absolute;
    top: 0;
    right: 0;
}
#pptModal .modal-body {
	background: rgba(129,140,147,0.9);
}
.person-bottom{
	min-height:40px;
}
.person-img img.img-circle {
    object-fit: cover;
    height: 58px;
    width: 58px;
}
.block-discussion .person-img {
	width: 58px;
    position: relative;
}
#dynamicDiscussion .odd .person-bottom {
    background: #dcebfe;
}
.toltip-close3 {
    position: absolute;
    right: 15px;
}
.toltip-close3 a {
    color: #333;
    font-size: 16px;
}
div#dynamicDiscussion {
    max-height: 33vw !important;
    overflow-y: scroll;
}
</style>

<script>
var A=AUI();
jQuery(function() {
	jQuery("#add-folder").click(function(e){
		e.stopPropagation();
		jQuery("#add-folder-modal").modal('show');
	});
	jQuery("#add-files").click(function(e){
		e.stopPropagation();
		jQuery("#add-files-modal").modal('show');
	});
	$('#<portlet:namespace />uploadedDocument').change(function() {
        if ($(this).val()) {
            error = false;
            var filename = $(this).val();
            filename = this.value.replace(/\\/g, '/').replace(/.*\//, '');
            $(this).closest('.browse-file').find('.input-values').html(filename).addClass("available");
            $("#doc-upload-chipset").html("");
            if (error) {
                parent.addClass('error').prepend.after('<div class="alert alert-error">' + error + '</div>');
            }
        }
    });
	/* setInterval(function() {
	    showDiscussionMessage();
	}, 60 * 1000); */
	setInterval(function() { 
		showDiscussionLoadMessage();
	}, 1000);
});

$(document).ready(function(){
	showDiscussionMessage();
	getFolders();
	getFilesByFolderSelection();
});



function saveFiles(action){
	if(action=='addFolder'){
		AUI().use('aui-io-request-deprecated', function(A){
	        A.io.request("<portlet:resourceURL id='saveFolder'/>", {
               method: 'post',
               form: {
                   id: '<portlet:namespace/>folderUploadForm',
                   upload:true
               },
               cache: false,
               contentType: false,
               processData: false,
               on: {
            	   start:function(){
            		   //$("#wait").show();
            	   },
            	   complete: function(value){
            		   debugger;
            		   
            		   if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                  			var j = JSON.parse(value.details[1].responseText);
                  			$("#<portlet:namespace/>parentFolderId").val(j.parentFolderId);
                  			$("#<portlet:namespace/>uploadedFile").val("");
                  			$("#add-folder-modal").modal('hide');
                  			$("#add-files-modal").modal("hide");
                  			if(j.message=="add"){
                  				showMsg("Saved successfully");
                  			}else{
                  				showMsg("Not saved");
                  			}        		
                  		}
            		    getFolders();
                   },
                   failure:function(data){
                	   //$("#wait").hide();
                   }
               }
            });
    	});
	}else if(action=='addFile'){
		AUI().use('aui-io-request-deprecated', function(A){
	        A.io.request("<portlet:resourceURL id='saveFiles'/>", {
               method: 'post',
               form: {
                   id: '<portlet:namespace/>filesUploadForm',
                   upload:true
               },
               cache: false,
               contentType: false,
               processData: false,
               on: {
            	   start:function(){
            		   //$("#wait").show();
            	   },
            	   complete: function(value){
            		   debugger;
            		    if(value!=null && value!="undefined" && value!=undefined && value!="null"){
            		    	var j = JSON.parse(value.details[1].responseText);
            		    	$("#<portlet:namespace/>uploadedFile").val("");
                  			$("#add-folder-modal").modal('hide');
                  			$("#add-files-modal").modal("hide");
	             			if(j.message=="add"){
	             				showMsg("Saved successfully");
	             			}else{
	             				showMsg("Not saved");
	             			}        	
	            		    getSelectedFolder(j.parentFolderId);
            		    }
            		   //getFilesByFolderSelection(parentFolderId);
                   },
                   failure:function(data){
                	   //$("#wait").hide();
                   }
               }
            });
    	});
	}	
}

function saveMessage(){
	if($("#<portlet:namespace/>discussionMessage").val()!=""){
		AUI().use('aui-io-request-deprecated', function(A){
	        A.io.request("<portlet:resourceURL id='saveMessage'/>", {
	           method: 'post',
	           form: {
	               id: '<portlet:namespace/>projectDiscussionForm',
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
						showDiscussionMessage();
	               },
	               failure:function(data){
	            	   //$("#wait").hide();
	               }
	           }
	        });
		});
	}	
}

function getFolders(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getFolders'/>"
		,{
              method: 'post',
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
                   		$("#dynamicfolderStructure").html("");  
                   		if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                   			var j = JSON.parse(value);
                   			$("#dynamicfolderStructure").html(j.templateFolder);
                   			$("#<portlet:namespace/>folderId").val(j.parentFolderId);
                   			$(".tree-sidebar ul li a").on("click", function(){ 
                   				$(".tree-sidebar ul li").removeClass("active"); 
                   				$(this).parent("li").addClass("active"); 
                   			});
                   		}
                   },error: function(){	             
                   }
			},

         });
	});
}

function getFilesByFolderSelection(parentFolderId){
	if(parentFolderId!=0){ $("#<portlet:namespace/>folderId").val(parentFolderId); }	
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getFilesByFolderSelection'/>"
		,{
              method: 'post',
              data:{ 	
            	  '<portlet:namespace/>parentFolderId':$("#<portlet:namespace/>folderId").val()/* ,
            	  '<portlet:namespace/>folderId':$("#<portlet:namespace/>parentFolderId").val() */
              },
              sync : true, 
              on:{
           	   complete:function()
            		{		            		   
            		},
                   success:function()
                   {			      
                	    debugger;
                   		var value=this.get('responseData');	
                   		/* $("#treeActiveContent").html(""); */
                   		$("#modalValueContent").html("");
                   		$("#treeActiveContent").html("");
                   		/* alert("#taskOverview==="+value); */
                   		if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                   			$("#treeActiveContent").html(value);
                   		}
                   		$("#treeActiveContent a").on("click", function(){ 
                   			$("#modalValueContent").html("");
                   			var modalValue = $(this).attr('data-content');
                   			
                   			var fileExtension;
                   			fileExtension = modalValue.replace(/^.*\./, '');
                   			console.log (fileExtension);
                   			if(fileExtension === "docx") {
                   				const link = document.createElement('a'); 
			                    link.href = modalValue; 
			                    link.setAttribute('download', modalValue); 
			                    document.body.appendChild(link); 
			                    link.click(); 
                   			}
                   			if(fileExtension === "jpeg" || fileExtension === "jpg" || fileExtension === "png" || fileExtension === "gif") {
                   				$("#modalValueContent").append("<img src='"+modalValue+"' class='mw-100 mh-100'>");
                   				$("#pptModal").modal("show");
                   			}
                   			if(fileExtension === "pdf") {
                   				$("#modalValueContent").append("<iframe src='"+modalValue+"' class='w-100'></iframe>");
                   				$("#pptModal").modal("show");
                   			} 
                   		});
                   },error: function(){	             
                   }
			},

         });
	});
} 

function getSelectedFolder(folderId){
	//$("#<portlet:namespace/>parentFolderId").val(folderId);
	$("#<portlet:namespace/>folderId").val(folderId);
	$(this).addClass("active-href");
	//$("#<portlet:namespace/>folderName").val(folderName);
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getFolderSelection'/>"
		,{
              method: 'post',
              data:{ 	
            	  '<portlet:namespace/>PK_parentFolderId':folderId
              },
              sync : true, 
              on:{
           	   complete:function()
            		{		            		   
            		},
                   success:function()
                   {			      
                	    debugger;
                   		var value=this.get('responseData');	
                   		if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                   			var j = JSON.parse(value);
                   			$("#<portlet:namespace/>parentFolderId").val(j.parentFolderId);
                   			$("#<portlet:namespace/>folderNameHidden").val(j.folderName);
                   			getFilesByFolderSelection(folderId);
                   			//$("#taskOverview").html(value);
                   		}
                   },error: function(){	             
                   }
			},

         });
	});
}

function showDiscussionMessage(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='showDiscussionMessage'/>"
		,{
              method: 'post',
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
                   		$("#dynamicDiscussion").html("");  
                   		if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                   			$("#dynamicDiscussion").html(value);
                   		}
                   		$("#<portlet:namespace/>discussionMessage").val("");
                   		$("#bradleyLabDiscussionScreenLoader").fadeOut();
                   },error: function(){	             
                   }
			},

         });
	});
}

function showDiscussionLoadMessage(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='showDiscussionMessage'/>"
		,{
              method: 'post',
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
                   		$("#dynamicDiscussion").html("");  
                   		if(value!=null && value!="undefined" && value!=undefined && value!="null"){
                   			$("#dynamicDiscussion").html(value);
                   		}
                   		$("#bradleyLabDiscussionScreenLoader").fadeOut();
                   },error: function(){	             
                   }
			},

         });
	});
}

</script>