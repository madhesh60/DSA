package BINSEARCH;

import java.util.Arrays;

public class AggCows{
    public static void main(String[] args) {
        int[] nums={0,3,4,7,10};
        System.out.println(helper(nums,4));
    }
    public static int helper(int[] nums,int k)
    {
        int start=1;
        int end=0;
        int ans=0;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        end=max-min;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(CanWePlace(nums,k,mid))
            {
                ans=mid;
                start=mid+1;
            }
            else
                end=mid-1;

        }
        return ans;

    }
    public static boolean CanWePlace(int[] nums,int k,int mid)
    {
        int count=1;
        int last=nums[0];
        for(int i=0;i<nums.length;i++)
        {
            if((nums[i]-last)>=mid)
            {
                count++;
                last=nums[i];
            }
            if(count>=k)
                return true;
        }
        return false;
    }

}
