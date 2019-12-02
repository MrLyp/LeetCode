package com.robbie;

public class So367 {
    public boolean isPerfectSquare(int num) {
        if (num < 0)
            return false;
        if (num == 0 || num == 1)
            return true;
        int start = 1;
        int end = num;
        while (start <= end) {
            int mid = (start + end) / 2;
            int div = num / mid;
            if (num % mid == 0 && div == mid)
                return true;
            if (div > mid)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        So367 so = new So367();
        System.out.println(so.isPerfectSquare(16));
        System.out.println(so.isPerfectSquare(104976));
    }
}
