<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.lazy/1.7.6/jquery.lazy.min.js"></script>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>
.height200{
   height:200px;
   background: rgba(230, 229, 229, 0.6196078431372549);
      margin-bottom: 20px;
}
.big-box {
  width: 100%;
  background-color: gray;
  height: 100vh;
  border-top: 1px solid black;
}
.wrap-collaborated div.asset {
    padding: 35px 10px 6px;
}
.matchingImg {
	width: 100px;
	height: 100px;
	border-radius: 50%;
	position: relative;
	overflow: hidden;
	display: block;
    margin: auto;
}
.font16 {
    font-size: 16px !important;
    line-height: 1.5;
}
.hover-underline {
    text-decoration: none !important;
}
.font-style-italic {
    font-style: italic !important;
}
	/* #portlet_com_collaborated_matching_portlet_MatchingScreenPortlet_INSTANCE_3YgDJpoVUMhb{
		margin-bottom: 0px !important;
	}
	.wrap-collaborated {
	    padding-bottom: 80px;
	}
	.wrap-collaborated div.asset {
	    padding: 35px 10px 6px;
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
	.wrap-collaborated div.asset .content-left img {
	    width: 143px;
	    height: 143px;
	    border-radius: 50%;
	}
	.wrap-collaborated .asset h2:hover {
	    color: #09f;
	    transition: .2s;
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
	} */
	
