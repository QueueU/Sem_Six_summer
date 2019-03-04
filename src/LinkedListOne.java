import java.util.Scanner;

public class LinkedListOne {
    Node head;
    public int size;
    Scanner input = new Scanner(System.in);

    public void insert() {

        if (size > 0) {
            int data = 0;
            System.out.println("Enter Data ");
            data = input.nextInt();
            Node node = new Node();
            node.data = data;
            node.next = null;

            if (head == null) {
                head = node;
                size--;
            } else {
                Node n = head;
                while (n.next != null) {
                    n = n.next;

                }

                n.next = node;
                size--;
            }

        }

        else
        {
            System.out.println("Stack is overFlow");
        }
    }


    public void delete()
    {

        Node node=head;
        if(head==null)
        {
            System.out.println("Stack is underflow");

        }

        else
        {
            while(node.next.next != null)
            {
                    node=node.next;
            }
            //System.out.println("data going to delete2"+node.next.data);
            node.next=null;

            size++;
        }
    }

    public void show() {
        Node node = head;

        while (node.next != null) {
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println(node.data);

    }

    public static void main(String args[]) {

        LinkedListOne li = new LinkedListOne();
        System.out.println("Enter stack Size");
        li.size = li.input.nextInt();
        int ch = 0;
        while(ch!=4)
        {
            System.out.println("1.insert data");
            System.out.println("2.delete data");
            System.out.println("3.view Data");
            System.out.println("4.exit");


            ch=li.input.nextInt();
            switch (ch) {
                case 1:
                    li.insert();
                    break;
                case 2:
                    li.delete();
                    break;
                case 3:
                    li.show();
                    break;

                default:
                    System.out.print("invalied Choise");
                    break;
            }

        }

    }


}

