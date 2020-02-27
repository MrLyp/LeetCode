package com.robbie;

public class So461 {
    public int hammingDistance(int x, int y) {
        int i = 0;
        int sum = 0;
        int num = x ^ y;
        while (i < 32) {
            if (((num >> i) & 1) == 1)
                sum++;
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        So461 so = new So461();
        System.out.println(so.hammingDistance(1, 4));
    }
}
