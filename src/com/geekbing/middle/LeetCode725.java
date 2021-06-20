package com.geekbing.middle;

import java.util.Arrays;

/**
 * @author bing
 */
public class LeetCode725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = countListNode(head);
        int base = count / k;
        int remain = count % k;

        ListNode[] ans = new ListNode[base];


        return ans;
    }

    private int countListNode(ListNode head) {
        int count = 0;
        ListNode idx = head;
        while (idx.next != null) {
            idx = idx.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode725 leetCode725 = new LeetCode725();

        ListNode head = new ListNode(1);
        System.out.println(Arrays.toString(leetCode725.splitListToParts(head, 5)));
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
