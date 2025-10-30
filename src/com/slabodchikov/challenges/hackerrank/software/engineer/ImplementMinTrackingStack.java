package com.slabodchikov.challenges.hackerrank.software.engineer;

import java.util.*;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/min-tracking-stack/problem?isFullScreen=true">Problem</a>
 */
public class ImplementMinTrackingStack {

    public static void main(String[] args) {
        List<String> operations = Arrays.asList(
            "push 0",
            "top"
        );
        System.out.println(processCouponStackOperations(operations));
    }

    /*
     * Complete the 'processCouponStackOperations' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */
    public static List<Integer> processCouponStackOperations(List<String> operations) {
        MinTrackingStack stack = new MinTrackingStack();
        List<Integer> output = new ArrayList<>();
        for (String operation : operations) {
            switch (operation) {
                case "getMin" -> output.add(stack.getMin());
                case "pop" -> stack.pop();
                case "top" -> output.add(stack.top());
                default -> {
                    int value = Integer.parseInt(operation.substring(5));
                    stack.push(value);
                }
            }
        }
        return output;

    }


    public static class MinTrackingStack {
        private final Deque<Integer> minStack;
        private final Deque<Integer> mainStack;

        public MinTrackingStack() {
            this.minStack = new ArrayDeque<>();
            this.mainStack = new ArrayDeque<>();
        }

        public void push(int num) {
            mainStack.addLast(num);
            Integer currentMin = minStack.peekLast();
            if (currentMin == null || (currentMin >= num)) {
                minStack.addLast(num);
            }
        }

        public int getMin() {
            return minStack.getLast();
        }

        public int top() {
            return mainStack.getLast();
        }

        public void pop() {
            int removedNumber = mainStack.removeLast();
            if (minStack.peekLast() != null && minStack.peekLast() == removedNumber) {
                minStack.removeLast();
            }
            if (minStack.isEmpty() && !mainStack.isEmpty()) {
                minStack.push(mainStack.getLast());
            }
        }
    }
}
