package com.geekbing.middle;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bing
 */
public class LeetCode142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode idx = head;
        while (idx != null) {
            if (set.contains(idx)) {
                return idx;
            } else {
                set.add(idx);
            }
            idx = idx.next;
        }
        return null;
    }

    public ListNode detectCycleV2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            if (slow == fast) {
                // 相遇之后，fast重新从开始节点一次走一步
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        LeetCode142 leetCode142 = new LeetCode142();

        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next;

        ListNode ans1 = leetCode142.detectCycleV2(head1);
        System.out.println(ans1 == null ? "null" : ans1.val);
    }

    private static final class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
