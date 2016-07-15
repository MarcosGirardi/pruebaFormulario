package pruebaformulario

class Constants{

//---------------------------Hobbies Formating----------------------------------
  public static String AA = "A"
  public static String BB = "B"
  public static String CC = "C"

  public static String A_A = "Aaaa"
  public static String B_B = "Bbbb"
  public static String C_C = "Cccc"
//------------------------------------------------------------------------------


//--------------------------Missing Optional Atribute---------------------------
  public static String NO_PERSONALITY = "Sin especificar"
  public static String NO_HOBBIES = "Sin hobbies"
//------------------------------------------------------------------------------


//-----------------------------Validation Erros---------------------------------
  public static String FORM_ERROR = "Hay errores en el formulario"
  public static String FECHA_ERROR = "fecha"
  public static String FECHA_MESSAGE = "Ingrese una fecha válida"
  public static String DNI_ERROR = "dni"
  public static String DNI_MESSAGE = "El DNI solo debe tener 8 números"
  public static String EMAIL_ERROR = "correo"
  public static String EMAIL_PATTERN = /([a-z0-9_]+)([.]*[a-z0-9_]*)@([a-z0-9]+)([.]([a-z]+)){1,2}/
  public static String EMAIL_MESSAGE = "Ingrese una dirección de correo válida"
//------------------------------------------------------------------------------


//-------------------------------Method Errors----------------------------------
  public static String LISTAR_ERROR = "Error al listar los formularios"
  public static String BUSCAR_ERROR = "Error al buscar el formulario"
  public static String BUSCAR_NOT_FOUND = "El formulario no existe"
  public static String HOOBIES_FORMATING_ERROR = "Error al dar formato a los hobbies"
  public static String CREAR_ERROR = "Error al guardar el formulario"
  public static String MODIFICAR_ERROR = "Error al actualizar el formulario"
  public static String BORRAR_ERROR = "Error al borrar el formulario"
  public static String DELETED = "El formulario ya no existe"
  public static String RELLENAR_ERROR = "Error al rellenar el formulario"
//------------------------------------------------------------------------------


//------------------------------Success Notifications---------------------------
  public static String CREAR_SUCCESS = "Se guardó el formulario"
  public static String MODIFICAR_SUCCESS = "Se modificó el formulario"
  public static String BORRAR_SUCCESS = "Se eliminó el formulario"
//------------------------------------------------------------------------------


//--------------------------------Other Errors----------------------------------
  public static String OTHER_ERROR = "Lo sentimos, se ha producido un error inesperado"
//------------------------------------------------------------------------------


}
