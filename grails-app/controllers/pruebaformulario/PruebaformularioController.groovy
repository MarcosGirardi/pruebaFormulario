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
      def mensaje

      try{
        log.println("se van a buscar todos los formularios")
        formularios = pruebaformularioService.listar()
        log.println("se buscaron")
      } catch (Exception list){
        log.println("error al buscar todos los formularios")
        error = list.getMessage()
        log.println("${error}")
      }

      if (error){
        if (error == Constants.LISTAR_FORM_ERROR){
          mensaje = error
        } else {
          mensaje = Constants.OTHER_ERROR
        }
        flash.error = message(code: "${mensaje}", args: [message(code: 'pruebaformulario.label', default: 'Pruebaformulario')])
        redirect(url: "http://localhost:8080/pruebaFormulario/")
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
      def mensaje

      try {
        log.println("se va a buscar")
        formulario = pruebaformularioService.mostrar(params, "show")
        log.println("Se buscó")
      } catch (Exception show){
        log.println("error al buscar")
        error = show.getMessage()
        log.println("${error}")
      }

      if (error){
        if (error == Constants.BUSCAR_FORM_ERROR || error ==  Constants.FORMATEAR_HOOBIES_ERROR || error == Constants.BUSCAR_NOT_FOUND){
          mensaje = error
        } else {
          mensaje = Constants.OTHER_ERROR
        }
        flash.error = message(code: "${mensaje}", args: [message(code: 'pruebaformulario.label', default: 'Pruebaformulario')])
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
      def mensaje

      try {
        log.println("se va a validar")
        validationService.validate(params)
        log.println("Se validó")
      } catch (Exception validar){
        log.println("error al validar")
        error = validar.getMessage()
        log.println("${error}")
      }

      if (!error){
        try {
          log.println("se va a crear")
          formulario = pruebaformularioService.crear(params)
          log.println("Se creó")
        } catch (Exception save){
          log.println("error al crear")
          error = crear.getMessage()
          log.println("${error}")
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
        if (error.contains(Constants.MISSING_FECHA) || error.contains(Constants.FECHA_ERROR) ||  error.contains(Constants.MISSING_DNI) || error.contains(Constants.DNI_INVALID_TYPE) || error.contains(Constants.DNI_INVALID_SIZE) || error.contains(Constants.MISSING_CORREO) || error== Constants.CREAR_FORM_ERROR){
          mensaje = error
        } else {
          mensaje = Constants.OTHER_ERROR
        }
        request.withFormat {
            form multipartForm {
                flash.error = message(code: "${mensaje}", args: [message(code: 'pruebaformulario.label', default: 'Pruebaformulario')])
                forward(controller: "pruebaformulario", action: "create", method: "post", params: [apellido:"${params.apellido}", genero:"${params.genero}", dni:"${params.dni}", correo:"${params.correo}", personalidad:"${params.personalidad}", hobbies:"${params.hobbies}"])
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
      def formulario
      def error
      def mensaje

      try {
        log.println("se va a buscar")
        formulario = pruebaformularioService.mostrar(params, "edit")
        log.println("Se buscó")
      } catch (Exception edit){
        log.println("error al buscar")
        error = edit.getMessage()
        log.println("${error}")
      }

      if (error){
        if (error == Constants.BUSCAR_FORM_ERROR || error == Constants.BUSCAR_NOT_FOUND){
          mensaje = error
        } else {
          mensaje = Constants.OTHER_ERROR
        }
        flash.error = message(code: "${mensaje}", args: [message(code: 'pruebaformulario.label', default: 'Pruebaformulario')])
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
      def formulario
      def error
      def mensaje

      try {
        log.println("se va a validar")
        validationService.validate(params)
        log.println("Se validó")
      } catch (Exception validar){
        log.println("error al validar")
        error = validar.getMessage()
        log.println("${error}")
      }

      if (!error){
        try {
          log.println("se va a modificar")
          formulario = pruebaformularioService.modificar(params)
          log.println("Se modificó")
        } catch (Exception update){
          log.println("error al modificar")
          error = update.getMessage()
          log.println("${error}")
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
        if (error.contains(Constants.MISSING_FECHA) ||  error.contains(Constants.MISSING_DNI) || error.contains(Constants.DNI_INVALID_TYPE) || error.contains(Constants.DNI_INVALID_SIZE) || error.contains(Constants.MISSING_CORREO) || error == Constants.BUSCAR_FORM_ERROR || error== Constants.MODIFICAR_FORM_ERROR){
          mensaje = error
        } else {
          mensaje = Constants.OTHER_ERROR
        }
        request.withFormat {
            form multipartForm {
                flash.error = message(code: "${mensaje}", args: [message(code: 'pruebaformulario.label', default: 'Pruebaformulario')])
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
      def mensaje

      try {
        log.println("se va a eliminar")
        formulario = pruebaformularioService.eliminar(params)
        log.println("se va a se eliminó")
      } catch (Exception delete){
        log.println("error al eliminar")
        error = delete.getMessage()
        log.println("${error}")
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
        if (error.contains(Constants.BUSCAR_FORM_ERROR) ||  error.contains(Constants.BORRAR_FORM_ERROR) || error.contains(Constants.DELETE_NOT_FOUND)){
          mensaje = error
        } else {
          mensaje = Constants.OTHER_ERROR
        }
        request.withFormat {
            form multipartForm {
                flash.error = message(code: "${mensaje}", args: [message(code: 'Pruebaformulario.label', default: 'Pruebaformulario'), formulario.apellido])
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
