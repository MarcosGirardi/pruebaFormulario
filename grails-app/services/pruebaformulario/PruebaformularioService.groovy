package pruebaformulario

import grails.transaction.Transactional

@Transactional
class PruebaformularioService {
  def formatService

//--------------------------------LISTAR----------------------------------------
    def listar() {
      log.println("listar()")
      def forms
      def f = Pruebaformulario.createCriteria()

      try{
        log.println("se va a listar")
        forms = f{
          order("apellido", "asc")
          eq("borrado", false)
        }
        log.println("se listó")
      } catch (Exception listar){
        log.println("error al listar")
        log.println("${listar.getMessage()}")
        throw new Exception (Constants.LISTAR_FORM_ERROR)
      }

      forms

    }
//------------------------------------------------------------------------------


//-------------------------------MOSTRAR----------------------------------------
  def mostrar(def params, def str){
    log.println("mostrar(${params}; ${str})")
    def form

    try {
      log.println("buscando")
      form = Pruebaformulario.read(params.id)
      log.println("buscado")
    } catch (Exception mostrar){
      log.println("error al buscar")
      log.println("${mostrar.getMessage()}")
      throw new Exception (Constants.BUSCAR_FORM_ERROR)
    }

    if (form && form.borrado==false){
      switch(str) {

        case "show":
        if(form.hobbies != Constants.NO_HOBBIES){
          try {
            log.println("se va a formatear hobbies")
            form.hobbies = formatService.hobbies(form.hobbies)
            log.println("se formatearon los hobbies")
          } catch (Exception format){
              log.println("error al formatear")
              log.println("${format.getMessage()}")
              throw new Exception (Constants.FORMATEAR_HOOBIES_ERROR)
          }
        }
        break

        case "edit":
        if(form.hobbies == Constants.NO_HOBBIES){
          form.hobbies = null
        }
        if(form.personalidad == Constants.NO_PERSONALITY){
          form.personalidad = null
        }
        break

      }
    } else{
      throw new Exception (Constants.BUSCAR_NOT_FOUND)
    }

    form

  }
//------------------------------------------------------------------------------


//----------------------------------CREAR---------------------------------------
  def crear(def params){
    log.println("crear(${params})")
    def form = new Pruebaformulario()

    form.apellido = params.apellido
    form.fechaNac = params.fechaNac
    form.genero = params.genero
    form.dni = params.dni
    form.correo = params.correo
    if (params.personalidad){
      form.personalidad = params.personalidad
    } else{
      form.personalidad = Constants.NO_PERSONALITY
    }
    if (params.hobbies){
      form.hobbies = params.hobbies
    } else{
      form.hobbies = Constants.NO_HOBBIES
    }
    form.borrado = false

    try {
      log.println("se va a guardar")
      form.save(fĺush:true)
      log.println("se guardó")
    } catch (Exception crear){
      log.println("error al guardar")
      log.println("${crear.getMessage()}")
      throw new Exception (Constants.CREAR_FORM_ERROR)
    }

    form

  }
//------------------------------------------------------------------------------


//------------------------------------MODIFICAR---------------------------------
  def modificar(def params){
    log.println("modificar(${params})")
    def form
    def error

    try {
      log.println("buscando")
      form = Pruebaformulario.findById(params.id)
      log.println("buscado")
    } catch (Exception buscar){
      log.println("error al buscar")
      log.println("${buscar.getMessage()}")
      throw new Exception (Constants.BUSCAR_FORM_ERROR)
    }

    form.apellido = params.apellido
    form.fechaNac = params.fechaNac
    form.genero = params.genero
    form.dni = params.dni
    form.correo = params.correo
    if (params.personalidad){form.personalidad = params.personalidad}
    if (params.hobbies){form.hobbies = params.hobbies}

    try {
      log.println("se va a guardar")
      form.save(fĺush:true)
      log.println("se va guardó")
    } catch (Exception modificar){
      log.println("error al guardar")
      log.println("${modificar.getMessage()}")
      throw new Exception (Constants.MODIFICAR_FORM_ERROR)
    }

    form

  }
//------------------------------------------------------------------------------


//--------------------------------ELIMINAR--------------------------------------
  def eliminar(def params){
    log.println("eliminar(${params})")
    def form
    def error

    try {
      log.println("se va a buscar")
      form = Pruebaformulario.findById(params.id)
      log.println("se va a buscó")
    } catch (Exception buscar){
      log.println("error al buscar")
      log.println("${buscar.getMessage()}")
      throw new Exception (Constants.BUSCAR_FORM_ERROR)
    }

    if (form){
      try {
        log.println("se va a borrar")
        form.borrado = true
        form.save(flush:true)
        log.println("se va a borró")
      }catch (Exception eliminar){
        log.println("error al borrar")
        log.println("${eliminar.getMessage()}")
        throw new Exception (Constants.BORRAR_FORM_ERROR)
      }
    } else{
      throw new Exception (Constants.DELETE_NOT_FOUND)
    }

    form

  }
//------------------------------------------------------------------------------
}
