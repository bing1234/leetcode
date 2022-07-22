package com.geekbing.middle;

/**
 * https://leetcode-cn.com/problems/insertion-sort-list/submissions/
 *
 * @author bing
 * 147. 对链表进行插入排序
 */
public class LeetCode147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head;
        ListNode pre = head, cur = pre.next;
        while (cur != null) {
            // 先将当前节点从链表中断开
            pre.next = cur.next;

            // 如果当前节点最小
            if (cur.val < newHead.val) {
                cur.next = newHead;
                newHead = cur;
            } else {
                // 从链表中找到待插入的位置
                ListNode preIdx = newHead, idx = preIdx.next;
                while (idx != pre.next && cur.val > idx.val) {
                    preIdx = preIdx.next;
                    idx = idx.next;
                }
                // 插入当前节点
                cur.next = idx;
                preIdx.next = cur;

                if (pre.next == cur) {
                    pre = pre.next;
                }
            }
            cur = pre.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        LeetCode147 leetCode147 = new LeetCode147();

        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(3);
        ListNode newHead1 = leetCode147.insertionSortList(head1);
        leetCode147.printListNode(newHead1);

        ListNode head2 = new ListNode(-1);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(0);
        ListNode newHead2 = leetCode147.insertionSortList(head2);
        leetCode147.printListNode(newHead2);
    }

    private void printListNode(ListNode head) {
        ListNode idx = head;
        while (idx != null) {
            System.out.print(idx.val + " ");
            idx = idx.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
