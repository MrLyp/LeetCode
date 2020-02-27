package com.robbie;

public class So459 {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 2; i <= s.length(); i++) {
            if (s.length() % i != 0)
                continue;
            int len = s.length() / i;
            int start = len;
            String substr = s.substring(0, len);
            while (start < s.length()) {
                String piece = s.substring(start, start + len);
                if (!substr.equals(piece))
                    break;
                start += len;
            }
            if (start == s.length())
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        So459 so = new So459();
        System.out.println(so.repeatedSubstringPattern("abab"));
        System.out.println(so.repeatedSubstringPattern("abba"));
        System.out.println(so.repeatedSubstringPattern("bb"));
    }
}
