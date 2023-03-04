package com.slabodchikov.challenges.adventofcode.y2022.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Roman Slabodchikov on 15.12.2022
 */
public class Part1 {

    public static void main(String[] args) throws FileNotFoundException {
        File inputData = new File("C:\\Users\\Roman\\Documents\\adventofcode\\day6\\input.txt");
        Scanner scanner = new Scanner(inputData);

        String inputLine = scanner.nextLine();
        System.out.println(getSymbolCountForStartMarker(inputLine, 4) + 1);
        System.out.println(getSymbolCountForStartMarker(inputLine, 14) + 1);
    }

    public static int getSymbolCountForStartMarker(String inputLine, int markerLength) {
        LinkedList<Character> startMarker = new LinkedList<>();
        for (int i = 0; i < inputLine.length(); i++) {
            if (startMarker.size() == markerLength) {
                startMarker.removeFirst();
            }
            startMarker.add(inputLine.charAt(i));
            if (startMarker.stream().distinct().count() == markerLength) {
                return i;
            }
            
        }
        return 0;
    }
}
