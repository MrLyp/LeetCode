package com.robbie;

public class So275 {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        int n = citations.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (citations[mid] > n - mid)
                r = mid - 1;
            else if (citations[mid] < n - mid)
                l = mid + 1;
            else
                return n - mid;
        }
        return n - l;
    }

    public static void main(String[] args) {
        So275 so = new So275();
        System.out.println(so.hIndex(new int[]{0, 1, 3, 5, 6}));
        System.out.println(so.hIndex(new int[]{11, 15}));
        System.out.println(so.hIndex(new int[]{0}));
        System.out.println(so.hIndex(new int[]{1,1,2,3,4,5,7}));
    }
}
