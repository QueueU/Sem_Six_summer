package Circuler_queue;

import java.util.Scanner;

public class Cir_Queue {
    int size = 5;
    int front = -1, rear = -1;
    Scanner sc = new Scanner(System.in);
    int q[] = new int[size];



    public static void main(String args[]) {
        Cir_Queue q = new Cir_Queue();
        int ch = 0;


        while (ch != 4) {
            System.out.println("Enter your Choise");
            System.out.println("1.Insert");
            System.out.println("2.Delete");
            System.out.println("3.Show");
            System.out.println("4.Exit");
            System.out.println();
            ch = q.sc.nextInt();

            switch (ch) {
                case 1:
                    q.insert();
                    break;
                case 2:
                    q.delete();
                    break;
                case 3:
                      q.Display();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("invalid choise");
                    break;


            }


        }


    }

    public void insert() {
        int item;
        System.out.println("Enter elements \n");
        item=sc.nextInt();

        if((rear+1)%size == front)
        {
            System.out.println("OverFlow");
        }
        else if(front == -1 && rear == -1)
        {
            front=0;
            rear=0;
        }
        else if(front == size-1 && front !=0)
        {
            rear=0;

        }
        else
        {
            rear=(rear+1)%size;
        }
        q[rear]=item;
        System.out.print("Value Inserted");
    }

    public void delete()
    {
        int item;
        if(front == -1 && rear ==-1)
        {
            System.out.println("\n UnderFlow");

        }
        else if(front ==rear)
        {
            front =-1;
            rear= -1;
        }
        else if(front == size-1)
        {
            front =0;
        }
        else
        {
            front=front+1;
        }
    }


    public void Display()
    {
        int i;
        if(front == -1)
        {
            System.out.println("\n Circular Queue is Empty");

        }
        else
        {
            i=front;
            System.out.println("\n Circular Queue Elements are : \n");
            if (front <=rear) {
                while (i <= rear) {
                    System.out.println(q[i++] + " " + front + " " + rear);
                }
            }
                else {
                    while (i <=size -1)
                    {
                        System.out.println(q[i++] + " " + front + " " + rear);

                    }
                    i=0;

                    while(i<=size-1)
                    {
                        System.out.println(q[i++] + " " + front + " " + rear);
                    }

            }

        }
    }
}
