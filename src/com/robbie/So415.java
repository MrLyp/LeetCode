package com.robbie;

public class So415 {
    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carrier = 0;
        int sum = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            int a = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int b = (j >= 0) ? num2.charAt(j--) - '0' : 0;
            sum = a + b + carrier;
            carrier = sum / 10;
            sum %= 10;
            builder.append(sum);
        }
        if (carrier > 0)
            builder.append(carrier);
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        So415 so = new So415();
        System.out.println(so.addStrings("111", "999"));
    }
}
