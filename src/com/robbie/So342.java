package com.robbie;

public class So342 {
    public boolean isPowerOfFour(int num) {
        while (num >= 4) {
            if (num % 4 != 0)
                return false;
            num /= 4;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        So342 so = new So342();
        System.out.println(so.isPowerOfFour(16));
        System.out.println(so.isPowerOfFour(5));
    }
}
