package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        LeetCode237 leetCode237 = new LeetCode237();
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(5);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(9);
        leetCode237.deleteNode(head1.next);

        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(9);
        leetCode237.deleteNode(head2.next.next);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
