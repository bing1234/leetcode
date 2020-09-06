package com.geekbing.interview;

public class Interview0203 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        // 单向链表1->2->3->4->5->6中的节点3
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Interview0203 interview0203 = new Interview0203();
        interview0203.deleteNode(node3);
        interview0203.printLinkNode(head);
    }

    private void printLinkNode(ListNode head) {
        ListNode index = head;
        while (index != null) {
            System.out.print(index.val);
            index = index.next;
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
