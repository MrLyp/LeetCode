package com.robbie;

// https://leetcode.com/problems/excel-sheet-column-title/
public class So168 {
    public String convertToTitle(int n) {
        int div = n - 1;
        int mod = div % 26;
        StringBuffer res = new StringBuffer();
        while (div >= 0) {
            char c = (char) ('A' + mod);
            res.append(c);
            div = div / 26 - 1;
            mod = div % 26;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        check(1, "A");
        check(28, "AB");
        check(701, "ZY");
        check(52, "AZ");
    }

    private static void check(int n, String res) {
        So168 so = new So168();
        String title = so.convertToTitle(n);
        if (!res.equals(title))
            throw new IllegalStateException(n + "," + res + "," + title);
        System.out.println(n + "," + res + ", pass");
    }

}
