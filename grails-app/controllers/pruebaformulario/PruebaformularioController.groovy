package pruebaformulario

//import static org.springframework.http.HttpStatus.*
//import grails.transaction.Transactional
import grails.converters.*

class PruebaformularioController {
  def pruebaformularioService
  def validationService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Pruebaformulario.list(params), model:[pruebaformularioInstanceCount: Pruebaformulario.count()]
    }

//---------------------------------GET Method-----------------------------------
    def show(Pruebaformulario pruebaformularioInstance) {
      log.println("llega un request al GET")
      def formulario
      def error

      try{
        log.println("buscando")
        formulario = Pruebaformulario.mostrar(params)
        log.println("encontrado")
      } catch (Exception m){
        log.println("error al buscar")
        error = m.getMessage()
        log.println("${error}")
      }

      if (!error){
        log.println("formulario encontrado")
        response.status = 201
        respond formulario
      } else{
        log.println ("error")
        response.status = 500
        request.withFormat {
          form multipartForm {
            flash.message = message(code: "${error}", args: [message(code: 'formulario.label', default: 'Pruebaformulario')])
            redirect action:"index", method:"GET"
          }
          '*' { respond pruebaFormulario, [status: INTERNAL_SERVER_ERROR] }
        }
      }

    }
//------------------------------------------------------------------------------

    def create() {
        respond new Pruebaformulario(params)
    }


//--------------------------------POST Method-----------------------------------
    def save(def parametros) {
      log.println("llega un request al POST")
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
          formulario = pruebaformularioService.guardar(parametros)
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

//------------------------------PUT Method--------------------------------------
    def update(def parametros) {
      log.println("llega un request al PUT")
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
          log.println("modificando")
          formulario = pruebaformularioService.modificar(parametros)
          log.println("modificado")
        } catch (Exception u){
          log.println("error en modificar")
          error = u.getMessage()
          log.println("${error}")
        }
      }

      if (formulario){
        log.println("formulario modificado")
        response.status = 201
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Pruebaformulario.label', default: 'Pruebaformulario'), pruebaformularioInstance.id])
                redirect pruebaformularioInstance
            }
            '*'{ respond pruebaformularioInstance, [status: UPDATED] }
        }
      } else {
        log.println ("error")
        response.status = 500
        request.withFormat {
          form multipartForm {
            flash.message = message(code: "${error}", args: [message(code: 'formulario.label', default: 'Pruebaformulario')])
            redirect(controller: "pruebaFormulario", action: "edit", params: parametros.id)
          }
          '*' { respond pruebaFormulario, [status: INTERNAL_SERVER_ERROR] }
        }
      }

      //-------------------------------Sin Uso----------------------------------
      /*
      if (pruebaformularioInstance == null) {
          notFound()
          return
      }

      if (pruebaformularioInstance.hasErrors()) {
          respond pruebaformularioInstance.errors, view:'edit'
          return
      }

      pruebaformularioInstance.save flush:true
      */

    }
//------------------------------------------------------------------------------

//-------------------------------DELETE Method----------------------------------
    def delete(def parametros) {  //Pruebaformulario pruebaformularioInstance
      log.println("llega un request al DELET")
      def error

      try {
        log.println("borrando")
        pruebaformularioService.borrar(parametros)
        log.println("borrado")
      } catch (Exception d){
        log.println("error en borrar")
        error = d.getMessage()
        log.println("${error}")
      }

      if (!error){
        log.println("formulario borrado")
        response.status = 201
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Pruebaformulario.label', default: 'Pruebaformulario'), pruebaformularioInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: DELETED }
        }
      } else {
        log.println ("error")
        response.status = 500
        request.withFormat {
          form multipartForm {
            flash.message = message(code: "${error}", args: [message(code: 'formulario.label', default: 'Pruebaformulario')])
            redirect(controller: "pruebaFormulario", action: "show", params: parametros.id)
          }
          '*' { respond pruebaFormulario, [status: INTERNAL_SERVER_ERROR] }
        }
      }

        //-------------------------------Sin Uso--------------------------------
        /*
        if (pruebaformularioInstance == null) {
            notFound()
            return
        }

        pruebaformularioInstance.delete flush:true
        */
        //----------------------------------------------------------------------

    }
//------------------------------------------------------------------------------

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
