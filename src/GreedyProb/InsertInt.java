package GreedyProb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInt {
        public static void main(String[] args) {
            int[][] arr={{1,2},{3,5},{6,7},{8,10},{12,16}};
            int[] newInterval={4,8};

            System.out.println(Arrays.deepToString(helper(arr,newInterval)));
        }
        public static int[][] helper(int[][] intervals,int[] newInterval){

            List<int[]> ans=new ArrayList<>();
            int n=intervals.length;
            int i=0;

            while(i<n && intervals[i][1]<newInterval[0]){
                ans.add(intervals[i]);
                i++;
            }

            while(i<n && intervals[i][0]<=newInterval[1]){
                newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
                newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
                i++;
            }
            ans.add(newInterval);

            while(i<n){
                ans.add(intervals[i]);
                i++;
            }

            return ans.toArray(new int[ans.size()][]);
        }
}
