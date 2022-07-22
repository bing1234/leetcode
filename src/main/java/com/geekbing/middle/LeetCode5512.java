package com.geekbing.middle;

/**
 * todo
 */
public class LeetCode5512 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (unHappy(i, preferences, pairs)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean unHappy(int i, int[][] preferences, int[][] pairs) {
        return false;
    }

    public static void main(String[] args) {
        LeetCode5512 leetCode5512 = new LeetCode5512();

        int[][] preferences1 = new int[4][3];
        preferences1[0] = new int[]{1, 2, 3};
        preferences1[1] = new int[]{3, 2, 0};
        preferences1[2] = new int[]{3, 1, 0};
        preferences1[3] = new int[]{1, 2, 0};
        int[][] pairs1 = new int[2][2];
        pairs1[0] = new int[]{0, 1};
        pairs1[1] = new int[]{2, 3};
        System.out.println(leetCode5512.unhappyFriends(4, preferences1, pairs1));

        int[][] preferences2 = new int[2][1];
        preferences2[0] = new int[]{1};
        preferences2[1] = new int[]{0};
        int[][] pairs2 = new int[1][2];
        pairs2[0] = new int[]{1, 0};
        System.out.println(leetCode5512.unhappyFriends(4, preferences2, pairs2));

        int[][] preferences3 = new int[4][5];
        preferences3[0] = new int[]{1, 3, 2};
        preferences3[1] = new int[]{2, 3, 0};
        preferences3[2] = new int[]{1, 3, 0};
        preferences3[3] = new int[]{0, 2, 1};
        int[][] pairs3 = new int[2][2];
        pairs3[0] = new int[]{1, 3};
        pairs3[1] = new int[]{0, 2};
        System.out.println(leetCode5512.unhappyFriends(4, preferences3, pairs3));
    }
}
