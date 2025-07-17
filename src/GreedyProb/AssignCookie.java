package GreedyProb;

import java.util.Arrays;

public class AssignCookie {
    public static void main(String[] args) {
        int[] arr1={1,2,3};
        int[] arr2={4,3};
        System.out.println(helper(arr1,arr2));
    }
    public static int helper(int[] g,int[] s)
    {
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        int l=0;
        int r=0;
        while(l<g.length && r< s.length)
        {
            if(s[r]>=g[l]) {
                count++;
                l++;
                r++;
            }
            else {
               r++;
            }
        }
        return count;
    }
}
