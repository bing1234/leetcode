package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode2181 {
    public ListNode mergeNodes(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode newHead = head.next;
        int sum = 0;
        // 找到下一个不为0的节点
        ListNode idx = newHead;
        while (idx != null && idx.val != 0) {
            sum += idx.val;
            idx = idx.next;
        }
        newHead.val = sum;
        newHead.next = mergeNodes(idx);
        return newHead;
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
        LeetCode2181 leetCode2181 = new LeetCode2181();
        ListNode head = buildListNode(new int[]{0, 3, 1, 0, 4, 5, 2, 0});
        ListNode newHead = leetCode2181.mergeNodes(head);
        List<Integer> ans = travelListNode(newHead);
        List<Integer> expert = new ArrayList<>(Arrays.asList(4, 11));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode2181 leetCode2181 = new LeetCode2181();
        ListNode head = buildListNode(new int[]{0, 1, 0, 3, 0, 2, 2, 0});
        ListNode newHead = leetCode2181.mergeNodes(head);
        List<Integer> ans = travelListNode(newHead);
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 3, 4));
        assert expert.equals(ans);
    }
}
