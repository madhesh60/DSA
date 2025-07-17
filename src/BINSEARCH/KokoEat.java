package BINSEARCH;

import java.util.Arrays;

public class KokoEat {
    public static void main(String[] args) {
        int[] nums={3,6,7,11};
        int start=1;
        int end=findmax(nums);
        int ans=0;
        int k=8;
        while(start<=end)
        {
            int mid=(start+end)/2;
            int check=helper(nums,mid);
            if(check<=k)
            {
                ans=mid;
                end=mid-1;
            }
            else
                start=mid+1;
        }
        System.out.println(ans);
    }
    public static int helper(int[] nums,int mid) {
    int ans=0;
    for(int i=0;i<nums.length;i++)
        {
          ans+=Math.ceil((double)nums[i]/(double)mid);
        }
    return ans;
    }
    public static int findmax(int[] nums)
    {
        int maxans=-1;
        for(int i=0;i<nums.length;i++) {
            maxans = Math.max(nums[i], maxans);
        }
        return maxans;
    }
}
