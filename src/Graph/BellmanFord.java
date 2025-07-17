package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
    public static void main(String[] args) {

    }
    public static int[] helper(ArrayList<ArrayList<Integer>> adj,int n){
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;

        for(int i=0;i<n-1;i++){
            for(ArrayList<Integer> it:adj){
                int u=it.get(0);
                int v=it.get(1);
                int weight=it.get(2);

                if(dist[u]!=Integer.MAX_VALUE && dist[u]+weight<dist[v]){
                    dist[v]=dist[u]+weight;
                }
            }
        }

        for(ArrayList<Integer> it:adj) {
            int u = it.get(0);
            int v = it.get(1);
            int weight = it.get(2);

            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Negative weight cycle detected");
                return new int[]{-1};
            }
        }
        return dist;
    }
}
