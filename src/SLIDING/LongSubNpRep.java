package SLIDING;

import java.util.Arrays;

public class LongSubNpRep {
    public static void main(String[] args) {
        System.out.println(helper("cadbzabcd"));
    }
    public static int helper(String s)
    {
        int maxans=0;
        int l=0;
        int r=0;
        int n=s.length();
        int[] hash=new int[256];
        Arrays.fill(hash,-1);
        while(r<n)
        {
            if(hash[s.charAt(r)]!=-1 &&hash[s.charAt(r)]>=l)
                l=hash[s.charAt(r)]+1;
            int len=r-l+1;
            maxans=Math.max(maxans,len);
            hash[s.charAt(r)]=r;
            r++;
        }
        return maxans;
    }
}
