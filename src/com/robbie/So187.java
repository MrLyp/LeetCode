package com.robbie;

import java.util.*;

/**
 * Created by leeyunpeng on 2018/12/20.
 */
// https://leetcode.com/problems/repeated-dna-sequences/
public class So187 {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) {
            return result;
        }
        int length = s.length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < length - 9; i++) {
            String sub = s.substring(i, i + 10);
            int value = map.get(sub) == null ? 0 : map.get(sub);
            map.put(sub, value + 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) > 1) {
                result.add(key);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        check("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", "[AAAAACCCCC, CCCCCAAAAA]");
        check("AAAAAAAAAAAA", "[AAAAAAAAAA]");
        check("GAGAGAGAGAGA", "[GAGAGAGAGA]");
    }

    private static void check(String str, String expected) {
        So187 so = new So187();
        List<String> res = so.findRepeatedDnaSequences(str);
        if (expected.equals(res.toString())) {
            System.out.println("pass");
        } else {
            throw new RuntimeException(expected + "," + res.toString());
        }
    }
}
