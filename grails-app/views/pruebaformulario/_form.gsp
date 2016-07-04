<%@ page import="pruebaformulario.Pruebaformulario" %>



<div class="fieldcontain ${hasErrors(bean: pruebaformularioInstance, field: 'apellido', 'error')} required">
	<label for="apellido">
		<g:message code="pruebaformulario.apellido.label" default="Apellido" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="apellido" maxlength="50" required="" value="${pruebaformularioInstance?.apellido}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pruebaformularioInstance, field: 'fechaNac', 'error')} ">
	<label for="fechaNac">
		<g:message code="pruebaformulario.fechaNac.label" default="Fecha Nac" />
		
	</label>
	<g:datePicker name="fechaNac" precision="day"  value="${pruebaformularioInstance?.fechaNac}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: pruebaformularioInstance, field: 'genero', 'error')} required">
	<label for="genero">
		<g:message code="pruebaformulario.genero.label" default="Genero" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="genero" from="${pruebaformularioInstance.constraints.genero.inList}" required="" value="${pruebaformularioInstance?.genero}" valueMessagePrefix="pruebaformulario.genero"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pruebaformularioInstance, field: 'dni', 'error')} ">
	<label for="dni">
		<g:message code="pruebaformulario.dni.label" default="Dni" />
		
	</label>
	<g:textField name="dni" maxlength="8" value="${pruebaformularioInstance?.dni}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pruebaformularioInstance, field: 'correo', 'error')} ">
	<label for="correo">
		<g:message code="pruebaformulario.correo.label" default="Correo" />
		
	</label>
	<g:field type="email" name="correo" maxlength="50" value="${pruebaformularioInstance?.correo}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pruebaformularioInstance, field: 'personalidad', 'error')} ">
	<label for="personalidad">
		<g:message code="pruebaformulario.personalidad.label" default="Personalidad" />
		
	</label>
	<g:textField name="personalidad" value="${pruebaformularioInstance?.personalidad}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pruebaformularioInstance, field: 'hobbies', 'error')} ">
	<label for="hobbies">
		<g:message code="pruebaformulario.hobbies.label" default="Hobbies" />
		
	</label>
	<g:textField name="hobbies" value="${pruebaformularioInstance?.hobbies}"/>

</div>

