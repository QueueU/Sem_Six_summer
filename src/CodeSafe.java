import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CodeSafe
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//Scanner sc=new Scanner(System.in);
        int T=Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            String str[]=br.readLine().split(" ");
            int N=Integer.parseInt(str[0]);
            int B=Integer.parseInt(str[1]);
            int cal[]=new int[N+1];
            int price[]=new int[N+1];
            String s[]=br.readLine().split(" ");
            for(int j=1;j<=N;j++){
                cal[j]=Integer.parseInt(s[j-1]);
            }
            String s1[]=br.readLine().split(" ");
            for(int j=1;j<=N;j++){
                price[j]=Integer.parseInt(s1[j-1]);
            }
            int arr[][]=new int[N+1][B+1];
            for(int j=0;j<=N;j++)
                arr[j][0]=0;
            for(int j=0;j<=B;j++)
                arr[0][j]=0;

            for(int j=1;j<=N;j++){
                for(int k=1;k<=B;k++){
                    if(price[j]>k)
                        arr[j][k]=arr[j-1][k];
                    else
                        arr[j][k]=Math.max(arr[j-1][k],arr[j-1][k-price[j]]+cal[j]);
                }
            }
            System.out.println(arr[N][B]);
        }
    }
}
