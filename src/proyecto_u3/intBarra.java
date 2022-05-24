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

public class intBarra extends JFrame implements ActionListener, Runnable {
    
    JLabel tit,progreso;
    JProgressBar p;
    
    JButton btn;

        
  public intBarra(){
        super("Inicio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        getContentPane().setBackground(Color.CYAN);
        
        tit=new JLabel("Bienvenido");
        tit.setBounds(40,50,420,100);//x,y,ancho, alto
        tit.setFont(new Font("bodoni mt black",Font.PLAIN,70));
        
        btn= new JButton("Comenzar");
        btn.setBounds(200,200,100,30);
        btn.setBackground(Color.LIGHT_GRAY);
        
       p= new JProgressBar(0,100);
       p.setBounds(100,300,300,40);
       p.setStringPainted(true);
       //p.setBackground(Color.BLACK);


       
        this.add(tit);
        this.add(p);
        this.add(btn);
        
        btn.addActionListener(this);
        
  }
  
  public void actionPerformed(ActionEvent ev){
      Object objeto=ev.getSource();
      
      if(objeto==btn){
          inicio();
      }
  }
  public void run() {
                p.setStringPainted(true);
                int x = 1;

                while(x <= 100){
                    p.setValue(x);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                    x++;
                }
                JOptionPane.showMessageDialog(null,"          A terminado el tiempo de carga.\nA continuacion se le mostrara la ventana");
            }
  
  private void inicio(){
        Thread t;
        t = new Thread(this);
        t.start();
    }
  
    
}
