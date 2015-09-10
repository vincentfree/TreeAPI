package com.vijfhart.casus.tree;

import java.util.Iterator;

public interface TreeIterable<T extends Node<T>> extends Iterable<T> {

    TreeIterator<T> iterator();

    void add(T t);
}
