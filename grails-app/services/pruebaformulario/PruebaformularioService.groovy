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
        forms = f{
          order("apellido", "asc")
        }
      } catch (Exception b){
        throw new Exception (b.getMessage())
      }

      forms

    }
//------------------------------------------------------------------------------


//-------------------------------MOSTRAR----------------------------------------
  def mostrar(def params){
    log.println("mostrar(${params})")
    def form
    def error

    try {
      log.println("buscando")
      form = Pruebaformulario.read(params.id)
      log.println("buscado")
    } catch (Exception mostrar){
      log.println("error al buscar")
      throw new Exception (mostrar.getMessage())
    }

    if(form.hobbies){
      try {
        log.println("se va a formatear hobbies")
        form.hobbies = formatService.hobbiesShow(form.hobbies)
        log.println("se formatearon los hobbies")
      } catch (Exception format){
          log.println("error al formatear")
          error = format.getMessage()
          log.println("${error}")
          throw new Exception (error)
      }
    }

    form

  }
//------------------------------------------------------------------------------


//----------------------------------CREAR---------------------------------------
  def crear(def params){
    log.println("crear(${params})")
    def form = new Pruebaformulario()
    def error

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

    try {
      log.println("se va a guardar")
      form.save(fĺush:true)
      log.println("se va guardó")
    } catch (Exception guardado){
      log.println("error al guardar")
      error = guardado.getMessage()
      throw new Exception (error)
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
      throw new Exception (buscar.getMessage())
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
    } catch (Exception guardado){
      log.println("error al guardar")
      error = guardado.getMessage()
      throw new Exception (error)
    }

    form

  }
//------------------------------------------------------------------------------
}
