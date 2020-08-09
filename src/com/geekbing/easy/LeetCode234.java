package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode234 {
    /**
     * 题目思路
     * 1. 快慢指针，找到中节点
     * 2. 翻转后面链表
     * 3. 判断是否是回文链表
     * 4. 恢复链表
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 最后需要删除的元素
        ListNode needDelete;
        if (fast != null && fast.next != null) {
            needDelete = new ListNode(0);
            needDelete.next = slow.next;
            slow.next = needDelete;
            slow = slow.next;
            fast = fast.next;
        }
        // 现在slow指向中间节点、fast指向最后一个节点




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
