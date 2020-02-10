package com.robbie;

import java.util.Map;

public class So383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (int i = 0;i < magazine.length(); i++) {
            map[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--map[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        So383 so = new So383();
        System.out.println(so.canConstruct("ab", "aa"));
    }
}
