/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class calculator extends Arith implements ActionListener{
    private JFrame calculator =new JFrame("CS180 Calculator");
    private JPanel keyPad=new JPanel();
    private JPanel screenPanel=new JPanel();
    private JTextField screen= new JTextField("0");
    private JButton[] num=new JButton[10];
    private JButton plus =new JButton("+");
    private JButton minus =new JButton("-");
    private JButton times =new JButton("*");
    private JButton divide =new JButton("/");
    private JButton equal =new JButton("=");
    private JButton log =new JButton("log");
    private JButton ln =new JButton("ln");
    private JButton pow =new JButton("pow");
    private JButton square =new JButton("squar");
    private JButton squareRoot =new JButton("sqrt");
    private JButton sin =new JButton("sin");
    private JButton cos =new JButton("cos");
    private JButton tan =new JButton("tan");
    private JButton decimalPoint =new JButton(".");
    private String numOnScreen="";
    private double memory;//for +-/*
    private double memory2;//for log, ln ect;
    private int operator=0;//+-*/pwd to 12345
    boolean ifMemory=false;
    boolean ifDecimal=false;
    boolean ifUnary=false;
    public calculator(){

        setFrame();
        setListener();
    }
    //setFrame panel button
    public void setFrame(){
        for(int i=0;i<10;i++){
            num[i]=new JButton(Integer.toString(i));
        }
        //keyPad.add(log);
        //keyPad.add(ln);
        //keyPad.add(pow);
        keyPad.add(num[1]);
        keyPad.add(num[2]);
        keyPad.add(num[3]);
        keyPad.add(plus);
        keyPad.add(minus);
        //keyPad.add(square);
        //keyPad.add(squareRoot);
        //keyPad.add(sin);
        keyPad.add(num[4]);
        keyPad.add(num[5]);
        keyPad.add(num[6]);
        //keyPad.add(times);
        keyPad.add(divide);
        //keyPad.add(cos);
        //keyPad.add(tan);
        keyPad.add(decimalPoint);
        keyPad.add(num[7]);
        keyPad.add(num[8]);
        keyPad.add(num[9]);
        keyPad.add(num[0]);
        keyPad.add(equal);
        keyPad.setLayout(new GridLayout(3,8,0,0));
        screenPanel.add(screen);
        screenPanel.setLayout(new GridLayout(1,1,0,0));
        calculator.add(keyPad);
        calculator.add(screenPanel);
        calculator.setLayout(null);
        screenPanel.reshape(0,0,600,20);
        keyPad.reshape(0,20,600,200);
        calculator.setSize(610,241);
        calculator.setVisible(true);
        calculator.setResizable(false);
        calculator.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    //For listerner
    public void setListener(){
        for(int i=0;i<10;i++){
            num[i].addActionListener(this);
        }
        plus.addActionListener(this);
        minus.addActionListener(this);
        times.addActionListener(this);
        divide.addActionListener(this);
        equal.addActionListener(this);
        //log.addActionListener(this);
        //ln.addActionListener(this);
        //pow.addActionListener(this);
        //square.addActionListener(this);
        //squareRoot.addActionListener(this);
        decimalPoint.addActionListener(this);
        //  sin.addActionListener(this);
        // cos.addActionListener(this);
        tan.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        Object aButton=e.getSource();
        String numInput;
        for(int i=0;i<10;i++){
            if(aButton==num[i]){
                if(ifUnary==false){
                    if(numOnScreen.equals("0")){
                        numOnScreen=Integer.toString(i);
                    }
                    else{
                        numOnScreen=numOnScreen+Integer.toString(i);//input the nums and output on the screen
                        System.out.print(numOnScreen);
                    }
                }
                else{
                    numOnScreen=Integer.toString(i);
                    ifUnary=false;
                }
                screen.setText(numOnScreen);
                break;
            }
        }
        if(aButton==plus){// find substring,do the operator . after that  clean numOnScreen
            if(numOnScreen=="")
                operator=1;
            else{
                if(numOnScreen.length()>8)
                    numOnScreen=numOnScreen.substring(0,8);
                if(ifMemory==false){//if memory is empty then fill it. output the numOnScreen
                    memory=Double.parseDouble(numOnScreen);
                    ifMemory=true;
                    screen.setText(numOnScreen);//output
                    operator=1;
                }
                else{//if memory is filled, then do the operator then output the result
                    //memory=memory+Double.parseDouble(numOnScreen);
                    calculate();//do the operator
                    operator=1;//reset operator
                    outPutMemory();//output
                }
            }
            numOnScreen="";//clean
            ifDecimal=false;//reset decimal
        }
        if(aButton==minus){// find substring,do the operator . after that  clean numOnScreen
            if(numOnScreen=="")
                operator=2;
            else{
                if(numOnScreen.length()>8)
                    numOnScreen=numOnScreen.substring(0,8);
                if(ifMemory==false){//if memory is empty then fill it. output the numOnScreen
                    memory=Double.parseDouble(numOnScreen);
                    ifMemory=true;
                    screen.setText(numOnScreen);//output
                    operator=2;//set operator
                }
                else{//if memory is filled, then do the operator then output the result
                    //memory=memory+Double.parseDouble(numOnScreen);
                    calculate();//do the operator
                    operator=2;//reset operator
                    outPutMemory();//output
                }
            }
            numOnScreen="";//clean
            ifDecimal=false;//reset decimal
        }
        if(aButton==times){// find substring,do the operator . after that  clean numOnScreen
            if(numOnScreen=="")
                operator=3;
            else{
                if(numOnScreen.length()>8)
                    numOnScreen=numOnScreen.substring(0,8);
                if(ifMemory==false){//if memory is empty then fill it. output the numOnScreen
                    memory=Double.parseDouble(numOnScreen);
                    ifMemory=true;
                    screen.setText(numOnScreen);//output
                    operator=3;
                }
                else{//if memory is filled, then do the operator then output the result
                    //memory=memory+Double.parseDouble(numOnScreen);
                    calculate();//do the operator
                    operator=3;//reset operator
                    outPutMemory();//output
                }
            }
            numOnScreen="";//clean
            ifDecimal=false;//reset decimal
        }

        if(aButton==divide){// find substring,do the operator . after that  clean numOnScreen
            if(numOnScreen=="")
                operator=4;
            else{
                if(numOnScreen.length()>8)
                    numOnScreen=numOnScreen.substring(0,8);
                if(ifMemory==false){//if memory is empty then fill it. output the numOnScreen
                    memory=Double.parseDouble(numOnScreen);
                    ifMemory=true;
                    screen.setText(numOnScreen);//output
                    operator=4;
                }
                else{//if memory is filled, then do the operator then output the result
                    //memory=memory+Double.parseDouble(numOnScreen);
                    calculate();//do the operator
                    operator=4;//reset operator
                    outPutMemory();//output
                }
            }
            numOnScreen="";//clean
            ifDecimal=false;//reset decimal
        }


        if(aButton==pow){// find substring,do the operator . after that  clean numOnScreen
            if(numOnScreen=="")
                operator=5;
            else{
                if(numOnScreen.length()>8)
                    numOnScreen=numOnScreen.substring(0,8);
                if(ifMemory==false){//if memory is empty then fill it. output the numOnScreen
                    memory=Double.parseDouble(numOnScreen);
                    ifMemory=true;
                    screen.setText(numOnScreen);//output
                    operator=5;
                }
                else{//if memory is filled, then do the operator then output the result
                    //memory=memory+Double.parseDouble(numOnScreen);
                    calculate();//do the operator
                    operator=5;//reset operator
                    outPutMemory();//output
                }
            }
            numOnScreen="";//clean
            ifDecimal=false;//reset decimal
        }
        //euqal
        if(aButton==equal){
            if(numOnScreen!=""){
                calculate();
                outPutMemory();
                ifMemory=false;//clean memory
                ifDecimal=false;//reset decimal
            }
            numOnScreen="";

        }

        if(aButton==decimalPoint){
            if(ifDecimal==false){
                numOnScreen=numOnScreen+".";
                screen.setText(numOnScreen);
                ifDecimal=true;
            }

        }
 /*if(aButton==log){
 numOnScreen=screen.getText();
 memory2=Math.log(Double.parseDouble(numOnScreen))/Math.log(10);
 outPutNumOnScreen();
 ifDecimal=false;
 ifUnary=true;
 }
  if(aButton==ln){
 numOnScreen=screen.getText();
 memory2=Math.log(Double.parseDouble(numOnScreen));
 outPutNumOnScreen();
 ifDecimal=false;
 ifUnary=true;
 }

    if(aButton==square){
 numOnScreen=screen.getText();
 memory2=Math.pow(Double.parseDouble(numOnScreen),2);
 outPutNumOnScreen();
 ifDecimal=false;
 ifUnary=true;
 }
        if(aButton==squareRoot){
 numOnScreen=screen.getText();
 memory2=Math.pow(Double.parseDouble(numOnScreen),0.5);
 outPutNumOnScreen();
 ifDecimal=false;
 ifUnary=true;
 }
  if(aButton==sin){
 numOnScreen=screen.getText();
 memory2=Math.sin(Double.parseDouble(numOnScreen));
 outPutNumOnScreen();
 ifDecimal=false;
 ifUnary=true;
 }
  if(aButton==cos){
 numOnScreen=screen.getText();
 memory2=Math.cos(Double.parseDouble(numOnScreen));
 outPutNumOnScreen();
 ifDecimal=false;
 ifUnary=true;
 }
  if(aButton==tan){
 numOnScreen=screen.getText();
 memory2=Math.tan(Double.parseDouble(numOnScreen));
 outPutNumOnScreen();
 ifDecimal=false;
 ifUnary=true;
 }*/
    }


    public void outPutNumOnScreen(){//reorganize memory2, throw off .0 from 1.0. then output
        String temp;
        if(memory2-(int)memory2==0.0)//output
            temp=Integer.toString((int)memory2);
        else
            temp=Double.toString(memory2);
        if(temp.length()>8)
            temp=temp.substring(0,8);
        screen.setText(temp);
        numOnScreen=temp;

    }
    public void outPutMemory(){
        String temp;
        if(memory-(int)memory==0.0)//output
            temp=Integer.toString((int)memory);
        else
            temp=Double.toString(memory);
        if(temp.length()>8)
            temp=temp.substring(0,8);
        memory=Double.parseDouble(temp);
        screen.setText(temp);
    }
    public void calculate(){
        switch(operator){
            //case 1:memory=memory+Double.parseDouble(numOnScreen);break;
            case 1:memory=add(memory,Double.parseDouble(numOnScreen)) ;break;
            // case 2:memory=memory-Double.parseDouble(numOnScreen);break;
            case 2:memory=sub(memory,Double.parseDouble(numOnScreen)) ;break;
            //  case 3:memory=memory*Double.parseDouble(numOnScreen);break;
            case 3:memory=mul(memory,Double.parseDouble(numOnScreen)) ;break;
            //case 4:memory=memory/Double.parseDouble(numOnScreen);break;
            case 4:memory=div(memory,Double.parseDouble(numOnScreen)) ;break;
            case 5:memory=Math.pow(memory,Double.parseDouble(numOnScreen));break;
        }
    }
    public  static void main(String [] args){
        new calculator();



    }
}


class Arith{ //This class  is designed for precison calculation

    private static final int DEF_DIV_SCALE = 10;

    public static double add(double v1,double v2){

        BigDecimal b1 = new BigDecimal(Double.toString(v1));

        BigDecimal b2 = new BigDecimal(Double.toString(v2));

        return b1.add(b2).doubleValue();

    }


    public static double sub(double v1,double v2){

        BigDecimal b1 = new BigDecimal(Double.toString(v1));

        BigDecimal b2 = new BigDecimal(Double.toString(v2));

        return b1.subtract(b2).doubleValue();

    }



    public static double mul(double v1,double v2){

        BigDecimal b1 = new BigDecimal(Double.toString(v1));

        BigDecimal b2 = new BigDecimal(Double.toString(v2));

        return b1.multiply(b2).doubleValue();

    }

    public static double div(double v1,double v2){

        return div(v1,v2,DEF_DIV_SCALE);

    }

    public static double div(double v1,double v2,int scale){

        BigDecimal b1 = new BigDecimal(Double.toString(v1));

        BigDecimal b2 = new BigDecimal(Double.toString(v2));

        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();

    }


};