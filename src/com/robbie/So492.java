package com.robbie;

import java.util.Arrays;

public class So492 {
    public int[] constructRectangle(int area) {
        int max = (int) Math.sqrt(area);
        if (max * max == area) {
            return new int[]{max, max};
        }
        for (int w = max; w > 0; w--) {
            if (area % w == 0) {
                int l = area / w;
                return new int[]{l, w};
            }
        }
        return new int[]{area, 1};
    }

    public static void main(String[] args) {
        So492 so = new So492();
        System.out.println(Arrays.toString(so.constructRectangle(4)));
        System.out.println(Arrays.toString(so.constructRectangle(6)));
        System.out.println(Arrays.toString(so.constructRectangle(234)));
        System.out.println(Arrays.toString(so.constructRectangle(12)));
    }
}
