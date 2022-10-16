package com.geekbing.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/group-the-people-given-the-group-size-they-belong-to/
 * 1282. 用户分组
 *
 * @author bing
 */
public class LeetCode1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        // 将同一组的元素放在一起
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> arr = map.get(groupSizes[i]);
            if (arr == null) {
                arr = new ArrayList<>();
            }
            arr.add(i);
            map.put(groupSizes[i], arr);
        }
        List<List<Integer>> ans = new ArrayList<>();
        map.forEach((key, value) -> {
            for (int i = 0; i < value.size(); i += key) {
                ans.add(value.subList(i, i + key));
            }
        });
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1282 leetCode1282 = new LeetCode1282();
        System.out.println(leetCode1282.groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3}));
        System.out.println(leetCode1282.groupThePeople(new int[]{2, 1, 3, 3, 3, 2}));
    }
}
