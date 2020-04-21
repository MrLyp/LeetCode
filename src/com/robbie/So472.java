package com.robbie;

import java.util.*;

public class So472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> list = Arrays.asList(words);
        Set<String> wordSet = new HashSet<>(list);
        List<String> res = new ArrayList<>();
        for (String word: words) {
            if (dfs(wordSet, word, 0))
                res.add(word);
        }
        return res;
    }

    private boolean dfs(Set<String> wordSet, String word, int level) {
        if (wordSet.contains(word) && level > 0)
            return true;
        for (int i = 1 ; i < word.length(); i++) {
            if (!wordSet.contains(word.substring(0, i)))
                continue;
            String next = word.substring(i);
            if (wordSet.contains(next) || dfs(wordSet, next, level + 1))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        So472 so = new So472();
        System.out.println(so.findAllConcatenatedWordsInADict(new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}));
    }
}
