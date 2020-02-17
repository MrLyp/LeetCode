package com.robbie;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class So401 {
    public List<String> readBinaryWatch(int num) {
        Map<Integer, List<Integer>> hours = new HashMap<>();
        for (int i = 0; i < 12; i++) {
            int bitCount = Integer.bitCount(i);
            List<Integer> list = hours.getOrDefault(bitCount, new ArrayList<>());
            list.add(i);
            hours.put(bitCount, list);
        }
        Map<Integer, List<Integer>> minutes = new HashMap<>();
        for (int i = 0; i <= 59; i++) {
            int bitCount = Integer.bitCount(i);
            List<Integer> list = minutes.getOrDefault(bitCount, new ArrayList<>());
            list.add(i);
            minutes.put(bitCount, list);
        }
        int hourUpper = Math.min(num, 4);
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= hourUpper; i++) {
            if (num - i > 6 || num - i < 0)
                continue;
            List<Integer> hourList = hours.get(i);
            if (hourList == null)
                continue;
            List<Integer> minuteList = minutes.get(num - i);
            if (minuteList == null)
                continue;
            result.addAll(make(hourList, minuteList));
        }
        return result;
    }

    private List<String> make(List<Integer> hours, List<Integer> minutes) {
        List<String> result = new ArrayList<>();
        for (Integer hour : hours) {
            for (Integer min : minutes) {
                StringBuilder builder = new StringBuilder();
                builder.append(hour);
                builder.append(":");
                if (min < 10)
                    builder.append("0");
                builder.append(min);
                result.add(builder.toString());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        So401 so = new So401();
        System.out.println(so.readBinaryWatch(2));
    }
}
