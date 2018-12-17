package com.robbie;

/**
 * Created by leeyunpeng on 2018/12/17.
 */
// https://leetcode.com/problems/excel-sheet-column-number/
public class So171 {
    public int titleToNumber(String s) {
        int res = 0;
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            res += (s.charAt(i) - 'A' + 1) * (Math.pow(26, n - i - 1));
        }
        return res;
    }

    public static void main(String[] args) {
        check(1, "A");
        check(28, "AB");
        check(701, "ZY");
    }

    private static void check(int n, String s) {
        So171 so = new So171();
        int res = so.titleToNumber(s);
        if (res != n)
            throw new IllegalStateException(n + "," + res);
        System.out.println(n + "," + res + ", pass");
    }
}
