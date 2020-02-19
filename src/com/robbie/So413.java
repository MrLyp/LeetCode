package com.robbie;

public class So413 {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3)
            return 0;

        int[] diff = new int[A.length - 1];
        for (int i = 1; i < A.length; i++) {
            diff[i - 1] = A[i] - A[i - 1];
        }
        int index = 1;
        int cur = diff[0];
        int count = 1;
        int sum = 0;
        while (index < diff.length) {
            while (index < diff.length && diff[index] == cur) {
                index++;
                count++;
            }
            if (count >= 2) {
                sum += count * (count - 1) / 2;
            }
            if (index >= diff.length)
                break;
            cur = diff[index];
            index++;
            count = 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        So413 so = new So413();
        System.out.println(so.numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
        System.out.println(so.numberOfArithmeticSlices(new int[]{1, 2, 3, 8, 9, 10}));
    }
}
