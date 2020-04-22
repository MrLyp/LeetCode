package com.robbie;

public class So482 {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder builder = new StringBuilder(S.toUpperCase().replaceAll("-", ""));
        int length = builder.length();
        if (length <= K)
            return builder.toString();
        int mod = length % K;
        int start = K;
        if (mod != 0) {
            builder.insert(mod, "-");
            start += mod + 1;
        }
        while (start < builder.length()) {
            builder.insert(start, "-");
            start += K + 1;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        So482 so = new So482();
        System.out.println(so.licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(so.licenseKeyFormatting("2-5g-3-J", 2));
        System.out.println(so.licenseKeyFormatting("a-a-a-a-", 1));
    }
}
