package com.robbie;

public class So87 {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null)
            return s2 == null;
        if (s1.length() != s2.length())
            return false;
        if (s1.length() == 0)
            return true;
        if (s1.length() == 1)
            return s1.equals(s2);
        if (s1.equals(s2))
            return true;
        int len = s1.length();
        int[] letters = new int[26];
        for (int i = 0; i < len; i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++)
            if (letters[i] > 0)
                return false;

        for (int i = 0; i < len - 1; i++) {
            if (isScramble(s1.substring(0, i + 1), s2.substring(0, i + 1)) &&
                    isScramble(s1.substring(i + 1), s2.substring(i + 1))) {
                return true;
            }
        }
        // 逆序
        for (int i = 0; i < len - 1; i++) {
            if (isScramble(s1.substring(0, i + 1), s2.substring(len - i - 1)) &&
                    isScramble(s1.substring(i + 1), s2.substring(0, len - i - 1))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        So87 so = new So87();
        System.out.println(so.isScramble("abcdefghijklmnopq",
                "efghijklmnopqcadb"));
    }
}
