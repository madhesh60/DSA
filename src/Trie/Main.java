package Trie;

public class Main {
    public static void main(String[] args) {
//        TrieNoofSubstr trie=new TrieNoofSubstr();
//        trie.insert("abab");
//        System.out.println(trie.count);
//
//        TrieXOR trie=new TrieXOR();
//        int[] arr1={3,10,5,25,2,8};
//        int[] arr2={8, 1, 2, 12, 7};
//        int maxans=0;
//
//        for(int i=0;i<arr1.length;i++) {
//            trie.insert(arr1[i]);
//        }
//
//        for(int i=0;i<arr2.length;i++) {
//            maxans=Math.max(maxans, trie.maxXOR(arr2[i]));
//        }
//        System.out.println(maxans);
        TrieXORQueries trie=new TrieXORQueries();
        int[] arr={0,1,2,3,4};
        int[][] queries={
                {3,1},
                {1,3},
                {5,6}
        };
        System.out.println(trie.maxXORQuery(arr,queries));
    }
}
