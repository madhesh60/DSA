package Graph;

import java.util.*;

public class ShortestPathDIR {
    public static void main(String[] args) {

    }
    public static int[] helper(int[][] arr,int n) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Pair> temp = new ArrayList<Pair>();
            adj.add(temp);
        }
        for (int i = 0; i < arr.length; i++) {
            int u = arr[i][0];
            int v = arr[i][1];
            int wt = arr[i][2];
            adj.get(u).add(new Pair(v, wt));
        }
        int[] dist = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < adj.size(); i++) {
            if (vis[i] == false) {
                topo(i, adj, vis, st);
            }
        }
        dist[0] = 0;
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int v = adj.get(node).get(i).key;
                int wt = adj.get(node).get(i).value;

                if (dist[node] + wt < dist[v]) {
                    dist[v] = wt + dist[node];
                }
            }
        }
        return dist;
    }

    public static void topo(int Node,ArrayList<ArrayList <Pair>> adj,boolean[] vis,Stack<Integer> stack){
        vis[Node]=true;
        for(int i=0;i<adj.get(Node).size();i++){
            int num=adj.get(Node).get(i).key;
            if(vis[num]==false){
                topo(num,adj,vis,stack);
            }
        }
        stack.push(Node);
    }
}
