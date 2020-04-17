<%@ include file="/init.jsp" %>

<div class="profesional box box-border-radius box-shadow bg-white">
                                        <div class="inner-wrap">
                                            <div class="box-top position-relative">
                                                <h2 class="box-subhead"><i class="fas fa-user"></i>Professional Bio</h2>
                                            </div>
                                            <div class="box-middle">
                                                <div class="row row-custom">
	                                                <div class="col-md-6">
	                                                	<h4 class="mb-3">Areas Of Expertise</h4>
	                                                	<aui:input type="text" name="areas-of-expertise1" label="Areas of Expertise &ndash; 1" value="American Assoc. of University Professors" cssClass="input" />
	                                                	<aui:input type="text" name="areas-of-expertise2" label="Areas of Expertise &ndash; 2" value="spanish" cssClass="input" />
	                                                	<aui:input type="text" name="areas-of-expertise3" label="Areas of Expertise &ndash; 3" value="" cssClass="input" />
	                                                    
	                                                    <div class="form-group">
															<label>International Experience</label>
															<div class="wrap-range-label">
																<ul>
																	<li>1 &ndash; 2 Years</li>
																	<li>3 &ndash; 7 Years</li>
																	<li>7+ Years</li>
																</ul>
															</div>
	                                                    	<div class="wrap-range">
															  <input type="range">
															</div>
															
	                                                    </div>
	                                                </div>
	                                                <div class="col-md-6 d-flex flex-column justify-content-end">
	                                                	<aui:input type="url" name="link-your-cv" label="Link Your CV" value="http://www.abcdefge/hijk/lmnop/tuvw.xyz" cssClass="input" />
	                                                </div>
	                                            </div>
	                                            <div class="row row-custom">
	                                            	<div class="col-md-12">
	                                            		<aui:input type="textarea" name="bio" label="Bio"  cssClass="input" style="min-height: 100px;" 
	                                            		value="Extensive background in special education, disability studies, social skills instruction, an career readiness. My research interests include dropout prevention for students with disabilities, culturally responsive teaching, and cultural and medical anthropology."  />
	                                            	</div>
	                                            </div>
                                            </div>
                                        </div>
                                    </div>