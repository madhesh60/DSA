package SLIDING;

import java.util.Arrays;

public class ContainsThree {
    public static void main(String[] args) {
        System.out.println(helper("bbacba"));
    }
    public static int helper(String s)
    {
        int count=0;
        int[] check=new int[3];
        Arrays.fill(check,-1);
        for(int i=0;i<s.length();i++) {
            check[s.charAt(i) - 'a'] = i;
            if(check[0]!=-1 && check[1]!=-1 && check[2]!=-1) {
                int allmin =0;
                allmin=Math.min(check[0], check[1]);
                allmin = Math.min(allmin, check[2]);
                count = count+(allmin+1);
            }
        }
        return count;
    }

}
/*
public static int helper(int[] nums,int k)
    {
        int maxans=0;
        for(int i=0;i< nums.length;i++)
        {
            int count=0;
            for(int j=i;j<nums.length;j++)
            {
                if(count>k)
                break;
                if(nums[j]==0)
                    count++;
                if(count<=k)
                    maxans=Math.max(maxans,j-i+1);
            }
        }
        return maxans;
    }
 */