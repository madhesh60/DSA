package GreedyProb;

public class Candy {
    public static void main(String[] args) {
        int[] arr={1,0,2};
        System.out.println(helper(arr));
    }
    public static int helper(int[] arr)
    {
        int n=arr.length;
        int sum=1;
        int peak;
        int down;
        int i=1;
        while(i<n)
        {
            if(i<n && arr[i]==arr[i-1]) {
                sum+=1;
                i++;
                continue;
            }
            peak=1;
            while(i<n && arr[i]>arr[i-1]){
                peak++;
                sum+=peak;
                i++;
            }
            down=1;
            while(i<n && arr[i]<arr[i-1]){
                sum+=down;
                down++;
                i++;
            }
            if(peak<down)
                sum+=down-peak;
        }
        return sum;

    }
}
