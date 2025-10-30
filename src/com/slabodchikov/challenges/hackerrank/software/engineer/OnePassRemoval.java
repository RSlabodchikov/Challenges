package com.slabodchikov.challenges.hackerrank.software.engineer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/one-pass-removal-kth-from-end/problem">Problem</a>
 */
public class OnePassRemoval {

    /*
     * Complete the 'removeKthNodeFromEnd' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts following parameters:
     *  1. INTEGER_SINGLY_LINKED_LIST head
     *  2. INTEGER k
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    public static SinglyLinkedListNode removeKthNodeFromEnd(SinglyLinkedListNode head, int k) {
        if (head.next == null && k == 0) {
            return null;
        }
        List<SinglyLinkedListNode> singlyLinkedListNodes = new ArrayList<>();
        while (head != null) {
            singlyLinkedListNodes.add(head);
            head = head.next;
        }
        int n = singlyLinkedListNodes.size() - 1;
        int deleteIndex = n - k;
        if (deleteIndex < 0) {
            return singlyLinkedListNodes.get(0);
        }
        if (deleteIndex == 0) {
            return singlyLinkedListNodes.get(1);
        } else {
            SinglyLinkedListNode preDeleteElement = singlyLinkedListNodes.get(deleteIndex - 1);
            preDeleteElement.next = singlyLinkedListNodes.get(deleteIndex).next;
            return singlyLinkedListNodes.get(0);
        }
    }
}
