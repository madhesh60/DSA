package DP;
import java.util.Arrays;

public class KnapSack01 {
    public static void main(String[] args) {
        int[] wt = {2, 4, 6};
        int[] val = {5, 11, 13};
        int W = 10;
        int n = wt.length;
        int[][] dp = new int[n][W + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        System.out.println(unboundedKnapsack(n, W,n-1, val, wt,dp));
        System.out.println(unboundedKnapsackTab(n, W, val, wt));
        System.out.println(unboundedKnapsackSpaceOpt(n, W, val, wt));
    }
    public static int unboundedKnapsack(int n,int W,int ind,int[] val,int[] wt,int[][] dp){
        //BASE CASE
        if(dp[ind][W]!=-1){
            return dp[ind][W];
        }
        if(ind==0){
            if(wt[0]<=W){
                return val[0];
            }
            else{
                return 0;
            }
        }

        //TAKE AND NOT TAKE WITH MEMOIZATION
        int notTake= unboundedKnapsack(n, W, ind-1, val, wt,dp);
        int take=Integer.MIN_VALUE;

        if(wt[ind]<=W){
            take=val[ind]+unboundedKnapsack(n,W-wt[ind],ind-1,val,wt,dp);
        }

         return dp[ind][W]=Math.max(notTake,take);
    }
    public static int unboundedKnapsackTab(int n,int W,int[] val,int[] wt){
        int[][] dp = new int[n][W + 1];
        for (int[] row : dp) Arrays.fill(row, 0);

        for(int i=wt[0];i<=W;i++){
            dp[0][i] = (wt[0] <= i) ? val[0] : 0;
        }

        for(int ind=1;ind<n;ind++){
            for(int j=0;j<=W;j++){
                int notTake=dp[ind-1][j];
                int take=Integer.MIN_VALUE;

                if(wt[ind]<=j){
                    take=val[ind]+dp[ind-1][j-wt[ind]];
                }

                dp[ind][j]=Math.max(notTake,take);
            }
        }
        return dp[n-1][W];
    }

    public static int unboundedKnapsackSpaceOpt(int n, int W, int[] val, int[] wt) {

        int[] prev = new int[W + 1];

        for (int j = W; j >= wt[0]; j--) {
            prev[j] = val[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int j = W; j >= wt[ind]; j--) {
                prev[j] = Math.max(prev[j], val[ind] + prev[j - wt[ind]]);
            }
        }

        return prev[W];
    }

}
