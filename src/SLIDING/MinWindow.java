package SLIDING;

import java.util.HashMap;

public class MinWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        int minlen = Integer.MAX_VALUE;
        String ans = "";
        int l = 0;
        int r = 0;
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) - 1);
        }
        while (r < s.length()) {
            char ch = s.charAt(r);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
                if (map.get(ch) == 0)
                    count++;
            }

            while (count == map.size()) {
                if (minlen > (r - l + 1)) {
                    ans = s.substring(l, r + 1);
                    minlen = r - l + 1;
                }

                char ch1 = s.charAt(l);
                if (map.containsKey(ch1)) {
                    if (map.get(ch1) == 0)
                        count--;
                    map.put(ch1, map.get(ch1) - 1);
                }
                l++;
            }
            r++;
        }
        return ans;
    }
}
