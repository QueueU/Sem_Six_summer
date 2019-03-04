import java.util.Scanner;

//Java implementation to find maximum length
//substring which is not palindrome
public class TestClass
{

    static Boolean isPalindrome(String str)
    {
        int n = str.length();


        for (int i = 0; i < n/2; i++)
            if (str.charAt(i) != str.charAt(n-i-1))
                return false;


        return true;
    }


    static int maxLen(String str)
    {
        int len = str.length();
        char ch = str.charAt(0);


        int i = 1;
        for (i = 1; i < len; i++)
            if(str.charAt(i) != ch)
                break;


        if (i == len)
            return 0;
        if (isPalindrome(str))
            return len-1;


        return len;
    }


    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String str = sc.next();
        System.out.println("Maximum Length = "
                + maxLen(str));
    }
}

