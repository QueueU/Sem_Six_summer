package Tree;

import java.util.Arrays;
import java.util.Scanner;

public class BST {

    Scanner input = new Scanner(System.in);
    Node root;
    NodeTwo head;



    public int getLevel(Node root, int data, int i) {

        if (root == null) {
            return 0;
        }
        if (root.key == data) {
            return i;
        }

        int downlevel = getLevel(root.leftChild, data, i + 1);
        if (downlevel != 0) {
            return downlevel;
        }

        downlevel = getLevel(root.rightChild, data, i + 1);

        return downlevel;

    }

    public void addNode(int key) {



        Node newNode = new Node(key);

        if (root == null) {

            Node.GlobalCount += 1;
            root = newNode;

        } else {



            Node focusNode = root;

            Node parent;

            while (true) {

                parent = focusNode;

                if (key == focusNode.key) {
                    newNode.count += 1;
                    Node.GlobalCount += 1;
                }
                if (key < focusNode.key) {

                    focusNode = focusNode.leftChild;

                    if (focusNode == null) {

                        parent.leftChild = newNode;
                        Node.GlobalCount += 1;
                        return;

                    }

                } else {

                    focusNode = focusNode.rightChild;

                    if (focusNode == null) {

                        parent.rightChild = newNode;
                        Node.GlobalCount += 1;
                        return;

                    }

                }

            }
        }

    }

