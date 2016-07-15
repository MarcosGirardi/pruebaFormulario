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
        error += " " + Constants.FECHA_ERROR
      } else{
        if (sdf.format(dia) <= sdf.format(params.fechaNac)){
          error = Constants.FECHA_ERROR
        }
      }
      if (!params.dni){
        error += " " + Constants.DNI_ERROR
      } else{
        if (!params.dni.isBigInteger()){
          error += " " + Constants.DNI_ERROR
        } else{
          if (params.dni.size()!=8){
            error += " " + Constants.DNI_ERROR
          }
        }
      }
      if (!params.correo){
        error += " " + Constants.EMAIL_ERROR
      } else{
        if (!(params.correo ==~ Constants.EMAIL_PATTERN)){
          error += " " + Constants.EMAIL_ERROR
        }
      }

      if (error){throw new Exception (error)}

    }
//------------------------------------------------------------------------------


//-----------------------------------Rellenar-----------------------------------
  def rellenar(def form, def params){
    log.println("rellenar(${form}, ${params})")
    
    form.apellido = params.apellido
    form.genero = params.genero
    form.personalidad = params.personalidad
    form.hobbies = params.hobbies
    form.borrado = params.borrado
    if (!params.error.contains(Constants.FECHA_ERROR)){
      form.fechaNac = params.fechaNac
    }
    if (!params.error.contains(Constants.DNI_ERROR)){
      form.dni = params.dni
    }
    if (!params.error.contains(Constants.EMAIL_ERROR)){
      form.correo = params.correo
    }

    form

  }
//------------------------------------------------------------------------------
}
