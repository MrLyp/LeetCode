package com.robbie;

import java.util.Arrays;
import java.util.HashSet;

public class So467 {
    public int findSubstringInWraproundString(String p) {
        if (p.isEmpty()) return 0;
        char[] chars = p.toCharArray();
        int[] dp = new int[26];
        int maxLen = 0;
        for (int i = 0; i < chars.length; i++) {
            int cur = chars[i] - 'a';
            if (i > 0 && ((chars[i - 1] - 'a' + 1) % 26 != cur))
                maxLen = 0;
            dp[cur] = Math.max(dp[cur], ++maxLen);
        }
        int res = 0;
        for (int i = 0; i < 26; i++)
            res += dp[i];
        return res;
    }

    public static void main(String[] args) {
        So467 so = new So467();
        System.out.println(so.findSubstringInWraproundString("zab"));
        System.out.println(so.findSubstringInWraproundString("cac"));
        System.out.println(so.findSubstringInWraproundString("abza"));
    }
}
