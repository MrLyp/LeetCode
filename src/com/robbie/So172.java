package com.robbie;

/**
 * Created by leeyunpeng on 2018/12/17.
 */
// https://leetcode.com/problems/factorial-trailing-zeroes/
public class So172 {
    public int trailingZeroes(int n) {
        int result = 0;
        while (n > 0) {
            result += n / 5;
            n /= 5;
        }
        return result;
    }

    public static void main(String[] args) {
        check(0, 3);
        check(1, 5);
        check(1, 7);
        check(2, 13);
    }

    private static void check(int n, int s) {
        So172 so = new So172();
        int res = so.trailingZeroes(s);
        if (res != n)
            throw new IllegalStateException(n + "," + res);
        System.out.println(n + "," + res + ", pass");
    }
}
