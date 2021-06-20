package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        return null;
    }

    public static void main(String[] args) {
        LeetCode1171 leetCode1171 = new LeetCode1171();

        ListNode head = new ListNode(1);
        ListNode newHead = leetCode1171.removeZeroSumSublists(head);
        System.out.println(newHead);
    }

    private static final class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
