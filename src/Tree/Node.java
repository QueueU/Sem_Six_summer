package Tree;

public class Node {
    int key;
    String name;
    int count=1;
    public static int GlobalCount=0;
    Node leftChild;
    Node rightChild;
    static int arr[];
   public static int ii=0;

    Node(int key)
    {this.key=key;
   // this.name=name;

    }

    public String toString()
    {
        return name + " has the key " + key + " Count :" + count ;
    }

    public  static int getGlobalCount()

    {
        return GlobalCount;
    }
}
