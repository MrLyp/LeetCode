package com.robbie;

public class So387 {
    public int firstUniqChar(String s) {
        int[] map = new int[256];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        So387 so = new So387();
        System.out.println(so.firstUniqChar("leetcode"));
        System.out.println(so.firstUniqChar("loveleetcode"));

    }
}
