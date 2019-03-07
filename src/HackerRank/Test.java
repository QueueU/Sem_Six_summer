package HackerRank;

import java.util.*;
class Test
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int arr[][]=new int[6][6];

        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }

        int sum[]=new int[16];
        int k=0;
        for(int i=0;i<6;i++)
        {
            if(i>1 && i<5)
            {
                for(int j=0;j<4;j++)
                {
                    System.out.print(arr[i][j+1]+ " \n"+arr[i-1][j]+ " "+arr[i-1][j+1]+" " +arr[i-1][j+2] + " \n"+(arr[i+1][j]) +" "+ arr[i+1][j+1]+" "+(arr[i+1][j+2]));
                    sum[k]=((arr[i][j+1])+(((arr[i-1][j])+(arr[i-1][j+1]))+(arr[i-1][j+2]))+(((arr[i+1][j])+(arr[i+1][j+1]))+(arr[i+1][j+2])));

                    k++;
                }
            }
        }

        Arrays.sort(sum);
        System.out.println(sum[15]);
    }
}
