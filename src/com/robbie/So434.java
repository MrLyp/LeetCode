package com.robbie;

public class So434 {
    public int countSegments(String s) {
        if (s == null)
            return 0;
        int count = 0;
        int start = 0;
        s = s.trim();
        if (s.length() == 0)
            return 0;
        while(start < s.length()) {
            while (start < s.length() && s.charAt(start) != ' ')
                start++;
            if (start < s.length())
                count++;
            while(start < s.length() && s.charAt(start) == ' ')
                start++;
        }
        return count + 1;
    }

    public static void main(String[] args) {
        So434 so = new So434();
        System.out.println(so.countSegments("Hello, my name is John"));
        System.out.println(so.countSegments(", , , ,        a, eaefa"));
        System.out.println(so.countSegments("                "
        ));
    }
}
