package com.robbie;

public class So344 {
    public void reverseString(char[] s) {
        if (s == null)
            return;
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        So344 so = new So344();
        char[] s = new char[]{'h','e','l','l','o'};
        so.reverseString(s);
        System.out.println(s);
    }
}
