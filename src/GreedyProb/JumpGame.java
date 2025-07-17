package GreedyProb;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums={3,2,1,0,4};
        System.out.println(helper(nums));
    }
    public static boolean helper(int[] nums)
    {
        int max=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i>max)
                return false;

            max=Math.max(max,i+nums[i]);
        }
        return true;
    }
}
