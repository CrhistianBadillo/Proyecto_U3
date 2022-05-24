/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_u3;

import static proyecto_u3.Skype.*;

public class Aviso {
    boolean bandera=false;
    String dato="";
    public Aviso(){
        
    }
    
    //Se hace wait(espera) del hilo que esta corriendo y se bloquea
    public synchronized void saludoEspera(String nombre_hilo){
        try{
            if(bandera == false){
                wait();
            }
            Thread.sleep(5000);
            dato=(nombre_hilo+" esta escribiendo....\n"
                    +nombre_hilo+": Perfecto profe, ahorita se la enviamos.\n");
            System.out.println(dato);
            con.setText(dato);
           
        }catch(InterruptedException ex){
            System.out.println("Algo anda mal");
        }
    }
    //El notify activa a todos los hilos que estan esperando
    public synchronized void saludoNotifica(String nombre_hilo){
        bandera=true;
         
        
        dato+=(nombre_hilo+": Buenos dias les encargó \n"
                + "hacer esta practica.\n");
         System.out.println(dato);
            con.setText(dato);
        notifyAll();
    }
}
