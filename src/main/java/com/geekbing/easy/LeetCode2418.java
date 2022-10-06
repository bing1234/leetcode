package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bing
 */
public class LeetCode2418 {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], names[i]);
        }
        heights = Arrays.stream(heights).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        String[] ans = new String[heights.length];
        for (int i = 0; i < heights.length; i++) {
            ans[i] = map.get(heights[i]);
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode2418 leetCode2418 = new LeetCode2418();
        String[] ans = leetCode2418.sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170});
        String[] expert = new String[]{"Mary", "Emma", "John"};
        assert Arrays.equals(expert, ans);
    }

    @Test
    public void testCase2() {
        LeetCode2418 leetCode2418 = new LeetCode2418();
        String[] ans = leetCode2418.sortPeople(new String[]{"Alice", "Bob", "Bob"}, new int[]{155, 185, 150});
        String[] expert = new String[]{"Bob", "Alice", "Bob"};
        assert Arrays.equals(expert, ans);
    }
}
