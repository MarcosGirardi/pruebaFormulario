package pruebaformulario

import grails.transaction.Transactional

@Transactional
class PruebaformularioService {

//------------------------------Form Save---------------------------------------
    def guardar(def params) {
      Pruebaformulario form
      form.apellido = params.apellido
      form.fechaNac = params.fechaNac
      form.genero = params.genero
      form.dni = params.dni
      form.correo = params.correo
      if (params.personalidad){
        form.personalidad = params.personalidad
      } else{
        form.personalidad = "Sin Datos"
      }
      if (params.hobbies){
        form.hobbies = params.hobbies
      } else{
        form.hobbies = "Sin Datos"
      }

      try{
        log.println("se va a guardar")
        form.save(flush:true)
        log.println("se guardó")
      } catch (Exception s){
        log.println("error al intentar guardar")
        throw new Exception (s.getMessage())
      }

      form

    }
//------------------------------------------------------------------------------
}
