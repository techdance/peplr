<%@ include file="/init.jsp" %>

<div class="box box-border-radius box-shadow bg-white block-discussion">
	<!-- Loader -->
	<div id="bradleyLabDiscussionScreenLoader" class="sectionloader"> 
		<div class="loader"></div>
	</div>
	<div class="inner-wrap">
		<div class="box-top position-relative">
			<h3 class="box-subhead"><span class="icon-regular icon-comments-alt"></span> Discussion</h3>
			<a href="#" class="icon-setting icon-box"><i class="fas fa-cog"></i></a>
		</div>
		<div class="box-middle">
			<ul class="nav nav-tabs" id="tabs" role="tablist">
				<li class="nav-item">
				<a class="nav-link active" id="discussion-tab" data-toggle="tab" href="#discussion" role="tab" aria-controls="discussion" aria-selected="true">Discussion</a>
				</li>
				<li class="nav-item">
				<a class="nav-link" id="file-tab" data-toggle="tab" href="#file" role="tab" aria-controls="file" aria-selected="false">Files</a>
				</li>
				<li class="nav-item">
				<a class="nav-link" id="resources-tab" data-toggle="tab" href="#resources" role="tab" aria-controls="resources" aria-selected="false">Resources</a>
				</li>
			</ul>
			<div class="tab-content" id="myTabContent">
			  <div class="tab-pane fade show active" id="discussion" role="tabpanel" aria-labelledby="discussion-tab">
					<div id="dynamicDiscussion"></div>
                  <!-- <div class="discussion-1">
                      <div class="item item-flex">
                          <div class="item-img">
                              <div class="person-img">
                                  <img src="/o/ahea-theme/images/Inez.png" width="58">
                                  <span class="user-active"></span>
                              </div>
                          </div>
                          <div class="item-text">
                              <div class="person-top">
                                  <p>Inez Campos 10.10.19 6:46 PM WET (+6 Hours), 10.10.19 12:46 PM CST</p>
                              </div>
                              <div class="person-bottom person-laguage">
                                  <p class="ing hide">Hello Bradley, might I make a suggestion? Would it be feasible to add the application of knowledge of cross-cultural context to the course description? This aids students in the resolution of global ethical dilemmas. The information available would be highly visible and increase awareness. <a class="cl-blue link-trans" href="#" data-toggle="tab">Translate</a></p>
                                  <p class="port">Olá Bradley, posso fazer uma sugestão? Seria possível adicionar a aplicação do conhecimento do contexto transcultural à descrição do curso? Isso ajuda os alunos a resolver dilemas éticos globais. A informação disponível seria altamente visível e aumentaria a conscientização. <a class="cl-blue link-orig" href="#" data-toggle="tab">Original</a></p>
                              </div>
                          </div>
                      </div>
                  </div>

                  <div class="discussion-2">
                      <div class="item item-flex">
                          <div class="item-text">
                              <div class="items odd">
                                  <div class="person-top">
                                      <p>Bradley Dexter 10.10.19 1:01 PM CST</p>
                                  </div>
                                  <div class="person-bottom">
                                      <p>Hello Inez, your ideas are very insightful and timely. We should make changes to increase student readiness.</p>
                                  </div>
                              </div>
                          </div>
                          <div class="item-img">
                              <div class="person-img">
                                  <img src="/o/ahea-theme/images/bradley.png" width="58">
                              </div>
                          </div>
                      </div>

                      <div class="item item-flex">
                          <div class="item-text">
                              <div class="items even">
                                  <div class="person-top">
                                      <p>Bradley Dexter 10.10.19 1:08 PM CST</p>
                                  </div>
                                  <div class="person-bottom">
                                      <p>Hello Inez, When you have a moment, please review the updated Course Description based upon your recommendation. Please let me know if it reflects your suggestion accurately.</p>
                                  </div>

                              </div>
                          </div>
                          <div class="item-img">
                              <div class="person-img">
                                  <img src="/o/ahea-theme/images/bradley.png" width="58">
                              </div>
                          </div>
                      </div>
                  </div>

                  <div class="discussion-1">
                      <div class="item item-flex">
                          <div class="item-img">
                              <div class="person-img">
                                  <img src="/o/ahea-theme/images/Inez.png" width="58">
                                  <span class="user-active"></span>
                              </div>
                          </div>
                          <div class="item-text">
                              <div class="person-top">
                                  <p>Inez Campos 10.10.19 7:12 PM WET (+6 Hours), 10.10.19 1:12 PM CST</p>
                              </div>
                              <div class="person-bottom person-laguage2">
                                  <p class="ing hide">The description is accurate and clear. <a class="cl-blue link-trans2" href="#" data-toggle="tab">Translate</a></p>
                                  <p class="port">A descrição é precisa e clara. <a class="cl-blue link-orig2" href="#" data-toggle="tab">Original</a></p>
                              </div>
                          </div>
                      </div>

                      <div class="item item-flex">
                          <div class="item-img">
                              <div class="person-img">
                                  <img src="/o/ahea-theme/images/Inez.png" width="58">
                                  <span class="user-active"></span>
                              </div>
                          </div>
                          <div class="item-text">
                              <div class="person-top">
                                  <p>Inez Campos 10.10.19 7:12 PM WET (+6 Hours), 10.10.19 1:12 PM CST</p>
                              </div>
                              <div class="person-bottom person-laguage3">
                                  <p class="ing hide">I have appended comments and ideas for our discussion tomorrow. <a class="cl-blue link-trans3" href="#" data-toggle="tab">Translate</a></p>
                                  <p class="port">Anexei comentários e idéias para nossa discussão amanhã. <a class="cl-blue link-orig3" href="#" data-toggle="tab">Original</a></p>
                              </div>
                          </div>
                      </div>
                  </div>

                  <div class="discussion-2">
                      <div class="item item-flex">
                          <div class="item-text">
                              <div class="items even">
                                  <div class="person-top">
                                      <p>Bradley Dexter 10.10.19 1:01 PM CST</p>
                                  </div>
                                  <div class="person-bottom">
                                      <p>I will review in advance.</p>
                                  </div>
                              </div>
                          </div>
                          <div class="item-img">
                              <div class="person-img">
                                  <img src="/o/ahea-theme/images/bradley.png" width="58">
                              </div>
                          </div>
                      </div>
                  </div> -->

                  <div class="item item-flex input-message mt-4">
                  	<aui:form name="projectDiscussionForm" onSubmit="event.preventDefault();" cssClass="w-100">
                      <div class="d-flex align-items-center">
                      	<div class="item-text d-flex w-100 mr-3">
	                      	<aui:input type="text" name="discussionMessage" label="" value="" placeholder="Type a new message"/>
	                       	<aui:button value="Save" type="submit"  cssClass="btn btn-blue btn-sm" onclick="saveMessage()" icon="fas fa-paper-plane"></aui:button>
	                      </div>
	                      <div class="item-img d-flex mt-0 ml-1">
	                          <a href="#"><i class="far fa-smile"></i></a>
	                          <a href="#"><i class="far fa-edit"></i></a>
	                          <a href="#"><i class="fas fa-cloud-upload-alt"></i></a>
	                          <a href="#"><i class="far fa-image"></i></a>
	                      </div>
                      </div>
                  	</aui:form>
                  </div>
              </div>
			  <div class="tab-pane fadeç" id="file" role="tabpanel" aria-labelledby="file-tab">
                  <div class="top-search d-inline-block mb-3">
                      <div class="box-search box-search-border">
                          <form action="">
                              <input type="text" placeholder="Search">
                              <button type="submit"><i class="fas fa-search"></i></button>
                          </form>
                      </div>
                  </div>

                  <div class="tree-folder d-flex">
                      <div class="tree-sidebar">
                          <!-- <ul class="mb-4">
                              <li><a href="#"><i class="fas fa-folder"></i> Document</a></li>
                              <li><a href="#"><i class="fas fa-folder"></i> Course Resource</a></li>
                              <li class="active active-white">
                                  <a href="#" class="active-href"><i class="fas fa-folder-open"></i> Course Materials</a>
                                  <ul>
                                      <li><i class="fas fa-folder"></i> Course Info</a>
                                      </li>
                                      <li><i class="fas fa-folder"></i> Course Design</a>
                                      </li>
                                      <li><i class="fas fa-folder"></i> Assessment Design</a>
                                      </li>
                                  </ul>
                              </li>
                              <li><a href="#"><i class="fas fa-trash"></i> Recycle Bin</a></li>
                          </ul> -->
                          
                          <div class="wrap-tree-button text-center mt-4 mb-3">  
                          	  <!-- Removed href="#" to avoild scrolling top -->                        
	                          <a class="btn btn-blue btn-w-100 d-inline-block" id="add-folder">Add Folder<i class="fas fa-cloud-upload-alt"></i></a>	                          
                          </div>
                          
                          <div id="dynamicfolderStructure"></div>
                          
                          <div class="wrap-tree-button text-center mt-4 mb-3">  
                          	  <!-- Removed href="#" to avoild scrolling top -->                         
	                          <a class="btn btn-blue btn-w-100 d-inline-block" id="add-files">File Upload <i class="fas fa-cloud-upload-alt"></i></a>
                          </div>
                          
                          <div id="add-folder-modal" class="modalareainterest color-black font14 modal fade">
	                          <aui:form name="folderUploadForm" onSubmit="event.preventDefault();">
								<aui:input  name="parentFolderId" value="0" type="hidden"></aui:input>
								<div class=" modal-dialog viewmoredetail view-more-interest-modal-inner">
									<div class="modal-content p-0">
										<div class="modal-body p-0">								
											<div class="interest-modal">
												<div class="view-more-interest-modal-inner tooltipdata">
													<div class="toltip-close2 text-right">
														<a href="javascript:void(0);" data-dismiss="modal"><i class="fa fa-times-circle"></i></a>
													</div>											
													<aui:input type="text" name="folderName" value=""/>
													<div class="row text-center pt-2 justify-content-center">
														<aui:button value="Save" type="submit"  cssClass="btn btn-blue btn-w-100 m-auto" onclick="saveFiles('addFolder')"></aui:button>
													</div> 
												</div>
											</div>
										</div>
									</div>
								</div>
								</aui:form>
						  </div>
                          
                          <div id="add-files-modal" class="modalareainterest color-black font14 modal fade">
	                          <aui:form name="filesUploadForm" onSubmit="event.preventDefault();">
								<aui:input  name="folderId" value="0" type="hidden"></aui:input>
								<aui:input type="hidden" name="folderNameHidden" value=""> </aui:input>
								<div class=" modal-dialog viewmoredetail view-more-interest-modal-inner">
									<div class="modal-content p-0">
										<div class="modal-body p-0">	
											<div class="modal-header position-relative"> 
												<div class="toltip-close3">
													<a href="javascript:void(0);" data-dismiss="modal">
														<i class="fa fa-times-circle" aria-hidden="true"></i>
													</a>
												</div> 
												<div class="text-left font15"><strong>File Upload</strong></div> 
											</div>							
											<div class="interest-modal">
												<div class="view-more-interest-modal-inner tooltipdata">
																							
													<aui:input type="file" name="uploadedFile" label="" />
													<div class="row text-center pt-2 justify-content-center">
														<aui:button value="Save" type="submit"  cssClass="btn btn-blue btn-w-100 m-auto" onclick="saveFiles('addFile')"></aui:button>
													</div> 
												</div>
											</div>
										</div>
									</div>
								</div>
								</aui:form>
						  </div>
                      </div>
                      <div id="treeActiveContent" class="row font12 w-100"></div>
                      <!-- <div class="wrap-folder">
                          <div class="row font12">
                              <div class="col-md-4 ac mb-3">
                                  <a href="#"><img src="/o/ahea-theme/images/Folder2.png" class="d-block m-auto">
                                      <span class="font12 color-black">Course Info</span></a>
                              </div>
                              <div class="col-md-4 ac mb-3">
                                  <a href="#"><img src="/o/ahea-theme/images/Folder2.png" class="d-block m-auto">
                                      <span class="font12 color-black">Course Design</span></a>
                              </div>
                              <div class="col-md-4 ac mb-3">
                                  <a href="#"><img src="/o/ahea-theme/images/Folder2.png" class="d-block m-auto">
                                      <span class="font12 color-black">Assessment Design</span></a>
                              </div>
                              <div class="col-md-4 ac mb-3">
                                  <a href="#"><img src="/o/ahea-theme/images/Folder2.png" class="d-block m-auto">
                                      <span class="font12 color-black">Task Design</span></a>
                              </div>
                              <div class="col-md-4 ac mb-3">
                                  <a href="#"><img src="/o/ahea-theme/images/Folder2.png" class="d-block m-auto">
                                      <span class="font12 color-black">Content Design</span></a>
                              </div>
                              <div class="col-md-4 ac mb-3">
                                  <a href="javascript:void(0);" data-toggle="modal" data-target="#pptModal"><img src="/o/ahea-theme/images/PPT.png" class="d-block m-auto">
                                      <span class="font12 color-black">EMM Course Development.pptx</span></a>

                                  Modal Badges
                                  <div class="modal fade modalToltip" id="pptModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
                                      <div class="modal-dialog" role="document">
                                          <div class="modal-content">
                                              <div class="modal-body">
                                                  <div class="p-3">
                                                      <div class="toltip-header">
                                                          <div class="toltip-close">
                                                              <a href="#" data-dismiss="modal"><i class="fa fa-times-circle"></i></a>
                                                          </div>
                                                      </div>
                                                      <div class="img-resp">
                                                          <img src="/o/ahea-theme/images/ScreenPPT.png">
                                                      </div>
                                                  </div>
                                              </div>
                                          </div>
                                      </div>
                                  </div>
                              </div>
                          </div>
                      </div> -->
                  </div>

              </div>
			  <div class="tab-pane fade" id="resources" role="tabpanel" aria-labelledby="resources-tab">
				resources
			  </div>
			</div>
		</div>
	</div>
</div>

<!-- The Modal -->
<div class="modal" id="pptModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <!-- Modal body -->
      <div class="modal-body p-0">
        <button type="button" class="close" data-dismiss="modal">
			<i class="fa fa-times-circle"></i>
		</button>
        <div id="modalValueContent">
        </div>
      </div>

    </div>
  </div>
</div>