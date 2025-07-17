package BINSEARCH;

public class NthRoot {
    public static void main(String[] args) {
        System.out.println(helper(1,100000000));
    }
    public static int  helper(int n,int num)
    {
        int start=1;
        int end=num;
        int mid=0;
        while(start<=end)
        {
            mid=(start+end)/2;
            int check=ans(mid,n,num);
            if(check==1)
                return mid;
            else if(check==2)
                end=mid-1;
            else
                start=mid+1;
        }
        return -1;
    }
    public static int ans(int mid,int n,int num)
    {
        long val=1;
        for(int i=1;i<=n;i++)
        {
            val=val*mid;
            if(val>num)
                return 2;
        }
        if(val==num)
            return 1;
        return 0;
    }
}
