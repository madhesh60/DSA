package Recursion;

import java.util.ArrayList;

public class Combination1 {
    public static void main(String[] args) {
        int[] arr={2,3,6,7};
        int target=7;
        ArrayList<Integer> temp=new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        helper(arr,target,0,ans,temp);
        System.out.println(ans);

    }
    static void helper(int[] arr,int target,int index,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> temp)
    {

            if(target==0) {
                ans.add(new ArrayList<>(temp));
                return;
            }
            if(target<0 || index==arr.length)
                return;

        if(arr[index]<=target) {
            temp.add(arr[index]);
            helper(arr,target-arr[index],index,ans,temp);
            temp.remove(temp.size()-1);
        }
        helper(arr,target,index+1,ans,temp);
    }
}
