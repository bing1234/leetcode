package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode5792 {
    public int countTriples(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i * i);
        }

        int ans = 0;
        for (int i = list.size() - 1; i >= 3; i--) {
            ans += 2 * findTwoSum(list, i, list.get(i));
        }
        return ans;
    }

    private int findTwoSum(List<Integer> list, int end, int sum) {
        int start = 0, temp, ans = 0;
        while (start < end) {
            temp = list.get(start) + list.get(end);
            if (temp < sum) {
                start++;
            } else if (temp == sum) {
                ans++;
                start++;
                end--;
            } else {
                end--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode5792 leetCode5792 = new LeetCode5792();

        System.out.println(leetCode5792.countTriples(5));
        System.out.println(leetCode5792.countTriples(10));
    }
}
