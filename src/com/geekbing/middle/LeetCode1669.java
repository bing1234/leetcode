package com.geekbing.middle;

/**
 * @author bing
 */
public class LeetCode1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode beforeA = list1, afterB = list1, end2 = list2;
        while (end2 != null && end2.next != null) {
            end2 = end2.next;
        }
        while (a > 1) {
            beforeA = beforeA.next;
            a--;
        }
        while (b >= 0) {
            afterB = afterB.next;
            b--;
        }
        beforeA.next = list2;
        end2.next = afterB;
        return list1;
    }

    public static void main(String[] args) {
        LeetCode1669 leetCode1669 = new LeetCode1669();

        ListNode head1 = new ListNode(0);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(4);
        head1.next.next.next.next.next = new ListNode(5);
        ListNode head2 = new ListNode(1000000);
        head2.next = new ListNode(1000001);
        head2.next.next = new ListNode(1000002);
        System.out.println(leetCode1669.mergeInBetween(head1, 3, 4, head2));

        ListNode head3 = new ListNode(0);
        head3.next = new ListNode(1);
        head3.next.next = new ListNode(2);
        head3.next.next.next = new ListNode(3);
        head3.next.next.next.next = new ListNode(4);
        head3.next.next.next.next.next = new ListNode(5);
        head3.next.next.next.next.next.next = new ListNode(6);
        ListNode head4 = new ListNode(1000000);
        head4.next = new ListNode(1000001);
        head4.next.next = new ListNode(1000002);
        head4.next.next.next = new ListNode(1000003);
        head4.next.next.next.next = new ListNode(1000004);
        System.out.println(leetCode1669.mergeInBetween(head3, 2, 5, head4));
    }

    private static class ListNode {
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
