package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            p1 = p1.next;
        } else {
            head = l2;
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
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        LeetCode21 leetcode21 = new LeetCode21();
        ListNode head = leetcode21.mergeTwoLists(l1, l2);
        leetcode21.print(head);
    }

    private void print(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * Definition for singly-linked list.
     */
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
