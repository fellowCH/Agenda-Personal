/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecosistema_smart_home;

/**
 *
 * @author bonil
 */
public class FocoInteligente extends Dispositivo implements Conexiones{
    
    public FocoInteligente(String marca){
        super(marca);
    }//end constructor 
    
    @Override 
    void encender (){
        System.out.println("Foco encendido al 100%");
    }
    
    @Override
    public void conectarRed(){
         System.out.println("Conectando al router via WIFI ");
    }
   
    
}//End class focoInteligente
