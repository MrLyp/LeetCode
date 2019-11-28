package com.robbie;

import java.math.BigInteger;

public class So330 {

    /**
     * 对于数组，如果子数组和能够覆盖[1,m]区间，那么像数组中添加m+1，新数组就可以覆盖[1,2m+1]的区间。
     * 所以对于这个问题也可以有扩展问题，比如对于任意的数字n，最少upper(lgn)个元素可以覆盖[1,n]的区间，也就是n的二进制表示位数，
     */
    public int minPatches(int[] nums, int n) {
        long patch = 0;
        int count = 0;
        int i = 0;
        while (patch < n) {
            if (i < nums.length && patch + 1 >= nums[i]) {
                patch += nums[i];
                i++;
            } else {
                count++;
                patch = 2 * patch + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        So330 so = new So330();
        System.out.println(so.minPatches(new int[]{1, 3}, 6));
        System.out.println(so.minPatches(new int[]{1, 2, 32}, 2147483647));
        System.out.println(so.minPatches(new int[]{}, 7));
        System.out.println(so.minPatches(new int[]{1, 2, 2}, 5));
//        System.out.println();
        System.out.println(so.minPatches(new int[]{1, 5, 10}, 100));
//        System.out.println();
        System.out.println(so.minPatches(new int[]{1, 2, 31, 33}, 2147483647));
    }
}
