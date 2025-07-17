package Graph;

import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(2, 4)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 1)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(3, 7)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(3, 3)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(4, 1)));
        int[] result=helper(adj,0);
        System.out.println(Arrays.toString(result));
    }
    public static int[] helper(ArrayList<ArrayList<ArrayList<Integer>>> adj,int src){
        int n= adj.size();
        int[] dis=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        PriorityQueue<Pair> q=new PriorityQueue<>((a, b) -> a.key - b.key);
        dis[src]=0;
        q.add(new Pair(0,src));

        while(!q.isEmpty()) {
            int wt = q.peek().key;
            int node=q.peek().value;
            q.poll();

            for(int i=0;i<adj.get(node).size();i++) {
                int adjNode =adj.get(node).get(i).get(0);
                int edgeW = adj.get(node).get(i).get(1);

                if(wt+ edgeW < dis[adjNode]) {
                    dis[adjNode] = wt+ edgeW;
                    q.add(new Pair(dis[adjNode],adjNode));
                }
            }
        }
        return dis;
    }

}
