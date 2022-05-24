/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_u3;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Alerta extends JFrame {
    
    JLabel fuego;
    
    public Alerta(){
        super("Interfaz");
            
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,300);
        this.setLocationRelativeTo(null);
        //no utilizar layout por default
        this.setLayout(null);
        //No redimension
        this.setResizable(false);
        this.setVisible(false);
        this.getContentPane().setBackground(Color.RED);
        
        fuego=new JLabel("FUEGO !!!!!!");
        fuego.setBounds(50,75,450,100);//x,y,ancho, alto
        fuego.setFont(new Font("arial",Font.PLAIN,70));
        fuego.setForeground(Color.YELLOW);
        
        this.add(fuego);
    }
    
    
    public static void main(String[] args) {
        Alerta obj= new Alerta();
    }
}
