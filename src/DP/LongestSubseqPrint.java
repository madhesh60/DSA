package DP;

/* FOR THESE TYPES OF SUBSTRING AND SUBSEQ PROBLEMS WHEN WE WANT TO TABULATE WE USE N+1 AND M+1
   TO DECLARE DP TO GET THE BASE CASE FIT IN DP ARRAY

   if(ind1<0 || ind2<0){
     return 0;
   }

}*/

public class LongestSubseqPrint {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        System.out.println(LongestSubseq(s1, s2,s1.length(),s2.length()));
    }
    public static String LongestSubseq(String s1, String s2, int ind1, int ind2){
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
        StringBuilder ans=new StringBuilder();
        int i=ind1;
        int j=ind2;

        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                ans.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                i=i-1;
            }
            else if(dp[i-1][j]<dp[i][j-1]){
                j=j-1;
            }
        }
        return ans.reverse().toString();
    }
}
