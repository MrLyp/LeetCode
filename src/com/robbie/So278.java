package com.robbie;

/**
 * Created by leeyunpeng on 2019/7/25.
 */
public class So278 {

    boolean isBadVersion(int version) {
        return version >= 4;
    }

    public int firstBadVersion(int n) {
        if (isBadVersion(1))
            return 1;
        int end = n;
        int start = 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid))
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }

    public static void main(String[] args) {
        So278 so = new So278();
        System.out.println(so.firstBadVersion(4));
    }
}
