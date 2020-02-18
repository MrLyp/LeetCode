package com.robbie;

import java.util.HashMap;
import java.util.Map;

public class So409 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
        }
        int ans = 0;
        boolean single = false;
        for (char c : map.keySet()) {
            int count = map.get(c);
            if (count >= 2) {
                if (count % 2 == 0)
                    ans += count;
                else {
                    ans += count - 1;
                    single = true;
                }
            } else {
                single = true;
            }
        }
        if (single) ans++;
        return ans;
    }

    public static void main(String[] args) {
        So409 so = new So409();
        System.out.println(so.longestPalindrome("abccccdd"));
    }
}
