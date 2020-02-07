package com.robbie;

public class So372 {
    public int superPow(int a, int[] b) {
        int res = 1;
        for(int i = 0; i < b.length; i++) {
            res = pow(res, 10) * pow(a, b[i]) % 1337;
        }
        return res;
    }

    private int pow(int a, int b) {
        a %= 1337;
        int res = 1;
        while(b-- > 0) {
            res = (res * a) % 1337;
        }
        return res;
    }

    public static void main(String[] args) {
        So372 so = new So372();
        System.out.println(so.superPow(2, new int[]{1, 0}));
        System.out.println(so.superPow(2, new int[]{3}));
    }
}
