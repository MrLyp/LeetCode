package com.robbie;

public class So275 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r + 1 >>> 1;
            if (citations[n - mid] >= mid) l = mid;
            else r = mid - 1;
        }
        return r;
    }

    public static void main(String[] args) {
        So275 so = new So275();
        System.out.println(so.hIndex(new int[]{0,1,3,5,6}));
        System.out.println(so.hIndex(new int[]{0}));
    }
}
