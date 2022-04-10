package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        // 特殊情况处理
        if (k == 1) {
            return new ListNode[]{head};
        }

        // 统计链表节点数
        int count = countListNode(head);
        if (count <= k) {
            // 每段节点数为1，且不够的为空链表
            return splitListToSingle(head, k);
        }

        // 每段长度数组
        int[] lens = new int[k];
        Arrays.fill(lens, count / k);
        for (int i = 0; i < count % k; i++) {
            lens[i]++;
        }

        ListNode[] ans = new ListNode[k];
        int index = 0;
        ListNode idx = head, pre = head;
        for (int i = 0; i < k; i++) {
            ans[index] = idx;
            for (int j = 0; j < lens[i]; j++) {
                pre = idx;
                idx = idx.next;
            }
            pre.next = null;
            index++;
        }
        return ans;
    }

    private ListNode[] splitListToSingle(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int i = 0;
        ListNode idx = head;
        while (idx != null) {
            ans[i] = idx;
            idx = idx.next;
            ans[i].next = null;
            i++;
        }
        return ans;
    }

    private int countListNode(ListNode head) {
        int count = 0;
        ListNode idx = head;
        while (idx != null) {
            count++;
            idx = idx.next;
        }
        return count;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode buildListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode idx = head;
        for (int i = 1; i < arr.length; i++) {
            idx.next = new ListNode(arr[i]);
            idx = idx.next;
        }
        return head;
    }

    private boolean equalListNode(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return true;
        } else if (head1 == null || head2 == null) {
            return false;
        } else {
            ListNode idx1 = head1, idx2 = head2;
            while (idx1 != null && idx2 != null) {
                if (idx1.val != idx2.val) {
                    return false;
                }
                idx1 = idx1.next;
                idx2 = idx2.next;
            }
            return idx1 == null && idx2 == null;
        }
    }

    @Test
    public void testCase1() {
        LeetCode725 leetCode725 = new LeetCode725();
        ListNode[] ans = leetCode725.splitListToParts(buildListNode(new int[]{1, 2, 3}), 5);
        assert ans.length == 5;
        assert equalListNode(ans[0], buildListNode(new int[]{1}));
        assert equalListNode(ans[1], buildListNode(new int[]{2}));
        assert equalListNode(ans[2], buildListNode(new int[]{3}));
        assert equalListNode(ans[3], buildListNode(new int[]{}));
        assert equalListNode(ans[4], buildListNode(new int[]{}));
    }

    @Test
    public void testCase2() {
        LeetCode725 leetCode725 = new LeetCode725();
        ListNode[] ans = leetCode725.splitListToParts(buildListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), 3);
        assert ans.length == 3;
        assert equalListNode(ans[0], buildListNode(new int[]{1, 2, 3, 4}));
        assert equalListNode(ans[1], buildListNode(new int[]{5, 6, 7}));
        assert equalListNode(ans[2], buildListNode(new int[]{8, 9, 10}));
    }

    @Test
    public void testCase3() {
        LeetCode725 leetCode725 = new LeetCode725();
        ListNode[] ans = leetCode725.splitListToParts(buildListNode(new int[]{0, 1, 2, 3, 4}), 3);
        assert ans.length == 3;
        assert equalListNode(ans[0], buildListNode(new int[]{0, 1}));
        assert equalListNode(ans[1], buildListNode(new int[]{2, 3}));
        assert equalListNode(ans[2], buildListNode(new int[]{4}));
    }
}
