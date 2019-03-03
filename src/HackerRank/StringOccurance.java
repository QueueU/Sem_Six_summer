package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StringOccurance {

    public static void  main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();

        char ch[]=str.toCharArray();
        int a[]=new int[10];

        ArrayList<Character> al=new ArrayList<Character>();



        for(int i=0;i<ch.length;i++)
        {
            al.add(ch[i]);
        }


        for(int i=0;i<al.size();i++)
        {

            for(int j=0;j<al.size();j++)
            {
                if(i==j)
                {
                    continue;
                }
                else if(al.get(i)==al.get(j))
                {

                   // System.out.println(al.get(i) + " : "+i+" ::: "+ j +" : " +al.get(j) );


                    a[Integer.parseInt(String.valueOf(al.get(i)))]+=1;
                    al.remove(j);
                   // System.out.println("Value of a :"+al.get(i)+" :: "+a[Integer.parseInt(String.valueOf(al.get(i)))]);
                    j--;

                }
            }


                    a[Integer.parseInt(String.valueOf(al.get(i)))] += 1;


        }


        for(int i=0;i<a.length;i++)
        {
            System.out.println(i + " " + a[i]);
        }





    }
}
