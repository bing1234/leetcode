package com.geekbing.middle;

public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next, pre = null, cur = head, next = cur.next;
        while (cur != null && next != null) {
            ListNode temp = next.next;
            if (pre != null) {
                pre.next = next;
            }
            next.next = cur;
            cur.next = temp;

            pre = cur;
            cur = pre.next;
            if (cur != null) {
                next = cur.next;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        LeetCode24 leetCode24 = new LeetCode24();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode newHead = leetCode24.swapPairs(head);
        leetCode24.printList(newHead);
    }

    private void printList(ListNode head) {
        ListNode idx = head;
        while (idx != null) {
            System.out.print(idx.val + " ");
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
