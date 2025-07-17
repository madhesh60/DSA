package BINSEARCH;

public class SingleEL {
    public static void main(String[] args) {
        int[] nums={3,3,7,7,10,11,11};
        System.out.println(helper(nums));
    }
    public static int helper(int[] nums)
    {
        int n=nums.length;
        if(nums.length==1)
            return nums[0];
        if(nums[0]!=nums[1])
            return nums[0];
        if(nums[n-1]!=nums[n-2])
            return nums[n-1];
        int start=1;
        int end=nums.length-2;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1])
                return nums[mid];

            if(mid%2==1 && nums[mid]==nums[mid-1] || mid%2==0 && nums[mid]==nums[mid+1])
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }
}
