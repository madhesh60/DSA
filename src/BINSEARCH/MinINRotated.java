package BINSEARCH;

public class MinINRotated {
    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2};
        System.out.println(helper(nums));
    }
    public static int helper(int[] nums) {
        int start=0;
        int end=nums.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(mid<end && nums[mid]>nums[mid+1])
                return nums[mid+1];
            else if(mid>start && nums[mid]<nums[mid-1])
                return nums[mid];
            else
            {
                if(nums[mid]>nums[end])
                    start=mid+1;
                else
                    end=mid-1;
            }
        }
        return nums[0];
    }

}
