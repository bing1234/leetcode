package com.geekbing.interview;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class Interview0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int val = l1.val + l2.val;
        ListNode head = new ListNode(val >= 10 ? val - 10 : val);
        int base = val >= 10 ? 1 : 0;
        ListNode idx = head, idx1 = l1.next, idx2 = l2.next;
        while (idx1 != null || idx2 != null) {
            val = (idx1 == null ? 0 : idx1.val) + (idx2 == null ? 0 : idx2.val) + base;
            idx.next = new ListNode(val >= 10 ? val - 10 : val);
            base = val >= 10 ? 1 : 0;

            idx = idx.next;
            idx1 = idx1 == null ? null : idx1.next;
            idx2 = idx2 == null ? null : idx2.next;
        }
        if (base == 1) {
            idx.next = new ListNode(1);
        }
        return head;
    }

    private List<Integer> travel(ListNode head) {
        List<Integer> ans = new ArrayList<>();
        ListNode idx = head;
        while (idx != null) {
            ans.add(idx.val);
            idx = idx.next;
        }
        return ans;
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

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @Test
    public void testCase1() {
        Interview0205 interview0205 = new Interview0205();
        ListNode head = interview0205.addTwoNumbers(buildListNode(new int[]{7, 1, 6}), buildListNode(new int[]{5, 9, 2}));
        List<Integer> ans = travel(head);
        List<Integer> expert = new ArrayList<>(Arrays.asList(2, 1, 9));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        Interview0205 interview0205 = new Interview0205();
        ListNode head = interview0205.addTwoNumbers(buildListNode(new int[]{5}), buildListNode(new int[]{5}));
        List<Integer> ans = travel(head);
        List<Integer> expert = new ArrayList<>(Arrays.asList(0, 1));
        assert expert.equals(ans);
    }
}
