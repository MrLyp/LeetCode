package com.robbie;

public class So263 {
    public boolean isUgly(int num) {
        if (num == 0)
            return false;
        while(num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 5 == 0) {
                num /= 5;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        So263 so = new So263();
        System.out.println(so.isUgly(-2147483648));
    }
}
