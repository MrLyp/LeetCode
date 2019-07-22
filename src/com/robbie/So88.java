package com.robbie;

import java.util.Arrays;

/**
 * Created by leeyunpeng on 2019/7/22.
 */
public class So88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0)
            return;
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[i + j + 1] = nums1[i];
                i--;
            } else {
                nums1[i + j + 1] = nums2[j];
                j--;
            }
        }
        while (j >= 0) {
            nums1[j] = nums2[j];
            j--;
        }
    }

    public static void main(String[] args) {
        So88 so = new So88();
        int[] nums1 = new int[]{1,2,3,7,8,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        so.merge(nums1, 5, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
