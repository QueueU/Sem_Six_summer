/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class RotateArray {
    public static void main (String[] args) {

        Scanner sc=new Scanner(System.in);

        int test=sc.nextInt();


        while(test!=0)
        {
            int N=sc.nextInt();
            int Rotate=sc.nextInt();


            int arr[]=new int[N];

            for(int i=0;i<N;i++)
            {
                arr[i]=sc.nextInt();
            }


            ArrayList<Integer> al=new ArrayList<>();
            int j=0;
/*            for(int i=Rotate;i<N;i++)
            {
                al.add(j++,arr[i]);

            }

            for(int i=0;i<Rotate;i++)
            {
                al.add(j++,arr[i]);
            }



            for(int i=0;i<al.size();i++)
            {
                System.out.print(" "+al.get(i));
            }
            System.out.println("");
*/

        int i=Rotate;
            while(true){

                if(i!=N){
                    System.out.println(arr[i]+" ");
                }


            }

    }
        //code
    }
}