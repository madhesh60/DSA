package BINSEARCH;

public class NoOfOne {
    public static void main(String[] args) {
         int[][] mat={
                {0,0,1},
                {1,1,1},
                {1,1,1}
        };
        System.out.println(helper(mat));

    }
    public static int helper(int[][] mat)
    {
        int ans=0;
        int index=-1;
        int maxans=0;

        for(int i=0;i<mat.length;i++)
        {
            int maxone=binsearch(mat[i],1);
            if(maxans<maxone)
            {
                maxans=maxone;
                index=i;
            }
        }
        return index;
    }
    public static int binsearch(int[] mat,int target)
    {
        int start=0;
        int end=mat.length-1;
        int mid;
        int ans=0;
        while(start<end)
        {
            mid=(start+end)/2;
            if(mat[mid]>=target) {
                ans=mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }

}
