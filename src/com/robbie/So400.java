package com.robbie;

public class So400 {
    public int findNthDigit(int num) {
        int k = 1;
        long base = 9;
        long n = num;
        while (n > k * base) {
            n -= k * base;
            k++;
            base *= 10;
        }
        long cur = (long) (Math.pow(10, k - 1) + (n - 1) / k);
        int index = (int) ((n - 1) % k);
        return (int) ((cur / (long) Math.pow(10, k - 1 - index)) % 10);
    }

    public static void main(String[] args) {
        So400 so = new So400();
        System.out.println(so.findNthDigit(1000000000));
        System.out.println(so.findNthDigit(11));
        System.out.println(so.findNthDigit(12));
        System.out.println(so.findNthDigit(13));
        System.out.println(so.findNthDigit(14));
        System.out.println(so.findNthDigit(15));
        System.out.println(so.findNthDigit(16));
    }
}
