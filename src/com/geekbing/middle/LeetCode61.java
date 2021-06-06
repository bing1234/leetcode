package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        // 统计链表的长度
        int len = countListNodeLen(head);
        if (k % len == 0) {
            return head;
        }
        k = k % len;
        int move = len - k - 1;
        ListNode idx = head;
        while (move > 0) {
            idx = idx.next;
            move--;
        }

        ListNode newHead = idx.next;
        idx.next = null;

        ListNode end = newHead;
        while (end.next != null) {
            end = end.next;
        }
        end.next = head;
        return newHead;
    }

    private int countListNodeLen(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode idx = head;
        int ans = 1;
        while (idx.next != null) {
            ans++;
            idx = idx.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode61 leetCode61 = new LeetCode61();

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        System.out.println(leetCode61.rotateRight(head1, 2));

        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);
        System.out.println(leetCode61.rotateRight(head2, 4));
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
