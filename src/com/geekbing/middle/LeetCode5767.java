package com.geekbing.middle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode5767 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        // 挑选出与范围有关的段
        List<int[]> list = new ArrayList<>();
        for (int[] range : ranges) {
            if (range[1] < left || range[0] > right) {
                continue;
            }
            list.add(range);
        }

        // 按照左端点排序
        list.sort(Comparator.comparingInt(o -> o[0]));

        // 查看上面的段是否完全覆盖
        if (list.isEmpty() || list.get(0)[0] > left) {
            return false;
        }
        // 特殊情况处理
        if (list.size() == 1) {
            return list.get(0)[0] <= left && list.get(0)[1] >= right;
        }

        int end = list.get(0)[1];
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i)[0] > end + 1) {
                return false;
            }
            end = Math.max(end, list.get(i)[1]);
            if (end >= right) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode5767 leetCode5767 = new LeetCode5767();

//        System.out.println(leetCode5767.isCovered(new int[][]{{1, 2}, {3, 4}, {5, 6}}, 2, 5) );
//        System.out.println(leetCode5767.isCovered(new int[][]{{1, 10}, {10, 20}}, 21, 21));
//        System.out.println(leetCode5767.isCovered(new int[][]{{13, 43}, {19, 20}, {32, 38}, {26, 33}, {3, 38}, {16, 31}, {26, 48}, {27, 43}, {12, 24}}, 36, 45));
//        System.out.println(leetCode5767.isCovered(new int[][]{{1, 1}}, 1, 50));
//        System.out.println(leetCode5767.isCovered(new int[][]{{1, 50}}, 1, 50));
//        System.out.println(leetCode5767.isCovered(new int[][]{{18, 43}, {42, 46}, {19, 30}}, 21, 45));
        System.out.println(leetCode5767.isCovered(new int[][]{{37, 49}, {5, 17}, {8, 32}}, 29, 49));
    }
}
