import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestSubseq {



    public void longSub(char s1[],char s2[])
    {
        int arr[][]=new int[s1.length+1][s2.length+1];


        //Arrays.fill(arr,0);

        int max=0;
        int j=0;

        System.out.print(arr[0][0]);
        for(int i=1;i<s1.length+1;i++)
        {
            for(j=1;j<s2.length+1;j++)
            {
                System.out.println("Check "+ s1[i-1] + "Check 2"+s2[j-1]);
                if(s1[i-1]==s2[j-1])
                {
                    arr[i][j]=arr[i-1][j-1]+1;
                }
                else
                {
                    arr[i][j]=Math.max(arr[i-1][j],arr[i][j-1]);
                }
                System.out.println("Values Store " + arr[i][j]);
                if(arr[i][j] > max)
                {
                    max=arr[i][j];

                }
            }





        }


        System.out.println("Ans is"+max);








    }



    public static void main(String args[])
    {

        String str1 = "ABCDGHLQR";
        String str2 = "AEDPHR";



        LongestSubseq lsc=new LongestSubseq();

        lsc.longSub(str1.toCharArray(),str2.toCharArray());



    }

}
