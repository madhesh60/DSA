package Graph;

import java.sql.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryMaze {
    public static void main(String[] args) {

    }
    public static int helper(int[][] arr) {
        if(arr[0][0]==1  || arr[arr.length-1][arr[0].length-1]==1)
            return -1;

        Queue<Node> myq = new LinkedList<>();
        int[][] img = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(img[i], Integer.MAX_VALUE);
        }
        img[0][0] = 1;
        int[] dr = {-1,-1,0,1,1,1,0,-1};
        int[] dc = {0,1,1,1,0,-1,-1,-1};

        myq.add(new Node(1,0,0));

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

                if (nrow >= 0 && nrow < arr.length && ncol >= 0 && ncol < arr[0].length && arr[nrow][ncol] == 0 && dist + 1 < img[nrow][ncol]) {
                    img[nrow][ncol] = 1 + dist;
                    myq.add(new Node(1 + dist, nrow, ncol));
                }
            }
        }
        return -1;
    }
}
