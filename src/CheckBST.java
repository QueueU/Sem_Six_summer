import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckBST {



    class Node{

        Node right;
        Node left;
        int data;

        Node(int data)
        {
            this.data=data;
            this.left=null;
            this.right=null;

        }
    }


Node root;



    public Node insertNode(Node node,int data)
    {

        if(node==null)
        {
            return new Node(data);
        }
        else
        {
            Node cur;

            if(node.data > data)
            {
                cur=insertNode(node.left,data);
                node.left=cur;
            }
            else
            {
                cur=insertNode(node.right,data);
                node.right=cur;
            }
        }

        return root;


    }
    public static void main(String args[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));


        int n=Integer.parseInt(br.readLine());


        int a[]=new int[n];


            CheckBST cb=new CheckBST();

        for(int i=0;i<n;i++)
        {

            a[i]=Integer.parseInt(br.readLine());
            cb.insertNode(cb.root,a[i]);

        }



         System.out.println()




    }




}
