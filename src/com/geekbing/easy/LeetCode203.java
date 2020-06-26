package com.geekbing.easy;

/**
 * TODO
 *
 * @author bing
 */
public class LeetCode203 {
    public ListNode removeElements(ListNode head, int val) {
        // 去除头部相等的
        ListNode current = head;
        while (current != null && current.val == val) {
            current = current.next;
        }
        if (current == null) {
            return null;
        }

        ListNode newHead = current;
        ListNode pre = current;
        current = current.next;
        while (current != null) {
            if (current.val == val) {
                pre.next = current.next;
            } else {
                pre = pre.next;
            }
            current = current.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        LeetCode203 leetCode203 = new LeetCode203();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        ListNode root = leetCode203.removeElements(head, 1);
        leetCode203.print(root);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private void print(ListNode head) {
        ListNode newHead = head;
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
