package Trie;

class TrieXOR{
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
    TrieXOR()
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
            int checkbit=(num>>i)&1;

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

