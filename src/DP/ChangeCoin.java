package DP;

public class ChangeCoin {
    public static void main(String[] args) {

    }
    public static int ChangeCoinRec(int ind,int T,int[] val){
        if(ind==0){
            return T%val[0]==0 ? 1 : 0;
        }
        int notTake= ChangeCoinRec(ind-1,T,val);
        int take=0 ;

        if(val[ind]<=T){
            take= 1 + ChangeCoinRec(ind,T-val[ind],val);
        }
        return Math.min(take,notTake);
    }
    public static int ChangeCoinTab(int n,int T,int[] val){
        int[][] dp=new int[n][T+1];

        for(int i=0;i<T;i++){
            dp[0][i]= T % val[i]==0 ? 1 : 0;
        }

        for(int ind=1;ind<n;ind++){
            for(int t=0;t<=T;t++){
                int notTake=dp[ind-1][T];
                int take=Integer.MAX_VALUE;

                if(val[ind]<=T){
                    take= 1 + dp[ind][T-val[ind]];
                }
                return Math.min(take,notTake);
            }
        }
        return dp[n][T];
    }
}
