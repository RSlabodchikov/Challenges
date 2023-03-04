package com.slabodchikov.challenges.leetcode.interview;

import java.util.Stack;

/**
 * @author Roman Slabodchikov on 1/26/2023
 * @see <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">Problem 19</a>
 */
public class Problem19 {

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        System.out.println(removeNthFromEnd(head, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stackNodes = new Stack<>();
        ListNode cur = head;
        ListNode prev = head.next;
        while (cur != null) {
            stackNodes.add(cur);
            cur = cur.next;
        }

        if (stackNodes.size() == n) {
            return head.next;
        }

        int i = 0;

        while (i != n) {
            prev = stackNodes.pop();
            cur = stackNodes.peek();
            i++;
        }
        cur.next = prev.next;

        return head;
    }
}
