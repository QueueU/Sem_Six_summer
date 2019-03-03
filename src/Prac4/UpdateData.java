package Prac4;


import Prac4.SignUp;
import java.awt.CardLayout;
import java.awt.Container;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
    SignUp su;
    public UpdateData(CardLayout cn, Container cr) {

        this.cn = cn;
        this.cr = cr;
             String UserName="";
        if(LoginDB.flag)
        {
        UserName= JOptionPane.showInputDialog(null, "Enter UserName or Email");
        }

        try {
            if (CheckData(UserName)) {
                System.out.println(CheckData(UserName));
              su=new SignUp(cn,cr);  
              add(su);
            } else {
                    
                JOptionPane.showMessageDialog(null, "Data Not found");
            }
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public boolean CheckData(String UserName) throws Exception {
       // Connection con = Prac4.DriverClass.getConnection();
        //PreparedStatement ps = con.prepareStatement("select * from st where email=?");
        //ps.setString(1, UserName);

        boolean check = false;
        //check = ps.execute();

        /*
        if (check) {
            return check;
        } else {
            return check;
        }
*/
        check=true;
        
        return check;
        
        
    }
}
