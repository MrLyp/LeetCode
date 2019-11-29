package com.robbie;

import java.util.Arrays;

public class So338 {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for (int i = 1; i <= num; i++) {
            res[i] = res[i >> 1] + (i % 2 == 0 ? 0 : 1);
        }
        return res;
    }

    public static void main(String[] args) {
        So338 so = new So338();
        System.out.println(Arrays.toString(so.countBits(16)));
    }
}
