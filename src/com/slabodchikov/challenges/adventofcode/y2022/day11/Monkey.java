package com.slabodchikov.challenges.adventofcode.y2022.day11;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.function.Function;

/**
 * @author Roman Slabodchikov
 */
public class Monkey {

    private Integer number;
    private LinkedList<BigInteger> items;
    private Function<BigInteger, BigInteger> operation;
    private Function<BigInteger, Integer> test;
    private BigInteger inspectedItems = BigInteger.valueOf(0);

    public Monkey(Integer number, LinkedList<BigInteger> items, Function<BigInteger, BigInteger> operation, Function<BigInteger, Integer> test) {
        this.number = number;
        this.items = items;
        this.operation = operation;
        this.test = test;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LinkedList<BigInteger> getItems() {
        return items;
    }

    public void setItems(LinkedList<BigInteger> items) {
        this.items = items;
    }

    public Function<BigInteger, BigInteger> getOperation() {
        return operation;
    }

    public void setOperation(Function<BigInteger, BigInteger> operation) {
        this.operation = operation;
    }

    public Function<BigInteger, Integer> getTest() {
        return test;
    }

    public void setTest(Function<BigInteger, Integer> test) {
        this.test = test;
    }

    public BigInteger getInspectedItems() {
        return inspectedItems;
    }

    public void incrementInspectedItems() {
        this.inspectedItems = this.inspectedItems.add(BigInteger.ONE);
    }
}
