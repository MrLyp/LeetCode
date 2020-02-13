package com.robbie;

public class So393 {
    public boolean validUtf8(int[] data) {
        return valid(0, data.length - 1, data);
    }

    private boolean valid(int start, int end, int[] data) {
        if (start > end)
            return true;
        int num = data[start];
        // 1 byte
        if ((num & (1 << 7)) == 0) {
            return valid(start + 1, end, data);
        }
        // 2 bytes
        if ((num & (7 << 5)) == 0b11000000) {
            return start + 1 <= end && startWith10(data[start + 1]) && valid(start + 2, end, data);
        }
        // 3bytes
        if ((num & (15 << 4)) == 0b11100000) {
            return (start + 2 <= end) && startWith10(data[start + 1]) && startWith10(data[start + 2]) && valid(start + 3, end, data);
        }
        // 4bytes
        if ((num & (31 << 3)) == 0b11110000) {
            return (start + 3 <= end) && startWith10(data[start + 1]) && startWith10(data[start + 2]) && startWith10(data[start + 3]) && valid(start + 4, end, data);
        }
        return false;
    }

    private boolean startWith10(int num) {
        return (num & (3 << 6)) == 0b10000000;
    }

    public static void main(String[] args) {
        So393 so = new So393();
//        System.out.println(so.validUtf8(new int[]{197, 130, 1}));
//        System.out.println(so.validUtf8(new int[]{235, 140, 4}));
        System.out.println(so.validUtf8(new int[]{248,130,130,130}));
    }
}
