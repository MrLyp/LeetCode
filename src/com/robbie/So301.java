package com.robbie;


import java.util.*;

public class So301 {

    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                if (left > 0)
                    left--;
                else
                    right++;
            }
        }
        List<String> res = new ArrayList<>();
        search(res, s, "", 0, left, right);
        if (res.isEmpty())
            res.add("");
        return res;
    }

    private void search(List<String> res, String s, String path, int index, int left, int right) {
        if (left == 0 && right == 0 && index == s.length()) {
            if (!res.contains(path) && isValid(path))
                res.add(path);
            return;
        }
        if (index >= s.length())
            return;

        int i = index;
        char c = s.charAt(i);
        if (c == '(' && left > 0) {
            search(res, s, path, i + 1, left - 1, right);
        } else if (c == ')' && right > 0) {
            search(res, s, path, i + 1, left, right - 1);
        }
        search(res, s, path + c, i + 1, left, right);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s == null || s.length() == 0)
            return true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty())
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        So301 so = new So301();
        System.out.println(so.removeInvalidParentheses("()())()"));
        System.out.println(so.removeInvalidParentheses("(a)())()"));
        System.out.println(so.removeInvalidParentheses(")("));
        System.out.println(so.removeInvalidParentheses("x("));
    }
}
