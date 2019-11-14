package com.robbie;

import java.util.ArrayList;
import java.util.List;

public class So166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0)
            return "";
        if (numerator == 0)
            return "0";
        boolean positive = (numerator > 0 && denominator > 0) || (numerator < 0 && denominator < 0);
        StringBuilder res = new StringBuilder();
        long nn = Math.abs(numerator);
        long de = Math.abs(denominator);
        long d = Math.abs(nn / de);
        long m = Math.abs(nn % de);
        if (m == 0)
            return sign(positive) + res.append(d).toString();
        List<Long> mods = new ArrayList<>();
        mods.add(m);
        long p = m;
        while (true) {
            p *= 10;
            long dd = Math.abs(p / de);
            res.append(dd);

            p = p % de;
            if (mods.contains(p)) {
                int index = mods.indexOf(p);
                if (index == 0) {
                    return sign(positive) + d + ".(" + res + ")";
                } else {
                    return sign(positive) + d + "." + res.substring(0, index) + "(" + res.substring(index) + ")";
                }
            }
            mods.add(p);
            if (p == 0) {
                break;
            }
        }
        return sign(positive) + d + "." + res;
    }

    private String sign(boolean positive) {
        if (positive)
            return "";
        else
            return "-";
    }

    public static void main(String[] args) {
        So166 so = new So166();
        System.out.println(so.fractionToDecimal(-2147483648,
                1));
    }
}
