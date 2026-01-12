package DP;

/* FOR THESE TYPES OF SUBSTRING AND SUBSEQ PROBLEMS WHEN WE WANT TO TABULATE WE USE N+1 AND M+1
   TO DECLARE DP TO GET THE BASE CASE FIT IN DP ARRAY

   if(ind1<0 || ind2<0){
     return 0;
   }

}*/

public class LongestSubstring {
    public static void main(String[] args) {

    }
    public static int LongestString(String s1,String s2){
        int n=s1.length();
        int m=s2.length();

        int ans=0;
        int[][] dp=new int[n+1][m+1];
        for(int i = 1;i <= n; i++){
            for(int j = 1; j <= m; j++){

                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]= 1 + dp[i-1][j-1];
                    ans=Math.max(ans,dp[i][j]);
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}
