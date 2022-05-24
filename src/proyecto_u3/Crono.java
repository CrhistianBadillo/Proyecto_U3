
package proyecto_u3;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Crono extends JFrame implements Runnable,ActionListener{
   
    JLabel tit,tiempo, reloj;
    JButton iniciar,pausar,reiniciar;
    
    ImageIcon imacro1= new ImageIcon("C:\\Users\\Acer\\Downloads\\pausa.png");
    ImageIcon imacro2= new ImageIcon("C:\\Users\\Acer\\Downloads\\pausa2.png");
    
    
    int minutos=0,segundos=0, milesimas=0;
    String min="",seg="", mil="";
    Thread hilo;
    boolean cronoAct,cronoPau;
    
    public Crono(){
    super("Cronómetro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600,600);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        getContentPane().setBackground(Color.CYAN);
        
        tit=new JLabel("Cronómetro");
        tit.setBounds(75,10,450,100);//x,y,ancho, alto
        tit.setFont(new Font("bodoni mt black",Font.PLAIN,70));
        
        tiempo=new JLabel("00:00:000");
        tiempo.setBounds(160,150,300,100);//x,y,ancho, alto
        tiempo.setFont(new Font("bodoni mt black",Font.PLAIN,50));
        tiempo.setHorizontalAlignment(JLabel.CENTER);
        
        iniciar=new JButton("Iniciar");
        iniciar.setBounds(25,300,150,50);//x,y,ancho, alto
        iniciar.setFont(new Font("bodoni mt black",Font.PLAIN,30));
        iniciar.setBackground(Color.cyan);
        iniciar.setBorderPainted(false);
        
        reiniciar=new JButton("Reiniciar");
        reiniciar.setBounds(200,300,200,50);//x,y,ancho, alto
        reiniciar.setFont(new Font("bodoni mt black",Font.PLAIN,30));
        reiniciar.setBackground(Color.cyan);
        reiniciar.setBorderPainted(false);
        
        pausar=new JButton("Pausar");
        pausar.setBounds(425,300,150,50);//x,y,ancho, alto
        pausar.setFont(new Font("bodoni mt black",Font.PLAIN,30));
        pausar.setBackground(Color.cyan);
        pausar.setBorderPainted(false);
        
        reloj=new JLabel(imacro1);
        reloj.setBounds(225,375,150,150);//x,y,ancho, alto
        
        

        
        
        this.add(tit);
        this.add(tiempo);
        this.add(iniciar);
        this.add(pausar);
        this.add(reiniciar);
        this.add(reloj);
        
        iniciar.addActionListener(this);
        pausar.addActionListener(this);
        reiniciar.addActionListener(this);
        
        
}
    
    
    
    
    public void run(){
      while(cronoAct==true & cronoPau==false){

              milesimas+=1;
                        try {
              Thread.sleep(1);
          } catch (InterruptedException ex) {
              Logger.getLogger(Crono.class.getName()).log(Level.SEVERE, null, ex);
          }
              if(milesimas==1000){
                  milesimas=0;
                  segundos+=1;
                  
                  if(segundos==60){
                      segundos=0;
                      minutos++;
                  }
              }
              
              
           if(milesimas<10){
               mil="00"+milesimas;
              // mil=Integer.toString(milesimas);
           }else if(milesimas<100){
               mil="0"+milesimas;
              // mil=Integer.toString(milesimas);
           }else mil=Integer.toString(milesimas);
           
           
           if(segundos<10){
               seg=Integer.toString(segundos);
               seg="0"+seg;
           }else if(segundos>=10){
               seg=Integer.toString(segundos);
           }
           
           if(minutos<10){
               min="0"+minutos;
               min=Integer.toString(minutos);
           }
           
           tiempo.setText(min+":"+seg+":"+ mil);
      }
}
    
    public void actionPerformed(ActionEvent ev){
             Object objeto=ev.getSource();
       if(objeto instanceof JButton){//si se pulso el boton

         if (objeto==iniciar){
                iniciarCrono();
                reloj.setIcon(null);
                reloj.setIcon(imacro2);
               }
         if(objeto==pausar){
                pausarCrono();
                reloj.setIcon(null);
                reloj.setIcon(imacro1);
                iniciar.setText("");
                iniciar.setText("Seguir");
         }
         if(objeto==reiniciar){
             reiniciarCrono();
             tiempo.setText("00:00:000");
             reloj.setIcon(null);
             reloj.setIcon(imacro1);
             iniciar.setText("");
             iniciar.setText("Iniciar");
         }

         }
    }
    
 public void iniciarCrono(){
     cronoAct=true;
     cronoPau=false;
     hilo = new Thread(this);
     hilo.start();
 }    
 
 public void pausarCrono(){
     cronoAct=false;
     cronoPau=true;
     hilo.stop();

 }
 
 public void reiniciarCrono(){
     cronoAct=false;
     cronoPau=false;
     hilo.stop();
     minutos=0;
     segundos=0;
     milesimas=0;
 }

}

