/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prac4;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author b201
 */
public class Login extends JPanel{
    
    CardLayout cn;
    Container cr;
    JLabel lb1,lb2;
   public static JTextField userName;
   public static JPasswordField password;
    public static JButton jb;
    public Login(CardLayout cn, Container cr)
    {
       
        this.cn=cn;
        this.cr=cr;
        lb1=new JLabel("Enter UserName");
        userName=new JTextField();
        lb2=new JLabel("Enter Password");
        password=new JPasswordField();
        password.setEchoChar('*');
        jb=new JButton("Login");
        
        setLayout(new GridLayout(3,2));
        add(lb1);
        add(userName);
        add(lb2);
        add(password);
        add(jb);
        
        
        
    }
    
}
