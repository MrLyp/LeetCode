package com.robbie;

public class So319 {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    public static void main(String[] args) {
        So319 so = new So319();
        System.out.println(so.bulbSwitch(3));
    }
}
