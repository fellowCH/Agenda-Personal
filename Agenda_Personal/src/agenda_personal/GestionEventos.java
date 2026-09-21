package agenda_personal;
/**
 *
 * @author bonil
 */
public class GestionEventos {
    //varables que contendran los siguientes datos de la tarea nombre, hora, fecha.
    private String nombreEvento;
    public int horaEvento;
    private Indicador indicador;
    private boolean completado; 
    
    //constructor con dos datos: Sin indicador 
    public GestionEventos (String nombreEvento, int horaEvento){
        this.nombreEvento = nombreEvento;
        this.horaEvento = horaEvento;
        this.indicador = null;
        this.completado = false;
    }//end constructor 
    
    //constructor con dos datos: Con indicador 
    public GestionEventos (String nombreEvento, int horaEvento, Indicador indicador){
        this.nombreEvento = nombreEvento;
        this.horaEvento = horaEvento;
        this.indicador = indicador;
        this.completado = false;
    }//end constructor 
    
    public void salidaEvento() {
        //se representan las casillas de comletado y no comletado
        if (completado) {
            System.out.print("[X] ");
        }//en if
        else {
            System.out.print("[ ] ");
        }//end else

        System.out.print(nombreEvento);

        if (indicador != null) {
            System.out.print(" (Indicador: " + indicador.getNombreIndicador() + ")");
        }//end if
        System.out.println();
    }//end salidaEvento
    
    
    public int getHora(){
       return horaEvento;
    }//end metodo hora

    public void marcarCompletado(boolean nuevoEstado){
        if ( nuevoEstado != completado) {//esta condicion asegura que hace algo si el estado cambia. evita errores de incrementos por marcar un evento como completado dos veces
            completado = nuevoEstado;
        }//end if
          if (indicador != null) {// solo toca el idicador si el evento tiene uno.
              //incrementar o decrementar utilizanddo los emtodos de GestionIndicadores si el estado quedo comletado.
              if(completado){
                  indicador.incrementarIndicador();
              }//end if
              else{
                  indicador.decrementarIndicador();
              }//end else
          }//end if
    }//end marcarCompletado
    
    public Indicador getIndicador(){
        return indicador;
    }//getIndicador
    public boolean isCompletado(){
        return completado;
    }//end isCompletado
    public void setNombre(String nuevoNombre){//nuevo nombre no se puede cambair sin set 
    nombreEvento = nuevoNombre;
    }
}//end class
