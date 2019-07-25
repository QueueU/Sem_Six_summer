/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class AdjustString {
    public static void main (String[] args) throws Exception {
        //code

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int Test=Integer.parseInt(br.readLine());

        while(Test!=0)
        {
            String str=br.readLine();
            ArrayList<Character> al=new ArrayList<>();


            int count=1;
           // int p=0;
            al.add(str.charAt(0));
           // p++;
           // System.out.println(str.charAt(str.length()-1));
            for(int i=1;i<str.length();i++)
            {

               // System.out.println(str.length());

                //System.out.println(p);

               System.out.println( str.charAt(i)+" & "+al.get(al.size()-1) + " check "+ (str.charAt(i)==al.get(al.size()-1)));
                if(str.charAt(i)==al.get(al.size()-1))
                {
                    al.add(str.charAt(i));
                   // p++;

                    count++;
                    //System.out.println("-----------"+count);
                    if(i==str.length()-1)
                    {
                        int k=al.size();
                        for (int j=count;j>0;j--)
                        {
                            //System.out.println(al.get(k-1)+" gets removed");
                            al.remove(k-1);
                            // p--;
                            k--;
                        }
                    }
                }else
                {

                    if(count>=2)
                    {
                        //System.out.println(p);
                        int k=al.size();
                        for (int j=count;j>0;j--)
                        {
                      //   System.out.println(al.get(k-1)+" gets removed");
                            al.remove(k-1);
                           // p--;
                            k--;
                        }


                    }
                    count=1;
                    al.add(str.charAt(i));
                  //  p++;

                }
            }




            for(char c:al)
            {
                System.out.print(c+" ");
            }
            Test--;
        }
    }
}