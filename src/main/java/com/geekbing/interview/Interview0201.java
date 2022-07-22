package com.geekbing.interview;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author bing
 */
public class Interview0201 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode pre = head, idx = head;
        while (idx != null) {
            while (idx != null && set.contains(idx.val)) {
                idx = idx.next;
            }
            if (idx == null) {
                pre.next = null;
            } else {
                set.add(idx.val);
                pre.next = idx;
                pre = pre.next;
                idx = idx.next;
            }
        }
        return head;
    }

    private static final class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
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

    private List<Integer> travelListNode(ListNode head) {
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
        Interview0201 interview0201 = new Interview0201();
        ListNode head = buildListNode(new int[]{1, 2, 3, 3, 2, 1});
        ListNode newHead = interview0201.removeDuplicateNodes(head);
        List<Integer> ans = travelListNode(newHead);
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 2, 3));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        Interview0201 interview0201 = new Interview0201();
        ListNode head = buildListNode(new int[]{1, 1, 1, 1, 2});
        ListNode newHead = interview0201.removeDuplicateNodes(head);
        List<Integer> ans = travelListNode(newHead);
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 2));
        assert expert.equals(ans);
    }
}
