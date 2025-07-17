package Graph;
import java.util.*;

public class AlienDict {
    public static void main(String[] args) {
        int K = 3;
        String[] dict = {"caa","aaa","aab"};
        System.out.println(helper(dict,K).toString());
    }
    public static ArrayList<Character> helper(String[] str,int K){
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0;i<K ; i++) {
            arr.add(new ArrayList<>());
        }

        Map<Character,Integer> map=new HashMap<>();
        map.put('a',0);
        map.put('b',1);
        map.put('c',2);
        map.put('d',3);

        for(int i=0;i<str.length-1;i++){
            String s=str[i];
            String s1=str[i+1];

            int l=0;
            int r=0;
            while(l<s.length() && r<s1.length() && s.charAt(l)==s1.charAt(r)){
                l++;
                r++;
            }

            if (l < s.length() && r < s1.length()) {
                char ch = s.charAt(l);
                char ch1 = s1.charAt(r);
                arr.get(map.get(ch)).add(map.get(ch1));
            }

        }
        ArrayList<Integer> ans=topo(arr,K);
        ArrayList<Character> fans=new ArrayList<>();

        for(int i=0;i<K;i++){
            int index = ans.get(i);
            fans.add((char) ('a' + index));
        }
        return fans;
    }
    public static ArrayList<Integer> topo(List<List<Integer>> arr,int K) {
        boolean[] vis=new boolean[K];
        int[] indegree=new int[K];
        Queue<Integer> myq=new LinkedList<>();
        ArrayList<Integer> ans=new ArrayList<>();

        for(int i=0;i<K;i++){
            for(int j=0;j<arr.get(i).size();j++){
                indegree[arr.get(i).get(j)]++;
            }
        }

        for(int i=0;i<K;i++){
            if(indegree[i]==0){
                myq.offer(i);
            }
        }
        while (!myq.isEmpty()){
            int num=myq.peek();
            myq.poll();
            ans.add(num);

            for(int i=0;i<arr.get(num).size();i++){
                int temp=arr.get(num).get(i);
                indegree[temp]--;
                if(indegree[temp]==0){
                    myq.offer(temp);
                }
            }

        }
        return ans;
    }

}
