package com.robbie;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class So241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> nums = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                nums.add(Integer.parseInt(input.substring(start, i)));
                nums.add((int) input.charAt(i));
                start = i + 1;
            }
        }
        nums.add(Integer.parseInt(input.substring(start)));
        List<Integer> res = new ArrayList<>();
        compute(res, nums);
        return res;
    }

    private void compute(List<Integer> res, List<Integer> nums) {
        if (nums.isEmpty())
            return;
        if (nums.size() == 1) {
            res.add(nums.get(0));
            return;
        }
        for (int i = 1; i < nums.size(); i += 2) {
            List<Integer> left = new ArrayList<>();
            compute(left, nums.subList(0, i));
            List<Integer> right = new ArrayList<>();
            compute(right, nums.subList(i + 1, nums.size()));
            if (left.isEmpty() && !right.isEmpty()) {
                res.addAll(right);
                return;
            }
            if (!left.isEmpty() && right.isEmpty()) {
                res.addAll(left);
                return;
            }
            int op = nums.get(i);
            for (int l = 0; l < left.size(); l++) {
                for (int r = 0; r < right.size(); r++) {
                    if (op == '+') {
                        res.add(left.get(l) + right.get(r));
                    } else if (op == '-') {
                        res.add(left.get(l) - right.get(r));
                    } else if (op == '*') {
                        res.add(left.get(l) * right.get(r));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        So241 so = new So241();
        System.out.println(so.diffWaysToCompute("2-1-1"));
        System.out.println(so.diffWaysToCompute("2*3-4*5"));
    }
}
