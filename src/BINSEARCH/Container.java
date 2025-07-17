package BINSEARCH;

public class Container{
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7,8,9,10};
        System.out.println( shipWithinDays(nums,5));
    }
    public static int shipWithinDays(int[] nums, int days) {
        int ans=0;
        int start=1;
        int end=0;
        for(int i:nums)
        {
            end+=i;;
        }
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(helper(nums,mid)<=days)
            {
                ans=mid;
                end=mid-1;
            }
            else
                start=mid+1;
        }
        return ans;
    }
    public static int helper(int[] nums,int mid)
    {
        int count=1;
        int sum=0;
        for(int i:nums)
        {
            sum+=i;
            if(sum>=mid)
            {
                sum=i;
                count++;
            }
        }
        return count;
    }
}

