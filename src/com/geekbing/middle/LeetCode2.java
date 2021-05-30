package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode index1 = l1, index2 = l2, head = null, index = null;
        int carry = 0, current, val1, val2;
        while (index1 != null || index2 != null) {
            val1 = (index1 == null) ? 0 : index1.val;
            val2 = (index2 == null) ? 0 : index2.val;
            current = val1 + val2 + carry;
            if (current > 9) {
                current = current - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            if (head == null) {
                head = new ListNode(current);
                index = head;
            } else {
                index.next = new ListNode(current);
                index = index.next;
            }
            if (index1 != null) {
                index1 = index1.next;
            }
            if (index2 != null) {
                index2 = index2.next;
            }
        }
        if (carry == 1) {
            index.next = new ListNode(1);
        }
        return head;
    }

    private void print(ListNode head) {
        ListNode index = head;
        while (index != null) {
            System.out.println(index.val);
            index = index.next;
        }
    }

    public static void main(String[] args) {
        // 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        LeetCode2 leetCode2 = new LeetCode2();
        ListNode head = leetCode2.addTwoNumbers(l1, l2);
        leetCode2.print(head);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
