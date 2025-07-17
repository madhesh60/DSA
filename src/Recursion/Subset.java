package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        getHelper(0,arr,temp,ans);

        System.out.println(ans);
        
    }

    private static void getHelper(int index,int[] arr, List<Integer> temp,List<List<Integer>> ans) {
            if(index== arr.length) {
                ans.add(new ArrayList<>(temp));
                return;
            }

            temp.add(arr[index]);
            getHelper(index+1,arr,temp,ans);
            temp.remove(temp.size()-1);
            getHelper(index+1,arr,temp,ans);

    }

}
