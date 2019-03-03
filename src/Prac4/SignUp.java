    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package Prac4;

 

    import javax.swing.*;
    import java.awt.*;


    public class SignUp extends JPanel{

        CardLayout cn;
        Container cr;
       public static JRadioButton b1,b2;
       public static ButtonGroup bg;
        JLabel firstName,lastName,email,password,erNumber,age,gender,none;
        public static JTextField FirstName,LastName,Email,ErNumber,Age,Gender;
        public static JPasswordField Password;
        public static JButton jb;
        
        
        public SignUp(CardLayout cn, Container cr)
        {


            this.cn=cn;
            this.cr=cr;
            firstName=new JLabel("FirstName");
            FirstName =new JTextField();
            lastName=new JLabel("LastName");
            LastName =new JTextField();
            email=new JLabel("Email");
            Email=new JTextField();
            password=new JLabel("Password");
            Password=new JPasswordField();
            Password.setEchoChar('*');
            jb=new JButton("SignUp");
            erNumber=new JLabel("Er Number");
            ErNumber=new JTextField();
            age=new JLabel("Age");
            Age=new JTextField();
            gender=new JLabel("Gender");
            b1=new JRadioButton("Male");
            b2=new JRadioButton("female");
            bg=new ButtonGroup();
            none=new JLabel("");
            setLayout(new GridLayout(9,2));
            add(firstName);
            add(FirstName);
            add(lastName);
            add(LastName);
            add(email);
            add(Email);
            add(password);
            add(Password);
            add(erNumber);
            add(ErNumber);
            add(age);
            add(Age);
            add(gender);
            bg.add(b1);
            bg.add(b2);
            add(b1);
            add(none);
            add(b2);
            add(jb);
           // setLayout(new GridLayout(8,2));







        }

    }
