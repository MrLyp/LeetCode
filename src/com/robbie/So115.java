package com.robbie;

import org.omg.PortableInterceptor.INACTIVE;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class So115 {
    private int count = 0;

    public int numDistinct(String s, String t) {
        if (t.length() > s.length())
            return 0;
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i <= t.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= s.length(); i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (t.charAt(i) != s.charAt(j))
                    dp[i + 1][j + 1] = dp[i + 1][j];
                else
                    dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j];
            }
        }
        return dp[t.length()][s.length()];
    }

    // TLE
    private void search(String t, int index, String s, char[] array) {
        if (t.equals(s)) {
            count++;
            return;
        }
        if (!t.startsWith(s))
            return;
        if (index >= array.length)
            return;
        search(t, index + 1, s + array[index], array);
        search(t, index + 1, s, array);
    }

    public static void main(String[] args) {
        So115 so = new So115();
        System.out.println(so.numDistinct("aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe"
                , "bddabdcae"));
    }
}
