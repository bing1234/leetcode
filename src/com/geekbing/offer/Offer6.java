package com.geekbing.offer;

/**
 * @author bing
 */
public class Offer6 {
    public int[] reversePrint(ListNode head) {
        // 链表长度
        int count = 0;
        ListNode index = head;
        while (index != null) {
            index = index.next;
            count++;
        }

        int[] result = new int[count];

        index = head;
        for (int i = count - 1; i >= 0; i--) {
            result[i] = index.val;
            index = index.next;
        }
        return result;
    }

    public static void main(String[] args) {
        Offer6 offer6 = new Offer6();

        ListNode head = new ListNode(1);
        //head.next = new ListNode(3);
        //head.next.next = new ListNode(2);

        int[] result = offer6.reversePrint(head);
        for (int num : result) {
            System.out.println(num);
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
