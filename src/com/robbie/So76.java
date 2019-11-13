package com.robbie;


public class So76 {
    public String minWindow(String s, String t) {
        int l = 0;
        int r = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        int[] arr = new int[128];
        for (int i = 0 ; i < t.length(); i++) {
            arr[t.charAt(i)]++;
        }
        int remain = t.length();
        while (l <= r && r < s.length()) {
            if (arr[s.charAt(r)] > 0) {
                remain--;
            }
            arr[s.charAt(r)]--;
            while(remain == 0){
                if (min > r - l + 1) {
                    min = r - l + 1;
                    res = s.substring(l, r + 1);
                }

                arr[s.charAt(l)]++;
                if (arr[s.charAt(l)] > 0) {
                    remain++;
                }
                l++;
            }
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        So76 so = new So76();
        System.out.println(so.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(so.minWindow("a", "a"));
    }
}
