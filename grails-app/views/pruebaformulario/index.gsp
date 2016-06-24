
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
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div></div>
		<div style="width:76%;float:right">
		<div id="list-pruebaformulario" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>

						<g:sortableColumn property="apellido" title="${message(code: 'pruebaformulario.apellido.label', default: 'Apellido')}" />

						<g:sortableColumn property="fechaNac" title="${message(code: 'pruebaformulario.fechaNac.label', default: 'Fecha Nac')}" />

						<g:sortableColumn property="genero" title="${message(code: 'pruebaformulario.genero.label', default: 'Genero')}" />

						<g:sortableColumn property="dni" title="${message(code: 'pruebaformulario.dni.label', default: 'Dni')}" />

						<g:sortableColumn property="correo" title="${message(code: 'pruebaformulario.correo.label', default: 'Correo')}" />

						<g:sortableColumn property="personalidad" title="${message(code: 'pruebaformulario.personalidad.label', default: 'Personalidad')}" />

					</tr>
				</thead>
				<tbody>
				<g:each in="${pruebaformularioInstanceList}" status="i" var="pruebaformularioInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td><g:link action="show" id="${pruebaformularioInstance.id}">${fieldValue(bean: pruebaformularioInstance, field: "apellido")}</g:link></td>

						<td><g:formatDate date="${pruebaformularioInstance.fechaNac}" /></td>

						<td>${fieldValue(bean: pruebaformularioInstance, field: "genero")}</td>

						<td>${fieldValue(bean: pruebaformularioInstance, field: "dni")}</td>

						<td>${fieldValue(bean: pruebaformularioInstance, field: "correo")}</td>

						<td>${fieldValue(bean: pruebaformularioInstance, field: "personalidad")}</td>

					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${pruebaformularioInstanceCount ?: 0}" />
			</div>
		</div>
	</div>
	</body>
</html>
