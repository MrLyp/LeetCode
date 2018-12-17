package com.robbie;

import java.util.Arrays;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class So167 {
    public int[] twoSumFail(int[] numbers, int target) {
        int[] result = new int[2];
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if(target == numbers[i] + numbers[j]) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    break;
                }
            }
        }

        return result;
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int j = bsearch(numbers, target - numbers[i]);
            if (j >= 0 && i != j) {
                if (i < j) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                } else {
                    result[0] = j + 1;
                    result[1] = i + 1;
                }
                break;
            }
        }
        return result;
    }

    private int bsearch(int[] numbers, int target) {
        return Arrays.binarySearch(numbers, target);
    }

    public static void main(String[] args) {
        int[] numbers = {2,2, 7,11,15};
        int target = 4;
        So167 twoSum = new So167();
        int[] result = twoSum.twoSum(numbers, target);
        System.out.print(Arrays.toString(result));
    }
}
