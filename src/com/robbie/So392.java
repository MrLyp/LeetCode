package com.robbie;

public class So392 {
    public boolean isSubsequence(String s, String t) {
        int si = 0;
        int ti = 0;
        while (si < s.length() && ti < t.length()) {
            if (s.charAt(si) == t.charAt(ti)) {
                si++;
                ti++;
            } else {
                ti++;
            }
        }
        return si == s.length();
    }

    public static void main(String[] args) {
        So392 so = new So392();
        System.out.println(so.isSubsequence("abc", "ahbgdc"));
        System.out.println(so.isSubsequence("axc", "ahbgdc"));
    }
}
