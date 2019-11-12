package com.robbie;

public class So214 {

    // 最差情况下，把s从后向前的插入，就一定是一个回文。如果存在最短回文，那么s开始的部分一定是回文，所以寻找从0开始的最长回文子串，然后把后面的部分依次插入到前面就好了。
    public String shortestPalindrome(String s) {
        int start = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(start) == s.charAt(i)) {
                start++;
            } else {
                if (start != i) {
                    i += start;
                    start = 0;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = s.length() - 1; i >= start; i--) {
            res.append(s.charAt(i));
        }
        return res.append(s).toString();
    }

    public static void main(String[] args) {
        So214 so = new So214();
        System.out.println(so.shortestPalindrome("abcd"));
    }
}
