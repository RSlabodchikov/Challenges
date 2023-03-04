package com.slabodchikov.challenges;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Slabodchikov on 2/22/2023
 */
public class SortingUtils {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(4);
        arr.add(5);
        arr.add(3);
        arr.add(6);

        System.out.printf(String.valueOf(indexOf(arr, 3)));
    }

    public static void sortArray(List<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            for (int j = i; j < array.size(); j++) {
                if (array.get(i) > array.get(j)) {
                    array.set(j, array.set(i, array.get(j)));
                }
            }
        }
    }

    public static int indexOf(List<Integer> array, int variable) {


        int begin = 0;
        int end = array.size() - 1;
        int i = (array.size()) / 2;

        while (begin != end) {
            if (array.get(i) == variable) {
                return i;
            }
            if (array.get(i) < variable) {
                begin = i;
                i = (i + end) / 2;
            } else {
                end = i;
                i = (begin + i) / 2;
            }
        }

        return -1;
    }
}
