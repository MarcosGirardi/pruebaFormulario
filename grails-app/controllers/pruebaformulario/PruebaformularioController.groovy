package pruebaformulario



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

class PruebaformularioController {
  def validationService
  def pruebaformularioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]


//-----------------------------------Listar-------------------------------------
    def index(def params) {
      log.println("---------------------------------------------")
      log.println("llega un request al Listar")
      def formularios
      def total
      def error

      try{
        log.println("se van a buscar todos los formularios")
        (formularios, total) = pruebaformularioService.listar(params)
        log.println("se buscaron")
      } catch (Exception list){
        log.println("error al buscar todos los formularios")
        error = list.getMessage()
        log.println("${error}")
      }

      if (formularios){
        respond formularios, model:[pruebaformularioInstanceCount: total]
      } else{
        if (error != Constants.LISTAR_ERROR){
          error = Constants.OTHER_ERROR
        }
        flash.message = message(code: "${error}", args: [message(code: 'pruebaformulario.label', default: 'Pruebaformulario')])
        redirect(url: "http://localhost:8080/pruebaFormulario/")
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
        log.println("${error}")
      }

      if (formulario){
        respond formulario
      } else{
        if (error != Constants.BUSCAR_ERROR && error !=  Constants.HOOBIES_FORMATING_ERROR && error != Constants.BUSCAR_NOT_FOUND){
          error = Constants.OTHER_ERROR
        }
        flash.message = message(code: "${error}", args: [message(code: 'pruebaformulario.label', default: 'Pruebaformulario')])
        redirect action: "index", method: "GET"
      }

    }
//------------------------------------------------------------------------------


//------------------------------Create Method-----------------------------------
    def create() {
        respond new Pruebaformulario(params)
    }
//------------------------------------------------------------------------------


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
                flash.message = message(code: Constants.CREAR_SUCCESS +  " ${formulario.apellido}")
                redirect formulario
            }
            '*' { respond formulario, [status: CREATED] }
        }
      } else{
        if (!(error.contains(Constants.FECHA_ERROR)) && !(error.contains(Constants.DNI_ERROR)) && !(error.contains(Constants.EMAIL_ERROR)) && error != Constants.CREAR_ERROR){
          error = Constants.OTHER_ERROR
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: "${error}")
                forward(controller: "pruebaformulario", action: "create", method: "post", params: params)
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

      try {
        log.println("se va a buscar")
        formulario = pruebaformularioService.mostrar(params, "edit")
        log.println("Se buscó")
      } catch (Exception edit){
        log.println("error al buscar")
        error = edit.getMessage()
        log.println("${error}")
      }

      if (formulario){
        respond formulario
      } else{
        if (error != Constants.BUSCAR_ERROR && error != Constants.BUSCAR_NOT_FOUND){
          error = Constants.OTHER_ERROR
        }
        flash.message = message(code: "${error}", args: [message(code: 'pruebaformulario.label', default: 'Pruebaformulario')])
        redirect action: "index", method: "GET"
      }

    }
//------------------------------------------------------------------------------


//--------------------------------PUT Method------------------------------------
    def update(def params) {  //Pruebaformulario pruebaformularioInstance
      log.println("---------------------------------------------")
      log.println("llega un request al put")
      def formulario
      def error

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
                flash.message = message(code: Constants.MODIFICAR_SUCCESS + " ${formulario.apellido}")
                redirect formulario
            }
            '*'{ respond formulario, [status: OK] }
        }
      } else{
        if (!(error.contains(Constants.FECHA_ERROR)) && !(error.contains(Constants.DNI_ERROR)) && !(error.contains(Constants.EMAIL_ERROR)) && error != Constants.BUSCAR_ERROR && error != Constants.DELETED && error != Constants.MODIFICAR_ERROR){
          error = Constants.OTHER_ERROR
        }
        request.withFormat {
            form multipartForm {
                flash.message = message(code: "${error}", args: [message(code: 'pruebaformulario.label', default: 'Pruebaformulario')])
                forward(controller: "pruebaformulario", action: "edit", params: params)  //id: params.id
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
        log.println("${error}")
      }

      if (formulario){
        request.withFormat {
            form multipartForm {
                flash.message = message(code: Constants.BORRAR_SUCCESS + " ${formulario.apellido}")
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
      } else{
        if (error != Constants.BUSCAR_ERROR &&  error != Constants.BORRAR_ERROR && error != Constants.DELETED){
          error = Constants.OTHER_ERROR
        }
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
