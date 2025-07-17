package SLIDING;

public class MaxOnes {
    public static void main(String[] args) {
        int[] nums={1,1,1,0,0,0,1,1,1,1,1,0};
        System.out.println(helper(nums,2));
    }
    public static int helper(int[] nums,int k)
    {
        int l=0;
        int maxans=0;
        int zeros=0;
        for (int r=0; r<nums.length;r++) {
            if (nums[r] == 0)
                zeros++;

            while (zeros > k) {
                if (nums[l] == 0)
                    zeros--;
                l++;
            }

            maxans = Math.max(maxans, r - l + 1);
        }
        return maxans;
    }
}
