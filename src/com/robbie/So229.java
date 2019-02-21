package com.robbie;

import java.util.ArrayList;
import java.util.List;

public class So229 {

    public List<Integer> majorityElement(int[] nums) {
        int m1 = 0, m2 = 0, c1 = 0, c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (m1 == nums[i]) {
                c1++;
                continue;
            }
            if (m2 == nums[i]) {
                c2++;
                continue;
            }
            if (c1 == 0) {
                m1 = nums[i];
                c1++;
                continue;
            }
            if (c2 == 0) {
                m2 = nums[i];
                c2++;
                continue;
            }

            c1--;
            c2--;
        }
        c1 = 0;
        c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == m1)
                c1++;
            else if (nums[i] == m2) {
                c2++;
            }
        }
        List<Integer> result = new ArrayList<>();
        if (c1 > nums.length / 3)
            result.add(m1);
        if (c2 > nums.length / 3)
            result.add(m2);
        return result;
    }

    public static void main(String[] args) {
        So229 so = new So229();
        System.out.println(so.majorityElement(new int[]{3, 2, 3}));
        System.out.println(so.majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2}));
    }
}
