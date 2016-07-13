
<%@ page import="pruebaformulario.Pruebaformulario" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pruebaformulario.label', default: 'Pruebaformulario')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-pruebaformulario" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="Inicio"/></a></li>
				<li><g:link class="create" action="create"><g:message code="Nuevo usuario" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-pruebaformulario" class="content scaffold-list" role="main">
			<h1>LISTADO PRINCIPAL</h1>
			<p> En el siguiente listado, se presentan los usuarios que ingresamos realizando una prueba de formulario
				sin usar scaffolding.El listado tambien pretende ser creado sin las condiciones que trae el scaffolding</p><br>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<div id="no-more-tables">
			<table class="col-md-12 table-bordered table-striped table-condensed cf">
			<thead class="cf">
				<tr>
					<g:sortableColumn property="apellido" title="apellido" />
					<g:sortableColumn property="fechaNac" title="fechaNac" />
					<g:sortableColumn property="genero" title="genero" />
					<g:sortableColumn property="dni" title="dni" />
					<g:sortableColumn property="correo" title="correo" />
					<g:sortableColumn property="edit" title=" " />
				</tr>
			</thead>
				<tbody>
				<g:each in="${pruebaformularioInstanceList}" status="i" var="pruebaformularioInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
							<td data-title="apellido"><g:link action="show" id="${pruebaformularioInstance.id}" class="profile">${pruebaformularioInstance.apellido}</g:link></td>
							<td data-title="fechaNac">${pruebaformularioInstance.fechaNac.format('dd-MM-yyyy')}</td>
							<td data-title="genero">${pruebaformularioInstance.genero}</td>
							<td data-title="dni">${pruebaformularioInstance.dni}</td>
							<td data-title="correo">${pruebaformularioInstance.correo}</td>
							<td><g:link class="edit" action="edit" id="${pruebaformularioInstance.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link></td>

					</tr>
				</g:each>
				</tbody>
			</table>
		</div>
			<div class="pagination">
				<g:paginate total="${pruebaformularioInstanceCount ?: 0}" />
			</div>
		</div><p>HOLAAA</p><br/><br/><br/><h2>CHAUU</h2><br/><br/><br/><h2>CHAUU</h2>
	</body>
</html>
