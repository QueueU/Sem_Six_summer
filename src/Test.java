import java.util.Arrays;

public class Test {

    public static void main(String args[])
    {
        String arr[]={"1","56"};
        String aa= Arrays.toString(arr);
        System.out.println("here:"+aa);
        char io[]=aa.toCharArray();
        System.out.println(io[0]);
    }
}
