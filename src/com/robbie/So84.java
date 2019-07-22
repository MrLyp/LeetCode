package com.robbie;

import java.util.*;

/**
 * Created by leeyunpeng on 2019/7/18.
 */
public class So84 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        int res = 0;
        for (int i = 1; i <= heights.length; i++) {
            Deque<Integer> stack = new LinkedList<>();
            int min = Integer.MAX_VALUE;
            for (int t = 0; t< i; t++) {
                if (min > heights[t])
                    min = heights[t];
            }
            stack.push(min);

            for (int j = i; j < heights.length; j++) {

                stack.push(Math.min(heights[j], stack.peek()));
                res = Math.max(res, stack.peek() * i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        So84 so = new So84();
        System.out.println(so.largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(so.largestRectangleArea(new int[]{1}));
    }
}
