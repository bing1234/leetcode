package com.geekbing.easy;

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

    public static void main(String[] args) {
        LeetCode1290 leetCode1290 = new LeetCode1290();

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(0);
        head1.next.next = new ListNode(1);
        System.out.println(leetCode1290.getDecimalValueV3(head1));

        ListNode head2 = new ListNode(0);
        System.out.println(leetCode1290.getDecimalValueV3(head2));

        ListNode head3 = new ListNode(1);
        System.out.println(leetCode1290.getDecimalValueV3(head3));

        // 1,0,0,1,0,0,1,1,1,0,0,0,0,0,0
        ListNode head4 = new ListNode(1);
        head4.next = new ListNode(0);
        head4.next.next = new ListNode(0);
        head4.next.next.next = new ListNode(1);
        head4.next.next.next.next = new ListNode(0);
        head4.next.next.next.next.next = new ListNode(0);
        head4.next.next.next.next.next.next = new ListNode(1);
        head4.next.next.next.next.next.next.next = new ListNode(1);
        head4.next.next.next.next.next.next.next.next = new ListNode(1);
        head4.next.next.next.next.next.next.next.next.next = new ListNode(0);
        head4.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        head4.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        head4.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        head4.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        head4.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        System.out.println(leetCode1290.getDecimalValueV3(head4));

        ListNode head5 = new ListNode(0);
        head5.next = new ListNode(0);
        System.out.println(leetCode1290.getDecimalValueV3(head5));
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
