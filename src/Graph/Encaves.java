package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Encaves {
    public static void main(String[] args) {

    }
    public static int helper(int[][] arr){
        Queue<Pair> q = new LinkedList<Pair>();
        int n = arr.length;
        int m = arr[0].length;
        int vis[][] = new int[n][m];


        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if(i == 0 || j == 0 || i == n-1 || j == m-1) {
                    if(arr[i][j] == 1) {
                        q.add(new Pair(i, j));
                        vis[i][j] = 1;
                    }
                }
            }
        }
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            int row = q.peek().key;
            int col = q.peek().value;
            q.remove();

            for(int i = 0;i<4;i++) {
                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if(nrow >=0 && nrow <n && ncol >=0 && ncol < m
                        && vis[nrow][ncol] == 0 && arr[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }

        }
        int count = 0;
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if(arr[i][j] == 1 & vis[i][j] == 0)
                    count++;
            }
        }
        return count;
    }
}

