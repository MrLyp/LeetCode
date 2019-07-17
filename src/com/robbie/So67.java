package com.robbie;

public class So67 {
    public String addBinary(String a, String b) {
        int m, n, ins = 0, res = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            if (i >= 0)
                m = a.charAt(i) - '0';
            else
                m = 0;
            if (j >= 0)
                n = b.charAt(j) - '0';
            else
                n = 0;
            res = m + n + ins;
            if (res > 1) {
                ins = res / 2;
                res = res % 2;
            } else {
                ins = 0;
            }
            builder.append(res);
        }
        if (ins > 0)
            builder.append(ins);
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        So67 so = new So67();
        System.out.println(so.addBinary("1010", "1011"));
    }
}
