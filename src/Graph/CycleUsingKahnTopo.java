package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleUsingKahnTopo {
    public static void main(String[] args) {
        int[][] arr={
                {1},
                {2},
                {0}
        };
        int n=arr.length;
        boolean[] vis=new boolean[n];
        int[] indegree=new int[n];
        Queue<Integer> myq=new LinkedList<>();
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<arr[0].length;i++){
                if (arr[i][j] == 1) {
                    indegree[j]++;
                }
            }
        }

        for(int i=0;i< arr.length;i++){
            if(indegree[i]==0){
                myq.offer(i);
            }
        }
        while (!myq.isEmpty()){
            int num=myq.peek();
            myq.poll();
            count++;

            for(int i=0;i<arr[num].length;i++){
                int temp=arr[num][i];
                indegree[temp]--;
                if(indegree[temp]==0){
                    myq.offer(temp);
                }
            }

        }
        System.out.println(count);

    }
}
