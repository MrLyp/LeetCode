package com.robbie;

public class So4 {
    /*
    这里需要记录一下解题思路，题目要求是log(m+n)复杂度，所以线性插入构造新数组，或者合并再排序什么的思路就不行了。
    因为是log复杂度，并且数组是排序的，所以一定是要想办法做二分查找。基本思想是对于array1, array2, 合并之后寻找第(m+n)/2大的数。
    如果array1第k/2大的数 小于 array2第k/2大的数，那么合并之后第k大数一定是在array1[k/2, m]+array2[0,n]之中。然后递归的去找就OK了。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int mid = (m + n) / 2;
        if ((m + n) % 2 == 0) {
            return ((double) findK(nums1, 0, nums2, 0, mid) + findK(nums1, 0, nums2, 0, mid + 1)) / 2;
        } else {
            return findK(nums1, 0, nums2, 0, mid + 1);
        }
    }

    private int findK(int[] num1, int left1, int[] num2, int left2, int k) {
        System.out.println(left1 + "," + left2 + "," + k);
        if (left1 >= num1.length) {
            return num2[left2 + k - 1];
        }
        if (left2 >= num2.length) {
            return num1[left1 + k - 1];
        }
        if (k == 1) {
            return Math.min(num1[left1], num2[left2]);
        }
        int mid1 = left1 + k / 2 - 1;
        int mid2 = left2 + k / 2 - 1;
        if (mid1 >= num1.length) {
            return findK(num1, left1, num2, mid2 + 1, k - k / 2);
        }
        if (mid2 >= num2.length) {
            return findK(num1, mid1 + 1, num2, left2, k - k / 2);
        }
        int val1 = num1[left1 + k / 2 - 1];
        int val2 = num2[left2 + k / 2 - 1];
        if (val1 <= val2) {
            return findK(num1, mid1 + 1, num2, left2, k - k / 2);
        } else {
            return findK(num1, left1, num2, mid2 + 1, k - k / 2);
        }
    }

    public static void main(String[] args) {
        So4 so = new So4();
        System.out.println(so.findMedianSortedArrays(new int[]{4}, new int[]{1, 2, 3, 5, 6}));
    }
}
