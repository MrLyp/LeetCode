package com.robbie;

public class So397 {

    public int integerReplacement(int n) {
        return doReplace(n);
    }

    private int doReplace(long n) {
        if (n == 1)
            return 0;
        if (n % 2 == 0) {
            return doReplace(n / 2) + 1;
        } else {
            return Math.min(doReplace(n + 1), doReplace(n - 1)) + 1;
        }
    }

    public static void main(String[] args) {
        So397 so = new So397();
        System.out.println(so.integerReplacement(2147483647));
    }
}
