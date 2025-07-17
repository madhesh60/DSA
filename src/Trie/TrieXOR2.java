package Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class TrieXOR2{
    class Node {
        Node[] link;

        Node() {
            link = new Node[2];
        }

        boolean isContains(int bit) {
            return link[bit] != null;
        }

        void put(int bit, Node node) {
            link[bit] = node;
        }

        Node get(int bit) {
            return link[bit];
        }
    }

    Node root;
    TrieXOR2()
    {
        root=new Node();
    }

    void insert(int num)
    {
        Node node=root;
        for(int i=31;i>=0;i--)
        {
            int bit=(num>>i)&1;

            if(!node.isContains(bit)){
                node.put(bit,new Node());
            }
            node=node.get(bit);
        }
    }
    int  maxXOR(int num)
    {
        int ans=0;
        Node node=root;
        for(int i=31;i>=0;i--)
        {
            int checkbit =(num>>i)&1;

            if(node.isContains(1-checkbit)) {
                ans|=(1<<i);
                node=node.get(1-checkbit);
            }
            else{
                node=node.get(checkbit);
            }
        }
        return ans;
    }

}

class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

class TrieXORQueries {
    int[] maxXORQuery(int[] arr, int[][] check)
    {
        TrieXOR2 trie = new TrieXOR2();

        int[] ans = new int[check.length];
        ArrayList<Pair<Integer, Pair<Integer, Integer>>> queries = new ArrayList<>();
        Arrays.sort(arr);

        int index = 0;
        for(int[] it : check) {
            //queries.add(new Pair<>(it[1], new Pair<>(it[0], index++)));
        }

        Collections.sort(queries, new Comparator<Pair<Integer, Pair<Integer, Integer>>>() {
            @Override
            public int compare(Pair<Integer, Pair<Integer, Integer>> p1, Pair<Integer, Pair<Integer, Integer>> p2) {
                return p1.getKey().compareTo(p2.getKey());
            }
        });


        int i = 0;
        for (Pair<Integer, Pair<Integer, Integer>> it : queries) {
            while (i < arr.length && arr[i] < it.getKey()) {
                trie.insert(arr[i]);
                i++;
            }

            if (i != 0) {
                ans[it.getValue().getValue()] = trie.maxXOR(it.getValue().getKey());
            } else {
                ans[it.getValue().getValue()] = -1;
            }
        }
        return ans;
    }
}