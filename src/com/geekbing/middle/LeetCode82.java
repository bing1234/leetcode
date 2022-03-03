package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            ListNode idx = head;
            while (idx != null && idx.val == head.val) {
                idx = idx.next;
            }
            return deleteDuplicates(idx);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }

    private static final class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private List<Integer> printListNode(ListNode head) {
        List<Integer> ans = new ArrayList<>();
        ListNode idx = head;
        while (idx != null) {
            ans.add(idx.val);
            idx = idx.next;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode82 leetCode82 = new LeetCode82();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        ListNode newHead = leetCode82.deleteDuplicates(head);

        List<Integer> ans = printListNode(newHead);
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 2, 5));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode82 leetCode82 = new LeetCode82();

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);

        ListNode newHead = leetCode82.deleteDuplicates(head);

        List<Integer> ans = printListNode(newHead);
        List<Integer> expert = new ArrayList<>(Arrays.asList(2, 3));
        assert expert.equals(ans);
    }
}
