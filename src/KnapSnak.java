import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class KnapSnak {


    public static void main(String args[]) throws Exception
    {


        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));



       System.out.println("Enter Out Put N");
       int N=Integer.parseInt(br.readLine());
       int wt[]=new int[N];


       System.out.println("Enter Weight");
       for(int i=0;i<N;i++)
       {
           wt[i]=Integer.parseInt(br.readLine());
       }


       int value[]=new int[N];
       System.out.println("Enter Value");
       for(int i=0;i<N;i++)
       {
           value[i]=Integer.parseInt(br.readLine());
       }



       System.out.println("Enter Max value of weight");
       int Max=Integer.parseInt(br.readLine());

       int maxValue[]=new int[Max+1];

       for(int i=0;i<=Max;i++)

       {
           maxValue[i]=i;

           //System.out.println(maxValue[i]);
       }

       int NapValue[][]=new int[N+1][Max+1];

        //Arrays.fill(NapValue,0);




       for(int i=1;i<N;i++)
       {
           for(int j=1;j<=Max;j++ ){

               if(wt[i-1] <= maxValue[j])
               {
                   NapValue[i][j]=Math.max((value[i-1]+NapValue[i-1][j-wt[i-1]]),NapValue[i-1][j]);
                   System.out.println(NapValue[i][j]+" Stored");
               }
                else
               {
                   NapValue[i][j]=NapValue[i-1][j];
               }


           }
       }



        for(int i=1;i<N;i++)
        {
            for(int j=1;j<=Max+1;j++ ){

                System.out.print(NapValue[i][j]+" ");

            }

            System.out.println(" ");

            }

    }
}
