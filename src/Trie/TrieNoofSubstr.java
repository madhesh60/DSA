package Trie;

public class TrieNoofSubstr {

    class Node{
        Node[] link=new Node[26];
        //PROPERTIES WE USE IN INSERT AND SOME OTHER FUNC IN TRIE CLASS
        boolean isContain(char ch) {
            return link[ch - 'a'] != null;
        }
        void put(char ch, Node node) {
            link[ch - 'a']=node;
        }
        Node get(char ch) {
            return link[ch - 'a'];
        }
    }

    //CONSTRUCTOR
    Node root;
    int count;
    TrieNoofSubstr(){
        root=new Node();
        count=1;
    }

    public void insert(String word)
    {
        Node node=root;
        for(int i=0;i<word.length();i++)
        {
            for(int j=i;j<word.length();j++) {
                if (!node.isContain(word.charAt(j))) {
                    node.put(word.charAt(j), new Node());
                    count++;
                }
            }
            node=node.get(word.charAt(i));
        }

    }
}
