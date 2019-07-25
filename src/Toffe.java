import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Toffe {

    public static void main(String args[]) throws IOException
    {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        //System.out.print(br.readLine());

        String str2[]=br.readLine().trim().split(" ");
        int test=Integer.parseInt(str2[0]);


        while(test!=0)
        {

            String str1[]=br.readLine().split(" ");
            int toffeNumber=Integer.parseInt(str1[0]);
            int budget=Integer.parseInt(str1[1]);




            int calArr[]=new int[toffeNumber];
            int costArr[]=new int[toffeNumber];


            String getCal[]=br.readLine().split(" ");

            for(int i=0;i<toffeNumber;i++)
            {
                calArr[i]=Integer.parseInt(getCal[i]);
            }

            String getCost[]=br.readLine().split(" ");
            for(int i=0;i<toffeNumber;i++)
            {
                costArr[i]=Integer.parseInt(getCost[i]);
            }


            int NapValue[][]=new int[toffeNumber+1][budget+1];


            for(int i=1;i<=toffeNumber;i++)
            {
                for(int j=1;j<=budget;j++)
                {


                    if(costArr[i-1] > j)
                    {

                        NapValue[i][j]=NapValue[i-1][j];
                        //System.out.println(NapValue[i][j]+" Stored");
                    }
                    else
                    {
                        NapValue[i][j]=Math.max((calArr[i-1]+NapValue[i-1][j-costArr[i-1]]),NapValue[i-1][j]);
                        //System.out.println(NapValue[i][j]+" Stored");
                    }

                }
            }



            System.out.println(NapValue[toffeNumber][budget]);
            test--;



        }
    }
}
