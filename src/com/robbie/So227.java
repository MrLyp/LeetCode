package com.robbie;

import java.util.Stack;

public class So227 {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int n = 0;
        char lastOp = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isDigit(c)) {
                n = n * 10 + c - '0';
            }
            System.out.println(n);
            if((!isDigit(c) && c != ' ') || (i == s.length() - 1)) {
                if (lastOp == '-') {
                    stack.push(-n);
                } else if (lastOp == '+') {
                    stack.push(n);
                } else if (lastOp == '*') {
                    stack.push(stack.pop() * n);
                } else if (lastOp == '/') {
                    stack.push(stack.pop() / n);
                }
                n = 0;
                lastOp = c;
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        So227 so = new So227();
        check(so.calculate("3+2*2"), 7);
        check(so.calculate(" 3/2 "), 1);

        check(so.calculate(" 3+5 / 2 "), 5);
        check(so.calculate(" 3+544 / 2*2 "), 547);
        check(so.calculate("100000000/1/2/3/4/5/6/7/8/9/10"), 1);
    }

    private static void check(int n, int expect) {
        if (n != expect) {
            throw new RuntimeException(n + " failed, expected " + expect);
        } else {
            System.out.println(n + " passed");
        }
    }

}
