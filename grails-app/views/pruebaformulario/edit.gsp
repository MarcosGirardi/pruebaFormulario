<%@ page import="pruebaformulario.Pruebaformulario" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pruebaformulario.label', default: 'Pruebaformulario')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#edit-pruebaformulario" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="Inicio"/></a></li>
				<li><g:link class="list" action="index"><g:message code="Listado Usuario" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="Nuevo Usuario" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="edit-pruebaformulario" class="content scaffold-edit" role="main">
			<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${pruebaformularioInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${pruebaformularioInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<p>"${pruebaformularioInstance}"</p>
			<g:form controller="Pruebaformulario" action="update" method="PUT">
			<fieldset class="form">
				<div class="fieldcontain ">
					 <g:hiddenField name="id" value="${pruebaformularioInstance?.id}" /><br/>
				</div>

				<div class="fieldcontain ">
					 <label> Apellido: </label>
					 <g:textField name="apellido" value="${pruebaformularioInstance?.apellido}" /><br/>
				</div>
				<div class="fieldcontain">
					<label> Fecha de Nacimiento: </label>
						<g:datePicker name="fechaNac" value="${pruebaformularioInstance?.fechaNac}" default="${new Date()}"precision="day"
							noSelection="['':'-Choose-']" /><br/>
				</div>
				<div class="fieldcontain">
				 <label> Genero : </label>
				 <g:if test="${pruebaformularioInstance?.genero=='M'}">
				 	<g:radio name="genero" value="M" checked="true"/> M
					<g:radio name="genero" value="F"/> F
				 </g:if>
				 <g:else>
				 	<g:radio name="genero" value="F" checked="true"/> F
					<g:radio name="genero" value="M"/> M
				 </g:else>

			 </div>
					<div class="fieldcontain required">
					 <label>DNI: </label>
					 <g:textField name="dni" value="${pruebaformularioInstance?.dni}"/><br/>
				 </div>
					<div class="fieldcontain">
					 <label>Correo: </label>
					 <g:textField name="correo" value="${pruebaformularioInstance?.correo}"/><br/>
				 </div>
					<div class="fieldcontain">
					 <label> Hobbies: </label><br/>
					 <div style="float:left;">
						<g:if test="${pruebaformularioInstance?.hobbies.contains('deporte')}">
						<g:checkBox name="hobbies" value="deporte" checked="true"/> Deporte
						 </g:if>
						 <g:else>
						 	<g:checkBox name="hobbies" value="deporte" checked="false"/> Deporte
						 </g:else>

						 <g:if test="${pruebaformularioInstance?.hobbies.contains('arte')}">
 						<g:checkBox name="hobbies" value="arte" checked="true"/> Arte
 						 </g:if>
 						 <g:else>
 						 	<g:checkBox name="hobbies" value="arte" checked="false"/> Arte
 						 </g:else>

						 <g:if test="${pruebaformularioInstance?.hobbies.contains('musica')}">
						 <g:checkBox name="hobbies" value="musica" checked="true"/> Musica
							</g:if>
							<g:else>
							 <g:checkBox name="hobbies" value="musica" checked="false"/> Musica
							</g:else>

							<g:if test="${pruebaformularioInstance?.hobbies.contains('moda')}">
							<g:checkBox name="hobbies" value="moda" checked="true"/> Moda
							 </g:if>
							 <g:else>
								<g:checkBox name="hobbies" value="moda" checked="false"/> Moda
							 </g:else>
					 </div></div><br/><br/>
				<div class="fieldcontain">
							<label>Personalidad: </label>
							<g:textArea name="personalidad" value="${pruebaformularioInstance?.personalidad}" rows="5" cols="40" />
				</fieldset></div>
				<fieldset class="buttons">
					<g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
				</fieldset>
				</g:form>
		<!--	<g:form url="[resource:pruebaformularioInstance, action:'update']" method="PUT" >
				<g:hiddenField name="version" value="${pruebaformularioInstance?.version}" />
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
				</fieldset>
			</g:form>-->
		</div>
	</body>
</html>
