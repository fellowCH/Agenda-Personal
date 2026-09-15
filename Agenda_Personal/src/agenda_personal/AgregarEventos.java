package agenda_personal;
/**
 *
 * @author bonil
 */
public class AgregarEventos {
    //array que reprecenta el dia y almacenara los objetos, osea los eventos
    public GestionEventos[] actividades = new GestionEventos[24]; 
   
    //Creando el metodo que asignara eventos al horrario
    public void agregarEvento(GestionEventos actividad){
        /*La idea es utilizar la hora obtenida en el GestionEventos 
        para colocar el elemento en el mismo lugar dentro del arreglo*/
        actividades[actividad.getHora()] = actividad;
    }//end GestionEventos
    
    //Este metodo mostrara en pantalla toda el horario del dia.
    public void mostrarAgenda(){
        //for imprimira en pantalla el contenido del arreglo osea toda la agenda
        for (int hora = 0; hora < actividades.length; hora++){
            //el if esta disenado para identificar los espacios diferentes a null osea los indices que si esten llenos 
            if (actividades[hora] != null){
                System.out.printf("%d:00 - ", hora);
                /*se hace referencia al objeto gaurdado en el espacio indicado por el indice 
                y el metodo en la clase gestion eventos lo imrpime*/
                actividades[hora].salidaEvento();
            }//end if
            //este else controlara que aparezca null, se vera mas estetico
            else{
                System.out.printf("%d:00 - Sin actiivdad.\n", hora);
                }//end else
        }//end for
    }//end mostrar Agenda
}//end class