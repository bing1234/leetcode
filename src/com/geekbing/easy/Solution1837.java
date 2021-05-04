package com.geekbing.easy;

/**
 * @author bing
 */
public class Solution1837 {
    public int sumBase(int n, int k) {
        int ans = 0;
        while (n > 0) {
            ans += n % k;
            n = n / k;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1837 solution1837 = new Solution1837();
        System.out.println(solution1837.sumBase(34, 6));
        System.out.println(solution1837.sumBase(10, 10));
    }
}
