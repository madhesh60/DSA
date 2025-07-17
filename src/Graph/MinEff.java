package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinEff {
    public static void main(String[] args) {

    }
    public static int helper(int[][] arr) {
        PriorityQueue<Node> myq = new PriorityQueue<>((x,y)-> x.first-y.first);
        int[][] img = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(img[i], Integer.MAX_VALUE);
        }
        img[0][0] = 0;
        int maxeff=0;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        myq.add(new Node(0,0,0));

        while (!myq.isEmpty()) {
            Node node = myq.poll();
            int dist = node.first;
            int src0 = node.second;
            int src1 = node.third;

            if (src0 == arr.length - 1 && src1==arr[0].length - 1) {
                return dist;
            }

            for (int i = 0; i < dr.length; i++) {
                int nrow = src0+ dr[i];
                int ncol = src1+ dc[i];

                if(nrow >= 0 && nrow < arr.length && ncol >= 0 && ncol < arr[0].length){
                    maxeff=Math.max(Math.abs(arr[nrow][ncol]-arr[src0][src1]),dist);
                    if (maxeff<img[nrow][ncol]){
                        img[nrow][ncol] = maxeff;
                        myq.add(new Node(maxeff, nrow, ncol));
                    }
                }
            }
        }
        return 0;
    }
}
