package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode206 {
    /**
     * 迭代
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, current = head, next = current.next;
        while (next != null) {
            current.next = pre;
            pre = current;
            current = next;
            next = next.next;
        }
        current.next = pre;
        return current;
    }

    /**
     * 递归
     */
    public ListNode reverseListV2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 翻转剩下节点并返回头结点
        ListNode newHead = reverseListV2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        LeetCode206 leetCode206 = new LeetCode206();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead = leetCode206.reverseList(head);
        print(newHead);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static void print(ListNode head) {
        ListNode index = head;
        while (index != null) {
            System.out.println(index.val);
            index = index.next;
        }
    }
}
