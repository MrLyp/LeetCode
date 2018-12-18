package com.robbie;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/largest-number/
public class So179 {

    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return compareValue(o1, o2);
            }
        });
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            if (res.length() == 0 && strs[i].equals("0")) {
                continue;
            }
            res.append(strs[i]);
        }
        if (res.length() == 0)
            return "0";
        return res.toString();
    }

    private int compareValue(String o1, String o2) {
        String res1 = o1 + o2;
        String res2 = o2 + o1;
        return res2.compareTo(res1);
    }

    public static void main(String[] args) {
        check(new int[]{10, 2}, "210");
        check(new int[]{3, 30, 34, 5, 9}, "9534330");
        check(new int[]{0, 0}, "0");
        check(new int[]{0, 0, 3}, "300");
        check(new int[]{824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247}, "9609938824824769735703560743981399");
        check(new int[]{121, 12}, "12121");
        check(new int[]{9051, 5526, 2264, 5041, 1630, 5906, 6787, 8382, 4662, 4532, 6804, 4710, 4542, 2116, 7219, 8701, 8308, 957, 8775, 4822, 396, 8995, 8597, 2304, 8902, 830, 8591, 5828, 9642, 7100, 3976, 5565, 5490, 1613, 5731, 8052, 8985, 2623, 6325, 3723, 5224, 8274, 4787, 6310, 3393, 78, 3288, 7584, 7440, 5752, 351, 4555, 7265, 9959, 3866, 9854, 2709, 5817, 7272, 43, 1014, 7527, 3946, 4289, 1272, 5213, 710, 1603, 2436, 8823, 5228, 2581, 771, 3700, 2109, 5638, 3402, 3910, 871, 5441, 6861, 9556, 1089, 4088, 2788, 9632, 6822, 6145, 5137, 236, 683, 2869, 9525, 8161, 8374, 2439, 6028, 7813, 6406, 7519}, "995998549642963295795569525905189958985890288238775871870185978591838283748308830827481618052787813771758475277519744072727265721971071006861683682268046787640663256310614560285906582858175752573156385565552654905441522852245213513750414822478747104662455545424532434289408839763963946391038663723370035134023393328828692788270926232581243924362362304226421162109163016131603127210891014");
    }

    private static void check(int[] numbers, String target) {
        So179 so = new So179();
        String res = so.largestNumber(numbers);
        if (!target.equals(res)) {
            throw new IllegalStateException(target + "," + res);
        } else {
            System.out.println(target + "," + res + ", pass");
        }
    }

}
