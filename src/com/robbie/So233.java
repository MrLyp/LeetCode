package com.robbie;

public class So233 {
    // 1出现的个数等于个位是1的次数 + 十位是1的次数 + 。。。
    public int countDigitOne(int n) {
        int res = 0;
        for (long k = 1; k <= n; k *= 10) {
            long r = n / k, m = n % k;
            long digit = r % 10;
            long p;
            if (digit == 0) {
                p = r / 10 * k;
            } else if (digit == 1) {
                p = r / 10 * k+ m + 1;
            } else {
                p = (r / 10 + 1) * k;
            }
            res += p;
        }
        return res;
    }

    public static void main(String[] args) {
        So233 so = new So233();
        System.out.println(so.countDigitOne(1234));
    }
}
