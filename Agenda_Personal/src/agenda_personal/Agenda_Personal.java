
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
                System.out.println("5. Salir");
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
                            //System.out.println("Elija una hora para la actividad que quiere editar (0-23): ");
                            horaEvento = ValidacionNumero(sc, "Elija una hora para la actividad que quiere editar (0-23): ");
                            if(horaEvento >= 0 && horaEvento <= 23){ //valida que siempre este dentro del rango de 0 a 23
                                    
                                    System.out.println("Eventos en esta hora:");
                                    
                                    agendaDia.mostrarEventosPorHora(horaEvento); 

                                    
                                    System.out.println("Ingrese el numero del evento que desea editar: ");  
                                    indice = sc.nextInt(); 
                                    
                                    sc.nextLine();
                                    
                                    System.out.println("Nombre del nuevo evento: ");
                                    nombreEvento = sc.nextLine();
                                    
                                                                        
                                    agendaDia.editarEvento(horaEvento, indice, nombreEvento); 
                                    
                                    /* Explicacion de editarEvento
                                    la variable horaEvento dentro de los parametros de editarEvento se conseguis desde la linea de codigo 71
                                    la variable indice se consegui de la linea de codigo 80
                                    la variable nombreEvento desde la linea 85.                                  
                                    
                                    */
                                    System.out.println("Nombre cambiado con exito. ");
                                    
                                } else {
                                    System.out.println("Hora invalida.");
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
                            
                            System.out.println("Saliendo de la agenda..."); //esta funciona para salir del case e iniciar de vuelta
                            break;
                            
                        default:
                            System.out.println("Opcion fuera de rango (debe ser 0, 1, 2, 3, 4 o 5)."); // verifica que siempre este dentro del rango de opciones
                            
                            break;
                    }

                } else {

                    System.out.println(" Error: Debe ingresar un numero entero, no texto o simbolos.");
                    opcion = 0; 
                    sc.nextLine(); 
                }

            } while (opcion != 5); // fin del do while  
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

