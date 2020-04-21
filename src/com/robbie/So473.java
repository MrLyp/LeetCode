package com.robbie;

public class So473 {
    public boolean makesquare(int[] nums) {
        if (nums == null)
            return false;
        int sum  = 0;
        for (int i : nums)
            sum += i;
        if (sum == 0)
            return false;
        if (sum % 4 != 0)
            return false;
        int sl = sum / 4;
        return dfs(nums, sl, new int[4], 0);
    }

    private boolean dfs(int[] nums, int target, int[] sides, int index) {
        if (index == nums.length) {
            return isSquare(sides);
        }
        int stick = nums[index];
        for (int i = 0; i < 4; i++) {
            if (sides[i] + stick <= target) {
                sides[i] += stick;
                if (dfs(nums, target, sides, index + 1))
                    return true;
                sides[i] -= stick;
            }
        }
        return false;
    }

    private boolean isSquare(int[] sides) {
        for (int i = 1; i < 4; i++)
            if (sides[i] != sides[0])
                return false;
        return true;
    }

    public static void main(String[] args) {
        So473 so = new So473();
        System.out.println(so.makesquare(new int[]{1,1,2,2,2}));
        System.out.println(so.makesquare(new int[]{3,3,3,3,4}));
    }
}
