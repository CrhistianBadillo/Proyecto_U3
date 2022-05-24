/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_u3;

/**
 *
 * @author Acer
 */
public class Hilo implements Runnable {
    public Thread hilo;
    String n_hilo;
    
    
    Hilo (String nombrehilo) {
	hilo = new Thread (this, nombrehilo);
	n_hilo = nombrehilo; //almacena el nombre del hilo
	System.out.println ("Comienza " + hilo.getName ()
		 + " Iniciando");
	hilo.start ();
    }
    
     public void run ()
    {
	try
	{
	    if (n_hilo == "Sub_PROCESO1")
	    {

		Thread.sleep (0);
                intBarra obj= new intBarra();

	    }
	    if (n_hilo == "Sub_PROCESO2")
	    {

		Thread.sleep (20000);
		Interfaz obj= new Interfaz();
	    }

	}
	catch (InterruptedException exc)
	{
	    System.out.println ("Interrupcion en hilo " + hilo.getName ());
	}
    }
     
     
}
