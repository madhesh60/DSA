package Graph;

import java.util.ArrayList;

//ANYTHING WHICH HAS A CYCLE OR WHICH LEADS TO CYCLE IS NOT SAFE
//GO FOR CYCLE DETECT IN DIR->GRAPH

public class SafeState {
    public static void main(String[] args) {
        int[][] graph = {
                {1},
                {2},
                {0}
        };
        System.out.println(helper(graph));
    }
    public static ArrayList helper(int[][] arr){
        int n= arr.length;
        boolean[] vis=new boolean[n];
        boolean[] path=new boolean[n];
        boolean[] check=new boolean[n];
        ArrayList<Integer> ans=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(vis[i]==false)
                dfs(arr,vis,path,check,i);
        }
       for (int i=0;i< check.length;i++){
           if(check[i]==true)
               ans.add(i);
       }
       return ans;
    }
    public static boolean dfs(int[][] arr,boolean[] vis,boolean[] path,boolean[] check,int node){
        vis[node]=true;
        path[node]=true;

        for(int i=0;i<arr[node].length;i++){
            int num=arr[node][i];
            if(vis[num]==false){
                if(dfs(arr,vis,path,check,num)==true){
                    check[num]=false;
                    return true;
                }
            }
            else if(path[num]==true){
                check[num]=false;
                return true;
            }
        }
        path[node]=false;
        check[node]=true;
        return false;
    }
}
