package com.slabodchikov.challenges.hackerrank.software.engineer;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/reverse-even-indexed-nodes/problem">Problem</a>
 */
public class ReverseEvenIndexedNodes {

    /*
     * Complete the 'extractAndAppendSponsoredNodes' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts INTEGER_SINGLY_LINKED_LIST head as parameter.
     */
    public static SinglyLinkedListNode extractAndAppendSponsoredNodes(SinglyLinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        SinglyLinkedListNode newHead = head.next;
        SinglyLinkedListNode oddHead = head.next;
        SinglyLinkedListNode evenHead = head;
        evenHead.next = null;

        SinglyLinkedListNode current = oddHead.next;
        boolean even = true;
        while (current != null) {
            if (even) {
                oddHead.next = current.next;
                current.next = evenHead;
                evenHead = current;
                current = oddHead.next;
            } else {
                oddHead = oddHead.next;
                current = current.next;
            }
            even = !even;
        }
        oddHead.next = evenHead;
        return newHead;
    }

    public static void main(String[] args) {
        SinglyLinkedListNode head = SinglyLinkedListNode.fromArray(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(extractAndAppendSponsoredNodes(head).toString());
    }

    public static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }

        public static SinglyLinkedListNode fromArray(int[] nums) {
            SinglyLinkedListNode head = new SinglyLinkedListNode(nums[0]);
            SinglyLinkedListNode current = head;
            for (int i = 1; i < nums.length; i++) {
                current.next = new SinglyLinkedListNode(nums[i]);
                current = current.next;
            }
            return head;
        }

        @Override
        public String toString() {
            StringBuilder out = new StringBuilder("[");
            SinglyLinkedListNode current = this;
            while (current != null) {
                out.append(current.data);
                if (current.next != null) {
                    out.append(", ");
                }
                current = current.next;
            }

            out.append("]");
            return out.toString();
        }
    }
}
