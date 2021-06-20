package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = head, idx = head;
        while (idx.next != null && idx.val == idx.next.val) {
            idx = idx.next;
        }

        return null;
    }

    public static void main(String[] args) {

    }

    private static final class ListNode {
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
