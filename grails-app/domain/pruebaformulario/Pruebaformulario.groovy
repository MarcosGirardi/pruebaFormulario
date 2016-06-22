package pruebaformulario

class Pruebaformulario {

  String apellido
  Date fechaNac
  String genero
  Integer dni
  String correo
  String personalidad
  String hobbies

  static constraints = {
        apellido(maxSize:50,blank:false)
        fechaNac(nullable:true)
        genero(inList:["M", "F"])
        dni(blank:false)
        correo(maxSize:50,email:true)
        personalidad(nullable:true)
        hobbies(nullable:true)
  }
}
