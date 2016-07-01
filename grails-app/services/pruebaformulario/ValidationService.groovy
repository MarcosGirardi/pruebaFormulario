package pruebaformulario

import grails.transaction.Transactional

@Transactional
class ValidationService {

//----------------------------Form Validation-----------------------------------
  def validate(def params) {
    log.println("validando")
    String message

    if(!params.fechaNac){
      message = message + "Falta fecha de nacimiento;"
    }
    if(!params.genero){
      message = message + "Falta genero;"
    }
    if(!params.dni){
      message = message + "Falta DNI;"
    }
    if(!params.correo){
      message = message + "Falta correo"
    }

    if(message){
      throw new Exception (message)
    }

  }
//------------------------------------------------------------------------------

}
