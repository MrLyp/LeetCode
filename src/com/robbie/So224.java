package com.robbie;

import java.util.LinkedList;
import java.util.Stack;

public class So224 {
    public int calculate(String s) {
        int sum = 0;
        int sign = 1;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ')
                continue;
            if (c == '(') {
                int left = 1;
                int j = i + 1;
                while (left > 0) {
                    char d = s.charAt(j);
                    if (d == '(')
                        left++;
                    else if (d == ')')
                        left--;
                    j++;
                }
                String sub = s.substring(i + 1, j - 1);
                i = j - 1;
                sum += sign * calculate(sub);
            } else if (c == '+') {
                sum += sign * num;
                sign = 1;
                num = 0;
            } else if (c == '-') {
                sum += sign * num;
                sign = -1;
                num = 0;
            } else {
                num = num * 10 + (c - '0');
            }
        }
        return sum + sign * num;
    }


    public static void main(String[] args) {
        So224 so = new So224();
        System.out.println(so.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(so.calculate(" 2-1 + 2 "));
    }
}
