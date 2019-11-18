package com.robbie;

import java.util.*;

public class So306 {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3)
            return false;
        return search(num, -1, -1, -1, 0);
    }

    private boolean search(String num, long n1, long n2, long n3, int index) {
        if (index >= num.length()) {
            return n1 + n2 == n3;
        }

        for (int i = index + 1; i <= num.length(); i++) {
            String sub = num.substring(index, i);
            if (sub.length() > num.length() / 2)
                return false;
            if (sub.length() > 1 && sub.charAt(0) == '0')
                return false;
            long number = Long.parseLong(sub);
            if (number < n3 || number < n2)
                continue;
            if (n1 == -1) {
                if (search(num, number, n2, n3, i))
                    return true;
            }
            if (n2 == -1) {
                if (search(num, n1, number, n3, i))
                    return true;
            }

            if (n3 == -1 && n1 + n2 == number) {
                return search(num, n1, n2, number, i);
            }
            if (n2 + n3 == number) {
                return search(num, n2, n3, number, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        So306 so = new So306();
        System.out.println(so.isAdditiveNumber("111"));
        System.out.println(so.isAdditiveNumber("121474836472147483648"));
        System.out.println(so.isAdditiveNumber("112358"));
        System.out.println(so.isAdditiveNumber("19910019"));
    }
}
