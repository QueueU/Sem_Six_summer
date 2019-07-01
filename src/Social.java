/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail


import java.util.*;
class Social {
    public static void main(String args[] ) throws Exception {



        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        String str="";
        ArrayList<String> al=new ArrayList<>();
        for(int i=0;i<n;i++)
        {

            al.add(i*2,sc.next());
            str=sc.next();
            al.add(i*2+1,sc.next());

        }

        ArrayList<Integer> al2=new ArrayList<>();

        TreeSet<String> ts=new TreeSet<>();

        int totallength=0;
        int j=0;
        boolean flag=true;
        al2.add(j,0);
        for(int i=0;i<n-1;i++)
        {

         // System.out.println("first "+al.get(i*2)+" Second "+al.get(i*2+3));
            if(al.get(i*2).toLowerCase().equals(al.get(i*2+3).toLowerCase()))
            {
                //System.out.println("Ht1");
                if(flag)
                {
                  //  System.out.println("Ht1");
                    al2.add(j,al2.get(j)+2);
                    flag=false;
                }
                else {
                    al2.add(j, al2.get(j) + 1);
                }
            }
            else
            {
                al2.add(j++,0);
                flag=true;
            }

        }

       System.out.println(al2);
        Collections.sort(al2);




        if(al2.get(al2.size()-1) > 0)
        {
            System.out.println(al2.get(al2.size() - 1) + 1);
        }
        else
        {
            System.out.println(al2.get(al2.size() - 1) + 2);
        }



        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here

    }
}
