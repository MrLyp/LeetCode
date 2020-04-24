package com.robbie;

public class So495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0)
            return 0;
        int sum = 0;
        int last = timeSeries[0];
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] - last>= duration) {
                sum += duration;
            } else {
                sum += timeSeries[i] - last;
            }
            last = timeSeries[i];
        }
        sum += duration;
        return sum;
    }

    public static void main(String[] args) {
        So495 so = new So495();
        System.out.println(so.findPoisonedDuration(new int[]{1, 4, 5}, 2));
        System.out.println(so.findPoisonedDuration(new int[]{1, 2, 3}, 2));
    }
}
