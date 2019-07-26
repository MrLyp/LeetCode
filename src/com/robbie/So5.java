package com.robbie;

import java.util.Arrays;

public class So5 {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty())
            return s;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
        }
        int max = 0;
        String res = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (i + 1 == j) {
                    if (s.charAt(i) == s.charAt(j))
                        dp[i][j] = 2;
                    else
                        dp[i][j] = -1;
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] > 0) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = -1;
                    }
                }
                if (max < dp[i][j]) {
                    max = dp[i][j];
                    res = s.substring(i, j + 1);
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        return res;
    }

    public static void main(String[] args) {
        So5 so = new So5();
//        System.out.println(so.longestPalindrome("abba"));
//        System.out.println(so.longestPalindrome("a"));
        System.out.println(so.longestPalindrome("aacdefcaa"));
    }
}
