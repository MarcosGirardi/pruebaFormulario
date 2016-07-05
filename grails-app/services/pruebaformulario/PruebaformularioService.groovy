package pruebaformulario

import grails.transaction.Transactional

@Transactional
class PruebaformularioService {
  def formatService

//--------------------------------LISTAR----------------------------------------
    def listar() {
      log.println("listar()")
      def forms
      def f = Pruebaformulario.createCriteria()
      try{
        forms = f{
          order("apellido", "asc")
        }
      } catch (Exception b){
        throw new Exception (b.getMessage())
      }

      forms

    }
//------------------------------------------------------------------------------


//-------------------------------MOSTRAR----------------------------------------
  def mostrar(def params){
    log.println("mostrar(${params})")
    def form
    def error

    try {
      log.println("buscando")
      form = Pruebaformulario.findById(params.id)
      log.println("buscado")
    } catch (Exception mostrar){
      log.println("error al buscar")
      throw new Exception (mostrar.getMessage())
    }

    if(form.hobbies){
      try {
        log.println("se va a formatear hobbies")
        form.hobbies = formatService.hobbiesShow(form.hobbies)
        log.println("se formatearon los hobbies")
      } catch (Exception format){
          log.println("error al formatear")
          error = format.getMessage()
          log.println("${error}")
          throw new Exception (error)
      }
    }

    form

  }
//------------------------------------------------------------------------------
}
