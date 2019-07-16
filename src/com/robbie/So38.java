package com.robbie;

/**
 * Created by leeyunpeng on 2019/7/16.
 */
public class So38 {

    public String countAndSay(int n) {
        if (n == 0)
            return "";
        if (n == 1)
            return "1";
        String s = countAndSay(n - 1);
        return countAndSay(s);
    }

    private String countAndSay(String s) {
        if (s.length() == 0)
            return "";
        char first = s.charAt(0);
        int i = 1;
        while (i < s.length() && s.charAt(i) == first) {
            i++;
        }
        return String.valueOf(i) + first + countAndSay(s.substring(i));
    }

    public static void main(String[] args) {
        So38 so = new So38();
        System.out.println(so.countAndSay(9));
    }
}
