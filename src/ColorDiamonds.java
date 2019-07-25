import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ColorDiamonds {

    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int test=Integer.parseInt(br.readLine());

        while(test!=0)
        {

            String Str[]=br.readLine().split(" ");
            int NumOfBox=Integer.parseInt(Str[0]);
            int NumOfDia=Integer.parseInt(Str[1]);


            test--;
        }
    }
}