.inner-wrap-flex {
    display: flex;
    padding: 35px 10px 6px;
}
.asset .content-left {
    margin-right: 27px;
}
.wrap-collaborated .asset h2 {
    color: #000;
    font-size: 18px;
    font-weight: 700;
    line-height: 24px;
}
.hover-underline:hover {
    text-decoration: underline !important;
}
.color-blue-light, .color-blue-light-hover:hover {
    color: #2a9eff !important;
}
.asset .box-middle {
    font-size: 14px;
    line-height: 24px;
    margin-bottom: 20px;
}
.lazyLoad {
	opacity: 0;
    transition: ease all 1s;
}
.lazyLoad.fadeIn{
  opacity: 1;
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

var matchingRequestedId = 0;
var matchingDataLength = 0;
$(document).ready(function(){	
	
	$(".breadcrumb .breadcrumb-item.active").html("Matches");
	
	var url_string = '<%=themeDisplay.getURLPortal()+themeDisplay.getURLCurrent() %>';
	var url = new URL(url_string);
	var param = url.searchParams.get("randamId");
	matchingRequestedId = param; 
	if(param!="" && param!=null && param!="null"){
		getAllDetails(param);
	}else{
		//loadRecommenedPartners();
	}
		
	 /* $('.lazyLoad').lazy(); */
	 
});

(function($) {

	  /**
	   * Copyright 2012, Digital Fusion
	   * Licensed under the MIT license.
	   * http://teamdf.com/jquery-plugins/license/
	   *
	   * @author Sam Sehnert
	   * @desc A small plugin that checks whether elements are within
	   *     the user visible viewport of a web browser.
	   *     only accounts for vertical position, not horizontal.
	   */

	  $.fn.visible = function(partial) {
	    
	      var $t            = $(this),
	          $w            = $(window),
	          viewTop       = $w.scrollTop(),
	          viewBottom    = viewTop + $w.height(),
	          _top          = $t.offset().top,
	          _bottom       = _top + $t.height(),
	          compareTop    = partial === true ? _bottom : _top,
	          compareBottom = partial === true ? _top : _bottom;
	    
	    return ((compareBottom <= viewBottom) && (compareTop >= viewTop));

	  };
	    
	})(jQuery);
	
$(window).scroll(function(event) {
	  
	  $(".lazyLoad").each(function(i, el) {
	    var el = $(el);
	    if (el.visible(true)) {
	       
		  setTimeout(function(){ el.addClass("fadeIn"); }, 500);
	    } else {
		 setTimeout(function(){ el.removeClass("fadeIn"); }, 500);
	      
	    }
	  });
	  
	});
	

/* $("#card-section").append("<div class='col-md-6 col-lg-3 mb-4'> "
			+" <div class='box box-collaborated box-border-radius box-shadow bg-white'> "
			+" <div class='inner-wrap row justify-content-center align-items-center asset text-center mr-0 ml-0'> "
			+" <div class='col-md-12 pr-0 pl-0'> "
			+" <a href='#' class='matchingImg'><img src='"+data[i].imageURL+"' alt='' class='mw-100 mh-100'></a> "
			+" </div> "
			+" <div class='col-md-12 pr-0 pl-0'> "
			+" <div class='box-top position-relative'> "
			+" <h2><a href='#' class='hover-underline color-black color-blue-light-hover' onClick='goToProfile("+ data[i].userId +","+data[i].PK_areaofinterest+")'>"+data[i].userName+educationLevel+"</a></h2> "
			+" </div> "
			+" <div class='box-middle p0'> "
			+" <p>Lecturer, Business & Economics</p> "
			+" <p><span class='font-style-italic color-blue-light'>University of Dubai</span></p> "
			+" <p>Dubai, UAE</p> "
			+" <p>"+invitationButton+"</p> "
			+" </div></div></div></div></div>"); */

function getAllDetails(id){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='getAllDetails'/>"
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
                   		matchingDataLength = data.length;
                   		if(data.length>0){
                   			$("#card-section,#card-lazyload").html("");
                   			for(var i=0;i<=7;i++){
                   				var educationLevel = data[i].educationLevel;
                   				var invitationButton = "";
                   				if(data[i].educationLevel!=""){
                   					educationLevel = ", "+data[i].educationLevel;
                   				}
                   				/* if(data[i].isAlreadySent==true){
                   					invitationButton = "Already Sent Invite";
                   				}else{
                   					invitationButton = "<a href='#' class='btn btn-blue btn-tiny' onclick='sendInvite("+data[i].userId+")'>Send Invite</a>";
                   				} */
                   				
                   				if(data[i].isAlreadySent==true){
                   					//invitationButton = "Already Sent Invite";
                   				}
                   				
                   				$("#card-section").append("<div class='col-md-6 col-lg-3 mb-4 customscroll'> "
                   						+" <div class='box box-collaborated box-border-radius box-shadow bg-white'> "
                   						+" <div class='inner-wrap row justify-content-center align-items-center asset text-center mr-0 ml-0'> "
                   						+" <div class='col-md-12 pr-0 pl-0'> "
                   						+" <a href='#' class='matchingImg' onClick='goToProfile("+ data[i].userId +")'><img src='"+data[i].imageURL+"' alt='' class='mw-100 mh-100'></a> "
                   						+" </div> "
                   						+" <div class='col-md-12 pr-0 pl-0'> "
                   						+" <div class='box-top position-relative'> "
                   						+" <h2><a href='#' class='hover-underline color-black color-blue-light-hover' onClick='goToProfile("+ data[i].userId +")'>"+data[i].userName+educationLevel+"</a></h2> "
                   						+" </div> "
                   						+" <div class='box-middle p0'> "
                   						+" <p>"+data[i].position+"</p> "
                   						+" <p>"+data[i].department+"</p> "
                   						+" <p><span class='font-style-italic color-blue-light'>"+data[i].institutionName+"</span></p> "
                   						+" <p>"+data[i].institutionLocation+" "+data[i].country+ "</p> "                   	
                   						+" <p>"+invitationButton+"</p> " 
                   						+" </div></div></div></div></div>");
                   			}
                   			
                   			
                   			
                   				
                   					for(var i=8;i<=data.length;i++){
                           				var educationLevel = data[i].educationLevel;
                           				var invitationButton = "";
                           				if(data[i].educationLevel!=""){
                           					educationLevel = ", "+data[i].educationLevel;
                           				}
                           				/* if(data[i].isAlreadySent==true){
                           					invitationButton = "Already Sent Invite";
                           				}else{
                           					invitationButton = "<a href='#' class='btn btn-blue btn-tiny' onclick='sendInvite("+data[i].userId+")'>Send Invite</a>";
                           				} */
                           				
                           				if(data[i].isAlreadySent==true){
                           					//invitationButton = "Already Sent Invite";
                           				}
                           				
                           				$("#card-section").append("<div class='col-md-6 col-lg-3 mb-4 customscroll'> "
                           						+" <div class='box box-collaborated box-border-radius box-shadow bg-white'> "
                           						+" <div class='inner-wrap row justify-content-center align-items-center asset text-center mr-0 ml-0'> "
                           						+" <div class='col-md-12 pr-0 pl-0'> "
                           						+" <a href='#' class='matchingImg' onClick='goToProfile("+ data[i].userId +")'><img src='"+data[i].imageURL+"' alt='' class='mw-100 mh-100'></a> "
                           						+" </div> "
                           						+" <div class='col-md-12 pr-0 pl-0'> "
                           						+" <div class='box-top position-relative'> "
                           						+" <h2><a href='#' class='hover-underline color-black color-blue-light-hover' onClick='goToProfile("+ data[i].userId +")'>"+data[i].userName+educationLevel+"</a></h2> "
                           						+" </div> "
                           						+" <div class='box-middle p0'> "
                           						+" <p>"+data[i].position+"</p> "
                           						+" <p>"+data[i].department+"</p> "
                           						+" <p><span class='font-style-italic color-blue-light'>"+data[i].institutionName+"</span></p> "
                           						+" <p>"+data[i].institutionLocation+" "+data[i].country+ "</p> "            	
                           						+" <p>"+invitationButton+"</p> " 
                           						+" </div></div></div></div></div>");
                           			}
                   				
                   		}
                   	}
                   	
                   },error: function(){	             
                   }
			},

         });
	});
}

