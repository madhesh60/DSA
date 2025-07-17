package BINSEARCH;

public class KthMiss {
    public static void main(String[] args) {
        int[] arr={2,3,4,7,11};
        System.out.println(findKthPositive(arr,5));
    }
    public static int findKthPositive(int[] arr, int k) {
        int start=0;
        int end=arr.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            int miss=arr[mid]-(mid+1);
            if(miss<k)
                start=mid+1;
            else
                end=mid-1;
        }
        return end+k+1;
    }
}
