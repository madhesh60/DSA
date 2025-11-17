package Verify;

//TO IMPLEMENT THE LINEAR SEARCH DETERMINE TIME TO SEARCH FOR AN ELEMENT AND REPEAT THE PROCESS FOR DIFFERENT VALUE OF N
// THE NO OF ELEMENT IN LIST TO BE SEARCHED AND PLOT A GRAPH FOR THE TIME TAKEN

import java.util.*;

public class test {
    public static void main(String[] args) {
        Solution ob=new Solution();
        int[] nums={0,1,2,2,3,0,4,2};
        System.out.println(ob.removeElement(nums,2));
        System.out.println(Arrays.toString(nums));
    }
}
class Solution {
    public int removeElement(int[] nums, int val) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                nums[i]=Integer.MAX_VALUE;
                count++;
            }
        }
        Arrays.sort(nums);
        return count;
    }
}
