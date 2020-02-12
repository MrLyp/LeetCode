package com.robbie;

public class So389 {
    public char findTheDifference(String s, String t) {
        long sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            sum -= t.charAt(i);
        }
        return (char) Math.abs(sum);
    }

    public static void main(String[] args) {
        So389 so = new So389();
        System.out.println(so.findTheDifference("abcd", "abcda"));
    }
}
