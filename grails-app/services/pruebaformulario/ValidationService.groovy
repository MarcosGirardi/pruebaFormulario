package pruebaformulario

import grails.transaction.Transactional

@Transactional
class ValidationService {

//----------------------------Validacion de Fomr--------------------------------
    def validate(def params) {
      log.println("validate(${params})")
      def error = "Falta:"

      if (!params.fechaNac){error += "\n" + "fecha de nacimiento;"}
      if (!params.dni){error += "\n" + "DNI;"}
      if (!params.correo){error += "\n" + "correo;"}
      log.println("${error}")

      if (error != "Falta:"){throw new Exception (error)}

    }
//------------------------------------------------------------------------------


//-----------------------------Recuperar----------------------------------------
  def recuperar(def form, def error){
    log.println("recuperar(${form}, ${error})")
    def temp

    try {
      log.println("se va a recuperar")
      temp = Pruebaformulario.read(form.id)
      log.println("se recuperó")
    } catch (Exception recuperar){
      log.println("error al recuperar")
      log.println("${recuperar.getMessage()}")
      throw new Exception (Constants.RECUPERAR_FORM_ERROR)
    }

    if (error.contains("fecha de nacimiento")){
      form.fechaNac = temp.fechaNac
    }
    if (error.contains("DNI")){
      form.dni = temp.dni
    }
    if (error.contains("correo")){
      form.correo = temp.correo
    }

    form

  }
//------------------------------------------------------------------------------
}
