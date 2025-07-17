package IMPLEMENT;
import java.util.LinkedList;


//NODE FOR EACH BUCKET-STORES KEY-VALUE IN A SINGLE PLACE
class Node<K,V>{
    K key;
    V value;
    Node(K key,V value)
    {
        this.key=key;
        this.value=value;
    }
}

//MAIN IMPLEMENT OF HASHMAP
public class HashMap<K,V>{
    private final int size=10;
    private LinkedList<Node<K,V>>[] buckets;

    HashMap()
    {
        buckets=new LinkedList[size];
        for(int i=0;i<size;i++)
        {
            buckets[i]=new LinkedList<>();
        }
    }


    //GET INDEX
    private int getIndex(K key)
    {
        return Math.abs(key.hashCode())%10;
    }


    //PUT KEY VALUE
    public void put(K key,V value)
    {
        int index=getIndex(key);
        LinkedList<Node<K,V>> bucket= buckets[index];
        for(Node<K,V> entry:bucket)
        {
            if(entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        Node<K,V> pair=new Node<>(key,value);
        bucket.add(pair);
    }


    public V get(K key)
    {
        int index=getIndex(key);
        LinkedList<Node<K,V>> bucket= buckets[index];
        for(Node<K,V> entry:bucket)
        {
            if(entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }


    public void remove(K key)
    {
        int index=getIndex(key);
        LinkedList<Node<K,V>> bucket= buckets[index];
        bucket.removeIf(entry -> entry.key.equals(key));
    }


    public void print()
    {
        for(LinkedList<Node<K,V>> bucket:buckets)
        {
            for(Node<K,V> entry:bucket)
            {
                System.out.println(entry.key+"-->"+entry.value);
            }
        }
    }
}
