package com.robbie;

import java.util.ArrayList;
import java.util.List;

public class So295 {
    // 这里只是为了测试速度，插入排序的方式效率怎么样，从效果上看使用ArrayList要好于LinkedList，看来testcase更多是查找中位数，而不是插入
    static class MedianFinder {

        private List<Integer> list;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            list = new ArrayList<>();
//            list = new LinkedList<>();
        }

        public void addNum(int num) {
            int i = 0;
            for (int item : list) {
                if (item > num) {
                    list.add(i, num);
                    return;
                }
                i++;
            }
            list.add(num);
        }

        public double findMedian() {
            int n = list.size();
            if (n % 2 == 0) {
                int mid = n / 2;
                return (list.get(mid) + list.get(mid - 1)) / 2.0;
            } else {
                return list.get(n / 2);
            }
        }
    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
        finder.addNum(4);
        System.out.println(finder.findMedian());
    }
}