    public void inOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {

            inOrderTraverseTree(focusNode.leftChild);

            System.out.println(focusNode);

            inOrderTraverseTree(focusNode.rightChild);

        }
    }

    public Node findNode(int key) {

        Node focusNode = root;

        while (focusNode.key != key) {

            if (key < focusNode.key) {

                focusNode = focusNode.leftChild;

            } else {

                focusNode = focusNode.rightChild;

            }

            if (focusNode == null) {
                return null;
            }

        }

        return focusNode;

    }

    public int height(Node FocusNode) {
        if (FocusNode == null) {
            return 0;
        } else {
            int ldepth = height(FocusNode.leftChild);
            int rdepth = height(FocusNode.rightChild);

            if (ldepth > rdepth) {
                return (ldepth + 1);
            } else {
                return (rdepth + 1);
            }
        }
    }


    public void TreeToArray(Node focusNode) {


        if (focusNode != null) {

            TreeToArray(focusNode.leftChild);

            System.out.println(focusNode);
            Node.arr[Node.ii] = focusNode.key;
            Node.ii++;

            TreeToArray(focusNode.rightChild);

        }


    }
    public void GetList(Node focusNode) {


        if (focusNode != null) {

            GetList(focusNode.leftChild);

            System.out.println(focusNode);
            InsertIntoList(focusNode.key);

            GetList(focusNode.rightChild);

        }


    }

    public void InsertIntoList(int data)
    {
        NodeTwo new_node = new NodeTwo(data,5);
        new_node.data=data;

        new_node.next = head;


        head = new_node;
    }

    public void LinkedListTra(NodeTwo n)
    {
        if(n==null)
            return;

        System.out.println(n.data);

        LinkedListTra(n.next);
    }

    public boolean remove(int key) {


        Node focusNode = root;
        Node parent = root;


        boolean isItALeftChild = true;


        while (focusNode.key != key) {

            parent = focusNode;


            if (key < focusNode.key) {

                isItALeftChild = true;


                focusNode = focusNode.leftChild;

            } else {


                isItALeftChild = false;


                focusNode = focusNode.rightChild;

            }


            if (focusNode == null)
                return false;

        }


        if (focusNode.leftChild == null && focusNode.rightChild == null) {


            if (focusNode == root)
                root = null;


            else if (isItALeftChild)
                parent.leftChild = null;


            else
                parent.rightChild = null;

        } else if (focusNode.rightChild == null) {

            if (focusNode == root)
                root = focusNode.leftChild;

            else if (isItALeftChild)
                parent.leftChild = focusNode.leftChild;


            else
                parent.rightChild = focusNode.leftChild;

        } else if (focusNode.leftChild == null) {

            if (focusNode == root)
                root = focusNode.rightChild;


            else if (isItALeftChild)
                parent.leftChild = focusNode.rightChild;



            else
                parent.rightChild = focusNode.rightChild;

        } else {

            Node replacement = getReplacementNode(focusNode);


            if (focusNode == root)
                root = replacement;

            else if (isItALeftChild)
                parent.leftChild = replacement;

            else
                parent.rightChild = replacement;

            replacement.leftChild = focusNode.leftChild;

        }

        return true;

    }

    public Node getReplacementNode(Node replacedNode) {

        Node replacementParent = replacedNode;
        Node replacement = replacedNode;

        Node focusNode = replacedNode.rightChild;

        while (focusNode != null) {

            replacementParent = replacement;

            replacement = focusNode;

            focusNode = focusNode.leftChild;

        }

        if (replacement != replacedNode.rightChild) {

            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;

        }

        return replacement;

    }

    public void GetKeys() {
        int key1, key2;
        System.out.println("Enter First key");
        key1 = input.nextInt();
        System.out.println("Enter Second Key");
        key2 = input.nextInt();

        for (int i = 0; i < Node.arr.length; i++) {

            if ((key1 <= Node.arr[i] && key2 >= Node.arr[i])) {
                System.out.println(Node.arr[i]);
            }
        }
    }

    public Node RotateFlip(Node root) {
        if (root == null) {
            return root;
        }
        if (root.leftChild == null && root.rightChild == null) {
            return root;
        }

        Node Flip = RotateFlip(root.leftChild);

        root.leftChild.leftChild = root.rightChild;
        root.leftChild.rightChild = root;
        root.leftChild = root.rightChild = null;
        return Flip;
        //inOrderTraverseTree(Flip);
    }

    public static void main(String args[]) {
        int key;
        String name;
        BST li = new BST();

        int ch = 0;
        while (ch != 11) {
            System.out.println("1.insert key");
            System.out.println("2.delete key");
            System.out.println("3.view key");
            System.out.println("4.Find Ele");
            System.out.println("5.Height Of tree");
            System.out.println("6.Level of Node");
            System.out.println("7.Flip Tree");
            System.out.println("8.Tree to Array");
            System.out.println("9.GetKeys");
            System.out.println("10.LinkList");
            System.out.println("11.exit");

            ch = li.input.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter Name :");
                    name = li.input.next();
                    System.out.println("Enter Key First:");
                    key = li.input.nextInt();

                    li.addNode(key);

                    break;
                case 2:
                    System.out.println("Enter key");
                    key = li.input.nextInt();

                    // Boolean temp=li.remove(key);

                    System.out.println(li.remove(key));
                    if(li.remove(key))
                    {
                        Node.GlobalCount--;
                    }
                    // li.inOrderTraverseTree(temp);

                case 3:
                    // li.show();
                    li.inOrderTraverseTree(li.root);
                    break;

                case 4:
                    System.out.println("Enter Key First:");
                    key = li.input.nextInt();
                    System.out.println("Here is key " + li.findNode(key));
                    break;

                case 5:
                    int height = li.height(li.root);
                    System.out.println("Height of Tree is : " + height);
                    break;

                case 6:
                    System.out.println("Enter key");
                    key = li.input.nextInt();
                    System.out.println(li.getLevel(li.root, key, 1));
                    break;

                case 7:
                    li.RotateFlip(li.root);

                    break;

                case 8:
                    System.out.println(Node.GlobalCount);

                    Node.arr=new int[Node.GlobalCount];
                    System.out.println(Node.arr.length);
                    li.TreeToArray(li.root);

                    System.out.println(Arrays.toString(Node.arr));
                    break;

                case 9:
                    li.GetKeys();
                    break;
                case 10:
                        li.GetList(li.root);
                        li.LinkedListTra(li.head);
                        break;
                case 11:
                    System.exit(0);
                default:
                    System.out.print("invalied Choise");
                    break;
            }

        }

    }
}