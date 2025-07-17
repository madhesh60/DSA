package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class XOGame {
    public static void main(String[] args) {

    }
    public static void helper(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        boolean[][] vis=new boolean[n][m];

        for(int row=0;row<m;row++){
            if(vis[0][row] == false && arr[0][row] == 'O') {
                dfs(0, row, vis, arr);
            }

            if(vis[n-1][row] == false && arr[n-1][row] == 'O') {
                dfs(n-1,row,vis,arr);
            }
        }

        for(int col=0;col<n;col++){
            if(vis[col][0] == false && arr[col][0] == 'O') {
                dfs(col,0, vis, arr);
            }

            if(vis[col][m-1] == false && arr[col][m-1] == 'O') {
                dfs(col,m-1,vis,arr);
            }
        }

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(vis[i][j]==false && arr[i][j]=='O')
                    arr[i][j]='X';
            }
        }
    }
    public static void dfs(int row,int col,boolean[][] vis,int[][] arr){
        vis[row][col]=true;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1,0, -1};

        for(int i=0;i<dr.length;i++) {
            int crow = row + dr[i];
            int ccol = col + dc[i];

            if (ccol >= 0 && ccol < arr[0].length && crow >= 0 && crow < arr.length && arr[crow][ccol] == 'O' && !vis[crow][ccol]) {
                dfs(crow,ccol,vis,arr);
            }

        }
    }

}
