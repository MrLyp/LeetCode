package com.robbie;

public class So441 {
    public int arrangeCoins(int n) {
        return (int) ((Math.sqrt(1L + 8 * (long)n) - 1) / 2);
    }

    public static void main(String[] args) {
        So441 so = new So441();
        System.out.println(so.arrangeCoins(5));
        System.out.println(so.arrangeCoins(8));
    }
}
