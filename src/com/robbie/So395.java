package com.robbie;

public class So395 {
    public int longestSubstring(String s, int k) {
        return findLongestRecursive(s, 0, s.length(), k);
    }


    private int findLongestRecursive(String s, int start, int end, int k) {
        if (end - start < k)
            return 0;
        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = start; i < end; i++) {
            int sum = count[s.charAt(i) - 'a'];
            if (sum < k) {
                return Math.max(findLongestRecursive(s, start, i, k), findLongestRecursive(s, i + 1, end, k));
            }
        }
        return end - start;
    }

    public static void main(String[] args) {
        So395 so = new So395();
        System.out.println(so.longestSubstring("aaabb", 3));
        System.out.println(so.longestSubstring("ababbc", 2));
        System.out.println(so.longestSubstring("abcdedghijklmnopqrstuvwxyz", 2));
    }
}
