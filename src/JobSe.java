/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class JobSe {
    public static void main (String[] args) throws Exception {


        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int test=Integer.parseInt(br.readLine());

        int max=0;
        while(test!=0)
        {

            int len=Integer.parseInt(br.readLine());

            String str[]=br.readLine().split(" ");


            // System.out.println(str[2]);

            int arr[][]=new int[len][3];
            int k=str.length;
            int j=0;
            for(int i=0;i<len;i++)
            {

                if(j<k)
                {
                    // System.out.println(str[0]);
                    arr[i][0]=Integer.parseInt(str[j]);
                    j++;
                    arr[i][1]=Integer.parseInt(str[j]);
                   // System.out.println(arr[i][1]);
                    if(arr[i][1] >=max)
                    {
                        max=arr[i][1];
                    }
                    j++;
                    arr[i][2]=Integer.parseInt(str[j]);

                    j++;

                }

            }

          //  System.out.println("Max dead line "+max);

            /*

            for(int i=0;i<len;i++)
            {
                for(int p=0;p<3;p++)
                {
                    System.out.print(arr[i][p]+" ");
                }

                System.out.println(" ");
            }

            */
           // System.out.println("//////////////");
            Arrays.sort(arr,new Comparator<int[]>(){


                        public int compare(final int e[],final int e2[])
                        {
                            if(e[2]<e2[2])
                            {
                                return 1;
                            }
                            else{
                                return -1;
                            }
                        }
                    }
            );

/*
            for(int i=0;i<len;i++)
            {
                for(int p=0;p<3;p++)
                {
                    System.out.print(arr[i][p]+" ");
                }

                System.out.println(" ");
            }

*/

            int arr2[]=new int[max+1];
            int count=0;
            int sum=0;

            //System.out.println(arr[0][2]);
            arr2[arr[0][1]]=arr[0][2];
           // System.out.println( arr2[arr[0][1]]);
            count++;
            sum+=arr[0][2];
            //System.out.println(len);
            for(int i=1;i<len;i++)
            {
               // System.out.println("Hitting "+i);
                if(arr2[arr[i][1]]==0)
                {
                    arr2[arr[i][1]]=arr[i][2];
                    count++;
                    sum+= arr[i][2];
                   // System.out.print("hit:"+arr2[arr[i][1]]+" at :"+arr[i][1]);
                }
                else
                {
                    if(arr[i][1] <=arr2[arr[i][1]])
                    {
                       // System.out.println("Gittt");
                        for(int t=arr[i][1]-1;t>0;t--)
                        {
                            if(arr2[t]==0)
                            {
                                arr2[t]=arr[i][2];
                                count++;
                                sum+= arr[i][2];
                              //  System.out.println(arr2[t]+"hit at "+t);
                                break;

                            }
                        }
                    }
                }
            }



            System.out.println(count+" "+sum);
            /*
            for(int i=0;i<len+1;i++)
            {
                System.out.println(arr2[i]);
            }
            */


            test--;
        }
        //code
    }
}