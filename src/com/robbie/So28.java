package com.robbie;

public class So28 {
    public int strStr(String haystack, String needle) {
        if (haystack == null)
            return 0;
        if (needle == null || needle.length() == 0)
            return 0;
        for (int i = 0; i < haystack.length(); i++) {
            int iter = 0;
            int j = i;
            while (j < haystack.length() && iter < needle.length() && haystack.charAt(j) == needle.charAt(iter)) {
                j++;
                iter++;
            }
            if (iter == needle.length()) {
                return j - needle.length();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        So28 so = new So28();
        System.out.println(so.strStr("hello", "ll"));
        System.out.println(so.strStr("aaaaa", "bba"));
        System.out.println(so.strStr("aaa", "a"));
        System.out.println(so.strStr("a", "a"));
        System.out.println(so.strStr("mississippi", "issip"));
    }
}
