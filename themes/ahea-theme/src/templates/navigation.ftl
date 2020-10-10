<nav class="${nav_css_class} navbar-expand-xl" id="navigation" role="navigation">
	<h1 class="hide-accessible"><@liferay.language key="navigation" /></h1>
	<div class="d-flex justify-content-between">
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    	<span class="navbar-toggler-icon"><i class="fas fa-bars" aria-hidden="true"></i></span>
  	</button>
  	</div>
  	 <div class="collapse navbar-collapse" id="collapsibleNavbar">
	<ul class="nav" id="nav" aria-label="<@liferay.language key="site-pages" />" role="menubar">
	
			<li class="active">
				<a href="/home1" class="icon-fa icon-home home">
					<span class="group-hide">Home</span>
				</a>
			</li>
			<li><a href="/calendar" class="icon-fa icon-calendar myCalendar"><span class="group-hide">My Calendar</span></a></li>
			<li class="not-active"><a href="/committees-teams" class="icon-fa icon-user-group committeesTeams"><span class="group-hide">Committees & Teams</span></a></li>
			<li class="not-active"><a href="/my-advisees" class="icon-fa icon-book-reader myAdvisees"><span class="group-hide">My Advisees</span></a></li>
			<li><a href="${course_url}" class="icon-fa icon-book myCourses"><span class="group-hide">My Courses</span></a></li>
			<li><a href="/my-projects" class="icon-fa icon-book-title myProjects"><span class="group-hide"> My Projects</span></a></li>
			<li class="not-active"><a href="/my-files" class="icon-fa icon-copy myFiles"><span class="group-hide"> My Files</span></a></li>
			<li><a href="/resources" class="icon-fa icon-th-large resources"><span class="group-hide">Resources</span></a></li>
			<li class="not-active"><a href="/opportunities" class="icon-fa icon-sun-haze opportunities"><span class="group-hide">Opportunities</span></a></li>
			<li class="not-active"><a href="/recommended-partners" class="icon-fa icon-user-friends recommenedePartners"><span class="group-hide">Recommended Partners</span></a></li>
			<li class="not-active"><a href="/settings1" class="icon-fa icon-settings settings"><span class="group-hide">Settings</span></a></li>
	
		<#list nav_items as nav_item>
			<#assign
				nav_item_attr_has_popup = ""
				nav_item_css_class = ""
				nav_item_layout = nav_item.getLayout()
				nav_child_menu_css_class=""
				nav_child_dashboard = ""
			/>

			<#if nav_item.isSelected()>
				<#assign
					nav_item_attr_has_popup = "aria-haspopup='true'"
					nav_item_css_class = "selected"
					nav_child_menu_css_class="subMenu"
				/>
			</#if>
			<#if nav_item.getName()=="Dashboard">
				<#assign
					nav_child_dashboard = " style='opacity: 0.45 !important;'"
				/>
			</#if>
			
			<#if nav_item.getName()=="Welcome" ||  nav_item.getName()=="Edit Profile" ||  nav_item.getName()=="Edit Profile Combined" ||  nav_item.getName()=="Profile" ||  nav_item.getName()=="Matching" || nav_item.getName()=="Course Development" || nav_item.getName()=="Privacy Policy" || nav_item.getName()=="Terms of Service"
			|| nav_item.getName()=="My Projects" || nav_item.getName()=="Messaging" || nav_item.getName()=="Forums" || nav_item.getName()=="Dashboard" || nav_item.getName()=="Lab Screen" || nav_item.getName()=="Lab Screen V2"  || nav_item.getName()=="Lab Detailed Screen" || nav_item.getName()=="Asset Display Page" || nav_item.getName()=="Project Invites" || nav_item.getName()=="Project Creation"
			>
			
			<#else>
				<li class="${nav_item_css_class} d-none" id="layout_${nav_item.getLayoutId()}" role="presentation">
					<#if nav_item.getName()=="Dashboard">
						<a aria-labelledby="layout_${nav_item.getLayoutId()}" ${nav_item_attr_has_popup} href="#" ${nav_item.getTarget()} role="menuitem"><span><@liferay_theme["layout-icon"] layout=nav_item_layout /> ${nav_item.getName()}</span></a>					
					<#else>
					<a aria-labelledby="layout_${nav_item.getLayoutId()}" ${nav_item_attr_has_popup} href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem"><span><@liferay_theme["layout-icon"] layout=nav_item_layout /> ${nav_item.getName()}</span></a>
					
					</#if>

					<#if nav_item.hasChildren()>
						<ul class="sub-menu child-menu ${nav_child_menu_css_class} m-0" role="menu">
							<#list nav_item.getChildren() as nav_child>
								<#assign
									nav_child_css_class = ""
								/>

								<#if nav_child.isSelected()>
									<#assign
										nav_child_css_class = "selected"
									/>
								</#if>

								<li class="${nav_child_css_class}" id="layout_${nav_child.getLayoutId()}" role="presentation">
									<a aria-labelledby="layout_${nav_child.getLayoutId()}" href="${nav_child.getURL()}" ${nav_child.getTarget()} role="menuitem">${nav_child.getName()}</a>
								</li>
							</#list>
							<#--  <button type="button" class="btn btn-purple ml-auto">Request Report</button>  -->
						</ul>
					</#if>
				</li>
			</#if>
		</#list>
	</ul>
	</div>
</nav>

