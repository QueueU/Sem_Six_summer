/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author b201
 */
public class TreeSwing {
    
    
    TreeSwing()
    {
        JFrame f=new JFrame("This is tree Practiocal");
        f.setLayout(new FlowLayout());
        f.setSize(350, 350);
        f.setVisible(true);
        
        DefaultMutableTreeNode tr=new DefaultMutableTreeNode("Elective 1");
        DefaultMutableTreeNode tr1=new DefaultMutableTreeNode("Elective 2");
        DefaultMutableTreeNode tr2=new DefaultMutableTreeNode("Elective 3");
        
        DefaultMutableTreeNode trj=new DefaultMutableTreeNode("JAVA Tech");
        DefaultMutableTreeNode tri=new DefaultMutableTreeNode("IOT");
        DefaultMutableTreeNode trl=new DefaultMutableTreeNode("LAMp");
    
           DefaultMutableTreeNode tr1c=new DefaultMutableTreeNode("Cloud Computing");
           DefaultMutableTreeNode tr1n=new DefaultMutableTreeNode("NSC");
           DefaultMutableTreeNode tr1b=new DefaultMutableTreeNode("BAO");
           
           DefaultMutableTreeNode tr2a=new DefaultMutableTreeNode("ADS");
           DefaultMutableTreeNode tr2m=new DefaultMutableTreeNode("ML");
           DefaultMutableTreeNode tr2d=new DefaultMutableTreeNode("DM");
           
           tr.add(trj);
           tr.add(tri);
           tr.add(trl);
            
           tr1.add(tr1c);
           tr1.add(tr1n);
           tr1.add(tr1b);
           
           tr2.add(tr2a);
           tr2.add(tr2m);
           tr2.add(tr2d);

           
            JTree jt=new JTree(tr);
            JTree jt1=new JTree(tr1);
            JTree jt2=new JTree(tr2);
                
            f.add(jt);
            f.add(jt1);
            f.add(jt2);
            
            
        }
    
    public static void main(String ags[])
    {
        TreeSwing ts=new TreeSwing();
    }
    
}
