package com.robbie;

public class So440 {
    public int findKthNumber(int n, int k) {
//        return find(0, n, k, new int[]{0});
        long start = 1;
        k -= 1;
        while (k > 0) {
            int gap = 0;
            long l = start;
            long r = start + 1;
            while (l <= n) {
                if (r > n + 1)
                    gap += n - l + 1;
                else
                    gap += r - l;
                l *= 10;
                r *= 10;
            }
            if (gap <= k) {
                start++;
                k -= gap;
            } else {
                start *= 10;
                k--;
            }
        }
        return (int) start;
    }

    private int find(int start, int n, int k, int[] count) {
        for (int i = 0; i <= 9; i++) {
            int num = start * 10 + i;
            if (num == 0)
                continue;
            if (num <= n) {
                count[0]++;
                if (count[0] == k)
                    return num;
                int res = find(num, n, k, count);
                if (res > 0)
                    return res;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        So440 so = new So440();
        System.out.println(so.findKthNumber(681692778 ,351251360));
        System.out.println(so.findKthNumber(13, 3));
        System.out.println(so.findKthNumber(13, 4));
        System.out.println(so.findKthNumber(13, 5));
        System.out.println(so.findKthNumber(13, 6));
        System.out.println(so.findKthNumber(13, 7));
    }
}
