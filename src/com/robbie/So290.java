package com.robbie;

import java.util.HashMap;
import java.util.Map;

public class So290 {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null)
            return str == null;
        String[] array = str.split(" ");
        if (pattern.length() != array.length)
            return false;
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> rmap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            String value = map.get(pattern.charAt(i));
            if (value != null && !value.equals(array[i]))
                return false;
            Character key = rmap.get(array[i]);
            if (key != null && key != pattern.charAt(i))
                return false;
            rmap.put(array[i], pattern.charAt(i));
            map.put(pattern.charAt(i), array[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        So290 so = new So290();
        System.out.println(so.wordPattern("abba", "dog cat cat fish"));
    }
}
