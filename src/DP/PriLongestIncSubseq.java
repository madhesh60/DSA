package DP;
import java.util.*;

public class PriLongestIncSubseq {
    public static void main(String[] args) {

    }
    public static int LongestSubseqSpace(int[] arr){
        int n=arr.length;
        int[] nums=new int[n];
        Arrays.fill(nums,1);
        int ans=1;

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    nums[i]=Math.max(nums[i],nums[j]+1);
                }
            }
        }
        for(int i:nums){
            ans=Math.max(ans,i);
        }
        return ans;
    }
}
