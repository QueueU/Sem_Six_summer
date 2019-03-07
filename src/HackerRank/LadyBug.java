package HackerRank;


import java.util.ArrayList;
import java.util.Scanner;

public class LadyBug {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        //boolean check[][] = new boolean[a][2];
        boolean check = false;
        for(int k=0;k<a;k++) {
            int b = sc.nextInt();

            String str=sc.next();


            char ch[] = str.toCharArray();
            //int a[]=new int[];

            ArrayList<Character> al = new ArrayList<Character>();


            for (int i = 0; i < ch.length; i++) {
                al.add(ch[i]);
            }





    /*
                    if (k == '_') {
                    check[0] = true;
                    continue;
                }
                if (al.contains(k)) {
                    check[0] = true;
                    al.add(k);
                } else {
                    System.out.println(k + "Hit");
                    check[1]= false;
                    al.add(k);

                }

*/
            //System.out.println(al.size());
            //System.out.println((al.get(0)!='_') && al.size()==1);
            int flag=0;
            if (al.contains('_')) {
                for (int i = 0; i < al.size(); i++) {


                    if((al.get(0)!='_') && al.size()==1)
                    {
                        //System.out.println("hit");
                        check=false;
                        break;
                    }
                     if (al.get(i).equals('_')) {
                        check = true;
                        continue;
                    }


                    for (int j = i+1; j < al.size(); j++) {
                        if (i == j) {
                            continue;
                        } else if (al.get(i) == al.get(j)) {

                            // System.out.println(al.get(i) + " : "+i+" ::: "+ j +" : " +al.get(j) );


                            // a[Integer.parseInt(String.valueOf(al.get(i)))]+=1;
                            al.remove(j);
                            // System.out.println("Value of a :"+al.get(i)+" :: "+a[Integer.parseInt(String.valueOf(al.get(i)))]);

                            check = true;
//                            j--;

                            continue;

                        } else {
                            check = false;
                        }
                    }

                    if (check == false) {
                        break;
                    }


                    //a[Integer.parseInt(String.valueOf(al.get(i)))] += 1;


                }
            } else {
                for (int i = 0; i < al.size() ; i++) {
                    //System.out.println("Else" + check);

                    flag=0;

                    for (int j = i + 1; j < al.size()-1; j++) {

                        if(i==j)
                        {
                            System.out.println("Hit");
                            continue;
                        }
                        System.out.println(i + "  " + j);
                        if (al.get(i).equals(al.get(j))) {
                            System.out.println("al[i]: " + al.get(i));
                            al.remove(j);
                            check = true;
                            j--;
                            flag=0;
                            continue;

                        } else if(flag==0) {
                            check = false;
                            flag=1;
                        }
                        else if(flag==1)
                        {
                            check=false;
                            break;
                        }

                    }
                    System.out.println("check" + check);
                    if (!check) {
                        break;
                    }
                    if((i+1)==al.size()){
                        check = true;
                        break;
                    }
                    /*if(al.get(i).equals(al.get(i+1)) || al.get(i).equals(al.get(i-1))){
                        if(i==(al.size()-2)){
                            check = true;
                        }
                        continue;
                    }
                    check = false;*/
                }
            }
            if (check) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }






        }
        /*
            for(int i=0;i<a;i++)
            {
                if((check[i][0] && check[i][1]))
                {
                    System.out.println("YES");
                }
                else
                {
                    System.out.println("NO");
                }
            }
            */


    }
}
