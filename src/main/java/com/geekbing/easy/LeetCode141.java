package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode141 leetCode141 = new LeetCode141();

        ListNode head1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        head1.next = node2;
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = node2;
        System.out.println(leetCode141.hasCycle(head1));

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head2;
        System.out.println(leetCode141.hasCycle(head2));

        ListNode head3 = new ListNode(1);
        System.out.println(leetCode141.hasCycle(head3));
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
