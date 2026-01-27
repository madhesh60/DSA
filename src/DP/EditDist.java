package DP;

import java.util.Arrays;

public class EditDist {
    public static void main(String[] args) {
        String s = "horse";
        String t = "ros";
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int[] row : dp) Arrays.fill(row, -1);

        System.out.println(EditDist(s,t,s.length(),t.length(),dp));
    }
    public static int EditDist(String s,String t,int i ,int j,int[][] dp){
        //Base Case
        if(j==0){
            return i;
        }
        else if(i==0){
            return j;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        //Recurrence
        if(s.charAt(i-1)==t.charAt(j-1)){
            return dp[i][j] = EditDist(s,t,i-1,j-1,dp);
        }
        else{
            dp[i][j]= 1 +  Math.min(EditDist(s,t,i,j-1,dp),Math.min(EditDist(s,t,i-1,j,dp),EditDist(s,t,i-1,j-1,dp)));
        }
        return dp[i][j];
    }
    public static int EditDistTab(String s,String t){
        int n=s.length();
        int m=t.length();
        int[][] dp=new int[n+1][m+1];

        //Base Case

        for(int i=0;i<=n;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=m;j++){
            dp[0][j]=j;
        }
        //Recurrence
       for(int i=1;i<=n;i++){
           for(int j=1;j<=m;j++){
               if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
               }
               else{
                   dp[i][j]= 1 +  Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
               }
           }
       }
       return dp[n][m];
    }


}
