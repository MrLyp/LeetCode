package com.robbie;

public class So365 {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0)
            return true;
        int a = Math.max(x, y);
        int b = Math.min(x, y);
        if (a + b < z)
            return false;
        return z % gcd(a, b) == 0;
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        So365 so = new So365();
        System.out.println(so.canMeasureWater(3, 5, 4));
        System.out.println(so.canMeasureWater(2, 6, 5));
        System.out.println(so.canMeasureWater(1, 2, 3));
        System.out.println(so.canMeasureWater(1, 0, 0));
    }
}
