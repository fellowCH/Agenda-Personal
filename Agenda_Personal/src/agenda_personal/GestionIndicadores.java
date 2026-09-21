
package agenda_personal;

import java.util.ArrayList;

/**
 *
 * @author bonil
 */
public class GestionIndicadores {
    //Arreglo para guardar los indicadores con maximo de 4 por dia 
   private ArrayList<Indicador> indicadores = new ArrayList<>(); //arreglo que guardara los indicadores
   
    //guardar los indicardores en el array 
    public boolean GuardarIndicador (Indicador nuevoIndicador){//gaurdara los indicadores en el arreglo y avisara caudo los eventos se allan guardado. 
        if (indicadores.size()< 4) {
            indicadores.add(nuevoIndicador); 
            return true;
        }//end if
        else{
            return false;
        }//end else
    }//end Guardar 
    
public void visualizarProgreso(){// mostrara la meta y el progreso de la misma. Tambien se indica cuando la lista esta vasia. 
    if (indicadores.isEmpty()) {
        System.out.println("Aun no hay indicadores creados");   
    }//end if
    else{
        for (Indicador ind: indicadores) {
            System.out.println("-----------");
            System.out.printf("Indicador: %s\n", ind.getNombreIndicador());
            System.out.printf("Porogreso: %d/%d\n", ind.getProgresoIndicador(), ind.getMetaIndicador());
            if (ind.metaAlcanzada()){
                System.out.println("Meta Alcanzada!");
            }//end if
            System.out.println("-----------");
        }//end foreach 
    }//end else
}//end visualizarProgreso   

public boolean hayIndicadores(){//si ya se creo un indicador no mostrara uan lista vacia
    return !indicadores.isEmpty();
}//end hayIndicadores

public void listarIndicadores(){//muestra los indicadores numerados y se arregla para que sea desde 1 y no 0 
    for (int i = 0; i < indicadores.size(); i++){
        Indicador ind = indicadores.get(i);
        System.out.printf("%d. %s (%d/%d)\n", i+1, ind.getNombreIndicador(), ind.getProgresoIndicador(), ind.getMetaIndicador());
}//end for
}//end listarIndicador

public Indicador obtener (int posicion){//da los indicadores de una posicion, si no hay en esa posicion, da null en lugar de detenerce.
    if(posicion >= 0 && posicion < indicadores.size()){
        return indicadores.get(posicion);
    }//end if
    else{
        return null;
    }//end else
}//end obtener
    
}//end class
