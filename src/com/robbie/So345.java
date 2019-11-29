package com.robbie;

public class So345 {
    public String reverseVowels(String s) {
        if (s == null)
            return null;
        char[] array = s.toCharArray();
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            while (!isVowels(array[i]) && i < j)
                i++;
            while (!isVowels(array[j]) && i < j)
                j--;
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        return new String(array);
    }

    private boolean isVowels(char a) {
        char c = Character.toLowerCase(a);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        So345 so = new So345();
        System.out.println(so.reverseVowels("hello"));
        System.out.println(so.reverseVowels("leetcode"));
        System.out.println(so.reverseVowels("aA"));
    }
}
