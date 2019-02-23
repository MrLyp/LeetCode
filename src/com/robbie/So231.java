package com.robbie;

public class So231 {

    public boolean isPowerOfTwo(int n) {
        int m = 0;
        while (n > 0) {
            if (n == 1 || n == 2)
                return true;
            m = n % 2;
            if (m != 0)
                return false;
            n = n / 2;
        }
        return false;
    }

    public static void main(String[] args) {
        So231 so = new So231();
        System.out.println(so.isPowerOfTwo(216));
    }
}
