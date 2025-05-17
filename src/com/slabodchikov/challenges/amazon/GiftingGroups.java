package com.slabodchikov.challenges.amazon;

import java.util.LinkedList;
import java.util.List;

public class GiftingGroups {

    public static int countGroups(List<String> related) {
        int n = related.size();
        int groupNumber = 0;
        int[] processedPeople = new int[n];

        for (int i = 0; i < n; i++) {
            if (processedPeople[i] == 1) {
                continue;
            }
            groupNumber++;
            // System.out.println(related.get(i));
            LinkedList<Integer> nextRelations = new LinkedList<>();

            char[] relations = related.get(i).toCharArray();
            for (int j = i + 1; j < n; j++) {
                if (processedPeople[j] == 0 && relations[j] == '1') {
                    nextRelations.add(j);
                }
            }
            while (!nextRelations.isEmpty()) {
                int j = nextRelations.removeFirst();
                processedPeople[j] = 1;
                relations = related.get(j).toCharArray();
                for (int k = i + 1; k < n; k++) {
                    if (processedPeople[k] == 0 && relations[k] == '1') {
                        nextRelations.add(k);
                    }
                }

            }

        }

        return groupNumber;
    }
}
