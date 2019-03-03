package HackerRank;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();

        int arr[]=new int[a];
        int count[]=new int[3];

        for(int i=0;i<a;i++)
        {
            arr[i]=sc.nextInt();

            if(arr[i] <0)
            {
                count[0]+=1;
            }
            else if (arr[i] > 0)
            {
                count[1]+=1;
            }
            else
            {
                count[2]+=1;
            }



        }




        DecimalFormat df=new DecimalFormat("#.######");

        System.out.println(df.format((Double.valueOf(count[1])/Double.valueOf(a))));
        System.out.println(df.format((Double.valueOf(count[0])/Double.valueOf(a))));
        System.out.println(df.format((Double.valueOf(count[2])/Double.valueOf(a))));

        /*
        System.out.printf("%.6f",(count[1]/a));
        System.out.printf("%.6f",(count[2]/a)); */
    }

}


