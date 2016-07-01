<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pruebaformulario.label', default: 'Pruebaformulario')}" />
		<title>Nueva Persona</title>
	</head>
	<body>
		<a href="#create-pruebaformulario" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="create-pruebaformulario" class="content scaffold-create" role="main">
			<h1> Nueva Persona</h1>
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
			<g:form controller="Pruebaformulario" action="save">
			<fieldset class="form">
				<div class="fieldcontain ">
					 <label> Apellido: </label>
					 <g:textField name="apellido" /><br/>
				</div>
				<div class="fieldcontain">
					<label> Fecha de Nacimiento: </label>
						<g:datePicker name="fechaNac" value="${new Date()}"precision="day"
							noSelection="['':'-Choose-']" /><br/>
				</div>
				<div class="fieldcontain">
				 <label> Genero : </label>
				 <g:radio name="genero" value="F"/> F
				 <g:radio name="genero" value="M" checked="true"/> M
			 </div>
					<div class="fieldcontain required">
					 <label>DNI: </label>
					 <g:textField name="dni"/><br/>
				 </div>
				 	<div class="fieldcontain">
					 <label>Correo: </label>
					 <g:textField name="correo"/><br/>
				 </div>
				 	<div class="fieldcontain">
					 <label> Hobbies: </label><br/>
					 <div style="float:left;margin-left: 26%;">
						 <g:checkBox name="hobbies" value="deporte" checked="false"/> Deporte
						 <g:checkBox name="hobbies" value="arte" checked="false"/> Arte
						 <g:checkBox name="hobbies" value="musica" /> Musica
						 <g:checkBox name="hobbies" value="moda" checked="false"/> Moda
						 <g:checkBox name="hobbies" value="ninguno" checked="false"/> Ninguno<br/>
					 </div></div><br/><br/>
				<div class="fieldcontain">
							<label>Personalidad: </label>
							<g:textArea name="personalidad" value="${value}" rows="5" cols="40" />
				</fieldset></div>
				<fieldset class="buttons">
					 <g:actionSubmit class="save" value="Save"/>
				</fieldset>
			 </g:form>
  		<!--<g:form url="[resource:pruebaformularioInstance, action:'save']" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
			</g:form>-->
		</div>
	</body>
</html>
