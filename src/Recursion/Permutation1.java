package Recursion;

import java.util.ArrayList;

public class Permutation1 {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        boolean[] check=new boolean[arr.length];
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        helper(arr,check,ans,temp);
        System.out.println(ans);
    }
    static void helper(int[] arr,boolean[] check,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer>temp)
    {
        if(arr.length==temp.size())
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<arr.length;i++)
        {
            if(!check[i])
            {
                check[i]=true;
                temp.add(arr[i]);
                helper(arr,check,ans,temp);
                check[i]=false;
                temp.remove(temp.size()-1);
            }
        }

    }
}
