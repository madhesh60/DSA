package IMPLEMENT;

public class Segment {
    Node root;
    class Node{
        int sum;
        int startInt;
        int endInt;
        Node left;
        Node right;
        Node(int start,int end) {
            this.startInt=start;
            this.endInt=end;
        }
    }
    Segment(int[] arr) {
        this.root=construct(arr,0,arr.length-1);
    }
    private Node construct(int[] arr,int start,int end)  {
        if(start==end){
            Node leaf=new Node(start,end);
            leaf.sum=arr[start];
            return leaf;
        }
        int mid=(start+end)/2;

        Node node=new Node(start,end);
        node.left=construct(arr,start,mid);
        node.right=construct(arr,mid+1, end);
        node.sum=node.left.sum+node.right.sum;

        return node;
    }
    public int Query(int start,int end){
        return Query(root,start,end);
    }

    private int Query(Node node,int start,int end){
        if(node.startInt>=start && node.endInt<=end) {
            return node.sum;
        }
        else if(node.startInt>end || node.endInt<start){
            return 0;
        }
        else {
            return Query(node.left, start, end) + Query(node.right, start, end);
        }
    }
    public void update(int index, int value) {
        this.root.sum = update(this.root, index, value);
    }

    private int update(Node node, int index, int value) {
        if (index >= node.startInt&& index <= node.endInt){
            if(index == node.startInt && index == node.endInt) {
                node.sum = value;
                return node.sum;
            } else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.sum = leftAns + rightAns;
                return node.sum;
            }
        }
        return node.sum;
    }


}
