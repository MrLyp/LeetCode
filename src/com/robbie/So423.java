package com.robbie;

public class So423 {
    // 实在是取巧，有些脱离常规算法题的范畴
    private char[] uniques = new char[]{'z', 'x', 'g', 'u', 'r', 'f', 'v', 't', 'i', 'o'};

    private String[] words = new String[]{"zero", "six", "eight", "four", "three", "five", "seven", "two", "nine", "one"};

    private int[] nums = new int[]{0, 6, 8, 4, 3, 5, 7, 2, 9, 1};

    public String originalDigits(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int[] res = new int[10];
        for (int i = 0; i < 10; i++) {
            int t = count[uniques[i] - 'a'];
            if (t > 0) {
                for (char c : words[i].toCharArray()) {
                    count[c - 'a'] -= t;
                }
                res[nums[i]] = t;
            }
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            while (res[i]-- > 0) sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        So423 so = new So423();
        System.out.println(so.originalDigits("owoztneoer"));
        System.out.println(so.originalDigits("fviefuro"));
    }
}
