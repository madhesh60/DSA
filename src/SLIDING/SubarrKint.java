package SLIDING;

import java.util.HashMap;

import static SLIDING.BinarySum.numSubarraysWithSum;

public class SubarrKint {
        public static void main(String[] args) {
            int[] nums = {1,2,1,2,3};
            System.out.println(numSubarraysWithKint(nums, 2));
        }
        public static int numSubarraysWithKint(int[] nums, int k) {
            return helper(nums,k)-helper(nums,k-1);
        }
        public static int  helper(int[] nums, int k)
        {

            int l=0;
            int r=0;
            int count=0;
            HashMap<Integer,Integer> map=new HashMap<>();
            while(r<nums.length)
            {
                map.put(nums[r],map.getOrDefault(nums[r],0)+1);
                while(map.size()>k)
                {
                    map.put(nums[l],map.getOrDefault(nums[l],0)-1);
                    if(map.get(nums[l])==0)
                        map.remove(nums[l]);
                    l++;
                }
                count+=r-l+1;
                r++;
            }
            return count;
        }
    }
