/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_u3;


import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Interfaz extends JFrame implements ActionListener,Runnable{
    Alerta obj= new Alerta();
    boolean activar;
    Thread hilo;
       JButton crono,saludo,sprite,fuego,agua;
    
     ImageIcon imacro= new ImageIcon("C:\\Users\\Acer\\Downloads\\crono1.png");
     ImageIcon imasalu= new ImageIcon("C:\\Users\\Acer\\Downloads\\saludo1.png");
     ImageIcon imaspr= new ImageIcon("C:\\Users\\Acer\\Downloads\\sprite.png");
     ImageIcon imafue= new ImageIcon("C:\\Users\\Acer\\Downloads\\fuego1.png");
     ImageIcon imaag= new ImageIcon("C:\\Users\\Acer\\Downloads\\agua.png");
    
    public Interfaz(){
        super("Interfaz");
            
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,700);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.CYAN);
        
        
        
        crono=new JButton(null,imacro);
        crono.setBounds(25,0,200,250);//x,y,ancho, alto
        crono.setBackground(Color.cyan);
        crono.setBorderPainted(false);
        
        saludo=new JButton(null,imasalu);
        saludo.setBounds(275,250,250,200);//x,y,ancho, alto
        saludo.setBackground(Color.cyan);
        saludo.setBorderPainted(false);
        
        sprite=new JButton(null,imaspr);
        sprite.setBounds(550,450,200,210);//x,y,ancho, alto
        sprite.setBackground(Color.cyan);
        sprite.setBorderPainted(false);
        
        fuego=new JButton(null,imafue);
        fuego.setBounds(650,20,100,130);//x,y,ancho, alto
        fuego.setBackground(Color.cyan);
        fuego.setBorderPainted(false);
        
        agua=new JButton(null,imaag);
        agua.setBounds(550,20,100,150);//x,y,ancho, alto
        agua.setBackground(Color.cyan);
        agua.setBorderPainted(false);
        agua.setVisible(false);
        
        this.add(crono);
        this.add(saludo);
        this.add(sprite);
        this.add(fuego);
        this.add(agua);
        
        crono.addActionListener(this);
        saludo.addActionListener(this);
        sprite.addActionListener(this);
        fuego.addActionListener(this);
        agua.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ev){
        
        //devuelve una referencia al objeto donde se genero el evento
       Object objeto=ev.getSource();
       if(objeto instanceof JButton){//si se pulso el boton

         if (objeto==crono){
             Crono obj=new Crono();
                
               }
         if(objeto==saludo){
             Skype obj= new Skype();
         }
         if(objeto==sprite){
             Sprite obj=new Sprite();
         }
         if(objeto==fuego){
             activar=true;
             hilo = new Thread(this);
             hilo.start();
             
             fuego.setVisible(false);
             agua.setVisible(true);
         }
         
         if(objeto==agua){
             activar=false;
             hilo.stop();
             agua.setVisible(false);
             fuego.setVisible(true);
         }
         }
        
        
             
         }
    
    public void run(){
        while(activar==true){
            
            obj.setVisible(true);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            obj.setVisible(false);
                        try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    public static void main(String[] args) {
        Interfaz obj1=new Interfaz();
    }
             
    
}
      
    

