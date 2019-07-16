package com.robbie;

public class So10 {

    public boolean isMatch(String s, String p) {

        if (p.length() == 0)
            return s.length() == 0;
        if (p.length() == 1) {
            return s.length() == 1 && matchFirst(s, p);
        }
        if (p.charAt(1) != '*') {
            if (s.length() < 1)
                return false;
            if (matchFirst(s, p))
                return isMatch(s.substring(1), p.substring(1));
            else
                return false;
        }
        if (isMatch(s, p.substring(2)))
            return true;
        int i = 0;
        while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
            if (isMatch(s.substring(i + 1), p.substring(2)))
                return true;
            i++;
        }
        return false;

    }

    private boolean matchFirst(String s, String p) {
        return s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
    }

    public static void main(String[] args) {
        // write your code here
        So10 so = new So10();
        System.out.println(so.isMatch("aab", "c*a*b"));
        System.out.println(so.isMatch("ab", ".*"));
        System.out.println(so.isMatch("mississippi", "mis*is*p*."));
    }
}
