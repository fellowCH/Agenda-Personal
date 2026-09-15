package agenda_personal;

import java.util.ArrayList;

public class AgregarEventos {
    //array que reprecenta el dia y almacenara los objetos, osea los eventos.
    //Aqui modifique el arraylist importanto el java util para mejorar la gestion.
    public ArrayList<GestionEventos>[] actividades = new ArrayList[24];
   
    //Creando el metodo que asignara eventos al horrario
    public AgregarEventos(){ // aqui lo actualice para que ya aceptara las 24 horas
        
        for (int i = 0; i < 24; i++){
            
            actividades[i] = new ArrayList<>();
            
        } // fin del for
        
    } // fin del agregareventos
    
    public void agregarEvento (GestionEventos actividad){ // funcion para agregar
        
        actividades[actividad.getHora()].add(actividad);
        
    }
    
    //Este metodo mostrara en pantalla toda el horario del dia.
    public void mostrarAgenda(){
        
        for (int hora = 0; hora < actividades.length; hora++) { 
            
            if(!actividades[hora].isEmpty()){ // aqui aproveche el extra que tiene el import para que verifique si la lista de esta hora no esta vacia. Por eso esta el ! y el isEmpty
                
                System.out.printf("%d:00 -\n", hora);
                
                for (GestionEventos ev : actividades[hora]){ //este es un bucle for each, lo que hace es que recorre todos los eventos guardados de esa hora. ev o evento es la variable temporal
                    
                    System.out.println("    ->  ");
                    ev.salidaEvento(); // aqui imprime el evento usando la variable ev
                }
                               
                
            } else {
                // el else ya es para que dicte que no hay ninguna actividad pendiente
                System.out.printf("%d:00 no hay actividades pendientes...\n", hora);
                
            }// fin del if
                
                
        } // fin de for
        
        
    }//end mostrar Agenda
}//end class