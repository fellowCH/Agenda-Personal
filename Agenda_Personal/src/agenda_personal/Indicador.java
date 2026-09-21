
package agenda_personal;

/**
 *
 * @author bonil
 */
public class Indicador {
   private String nombreIndicador;
   private int metaIndicador;
   private int progresoIndicador;
   
   //constructor de objetos que guardaran especificaciones de las metas
    public Indicador(String nombreIndicador, int metaIndicador){
     this.nombreIndicador = nombreIndicador;
     this.metaIndicador = metaIndicador;
     this.progresoIndicador = 0;
    }//end constructor 
    
    public void incrementarIndicador(){
        progresoIndicador++;
    }//end incrementarIndicador
    
    public void decrementarIndicador(){//control de error para que el decremento nunca sea -1
        if (progresoIndicador >= 0){
            progresoIndicador--;  
        }//end if
    }//end decrementarIndicador 
    
    public boolean metaAlcanzada(){
        return progresoIndicador >= metaIndicador;
    }//end metaAlcanzada
    
    //los get serviran para obtener el valor de las variables que estan en privado en esta clase. 
    public String getNombreIndicador(){
        return nombreIndicador;
    }//end getNombre
    
    public int getMetaIndicador(){
        return metaIndicador;
    }//end getMeta
    
    public int getProgresoIndicador(){
        return progresoIndicador;
    }//end getProgreso
}//end class
