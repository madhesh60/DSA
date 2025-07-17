package SLIDING;

public class BinarySum {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        System.out.println(numSubarraysWithSum(nums, 2));
    }
    public static int numSubarraysWithSum(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }
    public static int  helper(int[] nums, int k)
    {
        if(k<0)
            return 0;
        int count=0;
        int sum=0;
        int l=0;
        int r=0;
        while(r<nums.length)
        {
            sum+=nums[r];
            while(sum>k)
            {
                sum-=nums[l];
                l++;
            }
            count+=(r-l+1);
            r++;
        }
        return count;
    }
}

