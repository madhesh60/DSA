package DP;

import java.util.Arrays;

/* FOR THESE TYPES OF SUBSTRING AND SUBSEQ PROBLEMS WHEN WE WANT TO TABULATE WE USE N+1 AND M+1
   TO DECLARE DP TO GET THE BASE CASE FIT IN DP ARRAY

   if(ind1<0 || ind2<0){
     return 0;
   }

}*/

public class LongestSubseq {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";

        int[][] dp = new int[s1.length()][s2.length()];
        for (int[] row : dp){
            Arrays.fill(row, -1);
        }
        System.out.println(LongestSubseq(s1, s2,s1.length()-1,s2.length()-1,dp));
        System.out.println(LongestSubseqTab(s1, s2,s1.length(),s2.length()));
        System.out.println(LongestSubseqSpace(s1, s2));

    }
    public static int LongestSubseq(String s1, String s2, int ind1, int ind2,int[][] dp){
        if(ind1<0 || ind2<0){
            return 0;
        }
        if (dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }

        if(s1.charAt(ind1)==s2.charAt(ind2)){
            return dp[ind1][ind2] = 1 + LongestSubseq(s1, s2,ind1-1,ind2-1,dp);
        }
        else {
            return dp[ind1][ind2] = Math.max(LongestSubseq(s1, s2, ind1 - 1, ind2, dp), LongestSubseq(s1, s2, ind1, ind2 - 1, dp));
        }
    }
    public static int LongestSubseqTab(String s1, String s2, int ind1, int ind2){
        int[][] dp=new int[ind1+1][ind2+1];

        for(int i=0;i<=ind1;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<=ind2;i++){
            dp[0][i]=0;
        }

        for(int i=1;i<=ind1;i++){
            for(int j=1;j<=ind2;j++){
                if(s1.charAt(i-1)==s1.charAt(j-1)){
                  dp[i][j]=1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[ind1][ind2];
    }
    public static int LongestSubseqSpace(String s1, String s2){
        int ind1=s1.length();
        int ind2=s2.length();

        int[] prev = new int[ind2 + 1];

        for(int i=1;i<=ind1;i++){
            int[] curr = new int[ind2 + 1];
            for(int j=1;j<=ind2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }
                else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev=curr;
        }
        return prev[ind2];
    }

}
