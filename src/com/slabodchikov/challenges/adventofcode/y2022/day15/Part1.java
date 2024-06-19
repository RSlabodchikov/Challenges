package com.slabodchikov.challenges.adventofcode.y2022.day15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Roman Slabodchikov
 */
public class Part1 {

    private static final Pattern numbersPattern = Pattern.compile("\\d+");

    private static final Integer DISTRESS_ROW = 2000000;

    public static void main(String[] args) throws FileNotFoundException {
        File inputData = new File("C:\\Users\\Roman\\Documents\\adventofcode\\day15\\input.txt");
        Scanner scanner = new Scanner(inputData);
        Set<Integer> coveredPositions = new HashSet<>();
        Set<Integer> beaconCoveredPositions = new HashSet<>();

        while (scanner.hasNext()) {
            Matcher startItemsMatcher = numbersPattern.matcher(scanner.nextLine());
            List<Integer> coordinates = new ArrayList<>();
            while (startItemsMatcher.find()) {
                coordinates.add(Integer.parseInt(startItemsMatcher.group()));
            }
            int sensorRow = coordinates.get(1);
            int sensorColumn = coordinates.get(0);
            int distanceFromBeacon = Math.abs(sensorColumn - coordinates.get(2)) + Math.abs(sensorRow - coordinates.get(3));
            int distanceFromSensorToRow = Math.abs(sensorRow - DISTRESS_ROW);
            if (coordinates.get(3).equals(DISTRESS_ROW)) {
                beaconCoveredPositions.add(coordinates.get(3));
            }
            if (distanceFromBeacon >= distanceFromSensorToRow) {
                coveredPositions.add(sensorColumn);
                int diff = distanceFromBeacon - distanceFromSensorToRow;
                while (diff > 0) {
                    coveredPositions.add(sensorColumn + diff);
                    coveredPositions.add(sensorColumn - diff);
                    diff--;
                }
            }
        }
        coveredPositions.removeIf(beaconCoveredPositions::contains);
        System.out.println(coveredPositions.size());
    }
}
