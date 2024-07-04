package com.slabodchikov.challenges.leetcode;

/**
 * @author Roman Slabodchikov
 */
public class ListNode {

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

    static ListNode fromArray(int[] values) {
        ListNode head = new ListNode();
        ListNode current = head;
        for (int i = 0; i < values.length - 1; i++) {
            current.val = values[i];
            current.next = new ListNode();
            current = current.next;
        }
        current.val = values[values.length - 1];

        return head;
    }

    @Override
    public String toString() {
        if (next == null) {
            return String.valueOf(val);
        }
        return String.join(" ", String.valueOf(val), next.toString());

    }
}
