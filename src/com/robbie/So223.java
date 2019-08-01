package com.robbie;

public class So223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaA = (C - A) * (D - B);
        int areaB = (G - E) * (H - F);
        if (G < A || E > C || H < B || F > D)
            return areaA + areaB;
        int w, h;
        w = Math.min(G, C) - Math.max(A, E);
        h = Math.min(H, D) - Math.max(B, F);
        if (w < 0)
            w = 0;
        if (h < 0)
            h = 0;
        return areaA + areaB - w * h;
    }

    public static void main(String[] args) {
        So223 so = new So223();
        System.out.println(so.computeArea(-3, 0, 3, 4, 0, -1, 9 , 2));
    }
}
