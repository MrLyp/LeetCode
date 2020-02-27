package com.robbie;

public class So458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int round = minutesToTest / minutesToDie + 1;
        return (int) Math.ceil(Math.log(buckets) / Math.log(round));
    }

    public static void main(String[] args) {
        So458 so = new So458();
        System.out.println(so.poorPigs(1000, 15, 60));
    }
}
