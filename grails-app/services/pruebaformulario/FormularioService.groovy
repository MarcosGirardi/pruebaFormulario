package pruebaformulario

import grails.transaction.Transactional

@Transactional
class FormularioService {

//------------------------------Form Save---------------------------------------
    def guardar(def params) {
      FormularioService form
      form.apellido = params.apellido
      form.fechaNac = params.fechaNac
      form.genero = params.genero
      form.dni = params.dni
      form.correo = params.correo
      form.personalidad = params.personalidad
      if (params.hobbies){
        form.hobbies = params.hobbies
      }

      try{
        log.println("se va a guardar")
        form.save(flush:true)
        log.println("se guardó")
      } catch (Exception s){
        log.println("error al intentar guardar")
        throw new Exception (s.getMessage())
      }

      recurso

    }
}
