package com.robbie;

import java.util.Stack;

public class So402 {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() > c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while (k-- > 0) stack.pop();
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) builder.append(stack.pop());
        for (int i = builder.length() - 1; i >= 0; i--) {
            if (builder.charAt(i) == '0')
                builder.deleteCharAt(i);
            else
                break;
        }
        if (builder.length() == 0)
            return "0";
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        So402 so = new So402();
        System.out.println(so.removeKdigits("1432219", 3));
        System.out.println(so.removeKdigits("100200", 1));
        System.out.println(so.removeKdigits("100200", 2));
    }
}
