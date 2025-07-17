package Graph;

public class DetectCycleDir {
    public static void main(String[] args) {
        int[][] graph = {
                {1},
                {2},
                {0}
        };
        System.out.println(helper(graph));
    }
    public static boolean helper(int[][] arr){
        int n= arr.length;
        boolean[] vis=new boolean[n];
        boolean[] path=new boolean[n];
        for(int i=0;i<n;i++){
            if(vis[i]==false)
                if(dfs(arr,vis,path,i))
                    return true;
        }
        return false;
    }
    public static boolean dfs(int[][] arr,boolean[] vis,boolean[] path,int node){
        vis[node]=true;
        path[node]=true;

        for(int i=0;i<arr[node].length;i++){
            int num=arr[node][i];
            if(vis[num]==false){
                if(dfs(arr,vis,path,num)==true)
                    return true;
            }
            else if(path[num]==true){
                return true;
            }
        }
        path[node]=false;
        return false;
    }
}
