package BINSEARCH;

public class SplitArray {  //*****PAINTER PARTITION ALSO HAS SOME METHOD AND LOGIC*****\\
    public static void main(String[] args) {
        int[] nums={7,2,5,10,8};
        int k=2;
        System.out.println(splitArray(nums,k));
    }
    public static int splitArray(int[] nums, int k) {
        int start=-1;
        int end=0;
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            start=Math.max(nums[i],start);
            end+=nums[i];
        }
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(helper(nums,mid,k)>k)
                start=mid+1;
            else
            {
                // ans=mid;
                end=mid-1;
            }
        }
        return start;
    }
   public static int helper(int[] nums,int mid,int k)
    {
        int div=1;
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            if(sum+nums[i]<=mid)
                sum=sum+nums[i];
            else
            {
                sum=nums[i];
                div++;
            }
        }
        return div;
    }
}
