package com.robbie;

public class So190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }

    public static void main(String[] args) {
        So190 so = new So190();
        check(so.reverseBits(43261596), 964176192);
        check(so.reverseBits(-3), -1073741825);
    }

    private static void check(int n, int expect) {
        if (n != expect) {
            throw new RuntimeException(n + " failed, expected " + expect);
        } else {
            System.out.println(n + " passed");
        }
    }
}
