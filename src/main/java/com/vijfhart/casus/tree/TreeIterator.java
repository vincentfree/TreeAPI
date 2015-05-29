package com.vijfhart.casus.tree;

import java.util.Iterator;

/**
 * Created by a591220 on 29-5-2015.
 */
public interface TreeIterator<E extends Node<E>> extends Iterator<E> {
    int level();
    void startWith(E node);
    boolean isLeaf();
}