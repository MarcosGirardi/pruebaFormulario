package pruebaformulario

import grails.transaction.Transactional
import java.text.SimpleDateFormat
import java.util.regex.*

@Transactional
class ValidationService {

//----------------------------Validacion de Fomr--------------------------------
    def validate(def params) {
      log.println("validate(${params})")
      def error = ""
      def dia = new Date()
      def sdf
      sdf = new SimpleDateFormat("MM/dd/yyyy")

      if (!params.fechaNac){
        error += " " + Constants.MISSING_FECHA
      } else{
        if (sdf.format(dia) <= sdf.format(params.fechaNac)){
          error = Constants.FECHA_ERROR
        }
      }
      if (!params.dni){
        error += " " + Constants.MISSING_DNI
      } else{
        if (!params.dni.isBigInteger()){
          error += " " + Constants.DNI_INVALID_TYPE
        } else{
          if (params.dni.size()!=8){
            error += " " + Constants.DNI_INVALID_SIZE
          }
        }
      }
      log.println(params.correo ==~ Constants.CORREO_PATTERN)
      if (!params.correo){
        error += " " + Constants.MISSING_CORREO
      } else{
        if (!(params.correo ==~ Constants.CORREO_PATTERN)){
          error += " " + Constants.CORREO_ERROR
        }
      }

      if (error){throw new Exception (error)}

    }
//------------------------------------------------------------------------------


//-----------------------------Recuperar----------------------------------------
//----------------------------Sin Uso Por Ahora---------------------------------
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
