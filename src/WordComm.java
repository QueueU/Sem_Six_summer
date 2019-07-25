import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class WordComm {

    public static void main(String args[]) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String str="";
        ArrayList<String>  al=new ArrayList<>();

        do
        {
            str=br.readLine().trim();
            al.add(str);
        }
        while(!str.equals("END"));

        al.remove(al.size()-1);

       // System.out.println(al);


        String str2[]=br.readLine().split(" ");

        //System.out.print(str2[1]);
        StringBuffer sb[]=new StringBuffer[2];

        sb[0]=new StringBuffer(str2[0].trim());

        sb[1]=new StringBuffer(str2[1].trim());
        System.out.println(sb[1]);

        //System.out.println(sb[0].length() +" "+sb[1].length());

        StringBuffer tempString=sb[0];

        int count=0;


        if(sb[0].equals(sb[1]))
        {
            System.out.print(0);
        }

        System.out.print(sb[0].length()+" "+(sb[1].length())+" "+(sb[0].length()<sb[1].length()));

        if(sb[0].length()>sb[1].length())
        {
            sb[0].setCharAt(sb[0].length()-1,' ');
            sb[0].trimToSize();



            for(int i=0;i<sb[0].length();i++)
            {
                System.out.println(" 1 nog");
                if (sb[0].charAt(i) != sb[1].charAt(i)) {
                    sb[0].setCharAt(i, sb[1].charAt(i));

                    System.out.println(sb[0]);

                    // System.out.println(al.contains(sb[0])+" ");

                    if (al.contains(sb[0].toString()) == true) {
                        count++;

                        //System.out.println(count);
                    }
                    sb[0] = tempString;

                }
            }

        }
        else if(sb[0].length()<sb[1].length())
        {
            for(int i=0;i<sb[1].length();i++)
            {

                System.out.println(" 2 nog");

                if(i==sb[0].length())
                {
                    sb[0].append(sb[1].charAt(i));

                  //  System.out.println(sb[0]);

                    if(al.contains(sb[0].toString())==true)
                    {
                        count++;
                    }

                    sb[0] = tempString;
                }

                else {
                    if (sb[0].charAt(i) != sb[1].charAt(i)) {
                        sb[0].setCharAt(i, sb[1].charAt(i));

                      //  System.out.println(sb[0]);

                       // System.out.println(al.contains(sb[0])+" ");

                        if (al.contains(sb[0].toString()) == true) {
                            count++;

                            //System.out.println(count);
                        }
                            sb[0] = tempString;

                    }
                }






            }



        }

        else if(sb[0].length()==sb[1].length())
        {

            System.out.println("nog");
            for(int i=0;i<sb[1].length();i++)
            {
                if (sb[0].charAt(i) != sb[1].charAt(i)) {
                    sb[0].setCharAt(i, sb[1].charAt(i));

                    //  System.out.println(sb[0]);

                    System.out.println(al.contains(sb[0])+" ");

                    if (al.contains(sb[0].toString()) == true) {
                        count++;

                        //System.out.println(count);
                    }
                    sb[0] = tempString;

                }
            }
        }


        if(count==0)
        {
            System.out.println("-1");
        }
        else
        {
            System.out.println(count);
        }















    }
}
