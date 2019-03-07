/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prac4;

import Prac4.DriverClass;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 *
 * @author b201
 */
public class ShowAllData extends JPanel{

     CardLayout cd;
        Container cr;

        ShowAllData(CardLayout cd, Container cr) {
        this.cd = cd;
        this.cr = cr;
        this.GetData();
    }

        public void GetData() {
            String data[][]=null;
        String column[] = {"FirstName", "LastName", "Eamil", "password", "erNumber", "age", "Gender"};
        try {
            Connection con = DriverClass.getConnection();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("select  count(*) from st");
            int length = 0;
            while (res.next()) {
                length = res.getInt(1);
            }
            PreparedStatement ps = con.prepareStatement("select * from st");
           data = new String[length][7];
            System.out.println(length);
            ResultSet rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getString(3);
                data[i][3] = rs.getString(4);
                data[i][4] = rs.getString(5);
                data[i][5] = rs.getString(6);
                data[i][6] = rs.getString(7);
              i++;
            }
            System.out.println(data);
        }
        catch (Exception ep) {
            ep.printStackTrace();
        }
        JTable jt = new JTable(data, column);
        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        this.add(jt);
    }
}
