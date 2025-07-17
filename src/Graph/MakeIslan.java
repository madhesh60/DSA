package Graph;

import java.util.ArrayList;
import java.util.List;

public class MakeIslan {
    public static void main(String[] args) {

    }
    public static boolean valid(int adjr,int adjc,int n,int m){
        return adjc>=0 && adjc<n && adjr>=0 && adjr<m;
    }
    public static List<Integer> helper(int[][] arr,int n,int m){
        Disjoint ds=new Disjoint(n*m);
        int cnt=0;
        int[][] vis=new int[n][m];
        List<Integer> ans=new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            int row=arr[i][0];
            int col=arr[i][1];

            if (vis[row][col] == 1) {
                ans.add(cnt);
                continue;
            }
            vis[row][col]=1;
            cnt++;

            int[] dr={-1,0,1,0};
            int[] dc={0,1,0,-1};
            for(int j=0;i<4;i++){
                int adjr=row+dr[i];
                int adjc=col+dc[i];

                if(valid(adjr,adjc,n,m)){
                    if (vis[adjr][adjc] == 1) {
                        int Node = row * m + col;
                        int adjNode = adjr * m + row;
                        if (ds.findU(Node) != ds.findU(adjNode)) {
                            cnt--;
                            ds.UnionBySize(Node, adjNode);
                        }
                    }
                }
            }
            ans.add(cnt);


        }

        return ans;
    }

}
