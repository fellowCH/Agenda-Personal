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
                
                System.out.printf("%d:00 ****Eventos para esta hora****\n", hora);
                
                for (GestionEventos ev : actividades[hora]){ //este es un bucle for each, lo que hace es que recorre todos los eventos guardados de esa hora. ev o evento es la variable temporal
                    
                    System.out.print("\t---> ");
                    ev.salidaEvento(); // aqui imprime el evento usando la variable ev 
                }
                               
                
            } else {
                // el else ya es para que dicte que no hay ninguna actividad pendiente
                System.out.printf("%d:00 no hay actividades pendientes...\n", hora);
                
            }// fin del if
                
                
        } // fin de for
              
    }//end mostrar Agenda
    
    public void eliminarEvento(int hora, int indice){ //las variables hora e indice funcionan para cuando vayamos a ingresar los datos que pide desde el main
    
        actividades[hora].remove(indice); 
    
    } //fin de eliminar evento
    
    public void mostrarEventosPorHora(int hora) { // este funciona ara motrar que eventos hay por cada hora sin necesidad de llamar al evento mostraragenda.

        for (int i = 0; i < actividades[hora].size(); i++) {  //aqui toma la array actividades y mediante la variable y el numero que se ingrese buscara todas las coincidencias con esa hora
            System.out.print(i + ". ");  
            actividades[hora].get(i).salidaEvento();
        } //fin del if
    } //fin de mostrar eventos por hora
    
    public void editarEvento(int hora, int indice, String nombreEvento){ 
        
        GestionEventos actividad = new GestionEventos(nombreEvento, hora); 
        actividades[hora].set(indice, actividad); //aqui tomamos la misma formula que en agregar pero cambiando por un set en lugar de un add
        
    } // fin de editarEvento
    
}//end class