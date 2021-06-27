package com.geekbing.interview;

import java.util.List;

/**
 * @author bing
 */
public class Interview0201 {
    public ListNode removeDuplicateNodes(ListNode head) {
        return null;
    }

    public static void main(String[] args) {
        Interview0201 interview0201 = new Interview0201();

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(2);
        head1.next.next.next.next.next = new ListNode(1);
        System.out.println(interview0201.removeDuplicateNodes(head1));

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(1);
        head2.next.next.next.next = new ListNode(2);
        System.out.println(interview0201.removeDuplicateNodes(head2));
    }

    private static final class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
