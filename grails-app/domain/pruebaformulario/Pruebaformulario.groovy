package pruebaformulario

class Pruebaformulario {

  String apellido
  Date fechaNac = new Date()
  String genero
  String dni
  String correo
  String personalidad
  String hobbies

  static constraints = {
        apellido(maxSize:50,blank:false)
        fechaNac(nullable:true)
        genero(inList:["M", "F"])
        dni(nullable:true, maxSize:8, minSize:8)
        correo(maxSize:50,email:true,nullable:true)
        personalidad(nullable:true)
        hobbies(nullable:true)
  }
}
