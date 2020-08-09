package com.geekbing.easy;

/**
 * @author bing
 */
public class LeetCode234 {
    /**
     * 题目思路
     * 1. 快慢指针，找到中节点
     * 2. 翻转后面链表
     * 3. 判断是否是回文链表
     * 4. 恢复链表
     */
    public boolean isPalindrome(ListNode head) {
        // 特殊情况处理
        if (head == null || head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            return head.val == head.next.val;
        }

        // 快慢指针
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 为了保持一致，当节点数为偶数时候，添加一个最后需要删除的元素
        ListNode needDelete = null;
        if (fast.next != null) {
            needDelete = new ListNode(0);
            needDelete.next = slow.next;
            slow.next = needDelete;
            slow = slow.next;
            fast = fast.next;
        }
        // 经过上面的处理后，现在slow指向中间节点、fast指向最后一个节点
        // 从slow开始翻转链表
        reverseList(slow);

        // 判断是否是回文链表
        ListNode index1 = head, index2 = fast;
        while (index1 != null && index2 != null) {
            if (index1.val != index2.val) {
                return false;
            }
            index1 = index1.next;
            index2 = index2.next;
        }

        // 结果
        boolean result = index1 == null && index2 == null;

        // 恢复链表
        reverseList(fast);
        // 删除多余的节点
        if (needDelete != null) {
            needDelete.val = needDelete.next.val;
            needDelete.next = needDelete.next.next;
        }
        return result;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, current = head, next = current.next;
        while (next != null) {
            current.next = pre;
            pre = current;
            current = next;
            next = next.next;
        }
        current.next = pre;
        return current;
    }

    public static void main(String[] args) {
        LeetCode234 leetCode234 = new LeetCode234();

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        System.out.println(leetCode234.isPalindrome(head1));
        print(head1);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(1);
        System.out.println(leetCode234.isPalindrome(head2));
        print(head2);

        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(2);
        head3.next.next.next = new ListNode(2);
        head3.next.next.next.next = new ListNode(1);
        System.out.println(leetCode234.isPalindrome(head3));
        print(head3);
    }

    private static void print(ListNode head) {
        ListNode index = head;
        while (index != null) {
            System.out.println(index.val);
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
