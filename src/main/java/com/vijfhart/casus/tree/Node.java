package com.vijfhart.casus.tree;

/**
 * Created by Vincent Free on 29-5-2015.
 */
public interface Node <E extends Node<E>> extends Comparable <E>, LevelComparable {

    public E getParent();
    public E setParent(E node);
    boolean isLeaf();
}
