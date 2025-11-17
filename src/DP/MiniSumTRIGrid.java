package DP;
import java.util.*;

public class MiniSumTRIGrid {
    public static void main(String[] args) {
        List<List<Integer>> arr=new ArrayList<>();
        arr.add(Arrays.asList(1));
        arr.add(Arrays.asList(2, 3));
        arr.add(Arrays.asList(3, 6, 7));
        arr.add(Arrays.asList(8, 9, 6, 10));

        int[][] dp=new int[arr.size()][arr.get(arr.size()-1).size()];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println(helper(arr,0,0,dp,arr.size()));
    }
//  public static int  helper(List<List<Integer>> triangle,int i,int j,int[][] dp,int n){
//        if(dp[i][j]!=-1){
//            return dp[i][j];
//        }
//        if(i==n-1){
//            return triangle.get(i).get(j);
//        }
//        int down =helper(triangle,i+1,j,dp,n)+triangle.get(i).get(j);
//        int RightDiag=helper(triangle,i+1,j+1,dp,n)+triangle.get(i).get(j);
//
//        return dp[i][j]=Math.min(down,RightDiag);
//    }
    public static int  helper(List<List<Integer>> triangle,int i,int j,int[][] dp,int n){

        for(int k=0;k<n;k++){
            dp[n-1][k]=triangle.get(n-1).get(k);
        }

        for(int k=n-2;k>=0;k--){
            for(int z=0;z<triangle.get(k).size();z++){

                int down=triangle.get(k).get(z)+dp[k+1][z];
                int rightDiag=triangle.get(k).get(z)+dp[k+1][z+1];

                dp[k][z]=Math.min(down,rightDiag);
            }
        }

        return dp[0][0];
    }
}
