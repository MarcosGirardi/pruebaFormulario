package pruebaformulario



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PruebaformularioController {

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
