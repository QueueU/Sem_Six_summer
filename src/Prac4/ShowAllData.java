/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prac4;

import java.awt.CardLayout;
import java.awt.Container;
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
    
    ShowAllData(CardLayout cd,Container cr)
    {
        this.cd=cd;
        this.cr=cr;
        
        
        GetData();
        
        
    }
    
    public void GetData()
    {
        String data[][]={ {"abce","xyz","abc@gmail.com","123","145","23","Male"},    
                          {"Ujash" , "Patel" ,"ujash@gmail.com" ,"133","144","21","Male"}};
                           
    String column[]={"FirstName","LastName","Eamil","password","erNumber","age","Gender"};  
    
    
    JTable jt=new JTable (data,column);
    jt.setBounds(30,40,200,300);          
    JScrollPane sp=new JScrollPane(jt);    
    
    add(jt);
    
    }
    
}
