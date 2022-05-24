
package proyecto_u3;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Sprite extends JFrame implements ActionListener, Runnable{
    
    Thread hilo;
    JLabel sprite,tit;
    JButton accionar,pausar;
    boolean accion,pausa;
    
    ImageIcon imasp1= new ImageIcon("C:\\Users\\Acer\\Downloads\\sp1.png");
    ImageIcon imasp2= new ImageIcon("C:\\Users\\Acer\\Downloads\\sp2.png");
    ImageIcon imasp3= new ImageIcon("C:\\Users\\Acer\\Downloads\\sp3.png");
    ImageIcon imasp4= new ImageIcon("C:\\Users\\Acer\\Downloads\\sp4.png");
    ImageIcon imasp5= new ImageIcon("C:\\Users\\Acer\\Downloads\\sp5.png");
    ImageIcon imasp6= new ImageIcon("C:\\Users\\Acer\\Downloads\\sp6.png");
    
    public Sprite(){
        super("Sprite");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000,500);
        this.setLocationRelativeTo(null);
        //no utilizar layout por default
        this.setLayout(null);
        //No redimension
        this.setResizable(false);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.CYAN);
        
        tit=new JLabel("Sprite");
        tit.setBounds(325,10,250,70);//x,y,ancho, alto
        tit.setFont(new Font("bodoni mt black",Font.PLAIN,70));
        
        accionar=new JButton("Acción");
        accionar.setBounds(360,100,150,50);//x,y,ancho, alto
        accionar.setFont(new Font("bodoni mt black",Font.PLAIN,30));
        accionar.setBackground(Color.CYAN);
        accionar.setBorderPainted(false);
        
        pausar=new JButton("Pausar");
        pausar.setBounds(360,150,150,50);//x,y,ancho, alto
        pausar.setFont(new Font("bodoni mt black",Font.PLAIN,30));
        pausar.setBackground(Color.CYAN);
        pausar.setBorderPainted(false);
        
        sprite=new JLabel();

        


        
        this.add(tit);
        this.add(accionar);
        this.add(sprite);
        this.add(pausar);
        
        accionar.addActionListener(this);
        pausar.addActionListener(this);
    }
    
    public void run(){
        while(accion==true && pausa==false){
             
            sprite.setIcon(imasp5);
            sprite.setBounds(20,250,150,200);//x,y,ancho, alto
            
             try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sprite.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            sprite.setIcon(null);
            sprite.setIcon(imasp6);
            sprite.setBounds(180,250,150,200);
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sprite.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            sprite.setIcon(null);
            sprite.setIcon(imasp1);
            sprite.setBounds(340,250,150,200);
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sprite.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            sprite.setIcon(null);
            sprite.setIcon(imasp2);
            sprite.setBounds(500,250,150,200);
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sprite.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            sprite.setIcon(null);
            sprite.setIcon(imasp3);
            sprite.setBounds(660,250,150,200);
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sprite.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            sprite.setIcon(null);
            sprite.setIcon(imasp4);
            sprite.setBounds(820,250,150,200);
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sprite.class.getName()).log(Level.SEVERE, null, ex);
            }
            
//            sprite.setIcon(null);
//            sprite.setIcon(imasp5);
//            sprite.setBounds(20,250,150,200);
            
        }
        
        
    }
    
    public void actionPerformed(ActionEvent ev){
                   Object objeto=ev.getSource();
       if(objeto instanceof JButton){//si se pulso el boton

         if (objeto==accionar){
                accion();
               }
         if(objeto==pausar){
             pausar();
         }
    }
    }
    
    public void accion(){
     accion=true;
     pausa=false;
     hilo = new Thread(this);
     hilo.start();
    }
    
    public void pausar(){
        accion=false;
        pausa=true;
        hilo.stop();
    }
    
    public static void main(String[] args) {
        Sprite obj=new Sprite();
    }
}
