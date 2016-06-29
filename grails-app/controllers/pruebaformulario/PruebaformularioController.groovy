package pruebaformulario

//import static org.springframework.http.HttpStatus.*
//import grails.transaction.Transactional
import grails.converters.*

class PruebaformularioController {
  def formularioService
  def validationService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Pruebaformulario.list(params), model:[pruebaformularioInstanceCount: Pruebaformulario.count()]
    }

    def show(Pruebaformulario pruebaformularioInstance) {
        respond pruebaformularioInstance
    }

    def create() {
        respond new Pruebaformulario(params)
    }


//--------------------------------POST Method-----------------------------------
    def save(def parametros) {
      log.printlm("llega un request al POST")
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
        log.println("${error}")
      }

      if (!error){
        try {
          log.println("guardando")
          formularioService.guardar(parametros)
          log.println("guardado")
        } catch (Exception s){
          log.println("error en guardado")
          error = s.getMessage()
          log.println("${error}")
        }
      }

      if (formulario){
        log.println("formulario guardado")
        response.status = 201
        request.withFormat {
          form multipartForm {
            flash.message = message(code: 'default.created.message', args: [message(code: 'formulario.label', default: 'Pruebaformulario'), formulario.id])
            redirect formulario
          }
          '*' { respond formulario, [status: CREATED] }
        }
      } else {
        log.println ("error")
        response.status = 500
        request.withFormat {
          form multipartForm {
            flash.message = message(code: "${error}", args: [message(code: 'formulario.label', default: 'Pruebaformulario')])
            redirect(controller: "pruebaFormulario", action: "create", params: parametros)
          }
          '*' { respond pruebaFormulario, [status: INTERNAL_SERVER_ERROR] }
        }
      }

      //-----------------------------Sin Uso------------------------------------
      /*
      if (pruebaformularioInstance == null) {
          notFound()
          return
      }

      if (pruebaformularioInstance.hasErrors()) {
          respond pruebaformularioInstance.errors, view:'create'
          return
      }

      pruebaformularioInstance.save flush:true
      */

    }
//------------------------------------------------------------------------------

    def edit(Pruebaformulario pruebaformularioInstance) {
        respond pruebaformularioInstance
    }

    @Transactional
    def update(Pruebaformulario pruebaformularioInstance) {
        if (pruebaformularioInstance == null) {
            notFound()
            return
        }

        if (pruebaformularioInstance.hasErrors()) {
            respond pruebaformularioInstance.errors, view:'edit'
            return
        }

        pruebaformularioInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Pruebaformulario.label', default: 'Pruebaformulario'), pruebaformularioInstance.id])
                redirect pruebaformularioInstance
            }
            '*'{ respond pruebaformularioInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Pruebaformulario pruebaformularioInstance) {

        if (pruebaformularioInstance == null) {
            notFound()
            return
        }

        pruebaformularioInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Pruebaformulario.label', default: 'Pruebaformulario'), pruebaformularioInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pruebaformulario.label', default: 'Pruebaformulario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
