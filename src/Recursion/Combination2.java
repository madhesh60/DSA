package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination2 {
    public static void main(String[] args) {
        int[] arr={10,1,2,7,6,1,5};
        Arrays.sort(arr);
        List<Integer> temp=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        helper(arr,8,0,ans,temp);

        System.out.println(ans);
    }
    static void helper(int[] arr, int target, int index, List<List<Integer>> ans, List<Integer> temp)
    {

        if(target==0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index;i<arr.length;i++)
        {

            if(i>index && arr[i]==arr[i-1])
                continue;

            if(arr[i]>target)
                break;

            temp.add(arr[i]);
            helper(arr,target-arr[i],i+1,ans,temp);
            temp.remove(temp.size()-1);
        }

    }
}
