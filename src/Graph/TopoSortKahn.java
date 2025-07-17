package Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopoSortKahn {
    public static void main(String[] args) {

    }
    public static ArrayList<Integer> helper(int[][] arr){
        int n=arr.length;
        int[] indegree=new int[n];
        Queue<Integer> myq=new LinkedList<>();
        ArrayList<Integer> ans=new ArrayList<>();

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
            ans.add(num);

            for(int i=0;i<arr[num].length;i++){
                int temp=arr[num][i];
                indegree[temp]--;
                if(indegree[temp]==0){
                    myq.offer(temp);
                }
            }

        }
        return ans;

    }
}
