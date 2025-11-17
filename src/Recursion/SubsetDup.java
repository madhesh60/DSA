package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetDup {
    public static void main(String[] args) {
        int[] arr={1,2,2};
        Arrays.sort(arr);
        List<Integer> temp=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        helper(arr,0,ans,temp);

        System.out.println(ans);

    }
    static void helper(int[] arr,int index,List<List<Integer>> ans,List<Integer> temp)
    {
        ans.add(new ArrayList<>(temp));
        for(int i=index;i<arr.length;i++)
        {

            if(i>index && arr[i]==arr[i-1])
                continue;

            temp.add(arr[i]);
            helper(arr,i+1,ans,temp);
            temp.remove(temp.size()-1);
        }
    }
}
