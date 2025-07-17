package BINSEARCH;

public class Bouqe {
    public static void main(String[] args) {
        Bouqe obj=new Bouqe();
        int[] nums={7,7,7,7,12,7,7};
        System.out.println(obj.minDays(nums,2,3));
    }
    public int minDays(int[] nums, int m, int k) {
        long val=(long)m*k;
        if(val>nums.length)
            return -1;
        int ans=0;
        int start=Integer.MAX_VALUE;
        int end=Integer.MIN_VALUE;
        for(int i:nums)
        {
            start=Math.min(i,start);
            end=Math.max(i,end);
        }
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(helper(nums,mid,k)>=m)
            {
                ans=mid;
                end=mid-1;
            }
            else
                start=mid+1;
        }
        return ans;
    }
    static int helper(int[] nums,int mid,int k)
    {
        int ans=0;
        int count=0;
        for(int i:nums)
        {
            if(i<=mid)
            {
                count++;
            }
            else{
                ans+=(count/k);
                count=0;
            }
        }
        ans+=(count/k);
        return ans;
    }
}
