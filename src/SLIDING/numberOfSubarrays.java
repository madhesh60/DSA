package SLIDING;

public class numberOfSubarrays {
    public static void main(String[] args) {
        int[] nums={2,2,2,1,2,2,1,2,2,2};
        System.out.println(helper(nums,2));
    }
    public static int helper(int[] nums,int k)
    {
        int l=0;
        int r=0;
        int count=0;
        int ans=0;
        int n=nums.length;
        while(r<n)
        {
            if((nums[r]&1)==1)
                count++;
            if(count>k)
            {
                if((nums[l]&1)==1)
                    count--;
                l++;
            }
            if(count==k)
            {
                ans+=n-r;
            }
            r++;
        }
        return ans;
    }
}
