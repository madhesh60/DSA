package IMPLEMENT;

public class AVL {
    Node root;
    class Node{
        int data;
        Node left;
        Node right;
        int height;
        Node(int data)
        {
            this.data=data;
            left=right=null;
        }
    }
    AVL()
    {
        root=null;
    }
    int getBalance(Node node)
    {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }
    int getHeight(Node node) {
        return node == null ? -1 : node.height;
    }
    public void insert(int value)
    {
        root=insert(value,root);
    }
    private Node insert(int value,Node node)
    {
        if(node==null)
        {
            return new Node(value);
        }
        if(value<node.data)
            node.left=insert(value,node.left);
        else if(value>node.data)
            node.right=insert(value,node.right);

        node.height=Math.max(getHeight(node.left),getHeight(node.right))+1;
        return balance(node);
    }
    private Node balance(Node node) {
        int balanceFactor = getBalance(node);

        // Left heavy
        if (balanceFactor > 1) {
            // Left-Right case
            if (getBalance(node.left) < 0) {
                node.left = LeftRotate(node.left);
            }
            return RightRotate(node);
        }

        // Right heavy
        if (balanceFactor < -1) {
            // Right-Left case
            if (getBalance(node.right) > 0) {
                node.right = RightRotate(node.right);
            }
            return LeftRotate(node);
        }

        return node;
    }

    private Node LeftRotate(Node node)
    {
        Node c=node.right;
        Node t=c.left;

        c.left=node;
        node.right=t;

        node.height=Math.max(getHeight(node.left),getHeight(node.right))+1;
        c.height=Math.max(getHeight(c.left),getHeight(c.right))+1;


        return c;
    }
    private Node RightRotate(Node node)
    {
        Node c=node.left;
        Node t=c.right;

        c.right=node;
        node.left=t;


        node.height=Math.max(getHeight(node.left),getHeight(node.right))+1;
        c.height=Math.max(getHeight(c.left),getHeight(c.right))+1;

        return c;
    }
    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }
    public void display() {
        display(this.root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.data);
        display(node.left, "Left child of " + node.data + " : ");
        display(node.right, "Right child of " + node.data+ " : ");
    }
}
