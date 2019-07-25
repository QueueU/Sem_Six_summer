import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class MeanMedian  {

    public static void main(String args[]) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int Test=Integer.parseInt(br.readLine());

        while(Test!=0)
        {

            int arSize=Integer.parseInt(br.readLine());
            String str[]=br.readLine().split(" ");

            int arr[]=new int[str.length];
            //ArrayList<Integer> al=new ArrayList<>();
            //TreeSet<Integer> ts=new TreeSet<>();
            int sum=0;
            int min=Integer.parseInt(str[0]);
            for(int i=0;i<str.length;i++)
            {
                arr[i]=Integer.parseInt(str[i]);
               // al.add(arr[i]);
                //ts.add(arr[i]);
                sum+=arr[i];

                if(arr[i] < min)
                {
                    min=arr[i];
                }
            }
            double avg=(sum/(arr.length));


                int arr2[]=new int[10000];

            for(int i=0;i<arr.length;i++)
            {
                arr2[arr[i]]++;
            }

            int max=0;
            int k=0;
            int mode=0;
            for(int i=0;i<10000;i++)
            {
                if(arr2[i] > max)
                {
                    max=arr2[i];
                    k=i;
                }
            }

            if(max==1)
            {
                mode=min;
            }
            else
            {
                mode=k;
            }


            Arrays.sort(arr);

            double median=arr[(arr.length-1)/2];

            System.out.println("Min "+avg);
            System.out.println("Mode "+mode );
            System.out.println("Median "+median);

            Test--;
        }
    }
}
