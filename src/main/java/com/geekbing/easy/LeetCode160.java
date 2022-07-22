package com.geekbing.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * @author bing
 */
public class LeetCode160 {
    public ListNode getIntersectionNodeV2(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        ListNode idxA = headA, idxB = headB;
        if (lenA > lenB) {
            idxA = move(idxA, lenA - lenB);
        } else if (lenA < lenB) {
            idxB = move(idxB, lenB - lenA);
        }

        while (idxA != null && idxB != null && idxA != idxB) {
            idxA = idxA.next;
            idxB = idxB.next;
        }
        return idxA;
    }

    private ListNode move(ListNode head, int n) {
        ListNode idx = head;
        for (int i = 0; i < n; i++) {
            idx = idx.next;
        }
        return idx;
    }

    private int getLength(ListNode head) {
        int ans = 0;
        ListNode idx = head;
        while (idx != null) {
            idx = idx.next;
            ans++;
        }
        return ans;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<ListNode> nodesA = travel(headA);
        List<ListNode> nodesB = travel(headB);
        if (nodesA.size() == 0 || nodesB.size() == 0) {
            return null;
        }
        if (nodesA.get(0) != nodesB.get(0)) {
            return null;
        }
        int i = 0;
        while (i < nodesA.size() && i < nodesB.size() && nodesA.get(i) == nodesB.get(i)) {
            i++;
        }
        return nodesA.get(i - 1);
    }

    private List<ListNode> travel(ListNode head) {
        List<ListNode> nodes = new LinkedList<>();
        ListNode idx = head;
        while (idx != null) {
            nodes.add(0, idx);
            idx = idx.next;
        }
        return nodes;
    }

    public static void main(String[] args) {
        LeetCode160 leetCode160 = new LeetCode160();

    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
