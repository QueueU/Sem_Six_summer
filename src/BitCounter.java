import java.util.Scanner;

public class BitCounter {


    public int BinaryConvert(int[] a) {



        int check=0;

        for(int i=0;i<a.length-1;i++)
        {
            for(int j=i+1;j<a.length;j++)
            {


                        int ExOr=a[i]^a[j];



                        check+=getBinary(ExOr);




            }
        }

        return check;

    }



    public int getBinary(int a)
    {
            int sum=0;
        //int j=0;
        while (a!=0)
        {
            sum+=a%2;
            a=a/2;


        }

        return sum*2;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        BitCounter bc = new BitCounter();

        int i=sc.nextInt();

        while(i!=0)
        {
            int a=sc.nextInt();
            int arrIn[]=new int[a];
            for(int j=0;j<a;j++){

                arrIn[j]=sc.nextInt();
            }

           int check= 0;
            check=bc.BinaryConvert(arrIn);

            System.out.println(check);
            i--;



        }


    }
}

