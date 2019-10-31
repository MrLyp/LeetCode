package com.robbie;

import java.util.Arrays;
import java.util.List;

public class So1239 {
    int result = 0;
    public int maxLength(List<String> arr) {
        dfs(arr, "", 0);
        return result;
    }

    private void dfs(List<String> arr, String str, int index) {
        if (!isUnique(str)) {
            return;
        }
        result = Math.max(result, str.length());
        if (index >= arr.size()) {
            return;
        }
        for (int i = index; i < arr.size(); i++) {
            dfs(arr, str + arr.get(i), i + 1);
        }
    }

    private boolean isUnique(String s) {
        int map = 0;
        for (char c : s.toCharArray()) {
            int move = c - 'a';
            if ((map & (1 << move)) != 0) {
                return false;
            }
            map |= 1 << move;
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> arr = Arrays.asList("cha", "r", "act", "ers");
        So1239 so = new So1239();
        System.out.println(so.maxLength(arr));
    }
}
