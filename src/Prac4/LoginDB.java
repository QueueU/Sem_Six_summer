/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prac4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author b201
 */
public class LoginDB implements ActionListener {

    static JFrame jf;
    JMenu menu;
    public static int j;
    JMenuItem LoginMenu;
    JMenuItem SignMenu;
    JMenuItem Update;
    JMenuItem ShowData;
    static CardLayout card;
    static Connection con;
    JPanel p4;
    public static boolean flag;
        //public static boolean flag=false;
    public LoginDB() {
        card = new CardLayout();
        jf = new JFrame("LoginDB");
        JMenuBar mb = new JMenuBar();
        menu = new JMenu("Items");
        LoginMenu = new JMenuItem("Login");
        SignMenu = new JMenuItem("Sign");
        Update =new JMenuItem("Update");
        ShowData=new JMenuItem("ShowAll Data");
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p5=new JPanel();
        p4=new JPanel();

        JLabel lb = new JLabel("Welcome to Test Application");
        lb.setSize(100, 100);

        menu.add(LoginMenu);
        menu.add(SignMenu);
        menu.add(Update);
        menu.add(ShowData);


        mb.add(menu);
        p1.add(lb);
        p2.add(new Login(card, jf.getContentPane()));
       p3.add(new SignUp(card,jf.getContentPane()));
      p5.add(new ShowAllData(card,jf.getContentPane()));
        LoginMenu.addActionListener(this);
        SignMenu.addActionListener(this);
        Update.addActionListener(this);
        ShowData.addActionListener(this);


        SignUp.jb.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("from LoginDB");
                LoginDB.PushIntoDB(1);
            }
        });
        /*
        SignUp.jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String FirstName=SignUp.FirstName.getText();
                String LastName=SignUp.LastName.getText();
                String Email=SignUp.Email.getText();
                String password=SignUp.Password.getText();
                String erNumber=SignUp.ErNumber.getText();
                String age=SignUp.Age.getText();
                String Gender;
                 if(SignUp.b1.isSelected())
                 {
                     Gender="Male";
                 }
                 else
                 {
                     Gender="Female";
                 }
                 System.out.println(FirstName);
                System.out.println(LastName);
                System.out.println(Email);
                System.out.println(password);
                System.out.println(erNumber);
                System.out.println(age);
                System.out.println(Gender);

                 try {
                     con = Prac4.DriverClass.getConnection();
                     PreparedStatement ps = con.prepareStatement("insert into st values (?,?,?,?,?,?,?)");
                     ps.setString(1,FirstName);
                     ps.setString(2,LastName);
                     ps.setString(3,Email);
                     ps.setString(4,password);
                     ps.setString(5,erNumber);
                     ps.setString(6,age);
                     ps.setString(7,Gender);

                     int i=ps.executeUpdate();

                     if(i>=1)
                     {
                         card.show(jf.getContentPane(), "2");
                         SignUp.FirstName.setText("");
                         SignUp.LastName.setText("");
                         SignUp.Password.setText("");
                         SignUp.ErNumber.setText("");
                         SignUp.Age.setText("");
                         SignUp.Email.setText("");
                     }
                     else
                     {
                         JOptionPane.showMessageDialog(jf,"Somethings going Wrong");
                     }
                 }
                 catch (Exception E)
                 {
                     E.printStackTrace();
                 }

            }
        });
            */


        Login.jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String UserName = Login.userName.getText();
                String Password = Login.password.getText();

                try {
                    con = Prac4.DriverClass.getConnection();
                    PreparedStatement ps = con.prepareStatement("select * from st where email=? and password =?");
                    ps.setString(1, UserName);
                    ps.setString(2, Password);

                    String st[];
                    int ii=0;
                    ResultSet rs=ps.executeQuery();
                    rs.next();
                    //boolean i=ps.execute();

                   if(Password.equals(rs.getString("password")))
                   {
                       JOptionPane.showMessageDialog(jf,"Welcome "+rs.getString("firstName"));
                   }
                   else
                   {

                   }
                    } catch (Exception E) {
                    System.out.println(E);
                    JOptionPane.showMessageDialog(jf,"Login Failed ");
                }
            }
        });
        jf.setLayout(card);
        jf.setJMenuBar(mb);
        jf.add(p1, "1");
        jf.add(p2, "2");
        jf.add(p3, "3");
        jf.add(p4,"4");
        jf.add(p5,"5");
        jf.setSize(300, 300);
        jf.setVisible(true);


    }

    public static void main(String args[]) {
        LoginDB ldb = new LoginDB();
    }

    public static void CheckOperation() {
        try {
            con = DriverClass.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from st where email=?");
            ps.setString(1, UpdateData.UserName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SignUp.FirstName.setText(rs.getString(1));
                SignUp.LastName.setText(rs.getString(2));
                SignUp.Email.setText(rs.getString(3));
                SignUp.Password.setText(rs.getString(4));
                SignUp.ErNumber.setText(rs.getString(5));
                SignUp.Age.setText(rs.getString(6));
                String radioB = rs.getString(7);
                if (radioB == "male") {
                    SignUp.b1.getSelectedIcon();
                    //continue;
                }
                else {
                    SignUp.b2.getSelectedIcon();
                }


            }
        }
        catch (Exception eep) {
            eep.printStackTrace();
        }
    }

    public static void PushIntoDB(int j) {
        String FirstName = SignUp.FirstName.getText();
        String LastName = SignUp.LastName.getText();
        String Email = SignUp.Email.getText();
        String password = SignUp.Password.getText();
        String erNumber = SignUp.ErNumber.getText();
        String age = SignUp.Age.getText();
        String Gender = SignUp.b1.isSelected() ? "Male" : "Female";
        System.out.println(FirstName);
        System.out.println(LastName);
        System.out.println(Email);
        System.out.println(password);
        System.out.println(erNumber);
        System.out.println(age);
        System.out.println(Gender);
        try {
            con = DriverClass.getConnection();
            if (j == 0) {
                PreparedStatement ps = con.prepareStatement("update st SET firstName=?,lastName = ?,email =?,password =? ,erNumber =? ,age =?, gen = ? where email=?");
                ps.setString(1, FirstName);
                ps.setString(2, LastName);
                ps.setString(3, Email);
                ps.setString(4, password);
                ps.setString(5, erNumber);
                ps.setString(6, age);
                ps.setString(7, Gender);
                ps.setString(8, UpdateData.UserName);
                int i = ps.executeUpdate();
                if (i >= 1) {
                    JOptionPane.showMessageDialog(jf, "Data sucessfully updated");
                } else {
                    JOptionPane.showMessageDialog(jf, "Somethings going Wrong");
                }
            } else {
                PreparedStatement ps = con.prepareStatement("insert into st values (?,?,?,?,?,?,?)");
                ps.setString(1, FirstName);
                ps.setString(2, LastName);
                ps.setString(3, Email);
                ps.setString(4, password);
                ps.setString(5, erNumber);
                ps.setString(6, age);
                ps.setString(7, Gender);
                int i = ps.executeUpdate();
                if (i >= 1) {
                    card.show(jf.getContentPane(), "2");
                    SignUp.FirstName.setText("");
                    SignUp.LastName.setText("");
                    SignUp.Password.setText("");
                    SignUp.ErNumber.setText("");
                    SignUp.Age.setText("");
                    SignUp.Email.setText("");
                } else {
                    JOptionPane.showMessageDialog(jf, "Somethings going Wrong");
                }
            }
        }
        catch (Exception E) {
            E.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == LoginMenu) {
            card.show(jf.getContentPane(), "2");

        } else if (e.getSource() == SignMenu) {
            card.show(jf.getContentPane(), "3");
        }
        else if(e.getSource() == Update)
        {
            flag=true;
            System.out.println(flag);
             p4.add(new UpdateData(card,jf.getContentPane()));
       
        card.show(jf.getContentPane(),"4");
        
        }
        else if(e.getSource() == ShowData)
        {
            card.show(jf.getContentPane(), "5");
        }

    }

}
