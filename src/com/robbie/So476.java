package com.robbie;

public class So476 {
    public int findComplement(int num) {
        int n = num;
        int count = 0;
        while (n > 0) {
            n = n >> 1;
            count++;
        }
        int res = 0;
        count--;
        while (count >= 0) {
            res |= (~(num >> count) & 1) << count;
            count--;
        }
        return res;
    }

    public static void main(String[] args) {
        So476 so = new So476();
        System.out.println(so.findComplement(5));
        System.out.println(so.findComplement(1));
    }
}
