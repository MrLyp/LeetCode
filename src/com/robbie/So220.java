package com.robbie;

import java.util.HashMap;
import java.util.Map;

public class So220 {
    // TLE
    public boolean containsNearbyAlmostDuplicateBad(int[] nums, int k, int t) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = -t; j <= t; j++) {
                if (map.containsKey(nums[i] + j) && Math.abs(map.get(nums[i] + j) - i) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    // 将大小比较转化为除法，比上面那个效率高很多
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0 || k <= 0) return false;

        Map<Long, Integer> data = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long bucketId = getBucketId((long) nums[i], t);
            for (int j = -1; j <= 1; j++) {
                long key = bucketId + j;
                if (data.containsKey(key) && Math.abs(data.get(key) - (long) nums[i]) <= t) {
                    return true;
                }
            }
            if (i >= k) {
                data.remove(getBucketId((long) nums[i - k], t));
            }
            data.put(bucketId, nums[i]);
        }

        return false;
    }

    private long getBucketId(long itm, int t) {
        return t == 0 ? itm : itm / t;
    }


    public static void main(String[] args) {
        So220 so = new So220();
        System.out.println(so.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(so.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
    }

}
