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


//-----------------------------Recuperar----------------------------------------
//----------------------------Sin Uso Por Ahora---------------------------------
  def recuperar(def form){
    log.println("recuperar(${form})")
    def temp

    try {
      log.println("recuperando")
      temp = Pruebaformulario.read(form.id)
      log.println("se ha recuperado")
    } catch (Exception recuperar){
      log.println("error al recuperar")
      log.println("${recuperar.getMessage()}")
      throw new Exception (Constants.RECUPERAR_FORM_ERROR)
    }

    temp.apellido = form.apellido
    temp.genero = form.genero
    temp.personalidad = form.personalidad
    temp.hobbies = form.hobbies
    if (!form.error.contains(Constants.FECHA_ERROR)){
      temp.fechaNac = form.fechaNac
    }
    if (!form.error.contains(Constants.DNI_ERROR)){
      temp.dni = form.dni
    }
    if (!form.error.contains(Constants.EMAIL_ERROR)){
      temp.correo = form.correo
    }

    temp

  }
//------------------------------------------------------------------------------


//-----------------------------------Rellenar-----------------------------------
  def rellenar(def form, def temp){
    log.println("rellenar(${form}, ${temp})")
    form.apellido = temp.apellido
    form.fechaNac = temp.fechaNac
    form.genero = temp.genero
    form.dni = temp.dni
    form.correo = temp.correo
    form.personalidad = temp.personalidad
    form.hobbies = temp.hobbies
    form.borrado = temp.borrado

    form
  }
}
