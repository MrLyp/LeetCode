package com.robbie;

public class So299 {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] count = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                if (count[secret.charAt(i) - '0']++ < 0)
                    cows++;
                if (count[guess.charAt(i) - '0']-- > 0)
                    cows++;
            }
        }

        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        So299 so = new So299();
        System.out.println(so.getHint("11", "10"));
    }
}
