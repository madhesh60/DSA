package DP;

public class UniquePath {
    public static void main(String[] args) {

    }
    public static int uniquePaths(int m, int n) {
        int[] prev=new int[m];
        for(int i=0;i<n;i++){
            int[] temp=new int[m];
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    temp[j]=1;
                }
                else{
                    int up=0;
                    int left=0;

                    if(i>0){
                        up=prev[j];
                    }
                    if(j>0){
                        left=temp[j-1];
                    }

                    temp[j]=up+left;
                }
            }
            prev=temp;
        }
        return prev[m-1];
    }
    public static int uniquePathsRec(int m, int n) {
        return countPaths(0, 0, m, n);
    }

    private static int countPaths(int i, int j, int m, int n) {
        // Base case: reached destination
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // Out of bounds
        if (i >= m || j >= n) {
            return 0;
        }

        // Recursive calls: move right and down
        int right = countPaths(i, j + 1, m, n);
        int down = countPaths(i + 1, j, m, n);

        return right + down;
    }

}
