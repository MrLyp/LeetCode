package com.robbie;

/**
 * Created by leeyunpeng on 2019/7/17.
 */
public class So69 {
    public int mySqrt(int x) {
        if (x < 1)
            return 0;
        if (x <= 2)
            return 1;
        int upper = x >> 1;
        int lower = 2;
        while (true) {
            if (lower > x / lower)
                break;
            lower = lower << 1;
        }
        int res = lower >> 1;
        for (int i = res; i <= upper; i++) {
            if (i > x / i)
                break;
            res = i;
        }
        return res;
    }

    public static void main(String[] args) {
        So69 so = new So69();
        System.out.println(so.mySqrt(2147395600));
    }
}
