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

//--------------------------------Form Update-----------------------------------
  def modificar(def params){
    def form = PruebaFormulario.findById(params.id)

    if (form){
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
    } else{
      message = "no existe el formulario"
      throw new Exception (message)
    }

    try{
      log.println("se va a modificar")
      form.save(flush:true)
      log.println("se modificó")
    } catch (Exception u){
      log.println ("error al intentar modificar")
      throw new Exception (u.getMessage())
    }

    form

  }
//------------------------------------------------------------------------------

//--------------------------------Form Delete-----------------------------------
  def borrar(def params){
    def form = Pruebaformulario.findById(params.id)

    if (form){
      log.println("se va a borrar")
      form.delete(flush:true)
      log.println("se borró")
    } catch (Exception d){
      log.println ("error al intentar borrar")
      throw new Exception (u.getMessage())
    }
  }
//------------------------------------------------------------------------------
}
