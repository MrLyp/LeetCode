package com.robbie;

/**
 * Created by leeyunpeng on 2019/7/16.
 */
public class So44 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*')
                dp[0][i] = dp[0][i - 1];
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
                }
            }
        }
        return dp[s.length()][p.length()];
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
