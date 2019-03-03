package AVLTree;

import AVLTree.Node;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class AVLClient {
    Node root;
    Scanner input = new Scanner(System.in);

    public Node insertNode(int data, Node rootNode) {
        if (rootNode == null) {
            Node n = new Node(data);
            return n;
        }
        if (data < rootNode.data) {
            rootNode.left = this.insertNode(data, rootNode.left);
        } else {
            rootNode.right = this.insertNode(data, rootNode.right);
        }
        rootNode.height = Math.max(this.height(rootNode.left), this.height(rootNode.right)) + 1;
        return rootNode;
    }

    public Node LeftRotation(Node n) {
        Node b = n.right;
        Node e = b.left;
        b.left = n;
        n.right = e;
        n.height = Math.max(this.height(n.left), this.height(n.right)) + 1;
        b.height = Math.max(this.height(b.left), this.height(b.right)) + 1;
        return b;
    }

    public Node RightRotation(Node n) {
        Node b = n.left;
        Node t3 = b.right;
        b.right = n;
        n.left = t3;
        n.height = Math.max(this.height(n.left), this.height(n.right)) + 1;
        b.height = Math.max(this.height(b.left), this.height(b.right)) + 1;
        return b;
    }

    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public int bf(Node node) {
        if (node == null) {
            return 0;
        }
        return this.height(node.left) - this.height(node.right);
    }

    public void nodeDisplay(Node node) {
        if (node == null) {
            return;
        }
        Object str = "";
        str = node.left == null ? (String)str + "." : (String)str + node.left.data;
        str = (String)str + "-->" + node.data + "<--";
        str = node.right == null ? (String)str + "." : (String)str + node.right.data;
        System.out.println((String)str);
        this.nodeDisplay(node.left);
        this.nodeDisplay(node.right);
    }

    public Node splayTree(int data, Node SNode) {
        if (SNode == null) {
            return SNode;
        }
        if (SNode.data == data) {
            return SNode;
        }
        if (data < SNode.data) {
            if (SNode.left == null) {
                return SNode;
            }
            if (data < SNode.left.data) {
                System.out.println("SNode.left.left" + SNode.left.left.data);
                SNode.left.left = this.splayTree(data, SNode.left.left);
                System.out.println("// Zig-Zig (Left Left) /n");
                this.nodeDisplay(SNode);
                SNode = this.RightRotation(SNode);
            } else if (SNode.left.data < data) {
                SNode.left.right = this.splayTree(data, SNode.left.right);
                if (SNode.left.right != null) {
                    System.out.println("Zig-Zag (Left Right) /n");
                    this.nodeDisplay(SNode);
                    SNode.left = this.LeftRotation(SNode.left);
                }
            }
            return SNode.left == null ? SNode : this.RightRotation(SNode);
        }
        if (SNode.right == null) {
            return SNode;
        }
        if (SNode.right.data > data) {
            SNode.right.left = this.splayTree(data, SNode.right.left);
            if (SNode.right.left != null) {
                System.out.println("Zag-Zig (Right Left) /n");
                this.nodeDisplay(SNode);
                SNode.right = this.RightRotation(SNode.right);
            }
        } else if (SNode.right.data < data) {
            SNode.right.right = this.splayTree(data, SNode.right.right);
            System.out.println("Zag-Zag (Right Right)  /n ");
            this.nodeDisplay(SNode);
            SNode = this.LeftRotation(SNode);
        }
        return SNode.right == null ? SNode : this.LeftRotation(SNode);
    }

    public static void main(String[] args) {
        AVLClient av = new AVLClient();
        int ch = 0;
        block5 : while (ch != 4) {
            System.out.println("1. Input Data");
            System.out.println("2. Display Data");
            System.out.println("3.Slpay Search Data");
            System.out.println("4.Exit");
            System.out.println("Enter Input");
            ch = av.input.nextInt();
            switch (ch) {
                case 1: {
                    System.out.println("Enter Data");
                    int data = av.input.nextInt();
                    av.root = av.insertNode(data, av.root);
                    continue block5;
                }
                case 2: {
                    av.nodeDisplay(av.root);
                    continue block5;
                }
                case 3: {
                    System.out.print("Enter Search Value :");
                    int data1 = av.input.nextInt();
                    av.root = av.splayTree(data1, av.root);
                    av.nodeDisplay(av.root);
                    continue block5;
                }
            }
            System.out.println("Invalied Input");
        }
    }
}
