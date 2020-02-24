package com.robbie;

public class So443 {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0)
            return 0;
        int start = 0;
        int end = 0;
        while (end < chars.length) {
            int count = 1;
            int next = end + 1;
            while (next < chars.length && chars[end] == chars[next]) {
                next++;
                count++;
            }
            chars[start] = chars[end];
            end = next;
            if (count > 1) {
                String s = Integer.toString(count);
                System.arraycopy(s.toCharArray(), 0, chars, start + 1, s.length());
                start += s.length() + 1;
            } else {
                start++;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        So443 so = new So443();
        char[] s = new char[]{'a'};
        System.out.println(so.compress(s));
        System.out.println(s);
        s = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(so.compress(s));
        System.out.println(s);
    }
}
