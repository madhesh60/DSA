package Graph;

import java.util.HashMap;
import java.util.Map;

public class StoneRemove {
    public static void main(String[] args) {

    }
    public static int helper(int[][] adj,int n){
        int maxrow=0;
        int maxcol=0;
        for(int i=0;i<adj.length;i++){
            maxrow=Math.max(maxrow,adj[i][0]);
            maxcol=Math.max(maxcol,adj[i][1]);
        }
        Disjoint ds = new Disjoint(maxrow + maxcol + 1);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int noderow=adj[i][0];
            int nodecol=adj[i][1]+maxrow+1;

            ds.UnionBySize(nodecol,noderow);
            map.put(nodecol,1);
            map.put(noderow,1);
        }
        int cnt=0;
        for(Map.Entry<Integer,Integer> it:map.entrySet()){
            if(ds.findU(it.getKey())==it.getKey()){
                cnt++;
            }
        }
        return n-cnt;
    }
}
