/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenda_personal;

import java.util.ArrayList;

/**
 *
 * @author bonil
 */
public class Indicadores {
   //para los datos del indicador 
   private String nombreIndicador;
   private int metaIndicador;
   //Arreglo para guardar los indicadores con maximo de 4 por dia 
   private ArrayList<Indicadores> guardarIndicadores;// = new ArrayList<>();
   
  //Constructor que tendra la lista ArrayList
    public Indicadores (){
        guardarIndicadores = new ArrayList<>();
    }
    
  //constructor de objetos que guardaran especificaciones de las metas
    public Indicadores (String nombreIndicador, int metaIndicador){
     this.nombreIndicador = nombreIndicador;
     this.metaIndicador = metaIndicador;
    }//end constructor 

    //guardar los indicardores en el array 
    public void GuardarIndicadores (Indicadores nuevoIndicador){
        if (guardarIndicadores.size()< 4) {
            guardarIndicadores.add(nuevoIndicador); 
        }//end if
        else{
        
        }//end else
    }//end Guardar 
   
     public void VisualizarProgreso(){
         for(Indicadores indicador:guardarIndicadores){
            System.out.println("---------------");
            System.out.printf("Indicador: %s\n",indicador.nombreIndicador);
            System.out.printf("Meta: %d\n",indicador.metaIndicador);
            System.out.println("---------------");
         }//end Visualizar progreso
     }
    
}//end class
