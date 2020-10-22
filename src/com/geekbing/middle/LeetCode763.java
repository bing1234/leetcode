package com.geekbing.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode763 {
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.equals("")) {
            return new ArrayList<>();
        }
        // 记录字符最后出现的位置
        Map<Character, Integer> map = new HashMap<>();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (map.containsKey(S.charAt(i))) {
                continue;
            }
            map.put(S.charAt(i), i);
        }

        int[][] arr = new int[S.length()][2];
        for (int i = 0; i < S.length(); i++) {
            arr[i] = new int[]{i, map.get(S.charAt(i))};
        }

        List<Integer> ans = new ArrayList<>();
        int lastStart = arr[0][0], lastEnd = arr[0][1];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] > lastEnd) {
                ans.add(lastEnd - lastStart + 1);
                lastStart = arr[i][0];
                lastEnd = arr[i][1];
            } else {
                if (arr[i][1] > lastEnd) {
                    lastEnd = arr[i][1];
                }
            }
        }
        ans.add(lastEnd - lastStart + 1);
        return ans;
    }

    public static void main(String[] args) {
        LeetCode763 leetCode763 = new LeetCode763();
        System.out.println(leetCode763.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
