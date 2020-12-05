package com.geekbing.middle;

public class LeetCode621 {
    public int leastInterval(char[] tasks, int n) {
        int[] bucket = new int[26];
        int maxCount = 0;
        for (char task : tasks) {
            bucket[task - 'A']++;
            maxCount = Math.max(maxCount, bucket[task - 'A']);
        }
        int num = 0;
        for (int count : bucket) {
            if (count == maxCount) {
                num++;
            }
        }
        return Math.max((maxCount - 1) * (n + 1) + num, tasks.length);
    }

    public static void main(String[] args) {
        LeetCode621 leetCode621 = new LeetCode621();
        System.out.println(leetCode621.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println(leetCode621.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0));
        System.out.println(leetCode621.leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));
    }
}
