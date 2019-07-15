package com.robbie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leeyunpeng on 2019/7/15.
 */
public class So17 {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        find(res, digits, "");
        return res;
    }

    private void find(List<String> res, String digits, String temp) {
        if (digits.length() == 0) {
            res.add(temp);
            return;
        }
        char c = digits.charAt(0);
        String dict = getMapping(c);
        if (dict.length() == 0) {
            res.add(temp);
            return;
        }
        for (int i = 0; i < dict.length(); i++) {
            find(res, digits.substring(1), temp + dict.charAt(i));
        }
    }

    private String getMapping(char c) {
        if (c == '2')
            return "abc";
        else if (c == '3')
            return "def";
        else if (c == '4')
            return "ghi";
        else if (c == '5')
            return "jkl";
        else if (c == '6')
            return "mno";
        else if (c == '7')
            return "pqrs";
        else if (c == '8')
            return "tuv";
        else if (c == '9')
            return "wxyz";
        else
            return "";
    }

    public static void main(String[] args) {
        So17 so = new So17();
        System.out.println(so.letterCombinations("234"));
    }
}
