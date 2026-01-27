package DP;

public class LongestIncSubseq {
    public static void main(String[] args) {

    }
    public static int LongestSubseq(int i,int[] arr,int prev){
        if(i==arr.length){
            return 0;
        }
        int NotTake=LongestSubseq(i+1,arr,prev);
        int take=0;

        if(prev== -1 || arr[prev]<arr[i]){
            take = 1 + LongestSubseq(i+1,arr,i);
        }
        return Math.max(NotTake,take);
    }
    public static int LongestSubseqTab(int[] arr,int prev){
        int n=arr.length;
        int[][] dp=new int[n+1][n+1];

        for(int i=n-1;i>=0;i++){
            for(int j=i-1;j>=-1;j++){

                int NotTake=dp[i+1][j+1];
                int take=0;

                if(j == -1 || arr[j+1]<arr[i]){
                    take = 1 + dp[i+1][i+1];
                }
                dp[i][j+1] = Math.max(NotTake,take);
            }
        }

        return dp[0][0];
    }

}
