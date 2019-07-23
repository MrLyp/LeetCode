package com.robbie;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by leeyunpeng on 2019/7/22.
 */
public class So91 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        if (s.length() == 1) {
            return isLegal(s.charAt(0)) ? 1 : 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = s.charAt(0) != '0' ? 1 : 0;
        if (isLegal(s.charAt(0)) && isLegal(s.charAt(1)))
            dp[1] = 1;
        if (isLegal(s.charAt(0), s.charAt(1)))
            dp[1] += dp[0];
        for (int i = 2; i < s.length(); i++) {
            if (isLegal(s.charAt(i)))
                dp[i] += dp[i - 1];
            if (isLegal(s.charAt(i - 1), s.charAt(i)))
                dp[i] += dp[i - 2];
        }
        return dp[s.length() - 1];
    }

    private boolean isLegal(char c) {
        return c >= '1' && c <= '9';
    }

    private boolean isLegal(char c1, char c2) {
        if (c1 == '1')
            return true;
        else
            return c1 == '2' && c2 < '7';
    }

    private void decode(Set<String> res, String s, String input, int step) {
        if (step == s.length()) {
            res.add(input);
            return;
        } else if (step > s.length()) {
            return;
        }
        int c = s.charAt(step) - '0';
        if (c == 0)
            return;
        String temp = String.valueOf((char) ('A' + c - 1));
        decode(res, s, input + temp, step + 1);
        if (step + 2 <= s.length()) {
            c = Integer.valueOf(s.substring(step, step + 2));
            if (c <= 26) {
                temp = String.valueOf((char) ('A' + c - 1));
                decode(res, s, input + temp, step + 2);
            }
        }
    }

    public static void main(String[] args) {
        So91 so = new So91();
        System.out.println(so.numDecodings("27"));
    }
}
