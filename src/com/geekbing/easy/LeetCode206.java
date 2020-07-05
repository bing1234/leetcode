package com.geekbing.easy;

import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.Stack;

/**
 * todo
 * @author bing
 */
public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        Stack<ListNode> stack = new Stack<>();

        ListNode index = head;
        while (index != null) {
            stack.push(index);
            index = index.next;
        }

        ListNode newHead = stack.pop();
        index = newHead;
        while (!stack.empty()) {
            index.next = stack.pop();
            index = index.next;
        }
        index.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        LeetCode206 leetCode206 = new LeetCode206();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead = leetCode206.reverseList(head);
        print(newHead);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static void print(ListNode head) {
        ListNode index = head;
        while (index != null) {
            System.out.println(index.val);
            index = index.next;
        }
    }
}
