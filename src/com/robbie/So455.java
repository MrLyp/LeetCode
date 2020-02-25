package com.robbie;

import java.util.Arrays;

public class So455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int sum = 0;
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                sum++;
                j++;
                i++;
            } else {
                j++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        So455 so = new So455();
        System.out.println(so.findContentChildren(new int[]{1,2,3}, new int[]{1,2,3,4}));
    }
}
