package com.geekbing.middle;

public class LeetCode1004 {
    public int longestOnes(int[] A, int K) {
        int left = 0, right = 0, zeroCount = 0, ans = 0;
        while (left <= right && right < A.length) {
            if (A[right] == 0) {
                zeroCount++;
            }
            if (zeroCount <= K) {
                ans = Math.max(ans, right - left + 1);
                right++;
            } else {
                while (left <= right && A[left] == 1) {
                    left++;
                }
                left++;
                zeroCount--;

                right++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1004 leetCode1004 = new LeetCode1004();
        System.out.println(leetCode1004.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(leetCode1004.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }
}
