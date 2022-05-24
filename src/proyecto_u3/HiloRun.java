package proyecto_u3;

import javax.swing.*;

public class HiloRun extends Thread{
    String nombre_hilo;
    Aviso avisar;
    boolean bandera;
    
    public HiloRun(String nombre_hilo, boolean bandera , Aviso avisar){
        this.nombre_hilo=nombre_hilo;
        this.avisar=avisar;
        this.bandera=bandera;
    }
    
    
    @Override
    public void run(){
             
           JOptionPane.showMessageDialog(null, "Se ha unido a la videollamada "+nombre_hilo);
        try{
            Thread.sleep(1000);
            
            //Para saber cual hilo llego con el booleano
            if(bandera){
                avisar.saludoNotifica(nombre_hilo);
                
            }else{
                avisar.saludoEspera(nombre_hilo);
            }
        }catch(InterruptedException ex){
            System.out.println("Algo anda mal");
        }
    }
}
