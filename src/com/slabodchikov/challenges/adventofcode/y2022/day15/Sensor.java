package com.slabodchikov.challenges.adventofcode.y2022.day15;

/**
 * @author Roman Slabodchikov on 23.12.2022
 */
public class Sensor {

    private final int x;
    private final int y;
    private final int beaconX;
    private final int beaconY;

    private final int beaconDistance;

    public Sensor(int x, int y, int beaconX, int beaconY) {
        this.x = x;
        this.y = y;
        this.beaconX = beaconX;
        this.beaconY = beaconY;
        this.beaconDistance = Math.abs(x - beaconX) + Math.abs(y - beaconY);
    }

    public boolean isPositionCovered(int x, int y) {
        return getDistanceFromPosition(x, y) <= beaconDistance;
    }

    public int getDistanceFromPosition(int x, int y) {
        return Math.abs(this.x - x) + Math.abs(this.y - y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getBeaconX() {
        return beaconX;
    }

    public int getBeaconY() {
        return beaconY;
    }

    public int getBeaconDistance() {
        return beaconDistance;
    }
}
