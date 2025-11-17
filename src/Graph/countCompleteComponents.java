package Graph;

import java.util.ArrayList;

class countCompleteComponents {
    public static void main(String[] args) {

    }
    public static int helper(int n, int[][] edges) {
        boolean[]  vis=new boolean[n];
        int count=0;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] it:edges){
            int ind=it[0];
            int map=it[1];
            adj.get(ind).add(map);
            adj.get(map).add(ind);
        }

        for(int i=0;i<n;i++){
            if(!vis[i]){
                ArrayList<Integer> temp=new ArrayList<>();
                dfs(adj,vis,i,temp);

                int node=temp.size();
                int nedges=0;

                for(int z:temp){
                    nedges+=adj.get(z).size();
                }

                nedges=nedges/2;
                if(nedges==node*(node-1)/2){
                    count++;
                }
            }
        }

        return count;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int node,ArrayList<Integer> temp){
        vis[node]=true;
        temp.add(node);

        for(int it:adj.get(node)){
            if(!vis[it]){
                dfs(adj,vis,it,temp);
            }
        }
    }
}