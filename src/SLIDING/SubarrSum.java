package SLIDING;

import java.util.HashMap;

public class SubarrSum {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(helper(nums,3));
    }
    public static int helper(int[] nums,int k)
    {
        int count = 0, sum = 0;
        HashMap< Integer,Integer> map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
/*
Fixed Window → Use a single loop and maintain a window of size k.
Variable Window → Expand with right, shrink with left when needed.
At Most K vs Exactly K → Use helper(k) - helper(k-1).
Frequency Map → Use HashMap for tracking counts.
Count Subarrays → Use right - left + 1 in the count.



                   ANOTHER LOGIC
1️⃣ Constant Wind
sum += arr[r] - (r >= k ? arr[r - k] : 0);

2️⃣ Longest Subarray (Variable Size Window)
✅ Hint: Expand r, shrink l only when violating the condition.
while (<invalid condition>) map.put(arr[l], map.get(arr[l]) - 1); l++;

3️⃣ Count of Subarrays Satisfying Condition------>(helper(k) - helper(k-1))
✅ Hint: Count subarrays with at most k distinct elements and subtract at most k-1.
count += r - l + 1;

4️⃣ Shortest/Minimum Window
✅ Hint: Expand r until condition is met, then shrink l to minimize.
if (condition met) minLen = Math.min(minLen, r - l + 1);
 */
