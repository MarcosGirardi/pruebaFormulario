package pruebaformulario

class PruebaformularioController {

  def validationService
  def formularioService

    def create() {
      log.println("llega un request")
      def parametros = request.JSON

      try {
        log.println("validacion")
        validationService.validate(parametros)
        log.println("paso las validaciones")
      } catch (Exception v){

      }

      try {
        log.println("guardado")
        formularioService.guardar(parametros)
        log.println("guardado")
      } catch (Exception s){

      }

      if (recurso){
        response.status = 201
        Map responseMap = recursoService.getResponseMap(recurso)
        log.println ("${responseMap}")
        request.withFormat {
          form multipartForm {
            flash.message = message(code: 'default.created.message', args: [message(code: 'recurso.label', default: 'Recurso'), recurso.id])
            redirect(controller: "recurso", action: "show", id: params.id)
          }
          '*' { respond recurso, [status: CREATED] }
          }
      } else {
        log.println ("error....")
        response.status = 500
        request.withFormat {
          form multipartForm {
            flash.message = message(code: "${error}", args: [message(code: 'recurso.label', default: 'Recurso')])
            params.lastLampChange = null
            redirect(controller: "recurso", action: "create", params: params)
          }
          '*' { respond recurso, [status: CREATED] }
        }
      }


    }
}
