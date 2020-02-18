package com.robbie;

public class So405 {

    // 这个是正向处理的办法，其实反向处理再reverse代码会稍微简单一点，减少一些临时变量和移位操作
    public String toHex(int num) {
        StringBuilder builder = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            int offset = 4 * i;
            int digits = (num & (15 << offset)) >>> offset;
            if (builder.length() == 0 && digits == 0)
                continue;
            builder.append(numToChar(digits));
        }
        if (builder.length() == 0)
            return "0";
        return builder.toString();
    }

    private char numToChar(int num) {
        if (num < 10)
            return (char) ('0' + num);
        else
            return (char) ('a' + num - 10);
    }

    public static void main(String[] args) {
        So405 so = new So405();
        System.out.println(so.toHex(26));
        System.out.println(so.toHex(-1));
    }
}
