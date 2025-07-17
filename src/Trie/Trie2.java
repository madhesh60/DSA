package Trie;

public class Trie2 {

    static class Node{
        Node[] link;
        int cntPrefix;
        int cntEnd;

        Node()
        {
            link=new Node[26];
            cntPrefix=0;
            cntEnd=0;

        }
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
        void IncPrefix() {
            cntPrefix++;
        }
        void IncEnd() {
            cntEnd++;
        }
        void DecPrefix() {
            cntPrefix--;
        }
        void DecEnd() {
            cntEnd--;
        }

    }
    //CONSTRUCTOR
    Node root;
    Trie2(){
        root= new Node();
    }


    void insert(String word)
    {
        Node node=root;
        for (int i=0;i<word.length();i++)
        {
            if(!node.isContain(word.charAt(i)))
            {
                node.put(word.charAt(i), new Node());
            }
            node=node.get(word.charAt(i));
            node.IncPrefix();
        }
        node.IncEnd();
    }

    int countNoWords(String word)
    {
        Node node=root;
        for (int i=0;i<word.length();i++)
        {
            if(node.isContain(word.charAt(i)))
                node=node.get(word.charAt(i));
            else
                return 0;
        }
        return node.cntEnd;
    }

    int countNoWordsPrefix(String word)
    {
        Node node=root;
        for (int i=0;i<word.length();i++)
        {
            if(node.isContain(word.charAt(i)))
                node=node.get(word.charAt(i));
            else
                return 0;
        }
        return node.cntPrefix;
    }
    void erase(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.isContain(word.charAt(i))) {
                node = node.get(word.charAt(i));
                node.DecPrefix();
            } else
                return;
        }
        node.DecEnd();
    }
}
