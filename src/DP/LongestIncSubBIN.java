package DP;

import java.util.ArrayList;
import java.util.Collections;

public class LongestIncSubBIN {
    public static void main(String[] args) {

    }
    public static int BinarySearch(int[] nums){
        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(nums[0]);

        for(int i=1;i<nums.length;i++){
            int tempNum=temp.get(temp.size()-1);
             if(nums[i]<tempNum){
                 temp.add(nums[i]);
             }
             else{
                 int ind= Collections.binarySearch(temp,nums[i]);
                 if(ind<0){
                     ind=0;
                 }

                 temp.add(ind,nums[i]);
             }
        }
        return temp.size();
    }
}
