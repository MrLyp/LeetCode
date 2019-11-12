package com.robbie;

import java.math.BigInteger;

public class So201 {
    public int rangeBitwiseAnd(int m, int n) {
        int p = m ^ n;
        int length = 0;
        while (p > 0) {
            p = p >> 1;
            length++;
        }
        return m & ((~0) << (length - 1));
    }

    public static void main(String[] args) {
        So201 so = new So201();
        System.out.println(so.rangeBitwiseAnd(5, 7));
    }
}
