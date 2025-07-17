package BINSEARCH;

public class Divisor {
    public static void main(String[] args) {
        int[] nums={44,22,33,11,1};
        System.out.println(smallestDivisor(nums,5));
    }
    public static int smallestDivisor(int[] nums, int threshold) {
        int ans=0;
        int start=1;
        int end=Integer.MIN_VALUE;
        for(int i:nums)
        {
            end=Math.max(i,end);
        }
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(helper(nums,mid)<=threshold)
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
        int res=0;
        for(int i:nums)
        {
            res+=Math.ceil((double)i/mid);
        }
        return res;
    }
}
