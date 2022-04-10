package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];

        // 统计链表节点数
        int count = countListNode(head);
        if (count <= k) {

        } else {

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

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
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
        assert ans[0].equals(buildListNode(new int[]{1}));
        assert ans[1].equals(buildListNode(new int[]{2}));
        assert ans[2].equals(buildListNode(new int[]{3}));
        assert ans[3].equals(buildListNode(new int[]{}));
        assert ans[4].equals(buildListNode(new int[]{}));
    }

    @Test
    public void testCase2() {
        LeetCode725 leetCode725 = new LeetCode725();
        ListNode[] ans = leetCode725.splitListToParts(buildListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), 3);
        assert ans.length == 3;
        assert ans[0].equals(buildListNode(new int[]{1, 2, 3, 4}));
        assert ans[1].equals(buildListNode(new int[]{5, 6, 7}));
        assert ans[2].equals(buildListNode(new int[]{8, 9, 10}));
    }
}
