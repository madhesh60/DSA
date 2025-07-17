package SLIDING;

import java.util.HashMap;

public class BasketFru {
    public static void main(String[] args) {
        int[] nums={3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(nums));
    }
    public static int totalFruit(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int maxans = 0;
        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            if (map.size() > 2) {
                map.put(nums[l], map.getOrDefault(nums[l], 0) - 1);
                if (map.get(nums[l]) == 0)
                    map.remove(nums[l]);
                l++;
            } else if (map.size() <= 2)
                maxans = Math.max(maxans, r - l + 1);
            r++;
        }
        return maxans;
    }
}
