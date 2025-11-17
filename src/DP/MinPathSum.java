package DP;

public class MinPathSum {
    public static void main(String[] args) {

    }
    public static int minPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[] prev=new int[m];

        for(int i=0;i<n;i++){
            int[] temp=new int[m];
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    temp[j]=matrix[i][j];
                }
                else{
                    int up=0;
                    int left=0;

                    if(i>0){
                        up=matrix[i][j]+prev[j];
                    }
                    else{
                        up+=Integer.MAX_VALUE;
                    }
                    if(j>0){
                        left=matrix[i][j]+temp[j-1];
                    }
                    else{
                        left+=Integer.MAX_VALUE;
                    }

                    temp[j]=Math.min(up,left);
                }
            }
            prev=temp;
        }
        return prev[m-1];
    }
    public static int minPathSumRec(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        return findMin(n - 1, m - 1, grid);
    }

    private static int findMin(int i, int j, int[][] grid) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }

        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        int up = grid[i][j] + findMin(i - 1, j, grid);
        int left = grid[i][j] + findMin(i, j - 1, grid);

        return Math.min(up, left);
    }

}
