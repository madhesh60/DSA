package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NoofProvinces{
    public static void main(String[] args) {
    int[][] arr={{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(helper(arr));
    }
    public static int helper(int[][] arr) {
        int count=0;
        int n=arr.length;
        int m=arr[0].length;
        boolean[][] vis=new boolean[n][m];

        for(int row=0;row<arr.length;row++){
            for(int col=0;col<arr[0].length;col++){

                if(!vis[row][col] && arr[row][col]=='1'){
                    count++;
                    bfs(row,col,vis,arr);
                }
            }

        }
        return count;

        /*
         int count=0;
        int n=arr.length;
        Disjoint ans=new Disjoint(n);

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr[0].length;j++){
                if(arr[i][j]==1){
                    ans.UnionBySize(i,j);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(ans.findU(i)==i){
                count++;
            }

        }
        return count;
         */
    }
    public static void bfs(int row,int col,boolean[][] vis,int[][] arr){
        Queue<Pair> myq=new LinkedList<>();
        vis[row][col]=true;
        myq.offer(new Pair(row,col));

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!myq.isEmpty()) {
            int nrow = myq.peek().key;
            int ncol = myq.peek().value;
            myq.poll();

            for(int i=0;i<dr.length;i++) {
                int crow = nrow + dr[i];
                int ccol = ncol + dc[i];

                if (ccol >= 0 && ccol < arr[0].length && crow >= 0 && crow < arr.length && arr[crow][ccol] == '1' && !vis[crow][ccol]) {
                    vis[crow][ccol] = true;
                    myq.offer(new Pair(crow,ccol));
                }
            }

        }
    }
}
