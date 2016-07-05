package pruebaformulario

import grails.transaction.Transactional

@Transactional
class FormatService {

//----------------------------Hobbies Formating---------------------------------
    def hobbiesShow(def params) {
      log.println("hobbiesShow(${params})")
      def h = params.tokenize('-')
      def format

      h.each {
        switch(it) {
          case Constants.AA:
            if (format){
              format += "\n" + Constants.A_A
            } else{
              format = Constants.A_A
            }
          break

          case Constants.BB:
            if (format){
              format += "\n" + Constants.B_B
            } else{
              format = Constants.B_B
            }
          break

          case Constants.CC:
            if (format){
              format += "\n" + Constants.C_C
            } else{
              format = Constants.C_C
            }
          break

          default:
            format = params
          break

        }
      }

    format

    }
//------------------------------------------------------------------------------
}
