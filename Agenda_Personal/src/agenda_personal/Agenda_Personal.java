
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
                Indicadores contenedorArrayList = new Indicadores ();
                //el do lo coloque para validar que siempre colocara la opcion correcta para que no salga ningun error al colocar otro
                //caracter que no sea int o un string
            do {
                System.out.println("\nAgenda Personal");
                System.out.println("------------------");
                System.out.println("1. Anadir evento");
                System.out.println("2. Indicadores");
                System.out.println("3. Editar evento");
                System.out.println("4. Eliminar evento");
                System.out.println("5. Mostrar agenda");
                System.out.println("6. Salir");
                System.out.println("------------------");
                System.out.print("Ingrese el numero de la opcion que desea ejecutar: ");
                
               

                // esta parte funciona para que valide que si ingreso un int, si tiene un int continua y no directamente corre la linea de codigo 71 a la 75.
                if (sc.hasNextInt()) { //aqui valida directamente si tiene INTs
                    opcion = sc.nextInt();//aqui lo deja correr si tiene INTs
                    sc.nextLine(); 

                    // este ya es el switch normal
                    switch (opcion) {
                        case 1:
                            System.out.println("Ingrese el nombre del evento: ");
                            nombreEvento = sc.nextLine();

                            System.out.println("Ingrese la hora del evento (0-23): ");
                            horaEvento = sc.nextInt(); 
                            sc.nextLine();

                            if(horaEvento >= 0 && horaEvento <= 23){
                                
                                GestionEventos actividad = new GestionEventos(nombreEvento, horaEvento);
                                agendaDia.agregarEvento(actividad); // aqui la variable agendaDia llama a la funcion agregar evento del archivo AgregarEventos
                                System.out.println("Actividad guardada correctamente.");        
                                                                    
                            } else { 
                                System.out.println("Error: La hora debe estar entre 0 y 23.");
                            } // fin del if
                            
                            
                            break;

                        case 2://crear indicador y establecer meta 
                            char opcionIndicador = 'g';
                              do {
                                 System.out.println("a. Anadir indicador ");
                            System.out.println("b. Eliminar indicador ");
                            System.out.println("c. Visualizar progreso ");
                                opcionIndicador = sc.nextLine().toLowerCase().charAt(0);
                            
                            switch (opcionIndicador){
                                case 'a':
                                    String nombreIndicador = "d";
                                    int metaIndicador = 0;
                                    System.out.println("Ingrese el nombre del nuevo indicador: "); 
                                        nombreIndicador = sc.nextLine();
                                    System.out.println("Ingrese su meta para este indicador: "); 
                                        metaIndicador = sc.nextInt();
                                        sc.nextLine();
                                        //anadir indicador 
                                        Indicadores nuevoIndicador = new Indicadores (nombreIndicador, metaIndicador);
                                        contenedorArrayList.GuardarIndicadores(nuevoIndicador);
                                        
                                    break; 
                                case 'b':
                                    
                                    break; 
                                case 'c': //
                                    contenedorArrayList.VisualizarProgreso();
                                    
                                    break; 
                                default:
                                    break;
                            
                            }//end switch 
                                
                            } while (opcionIndicador != 'd');
                            break;
                            
                        case 3:
                            
                            
                            break;
                            
                        case 4:
       
                            System.out.println("Elija una hora para la actividad que quiere eliminar (0-23): ");
                                horaEvento = sc.nextInt(); // toma la hora de evento
                                
                                if(horaEvento >= 0 && horaEvento <= 23){ //valida que siempre este dentro del rango de 0 a 23
                                    
                                    System.out.println("Eventos en esta hora:");
                                    
                                    agendaDia.mostrarEventosPorHora(horaEvento); //agendaDia llama a mostrar evento y la hora de evento funciona para que funciona el evento mostrar por hora

                                    
                                    System.out.println("Ingrese el numero del evento que desea eliminar: ");
                                    
                                    sc.nextInt();
                                    agendaDia.eliminarEvento(horaEvento, indice); //lo mismo que mostrar eventos pero usando indice para escoger el indice del array.

                                } else {
                                    System.out.println("Hora invalida.");
                                }
                            break;
                            
                        case 5:
                            
                            System.out.println("--- Agenda del Dia ---"); 
                            agendaDia.mostrarAgenda();  //este llama ala funcion mostrarAgenda                           
                            break;
                            
                        case 6: 
                            
                            System.out.println("Saliendo de la agenda..."); //esta funciona para salir del case e iniciar de vuelta
                            break;
                            
                        default:
                            System.out.println("Opción fuera de rango (debe ser 1, 2 o 3)."); // verifica que siempre este dentro del rango de opciones
                            break;
                    }

                } else {

                    System.out.println(" Error: Debe ingresar un numero entero, no texto o simbolos.");
                    opcion = 0; 
                    sc.nextLine(); 
                }

            } while (opcion != 6); // fin del do while
           
// fin del main

    
} // fin del class
}

