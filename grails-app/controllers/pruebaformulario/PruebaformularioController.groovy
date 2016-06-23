package pruebaformulario

class PruebaformularioController {

  def validationService
  def formularioService

//----------------------------------POST----------------------------------------
    def create() {
      log.println("llega un request")
      def parametros = request.JSON
      def formulario
      def error

      try {
        log.println("validacion")
        validationService.validate(parametros)
        log.println("paso las validaciones")
      } catch (Exception v){
        log.println("error en validacion")
        error = v.getMessage()
      }

      try {
        log.println("guardando")
        formularioService.guardar(parametros)
        log.println("guardado")
      } catch (Exception s){
        log.println("error en guardado")
        error = s.getMessage()
      }

      if (formulario){
        log.println("formulario guardado")
        response.status = 201
        request.withFormat {
          form multipartForm {
            flash.message = message(code: 'default.created.message', args: [message(code: 'formulario.label', default: 'Formulario'), recurso.id])
            redirect(controller: "formulario", action: "show", id: recurso.id)
          }
          '*' { respond formulario, [status: CREATED] }
          }
      } else {
        log.println ("error")
        response.status = 500
        request.withFormat {
          form multipartForm {
            flash.message = message(code: "${error}", args: [message(code: 'recurso.label', default: 'Recurso')])
            params.lastLampChange = null
            redirect(controller: "recurso", action: "create", params: parametros)
          }
          '*' { respond recurso, [status: CREATED] }
        }
      }


    }
}
