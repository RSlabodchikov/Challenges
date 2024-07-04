package com.slabodchikov.challenges.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Roman Slabodchikov
 * @see <a href="https://leetcode.com/problems/asteroid-collision/">Problem 735</a>
 */
public class Problem735 {

    public static void main(String[] args) {
        int[] asteroids = {5,10,-5};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (stack.isEmpty()) {
                stack.push(asteroid);
            } else {
                while (true) {
                    int prevAsteroid = stack.peek();
                    if (prevAsteroid > 0 && asteroid < 0) {
                        if (prevAsteroid > (-asteroid)) {
                            break;
                        } else if (prevAsteroid < (-asteroid)) {
                            stack.pop();
                            if (stack.isEmpty()) {
                                stack.push(asteroid);
                                break;
                            }
                        } else {
                            stack.pop();
                            break;
                        }
                    } else {
                        stack.push(asteroid);
                        break;
                    }
                }
            }
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
