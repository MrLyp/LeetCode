package com.robbie;

import java.util.Stack;

public class So388 {
    public int lengthLongestPath(String input) {
        String[] splits = input.split("\\n");
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        boolean found = false;
        for (String str : splits) {
            int depth = 0;
            String sub = str;
            while (sub.startsWith("\t")) {
                sub = sub.substring(1);
                depth++;
            }
            while(stack.size() > depth)
                stack.pop();
            int top = stack.isEmpty()? 0 : stack.peek();
            if (sub.contains(".")) {
                found = true;
                max = Math.max(max, sub.length() + top + depth);
            } else {
                stack.push(sub.length() + top);
            }
        }
        return found ? max : 0;
    }

    public static void main(String[] args) {
        So388 so = new So388();
        System.out.println(so.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println(so.lengthLongestPath("a"));
        System.out.println(so.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }
}
