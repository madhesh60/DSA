package IMPLEMENT;

public class LinkedList{
    class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
        }
        Node(int data,Node next)
        {
            this.data=data;
            this.next=next;
        }
    }
    Node head;
    Node tail;
    int size;
    LinkedList(){
        size=0;
    }
    void insertFirst(int value)
    {
        Node node=new Node(value);
        node.next=head;
        if(head==null)
            tail=node;
        head=node;
        size++;
    }
    void insertLast(int value)
    {
        if(tail==null)
        {
            insertFirst(value);
            return;
        }

        Node node=new Node(value);
        tail.next=node;
        tail=node;
        size++;
    }
    void display()
    {
        Node curr=head;
        while(curr!=null)
        {
            if(curr.next==null)
                System.out.print(curr.data+"->"+"NULLLLLLL");
            else
            System.out.print(curr.data+"->");
            curr=curr.next;
        }
    }
    void insert(int value,int pos,Node head) {
        Node node=new Node(value);
        Node curr=head;
        for(int i=0;i<pos-1;i++)
            curr=curr.next;
        node.next=curr.next;
        curr.next=node;
        size++;
    }
    void deleteFirst()
    {
        if(head==null) {
            System.out.println("DELETION NOT POSSIBLE");
            return;
        }
        head=head.next;
    }
    void deleteLast()
    {
        if(head==null) {
            System.out.println("DELETION NOT POSSIBLE");
            return;
        }

       Node curr=head;
       while(curr.next!=tail)
       {
           curr=curr.next;
       }
       tail=curr;
    }
    void delete(int pos) {
        Node curr=head;
        for(int i=0;i<pos-1;i++)
            curr=curr.next;
        curr.next=curr.next.next;
    }

}
