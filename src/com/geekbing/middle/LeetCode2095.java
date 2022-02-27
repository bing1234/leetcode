package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode2095 {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null) {
            slow.val = slow.next.val;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode build(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode idx = head;
        for (int i = 1; i < arr.length; i++) {
            idx.next = new ListNode(arr[i]);
            idx = idx.next;
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

    @Test
    public void testCase1() {
        LeetCode2095 leetCode2095 = new LeetCode2095();
        ListNode head = build(new int[]{1, 3, 4, 7, 1, 2, 6});
        ListNode newHead = leetCode2095.deleteMiddle(head);
        List<Integer> ans = travel(newHead);
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 3, 4, 1, 2, 6));
        assert ans.equals(expert);
    }

    @Test
    public void testCase2() {
        LeetCode2095 leetCode2095 = new LeetCode2095();
        ListNode head = build(new int[]{1, 2, 3, 4});
        ListNode newHead = leetCode2095.deleteMiddle(head);
        List<Integer> ans = travel(newHead);
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 2, 4));
        assert ans.equals(expert);
    }

    @Test
    public void testCase3() {
        LeetCode2095 leetCode2095 = new LeetCode2095();
        ListNode head = build(new int[]{2, 1});
        ListNode newHead = leetCode2095.deleteMiddle(head);
        List<Integer> ans = travel(newHead);
        List<Integer> expert = new ArrayList<>(Collections.singletonList(2));
        assert ans.equals(expert);
    }
}
