package agenda_personal;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bonil
 */
public class AgregarEventos {
    int indicadorHora = 0;
    int indice = 0;
    //Array que almacena los objetos osea los eventos
    public evento[] actividades = new evento[24]; 
   
    //Creando el arrego que guardara los eventos de un dia.
    public void agregarEvento(evento actividad){
        actividades[actividad.getHora()] = actividad;
    }//end evento
    

//for imprimira en pantalla el contenido del arreglo
    public void mostrarAgenda(){
    for (int hora = 0; hora < actividades.length; hora++){
     if (actividades[hora] == null){
         System.out.println(hora+":00 - Sin actiivdad.");
     }
     else{
         System.out.println(hora+":00 - "+actividades[hora]);}//end else
}//end for
    }//end mostrar Agenda
}//end class