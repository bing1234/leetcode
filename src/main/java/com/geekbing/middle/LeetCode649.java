package com.geekbing.middle;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode649 {
    public String predictPartyVictory(String senate) {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                queue1.add(i);
            } else {
                queue2.add(i);
            }
        }
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int idx1 = queue1.poll();
            int idx2 = queue2.poll();
            if (idx1 < idx2) {
                queue1.offer(idx1 + senate.length());
            } else {
                queue2.offer(idx2 + senate.length());
            }
        }
        return queue1.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        LeetCode649 leetCode649 = new LeetCode649();
        System.out.println(leetCode649.predictPartyVictory("RD"));
        System.out.println(leetCode649.predictPartyVictory("RDD"));
    }
}
