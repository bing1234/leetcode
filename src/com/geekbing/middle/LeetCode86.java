package com.geekbing.middle;

public class LeetCode86 {
    public ListNode partition(ListNode head, int x) {
        // 哑结点
        ListNode leftHead = new ListNode(0), leftIdx = leftHead;
        ListNode rightHead = new ListNode(0), rightIdx = rightHead;
        ListNode idx = head;
        while (idx != null) {
            if (idx.val < x) {
                leftIdx.next = idx;
                leftIdx = leftIdx.next;
            } else {
                rightIdx.next = idx;
                rightIdx = rightIdx.next;
            }
            idx = idx.next;
        }
        leftIdx.next = rightHead.next;
        rightIdx.next = null;
        return leftHead.next;
    }

    public ListNode partitionV2(ListNode head, int x) {
        ListNode leftHead = null, leftEnd = null, rightHead = null, rightEnd = null, idx = head;
        while (idx != null) {
            if (idx.val < x) {
                if (leftHead == null) {
                    leftHead = new ListNode(idx.val);
                    leftEnd = leftHead;
                } else {
                    leftEnd.next = new ListNode(idx.val);
                    leftEnd = leftEnd.next;
                }
            } else {
                if (rightHead == null) {
                    rightHead = new ListNode(idx.val);
                    rightEnd = rightHead;
                } else {
                    rightEnd.next = new ListNode(idx.val);
                    rightEnd = rightEnd.next;
                }
            }
            idx = idx.next;
        }
        if (leftHead != null) {
            leftEnd.next = rightHead;
            return leftHead;
        } else {
            return rightHead;
        }
    }

    public static void main(String[] args) {
        LeetCode86 leetCode86 = new LeetCode86();

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(2);
        ListNode newHead1 = leetCode86.partition(head1, 3);
        leetCode86.print(newHead1);
    }

    private void print(ListNode head) {
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
