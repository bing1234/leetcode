package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LeetCode253 {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(new int[]{interval[0], 1});
            list.add(new int[]{interval[1], -1});
        }
        list.sort((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int ans = 0, cnt = 0;
        for (int[] item : list) {
            cnt += item[1];
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode253 leetCode253 = new LeetCode253();
        assert leetCode253.minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}) == 2;
    }

    @Test
    public void testCase2() {
        LeetCode253 leetCode253 = new LeetCode253();
        assert leetCode253.minMeetingRooms(new int[][]{{7, 10}, {2, 4}}) == 1;
    }
}
