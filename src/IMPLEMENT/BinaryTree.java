package IMPLEMENT;

import java.util.Scanner;

public class BinaryTree{
        class Node{
            int data;
            Node right;
            Node left;
            Node(int data)
            {
                this.data=data;
                left=right=null;
            }
        }
    Node root;
    BinaryTree()
    {
        root=null;
    }
        public void insert(Scanner in) {
        System.out.println("Enter the root Node: ");
        int value = in.nextInt();
        root = new Node(value);
        insert(in,root);
    }

    void insert(Scanner in,Node node)
        {
            System.out.println("Do You Want to insert left of node"+node.data);
            boolean left=in.nextBoolean();
            if(left)
            {
                System.out.println("Enter the value of the left of " + node.data);
                int value=in.nextInt();
                Node newNode=new Node(value);
                node.left=newNode;
                insert(in,node.left);
            }
            System.out.println("Do You Want to insert right of node"+node.data);
            boolean right=in.nextBoolean();
            if(right) {
                System.out.println("Enter the value of the right of " + node.data);
                int value = in.nextInt();
                Node newNode = new Node(value);
                node.right = newNode;
                insert(in, node.right);
            }
        }
}