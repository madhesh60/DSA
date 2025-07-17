package Trie;

public class Trie {
     class Node{
         Node[] link=new Node[26];
         boolean flag=false;

         //PROPERTIES WE USE IN INSERT AND SOME OTHER FUNC IN TRIE CLASS
         boolean isContain(char ch) {
             return link[ch - 'a'] != null;
         }
         void put(char ch,Node node) {
             link[ch - 'a']=node;
         }
         Node get(char ch) {
             return link[ch - 'a'];
         }
         void setEnd() {
             flag=true;
         }
         boolean isEnd() {
             return flag;
         }
     }
     //CONSTRUCTOR
     Node root;
     Trie(){
         root=new Node();
     }

     public void insert(String word)
     {
         Node node=root;
         for(int i=0;i<word.length();i++)
         {
             if(!node.isContain(word.charAt(i)))
             {
                 node.put(word.charAt(i),new Node());
             }
             node=node.get(word.charAt(i));
         }
         node.setEnd();
     }

    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.isContain(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }
    public boolean searchPrefix(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.isContain(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return true;
    }
}
