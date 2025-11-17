package DP;

public class HouseRobber2 {
    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        if(nums.length==1){
            System.out.println(nums[0]);;
        }
        int[] num1=new int[nums.length-1];
        int[] num2=new int[nums.length-1];

        for(int i=1;i<nums.length;i++){
            num1[i-1]=nums[i];
        }
        for(int i=0;i<nums.length-1;i++){
            num2[i]=nums[i];
        }

        System.out.println(Math.max(helper(num1),helper(num2)));
    }
    //    public static int helper(int n,int[] nums){
//        if(n==0){
//            return nums[0];
//        }
//        if(n<0){
//            return 0;
//        }
//
//        int l=helper(n-2,nums)+nums[n];
//        int r=helper(n-1,nums);
//
//        return Math.max(l,r);
//    }
//      public static int helper(int n,int[] nums,int[] dp){
//            dp[0]=nums[0];
//
//            for(int i=1;i<nums.length;i++){
//                int take=nums[i];
//                if(i>1) {
//                    take += dp[i - 2];
//                }
//                int nottake=dp[i-1];
//
//                dp[i]=Math.max(take,nottake);
//            }
//            return dp[n];
//       }
//    public static int helper(int n,int[] nums,int[] dp){
//        dp[0]=nums[0];
//
//        for(int i=1;i<nums.length;i++){
//            int take=nums[i];
//            if(i>1) {
//                take += dp[i - 2];
//            }
//            int nottake=dp[i-1];
//
//            dp[i]=Math.max(take,nottake);
//        }
//        return dp[n];
//    }
    public static int helper(int[] nums){
        if(nums.length==0){
            return 0;
        }

        int prev=nums[0];
        int prev1=0;

        for(int i=1;i<nums.length;i++){
            int take=nums[i];
            if(i>1) {
                take += prev1;
            }
            int nottake=prev;

            int curr=Math.max(take,nottake);
            prev1=prev;
            prev=curr;

        }
        return prev;
    }

}
