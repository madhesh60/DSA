package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Combination3 {
    public static void main(String[] args) {
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = i + 1;
        }
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(arr, 7, 0, ans, temp, 3);

        System.out.println(ans);
    }

    static void helper(int[] arr, int target, int index, List<List<Integer>> ans, List<Integer> temp, int k) {
        if (target == 0 && temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < arr.length; i++) {

            if (arr[i] > target)
                break;

            temp.add(arr[i]);
            helper(arr, target - arr[i], i + 1, ans, temp, k);
            temp.remove(temp.size() - 1);
        }


    }
}
