package com.geekbing.easy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode682 {
    public int calPoints(String[] ops) {
        List<Integer> scores = new ArrayList<>();
        for (String op : ops) {
            switch (op) {
                case "C":
                    scores.remove(scores.size() - 1);
                    break;
                case "D":
                    scores.add(scores.get(scores.size() - 1) * 2);
                    break;
                case "+":
                    scores.add(scores.get(scores.size() - 2) + scores.get(scores.size() - 1));
                    break;
                default:
                    scores.add(Integer.parseInt(op));
                    break;
            }
        }
        return scores.stream().reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        LeetCode682 leetCode682 = new LeetCode682();
        System.out.println(leetCode682.calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(leetCode682.calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }
}
