package com.robbie;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class So205 {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Character> map = new HashMap<>();
        int[] index = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (map.containsKey(sc)) {
                if (map.get(sc) != tc)
                    return false;
            } else {
                if (index[tc] != 0)
                    return false;
                map.put(sc, tc);
                index[tc] = 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        So205 so = new So205();
        check(so.isIsomorphic("egg", "add"), true);
        check(so.isIsomorphic("bar", "foo "), false);
        check(so.isIsomorphic("foo", "bar "), false);
        check(so.isIsomorphic("paper", "title"), true);
        check(so.isIsomorphic("ab", "aa"), false);
    }

    private static void check(boolean result, boolean expect) {
        if (result == expect) {
            System.out.println("pass");
        } else {
            throw new RuntimeException("expect " + expect);
        }
    }
}
