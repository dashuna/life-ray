<header>
	<nav>
		<div class="logoDiv"><a href="/"><img src="https://www.grupo-sade.com/Content/Images/Logo97px.png"
					alt=""></a></div>
		<div class="menuDiv">
		<ul>
			<#foreach nav_item in nav_items>
				<li> 
					<a aria-labelledby="layout_${nav_item.getLayoutId()}" href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem">
						${nav_item.getName()}
					</a>
				</li>
			</#foreach>
		</ul>
			<#--  <ul>
				<li><a href="">Home</a></li>
				<li><a href="">Portfolio</a> </li>
				<li><a href="">Experiencia</a></li>
				<li><a href="">Contacto</a></li>
			</ul>  -->
			<#--  <p>${user_name}</p>  -->
		</div>
		<div id="botonMenu">

			<button id="button-toggle-navigation" onclick="cambia()">
				<span>Toggle Navigation</span>
			</button>

		</div>
	</nav>
</header>
<#--  <h1>Titulo</h1>
<nav aria-label="<@liferay.language key="site-pages" />" class="${nav_css_class}" id="navigation" role="navigation">
	<ul role="menubar">
		<#list nav_items as nav_item>
			<#assign
				nav_item_attr_has_popup = ""
				nav_item_css_class = ""
				nav_item_layout = nav_item.getLayout()
			/>

			<#if nav_item.isSelected()>
				<#assign
					nav_item_attr_has_popup = "aria-haspopup='true'"
					nav_item_css_class = "selected"
				/>
			</#if>

			<li class="${nav_item_css_class}" id="layout_${nav_item.getLayoutId()}" role="presentation">
				<a ${nav_item_attr_has_popup} href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem"><span><@liferay_theme["layout-icon"] layout=nav_item_layout /> ${nav_item.getName()}</span></a>

				<#if nav_item.hasChildren()>
					<ul class="child-menu" role="menu">
						<#list nav_item.getChildren() as nav_child>
							<#assign
								nav_child_css_class = ""
							/>

							<#if nav_item.isSelected()>
								<#assign
									nav_child_css_class = "selected"
								/>
							</#if>

							<li class="${nav_child_css_class}" id="layout_${nav_child.getLayoutId()}" role="presentation">
								<a href="${nav_child.getURL()}" ${nav_child.getTarget()} role="menuitem">${nav_child.getName()}</a>
							</li>
						</#list>
					</ul>
				</#if>
			</li>
		</#list>
	</ul>
</nav>  -->