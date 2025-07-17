package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MultiplicCount {
    public static void main(String[] args) {

    }
    public static int helper(int start,int[] arr,int end) {
        int mod = 100000;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0));

        int[] dist = new int[100000];
        Arrays.fill(dist, Integer.MAX_VALUE);

        while (!q.isEmpty()) {
            int node = q.peek().key;
            int steps = q.peek().value;
            q.remove();

            for (int num : arr) {
                num = (num * node) % mod;

                if (steps + 1 < dist[num]) {
                    dist[num] = steps + 1;
                    if (num == end) {
                        return steps + 1;
                    }
                    q.add(new Pair(num, steps + 1));
                }
            }
        }
        return -1;
    }
}
