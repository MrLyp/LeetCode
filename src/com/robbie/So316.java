package com.robbie;

import java.util.ArrayList;
import java.util.List;

public class So316 {
    public String removeDuplicateLetters(String s) {
        if (s == null)
            return null;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int i = 0;
        List<Character> list = new ArrayList<>();
        while (i < s.length()) {
            char c = s.charAt(i);
            if (list.size() > 0) {
                int length = list.size();
                while (length > 0 && !list.contains(c)) {
                    char last = list.get(length - 1);
                    if (c < last && count[last - 'a'] > 1) {
                        list.remove(--length);
                        count[last - 'a']--;
                    } else {
                        break;
                    }
                }
            }
            if (list.contains(c)) {
                count[c - 'a']--;
            } else {
                list.add(c);
            }
            i++;
        }
        StringBuilder builder = new StringBuilder();
        for (char c : list)
            builder.append(c);
        return builder.toString();
    }

    public static void main(String[] args) {
        So316 so = new So316();
        System.out.println(so.removeDuplicateLetters("cbacdcbc"));
        System.out.println(so.removeDuplicateLetters("abacb"));
    }
}
