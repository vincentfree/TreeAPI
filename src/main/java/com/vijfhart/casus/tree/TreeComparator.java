package com.vijfhart.casus.tree;

import java.util.*;

public class TreeComparator<T extends Node<T>> implements Comparator<T> {

    private Comparator<T> orderSiblingsBy;

    public void orderSiblingsBy(Comparator<T> comparator) {
        orderSiblingsBy = comparator;
    }

    public int compare(T first, T other) {
        if (first.getParent() == null) return -1;
        if (other.getParent() == null) return 1;
        if (first.compareLevelTo(other) > 0) {
            if (first.getParent().equals(other)) return 1;
            return compare(first.getParent(), other);
        }
        if (first.compareLevelTo(other) < 0) {
            if (first.equals(other.getParent())) return -1;
            return compare(first, other.getParent());
        }
        if (first.getParent().equals(other.getParent()) && orderSiblingsBy != null) {
            return orderSiblingsBy.compare(first, other);
        }
        return compare(first.getParent(), other.getParent());
    }

}
