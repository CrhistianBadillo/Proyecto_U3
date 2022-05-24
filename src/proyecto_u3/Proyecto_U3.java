
package proyecto_u3;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Proyecto_U3 {

    public static void main(String[] args) {
      
        Hilo obj = new Hilo ("Sub_PROCESO1");
	Hilo ob2 = new Hilo ("Sub_PROCESO2");
        
        	try
	{
	    obj.hilo.join ();
	    ob2.hilo.join ();

	}
	catch (InterruptedException e)
	{
	    System.out.println ("Interrupcion en el main");
	}

	System.out.println ("Termina main");
    }
    
}
