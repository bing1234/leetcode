package com.geekbing.middle;

public class LeetCode148 {
    public ListNode sortList(ListNode head) {
        return sortListNode(head, null);
    }

    private ListNode sortListNode(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        ListNode mid = slow;
        ListNode list1 = sortListNode(head, mid);
        ListNode list2 = sortListNode(mid, tail);
        return merge(list1, list2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        ListNode p1 = head1;
        ListNode p2 = head2;
        ListNode head;
        if (head1.val < head2.val) {
            head = head1;
            p1 = p1.next;
        } else {
            head = head2;
            p2 = p2.next;
        }

        ListNode p0 = head;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p0.next = p1;
                p1 = p1.next;
            } else {
                p0.next = p2;
                p2 = p2.next;
            }
            p0 = p0.next;
        }
        if (p1 == null) {
            p0.next = p2;
        }
        if (p2 == null) {
            p0.next = p1;
        }
        return head;
    }

    public static void main(String[] args) {
        LeetCode148 leetCode148 = new LeetCode148();

        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(3);
        ListNode newHead1 = leetCode148.sortList(head1);
        leetCode148.printListNode(newHead1);

        ListNode head2 = new ListNode(-1);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(0);
        ListNode newHead2 = leetCode148.sortList(head2);
        leetCode148.printListNode(newHead2);
    }

    private void printListNode(ListNode head) {
        ListNode idx = head;
        while (idx != null) {
            System.out.println(idx.val + " ");
            idx = idx.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
