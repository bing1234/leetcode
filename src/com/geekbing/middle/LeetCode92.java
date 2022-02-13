package com.geekbing.middle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        // 需要交换区间前面、后面一个节点; 需要交换区间的头、尾节点
        ListNode pre, end, subHead, subEnd;
        ListNode idx = head;
        if (left == 1) {
            pre = null;
            subHead = head;
        } else {
            for (int i = 2; i < left; i++) {
                idx = idx.next;
            }
            pre = idx;
            subHead = pre.next;
            idx = idx.next;
        }
        int cnt = left;
        while (cnt != right) {
            idx = idx.next;
            cnt++;
        }
        subEnd = idx;
        end = subEnd.next;

        // 断开区间链表的连接
        if (pre != null) {
            pre.next = null;
        }
        subEnd.next = null;

        // 反转区间链表
        ListNode[] pair = reverseList(subHead);
        // 得到区间链表新的投和尾节点
        ListNode subNewHead = pair[0];
        ListNode subNewEnd = pair[1];

        // 重新连接
        subNewEnd.next = end;
        if (pre == null) {
            return subNewHead;
        }

        pre.next = subNewHead;
        return head;
    }

    private ListNode[] reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return new ListNode[]{head, head};
        }
        ListNode pre = null, current = head, next = current.next;
        while (next != null) {
            current.next = pre;
            pre = current;
            current = next;
            next = next.next;
        }
        current.next = pre;
        return new ListNode[]{current, head};
    }

    private static final class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode buildListNode(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    private List<Integer> travel(ListNode head) {
        List<Integer> ans = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            ans.add(cur.val);
            cur = cur.next;
        }
        return ans;
    }

    @Test
    public void testCase1() {
        LeetCode92 leetCode92 = new LeetCode92();
        ListNode head = buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNode newHead = leetCode92.reverseBetween(head, 2, 4);
        List<Integer> arr = travel(newHead);
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 4, 3, 2, 5));
        assert expert.equals(arr);
    }

    @Test
    public void testCase2() {
        LeetCode92 leetCode92 = new LeetCode92();
        ListNode head = buildListNode(new int[]{5});
        ListNode newHead = leetCode92.reverseBetween(head, 1, 1);
        List<Integer> arr = travel(newHead);
        List<Integer> expert = new ArrayList<>(Collections.singletonList(5));
        assert expert.equals(arr);
    }

    @Test
    public void testCase3() {
        LeetCode92 leetCode92 = new LeetCode92();
        ListNode head = buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNode newHead = leetCode92.reverseBetween(head, 1, 5);
        List<Integer> arr = travel(newHead);
        List<Integer> expert = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
        assert expert.equals(arr);
    }

    @Test
    public void testCase4() {
        LeetCode92 leetCode92 = new LeetCode92();
        ListNode head = buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNode newHead = leetCode92.reverseBetween(head, 2, 5);
        List<Integer> arr = travel(newHead);
        List<Integer> expert = new ArrayList<>(Arrays.asList(1, 5, 4, 3, 2));
        assert expert.equals(arr);
    }
}
