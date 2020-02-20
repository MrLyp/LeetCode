package com.robbie;

import java.util.Arrays;

public class So424 {
    public int characterReplacement(String s, int k) {
        if (s.length() == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        int[] count = new int[26];
        int localMaxCount = 0;
        while (end < s.length()) {
            int curCount = ++count[chars[end] - 'A'];
            localMaxCount = Math.max(localMaxCount, curCount);
            while (end - start + 1 - localMaxCount > k) {
                count[chars[start] - 'A']--;
                start++;
            }
            max = Math.max(max, end - start + 1);
            end++;
        }
        return max;
    }

    public static void main(String[] args) {
        So424 so = new So424();
        System.out.println(so.characterReplacement("AABABBA", 1));
        System.out.println(so.characterReplacement("ABBB", 2));
    }
}
