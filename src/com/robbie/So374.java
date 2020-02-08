package com.robbie;

public class So374 {
    public int guessNumber(int n) {
        long h = n;
        long l = 1;

        while (l <= h) {
            long mid = (l + h) / 2;
            int g = guess((int) mid);
            if (g == 0)
                return (int) mid;
            else if (g < 0)
                h = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    private int guess(int num) {
        if (num > 1702766719)
            return 1;
        else if (num == 1702766719)
            return 0;
        else
            return -1;
    }

    public static void main(String[] args) {
        So374 so = new So374();
        System.out.println(so.guessNumber(2126753390
                ));
    }
}
