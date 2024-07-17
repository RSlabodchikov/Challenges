package com.slabodchikov.challenges.leetcode;


/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/reverse-linked-list/">Problem 206</a>
 */
public class Problem206 {

    public static void main(String[] args) {
        int[] originalVals = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ListNode original = ListNode.fromArray(originalVals);
        System.out.println(reverseList(original));
    }

    public static ListNode reverseList(ListNode head) {
        ListNode reversedHead = null;
        ListNode cur = head;
        while (cur != null) {
            reversedHead = new ListNode(cur.val, reversedHead);
            cur = cur.next;
        }

        return reversedHead;
    }
}
