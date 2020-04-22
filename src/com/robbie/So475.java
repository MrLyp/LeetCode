package com.robbie;

import java.util.Arrays;

public class So475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int j = 0;
        int r = 0;
        for (int i = 0 ; i < houses.length; i++) {
            int d = Math.abs(houses[i] - heaters[j]);
            while (j + 1 < heaters.length) {
                int nd = Math.abs(houses[i] - heaters[j + 1]);
                if (nd > d) {
                    break;
                }
                j++;
                d = nd;
            }
            r = Math.max(r, d);
        }
        return r;
    }

    public static void main(String[] args) {
        So475 so = new So475();
        System.out.println(so.findRadius(new int[]{1,2,3}, new int[]{2}));
        System.out.println(so.findRadius(new int[]{1,20,31,41}, new int[]{1,4}));
    }
}
