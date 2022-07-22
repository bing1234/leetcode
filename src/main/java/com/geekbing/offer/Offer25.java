package com.geekbing.offer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class Offer25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode idx1 = l1, idx2 = l2, head;
        if (l1.val <= l2.val) {
            head = l1;
            idx1 = idx1.next;
        } else {
            head = l2;
            idx2 = idx2.next;
        }
        ListNode idx = head;
        while (idx1 != null || idx2 != null) {
            if (idx1 == null) {
                idx.next = idx2;
                idx2 = idx2.next;
            } else if (idx2 == null) {
                idx.next = idx1;
                idx1 = idx1.next;
            } else if (idx1.val <= idx2.val) {
                idx.next = idx1;
                idx1 = idx1.next;
            } else {
                idx.next = idx2;
                idx2 = idx2.next;
            }
            idx = idx.next;
        }
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private List<Integer> travel(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode idx = head;
        while (idx != null) {
            list.add(idx.val);
            idx = idx.next;
        }
        return list;
    }

    @Test
    public void testCase1() {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        Offer25 offer25 = new Offer25();
        ListNode head = offer25.mergeTwoLists(head1, head2);

        List<Integer> ans = travel(head);
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 4, 4));
        assert expert.equals(ans);
    }
}
