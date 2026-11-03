/*
Una startup tecnologica que esta desarrolando un controlador central para hogareas inteligentes.
El equipo de ingenier[ia de software necesita dise;ar una arquitectura modular en java que permita 
integrar difetenes tipos de hardware (focos, cerraduras, sensores) de multiples marcas.

El sistema debe ser escalable:
agregar un nuevo tipo de dispoitivo enel futuro no debe requerir reescribir la ligic acentral del controlador.
 */
package ecosistema_smart_home;

public class Ecosistema_Smart_Home {

    public static void main(String[] args) {
        //Dispositivo Foco = new Dispositivo("phillips");
        Dispositivo miCasa[] = { new FocoInteligente ("phillips"),
                               new CerraduraInteligente("Yale") };
       
            
       
        miCasa[0].encender();
        miCasa[0].MostrarMarca();
        ((Conexiones)miCasa[0]).conectarRed();
        
        System.out.println("--------------------");
           miCasa[1].encender();
        miCasa[1].MostrarMarca();
        ((Conexiones)miCasa[1]).conectarRed();
    }//end main
    
}//end class
