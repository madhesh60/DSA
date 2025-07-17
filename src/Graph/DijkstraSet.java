package Graph;

import java.util.*;

public class DijkstraSet {
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
        TreeSet<Pair> set = new TreeSet<>();

        dis[src]=0;
        set.add(new Pair(0,src));

        while(!set.isEmpty()) {
            Pair top = set.pollFirst();
            int wt=top.key;
            int node=top.value;

            for(int i=0;i<adj.get(node).size();i++) {
                int adjNode =adj.get(node).get(i).get(0);
                int edgeW = adj.get(node).get(i).get(1);

                if (dis[adjNode] != (int) 1e9) {
                    set.remove(new Pair(dis[adjNode], adjNode));
                }

                if(wt+ edgeW < dis[adjNode]) {
                    dis[adjNode] = wt+ edgeW;
                    set.add(new Pair(dis[adjNode],adjNode));
                }
            }
        }
        return dis;
    }
}
