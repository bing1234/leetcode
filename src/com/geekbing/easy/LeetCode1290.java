package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author bing
 */
public class LeetCode1290 {
    public int getDecimalValue(ListNode head) {
        StringBuilder str = new StringBuilder();
        ListNode index = head;

        while (index != null) {
            str.insert(0, index.val);
            index = index.next;
        }

        int value = 0, base = 1;
        for (char c : str.toString().toCharArray()) {
            if (c == '1') {
                value = value + base;
            }
            base = base * 2;
        }
        return value;
    }

    public int getDecimalValueV2(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        ListNode index = head;
        while (index != null) {
            stack.push(index.val);
            index = index.next;
        }

        int value = 0, base = 1;
        while (!stack.empty()) {
            value = value + base * stack.pop();
            base = base * 2;
        }
        return value;
    }

    public int getDecimalValueV3(ListNode head) {
        ListNode index = head;
        int value = 0;
        while (index != null) {
            value = (value << 1) + index.val;
            index = index.next;
        }
        return value;
    }

    private static class ListNode {
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

    @Test
    public void testCase1() {
        LeetCode1290 leetCode1290 = new LeetCode1290();
        ListNode head = buildListNode(new int[]{1, 0, 1});
        assert leetCode1290.getDecimalValue(head) == 5;
    }

    @Test
    public void testCase2() {
        LeetCode1290 leetCode1290 = new LeetCode1290();
        ListNode head = buildListNode(new int[]{0});
        assert leetCode1290.getDecimalValue(head) == 0;
    }

    @Test
    public void testCase3() {
        LeetCode1290 leetCode1290 = new LeetCode1290();
        ListNode head = buildListNode(new int[]{1});
        assert leetCode1290.getDecimalValue(head) == 1;
    }

    @Test
    public void testCase4() {
        LeetCode1290 leetCode1290 = new LeetCode1290();
        ListNode head = buildListNode(new int[]{1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0});
        assert leetCode1290.getDecimalValue(head) == 18880;
    }

    @Test
    public void testCase5() {
        LeetCode1290 leetCode1290 = new LeetCode1290();
        ListNode head = buildListNode(new int[]{0, 0});
        assert leetCode1290.getDecimalValue(head) == 0;
    }
}
