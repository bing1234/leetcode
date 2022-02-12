package com.geekbing;

/**
 * @author bing
 */
public class LeetCode92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {



        return null;
    }

    public static void main(String[] args) {
        LeetCode92 leetCode92 = new LeetCode92();

        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(4);
        listNode1.next.next.next.next = new ListNode(5);
        System.out.println(leetCode92.reverseBetween(listNode1, 2, 4));

        ListNode listNode2 = new ListNode(5);
        System.out.println(leetCode92.reverseBetween(listNode2, 1, 1));
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
