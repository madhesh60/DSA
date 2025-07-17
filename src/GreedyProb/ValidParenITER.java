package GreedyProb;

public class ValidParenITER {
    public static void main(String[] args) {
        String str="(((((()*)(*)*))())())(()())())))((**)))))(()())()";
        System.out.println(helper(str));
    }

    public static boolean helper(String str) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                min++;
                max++;
            } else if (str.charAt(i) == ')') {
                min--;
                max--;
            } else {
                min--;
                max++;
            }
            if (min < 0) {
                min = 0;
            }

            if (max < 0)
                return false;
        }
        return min == 0;
    }
}
