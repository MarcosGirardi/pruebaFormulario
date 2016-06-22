package pruebaformulario

import grails.transaction.Transactional

@Transactional
class FormularioService {

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
      form.save(flush:true)

      recurso

    }
}
