package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode index = head;
        while (index != null && index.next != null) {
            if (index.val == index.next.val) {
                index.next = index.next.next;
            } else {
                index = index.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        LeetCode83 leetCode83 = new LeetCode83();

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);
        System.out.println(leetCode83.deleteDuplicates(head1));

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(3);
        head2.next.next.next.next = new ListNode(3);
        System.out.println(leetCode83.deleteDuplicates(head2));
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
