package agenda_personal;
/**
 *
 * @author bonil
 */
public class evento {
    //varables que contendran los siguientes datos de la tarea nombre, hora, fecha.
    private String nombreEvento;
    private String fechaEvento;
    private int horaEvento;
    
    //constructor para las tareas
    
    public evento (String nombreEvento, String fechaEvento, int horaEvento){
        this.nombreEvento = nombreEvento;
        this.fechaEvento = fechaEvento;
        this.horaEvento = horaEvento;
    }//end constructor 
    
    public void Evento(){
        System.out.println(nombreEvento);
        System.out.println(horaEvento);
        System.out.println(fechaEvento);    
    }//end metodo evento
    
    //COnvertira todo a string para ser impreso
    public String toString(){
        return "Nombre: " + nombreEvento + "Fecha: " + fechaEvento + ", hora evento: " + horaEvento;
    
    }//en to String
    public int getHora(){
       return horaEvento;
    }//end metodo hora
}//end class
