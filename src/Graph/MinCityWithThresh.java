package Graph;

public class MinCityWithThresh {
    public static void main(String[] args) {

    }
    public static int helper(int[][] arr,int n,int threshold){
        int maxcity=n+1;
        int cityno=-1;

        int[][] matrix=new int[n][n];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
               matrix[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int[] it:arr){
            int u=it[0];
            int v=it[1];
            int wt=it[2];

            matrix[u][v]=wt;
            matrix[v][u]=wt;
        }
        for (int i = 0; i < matrix.length; i++) {
             matrix[i][i] = 0;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(matrix[i][k]==Integer.MAX_VALUE || matrix[k][j]==Integer.MAX_VALUE){
                        continue;
                    }
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        for(int i=0;i< matrix.length;i++){
            int count=0;
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]<=threshold){
                    count++;
                }
            }
            if(count<=maxcity){
                maxcity=count;
                cityno=i;
            }
        }
        return cityno;
    }
}
