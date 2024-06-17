package com.slabodchikov.challenges.leetcode;

/**
 * @author Roman Slabodchikov on 1/24/2023
 * @see <a href="https://leetcode.com/problems/add-two-numbers/">Problem</a>
 */
public class Problem2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Head = l1;
        ListNode l1Prev = l1;

        int nextR = 0;

        while (l2 != null && l1 != null) {
            l1.val = l1.val + l2.val + nextR;
            nextR = l1.val / 10;
            l1.val %= 10;

            l1Prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (nextR == 0) {
            if (l2 != null) {
                l1Prev.next = l2;
            }
        } else if (l1 == null && l2 == null) {
            l1Prev.next = new ListNode(nextR);
        } else if (l1 != null) {
            while (nextR != 0 && l1 != null) {
                l1.val = l1.val + nextR;
                nextR = l1.val / 10;
                l1.val %= 10;

                l1Prev = l1;
                l1 = l1.next;
            }
            if (nextR != 0) {
                l1Prev.next = new ListNode(nextR);
            }
        } else {
            l1Prev.next = l2;
            while (nextR != 0 && l2 != null) {
                l2.val = l2.val + nextR;
                nextR = l2.val / 10;
                l2.val %= 10;

                l1Prev = l2;
                l2 = l2.next;
            }
            if (nextR != 0) {
                l1Prev.next = new ListNode(nextR);
            }
        }

        return l1Head;
    }
}
