package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PrimsAlgo {
    public static void main(String[] args) {

    }
    public static int helper(int n, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        PriorityQueue<Pair> heap=new PriorityQueue<>(
                (x, y) -> x.key - y.key
        );
        int[] vis=new int[n];
        int sum=0;
        heap.add(new Pair(0,0));

        while(!heap.isEmpty()){
            Pair pair=heap.peek();
            int wt=pair.key;
            int node= pair.value;
            heap.poll();

            if (vis[node] == 1) continue;

            vis[node] = 1;
            sum += wt;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edW = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if (vis[adjNode] == 0) {
                    heap.add(new Pair(edW, adjNode));
                }
            }
        }
        return sum;
    }
}
