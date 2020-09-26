package com.geekbing.middle;

public class LeetCode605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int ans = 0;
        // 当前是否有做边界、当前是否有右边
        int left = 0, right = 0;
        boolean hasLeft = false, hasRight = false;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                hasRight = true;
                right = i - 1;

                ans += calNum(left, right, hasLeft, hasRight);
                if (ans >= n) {
                    return true;
                }

                hasLeft = true;
                hasRight = false;
                left = i + 1;
            } else {
                right = i;
            }
        }
        ans += calNum(left, right, hasLeft, hasRight);
        return ans >= n;
    }

    private int calNum(int left, int right, boolean hasLeft, boolean hasRight) {
        int len = right - left + 1;
        if (len <= 0) {
            return 0;
        }
        if (hasLeft && hasRight) {
            if (len < 3) {
                return 0;
            }
            return (len - 1) / 2;
        } else if (!hasLeft && !hasRight) {
            return (len + 1) / 2;
        } else {
            return len / 2;
        }
    }

    public static void main(String[] args) {
        LeetCode605 leetCode605 = new LeetCode605();
//        System.out.println(leetCode605.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
//        System.out.println(leetCode605.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        System.out.println(leetCode605.canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0}, 2));
    }
}
