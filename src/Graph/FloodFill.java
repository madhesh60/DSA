package Graph;

import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
        int[][] arr={{1,1,1},{1,1,0},{1,0,1}};
        int r=1;
        int c=1;
        System.out.println(Arrays.deepToString(floodFill(arr,r,c,2)));
    }
    public static int[][] floodFill(int[][] arr, int row, int col, int newcolor) {
        if (arr[row][col] == newcolor) {
            return arr;
        }

        int init=arr[row][col];

        dfs(arr,row,col,init,newcolor);
        return arr;
    }
    public static void dfs(int[][] arr,int row,int col,int init,int newcolor){

        if (col<0 || col>= arr[0].length || row<0 || row>=arr.length || arr[row][col]!=init)
            return;

        arr[row][col]=newcolor;

        dfs(arr,row+1,col,init,newcolor);
        dfs(arr,row-1,col,init,newcolor);
        dfs(arr,row,col+1,init,newcolor);
        dfs(arr,row,col-1,init,newcolor);

    }

}
