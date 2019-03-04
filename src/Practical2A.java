/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author b201
 */
public class Practical2A implements ActionListener{

    /**
     * @param args the command line arguments
     */
    int i = 0;
         JFrame f;
         JButton jb1;
         JButton jb2;
         JButton jb3;
         JButton jb4;
         JLabel lb;
    public Practical2A() {

        f = new JFrame("This is Frame");
         jb1 = new JButton("Click Me");
        jb1.setBounds(10, 20, 30, 30);
       jb1.addActionListener((ActionListener) this);
        jb2 = new JButton("Not Click Me");
        jb2.addActionListener((ActionListener) this);
         jb3 = new JButton("Not Click Me");
         jb3.addActionListener((ActionListener) this);
         jb4 = new JButton("Not Click Me");
         jb4.addActionListener((ActionListener) this);
         lb = new JLabel("Info");
        f.add(jb1);
        f.add(jb2);
        f.add(jb3);
        f.add(jb4);
        f.setLayout(new FlowLayout());
        f.setVisible(true);
        f.setSize(400, 400);
        

    }

    public static void main(String[] args) {
                
        new Practical2A();
        // TODO code application logic here
    }

    public void actionPerformed(ActionEvent e) {

       
        
     if(jb1.getText() =="Click Me")
     {
         Check(jb1,1);
         
     }
     else if(jb2.getText() =="Click Me")
     {
         Check(jb2,2);
     }
     else if(jb3.getText() =="Click Me")
     {
         Check(jb4,3);
     }
     else if(jb4.getText() =="Click Me")
     {
         Check(jb4,4);
     }

       
    } 
    
    public void Check(JButton j,int num)
    {
        
         boolean flag=false;
        Random rm=new Random();
        int n=rm.nextInt(4)+1;
        if(num==n)
        {
            lb.setText("Click Again");
             System.out.println(n);
        }
        else
        {
        System.out.println(n);
        
        i++;
         lb.setText("Good Job");
        switch(n)
        {
            case 1:
                        jb1.setText("Click Me");
                        System.out.println("Jb1 Done");
                        break;
            case 2:
                        jb2.setText("Click Me");
                        System.out.println("Jb2 Done");
                        break;
            case 3:
                        jb3.setText("Click Me");
                        System.out.println("Jb3 Done");
                        break;
            case 4:
                        jb4.setText("Click Me");
                        System.out.println("Jb4 Done");
                        break;
        }
        j.setText("Not Click Me");
        }
         
    }

}


