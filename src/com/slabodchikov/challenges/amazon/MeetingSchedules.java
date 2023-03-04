package com.slabodchikov.challenges.amazon;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author Roman Slabodchikov on 03.11.2022
 */
public class MeetingSchedules {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int peopleCount = sc.nextInt();
        int duration = sc.nextInt();

        int startOffHour;
        int startOffMinute;

        int endOffHour;
        int endOffMinute;

        List<Pair> offSlots = new SortedList<>(new PairComparator());

        for (int i = 0; i < peopleCount; i++) {
            startOffHour = sc.nextInt();
            startOffMinute = sc.nextInt();

            endOffHour = sc.nextInt();
            endOffMinute = sc.nextInt();

            Pair newOffSlot = Pair.of(convertStartTimeToNumber(startOffHour, startOffMinute),
                convertEndTimeToNumber(endOffHour, endOffMinute));
            offSlots.add(newOffSlot);
        }

        for (int i = 0; i < offSlots.size() - 1; i++) {
            if (offSlots.get(i).intersects(offSlots.get(i + 1))) {
                Pair slot1 = offSlots.get(i);
                Pair slot2 = offSlots.get(i + 1);
                Pair newSlot = Pair.groupPairs(slot1, slot2);
                offSlots.remove(slot1);
                offSlots.remove(slot2);
                offSlots.add(newSlot);
                i = 0;
            }
        }

        List<Pair> eventSlots = new ArrayList<>();
        int start = 0;
        int end;

        for (Pair offSlot : offSlots) {
            end = offSlot.left;
            if (end - start >= duration) {
                eventSlots.add(Pair.of(start, end));
            }
            start = offSlot.right;
        }
        if (start < 24 * 60) {
            end = 24 * 60;
            if (end - start >= duration) {
                eventSlots.add(Pair.of(start, end));
            }
        }

        for (Pair eventSlot : eventSlots) {
            System.out.println(String.join(" ", mapToHour(eventSlot.left), mapToMinute(eventSlot.left),
                mapToHour(eventSlot.right), mapToMinute(eventSlot.right)));
        }
    }

    public static String mapToHour(int time) {
        int hourValue = time / 60;
        return hourValue < 10 ? "0" + hourValue : hourValue == 24 ? "00" : String.valueOf(hourValue);
    }

    public static String mapToMinute(int time) {
        int minuteValue = time % 60;
        return minuteValue < 10 ? "0" + minuteValue : String.valueOf(minuteValue);
    }

    public static Integer convertStartTimeToNumber(int hour, int minute) {
        return hour * 60 + minute;
    }

    public static Integer convertEndTimeToNumber(int hour, int minute) {
        if (hour == 0 && minute == 0) {
            hour = 24;
        }
        return hour * 60 + minute;
    }

    public static class Pair {
        private final int left;
        private final int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public static Pair of(int left, int right) {
            return new Pair(left, right);
        }

        public boolean intersects(Pair p2) {
            return (p2.left >= left && p2.right <= right) || (p2.right >= left && p2.right <= right);
        }

        public static Pair groupPairs(Pair p, Pair p2) {
            return Pair.of(Math.min(p.left, p2.left), Math.max(p.right, p2.right));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return left == pair.left && right == pair.right;
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right);
        }
    }

    public static class PairComparator implements Comparator<Pair> {

        @Override
        public int compare(Pair o1, Pair o2) {
            return Integer.compare(o1.left, o2.left);
        }
    }

    public static class SortedList<E> extends AbstractList<E> {

        private final ArrayList<E> internalList = new ArrayList<>();
        private final Comparator<E> comparator;

        public SortedList(Comparator<E> comparator) {
            this.comparator = comparator;
        }

        @Override
        public void add(int position, E e) {
            internalList.add(e);
            internalList.sort(comparator);
        }

        @Override
        public E get(int i) {
            return internalList.get(i);
        }

        @Override
        public int size() {
            return internalList.size();
        }

        @Override
        public E set(int index, E element) {
            E oldValue = internalList.get(index);
            internalList.set(index, element);
            internalList.sort(comparator);

            return oldValue;
        }

        @Override
        public E remove(int index) {
            return internalList.remove(index);
        }
    }
}
