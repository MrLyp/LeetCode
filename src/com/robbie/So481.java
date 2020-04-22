package com.robbie;

public class So481 {
    public int magicalString(int n) {
        StringBuilder builder = new StringBuilder("122");
        int index = 2;
        boolean _2 = false;
        while (builder.length() < n) {
            int count = builder.charAt(index) - '0';
            index ++;
            while (count-- > 0) {
                builder.append(_2 ? '2' : '1');
            }
            _2 = !_2;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (builder.charAt(i) == '1')
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        So481 so = new So481();
        System.out.println(so.magicalString(6));
    }
}
