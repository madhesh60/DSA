package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation2 {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();

        helper(0,arr,ans);
        System.out.println(ans);
    }
    static void helper(int index,int[] arr,ArrayList<ArrayList<Integer>> ans)
    {
        if(arr.length==index)
        {
            ArrayList<Integer> temp=new ArrayList<>();
            for(int i=0;i<arr.length;i++)
            {
                temp.add(arr[i]);
            }
            ans.add(new ArrayList<>(new ArrayList<>(temp)));
            return;
        }
        for(int i=index;i<arr.length;i++)
        {
            swap(i,index,arr);
            helper(index+1,arr,ans);
            swap(i,index,arr);
        }
    }
    static void swap(int a,int b,int[] arr)
    {
        int t=arr[a];
        arr[a]=arr[b];
        arr[b]=t;
    }
}
