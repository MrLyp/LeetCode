package com.robbie;

/**
 * Created by leeyunpeng on 2019/7/16.
 */
public class So44 {
    public boolean isMatch(String s, String p) {
        if (s == null)
            return p == null;
        if (s.length() == 0) {
            if (p.length() == 0)
                return true;
            int i = 0;
            while (i < p.length()) {
                if (p.charAt(i++) != '*')
                    return false;
            }
            return true;
        }
        if (p == null || p.length() == 0)
            return false;
        if (p.length() == 1) {
            if (p.charAt(0) == '*')
                return true;
            else
                return s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?');
        } else {
            if (p.charAt(0) == '*') {
                int t = 0;
                while (t < p.length()) {
                    if (p.charAt(t) != '*')
                        break;
                    t++;
                }
                for (int i = 0; i < s.length(); i++) {
                    if (isMatch(s.substring(i), p.substring(t > 1? t - 1 : 1)))
                        return true;
                }
            } else if (p.charAt(0) == '?') {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return s.charAt(0) == p.charAt(0) && isMatch(s.substring(1), p.substring(1));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        So44 so = new So44();
        System.out.println(so.isMatch("aa", "a"));
        System.out.println(so.isMatch("aa", "*"));
        System.out.println(so.isMatch("cb", "?a"));
        System.out.println(so.isMatch("adceb", "*a*b"));
        System.out.println(so.isMatch("acdcb", "a*c?b"));
        System.out.println(so.isMatch("mississippi", "m??*ss*?i*pi"));
        System.out.println(so.isMatch("ho", "ho**"));
        System.out.println(so.isMatch("aaba", "?***"));
        System.out.println(so.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"));
    }
}
