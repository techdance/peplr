<%@ include file="/init.jsp" %>

<section class="top">
					<!--<div class="top-icon icon-1">
						<button id="menu-button-hide-show" class="visible-lg"><i class="fas fa-arrow-circle-left"></i></button>
					</div>-->
					<div class="top-icon icon-1">
						<a  id="btn-badges">
							<img src="/o/ahea-theme/images/svg/Badges-Icon-1.svg" width="50" alt="">
							<span class="note">
								<span class="outer">1</span>
							</span>
						</a>	
						<div id="badges-toltip" class="toltip toltip-overlay p-3">
							<div class="toltip-header">
								<div class="toltip-title">
									<img src="/o/ahea-theme/images/svg/Badges-Icon-3.svg" width="25"> Badges
								</div>
								<div class="toltip-close">
									<a href="javascript:void(0);"><i class="fa fa-times-circle" aria-hidden="true"></i></a>
								</div>
							</div>
							<div class="toltip-body text-center">
								<div class="wrap-icon">
									<img src="/o/ahea-theme/images/svg/Badges-Icon-2.svg" alt="" width="125">
								</div>
								<p>Congratulations! You earned the Orientation Badge.</p>
							</div>
							<div class="toltip-footer text-center">
								<a href="#" class="btn btn-blue m-auto">View More</a>
							</div>
						</div>					
					</div>
					<div class="top-icon icon-2">
						<a id="btn-notification">
							<img class="this-img" src="/o/ahea-theme/images/svg/Bell-Icon-1.svg" width="45" alt="">
							<span class="note">
								<span class="outer">5</span>
							</span>
						</a>
						<div id="notification-toltip" class="toltip">
							<div class="toltip-item toltip-overlay d-flex mb-2">
								<div class="toltip-image">
									<img src="/o/ahea-theme/images/recom-img-1.jpg" width="48">
								</div>
								<div class="toltip-text">
									<p>Lorem ipsum dolor sit amet, adipiscing. Donec odio.</p>
								</div>
								<div class="toltip-close-details">
									<a href="#" class="close-this">Close</a>
									<a href="#">Details</a>
								</div>
							</div>
							<div class="toltip-item toltip-overlay d-flex mb-2">
								<div class="toltip-icon toltip-icon-green">
									<i class="fa fa-users" aria-hidden="true"></i>
								</div>
								<div class="toltip-text">
									<p>Lorem ipsum dolor sit amet, consectetuer adipiscing. Donec odio.</p>
								</div>
								<div class="toltip-close-details">
									<a href="#" class="close-this">Close</a>
									<a href="#">Details</a>
								</div>
							</div>
							<div class="toltip-item toltip-overlay d-flex mb-2">
								<div class="toltip-image">
									<img src="/o/ahea-theme/images/recom-img-2.jpg" width="48">
								</div>
								<div class="toltip-text">
									<p>Lorem ipsum dolor sit amet, adipiscing. Donec odio.</p>
								</div>
								<div class="toltip-close-details">
									<a href="#" class="close-this">Close</a>
									<a href="#">Details</a>
								</div>
							</div>
							<div class="toltip-item toltip-overlay d-flex mb-2">
								<div class="toltip-icon toltip-icon-blue">
									<i class="fas fa-bullhorn" aria-hidden="true"></i>
								</div>
								<div class="toltip-text">
									<p>Lorem ipsum dolor sit amet, consectetuer adipiscing. Donec odio.</p>
								</div>
								<div class="toltip-close-details">
									<a href="#" class="close-this">Close</a>
									<a href="#">Details</a>
								</div>
							</div>
							<div class="toltip-item toltip-overlay d-flex mb-2">
								<div class="toltip-image">
									<img src="/o/ahea-theme/images/recom-img-3.jpg" width="48">
								</div>
								<div class="toltip-text">
									<p>Lorem ipsum dolor sit amet, adipiscing. Donec odio.</p>
								</div>
								<div class="toltip-close-details">
									<a href="#" class="close-this">Close</a>
									<a href="#">Details</a>
								</div>
							</div>
						</div>
					</div>
					<div class="top-icon icon-3">
						<a href="#">
							<img src="/o/ahea-theme/images/svg/Envelope-Icon-1.svg" width="40" alt="">
							<span class="note">
								<span class="outer">3</span>
							</span>
						</a>
					</div>
					<div class="top-icon hello">
						<a href="#"  id="btn-user" class="btn-menu">
							<img class="img-circle img-border-blue" src="/o/ahea-theme/images/home-woman.jpg" alt="">
							Hello, <%=themeDisplay.getUser().getFirstName() %>
						</a>
						<div id="user-toltip" class="toltip menu-toltip toltip-overlay any-toltip">
							<ul>
								<li><a href="#">My Profile</a></li>
								<li><a href="#">Settings & Privacy</a></li>
								<li><a href="javascript:void(0);" data-toggle="modal" data-target="#signOutModal">Sign Out</a></li>
							</ul>
						</div>
					</div>
					<div class="top-icon top-button">
						<a href="#" class="btn btn-blue">Tour <i class="fas fa-forward"></i></a>
					</div>
					<div class="wrap-top-search">
						<div class="top-search">
							<div class="box-search">
								<form action="">
									<input type="text" placeholder="Search">
									<button type="submit"><i class="fas fa-search"></i></button>
								</form>
							</div>
							<div class="box-question">
								<a href="#"><img src="/o/ahea-theme/images/search-icon.png" width="38"></a>
							</div>
						</div>
						<div class="top-text">
							<p>Looking for an academic collaborator? <a href="#">Click Here</a>.</p>
						</div>
					</div>
				</section>