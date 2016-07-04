package pruebaformulario



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
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
      } catch (Exception b){
        log.println("error al buscar los formularios")
        error = b.getMessage()
        log.println("${error}")
      }

      if (!error){
        params.max = Math.min(max ?: 10, 100)
        respond formularios, model:[pruebaformularioInstanceCount: Pruebaformulario.count()]
      } else{
        //redirect action:"index", method:"GET"
      }

    }
//------------------------------------------------------------------------------


//--------------------------------GET Method------------------------------------
    def show(Pruebaformulario pruebaformularioInstance) {
        respond pruebaformularioInstance
    }
//------------------------------------------------------------------------------


    def create() {
        respond new Pruebaformulario(params)
    }
    

//-----------------------------------POST Method--------------------------------
    @Transactional
    def save(Pruebaformulario pruebaformularioInstance) {
        if (pruebaformularioInstance == null) {
            notFound()
            return
        }

        if (pruebaformularioInstance.hasErrors()) {
            respond pruebaformularioInstance.errors, view:'create'
            return
        }

        pruebaformularioInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pruebaformulario.label', default: 'Pruebaformulario'), pruebaformularioInstance.id])
                redirect pruebaformularioInstance
            }
            '*' { respond pruebaformularioInstance, [status: CREATED] }
        }
    }
//------------------------------------------------------------------------------


    def edit(Pruebaformulario pruebaformularioInstance) {
        respond pruebaformularioInstance
    }


//--------------------------------PUT Method------------------------------------
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
//------------------------------------------------------------------------------


//---------------------------------DELET Method---------------------------------
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
