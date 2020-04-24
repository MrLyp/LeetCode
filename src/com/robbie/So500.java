package com.robbie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class So500 {
    public String[] findWords(String[] words) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('q', 0);
        map.put('w', 0);
        map.put('e', 0);
        map.put('r', 0);
        map.put('t', 0);
        map.put('y', 0);
        map.put('u', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('p', 0);
        map.put('a', 1);
        map.put('s', 1);
        map.put('d', 1);
        map.put('f', 1);
        map.put('g', 1);
        map.put('h', 1);
        map.put('j', 1);
        map.put('k', 1);
        map.put('l', 1);
        map.put('z', 2);
        map.put('x', 2);
        map.put('c', 2);
        map.put('v', 2);
        map.put('b', 2);
        map.put('n', 2);
        map.put('m', 2);
        List<String> list = new ArrayList<>();
        for (String w : words) {
            String word = w.toLowerCase();
            int row = map.get(word.charAt(0));
            boolean flag = true;
            for (int i = 1; i < word.length(); i++) {
                if (row != map.get(word.charAt(i))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(w);
            }
        }
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        So500 so = new So500();
        System.out.println(Arrays.toString(so.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
    }
}
