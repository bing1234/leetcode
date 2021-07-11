package com.geekbing.lcs;

import java.util.*;

/**
 * @author bing
 */
public class LcsO2 {
    public int halfQuestions(int[] questions) {
        // 题型 - 次数
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int question : questions) {
            cntMap.put(question, cntMap.getOrDefault(question, 0) + 1);
        }

        // 将次数倒排
        List<Integer> times = new ArrayList<>(cntMap.values());
        times.sort(Comparator.reverseOrder());

        int ans = 0, sum = 0;
        for (int time : times) {
            sum += time;
            ans++;
            if (sum >= questions.length / 2) {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LcsO2 lcsO2 = new LcsO2();

        System.out.println(lcsO2.halfQuestions(new int[]{2, 1, 6, 2}));
        System.out.println(lcsO2.halfQuestions(new int[]{1, 5, 1, 3, 4, 5, 2, 5, 3, 3, 8, 6}));
    }
}
