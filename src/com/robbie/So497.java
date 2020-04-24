package com.robbie;

import java.util.Random;

public class So497 {
    class Solution {

        private int[][] rects;

        private Random mRandom = new Random();

        public Solution(int[][] rects) {
            this.rects = rects;
        }

        public int[] pick() {
            int[] rect = rects[mRandom.nextInt(rects.length)];
            int x = rect[0] + (int)(mRandom.nextDouble() * (rect[2] - rect[0]));
            int y = rect[1] + (int)(mRandom.nextDouble() * (rect[3] - rect[1]));
            return new int[]{x, y};
        }
    }
}
