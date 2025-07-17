package GreedyProb;

public class JumpGame2 {
    public static void main(String[] args) {
        int[] nums={2,3,1,4,1,1,1,2};
        System.out.println(helper(nums));
    }
    public static int helper(int[] nums)
    {
        int l=0;
        int r=0;
        int count=0;
        while(r<nums.length-1)
        {
            int max=0;
            for(int i=l;i<=r;i++)
            {
               max=Math.max(i+nums[i],max);
            }
            l=r+1;
            r=max;
            count++;
        }
        return count;
    }
}
