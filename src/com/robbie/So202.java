package com.robbie;

public class So202 {
    public boolean isHappy(int n) {
        if (n == 1)
            return true;
        int m = 0;
        while(n > 0) {
            m += (int) Math.pow(n % 10, 2);
            n = n / 10;
        }
        if (m == 4)
            return false;
//        System.out.println(m);
        return isHappy(m);
    }

    public static void main(String[] args) {
        So202 so = new So202();
        for (int i = 1; i < 10000; i++) {
            if (so.isHappy(i))
            System.out.println(i);
        }
    }
}
