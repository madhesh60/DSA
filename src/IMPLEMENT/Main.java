package IMPLEMENT;

public class Main {
    public static void main(String[] args) throws Exception {
//        LinkedList mylist=new LinkedList();
//        mylist.insertFirst(3);
//        mylist.insertFirst(2);
//        mylist.insertFirst(1);
//        mylist.insertLast(4);
//        mylist.insertLast(5);
//        mylist.display();
//        mylist.delete(2);
//        mylist.display();
//        mylist.deleteFirst();
//        mylist.display();
//
//        Stack st=new Stack(5);
//        st.push(1);
//        st.push(2);
//        st.push(3);
//        st.push(4);
//        st.push(5);
//        System.out.println(st.peek());
//        System.out.println(st.pop());
//        st.display();
//        System.out.println(st.peek());
//        System.out.println(st.pop());
//        st.display();
//        System.out.println(st.peek());
//        System.out.println(st.pop());
//        st.display();
//        Heap hp=new Heap();
//        hp.insert(1);
//        hp.insert(2);
//        hp.insert(4);
//        hp.insert(3);
//        hp.insert(5);
//        System.out.println(hp.remove());
//        System.out.println(hp.HeapSort());
//        hp.insert(1);
//        System.out.println(hp.HeapSort());
//        //hp.downheap(0); DOWNHEAP IS A METHOD FOR INNER FOR CLASS WE CANT MODIFY SINCE IT IS PRIVATE
//        BST bins=new BST();
//        bins.insert(5);
//        bins.insert(3);
//        bins.insert(8);
//        bins.insert(1);
//        bins.insert(4);
//        bins.insert(7);
//        bins.insert(9);
//        bins.display();
//        CustomList<Integer> mylist=new CustomList<>();
//        mylist.add(1);
//        mylist.add(2);
//        mylist.add(3);
//        mylist.add(4);
//        mylist.set(4,5);
//        mylist.remove(3);
//        System.out.println(mylist.size());
//        System.out.println(mylist.get(0));
//        System.out.println(mylist);

//        HashMap<String,Integer> map =new HashMap<>();
//        map.put("Sydney sweeney",1);
//        map.put("HAILEE",2);
//        map.put("KATH WINNICK",3);
//        map.print();
//        map.remove("KATH WINNICK");
//        System.out.println(map.get("Sydney sweeney"));
//        map.print();
//        AVL myavl=new AVL();
//
//        myavl.insert(1);
//        myavl.insert(2);
//        myavl.insert(3);
//        myavl.insert(4);
//        myavl.insert(5);
//        myavl.insert(6);
//        myavl.insert(7);
//        myavl.insert(8);
//        myavl.display();

        int[] arr={1,2,3};
        Segment myseg=new Segment(arr);
        System.out.println(myseg.Query(1,2));
    }
}
