package pruebaformulario

import grails.transaction.Transactional

@Transactional
class PruebaformularioService {

    def listar() {
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
}
