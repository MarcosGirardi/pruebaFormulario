package pruebaformulario



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

class PruebaformularioController {
  def validationService
  def pruebaformularioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]


//-----------------------------------Listar-------------------------------------
    def index(Integer max) {
      log.println("---------------------------------------------")
      log.println("llega un request al Listar")
      def formularios
      def error

      try{
        log.println("se van a buscar todos los formularios")
        formularios = pruebaformularioService.listar()
        log.println("se buscaron")
      } catch (Exception list){
        error = list.getMessage()
      }

      if (error){
        redirect(url: "http://localhost:8080/pruebaFormulario/?error=${Constants.LIST_FORM_ERR}")
      } else{
        params.max = Math.min(max ?: 10, 100)
        respond formularios
      }

    }
//------------------------------------------------------------------------------


//--------------------------------GET Method------------------------------------
    def show(def params) {  //Pruebaformulario pruebaformularioInstance
      log.println("---------------------------------------------")
      log.println("llega un request al show")
      def formulario
      def error

      try {
        log.println("se va a buscar")
        formulario = pruebaformularioService.mostrar(params, "show")
        log.println("Se buscó")
      } catch (Exception show){
        log.println("error al buscar")
        error = show.getMessage()
      }

      if (error){
        flash.message = message(code: "${error}", args: [message(code: 'pruebaformulario.label', default: 'Pruebaformulario')])
        redirect action: "index", method: "GET"
      } else {
        respond formulario
      }

    }
//------------------------------------------------------------------------------


    def create() {
        respond new Pruebaformulario(params)
    }


//-----------------------------------POST Method--------------------------------
    def save(def params) {  //Pruebaformulario pruebaformularioInstance
      log.println("---------------------------------------------")
      log.println("llega un request al post")
      def formulario
      def error

      try {
        log.println("se va a validar")
        validationService.validate(params)
        log.println("Se validó")
      } catch (Exception validar){
        log.println("error al validar")
        error = validar.getMessage()
      }

      if (!error){
        try {
          log.println("se va a crear")
          formulario = pruebaformularioService.crear(params)
          log.println("Se creó")
        } catch (Exception save){
          log.println("error al crear")
          error = crear.getMessage()
        }
      }

      if (formulario){
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pruebaformulario.label', default: 'Formulario'), formulario.apellido])
                redirect formulario
            }
            '*' { respond formulario, [status: CREATED] }
        }
      } else{
        request.withFormat {
            form multipartForm {
                flash.message = message(code: "${error}", args: [message(code: 'pruebaformulario.label', default: 'Pruebaformulario')])
                redirect(controller: "pruebaformulario", action: "create", params: [apellido:"${params.apellido}", genero:"${params.genero}", dni:"${params.dni}", correo:"${params.correo}", personalidad:"${params.personalidad}", hobbies:"${params.hobbies}"])
            }
            '*' { respond formulario, [status: CREATED] }
        }
      }

        //-----------------------------Sin Uso----------------------------------
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
        //----------------------------------------------------------------------
    }
//------------------------------------------------------------------------------


//--------------------------------Edit Method-----------------------------------
    def edit(def params) {  //Pruebaformulario pruebaformularioInstance
      log.println("---------------------------------------------")
      log.println("llega un request al edit")
      log.println("${params}")
      def formulario
      def error

      try {
        log.println("se va a buscar")
        formulario = pruebaformularioService.mostrar(params, "edit")
        log.println("Se buscó")
      } catch (Exception edit){
        log.println("error al buscar")
        error = edit.getMessage()
      }

      if (error){
        flash.message = message(code: "${error}", args: [message(code: 'pruebaformulario.label', default: 'Pruebaformulario')])
        redirect action: "index", method: "GET"
      } else {
        respond formulario
      }

    }
//------------------------------------------------------------------------------


//--------------------------------PUT Method------------------------------------
    def update(def params) {  //Pruebaformulario pruebaformularioInstance
      log.println("---------------------------------------------")
      log.println("llega un request al put")
      log.println("${params}")
      def formulario
      def error

      try {
        log.println("se va a validar")
        validationService.validate(params)
        log.println("Se validó")
      } catch (Exception validar){
        log.println("error al validar")
        error = validar.getMessage()
      }

      if (!error){
        try {
          log.println("se va a modificar")
          formulario = pruebaformularioService.modificar(params)
          log.println("Se modificó")
        } catch (Exception update){
          log.println("error al modificar")
          error = update.getMessage()
        }
      }

      if (formulario){
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Pruebaformulario.label', default: 'Pruebaformulario'), formulario.apellido])
                redirect formulario
            }
            '*'{ respond formulario, [status: OK] }
        }
      } else{
        request.withFormat {
            form multipartForm {
                flash.message = message(code: "${error}", args: [message(code: 'pruebaformulario.label', default: 'Pruebaformulario')])
                redirect(controller: "pruebaformulario", action: "edit", id: params.id)
            }
            '*' { respond formulario, [status: UPDATED] }
        }
      }

        //---------------------------Sin Uso------------------------------------
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
        //----------------------------------------------------------------------
    }
//------------------------------------------------------------------------------


//---------------------------------DELET Method---------------------------------
    def delete(Pruebaformulario pruebaformularioInstance) {
      log.println("---------------------------------------------")
      log.println("llega un request al delete")
      def formulario
      def error

      try {
        log.println("se va a eliminar")
        formulario = pruebaformularioService.eliminar(params)
        log.println("se va a se eliminó")
      } catch (Exception delete){
        log.println("error al eliminar")
        error = delete.getMessage()
      }

      if (formulario){
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Pruebaformulario.label', default: 'Pruebaformulario'), formulario.apellido])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
      } else{
        request.withFormat {
            form multipartForm {
                flash.message = message(code: "${error}", args: [message(code: 'Pruebaformulario.label', default: 'Pruebaformulario'), formulario.apellido])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
      }



        //---------------------------Sin Uso------------------------------------
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
