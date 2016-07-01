
<%@ page import="pruebaformulario.Pruebaformulario" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pruebaformulario.label', default: 'Pruebaformulario')}" />
		<title>Usuario: ${pruebaformularioInstance?.apellido}</title>
	</head>
	<body>
		<a href="#show-pruebaformulario" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="Inicio"/></a></li>
				<li><g:link class="list" action="index"><g:message code="Listado" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="Nuevo Usuario" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-pruebaformulario" class="content scaffold-show" role="main">
			<h1>Usuario: ${pruebaformularioInstance?.apellido}</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list pruebaformulario">

				<li class="fieldcontain">
					<span id="apellido-label" class="property-label"><g:message code="pruebaformulario.apellido.label" default="Apellido:" /></span>
						<span class="property-value"><g:fieldValue bean="${pruebaformularioInstance}" field="apellido"/></span>
				</li>

				<li class="fieldcontain">
					<span id="fechaNac-label" class="property-label"><g:message code="pruebaformulario.fechaNac.label" default="Fecha de nacimiento:" /></span>
						<span class="property-value"><g:formatDate format="dd-MM-yyyy" date="${pruebaformularioInstance?.fechaNac}" /></span>
				</li>

				<g:if test="${pruebaformularioInstance?.genero}">
				<li class="fieldcontain">
					<span id="genero-label" class="property-label"><g:message code="pruebaformulario.genero.label" default="Genero" /></span>

						<span class="property-value" aria-labelledby="genero-label"><g:fieldValue bean="${pruebaformularioInstance}" field="genero"/></span>

				</li>
				</g:if>

				<g:if test="${pruebaformularioInstance?.dni}">
				<li class="fieldcontain">
					<span id="dni-label" class="property-label"><g:message code="pruebaformulario.dni.label" default="Dni" /></span>

						<span class="property-value" aria-labelledby="dni-label"><g:fieldValue bean="${pruebaformularioInstance}" field="dni"/></span>

				</li>
				</g:if>

				<g:if test="${pruebaformularioInstance?.correo}">
				<li class="fieldcontain">
					<span id="correo-label" class="property-label"><g:message code="pruebaformulario.correo.label" default="Correo" /></span>

						<span class="property-value" aria-labelledby="correo-label"><g:fieldValue bean="${pruebaformularioInstance}" field="correo"/></span>

				</li>
				</g:if>

				<g:if test="${pruebaformularioInstance?.personalidad}">
				<li class="fieldcontain">
					<span id="personalidad-label" class="property-label"><g:message code="pruebaformulario.personalidad.label" default="Personalidad" /></span>

						<span class="property-value" aria-labelledby="personalidad-label"><g:fieldValue bean="${pruebaformularioInstance}" field="personalidad"/></span>

				</li>
				</g:if>
				<g:if test="${pruebaformularioInstance?.hobbies}">
				<li class="fieldcontain">
					<span id="hobbies-label" class="property-label"><g:message code="pruebaformulario.hobbies.label" default="Hobbies" /></span>

						<span class="property-value" aria-labelledby="hobbies-label"><g:fieldValue bean="${pruebaformularioInstance}" field="hobbies"/></span>

				</li>
				</g:if>

			</ol>
			<g:form url="[resource:pruebaformularioInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${pruebaformularioInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
