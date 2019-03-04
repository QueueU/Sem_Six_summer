/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author b201
 */
public class ListSwing {
    
    ListSwing()
    {
        JFrame frame=new JFrame();
        
        DefaultListModel<String> l1=new DefaultListModel<String>();
        l1.addElement("Item 1");
        l1.addElement("Item 2");
        l1.addElement("Item 1");
        l1.addElement("Item 3");
        l1.addElement("Item 4");
        l1.addElement("Item 2");l1.addElement("Item 4");l1.addElement("Item 3");
        JList<String> li=new JList<>(l1);
        
        
       
        li.setBounds(0, 0, 0, 0);
        JLabel lb=new JLabel();
        lb.setBounds(10, 10, 100, 100);
        JButton jb=new JButton("Check");
        jb.setBounds(70, 70, 100, 100);
        frame.add(jb);
        frame.add(li);
        frame.add(lb);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setSize(450, 450);
        jb.addActionListener(new ActionListener(){
            
           

            @Override
            public void actionPerformed(ActionEvent e) {
                int temp=li.getSelectedIndices().length;
             String s1=Arrays.toString(li.getSelectedIndices());
                List<String> s2=li.getSelectedValuesList();
                
                System.out.println(s1);
                System.out.println(s2);
                System.out.println(s2.size());
               // System.out.println(s2.get(0));
             //   System.out.println(s2.get(1));
             boolean flag=false;
                
             
             if(temp==1)
             {
                 lb.setText("Select item is same");
             }
             else
             {
                for(int i=1;i<s2.size();i++)
                {
                    if(s2.get(0) == s2.get(i))
                    {
                       flag=true; 
                    }else
                        
                    {
                        lb.setText("All selected Values are not same");
                        break;
                    }
                }
             }  
                if(flag==true)
                {
                    lb.setText("All selected values are Same");
                }
                    
                
            }
        
        });
        
    }
    
    public static void main(String args[]){
        ListSwing ls=new ListSwing();
    }
    
    
    
    
}
