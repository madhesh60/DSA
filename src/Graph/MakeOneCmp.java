package Graph;

public class MakeOneCmp {
    public static void main(String[] args) {

    }
    public static int helper(int n,int[][] arr){
        Disjoint ds=new Disjoint(n);
        int extra=0;
        int cmp=0;

        for(int i=0;i<arr.length;i++){
            int u=arr[i][0];
            int v=arr[i][1];

            if(ds.findU(u)== ds.findU(v)){
                extra++;
            }
            else{
                ds.UnionBySize(u,v);
            }
        }
        for(int i=0;i<n;i++) {
            if(ds.parent.get(i)==i){
                cmp++;
            }
        }

        return extra>=cmp ? cmp:-1;
    }
}
