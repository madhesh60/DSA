package GreedyProb;


//GIVES TLE FOR LONG LENGTH STRING DUE TO STACK SPACE
//LACK OF MEMOZIZATION-BETTER TO USE DP

public class ValidParanRec {
    public static void main(String[] args) {
        String str="()";
        System.out.println(helper(str,0,0));
    }
    public static boolean helper(String str,int count,int index)
    {
        if(index==str.length() && count==0)
        return true;
        else if(index==str.length() || count<0)
        return false;

        if(str.charAt(index)=='(')
            return helper( str,count+1,index+1);
        else if(str.charAt(index)==')')
            return helper( str,count-1,index+1);

        return helper( str,count+1,index+1)||helper( str,count-1,index+1)||
                helper( str,count,index+1);
    }
}
