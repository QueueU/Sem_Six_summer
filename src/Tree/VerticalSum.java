package Tree;

import java.util.*;

public class VerticalSum {

    NodeTwo root=null;

    static TreeMap<Integer,Integer> ValueSet=new TreeMap<Integer,Integer>();
  static List<Integer> key=new ArrayList<>();
   static List<Integer> value=new ArrayList<>();
   static List<Integer> Sum=new ArrayList<>();

int pointer=0;
int secondPointer=0;
boolean flag=false;
    public void insert(int data)
    {
       root= InsertNode(root,data,0,0);
    }


   public NodeTwo InsertNode(NodeTwo node,int data,int Check,int PriviousHD)
   {


     // Node n=
         if(node==null)
         {
            //node=new NodeTwo(data);
              //  System.out.println("Data "+node.data+"  inserted");


                if(Check==0)
                {
                    //secondPointer=pointer;
                    node=new NodeTwo(data,PriviousHD);
                   flag=ValueSet.containsKey(node.HD);
                   if(flag)
                   {
                       ValueSet.put(node.HD,ValueSet.get(node.HD)+node.data);
                   }
                   else
                   {
                       ValueSet.put(node.HD,node.data);
                   }
                    key.add(node.HD);
                    value.add(node.data);
                }
                else if(Check==1)
                {
                    //secondPointer=pointer-1;
                    node=new NodeTwo(data,PriviousHD-1);
                    flag=ValueSet.containsKey(node.HD);
                    if(flag)
                    {
                        ValueSet.put(node.HD,ValueSet.get(node.HD)+node.data);
                    }
                    else
                    {
                        ValueSet.put(node.HD,node.data);
                    }
                    key.add(node.HD);
                    value.add(node.data);
                }
                else if(Check==2) {

                    node =new NodeTwo(data,PriviousHD+1);
                    flag=ValueSet.containsKey(node.HD);
                    if(flag)
                    {
                        ValueSet.put(node.HD,ValueSet.get(node.HD)+node.data);
                    }
                    else
                    {
                        ValueSet.put(node.HD,node.data);
                    }
                    key.add(node.HD);
                    value.add(node.data);

                }




         }

         else if(node.data <= data)
         {
             int HD=node.HD;

             System.out.println("Check privious Node Data "+node.data);
             System.out.println("Check Pribious Node Hd "+node.HD);
            node.right= InsertNode(node.right,data,2,HD);
         }
         else
         {
             System.out.println("Check privious Node Data "+node.data);
             System.out.println("Check Pribious Node Hd "+node.HD);
            node.left= InsertNode(node.left,data,1,node.HD);
         }


        return node;
   }

   public void inorder(NodeTwo node)
   {

      if(node!=null)
      {
         inorder(node.left);
        // System.out.println("I am hare only");
         System.out.println(node.data);
         inorder(node.right);
      }

   }


    public void SumOfVertical()
    {
           for(int i=0;i<key.size();i++){
               Sum.add(i,value.get(i));
               for(int j=1;j<key.size();j++) {

                   if(j==i)
                   {
                       continue;
                   }
                   if (key.get(i) == key.get(j)) {
                       Sum.add(i,Sum.get(i) + value.get(j));


                   }
               }
           }



    }



   public static void main(String args[])
   {


               VerticalSum vs=new VerticalSum();
               vs.insert(45);
       vs.insert(21);
       vs.insert(65);
       vs.insert(16);
       vs.insert(22);
       vs.insert(8);vs.insert(55);
       vs.inorder(vs.root);

      // vs.SumOfVertical(vs.root,0);

       System.out.println("Keys");
      key.forEach((i) ->{
          System.out.println(i);
      });

      System.out.println("Values");

       for (Integer integer : value) {
           System.out.println(integer);

       }

       vs.SumOfVertical();
     /*
       System.out.println("Sum");

       for (Integer integer : Sum) {
           System.out.println(integer);

       }   */


     System.out.println("Map Stream");

     System.out.println(VerticalSum.ValueSet);
   }

}
