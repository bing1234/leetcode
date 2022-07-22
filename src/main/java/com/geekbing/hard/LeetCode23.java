package com.geekbing.hard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode[] ans = mergeLists(lists);
        if (ans == null || ans.length < 1) {
            return null;
        }
        return ans[0];
    }

    private ListNode[] mergeLists(ListNode[] lists) {
        if (lists == null || lists.length <= 1) {
            return lists;
        }
        ListNode[] items = new ListNode[lists.length % 2 == 0 ? lists.length / 2 : lists.length + 1];
        int left = 0, right = lists.length - 1, idx = 0;
        while (left < right) {
            items[idx] = mergeTwoLists(lists[left], lists[right]);
            left++;
            right--;
            idx++;
        }
        if (lists.length % 2 != 0) {
            items[idx] = lists[left];
        }
        return mergeLists(items);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            p1 = p1.next;
        } else {
            head = l2;
            p2 = p2.next;
        }

        ListNode p0 = head;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p0.next = p1;
                p1 = p1.next;
            } else {
                p0.next = p2;
                p2 = p2.next;
            }
            p0 = p0.next;
        }
        if (p1 == null) {
            p0.next = p2;
        }
        if (p2 == null) {
            p0.next = p1;
        }
        return head;
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

    private List<Integer> printListNode(ListNode head) {
        List<Integer> ans = new LinkedList<>();
        ListNode idx = head;
        while (idx != null) {
            ans.add(idx.val);
            idx = idx.next;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode23 leetCode23 = new LeetCode23();
        ListNode head = leetCode23.mergeKLists(new ListNode[]{
                        buildListNode(new int[]{1, 4, 5}),
                        buildListNode(new int[]{1, 3, 4}),
                        buildListNode(new int[]{2, 6})
                }
        );
        List<Integer> ans = printListNode(head);
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 4, 4, 5, 6));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode23 leetCode23 = new LeetCode23();
        ListNode head = leetCode23.mergeKLists(new ListNode[]{});
        List<Integer> ans = printListNode(head);
        assert new ArrayList<>().equals(ans);
    }

    @Test
    public void testCase3() {
        LeetCode23 leetCode23 = new LeetCode23();
        ListNode head = leetCode23.mergeKLists(new ListNode[]{buildListNode(new int[]{})});
        List<Integer> ans = printListNode(head);
        assert new ArrayList<>().equals(ans);
    }
}
