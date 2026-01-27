package DP;

import java.nio.Buffer;

public class BuyStocks2 {
    public static void main(String[] args) {
        int[] arr=new int[6];
        System.out.println(BuyAndSell(arr,true,0));
    }
    public static int BuyAndSell(int[] arr,boolean CheckBuy,int i){
        //BASE CASE
        if(i==arr.length){
            return 0;
        }

        //Recurrence
        if(CheckBuy){
            return Math.max( -arr[i]+BuyAndSell(arr,false,i+1), 0 + BuyAndSell(arr,true,i+1));
        }
        else{
            return Math.max(arr[i]+BuyAndSell(arr,true,i+1), 0 + BuyAndSell(arr,false,i+1));
        }
    }
    public static int BuyAndSellTab(int[] arr,int  CheckBuy){
        //BASE CASE
        int n=arr.length;
        int[][] dp = new int[arr.length+1][2];
        dp[n-1][0] = dp[n-1][1]=0;

        //RECURRENCE
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<2;j++){
                if(j==1){
                    dp[i][j] =  Math.max(-arr[i]+dp[i+1][0], dp[i+1][1]);
                }
                else{
                    dp[i][j] = Math.max(arr[i]+ dp[i+1][1], dp[i+1][0]);
                }
            }
        }
        return dp[0][1];
    }
}
