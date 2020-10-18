package com.geekbing.middle;

public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode pre = null, cur = head, fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            pre = cur;
            cur = cur.next;
            fast = fast.next;
        }
        if (pre == null) {
            return cur.next;
        }
        pre.next = cur.next;
        return head;
    }

    public static void main(String[] args) {
        LeetCode19 leetCode19 = new LeetCode19();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        leetCode19.removeNthFromEnd(head, 2);
        leetCode19.printList(head);
    }

    private void printList(ListNode head) {
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
