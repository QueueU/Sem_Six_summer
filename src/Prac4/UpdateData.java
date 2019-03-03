package Prac4;


import Prac4.SignUp;
import com.mysql.jdbc.log.Log;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author b201
 */
public class UpdateData extends JPanel {

    CardLayout cn;
    Container cr;
    public static String UserName="";
    SignUp su;
    public UpdateData(CardLayout cn, Container cr) {

        this.cn = cn;
        this.cr = cr;

        if(LoginDB.flag)
        {
        UserName= JOptionPane.showInputDialog(null, "Enter UserName or Email");
        }

        try {
            if (CheckData(UserName)) {
                System.out.println(this.CheckData(UserName));
                this.su = new SignUp(cn, cr);
                this.add(this.su);
                LoginDB.CheckOperation();
                SignUp.jb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       LoginDB.PushIntoDB(0);
                    }
                });
            } else {
                    
                JOptionPane.showMessageDialog(null, "Data Not found");
            }
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public boolean CheckData(String UserName) throws Exception {
        Connection con = Prac4.DriverClass.getConnection();

        PreparedStatement ps = con.prepareStatement("select * from st where email=?");
        ps.setString(1, UserName);

        boolean check = false;
        check = ps.execute();
        ResultSet i=ps.executeQuery();


        while (i.next()){
            return true;
        }

        return  false
                ;





        

        
        
    }
}
