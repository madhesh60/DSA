package Graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NoOfSCC {
    public static void main(String[] args){
        int n = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(1).add(3);
        adj.get(3).add(4);
        int sccCount = helper(n, adj);
        System.out.println("Number of Strongly Connected Components: " + sccCount);
    }
    public static int helper(int n, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis=new boolean[n];
        Stack<Integer> st=new Stack();
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                dfs(i,vis,st,adj);
            }
        }
        ArrayList<ArrayList<Integer>> adjt=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjt.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(Integer it:adj.get(i)){
                adjt.get(it).add(i);
            }
        }

        Arrays.fill(vis, false);
        int ans=0;
        while(!st.isEmpty()){
            int node=st.peek();
            st.pop();
            if(vis[node]==false){
                ans++;
                dfsNorm(node,vis,adjt);
            }
        }
        return ans;
    }
    public static void dfs(int node,boolean[] vis,Stack<Integer> st,ArrayList<ArrayList<Integer>> adj){
        vis[node]=true;
        for(Integer it:adj.get(node)){
            if(vis[it]==false){
                dfs(it,vis,st,adj);
            }
        }
        st.push(node);
    }

    public static void dfsNorm(int node,boolean[] vis,ArrayList<ArrayList<Integer>> adjT){
        vis[node]=true;
        for(Integer it:adjT.get(node)) {
            if (vis[it] == false) {
                dfsNorm(it, vis, adjT);
            }
        }
    }
}
