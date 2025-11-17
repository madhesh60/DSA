package DP;

public class UniquePath2 {
    public static void main(String[] args) {

    }
    public int uniquePathsWithObstacles(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[] prev=new int[m];

        for(int i=0;i<n;i++){
            int[] temp=new int[m];
            for(int j=0;j<m;j++){
                if(matrix[i][j]==1){
                    temp[j]=0;
                    continue;
                }
                if(i==0 && j==0){
                    temp[j]=1;
                }
                else{
                    int up=0;
                    int left=0;

                    if(i>0){
                        up=prev[j];
                    }
                    if(j>0){
                        left=temp[j-1];
                    }

                    temp[j]=up+left;
                }
            }
            prev=temp;
        }
        return prev[m-1];
    }
    public int uniquePathsWithObstaclesRec(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return countPaths(0, 0, m, n, obstacleGrid);
    }

    private int countPaths(int i, int j, int m, int n, int[][] grid) {
        // Out of bounds
        if (i >= m || j >= n) {
            return 0;
        }

        // Blocked cell
        if (grid[i][j] == 1) {
            return 0;
        }

        // Destination reached
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // Recursive calls
        int right = countPaths(i, j + 1, m, n, grid);
        int down = countPaths(i + 1, j, m, n, grid);

        return right + down;
    }

}
