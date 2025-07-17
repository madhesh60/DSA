package GreedyProb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonOverlap {
        public static void main(String[] args) {
            int[][] arr={{0,2},{1,3},{2,4},{3,5},{4,6}};
            System.out.println(helper(arr));
        }
        public static int helper(int[][] intervals){
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

           int temp=intervals[0][1];
            int count=1;

            for(int i=1;i<intervals.length;i++)
            {
               if(intervals[i][0]>=temp)
               {
                   count++;
                   temp=intervals[i][1];
               }
            }
            return intervals.length-count;

        }
}

