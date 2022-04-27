package com.geekbing.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode1474 {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode idx = head, temp;
        while (idx != null) {
            for (int i = 0; i < m - 1; i++) {
                idx = idx.next;
                if (idx == null) {
                    return head;
                }
            }
            temp = idx;
            for (int i = 0; i <= n; i++) {
                if (temp == null) {
                    break;
                }
                temp = temp.next;
            }
            idx.next = temp;
            idx = idx.next;
        }
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode buildWithArr(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode idx = head;
        for (int i = 1; i < arr.length; i++) {
            idx.next = new ListNode(arr[i]);
            idx = idx.next;
        }
        return head;
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
        LeetCode1474 leetCode1474 = new LeetCode1474();
        ListNode head = leetCode1474.deleteNodes(buildWithArr(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}), 2, 3);
        List<Integer> ans = printListNode(head);
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 2, 6, 7, 11, 12));
        assert expert.equals(ans);
    }

    @Test
    public void testCase2() {
        LeetCode1474 leetCode1474 = new LeetCode1474();
        ListNode head = leetCode1474.deleteNodes(buildWithArr(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}), 1, 3);
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 5, 9));
        assert expert.equals(printListNode(head));
    }

    @Test
    public void testCase3() {
        LeetCode1474 leetCode1474 = new LeetCode1474();
        ListNode head = leetCode1474.deleteNodes(buildWithArr(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}), 3, 1);
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6, 7, 9, 10, 11));
        assert expert.equals(printListNode(head));
    }

    @Test
    public void testCase4() {
        LeetCode1474 leetCode1474 = new LeetCode1474();
        ListNode head = leetCode1474.deleteNodes(buildWithArr(new int[]{9, 3, 7, 7, 9, 10, 8, 2}), 1, 2);
        List<Integer> expert = new ArrayList<>(Arrays.asList(9, 7, 8));
        assert expert.equals(printListNode(head));
    }
}
