package com.robbie;

import java.util.ArrayList;
import java.util.List;

public class So279 {

    private int min = Integer.MAX_VALUE;

    public int numSquares(int n) {
        min = Integer.MAX_VALUE;
        int k = (int) Math.ceil(Math.sqrt(n));
//        List<Integer> res = new ArrayList<>();
        find(n, k, 0);
//        int min = Integer.MAX_VALUE;
//        for (int i : res) {
//            min = Math.min(min, i);
//        }
        return min;
    }

    private void find(int n, int k, int index) {
        if (n == 0) {
            min = Math.min(index, min);
            return;
        }
        if (n < 0)
            return;
        if (index >= min)
            return;
        for (int i = k; i >= 1; i--) {
            find(n - i * i, k, index + 1);
        }
    }

    public static void main(String[] args) {
        So279 so = new So279();
        check(so.numSquares(12), 3);
        check(so.numSquares(13), 2);
        check(so.numSquares(1), 1);
        check(so.numSquares(51), 3);
        check(so.numSquares(7168), 4);
    }

    private static void check(int n, int expect) {
        if (n != expect) {
            throw new RuntimeException(n + " failed, expected " + expect);
        } else {
            System.out.println(n + " passed");
        }
    }
}
