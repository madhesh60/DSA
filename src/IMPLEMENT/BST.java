package IMPLEMENT;

public class BST {
    Node root;
    BST()
    {
        root=null;
    }
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
    public void insert(int value)
    {
        root=insert(value,root);
    }
    private Node insert(int value,Node node)
    {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if(value<node.data)
            node.left=insert(value,node.left);
        if(value>node.data)
            node.right=insert(value,node.right);

        return node;
    }
    void display()
    {
        display(root,"The root is:");
    }
    private void display(Node node,String details)
    {
        if(node==null)
            return;
        System.out.println(details+node.data);
        display(node.left,"The Left child of"+node.data+":");
        display(node.right,"The Right child of"+node.data+":");
    }

}
