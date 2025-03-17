package com.slabodchikov.challenges.leetcode.utils;

import java.util.Objects;

public class Pair<L, R> {

    protected final L left;
    protected final R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<L, R> pair = (Pair<L, R>) o;
        return left == pair.left && right == pair.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
