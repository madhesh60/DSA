package BINSEARCH;

public class NoofRot{
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        System.out.println(helper(nums));
    }
    public static int helper(int[] nums) {
        int start=0;
        int end=nums.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(mid<end && nums[mid]>nums[mid+1])
                return mid+1;
            else if(mid>start && nums[mid]<nums[mid-1])
                return mid;
            else
            {
                if(nums[mid]>nums[end])
                    start=mid+1;
                else
                    end=mid-1;
            }
        }
        return 0;
    }

}
