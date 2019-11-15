package com.robbie;

public class So292 {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        So292 so = new So292();
        System.out.println(so.canWinNim(5));
    }
}
