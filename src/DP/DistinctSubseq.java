package DP;

import java.util.Arrays;

public class DistinctSubseq {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        int[][] dp = new int[s.length()][t.length()];
        for (int[] row : dp) Arrays.fill(row, -1);

        System.out.println(DistinctSub(s,t,0,0,dp));
    }
    public static int DistinctSub(String s,String t,int i ,int j,int[][] dp){
        //Base Case
        if(j==t.length()){
            return 1;
        }
        else if(i==s.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        //Recurrence
        if(s.charAt(i)==t.charAt(j)){
            dp[i][j] = DistinctSub(s,t,i+1,j+1,dp)+DistinctSub(s,t,i+1,j,dp);
        }
        else{
            dp[i][j] = DistinctSub(s,t,i+1,j,dp);
        }
        return dp[i][j];
    }
    public static int DistinctSubTab(String s,String t){
        //Base Case
        int n = s.length();
        int m = t.length();
        int[][] dp=new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            dp[i][m]=1;
        }

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(s.charAt(i)==t.charAt(j)){
                    dp[i][j] = dp[i+1][j+1]+dp[i+1][j];
                }
                else{
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        //Recurrence
        return dp[0][0];
    }

}
