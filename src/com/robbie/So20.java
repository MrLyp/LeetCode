package com.robbie;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class So20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s == null || s.length() == 0)
            return true;
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                char top = '0';
                if (!stack.isEmpty())
                    top = stack.peek();
                if (map.get(top) != null && c == map.get(top)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        So20 so = new So20();
        System.out.println(so.isValid("()"));
        System.out.println(so.isValid("()[]{}"));
        System.out.println(so.isValid("(]"));
        System.out.println(so.isValid("([)]"));
        System.out.println(so.isValid("{[]}"));
        System.out.println(so.isValid("[])"));
    }
}
