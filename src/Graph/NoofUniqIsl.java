package Graph;

import java.util.ArrayList;
import java.util.HashSet;

public class NoofUniqIsl {
    public static void main(String[] args) {

    }
    public static int helper(int[][] arr){
        int n=arr.length;
        int m=arr[0].length;
        boolean[][] vis=new boolean[n][m];
        HashSet<ArrayList<String>> ans=new HashSet<>();

        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if(arr[i][j]==1 && vis[i][j]==false){
                    ArrayList<String> vec=new ArrayList<>();
                    dfs(i,j,arr,vis,vec,i,j);
                    ans.add(vec);
                }
            }
        }
        return ans.size();
    }
    public static void dfs(int row,int col,int[][] arr,boolean[][] vis,ArrayList<String> vec,int row0,int col0){
        vis[row][col]=true;
        vec.add(toString(row-row0,col-col0));
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};

        for(int i=0;i<4;i++){
            int crow=row+dr[i];
            int ccol=col+dc[i];

            if(ccol >= 0 && ccol < arr[0].length && crow >= 0 && crow < arr.length && !vis[crow][ccol] && arr[crow][ccol]==1){
                dfs(crow,ccol,arr,vis,vec,row0,col0);
            }
        }
    }
    public static String toString(int a,int b) {
        return Integer.toString(a)+""+Integer.toString(b);
    }
}
