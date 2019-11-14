package com.robbie;

import java.util.Arrays;

public class So274 {
    public int hIndex(int[] citations) {
        if (citations == null)
            return 0;
        int len = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < len; i++) {
            if (citations[i] >= len - i)
                return len - i;
        }
        return 0;
    }

    public static void main(String[] args) {
        So274 so = new So274();
        System.out.println(so.hIndex(new int[]{3, 0, 6, 1, 5, 1}));
        System.out.println(so.hIndex(new int[]{1,1,2,3,4,5,7}));
    }
}
