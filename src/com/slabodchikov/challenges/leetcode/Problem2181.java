package com.slabodchikov.challenges.leetcode;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/merge-nodes-in-between-zeros/">Problem 2181</a>
 */
public class Problem2181 {

    public static void main(String[] args) {
        int[] nums = {0, 3, 1, 0, 4, 5, 2, 0};
        ListNode listNode = ListNode.fromArray(nums);
        System.out.println(mergeNodes(listNode));
    }

    public static ListNode mergeNodes(ListNode head) {
        int currentValue = 0;
        ListNode newHead = new ListNode();
        ListNode currentNode = newHead;
        head = head.next;
        while (head != null) {
            if (head.val != 0) {
                currentValue += head.val;
                head = head.next;
            } else {
                currentNode.val = currentValue;
                currentValue = 0;
                head = head.next;
                if (head != null) {
                    currentNode.next = new ListNode();
                    currentNode = currentNode.next;
                }
            }
        }

        return newHead;
    }
}
