package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1446 {
    public int maxPower(String s) {
        char[] chars = s.toCharArray();
        char pre = chars[0], cur;
        int curNum = 1, ans = 1;
        for (int i = 1; i < chars.length; i++) {
            cur = chars[i];
            if (cur == pre) {
                curNum++;
            } else {
                curNum = 1;
                pre = cur;
            }
            ans = Math.max(ans, curNum);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1446 leetCode1446 = new LeetCode1446();
        System.out.println(leetCode1446.maxPower("leetcode"));
        System.out.println(leetCode1446.maxPower("abbcccddddeeeeedcba"));
        System.out.println(leetCode1446.maxPower("triplepillooooow"));
        System.out.println(leetCode1446.maxPower("hooraaaaaaaaaaay"));
        System.out.println(leetCode1446.maxPower("tourist"));
        System.out.println(leetCode1446.maxPower("j"));
    }
}
