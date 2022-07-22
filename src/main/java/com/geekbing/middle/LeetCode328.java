package com.geekbing.middle;

public class LeetCode328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode secondHead = head.next;
        ListNode firstIdx = head, secondIdx = head.next;
        while (secondIdx != null) {
            if (secondIdx.next == null) {
                break;
            }
            firstIdx.next = secondIdx.next;
            firstIdx = firstIdx.next;
            secondIdx.next = firstIdx.next;
            secondIdx = secondIdx.next;
        }
        firstIdx.next = secondHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        LeetCode328 leetCode328 = new LeetCode328();
        leetCode328.oddEvenList(head);

        System.out.println(head);
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
