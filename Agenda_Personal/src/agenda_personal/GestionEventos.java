package agenda_personal;
/**
 *
 * @author bonil
 */
public class GestionEventos {
    //varables que contendran los siguientes datos de la tarea nombre, hora, fecha.
    private String nombreEvento;
    public int horaEvento;
    //constructor para las tareas
    public GestionEventos (String nombreEvento, int horaEvento){
        this.nombreEvento = nombreEvento;
        this.horaEvento = horaEvento;
    }//end constructor 
    
    public void salidaEvento(){
        System.out.printf("%S\n", nombreEvento);
    }//end metodo Evento
    
    
    public int getHora(){
       return horaEvento;
    }//end metodo hora
    }//en to String
//}//end class
