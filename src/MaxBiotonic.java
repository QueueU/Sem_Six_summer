import java.util.Arrays;
import java.util.Scanner;

public class MaxBiotonic {


    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);

        int a=sc.nextInt();

        while(a!=0)
        {
            int b=sc.nextInt();
            int arr[]=new int[b];
            for(int i=0;i<b;i++){

                arr[i]=sc.nextInt();
            }
            Arrays.sort(arr);
            System.out.print(arr[arr.length-1]);
            a--;
        }
    }
}
