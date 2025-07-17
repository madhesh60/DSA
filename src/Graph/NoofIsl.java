package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NoofIsl {
    public static void main(String[] args) {
        int[][] arr={{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(helper(arr));
    }
    public static int helper(int[][] arr) {
        int count=0;
        boolean[] vis=new boolean[arr.length+1];

        for(int i=0;i<vis.length;i++){
            if(!vis[i]){
                count++;
                bfs(i,arr,vis);
            }
        }
        return count;
    }
    public static void bfs(int node,int[][] arr,boolean[] vis){
        Queue<Integer> myq=new LinkedList<>();
        vis[node]=true;
        myq.offer(node);

        while(!myq.isEmpty()){
            node=myq.poll();
            for(int i=0;i<arr[0].length;i++){
                if(vis[i]==false && arr[node][i]==1){
                    vis[i]=true;
                    myq.offer(i);
                }
            }
        }
    }
}
