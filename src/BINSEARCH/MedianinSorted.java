package BINSEARCH;

import javax.swing.*;

public class MedianinSorted {
    public static void main(String[] args) {
        int a[]={1,3};
        int  b[]={2};
        System.out.println(helper(a,b));
    }
    public static double helper(int[] a,int[] b)
    {
        if(a.length>b.length)
            return helper(b,a);
        int ans=0;
        int start=0;
        int end=a.length;
        int n=a.length+b.length;
        int left=(a.length+b.length+1)/2;
        while(start<=end)
        {
            int mid1=(start+end)/2;
            int mid2=left-mid1;

            int l1=(mid1>0) ? a[mid1-1]:Integer.MIN_VALUE;
            int l2=(mid2>0) ? b[mid2-1]:Integer.MIN_VALUE;
            int r1=mid1<a.length ? a[mid1]:Integer.MAX_VALUE;
            int r2=mid2<b.length ? b[mid2]:Integer.MAX_VALUE;

            if(l1<r2 && l2<r1)
            {
                if(n%2==1)
                    return (double)(Math.max(l1,l2));
                else
                    return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            }
            else if(l1>r2)
                end=mid1-1;
            else
                start=mid1+1;

        }
        return -1;
    }

}
