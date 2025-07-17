package BINSEARCH;


public class PeakEl {
    public static void main(String[] args) {
        int[] nums = {1, 8, 1, 3, 5, 6, 4};
        System.out.println(helper(nums));
    }

    public static int helper(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (arr[mid] < arr[mid + 1])
                start = mid + 1;
            else if (arr[mid] > arr[mid + 1])
                end = mid;
        }
        return end;
    }
}
