
package proyecto_u3;


import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Skype extends JFrame implements ActionListener {
    
    JLabel conver;
    JLabel skype,llamada;
    JLabel profe,alum1,alum2,alum3;
    
    public static JTextArea con;
    
    JButton iniciar;
    
    ImageIcon imask= new ImageIcon("C:\\Users\\Acer\\Downloads\\skype1.png");
    ImageIcon imalla= new ImageIcon("C:\\Users\\Acer\\Downloads\\call.png");
    
        Aviso avisar=new Aviso();
        HiloRun Alum1=new HiloRun("Edwin Kato",false,avisar);
        HiloRun Alum2=new HiloRun("Crhistian Badillo",false,avisar);
        HiloRun Alum3=new HiloRun("Eliud Ayala",false,avisar);
        HiloRun Maestro=new HiloRun("Anibal Saucedo",true,avisar);
    
    public Skype(){
        super("Skype");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(900,750);
        this.setLocationRelativeTo(null);
        //no utilizar layout por default
        this.setLayout(null);
        //No redimension
        this.setResizable(false);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        skype=new JLabel(imask);
        skype.setBounds(302,0,305,150);//x,y,ancho, alto
        
        llamada=new JLabel(imalla);
        llamada.setBounds(300,675,300,50);//x,y,ancho, alto
        llamada.setVisible(false);

        
        profe=new JLabel("");
        profe.setBounds(325,150,250,250);//x,y,ancho, alto
        profe.setFont(new Font("arial",Font.PLAIN,30));
        profe.setForeground(Color.WHITE);
        profe.setBackground(Color.DARK_GRAY);
        profe.setOpaque(true);
        profe.setBorder(BorderFactory.createLineBorder(Color.black));
        profe.setVisible(false);
        profe.setHorizontalAlignment(JLabel.CENTER);
        
        
        conver=new JLabel("Conversación");
        conver.setBounds(90,200,150,50);//x,y,ancho, alto
        conver.setFont(new Font("arial",Font.PLAIN,20));
        conver.setVisible(false);
        
        con=new JTextArea();
        con.setBounds(0,250,320,50);//x,y,ancho, alto
        con.setBackground(Color.WHITE);
        con.setOpaque(true);
        con.setBorder(BorderFactory.createLineBorder(Color.black));
        con.setVisible(false);
        con.setEditable(false);
        con.setWrapStyleWord(true);
        
        
        alum1=new JLabel("");
        alum1.setBounds(50,420,250,250);//x,y,ancho, alto
        alum1.setFont(new Font("arial",Font.PLAIN,30));
        alum1.setBackground(Color.DARK_GRAY);
        alum1.setForeground(Color.WHITE);
        alum1.setOpaque(true);
        alum1.setBorder(BorderFactory.createLineBorder(Color.black));
        alum1.setVisible(false);
        alum1.setHorizontalAlignment(JLabel.CENTER);
        
        alum2=new JLabel("");
        alum2.setBounds(325,420,250,250);//x,y,ancho, alto
        alum2.setFont(new Font("arial",Font.PLAIN,30));
        alum2.setForeground(Color.WHITE);
        alum2.setBackground(Color.DARK_GRAY);
        alum2.setOpaque(true);
        alum2.setBorder(BorderFactory.createLineBorder(Color.black));
        alum2.setVisible(false);
        alum2.setHorizontalAlignment(JLabel.CENTER);
        
        alum3=new JLabel("");
        alum3.setBounds(600,420,250,250);//x,y,ancho, alto
        alum3.setFont(new Font("arial",Font.PLAIN,30));
        alum3.setBackground(Color.DARK_GRAY);
        alum3.setForeground(Color.WHITE);
        alum3.setOpaque(true);
        alum3.setBorder(BorderFactory.createLineBorder(Color.black));
        alum3.setVisible(false);
        alum3.setHorizontalAlignment(JLabel.CENTER);
        
        iniciar= new JButton("Iniciar llamada");
        iniciar.setBounds(350,350,200,50);
        iniciar.setFont(new Font("arial",Font.PLAIN,20));
        iniciar.setBackground(Color.WHITE);
        
        
        this.add(skype);
        this.add(profe);
        this.add(alum1);
        this.add(alum2);
        this.add(alum3);
        this.add(llamada);
        this.add(iniciar);
        this.add(con);
        this.add(conver);
        
        iniciar.addActionListener(this);
        

        


    }
    
      public void actionPerformed(ActionEvent ev){
      Object objeto=ev.getSource();
      
      if(objeto==iniciar){         
        
        Alum1.start();
        Alum2.start();
        Alum3.start();
        Maestro.start();
          
        llamada.setVisible(true);
        profe.setVisible(true);
        alum1.setVisible(true);
        alum2.setVisible(true);
        alum3.setVisible(true);
        iniciar.setVisible(false);
        con.setVisible(true);
        conver.setVisible(true);
        
        
        
        profe.setText(Maestro.nombre_hilo);
        alum1.setText(Alum1.nombre_hilo);
        alum2.setText(Alum2.nombre_hilo);
        alum3.setText(Alum3.nombre_hilo);
        
        
        
      }
  }
      
      
      
    
    public static void main(String[] args) {
        Skype obj= new Skype();
    }
}
