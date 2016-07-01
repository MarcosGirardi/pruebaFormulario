package pruebaformulario

import grails.transaction.Transactional

@Transactional
class ValidationService {

//----------------------------Form Validation-----------------------------------
  def validate(def params) {
    log.println("validando")
    String message

    if (!params.fechaNac){
      message1 = "Falta fecha de nacimiento;"
    }
    if (!params.genero){
      message2 = "Falta genero;"
    }
    if (!params.dni){
      message3 = "Falta DNI;"
    }
    if (!params.correo){
      message4 = "Falta correo"
    }

    if (message1){message = message + message1}
    if (message2){
      if (message){message = message + "\n" + message2}
    }else {message = message + message2}
    if (message3){
      if (message){message = message + "\n" + message3}
    } else {message = message + message3}
    if (message4){
      if (message){message = message + "\n" + message4}
    }else {message = message + message4}

    if(message){
      throw new Exception (message)
    }

  }
//------------------------------------------------------------------------------

}
