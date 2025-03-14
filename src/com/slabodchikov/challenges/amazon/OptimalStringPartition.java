package com.slabodchikov.challenges.amazon;

public class OptimalStringPartition {

    public static void main(String[] args) {

        var partitioner = new OptimalStringPartition();
        System.out.println(partitioner.partitionString("hdklqkcssgxlvehva"));
    }

    public int partitionString(String s) {

        int partitions = 1;
        char[] allChars = s.toCharArray();
        int[] currentChars = new int[26];
        for (char ch : allChars) {
            if (currentChars[ch - 'a'] != 0) {
                currentChars = new int[26];
                partitions++;
            }
            currentChars[ch - 'a'] = 1;
        }

        return partitions;
    }
}
