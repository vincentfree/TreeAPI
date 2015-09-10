package com.vijfhart.casus.tree;

import java.util.*;

public interface Node<T extends Node<T>> extends LevelComparable<T>, Comparable<T> {
    T getParent();

    void setParent(T t);
}
