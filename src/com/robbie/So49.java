package com.robbie;

import java.util.*;

public class So49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            for (int t = 0; t < 26; t++)
                count[t] = 0;
            for (int j = 0; j < str.length(); j++) {
                count[str.charAt(j) - 'a']++;
            }
            String key = "";
            for (int t = 0; t < 26; t++) {
                key += count[t] + 'a';
            }
            List<String> value = map.get(key);
            if (value == null)
                value = new ArrayList<>();
            value.add(str);
            map.put(key, value);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        So49 so = new So49();
        System.out.println(so.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
