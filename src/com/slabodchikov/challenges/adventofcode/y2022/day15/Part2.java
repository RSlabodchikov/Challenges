package com.slabodchikov.challenges.adventofcode.y2022.day15;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Roman Slabodchikov
 */
public class Part2 {

    private static final Pattern numbersPattern = Pattern.compile("(-?[0-9]+)");

    private static final Integer MIN_COORDINATE = 0;
    private static final Integer MAX_COORDINATE = 4000000;

    public static void main(String[] args) throws FileNotFoundException {
        File inputData = new File("C:\\Users\\Roman\\Documents\\adventofcode\\day15\\input.txt");
        Scanner scanner = new Scanner(inputData);

        List<Sensor> sensors = new ArrayList<>();

        while (scanner.hasNext()) {
            Matcher startItemsMatcher = numbersPattern.matcher(scanner.nextLine());
            List<Integer> coordinates = new ArrayList<>();
            while (startItemsMatcher.find()) {
                coordinates.add(Integer.parseInt(startItemsMatcher.group()));
            }
            int sensorColumn = coordinates.get(0);
            int sensorRow = coordinates.get(1);

            int beaconColumn = coordinates.get(2);
            int beaconRow = coordinates.get(3);

            sensors.add(new Sensor(sensorColumn, sensorRow, beaconColumn, beaconRow));
        }

        sensors.forEach(sensor -> {
            int j = sensor.getY();
            for (int i = sensor.getX() - sensor.getBeaconDistance() - 1; i <= sensor.getX() + sensor.getBeaconDistance() + 1; i++) {
                if (i < MIN_COORDINATE || i > MAX_COORDINATE || j < MIN_COORDINATE || j > MAX_COORDINATE) {
                    if (j < sensor.getY() + sensor.getBeaconDistance()) {
                        j++;
                    } else {
                        j--;
                    }
                    continue;
                }
                int finalI = i;
                int finalJ = j;
                boolean coveredPos = sensors.stream().anyMatch(s -> s.isPositionCovered(finalI, finalJ));

                if (!coveredPos) {
                    System.out.println(BigInteger.valueOf(i).multiply(BigInteger.valueOf(4000000)).add(BigInteger.valueOf(j)));
                }
                if (j < sensor.getY() + sensor.getBeaconDistance()) {
                    j++;
                } else {
                    j--;
                }
            }
            j = sensor.getY();
            for (int i = sensor.getX() - sensor.getBeaconDistance() - 1; i <= sensor.getX() + sensor.getBeaconDistance() + 1; i++) {
                if (i < MIN_COORDINATE || i > MAX_COORDINATE || j < MIN_COORDINATE || j > MAX_COORDINATE) {
                    if (j > sensor.getY() - sensor.getBeaconDistance()) {
                        j--;
                    } else {
                        j++;
                    }
                    continue;
                }
                int finalI = i;
                int finalJ = j;
                boolean coveredPos = sensors.stream().anyMatch(s -> s.isPositionCovered(finalI, finalJ));

                if (!coveredPos) {
                    System.out.println(i * 4000000 + j);
                }
                if (j > sensor.getY() - sensor.getBeaconDistance()) {
                    j--;
                } else {
                    j++;
                }
            }
        });
//        for (int i = MIN_COORDINATE; i <= MAX_COORDINATE; i++) {
//            for (int j = MIN_COORDINATE; j <= MAX_COORDINATE; j++) {
//                int finalJ = j;
//                int finalI = i;
//                boolean coveredPos = sensors.stream().anyMatch(s -> s.isPositionCovered(finalI, finalJ));
//
//                if (!coveredPos) {
//                    k++;
//                    System.out.println(i + " " + j);
//                }
//
//            }
//        }
//        System.out.println(k);
    }
}