/* $("#card-section").append("<div class='col-md-6 col-lg-3 mb-4'> "
			+" <div class='box box-collaborated box-border-radius box-shadow bg-white'> "
			+" <div class='inner-wrap row justify-content-center align-items-center asset text-center mr-0 ml-0'> "
			+" <div class='col-md-12 pr-0 pl-0'> "
			+" <a href='#' class='matchingImg'><img src='"+data[i].imageURL+"' alt='' class='mw-100 mh-100'></a> "
			+" </div> "
			+" <div class='col-md-12 pr-0 pl-0'> "
			+" <div class='box-top position-relative'> "
			+" <h2><a href='#' class='hover-underline color-black color-blue-light-hover' onClick='goToProfile("+ data[i].userId +")'>"+data[i].userName+educationLevel+"</a></h2> "
			+" </div> "
			+" <div class='box-middle p0'> "
			+" <p>Lecturer, Business & Economics</p> "
			+" <p><span class='font-style-italic color-blue-light'>University of Dubai</span></p> "
			+" <p>"+invitationButton+"</p> "
			+" </div></div></div></div></div>"
	); 
 */
function loadRecommenedPartners(){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='loadRecommenedPartners'/>"
		,{
              method: 'post',
              data:{},
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
                   		if(data.length>0){
                   			$("#card-section").html("");
                   			for(var i=0;i<data.length;i++){
                   				var educationLevel = data[0].educationLevel;
                   				var invitationButton = "";
                   				if(data[0].educationLevel!=""){
                   					educationLevel = ", "+data[0].educationLevel;
                   				}
                   				if(data[0].isAlreadySent==true){
                   					invitationButton = "Already Sent Invite";
                   				}else{
                   					invitationButton = "<a href='#' class='btn btn-blue btn-tiny' onclick='sendInvite("+data[0].userId+")'>Send Invite</a>";
                   				}
                   				
                   				
                   				
                   				$("#card-section").append("<div class='col-md-6 col-lg-3 mb-4'> "
                   						+" <div class='box box-collaborated box-border-radius box-shadow bg-white'> "
                   						+" <div class='inner-wrap row justify-content-center align-items-center asset text-center mr-0 ml-0'> "
                   						+" <div class='col-md-12 pr-0 pl-0'> "
                   						+" <a href='#' class='matchingImg'><img src='"+data[0].imageURL+"' alt='' class='mw-100 mh-100'></a> "
                   						+" </div> "
                   						+" <div class='col-md-12 pr-0 pl-0'> "
                   						+" <div class='box-top position-relative'> "
                   						+" <h2><a href='#' class='hover-underline color-black color-blue-light-hover' onClick='goToProfile("+ data[0].userId +")'>"+data[0].userName+educationLevel+"</a></h2> "
                   						+" </div> "
                   						+" <div class='box-middle p0'> "
                   						+" <p>Lecturer, Business & Economics</p> "
                   						+" <p><span class='font-style-italic color-blue-light'>University of Dubai</span></p> "
                   						+" <p>"+invitationButton+"</p> "
                   						+" </div></div></div></div></div>"
                   				);
                   			}
                   		}
                   	}
                   	
                   },error: function(){	             
                   }
			},

         });
	});
}

function goToProfile(userId,interestId){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='loadProfileDetails'/>"
		,{
              method: 'post',
              data:{
              	  '<portlet:namespace/>key':userId
              },
              sync : true, 
              on:{
           	   complete:function()
            		{		            		   
            		},
                   success:function()
                   {	
                	   location.href="<%=themeDisplay.getURLPortal() %>"+"/profile?showInvite=true&interestId="+matchingRequestedId;
                   },error: function(){	             
                   }
			},

         });
	});
}

function sendInvite(inviteTo){
	AUI().use('aui-io-request-deprecated', function(A){
		A.io.request("<portlet:resourceURL id='sendInvite'/>"
		,{
              method: 'post',
              data:{
              	  '<portlet:namespace/>interestId':matchingRequestedId,
              	  '<portlet:namespace/>inviteTo':inviteTo
              },
              sync : true, 
              on:{
           	   complete:function()
            		{		            		   
            		},
                   success:function()
                   {	
                	    var value=this.get('responseData');
                   		if(value!=null && value!="undefined" && value!=undefined && value!="null" && value=="sent"){                
                   			showMsg("Invitation sent");
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
</script>