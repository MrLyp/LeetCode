package com.robbie;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class So239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0)
            return new int[0];
        Deque<Integer> queue = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i])
                queue.pollLast();
            queue.offer(i);
            if (i >= k - 1) {
                int first = queue.peekFirst();
                res[i - k + 1] = nums[first];
                if (first == i - k + 1)
                    queue.pop();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        So239 so = new So239();
        System.out.println(Arrays.toString(so.maxSlidingWindow(new int[]{1, 3, -1, -3, -5, 3, 6, 7}, 3)));
    }
}
