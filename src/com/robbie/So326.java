package com.robbie;

public class So326 {
    public boolean isPowerOfThree(int n) {
        if (n < 3)
            return false;
        while (n > 1) {
            if (n % 3 == 0)
                n = n / 3;
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        So326 so = new So326();
        System.out.println(so.isPowerOfThree(45));
        System.out.println(so.isPowerOfThree(27));
        System.out.println(so.isPowerOfThree(9));
        System.out.println(so.isPowerOfThree(0));
    }
}
