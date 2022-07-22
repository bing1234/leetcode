package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 翻转链表
        ListNode reverseL1 = reverseList(l1);
        ListNode reverseL2 = reverseList(l2);
        // 两链表相加
        ListNode sumHead = addTwoNums(reverseL1, reverseL2);
        // 翻转链表
        return reverseList(sumHead);
    }

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

    public ListNode addTwoNums(ListNode l1, ListNode l2) {
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

    public static void main(String[] args) {
        LeetCode445 leetCode445 = new LeetCode445();

        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode ans = leetCode445.addTwoNumbers(l1, l2);
        System.out.println(ans);
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
