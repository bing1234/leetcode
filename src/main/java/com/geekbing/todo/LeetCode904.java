package com.geekbing.todo;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode904 {
    public int totalFruit(int[] fruits) {
        // 维持一个[left, right]的滑动窗口，保持窗口内元素种类最多只有2种即可
        int left = 0, right = 0, cnt = 1, ans = 1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(fruits[0], 1);
        while (right + 1 < fruits.length) {
            if (map.size() < 2 || (map.size() == 2 && map.containsKey(fruits[right + 1]))) {
                // 右边进行扩张
                right++;
                cnt++;
                map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
                ans = Math.max(ans, cnt);
            } else {
                // 左边收缩
                while (map.size() > 1) {
                    int num = map.getOrDefault(fruits[left], 0);
                    if (num == 1) {
                        map.remove(fruits[left]);
                    } else {
                        map.put(fruits[left], num - 1);
                    }
                    left++;
                    cnt--;
                }
            }
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode904 leetCode904 = new LeetCode904();
        assert leetCode904.totalFruit(new int[]{1, 2, 1}) == 3;
    }

    @Test
    public void testCase2() {
        LeetCode904 leetCode904 = new LeetCode904();
        assert leetCode904.totalFruit(new int[]{0, 1, 2, 2}) == 3;
    }

    @Test
    public void testCase3() {
        LeetCode904 leetCode904 = new LeetCode904();
        assert leetCode904.totalFruit(new int[]{1, 2, 3, 2, 2}) == 4;
    }

    @Test
    public void testCase4() {
        LeetCode904 leetCode904 = new LeetCode904();
        assert leetCode904.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}) == 5;
    }
}
