package com.geekbing.middle;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/queries-on-a-permutation-with-key/
 * 1409. 查询带键的排列
 *
 * @author bing
 */
public class LeetCode1409 {
    public int[] processQueries(int[] queries, int m) {
        int[] ans = new int[queries.length];

        Node head = convertLinkList(m);
        Node pre, cur;
        int index;
        for (int i = 0; i < queries.length; i++) {
            pre = head;
            cur = head.next;
            index = 0;
            while (cur != null && cur.val != queries[i]) {
                pre = cur;
                cur = cur.next;
                index++;
            }
            ans[i] = index;

            // 将cur移动到列表前面
            pre.next = cur.next;
            cur.next = head.next;
            head.next = cur;
        }
        return ans;
    }

    private Node convertLinkList(int m) {
        Node head = new Node(-1);
        Node idx = head;
        for (int i = 1; i <= m; i++) {
            idx.next = new Node(i);
            idx = idx.next;
        }
        return head;
    }

    private static class Node {
        private final int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LeetCode1409 leetCode1409 = new LeetCode1409();
        System.out.println(Arrays.toString(leetCode1409.processQueries(new int[]{3, 1, 2, 1}, 5)));
        System.out.println(Arrays.toString(leetCode1409.processQueries(new int[]{4, 1, 2, 2}, 4)));
        System.out.println(Arrays.toString(leetCode1409.processQueries(new int[]{7, 5, 5, 8, 3}, 8)));
    }
}
