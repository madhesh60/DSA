package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinCostWithKStops {
    public static void main(String[] args) {

    }
    public static int helper(int[][] arr,int src,int dst,int n,int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<arr.length;i++){
            adj.get(arr[i][0]).add(new Pair(arr[i][1],arr[i][2]));
        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, src, 0));

        while(!q.isEmpty()){
            Node node=q.peek();
            q.remove();

            int steps=node.first;
            int vert=node.second;
            int weight=node.third;

            if(steps>k){
                continue;
            }
            for(Pair it:adj.get(vert)){
                int adjNode = it.key;
                int edgw=it.value;

                if(edgw+weight<dist[adjNode] && steps<=k){
                    dist[adjNode]=edgw+weight;
                    q.add(new Node(steps+1,adjNode,edgw+weight));
                }
            }

        }
        if(dist[dst] ==  Integer.MAX_VALUE) return -1;
        return dist[dst];

    }

}
