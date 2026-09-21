
package agenda_personal;

import java.util.Scanner;

/**
 *
 * @author Ricardo Ortez
 */
public class Agenda_Personal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Scanner sc = new Scanner(System.in);

                // Variables;
                int indice = 0;
                int opcion = 0;
                String nombreEvento = "Aquiles";
                int horaEvento = 0;
                String fechaEvento = "Aquiles";
                
                AgregarEventos agendaDia = new AgregarEventos(); //la variable agendaDia funciona para conectarla al indice del array y mediante este agenda dia llmamaos las funciones.
                GestionIndicadores gestionIndicadores = new GestionIndicadores ();
                //el do lo coloque para validar que siempre colocara la opcion correcta para que no salga ningun error al colocar otro
                //caracter que no sea int o un string
            do {
                System.out.println("\nAgenda Personal");
                System.out.println("------------------");
                System.out.println("0. Indicadores");
                System.out.println("1. Anadir evento");
                System.out.println("2. Editar evento");
                System.out.println("3. Eliminar evento");
                System.out.println("4. Mostrar agenda");
                System.out.println("5. Instrucciones de uso");
                System.out.println("6. Salir");
                System.out.println("------------------");
                System.out.print("Ingrese el numero de la opcion que desea ejecutar: ");
 
                // esta parte funciona para que valide que si ingreso un int, si tiene un int continua y no directamente corre la linea de codigo 71 a la 75.
                if (sc.hasNextInt()) { //aqui valida directamente si tiene INTs
                    opcion = sc.nextInt();//aqui lo deja correr si tiene INTs
                    sc.nextLine(); 

                    // este ya es el switch normal
                    switch (opcion) {
                        case 0: //crear indicador y establecer meta 
                            char opcionIndicador = 'g';
                              do {
                            String texto = "f";
                            System.out.println("----------------------");
                            System.out.println("a. Anadir indicador ");
                            System.out.println("b. Eliminar evento ");
                            System.out.println("c. Visualizar progreso ");
                            System.out.println("d. volver ");
                            System.out.println("----------------------");
                                //control de errores al presionar enter y que el espacio cuente como una respuesta. 
                                texto = sc.nextLine().toLowerCase();
                                if (texto.length() > 0) {       //se cuentan la cantidad de letras que se escribieron
                                    opcionIndicador = texto.charAt(0);
                                }//end if
                                else {
                                    opcionIndicador = 'x';  //x va a default no esta entre el switch    
                                }//end else
                            
                            switch (opcionIndicador){
                                case 'a':
                                    String nombreIndicador = "d";
                                    int metaIndicador = 0;
                                    System.out.println("Ingrese el nombre del nuevo indicador: "); 
                                        nombreIndicador = sc.nextLine();
                                    metaIndicador = ValidacionNumero(sc, "Ingrese su meta para este indicador: ");
                                    
                                        //anadir indicador pero verifica que la meta sea valida
                                    while  (metaIndicador <= 0){
                                        System.out.println("La meta debe ser mayor a 0");
                                        metaIndicador = ValidacionNumero(sc, "Ingrese su meta para este indicador: ");
                                    }//end while
      
                                        Indicador nuevoIndicador = new Indicador (nombreIndicador, metaIndicador);
                                        
                                        if(gestionIndicadores.GuardarIndicador(nuevoIndicador)){
                                            System.out.println("Indicador guardado correctamente");
                                        }//end if
                                        else{
                                            System.out.println("Ya alcanzo el maximo de 4 indicadores");
                                        }//end else
      
                                    break; 
                                case 'b':
                                    //System.out.println("volver");
                                    
                                    break; 
                                case 'd':
                                    System.out.println("volver");
                                    
                                    break; 
                                case 'c': //
                                    gestionIndicadores.visualizarProgreso();
                                    
                                    break; 
                                default:
                                    System.out.println("Valor invalido...");
                                    break;
                            }//end switch 
                                
                            } while (opcionIndicador != 'd');
                              break;
                        case 1:
                            
                            System.out.println("Ingrese el nombre del evento: ");
                            nombreEvento = sc.nextLine();
                            //System.out.println("Ingrese la hora del evento (0-23): ");
                            horaEvento = ValidacionNumero(sc, "Ingrese la hora del evento (0-23): ");

                            if(horaEvento >= 0 && horaEvento <= 23){
                                Indicador indicadorElegido = seleccionarIndicador(sc, gestionIndicadores);//guarda lo qeu devuelve la funicon de seleccionarIndicador
                                
                                GestionEventos actividad = new GestionEventos(nombreEvento, horaEvento, indicadorElegido);
                                agendaDia.agregarEvento(actividad); // aqui la variable agendaDia llama a la funcion agregar evento del archivo AgregarEventos
                                System.out.println("Actividad guardada correctamente.");        
                                                                    
                            } else { 
                                System.out.println("Error: La hora debe estar entre 0 y 23.");
                            } // fin del if

                            break;

                        case 2: //este case es tecnicamente el mismo que el 3, lo unica que cambia es la funcion que agregue de editarEvento.
                             //validacion dle numero entero, sino seguira hasta introducir valor correcto 
                            horaEvento = ValidacionNumero(sc, "Elija una hora para la actividad que quiere editar (0-23): ");//lee y valida mediante la funcion el numero correcto

                            if (horaEvento >= 0 && horaEvento <= 23) {//validacion de que la hora este dentro del rango 

                                if (agendaDia.hayEventos(horaEvento)) {//si hay un evento devolvera true, es para no editar algun elemento existente
                                    System.out.println("Eventos en esta hora:");
                                    agendaDia.mostrarEventosPorHora(horaEvento);//muestra los eventos de esa hora para saber ucal escoger 

                                    indice = ValidacionNumero(sc, "Ingrese el numero del evento que desea editar: ");//pide el numero del evento igualmente tiene un validador luego lo gaurda en indice 
                                    GestionEventos eventoElegido = agendaDia.obtenerEvento(horaEvento, indice);//si existe une vento en ese indice lo entrega, sino devuelve null 

                                    if (eventoElegido != null) {//protector de error para validar que el evento si exista y el programa no se cierre de no ser asi 
                                        System.out.println("a. Cambiar nombre");
                                        System.out.println("b. Marcar como completado");
                                        System.out.println("c. Marcar como NO completado");
                                        System.out.println("d. Cancelar");
                                        System.out.print("Elija una opcion: ");

                                        String textoEdicion = sc.nextLine().toLowerCase();
                                        char opcionEdicion = 'x';// si no se escirbe nada esto protege para que quede como invalido y no se cierre el programa

                                        if (textoEdicion.length() > 0) {//valida que no este en cero para no cerrarce
                                            opcionEdicion = textoEdicion.charAt(0);
                                        }//end if

                                        if (opcionEdicion == 'a') {
                                            System.out.println("Nombre del nuevo evento: ");
                                            nombreEvento = sc.nextLine();
                                            //camvia el nombre del mismo evento el indicador y el estado permanecen intactos 
                                            eventoElegido.setNombre(nombreEvento);
                                            System.out.println("Nombre cambiado con exito.");

                                        } //end if
                                        //marca como completado o no completado 
                                        else if (opcionEdicion == 'b' || opcionEdicion == 'c') {

                                            eventoElegido.marcarCompletado(opcionEdicion == 'b');//si el estado cambia sube o baja el indicador, solo si el estado se camvia si sleciono b es true y c es false

                                            if (opcionEdicion == 'b') {
                                                System.out.println("Evento marcado como completado.");
                                            }//end if
                                            else {
                                                System.out.println("Evento marcado como NO completado.");
                                            }//end else

                                            Indicador indicadorDelEvento = eventoElegido.getIndicador();

                                            if (indicadorDelEvento != null) {//solo se meustra el porgreso si el progreso tiene indicador 
                                                System.out.printf("Progreso de %s: %d/%d\n",
                                                        indicadorDelEvento.getNombreIndicador(),
                                                        indicadorDelEvento.getProgresoIndicador(),
                                                        indicadorDelEvento.getMetaIndicador());

                                                if (indicadorDelEvento.metaAlcanzada()) {//se encarga de avisar que la meta se a alcanzado
                                                    System.out.println("Meta alcanzada");
                                                }//end if
                                            }//end if

                                        }//end else if 
                                        else if (opcionEdicion != 'd') {//asegura validar la entrada, un valor que no sea a, b, c, d es invalido 
                                            System.out.println("Opcion invalida.");
                                        }//end else if
                                        else {//devolvio null, el numero no existe
                                            System.out.println("Numero de evento invalido.");
                                        } //end else 

                                    }//end if
                                    else {//la hora no tiene eventos
                                        System.out.println("No hay eventos en esa hora.");
                                    }//end else

                                }// end if
                                else {//la hora no esta entre 0-23
                                    System.out.println("Hora invalida.");
                                }//end else
                            }
                                break;

                        case 3://error de finalizar al seleccionar un evento que no existe y corregir validacion de evento existente
                               //System.out.println("Elija una hora para la actividad que quiere eliminar (0-23): ");
                               horaEvento = ValidacionNumero(sc, "Elija una hora para la actividad que quiere eliminar (0-23): "); // toma la hora de evento

                            if (horaEvento >= 0 && horaEvento <= 23) {//cuida el rando de que la hora ingresada este dentro de los parametros 
                                if (agendaDia.hayEventos(horaEvento)) {//verifica si hay eventos en la hora selecionada
                                    System.out.println("Eventos en esta hora:");
                                    agendaDia.mostrarEventosPorHora(horaEvento);//muestra los evnetos en esa hora.

                                    indice = ValidacionNumero(sc, "Ingrese el numero del evento que desea eliminar: ");//valida que sea un numero entero correcto y no letras o simbolos

                                    if (agendaDia.eliminarEvento(horaEvento, indice)) {//esta estrucutra de condicion, utiliza el metodo para avisar si ha eliminado el evento o no 
                                        System.out.println("Evento eliminado.");
                                    }//end if
                                    else {
                                        System.out.println("Numero de evento invalido.");
                                    }//end else

                                } else {//aviso de que no hay eventos
                                    System.out.println("No hay eventos en esa hora.");
                                }//end else

                            }//end if
                            else {
                                System.out.println("Hora invalida.");
                            }// end else
                            break;
                            
                        case 4:
                            
                            System.out.println("--- Agenda del Dia ---"); 
                            agendaDia.mostrarAgenda();  //este llama ala funcion mostrarAgenda                           
                            break;
                            
                        case 5:
                            System.out.println("\n=== INSTRUCCIONES DE USO DE LA AGENDA PERSONAL ===");
                            System.out.println("1. OPCION 0 - INDICADORES (METAS):");
                            System.out.println("   - Permite crear metas diarias (maximo 4 por dia).");
                            System.out.println("   - Asigna un nombre y un numero entero como meta.");
                            System.out.println("   - Consulta tu avance en 'Visualizar progreso'.");
                            System.out.println();
                            System.out.println("2. OPCION 1 - ANADIR EVENTO:");
                            System.out.println("   - Solicita el nombre de la actividad y la hora (0 a 23).");
                            System.out.println("   - Si existen indicadores, permite vincular la actividad a uno.");
                            System.out.println();
                            System.out.println("3. OPCION 2 - EDITAR EVENTO:");
                            System.out.println("   - Ingresa la hora y el numero de indice del evento.");
                            System.out.println("   - Escribe el nuevo nombre para actualizar la actividad.");
                            System.out.println();
                            System.out.println("4. OPCION 3 - ELIMINAR EVENTO:");
                            System.out.println("   - Ingresa la hora y el indice del evento para borrarlo.");
                            System.out.println();
                            System.out.println("5. OPCION 4 - MOSTRAR AGENDA:");
                            System.out.println("   - Muestra el horario completo del dia con sus actividades.");
                            System.out.println();
                            System.out.println("6. CONVENCIONES DE ESTADO:");
                            System.out.println("   - [ ] Indica actividad pendiente.");
                            System.out.println("   - [X] Indica actividad completada.");
                            System.out.println("==================================================");
                            break;

                        case 6:
                            System.out.println("Saliendo de la agenda...");
                            break;
                            
                        default:
                            
                            System.out.println("Opcion fuera de rango (debe ser 0, 1, 2, 3, 4, 5 o 6).");
                            break;
                    }

                } else {

                    System.out.println(" Error: Debe ingresar un numero entero, no texto o simbolos.");
                    opcion = 0; 
                    sc.nextLine(); 
                }

            } while (opcion != 6); // fin del do while  
} // fin del main
    
    //funcion para ontrol de errores, evita que el programa se detenga por un valor que no sea un int y simplifica los print
    public static int ValidacionNumero(Scanner sc, String mensaje){
        int numeroValido = 0;
        System.out.println(mensaje);
        while (!sc.hasNextInt()){
            sc.nextLine();
            System.out.println("Valor invalido, por favor, ingrese un numero entero nuevamente: ");
         }//end while
             numeroValido = sc.nextInt();
             sc.nextLine();
             return numeroValido;   
    }//end ValidacionNumero
    
    public static Indicador seleccionarIndicador(Scanner sc, GestionIndicadores gestor) {

    if (!gestor.hayIndicadores()) {
        System.out.println("No hay indicadores creados, el evento se guardara sin indicador.");
        return null;
    }//end if

    System.out.println("Asociar el evento a un indicador:");
    System.out.println("0. Ninguno");
    gestor.listarIndicadores();

    int eleccion = ValidacionNumero(sc, "Elija una opcion: ");
    Indicador elegido = null;

    while (eleccion != 0 && elegido == null) {
        elegido = gestor.obtener(eleccion - 1);

        if (elegido == null) {
            System.out.println("Opcion invalida.");
            eleccion = ValidacionNumero(sc, "Elija una opcion: ");
        }//end  if
    }//end while
    return elegido;
}//end if
}// fin del class

