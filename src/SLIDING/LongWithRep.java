package SLIDING;

import java.util.HashMap;

public class LongWithRep {
    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }

    public static int characterReplacement(String s, int k) {
        int l=0;
        int r=0;
        int maxans=0;
        int maxf=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxf=Math.max(maxf,map.get(ch));
            int changes=(r-l+1)-maxf;
            if(changes<=k)
                maxans=Math.max(maxans,(r-l+1));
            if(changes>k)
            {
                map.put(s.charAt(l),map.getOrDefault(s.charAt(l),0)-1);
                l++;
            }
            r++;
        }
        return maxans;
    }
}
/*
int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
 */