package com.robbie;

import java.util.*;

public class So438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length())
            return res;
        int[] pc = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pc[p.charAt(i) - 'a']++;
        }
        int start = 0;
        int end = start + p.length() - 1 ;
        int[] sc = new int[26];
        for (int i = start; i <= end; i++ ){
            sc[s.charAt(i) - 'a']++;
        }
        while (end < s.length()) {
            if (Arrays.equals(sc, pc))
                res.add(start);
            sc[s.charAt(start) - 'a']--;
            start++;
            end++;
            if (end == s.length())
                break;
            sc[s.charAt(end) - 'a']++;
        }
        return res;
    }

    public static void main(String[] args) {
        So438 so = new So438();
        System.out.println(so.findAnagrams("cbaebabacd", "abc"));
        System.out.println(so.findAnagrams("ababa", "ab"));
        System.out.println(so.findAnagrams("baa", "aa"));
    }
}
