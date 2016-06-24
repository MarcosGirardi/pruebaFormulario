<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'layout.css')}"/>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'fonts.css')}"/>
    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon"/>
		<link rel="apple-touch-icon" href="${assetPath(src: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'apple-touch-icon-retina.png')}">

    <g:layoutHead/>
  	<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>
		<g:layoutHead/>
	</head>
	<body>
		<header id="header">
	<hgroup>
		<h1 class="site_title"><a href="index.html">Administrador</a></h1>
		<h2 class="section_title">Tablero</h2><div class="btn_view_site"><a href="#">View Site</a></div>
	</hgroup>
</header><!--fin Primer Header-->
	<section id="secondary_bar">
	<div class="user">
		<p>Ivana Camargo (<a href="#">3 Mensajes</a>)</p>
		<a class="logout_user" href="#" title="Cerrar sesión">Logout</a>
	</div>
	<div class="breadcrumbs_container">
		<article class="breadcrumbs"><a href="index.html">Website Admin</a> <div class="breadcrumb_divider"></div> <a class="current">Dashboard</a></article>
	</div>
</section><!--fin segundo header -->
<aside id="sidebar" class="column">
	<form class="quick_search">
		<input type="text" value="Quick Search" onfocus="if(!this._haschanged){this.value=''};this._haschanged=true;">
	</form>
	<hr/>
	<h3>Content</h3>
	<ul class="toggle">
		<li class="icn_new_article"><a href="#">New Article</a></li>
		<li class="icn_edit_article"><a href="#">Edit Articles</a></li>
		<li class="icn_categories"><a href="#">Categories</a></li>
		<li class="icn_tags"><a href="#">Tags</a></li>
	</ul>
	<h3>Users</h3>
	<ul class="toggle">
		<li class="icn_add_user"><a href="#">Add New User</a></li>
		<li class="icn_view_users"><a href="#">View Users</a></li>
		<li class="icn_profile"><a href="#">Your Profile</a></li>
	</ul>
	<h3>Media</h3>
	<ul class="toggle">
		<li class="icn_folder"><a href="#">File Manager</a></li>
		<li class="icn_photo"><a href="#">Gallery</a></li>
		<li class="icn_audio"><a href="#">Audio</a></li>
		<li class="icn_video"><a href="#">Video</a></li>
	</ul>
	<h3>Admin</h3>
	<ul class="toggle">
		<li class="icn_settings"><a href="#">Options</a></li>
		<li class="icn_security"><a href="#">Security</a></li>
		<li class="icn_jump_back"><a href="#">Logout</a></li>
	</ul>

			<footer>
				<hr />
				<p><strong>Copyright &copy; 2016 Área de sistemas</strong></p>
			</footer>
</aside>
		<div style="width:76%; float:left;margin-left: 1px;">
	<!--	<div id="grailsLogo" role="banner"><a href="http://grails.org"><asset:image src="grails_logo.png" alt="Grails"/></a></div>-->
		<g:layoutBody/>
	<!--	<div class="footer" role="contentinfo"></div>-->
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
	</body>
</html>
