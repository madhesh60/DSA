package IMPLEMENT;

public class DoublyList {
    Node head;
    Node tail;
    int size;
    DoublyList(){
        size=0;
    }
    class Node{
        int data;
        Node next;
        Node prev;
        Node(int data)
        {
            this.data=data;
        }
        Node(int data,Node next,Node prev)
        {
            this.data=data;
            this.next=next;
            this.prev=prev;
        }
    }
    void insertFirst(int value)
    {
        Node node=new Node(value);
        node.next=head;
        if(head!=null)
            head.prev=node;
        else
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
        node.prev=tail;
        tail.next=node;
        tail=node;
        size++;
    }
    public void display() {
        Node node = tail;
        //Node last = null;
        while (node != null) {
            System.out.print(node.data + " -> ");
            //last = node;
            node = node.prev;
        }
        System.out.println("END");
    }

        void insert(int value, int pos) {
        Node node=new Node(value);
        Node curr=head;
        for(int i=0;i<pos-1;i++)
            curr=curr.next;
        node.prev=curr;
        node.next=curr.next;
        if (curr.next != null)
            curr.next.prev=node;
        curr.next=node;
        size++;
        if(pos==size-1)
            tail=node;
    }
    void deleteFirst()
    {
        if(head==null) {
            System.out.println("DELETION NOT POSSIBLE");
            return;
        }
        head=head.next;
        head.prev=null;
        size--;

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
        curr.next=null;
        tail=curr;
        size--;
    }
    void delete(int pos) {
        if(pos==size-1)
        {
            deleteLast();
            return;
        }
        Node curr=head;
        for(int i=0;i<pos-1;i++)
            curr=curr.next;
        curr.next=curr.next.next;
        curr.next.prev=curr;
        size--;
    }

}
