package com.geekbing.easy;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode5621 {
    public int countStudents(int[] students, int[] sandwiches) {
        if (students == null || students.length == 0) {
            return 0;
        }
        if (sandwiches == null || sandwiches.length == 0) {
            return students.length;
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int student : students) {
            queue.offerLast(student);
        }
        for (int sandwich : sandwiches) {
            int queueSize = queue.size();
            for (int j = 0; j < queueSize; j++) {
                if (queue.isEmpty()) {
                    return 0;
                }
                if (queue.peekFirst() == sandwich) {
                    queue.pollFirst();
                    break;
                } else {
                    queue.offerLast(queue.pollFirst());
                }
            }
            if (queue.size() == queueSize) {
                return queueSize;
            }
        }
        return queue.size();
    }

    public static void main(String[] args) {
        LeetCode5621 leetCode5621 = new LeetCode5621();
        System.out.println(leetCode5621.countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
        System.out.println(leetCode5621.countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
    }
}
