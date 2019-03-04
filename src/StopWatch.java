/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import javax.swing.*;

public class StopWatch implements ActionListener {
    JLabel jlab;
    long start;
    public StopWatch(){
        JFrame jfrm = new JFrame("A Simple Stopwatch");
        jfrm.setSize(230, 100);
        jfrm.setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton jbtnstart = new JButton("Start");
        JButton jbtnstop = new JButton("Stop");

        jbtnstart.addActionListener(this);
        jbtnstop.addActionListener(this);

        jlab = new JLabel(" Press start to begin timing.");
        jfrm.add(jbtnstart);
        jfrm.add(jbtnstop);
        jfrm.add(jlab);
        jfrm.setResizable(false);
        jfrm.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Calendar cal=Calendar.getInstance();

        if(e.getActionCommand().equals("Start")){
            start=cal.getTimeInMillis(); //strore start time
            jlab.setText("Stopwatch is running....");
        }
        else if (e.getActionCommand().equals("Stop")){
            jlab.setText("Elapsed time is "+ (double)(cal.getTimeInMillis() - start)/1000);
        }

    }

    public static void main(String args[]) {    //main thread
        SwingUtilities.invokeLater(() -> {
                    StopWatch StopWatch; /*stopWatch*/
                    StopWatch = new StopWatch();
                } //event dispatcher thread
        );
    }
}


