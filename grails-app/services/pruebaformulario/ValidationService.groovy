package pruebaformulario

import grails.transaction.Transactional

@Transactional
class ValidationService {

//----------------------------Form Validation-----------------------------------
  def validate(def params) {
    log.println("validando")
    String message

    if(!params.fechaNac){
      message = "Falta fecha de nacimiento"
      throw new Exception (message)
    }

    if(!params.genero){
      message = "Falta genero"
      throw new Exception (message)
    }

    if(!params.dni){
      message = "Falta DNI"
      throw new Exception (message)
    }

    if(!params.correo){
      message = "Falta correo"
      throw new Exception (message)
    }

    if(!params.hobbies){
      message = "Elija por lo menos 1 hobby"
      throw new Exception (message)
    }

  }
}
