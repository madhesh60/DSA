package Graph;

import java.util.HashSet;
import java.util.*;

public class WordLadder1 {
    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {
                "des",
                "der",
                "dfr",
                "dgt",
                "dfs"
        };
        System.out.println(helper(startWord,targetWord,wordList));
    }
    public static int helper(String start, String target, String[] word){
        Set<String> st=new HashSet<>();
        Queue<Pair1>q= new LinkedList<>();
        q.add(new Pair1(start, 1));

        for(int i=0;i<word.length;i++){
            st.add(word[i]);
        }
        st.remove(start);

        while(!q.isEmpty()){
            String w=q.peek().key;
            int step=q.peek().value;
            q.poll();

            if(w.equals(target)){
                return step;
            }
            for(int i=0;i<w.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] replace=w.toCharArray();
                    replace[i]=ch;

                    String added=new String(replace);
                    if(st.contains(added)){
                        st.remove(added);
                        q.add(new Pair1(added,step+1));
                    }
                }
            }

        }
        return 0;
    }

}
class Pair1{
    String key;
    int value;

    public Pair1(String key,int value) {
        this.key = key;
        this.value = value;
    }
}
