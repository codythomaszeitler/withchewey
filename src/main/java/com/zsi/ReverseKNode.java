package com.zsi;

public class ReverseKNode {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = null;
        ListNode prevStartOfGroup = null;

        ListNode iter = head;
        while (iter != null) {
            ListNode kthPlusOne = getNthNode(iter, k + 1);
            ListNode startOfReverse = reverse(iter, k);
            if (startOfReverse == null) {
                if (newHead == null) {
                    return head;
                }
                return newHead;
            }

            if (prevStartOfGroup != null) {
                prevStartOfGroup.next = startOfReverse;
            }

            if (newHead == null) {
                newHead = startOfReverse;
            }

            prevStartOfGroup = getNthNode(startOfReverse, k);
            iter.next = kthPlusOne;
            iter = kthPlusOne;
        }
        return newHead;
    }

    private ListNode reverse(ListNode start, int k) {
        ListNode newHead = null;

        ListNode iter = start;
        for (int i = k; i >= 1; i--) {
            ListNode current = getNthNode(iter, i);
            if (newHead == null) {
                newHead = current;
            }
            if (current == null) {
                return null;
            }

            ListNode prev = getNthNode(iter, i - 1);
            current.next = prev;
        }
        return newHead;
    }

    public ListNode getNthNode(ListNode start, int n) {
        ListNode iter = start;
        for (int i = 1; i < n; i++) {
            if (iter == null) {
                return null;
            }

            iter = iter.next;
        }

        return iter;
    }
}
