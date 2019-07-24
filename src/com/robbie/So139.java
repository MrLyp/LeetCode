package com.robbie;

import java.util.Arrays;
import java.util.List;

public class So139 {
    public boolean wordBreak(String s, List<String> wordDict) {
//        for (int i = 0; i < wordDict.size(); i++) {
//            if (s.equals(wordDict.get(i)))
//                return true;
//            if (s.startsWith(wordDict.get(i)))
//                if (wordBreak(s.substring(wordDict.get(i).length()), wordDict))
//                    return true;
//        }
//        return false;
        boolean[] dp = new boolean[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i] = wordDict.contains(s.substring(0, i));
        }
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        So139 so = new So139();
        System.out.println(so.wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(so.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(so.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
