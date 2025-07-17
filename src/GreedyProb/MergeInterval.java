package GreedyProb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        int[][] arr={{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(helper(arr)));
    }
    public static int[][] helper(int[][] intervals){
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans=new ArrayList<>();

        for(int[] interval:intervals)
        {
            if(ans.isEmpty() || interval[0]>ans.getLast()[1])
                ans.add(interval);

            else
                ans.getLast()[1]=Math.max(ans.getLast()[1],interval[1]);
        }
        return ans.toArray(new int[ans.size()][]);

    }
}
