/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class ReverseString {
    public static void main (String[] args) {

        Scanner sc=new Scanner(System.in);
        int Test=sc.nextInt();

        while(Test!=0)
        {
            //int lenS=sc.nextInt();

            String str="";

            str=sc.next();


            System.out.println(str);
           // System.out.println(str.charAt(2));


            StringBuffer sb=new StringBuffer();
            for(int i=str.length()-1;i>=0;i--)

            {

                sb.append(str.charAt(i));
            }


            System.out.println(sb.toString());
            if(str.equals(sb.toString()))
                System.out.println("Yes");
            else
                System.out.println("No");


            Test--;
        }


    }
}