
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
        //variables
        int opcion = 0;
        String nombreEvento= "Aquiles";
        int horaEvento = 0;
        String fechaEvento = "Aquiles";
        
        //menu principal en pantalla 
        System.out.println("Agenda Personal");
        System.out.println("------------------");
        System.out.println("1. Anadir evento");
        System.out.println("2. Editar evento");
        System.out.println("3. Eliminar evento");
        System.out.println("------------------");
        System.out.println("Ingrese el numero de la opcion que desea ejecutar: ");
            opcion = sc.nextInt();
            sc.nextLine();
//crear switch para seleccionar el menu 
        switch (opcion) {
            case 1:
                System.out.println("Ingrese el nombre del evento: ");
                    nombreEvento = sc.nextLine();
                System.out.println("Ingrese la hora del evento: ");
                    horaEvento = sc.nextInt(); 
                    sc.nextLine();
                //System.out.println("Ingrese la fecha del evento: ");
                    //fechaEvento = sc.nextLine();
               
               //envio de informacion al constructor de eventos en la clase de GestionEventos.
               GestionEventos actividad = new GestionEventos(nombreEvento, horaEvento);
               //creando un objeto que representara el dia que se estara utilizando.
               AgregarEventos agendaDia = new AgregarEventos();
               /*Llamando al metodo que asignara los valores del objeto actividad como parametro 
               para tener los valores y utilizarlos a fin de agregarlos en los espacios*/
               agendaDia.agregarEvento(actividad);
               //llamado al metodo para imprimir y mostrar los eventos del dia 
               agendaDia.mostrarAgenda();
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            default:
                
        }//end switch
        //MoisesBonilla Estuvo aqui 
    }
    
}

