package com.robbie;

import java.util.Arrays;
import java.util.Random;

public class So384 {
    static class Solution {

        private int[] array;

        private int[] origin;

        Random random = new Random();

        public Solution(int[] nums) {
            this.array = nums;
            this.origin = nums.clone();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return this.origin;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            for (int i = 0 ;i < array.length; i++) {
                int index = random.nextInt(array.length - i) + i;
                int tmp = array[index];
                array[index] = array[i];
                array[i] = tmp;
            }
            return array;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1,2,3, 4});
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
        System.out.println(Arrays.toString(solution.shuffle()));
    }
}
