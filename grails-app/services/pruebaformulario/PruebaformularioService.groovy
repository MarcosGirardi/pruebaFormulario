package pruebaformulario

import grails.transaction.Transactional

@Transactional
class PruebaformularioService {

//------------------------------Form Save---------------------------------------
    def guardar(def params) {
      log.println("guardar(); PruebaformularioService")
      def form = new Pruebaformulario()
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
/*
      try{
        log.println("se va a guardar")
        form.save(flush:true)
        log.println("se guardó")
      } catch (Exception s){
        log.println("error al intentar guardar")
        throw new Exception (s.getMessage())
      }*/

      if (!form.save(flush:true)) {
      log.error(form.errors)
    }

      form

    }
//------------------------------------------------------------------------------


//--------------------------------Form Update-----------------------------------
  def modificar(def params){
    log.println("modificar(); PruebaformularioService")
    def form

    try {
      log.println("se va a buscar")
      form = PruebaFormulario.findById(params.id)
      log.println("se buscó")
    } catch (Exception b){
      log.println ("error al buscar")
      throw new Exception (b.getMessage())
    }

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
    log.println("borrar(); PruebaformularioService")
    def form
    try {
      log.println("se va a buscar")
      form = Pruebaformulario.findById(params.id)
      log.println("se buscó")
    } catch (Exception b){
      log.println ("error al buscar")
      throw new Exception (b.getMessage())
    }

    if (form){
      try {
        log.println("se va a borrar")
        form.delete(flush:true)
        log.println("se borró")
      } catch (Exception d){
        log.println ("error al intentar borrar")
        throw new Exception (u.getMessage())
      }
    } else{
      message = "no existe el formulario"
      throw new Exception (message)
    }

  }
//------------------------------------------------------------------------------


//---------------------------------Form Serach----------------------------------
  def mostrar(def params){
    log.println("buscar(); PruebaformularioService")
    def form

    try{
      log.println("buscando")
      form = Pruebaformulario.findById(params)
      log.println("buscado")
    } catch (Exception m){
      log.println("error al buscar")
      throw new Exception (m.getMessage())
    }

    form

  }
//------------------------------------------------------------------------------


//-----------------------------------Form List----------------------------------
  def listar(){
    log.println("listar(); PruebaformularioService")
    def forms
    def f = Pruebaformulario.createCriteria()

    try {
      log.println("se va a listar")
      forms = f {
        order("apellido", "asc")
      }
      log.println("se listó")
    } catch (Exception l){
      log.println("error al listar")
      throw new Exception (l.getMessage())
    }

    forms

  }
//------------------------------------------------------------------------------
}
