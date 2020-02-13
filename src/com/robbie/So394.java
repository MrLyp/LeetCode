package com.robbie;

import java.util.Stack;

public class So394 {
    public String decodeString(String s) {
        int i = 0;
        StringBuilder builder = new StringBuilder();
        Stack<Integer> integers = new Stack<>();
        Stack<String> strings = new Stack<>();
        int count = 0;
        StringBuilder sub = new StringBuilder();
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (Character.isDigit(c)) {
                if (sub.length() > 0) {
                    while (strings.size() > 0 && strings.size() >= integers.size()) {
                        sub.insert(0, strings.pop());
                    }
                    strings.push(sub.toString());
                    sub.setLength(0);
                }
                count = count * 10 + c - '0';
            } else if (Character.isAlphabetic(c)) {
                if (integers.isEmpty()) {
                    builder.append(c);
                } else {
                    sub.append(c);
                }
            } else if (c == '[') {
                integers.push(count);
                count = 0;
                if (sub.length() > 0) {
                    strings.push(sub.toString());
                    sub.setLength(0);
                }
            } else if (c == ']') {

                StringBuilder sb = new StringBuilder();
                while (strings.size() > 0 && strings.size() >= integers.size()) {
                    sub.insert(0, strings.pop());
                }
                if (sub.length() == 0) {
                    sub.append(strings.pop());
                }
                int topNumber = integers.pop();
                while(topNumber-- > 0) {
                    sb.append(sub.toString());
                }

                if (integers.isEmpty()) {
                    builder.append(sb);
                } else {

                    strings.push(sb.toString());
                }
                sub.setLength(0);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        So394 so = new So394();
        System.out.println(so.decodeString("2[2[2[b]]]"));
        System.out.println(so.decodeString("2[2[y]pq4[2[jk]e1[f]]]ef"));
        System.out.println(so.decodeString("2[b4[F]c]"));
        System.out.println(so.decodeString("3[a]2[bc]"));
        System.out.println(so.decodeString("3[a2[c]]"));
        System.out.println(so.decodeString("2[abc]3[cd]ef"));
        System.out.println(so.decodeString("2[ax10[b3[c]]]ef"));
    }
}
