package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CountSteps {
    public static void main(String[] args) {
        int[][] arr={
                {0,1,0},
                {0,1,0},
                {0,1,0},
                {0,1,0},
                {0,1,0}
        };
        System.out.println(Arrays.deepToString(helper(arr)));
    }
    public static int[][] helper(int[][] arr){
        int n=arr.length;
        int m= arr[0].length;;
        boolean [][] vis=new boolean [n][m];
        int[][] ans=new int[n][m];
        Queue<Node> myq=new LinkedList<>();

        for(int i=0;i< arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==0){
                    myq.offer(new Node(i,j,0));
                    vis[i][j]=true;
                }
            }
        }
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1,0, -1};

        while(!myq.isEmpty()){
            int row=myq.peek().first;
            int col=myq.peek().second;
            int step=myq.peek().third;
            myq.remove();

            ans[row][col]=step;

            for(int i=0;i<4;i++){
                int crow=row+dr[i];
                int ccol=col+dc[i];

                if(ccol >= 0 && ccol < arr[0].length && crow >= 0 && crow < arr.length && !vis[crow][ccol]){
                    vis[crow][ccol]=true;
                    myq.offer(new Node(crow,ccol,step+1));
                }
            }
        }
        return ans;

    }
}
