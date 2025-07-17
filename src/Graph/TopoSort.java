package Graph;
import javax.swing.*;
import java.util.Stack;

public class TopoSort {
    public static void main(String[] args) {

    }
    public static int[] helper(int[][] arr){
        int n=arr.length;
        boolean[] vis=new boolean[n];
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0;i< arr.length;i++){
            if(vis[i]==false){
                dfs(arr,vis,stack,i);
            }
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void dfs(int[][] arr, boolean[] vis, Stack<Integer> stack,int node){
        vis[node]=true;

        for(int i=0;i<arr[node].length;i++){
            int num=arr[node][i];
            if(vis[num]==false){
                dfs(arr,vis,stack,num);
            }
        }
        stack.push(node);
    }

}
