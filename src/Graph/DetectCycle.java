package Graph;

import java.util.LinkedList;
import java.util.Queue;


public class DetectCycle {
    public static void main(String[] args) {

    }
    public static boolean helper(int[][] arr) {
        int n = arr.length;
        boolean[] vis = new boolean[n];
            for (int i = 0; i < arr.length; i++) {
                    if (!vis[i]) {
                    if(bfs(i, vis, arr))
                        return true;
                    }
                }
        return false;
    }
    public static boolean bfs(int i,boolean[] vis,int[][] arr){
        Queue<Pair> myq=new LinkedList<>();
        vis[i]=true;
        myq.offer(new Pair(i,-1));

        while(!myq.isEmpty()) {
            int key= myq.peek().key;
            int parent = myq.peek().value;
            myq.poll();

            for(int j=0;j<arr[key].length;j++){
                if(arr[key][j]==1) {
                    if (vis[j] == false) {
                        vis[j] = true;
                        myq.offer(new Pair(j, key));
                    }
                }
                else if(parent != j){
                    return true;
                }
            }
        }
        return true;
    }
}
