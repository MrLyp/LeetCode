package com.robbie;

public class So125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        int i = 0;
        int j = s.length() - 1;
        s = s.toLowerCase();
        while (i <= j) {
            if (!isLegal(s.charAt(i))) {
                i++;
                continue;
            }
            if (!isLegal(s.charAt(j))) {
                j--;
                continue;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isLegal(char c) {
        return Character.isJavaLetterOrDigit(c);
    }

    public static void main(String[] args) {
        So125 so = new So125();
        System.out.println(so.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(so.isPalindrome("race a car"));
        System.out.println(so.isPalindrome("0P"));
    }
}
