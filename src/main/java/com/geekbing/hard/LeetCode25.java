package com.geekbing.hard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 按照k个一组进行切分
        List<ListNode> items = split(head, k);

        // 每一组进行反转
        List<ListNode> list = new ArrayList<>();
        for (ListNode item : items) {
            if (sizeOfListNode(item) >= k) {
                list.add(reverse(item));
            } else {
                list.add(item);
            }
        }

        // 前一段结尾和后一段开头衔接起来
        for (int i = 1; i < list.size(); i++) {
            // 遍历到前一段的结尾
            ListNode end = endOfListNode(list.get(i - 1));
            end.next = list.get(i);
        }
        return list.get(0);
    }

    private List<ListNode> split(ListNode head, int k) {
        List<ListNode> ans = new ArrayList<>();
        ListNode idx = head;
        while (idx != null) {
            int cnt = 0;
            ListNode item = idx;
            while (idx != null && cnt < k) {
                cnt++;
                if (cnt == k) {
                    ListNode end = idx;
                    idx = idx.next;
                    end.next = null;
                } else {
                    idx = idx.next;
                }
            }
            ans.add(item);
        }
        return ans;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        ListNode end = endOfListNode(newHead);
        end.next = head;
        head.next = null;
        return newHead;
    }

    private ListNode endOfListNode(ListNode head) {
        ListNode idx = head;
        while (idx != null && idx.next != null) {
            idx = idx.next;
        }
        return idx;
    }

    private int sizeOfListNode(ListNode head) {
        int ans = 0;
        ListNode idx = head;
        while (idx != null) {
            idx = idx.next;
            ans++;
        }
        return ans;
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

    @Test
    public void testCase1() {
        LeetCode25 leetCode25 = new LeetCode25();
        ListNode head = leetCode25.buildWithArr(new int[]{1, 2, 3, 4, 5});
        ListNode newHead = leetCode25.reverseKGroup(head, 2);
        ListNode expert = leetCode25.buildWithArr(new int[]{2, 1, 4, 3, 5});
        assert leetCode25.sameListNode(newHead, expert);
    }

    @Test
    public void testCase2() {
        LeetCode25 leetCode25 = new LeetCode25();
        ListNode head = leetCode25.buildWithArr(new int[]{1, 2, 3, 4, 5});
        ListNode newHead = leetCode25.reverseKGroup(head, 3);
        ListNode expert = leetCode25.buildWithArr(new int[]{3, 2, 1, 4, 5});
        assert leetCode25.sameListNode(newHead, expert);
    }

    @Test
    public void testCase3() {
        LeetCode25 leetCode25 = new LeetCode25();
        ListNode head = leetCode25.buildWithArr(new int[]{1, 2, 3, 4});
        ListNode newHead = leetCode25.reverseKGroup(head, 2);
        ListNode expert = leetCode25.buildWithArr(new int[]{2, 1, 4, 3});
        assert leetCode25.sameListNode(newHead, expert);
    }

    @Test
    public void testCase4() {
        LeetCode25 leetCode25 = new LeetCode25();
        ListNode head = leetCode25.buildWithArr(new int[]{1, 2, 3, 4});
        ListNode newHead = leetCode25.reverseKGroup(head, 4);
        ListNode expert = leetCode25.buildWithArr(new int[]{4, 3, 2, 1});
        assert leetCode25.sameListNode(newHead, expert);
    }

    @Test
    public void testCase5() {
        LeetCode25 leetCode25 = new LeetCode25();
        ListNode head = leetCode25.buildWithArr(new int[]{1, 2, 3, 4});
        ListNode newHead = leetCode25.reverseKGroup(head, 5);
        ListNode expert = leetCode25.buildWithArr(new int[]{1, 2, 3, 4});
        assert leetCode25.sameListNode(newHead, expert);
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

    private boolean sameListNode(ListNode head1, ListNode head2) {
        if ((head1 != null && head2 == null) || (head1 == null && head2 != null)) {
            return false;
        } else {
            ListNode idx1 = head1;
            ListNode idx2 = head2;
            while (idx1 != null && idx2 != null) {
                if (idx1.val != idx2.val) {
                    return false;
                }
                idx1 = idx1.next;
                idx2 = idx2.next;
            }
            return idx1 == null && idx2 == null;
        }
    }

    private void printListNode(ListNode head) {
        ListNode idx = head;
        while (idx != null) {
            System.out.print(idx.val + " ");
            idx = idx.next;
        }
        System.out.println();
    }
}
