
package ecosistema_smart_home;

/**
 *
 * @author bonil
 */
public abstract class Dispositivo {
    String marca;
   
    public Dispositivo (String marca){
        this.marca= marca;
    }//end constructor dispositivo
    
    //metodos 
    abstract void encender();
    
    public void MostrarMarca(){
        System.out.println("Marca: "+this.marca);
    }
    
}//Fin abstract class dispositivo
