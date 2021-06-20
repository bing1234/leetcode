package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode1721 {
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode preKNode = head, postKNode = head;
        int i = 1;
        while (i < k) {
            preKNode = preKNode.next;
            i++;
        }

        ListNode fast = preKNode;
        while (fast.next != null) {
            fast = fast.next;
            postKNode = postKNode.next;
        }

        int temp = preKNode.val;
        preKNode.val = postKNode.val;
        postKNode.val = temp;
        return head;
    }

    public static void main(String[] args) {
        LeetCode1721 leetCode1721 = new LeetCode1721();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead = leetCode1721.swapNodes(head, 2);
        System.out.println(newHead);
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
