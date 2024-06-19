package com.slabodchikov.challenges.adventofcode.y2022.day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Roman Slabodchikov
 */
public class Part1 {

    private static final Pattern numbersPattern = Pattern.compile("\\d+");

    private static BigInteger DIVIDERS_PRODUCT = BigInteger.valueOf(1);

    private static final Map<Integer, Monkey> monkeys = new HashMap<>();
    private static final Integer ROUND_COUNT = 10000;

    public static void main(String[] args) throws FileNotFoundException {
        File inputData = new File("C:\\Users\\Roman\\Documents\\adventofcode\\day11\\input.txt");
        Scanner scanner = new Scanner(inputData);

        while (scanner.hasNext()) {
            Monkey monkey = parseMonkey(scanner);
            monkeys.put(monkey.getNumber(), monkey);
        }
        for (int i = 0; i < ROUND_COUNT; i++) {
            playRound();
        }

        BigInteger maxInspectedItemsProduct = monkeys.values()
            .stream()
            .map(Monkey::getInspectedItems)
            .sorted(Comparator.reverseOrder())
            .limit(2)
            .reduce(BigInteger.ONE, BigInteger::multiply);
        System.out.println(maxInspectedItemsProduct);
    }

    private static void playRound() {
        monkeys.keySet()
            .stream()
            .sorted()
            .forEach(i -> makeTurn(monkeys.get(i)));
    }

    private static void makeTurn(Monkey monkey) {
        while (!monkey.getItems().isEmpty()) {
            BigInteger item = monkey.getItems().pollFirst();
            item = monkey.getOperation().apply(item);
//            item = item.divide(BigInteger.valueOf(3));
            item = item.mod(DIVIDERS_PRODUCT);
            int newMonkeyNumber = monkey.getTest().apply(item);
            monkeys.get(newMonkeyNumber).getItems().addLast(item);
            monkey.incrementInspectedItems();
        }
    }

    private static Monkey parseMonkey(Scanner scanner) {
        Integer monkeyNumber = Integer.parseInt(scanner.nextLine().replaceAll("\\D+", ""));

        Matcher startItemsMatcher = numbersPattern.matcher(scanner.nextLine());
        LinkedList<BigInteger> startItems = new LinkedList<>();
        while (startItemsMatcher.find()) {
            startItems.addLast(BigInteger.valueOf(Integer.parseInt(startItemsMatcher.group())));
        }

        String operatorLine = scanner.nextLine();
        String operator = operatorLine.substring(operatorLine.indexOf("Operation: new = ") + 17);
        String[] operation = operator.split(" ");
        Function<BigInteger, BigInteger> operatorFun = getOperatorFunction(operation);

        int testDivider = Integer.parseInt(scanner.nextLine().replaceAll("\\D+", ""));
        DIVIDERS_PRODUCT = DIVIDERS_PRODUCT.multiply(BigInteger.valueOf(testDivider));
        int successMonkey = Integer.parseInt(scanner.nextLine().replaceAll("\\D+", ""));
        int failureMonkey = Integer.parseInt(scanner.nextLine().replaceAll("\\D+", ""));
        Function<BigInteger, Integer> testFunction = (input) -> input.mod(BigInteger.valueOf(testDivider)).equals(BigInteger.ZERO) ? successMonkey : failureMonkey;

        //read empty line after each monkey
        if (scanner.hasNext()) {
            scanner.nextLine();
        }

        return new Monkey(monkeyNumber, startItems, operatorFun, testFunction);
    }

    private static Function<BigInteger, BigInteger> getOperatorFunction(String[] operation) {
        switch (operation[1]) {
            case "*" -> {
                if ("old".equals(operation[2])) {
                    return (input) -> input.multiply(input);
                }
                return (input) -> input.multiply(BigInteger.valueOf(Integer.parseInt(operation[2])));
            }
            case "+" -> {
                if ("old".equals(operation[2])) {
                    return (input) -> input.add(input);
                }
                return (input) -> input.add(BigInteger.valueOf(Integer.parseInt(operation[2])));
            }
            default -> {
                return null;
            }
        }
    }
}
