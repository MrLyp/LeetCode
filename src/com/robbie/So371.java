package com.robbie;

public class So371 {
    public int getSum(int a, int b) {
        if (b == 0)
            return a;
        else
            return getSum(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        So371 so = new So371();
        System.out.println(so.getSum(12, 23));
    }
}
