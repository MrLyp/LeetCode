package com.robbie;

import java.util.ArrayList;
import java.util.List;

public class So386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>(n);
        add(res, 0, n);
        return res;
    }

    private void add(List<Integer> res, int start, int n) {
        for (int i = 0; i <= 9; i++) {
            int num = start * 10 + i;
            if (num == 0)
                continue;
            if (num <= n) {
                res.add(num);
                add(res, num, n);
            }
        }
    }

    public static void main(String[] args) {
        So386 so = new So386();
        System.out.println(so.lexicalOrder(103));
    }
}
