package com.geekbing.easy;

/**
 * todo
 *
 * @author bing
 */
public class LeetCode234 {
    public boolean isPalindrome(ListNode head) {

        return true;
    }

    public static void main(String[] args) {
        LeetCode234 leetCode234 = new LeetCode234();

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        System.out.println(leetCode234.isPalindrome(head1));

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(1);
        System.out.println(leetCode234.isPalindrome(head2));
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
