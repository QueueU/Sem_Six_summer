package AVLTree;


public class Node {
    int data;
    Node right;
    Node left;
    int height;

    public Node(int data) {
        this.data = data;
        this.height = 1;
    }
}
