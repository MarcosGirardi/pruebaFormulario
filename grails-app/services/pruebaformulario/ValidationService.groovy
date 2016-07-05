package pruebaformulario

import grails.transaction.Transactional

@Transactional
class ValidationService {

//----------------------------Validacion de Fomr--------------------------------
    def validate(def params) {
      log.println("validate(${params})")
      def error = "Falta:"

      params.format = 'dd-MM-yyyy'
      log.println("${params.format}")

      if (!params.fechaNac){error += "\n" + "fecha de nacimiento;"}
      if (!params.dni){error += "\n" + "DNI;"}
      if (!params.correo){error += "\n" + "correo;"}

      if (error != "Falta:"){throw new Exception (error)}

    }
//------------------------------------------------------------------------------
}
